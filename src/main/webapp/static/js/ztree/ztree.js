var zTreeObj;
// zTree 的参数配置，深入使用请参考 API 文档（setting 配置详解）
function setFontCss(treeId, treeNode) {
	return treeNode.level == 0 ? {
		color : "red"
	} : {};
};
var setting = {
	treeId : "",// tree
	treeObj : null,
	view : {
		addDiyDom : null,
		autoCancelSelected : true,
		dblClickExpand : true,
		expandSpeed : "fast",
		fontCss : setFontCss,// {},
		nameIsHTML : false,
		selectedMulti : true,
		showIcon : true,
		showLine : false,
		showTitle : true,
		txtSelectedEnable : false
	},
	data : {
		key : {
			children : "children",
			name : "name",
			title : "",
			url : "url",
			icon : "icon"
		},
		simpleData : {
			enable : false,
			idKey : "id",
			pIdKey : "pId",
			rootPId : null
		},
		keep : {
			parent : false,
			leaf : false
		}
	},
	async : {
		enable : true,
		contentType : "application/x-www-form-urlencoded",
		type : "post",
		dataType : "text",
		url : "",
		autoParam : [],
		otherParam : [],
		dataFilter : null
	},
	callback : {
		beforeAsync : null,
		beforeClick : null,
		beforeDblClick : null,
		beforeRightClick : null,
		beforeMouseDown : null,
		beforeMouseUp : null,
		beforeExpand : null,
		beforeCollapse : null,
		beforeRemove : null,
		onAsyncError : null,
		onAsyncSuccess : null,
		onNodeCreated : null,
		onClick : null,
		onDblClick : null,
		onRightClick : null,
		onMouseDown : null,
		onMouseUp : null,
		onExpand : null,
		onCollapse : null,
		onRemove : null
	}
};
// zTree 的数据属性，深入使用请参考 API 文档（zTreeNode 节点数据详解）
var zNodes = [ {
	name : "test1",
	open : true,
	children : [ {
		name : "test1_1",
		url : 'http://www.baidu.com'
	}, {
		name : "test1_2"
	} ]
}, {
	name : "test2",
	open : true,
	children : [ {
		name : "test2_1"
	}, {
		name : "test2_2"
	} ]
} ];
$(function() {
	zTreeObj = $.fn.zTree.init($("#treeDemo"), setting, zNodes);
	$('#btn').on('click', function(e) {
		var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
		App.log(treeObj);
		var nodes = treeObj.getSelectedNodes();
		if (nodes.length > 0) {
			treeObj.reAsyncChildNodes(nodes[0], "refresh");
		}
	});
});