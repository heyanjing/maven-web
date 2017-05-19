package com.he.spring.controller;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.he.spring.bean.GeocodingResult;
import com.he.spring.bean.Qiye;
import com.he.spring.bean.Result;
import com.he.spring.bean.Results;
import com.he.spring.entity.Person;
import com.he.spring.util.Https;
import com.he.spring.util.Jsons;
import com.he.spring.util.Strings;
import com.he.spring.util.Webs;
import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/home")
@SessionAttributes(names = "model")
public class HomeController {
	@Autowired
	private Cache	userCheatCache;// MEINFO:2017/4/21 9:39 spring单独使用ehcache  配置文件spring-base-cache.xml
	@Autowired
	private Cache	mobileCodeCache;
	@Resource
	private Person	p1;
	@Autowired
	private Person	p2;

	@RequestMapping(value = { "/", "" })
	public String home(Model model) {
		System.out.println(p1.getName());
		System.out.println(p2.getName());
		Element existEl = userCheatCache.get("e1");
		if (existEl == null) {
			System.err.println("锤子 ---- 空的");
		} else {
			System.err.println(Strings.toString(existEl.getObjectValue()));
		}
		Element el = new Element("e1", "窝草1缓存10秒");
		userCheatCache.put(el);
		model.addAttribute("model", "窝草");
		System.err.println("b");
//		return "/ztree/ztree";/// ztree/ztree
//		return "/page_jsrender2";
//		return "/handlebars";
//		return "/select2";
		return "/home";
//		return "/print";
	}

	/**
	 * @HTTP /home/kaptcha
	 */
	@RequestMapping(value = { "/kaptcha" })
	@ResponseBody
	public Result kaptcha(String kaptchaCode, HttpServletRequest request) {
		Result result = Results.success();
		if (Webs.isEqualsSessionKaptcha(request, kaptchaCode)) {
			result.setMsg("相同");
		} else {
			result.setSuccess(false);
			result.setMsg("失败");
		}
		return result;
	}

	@RequestMapping(value = { "/upload" })
	public String upload() {
		Element existEl = mobileCodeCache.get("e2");
		if (existEl == null) {
			System.err.println("锤子 ---- 空的");
		} else {
			System.err.println(Strings.toString(existEl.getObjectValue()));
		}
		Element el = new Element("e2", "窝草2");
		mobileCodeCache.put(el);
		return "/upload/upload";
	}

	@RequestMapping(value = { "/xx" }, method = RequestMethod.POST)
	public String xx() {
		Element existEl = mobileCodeCache.get("e2");
		if (existEl == null) {
			System.err.println("锤子 ---- 空的");
		} else {
			System.err.println(Strings.toString(existEl.getObjectValue()));
		}
		Element el = new Element("e2", "窝草2");
		mobileCodeCache.put(el);
		return "/upload/upload";
	}

	@RequestMapping(value = { "/findQiYeByQuXianName" })
	@ResponseBody
	public List<Qiye> findQiYeByQuXianName(String quXianName) {
		List<Qiye> list = Lists.newArrayList();
		Map<String, Object> params = Maps.newHashMap();
		String url = "http://api.map.baidu.com/geocoder/v2/";
		params.put("ak", "QPrRO9oujRFgvMxuK8xWSU0RfCGHTspU");
		params.put("output", "json");
		params.put("city", "重庆市");
		// params.put("address", "重庆市九龙坡区石桥铺科园一路2号");
		String[] jlp = { "九龙坡区石坪桥五一新村50号", "重庆市九龙坡区马王乡龙泉村129号", "九龙坡区科园二路137号", "重庆市九龙坡区杨家坪团结路1号22-2#", "重庆市九龙坡区谢家湾工农四村58号25幢2-9号", "重庆市九龙坡区杨家坪兴胜路32号1、2栋5层", "重庆市九龙坡区石桥镇高庙村玉灵洞158#", "九龙坡区大杨石组团D分区D8-4-2号地块歇台子罗汉沟一号", "重庆市九龙坡区九龙园区华福大道北段70号(美每家研发中心及标准厂房G栋6楼)", "重庆市九龙坡区石新路218号附44号" };
		String[] spb = { "沙坪坝区渝碚路88号商1-12号", "重庆市沙坪坝区天陈路56号第2层", "重庆市沙坪坝区汉渝路123号7楼", "重庆市沙坪坝区凤鸣山防水材料批发市场B幢15、16#", "重庆市沙坪坝区天陈路2号附2-1-11-1-2-3、2-1-11-1-2-4号", "重庆市沙坪坝区汉渝路123号7楼", "重庆市沙坪坝区井口镇复兴路48号", "沙坪坝区西永微电子产业圆SOHO楼A栋9楼" };
		String[] gxq = { "重庆市高新区陈家坪华宇大厦C栋16楼", "重庆市高新区石新路299号", "高新区科圆五街９８号", "重庆市高新区科园一路200号科技发展大厦C座11层", "重庆市高新区石桥铺南方花园C区嘉华楼三楼", "高新区渝州支路100-4号", "重庆市高新区金开道7号", "重庆市高新区白马凼29单元4-2号", "重庆市高新区科园一路2号12楼1－6号", "重庆市高新区科园四街标准厂房K座5楼", "重庆市高新区二郎科技新城迎宾大道38号智博中心18楼", "重庆市高新区科园一路3号渝高大厦5-1", "重庆市高新区渝高广场C座16-2", "重庆市高新区渝州路79号新科楼4层17#" };
		String[] allQiYe = null;
		if ("九龙坡区".equals(quXianName)) {
			allQiYe = jlp;
		} else {
			allQiYe = spb;
		}
		allQiYe = gxq;
		int i = 0;
		for (String qiYe : allQiYe) {
			i++;
			params.put("address", qiYe);
			try {
				GeocodingResult gResult = Jsons.toBean(Https.post(url, params), GeocodingResult.class);
				Qiye qy = new Qiye(i + "", "办公地址--" + i, gResult.getResult().getLocation());
				list.add(qy);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		System.err.println(list);
		return list;
	}

	@RequestMapping(value = { "/zuoBiaoChange" })
	@ResponseBody
	public List<Qiye> zuoBiaoChange() {
		List<Qiye> list = Lists.newArrayList();
		Map<String, Object> params = Maps.newHashMap();
		String url = "http://restapi.amap.com/v3/config/district";
		params.put("key", "b8f3e796381186d1a4be764999b7b2ce");
		params.put("keywords", "023");
		params.put("subdistrict", 1);
		params.put("output", "JSON");
		try {
			System.err.println(Https.post(url, params));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@RequestMapping(value = { "/findQuXian" })
	@ResponseBody
	public List<Qiye> findQuXian() {
		List<Qiye> list = Lists.newArrayList();
		Map<String, Object> params = Maps.newHashMap();
		String url = "http://restapi.amap.com/v3/config/district";
		params.put("key", "b8f3e796381186d1a4be764999b7b2ce");
		params.put("keywords", "023");
		params.put("subdistrict", 1);
		params.put("output", "JSON");
		try {
			System.err.println(Https.post(url, params));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
