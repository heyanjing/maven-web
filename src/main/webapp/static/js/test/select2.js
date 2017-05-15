$(function() {
	var data = [ {
		id : 0,
		text : 'enhancement'
	}, {
		id : 1,
		text : 'bug'
	}, {
		id : 2,
		text : 'duplicate'
	}, {
		id : 3,
		text : 'invalid'
	}, {
		id : 4,
		text : 'wontfix'
	} ];
	$(".select2").select2({
		multiple : true,
		maximumSelectionLength : 4,
		language : 'zh-CN',// 转为中文版
		allowClear : true,
		placeholder : "提示",
		 tag : true,//可以直接输入值
		width : 200,
		ajax : {
			url : CTX + "/person/pageByName",
			dataType : 'json',
			delay : 500,
			data : function(params) {
				var selectedIds=$(".select2").val();
				if(selectedIds){
					selectedIds=selectedIds.join(',');
				}
				return {
					name : params.term,
					selectedIds :selectedIds,//查询数据不包含已选择的数据
					pageNumber : params.page
				};
			},
			processResults : function(data, params) {
				params.page = params.page || 1;
				return {
					results : $.map(data.content, function(v) {
						return {
							id : v.id,
							text : v.name
						}
					}),// data.content,
					pagination : {
						// totalElements是后台接口返回总数的字段
						// params.page * 每页的数据20条，当结果小于总数，用户向下滑的时候，请求下一页的数据
						more : (params.page * 20) < data.totalElements
					}
				};
			},
			cache : false
		},
		minimumInputLength : 1,
		templateResult : function(repo) {// 渲染下拉显示数据
			return repo.name || repo.text
		},
		templateSelection : function(repo) {// 渲染选中后的显示内容
			return repo.name || repo.text
		}
	});
	$(".select3").select2({
		width : 200,
		language : 'zh-CN',
		multiple : true,
		maximumSelectionLength : 2,
		placeholder : "提示",
		allowClear : true,
		ajax : {
			url : CTX + '/person/findAll',
			dataType : 'json',
			delay : 500,
			data : function(params) {
				return {
					param : params.term
				}
			},
			processResults : function(data, params) {
				return {
					results : data
				}
			},
			cache : true
		},
		minimumInputLength : 1,
		templateResult : function(item) {
			return '<span style="color:green">' + item.name + '</span><span style="font-size:8px">: ' + item.name + '</span>'
		},
		templateSelection : function(item) {
			return item.name
		},
		escapeMarkup : function(markup) {
			return markup;
		}
	});
	$(".select1").select2({
		multiple : true,
		maximumSelectionLength : 2,
		width : 200,
		data : data,
		placeholder : '请选择',
		allowClear : true

	});
	$('#btn1').on('click', function() {
		App.log($(".select1").val());
	});
	$('#btn2').on('click', function() {
		App.log($(".select2").val());
	});
	$('#btn3').on('click', function() {
		App.log($(".select3").val());
	});

});