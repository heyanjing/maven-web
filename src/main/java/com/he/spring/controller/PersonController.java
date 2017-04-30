package com.he.spring.controller;

import com.google.common.collect.Lists;
import com.he.spring.bean.PersonBean;
import com.he.spring.bean.Result;
import com.he.spring.bean.Results;
import com.he.spring.entity.Person;
import com.he.spring.service.PersonService;
import com.he.spring.util.Jsons;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonService personService;

	/**
	 */
	@ResponseBody
	@RequestMapping(value = "/test", produces = { "application/json;charset=UTF-8" })
	public String test() {
		return "xx成功";
	}

	/**
	 */
	@ResponseBody
	@RequestMapping(value = "/get")
	public Person get(String id) {
		return personService.get(id);
	}

	@ResponseBody
	@RequestMapping(value = "/save")
	public Object save() {
		Person person = new Person("name1", 13, new Date());
		person = personService.save(person);
		return person;
	}

	@ResponseBody
	@RequestMapping(value = "/saveAll")
	public List<Person> saveAll() {
		List<Person> list = Lists.newArrayList();
		for (int i = 1; i <= 50; i++) {
			Person person = new Person("name" + i, 10 + i, new Date());
			list.add(person);
		}
		return personService.saveAll(list);
	}
	public static byte[] getRequestPostBytes(HttpServletRequest request)  
            throws IOException {  
		int contentLength = request.getContentLength();  
        if(contentLength<0){  
            return null;  
        }  
        byte buffer[] = new byte[contentLength];  
        for (int i = 0; i < contentLength;) {  
  
            int readlen = request.getInputStream().read(buffer, i,  
                    contentLength - i);  
            if (readlen == -1) {  
                break;  
            }  
            i += readlen;  
        }  
        return buffer;  
    }  
	@RequestMapping(value = "/savex")
	@ResponseBody
	public Result savex(HttpServletRequest request,HttpServletResponse response,String json) throws IOException {
		/*
		 *okgo.upjson 上传json
		String s=new String(getRequestPostBytes(request));
		System.err.println(s);*/
		
		Result reslut=Results.success();
		Person person=null;
		if(json!=null){
			person = Jsons.toBean(json, Person.class);
		}else{
			person = new Person("name1", 13, new Date());
		}
		person = personService.save(person);
		return reslut;
	}

	// @ModelAttribute(name = "person")
	// public Person newUser() {
	// return new Person(null, 200, new Date());
	// }

	@ResponseBody
	@RequestMapping(value = "/update")
	public Object update(@Valid @ModelAttribute(name = "person") Person person, BindingResult result) {
		if (result.hasErrors()) {
			List<FieldError> fes = result.getFieldErrors();
			for (FieldError fe : fes) {
				System.out.println(fe.getField() + "-------------->" + fe.getDefaultMessage());
			}
		}
		return null;
	}

	@ResponseBody
	@RequestMapping(value = "/findAll")
	public List<Person> findAll() {
		List<Person> ps = this.personService.findAllx();
		System.out.println(ps);
		return ps;
	}

	@ResponseBody
	@RequestMapping(value = "/findAllPersonBean")
	public List<PersonBean> findAllPersonBean() {
		List<PersonBean> pbs = this.personService.findAllPersonBean();
		System.out.println(pbs);
		return pbs;
	}

	@ResponseBody
	@RequestMapping(value = "/pageByName")
	public Page<Person> pageByNamex(String name, String selectedIds, @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber, @RequestParam(name = "pageSize", defaultValue = "20") Integer pageSize) {
		Page<Person> page = this.personService.pageByName(name, selectedIds, pageNumber, pageSize);
		if(true){
			throw  new RuntimeException("手动抛得异常");
		}
//		System.out.println(page);
		System.err.println("xxx我xx操我操我操我操我操我操我操我操我操我操我操我操我操");
		return page;
	}

	// @ResponseBody
	// @RequestMapping(value = "/pageByName")
	// public Page<Person> getTotleNumber(String name, Integer pageNumber, Integer pageSize) {
	// Page<Person> page = this.personService.pageByName(name, pageNumber, pageSize);
	// return page;
	// }

	@ResponseBody
	@RequestMapping(value = "/pagePersonBeanByName")
	public Page<PersonBean> pagePersonBeanByName(String name, Integer pageNumber, Integer pageSize, Model model) {
		Page<PersonBean> page1 = this.personService.pagePersonBeanByName(name, pageNumber, pageSize);
		// model.addAttribute("page1", page1.getContent());
		// Page<Person> page2 = this.personService.pageByName(name, pageNumber, pageSize);
		// model.addAttribute("page2", page2);
		// List<Person> all = this.personService.findAll();
		// model.addAttribute("all", all);
		// return "/home";
		return page1;
	}
}
