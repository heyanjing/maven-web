$(function () {
    $('#test').on('click',function () {
        $.ajax( {
            url:CTX+'/person/pageByName?name=name1&pageNumber=1&pageSize=2',
            type:'post',
            dataType : "json",
            success : function(data, textStatus, jqXHR) {
                console.log(data);
            },
            error : function(data, textStatus, jqXHR) {
                console.log("错误");
                console.log(data);
                console.log(textStatus);
                console.log(jqXHR);
                if(data.status===403){
                    window.location.href=CTX;
                }
            }

        });
    });

   /*
   跨域测试
   $.ajax( {
        url:CTX+'/person/pageByName?name=name1&pageNumber=1&pageSize=2',
        type:'post',
        dataType : "json",
        success : function(data, textStatus, jqXHR) {
            console.log(data);
        },
        error : function(data, textStatus, jqXHR) {
            console.log("错误");
        }

    });
    $.ajax({
        url:CTX+'/person/pageByNamex',
        type:'post',
        dataType : "json",
        data:{url:'http://localhost:8089/spring/person/pageByName'},//ajax不允许跨域，使用后台将跨域信息返回
        success : function(data, textStatus, jqXHR) {
            console.log(data);
        },
        error : function(data, textStatus, jqXHR) {
            console.log("错误");
        }

    });*/

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
