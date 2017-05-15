$(function () {
});


/*
$.ajax({
	type : "post",
	url : CTX + "/person/findAll",
	// url : CTX + "/person/findAllPersonBean",
	// // url : CTX + "/person/pageByName",
	// url : CTX + "/person/pagePersonBeanByName",
	// data : {
	// name :"name1",
	// pageNumber : 0,
	// pageSize : 10
	// },
	dataType : "json",
	success : function(data, textStatus, jqXHR) {
		App.log(this);
		App.log(data);
		App.log(textStatus);
		App.log(jqXHR);
	},
	error : function(data, textStatus, jqXHR) {
		App.log(this);
		App.log(data);
		App.log(textStatus);
		App.log(jqXHR);
	}
});
 */

/*
 * $.ajaxSetup({ global : false, method : "POST", dataType : 'json', cache : false, timeout : 5000 });
 */
$('#kaptcha').click(function() {
	var img = $(this).attr('src') + "?" + Math.floor(Math.random() * 100);
	$(this).attr('src', img);
});

$('#btn').on('click', function() {
	$.ajax({
		url : CTX + '/home/kaptcha',
		data : {
			kaptchaCode : $('#kaptchaCode').val()
		},
		success : function(data, textStatus, jqXHR) {
			console.log(data);
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {

		}

	});
});

// $('#demo').pagination({
// 	dataSource : [ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 ],
// 	pageSize : 2,
// 	showGoInput : true,
// 	showGoButton : true,
// 	callback : function(data, pagination) {
// 		var html = template(data);
// 		dataContainer.html(html);
// 	}
// })

// (function() {
// console.log("1111111");
// })();
