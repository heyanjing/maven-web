
/**
 * ajax全局设置
 */
$.ajaxSetup({
    type : 'post',
    cache : false,
    dataType : 'json',
    timeout : 60
});

/**
 * jsrender设置允许使用外部变量
 */
$.views.tags({//自定义标签显示数据序号
      index: function(index) {
       return  (He.Test.pageNumber-1)*He.Test.cfg.pageSize+(index+1);
      }
});
var param1='name1',i=0;
/**
 * 定义类的名称空间
 */
R.ns('He.Test', {
    pageNumber:1,
    cfg : {
        dataSource : CTX + '/person/pageByName',
        pageSize : 2,
        beforePaging : function(pageNumber) {
            var me=He.Test;
            console.log('beforePaging');
            me.pageNumber=pageNumber;
        },
        callback : function(data, pagination) {
            var me = He.Test;
            console.log('callback');
            me.render(data);
        },
        formatResult : function(data) {
        },
        ajax : {//全局定义无效只能在配置里面定义,只支持提供的几个参数
            type : 'post',
            cache : false,
            data : {
            },
            beforeSend : function() {
            }
        }   
    },
    render : function(data) {
    	var tmpl = $.templates("#myTemplate");
    	var html = tmpl.render(data);
    	$('#content').html(html);
    },
    init : function() {
        var me = He.Test;
        //给查询添加点击事件(只执行一次);每次初始化只能让按钮执行一次点击，不然点击会指数增长
        $('#search').one({
        	click:function(){
        		me.cfg.ajax.data.name=i++;
//        		$(this).off('click');//当使用on时，需要将点击事件取消，不然点击会指数增长
        		me.init();
        	}
    	});
        var data = {
    		pageNumber : 1,
            pageSize : me.cfg.pageSize
        };
        data = R.applyIf(data, me.cfg.ajax.data);
        $.ajax({
            url : me.cfg.dataSource,
            data : data,
            success : function(result) {
                me.cfg.totalNumber = result.totalElements;
                me.render(result.content);
                $('#page').pagination(me.cfg);
            }
        });

    }
});
