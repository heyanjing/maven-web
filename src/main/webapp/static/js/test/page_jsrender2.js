/**
 * ajax全局设置
 */
$.ajaxSetup({
	type : 'post',
	cache : false,
	dataType : 'json',
	timeout : 60000
});
/**
 * jsrender设置允许使用外部变量
 */
$.views.tags({// 自定义标签显示数据序号
	index : function(index) {
		return (He.Test.pageNumber-1) * He.Test.pageSize + (index + 1);
	}
});
/**
 * 定义类的名称空间
 */
R.ns('He.Test', {
	pageSize : 2,
	pageOpts : {
		totalData : 0, // 数据总条数
		showData : 0, // 每页显示的条数
		pageCount : 10000, // 总页数,默认为9
		current : 1, // 当前第几页
		prevCls : 'prev', // 上一页class
		nextCls : 'next', // 下一页class
		prevContent : '上页', // 上一页内容
		nextContent : '下页', // 下一页内容
		activeCls : 'active', // 当前页选中状态
		coping : true, // 首页和尾页
		isHide : false, // 当前页数为0页或者1页时不显示分页
		homePage : '首页', // 首页节点内容
		endPage : '尾页', // 尾页节点内容
		keepShowPN : false, // 是否一直显示上一页下一页
		count : 3, // 当前页前后分页个数
		jump : true, // 跳转到指定页数
		jumpIptCls : 'jump-ipt', // 文本框内容
		jumpBtnCls : 'jump-btn', // 跳转按钮
		jumpBtn : '跳转', // 跳转按钮文本
		callback : function() {
		} // 回调
	},
	load : function(api) {
		var me = He.Test;
		$.ajax({
			url : CTX + '/person/pageByName',
			data : {
				pageNumber : api.getCurrent(),
				pageSize : me.pageSize
			},
			success : function(result) {
//				App.log(result);
				api.setPageCount(result.totalPages);
				me['pageNumber'] = api.getCurrent();
				me.render(result.content);
			},
			error : function() {
				App.log('error');
			}
		});
	},
	render : function(data) {
		var tmpl = $.templates("#myTemplate");
		var html = tmpl.render(data);
		$('#content').html(html);
	},
	init : function() {
		var me = He.Test, opts = {
			callback : function(api) {
				me.load(api);
			}
		};
		opts = R.applyIf(opts, me.pageOpts);
		$.ajax({
			url : CTX + '/person/pageByName',
			data : {
				pageNumber : 1,
				pageSize : me.pageSize
			},
			success : function(result) {
//				App.log(result);
				opts.pageCount=result.totalPages;
				me['pageNumber'] = result.number+1;
				me.render(result.content);
				$('.M-box').pagination(opts);//样式必须为M-box
			},
			error : function(xhr) {
				App.log('error');
				App.log(xhr);
			}
		});
	}
});
