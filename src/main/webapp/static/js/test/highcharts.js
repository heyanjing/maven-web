$(function() {
    Highcharts.setOptions({
        // 所有语言文字相关配置都设置在 lang 里
        lang : {
            resetZoom : '重置',
            resetZoomTitle : '重置缩放比例',
            printChart : "打印图表",
            downloadJPEG : "下载JPEG 图片",
            downloadPDF : "下载PDF文档",
            downloadPNG : "下载PNG 图片",
            downloadSVG : "下载SVG 矢量图",
            exportButtonTitle : "导出图片"
        }
    });
    var cfg1 = {
        title : {
            text : 'Exporting is loaded but <em>enabled</em> is false'
        },
        credits : {
            enabled : false
        },
        xAxis : {
            categories : ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec']
        },
        series : [{
            data : [29.9, 71.5, 106.4, 129.2, 144.0, 176.0, 135.6, 148.5, 216.4, 194.1, 95.6, 54.4]
        }],
        exporting : {
            enabled : true
        }
    };
    var cfg2 = {
        chart : {
            type : 'line',
            height : 600,
            borderColor : "#4572A7", //边框颜色
            borderWidth : 0, //边框宽度
            margin : [20, 20], //边距是指图表的外边与图形区域之间的距离，数组分别代表上、右、下和左。要想单独设置可以用marginTop,marginRight,marginBotton 和 marginLeft.
            inverted : false, //是否将X轴和Y轴进行调换，默认值为false
            backgroundColor : '#66B3FF', //背景颜色
            panning : true, //开启平移功能
            panKey : 'shift', //平移时使用的按键
            zoomType : 'x', //那个方向上的平移
            plotBackgroundColor : {
                linearGradient : [0, 0, 500, 500],
                stops : [[0, 'rgb(255, 255, 255)'], [1, 'rgb(200, 200, 255)']]
            },
            //plotBackgroundImage : 'http://www.highcharts.com/demo/gfx/skies.jpg'//绘制图形区域可加背景图片;会覆盖plotBackgroundColor
            plotBorderColor : "#C0C0C0", //绘制图形区域边框颜色
            plotBorderWidth : 1, //绘制图形区域边框宽度
            plotShadow : true, //绘图区投影
            spacing : [0, 10, 15, 10], //图的外边框和绘图区之间的距离，此属性后面跟着是数组，它们分别代表上，右，下，左四个方位的距离。
            resetZoomButton : {//这个按钮出现在缩放之后
                position : {
                    // align: 'right', // by default
                    // verticalAlign: 'top', // by default
                    x : 0,
                    y : 0
                },
                relativeTo : 'plot', //'chart'  它可以更改按钮位置是相对于绘图区还是整个chart区，此属性默认为绘图区 默认值：plot.
                theme : {
                    fill : 'white',
                    stroke : 'silver',
                    r : 0,
                    states : {
                        hover : {
                            fill : '#41739D',
                            style : {
                                color : 'white'
                            }
                        }
                    }
                }
            }
        },
        credits : {
            enabled : true,
            href : 'http://www.baidu.com',
            position : {
                align : 'right',
                verticalAlign : 'bottom',
                x : -10,
                y : -5
            },
            style : {
                cursor : 'pointer',
                color : '#909090',
                fontSize : '10px'
            },
            text : 'www.baidu.com'
        },
        xAxis : {
            categories : ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec']
        },
        series : [{
            data : [29.9, 71.5, 106.4, 129.2, 144.0, 176.0, 135.6, 148.5, 216.4, 194.1, 95.6, 54.4]
        }]
    };

    $('#container').highcharts(cfg1);
});

