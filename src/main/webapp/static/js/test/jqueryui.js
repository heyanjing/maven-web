// $("#datepicker").datepicker();
//jQuery('#datetimepicker1').datetimepicker({
//	i18n : {
//		de : {
//			months : [ 'Januar', 'Februar', 'März', 'April', 'Mai', 'Juni', 'Juli', 'August', 'September', 'Oktober', 'November', 'Dezember', ],
//			dayOfWeek : [ "So.", "Mo", "Di", "Mi", "Do", "Fr", "Sa.", ]
//		},
//		zh : {
//			months : [ '一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月', '十月', '十一月', '十二月', ],
//			dayOfWeek : [ "星期天", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六", ]
//		}
//	},
//	timepicker : false,
//	format : 'd.m.Y'
//});
jQuery.datetimepicker.setLocale('zh');
$('#datetimepicker').datetimepicker({
	format : 'Y-n-j',// Y-n-j G:i:s
	formatDate : 'Y-n-j',
	formatTime : 'G:i:s',
	step : 5,
	closeOnDateSelect : true,
	closeOnWithoutClick : false,// 无效
	validateOnBlur : true,
	timepicker : false,
	datepicker : true,
	weeks : true,// 显示第几周
	// theme : 'dark',
	todayButton : true,
	defaultSelect : true,
	allowBlank : false,
	onSelectDate : function(date, self, e) {
		App.log(date);
		App.log(self);
		App.log(e);
	},
	yearStart : 1950,
	yearEnd : 2050,
	dayOfWeekStart : 0
// weekends : [ '01.01.2014', '02.01.2014', '03.01.2014', '04.01.2014', '05.01.2014', '06.01.2014' ]
});

$('#startDate').datetimepicker({
	format : 'Y-n-j',
	onShow : function(ct) {
		this.setOptions({
			maxDate : $('#endDate').val() ? $('#endDate').val() : false
		})
	},
	timepicker : false
});
$('#endDate').datetimepicker({
	format : 'Y-n-j',
	onShow : function(ct) {
		this.setOptions({
			minDate : $('#startDate').val() ? $('#startDate').val() : false
		})
	},
	timepicker : false
});