var array = [ "重庆市渝北区龙溪街道加州花园A2幢", "奉节县永安镇竹枝路240号", "铜梁县巴川镇铁石路257号", "巫溪县城厢镇先锋路399号", "云阳县双江镇顺通路银海市场七楼", "重庆市江北区洋河二村23号2-3", "沙坪坝区渝碚路88号商1-12号", "重庆市南川区南城街道办事处大星居委", "巫溪县城厢镇白马村一社", "重庆市渝中区观音岩银中大厦E-3-E", "重庆市江北区渝北二村一支路6号未来国际26-7、26-8、26-9、26-10", "重庆市南岸区通江大道96号", "九龙坡区石坪桥五一新村50号", "重庆市南岸区茶园新区花街二期B栋101-1室", "重庆江津区几江鼎山大道邮政业务楼二楼", "重庆市彭水县汉葭镇鼓楼街", "铜梁县巴川镇新南街22号", "重庆市北部新区经开园湖影街2号2幢3号", "重庆市巴南区花溪街道红光大道71号", "重庆市开县汉丰新城南环路1053号", "巴南区鱼洞鱼轻路43号1、2号", "大渡口区西南新城26号佳禾钰茂.毫俊阁A栋8-4", "重庆市南岸区南山街道文峰正街98号8栋", "垫江县桂溪镇石岩路桂东市场6栋房二楼", "重庆市南岸区南坪街道开发路31号", "重庆市巴南区鱼洞秦家院290号1幢2-9", "万州区鸽子沟72号", "重庆市渝北区龙瑞街22号", "重庆市涪陵区中山路9号", "璧山县青杠街道中大街2号海伦宾馆1号别墅", "重庆市渝中区长江支路25号附2号2-2", "重庆市永川区凉亭子89号6幢附22号", "巫溪县城厢镇太平路228号", "重庆市垫江县桂溪镇人民西路1-3号第七层", "渝中区长江二路177号附2号", "重庆市大足区棠香街道办事处五星大道164号附1号", "渝北区新南路9号", "重庆市九龙坡区马王乡龙泉村129号", "大渡口区钢花路648号", "重庆市江津区几江黄荆街220号", "重庆市沙坪坝区天陈路56号第2层", "垫江县桂溪镇人民西路白领雅园", "铜梁县金龙工业园", "九龙坡区科园二路137号", "重庆市江津区油溪镇建新街", "长寿区凤城街道凤园路1-4-2号", "忠县忠州镇州屏环路43号", "重庆市九龙坡区杨家坪团结路1号22-2#",
		"重庆市渝北区龙塔街道紫荆路288号新城丽园1幢2-1", "巴南区鱼洞新农街36号2-2#", "巫山县巫峡镇广东路", "重庆市南岸区茶园新城区世纪大道28号", "合川区南办处井湾街145#", "大足县棠香街道办事处宏声商业广场6区A09号", "重庆市北碚区歇马镇歇马路55号附11号", "渝中区双钢路3号科协大厦1910", "重庆市江北区建新北路16号27-3", "重庆市北碚区静观镇华静路212、214号", "重庆市沙坪坝区汉渝路123号7楼", "长寿区凤城街道骑鞍街1号", "重庆市北碚区静观镇华渝路111号", "渝中区人和街13号14-1", "重庆市沙坪坝区凤鸣山防水材料批发市场B幢15、16#", "重庆市九龙坡区谢家湾工农四村58号25幢2-9号", "重庆市江北区建新东路21号", "江北区建新东路339号4栋13楼", "渝中区青年路1号32-2#", "重庆市江北区电仪村100号", "重庆市沙坪坝区天陈路2号附2-1-11-1-2-3、2-1-11-1-2-4号", "重庆市江北区建新北路一支路6号40层1号", ];
var back = [ '四川省', '云南省', '湖北省', '湖南省', '贵州省', '陕西省' ];
var jlp = [ '九龙坡区石坪桥五一新村50号', '重庆市九龙坡区马王乡龙泉村129号', '九龙坡区科园二路137号', '重庆市九龙坡区杨家坪团结路1号22-2#', '重庆市九龙坡区谢家湾工农四村58号25幢2-9号', '重庆市九龙坡区杨家坪兴胜路32号1、2栋5层', '重庆市九龙坡区石桥镇高庙村玉灵洞158#', '九龙坡区大杨石组团D分区D8-4-2号地块歇台子罗汉沟一号', '重庆市九龙坡区九龙园区华福大道北段70号(美每家研发中心及标准厂房G栋6楼)', '重庆市九龙坡区石新路218号附44号' ];
var spb = [ '沙坪坝区渝碚路88号商1-12号', '重庆市沙坪坝区天陈路56号第2层', '重庆市沙坪坝区汉渝路123号7楼', '重庆市沙坪坝区凤鸣山防水材料批发市场B幢15、16#', '重庆市沙坪坝区天陈路2号附2-1-11-1-2-3、2-1-11-1-2-4号', '重庆市沙坪坝区汉渝路123号7楼', '重庆市沙坪坝区井口镇复兴路48号', '沙坪坝区西永微电子产业圆SOHO楼A栋9楼' ];
var Test = {
	constant : {
		cq : {
			name : '重庆市',
			code : '132'
		}
	},
	/**
	 * 初始化地图
	 */
	initMap : function() {
		var me = this, map = new BMap.Map("container"), quXianMarkerMgr = new BMapLib.MarkerManager(map), qiYeMarkerMgr = new BMapLib.MarkerManager(map);
		me['map'] = map;
		me['quXianMarkerMgr'] = quXianMarkerMgr;
		me['qiYeMarkerMgr'] = qiYeMarkerMgr;
		map.enableScrollWheelZoom();

		map.disableDoubleClickZoom();
		map.enableInertialDragging();
		map.setMapStyle({
			features : [ "point", "road", "water", "land", "building" ],
			style : "normal"
		});

		me.map.addControl(new BMap.NavigationControl());// 平移缩放控件
		// me.map.addControl(new BMap.OverviewMapControl({
		// isOpen : true
		// }));// 缩略地图控件
		me.map.addControl(new BMap.ScaleControl());// 比例尺控件
		me.map.addControl(new BMap.MapTypeControl(/*
													 * { mapTypes : new BMap.MapType(BMAP_SATELLITE_MAP); }
													 */));// 地图类型控件
		// me.map.addControl(new BMap.CopyrightControl().addCopyright({
		// id : 'cid',
		// content : '版权信息哟'
		// }));// 版权控件

		// me.map.addControl(new BMap.GeolocationControl());// 定位控件
		me.map.addControl(new BMap.PanoramaControl({
			anchor : BMAP_ANCHOR_BOTTOM_RIGHT
		}));// 全景控件
		me.defaultCenterPosition();
	},
	/**
	 * 设置地图默认位置和层级大小
	 */
	defaultCenterPosition : function() {
		var me = this, point = new BMap.Point(107.830028, 29.96226);
		me.map.centerAndZoom(point, 8); // 以丰都县为中心
	},
	setCenterPosition : function(point) {
		var me = this;
		me.map.centerAndZoom(point, 13);
	},
	instanceLabel : function(content) {
		var label = new BMap.Label(content);
		label.setOffset(new BMap.Size(0, -16));
		return label;
	},
	instanceQiYeIcon : function(img) {
		return new BMap.Icon(img, new BMap.Size(22, 22));
	},
	/**
	 * 添加区县的注标到areaMarkerMgr中
	 */
	addMarkerToQuXianMarkerMgr : function(obj) {
		obj.title = obj.title || obj.name || '未知地址名称';
		var me = this, marker = new BMap.Marker(obj.point, {
			title : obj.title
		});
		var label = me.instanceLabel(obj.title);
		marker.setLabel(label);
		marker.addEventListener('click', function(type) {
			marker.setAnimation(BMAP_ANIMATION_BOUNCE);// BMAP_ANIMATION_DROP BMAP_ANIMATION_BOUNCE
			if (marker.getLabel()) {
				marker.getLabel().setContent('正在加载数据...');
			}
			var point = this.getPosition();
			console.log(this.z.title);
			$.ajax({
				type : "post",
				url : CTX + "/home/findQiYeByQuXianName",
				dataType : "json",
				data : {
					quXianName : this.z.title
				},
				success : function(data, textStatus, jqXHR) {
					if (me.qiYeMarkerMgr._numMarkers.length != 0) {
						// console.log('清除企业注标');
						me.qiYeMarkerMgr.clearMarkers();
					}
					for (var i = 0; i < data.length; i++) {
						var qiYePoint = new BMap.Point(data[i].point.lng, data[i].point.lat);
						me.addMarkerToQiYeMgrMarker({
							id : data[i].id,
							point : qiYePoint,
							title : data[i].bgdz
						});
					}
					var allMarkersArr = me.map.getOverlays(), quXianMarkersArr = me.quXianMarkerMgr._numMarkers;
					for (var i = 0; i < quXianMarkersArr.length; i++) {
						var quXianMarker = quXianMarkersArr[i], flag = false;
						for (var j = 0; j < allMarkersArr.length; j++) {
							var allMarker = allMarkersArr[j];
							if (quXianMarker == allMarker) {
								break;
							}
							if (j == allMarkersArr.length - 1) {
								// console.log('窝草就是你了');
								// console.log(quXianMarker);
								flag = true;
								quXianMarker.setLabel(me.instanceLabel(quXianMarker.z.title));
								me.map.addOverlay(quXianMarker);
							}
						}
						if (flag) {
							break;
						}
					}
					me.map.removeOverlay(marker);
					me.setCenterPosition(point);
					me.qiYeMarkerMgr.showMarkers();
				},
				error : function(data, textStatus, jqXHR) {
				}
			});
		});
		me.quXianMarkerMgr.addMarker(marker, 2, 19);// 添加了并未显示
	},
	addMarkerToQiYeMgrMarker : function(obj) {
		obj.title = obj.title || obj.name || '未知地址名称';
		var me = this, marker = new BMap.Marker(obj.point, {
			icon : me.instanceQiYeIcon(IMG + '/icon/qiYe.png')
		});
		// XXX 企业点击事件
		marker.addEventListener('click', function(type) {
			marker.setAnimation(BMAP_ANIMATION_BOUNCE);// BMAP_ANIMATION_DROP BMAP_ANIMATION_BOUNCE
			var label = me.instanceLabel(obj.title);
			label.setContent('正在加载数据...');
			marker.setLabel(label);
			App.log(marker.id);
			// XXX 请求企业信息
			setTimeout(function() {
				label.setContent(null);
				marker.setAnimation(null);// BMAP_ANIMATION_DROP BMAP_ANIMATION_BOUNCE
			}, 1000 * 1);
		});
		marker.setTitle(obj.title);
		marker['id'] = obj.id;
		App.log(marker.id);

		me.qiYeMarkerMgr.addMarker(marker, 2, 19);// 添加了并未显示
	},
	/**
	 * 根据企业详细地址显示图标点 '九龙坡区石新路158号巴山建材城接待中心'
	 */
	markerByQiYe : function(address) {
		var me = this;
		var geocoder = new BMap.Geocoder();
		geocoder.getPoint(address, function(point) {
			if (point) {
				var obj = {
					point : point,
					title : address
				};
				me.addMarkerToQiYeMgrMarker(obj);// XXX 企业的注标时回调加进去的
			} else {
				console.log(address + '---找不到');
			}
		}, me.constant.cq.name);
	},
	/**
	 * 显示行政区域范围同时添加注标
	 */
	quXianArea : function(nameAndPoint) {
		var me = this, bdary = new BMap.Boundary();
		bdary.get(nameAndPoint.name, function(rs) {
			var count = rs.boundaries.length;
			if (count === 0) {
				console.log('未能获取当前输入行政区域');
				return;
			}
			var pointArray = [];
			for (var i = 0; i < count; i++) {
				var ply = new BMap.Polygon(rs.boundaries[i], {// 填充颜色没有时事件无效
					strokeWeight : 2,
					strokeColor : '#ff0000',
					fillOpacity : 0.0,
					fillColor : 'none'
				});
				/*
				 * ply.addEventListener("click", function(type) { console.log(BMapLib.GeoUtils.isPointInPolygon(type.point, ply)); });
				 */
				me.map.addOverlay(ply);
			}
		});
		me.addMarkerToQuXianMarkerMgr(nameAndPoint);// XXX 区域的注标是直接加进去的
	},
	/**
	 * 重庆所有区县
	 */
	allQuXianOfCq : function() {
		var me = this, cityList = new BMapLib.CityList({
			map : me.map
		});
		cityList.getSubAreaList(me.constant.cq.code, function(result) {
			var arr = [], temp = [];
			me.getAllAreaNameAndPoint(result, arr);
			var cityNameAndPoint = arr[0];
			temp.push(arr[0].name)
			for (var i = 1; i < arr.length; i++) {// 循环所有行政区域
				me.quXianArea(arr[i]);
				temp.push(arr[i].name)
			}
			App.log(temp.join(','));
			me.quXianMarkerMgr.showMarkers();
		});
	},
	/**
	 * 将城市的名字和坐标点作为一个对象放入arr
	 */
	getAllAreaNameAndPoint : function(obj, arr) {
		var me = this, area_name = obj.area_name, point = obj.geo, sub = obj.sub;
		if (area_name) {
			arr.push({
				name : area_name,
				point : point
			});
		}
		if (sub) {
			for (var i = 0; i < sub.length; i++) {
				me.getAllAreaNameAndPoint(sub[i], arr);
			}
		}
	},
	/**
	 * 渲染地图
	 */
	render : function() {
		var me = this;
		me.initMap();
		me.allQuXianOfCq();
	}
};
Test.render();
