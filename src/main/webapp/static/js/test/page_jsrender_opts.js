/**
 * jquery分页插件的默认值
 */
$.extend($.fn.pagination.defaults, {
    className : 'paginationjs-theme-blue',
    locator : 'content',
    showGoInput : true,
    showGoButton : true,
    autoHidePrevious : true,
    autoHideNext : true,
    prevText : '上一页',
    nextText : '下一页',
    goButtonText : '跳转',
    showNavigator : true, // n/m
    alias : {
        pageNumber : 'pageNumber',
        pageSize : 'pageSize'
    },
    pageRange : 2,
    formatAjaxError : function(jqXHR, textStatus, errorThrown) {//访问数据失败
        console.log('formatAjaxError');
    },
    triggerPagingOnInit : false, //触发初始化请求分页,false时第一页数据有自己请求获取
    beforeInit : function() {
        console.log('beforeInit');
    },
    afterInit : function() {
        console.log('afterInit');
    },
    beforeRender : function() {
        console.log('beforeRender');
    },
    afterRender : function() {
        console.log('afterRender ');
    }
    // ,
    // pageLink :'http://www.baidu.com'
});