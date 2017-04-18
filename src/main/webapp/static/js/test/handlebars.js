Handlebars.registerHelper('list', function(items, options) {
	App.log(items);
	App.log(options);
	App.log(options.fn);
  var out = "<ul>";

  for(var i=0, l=items.length; i<l; i++) {
    out = out + "<li>" + options.fn(items[i]) + "</li> " ;       /*options.fn相当于一个编译的函数*/
  }  

  return out + "</ul>";
});


var source   = $("#entry-template1").html();
var template = Handlebars.compile(source);
var context ={
		arr:[{name:'12',age:12},{name:'13',age:13}]
}
var html    = template(context);







$('#hand').html(html);
App.log(html);


