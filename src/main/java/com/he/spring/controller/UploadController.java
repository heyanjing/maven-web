package com.he.spring.controller;

import com.he.spring.bean.Result;
import com.he.spring.bean.Results;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

@Controller
@RequestMapping("/upload")
public class UploadController {

    // 将配置文件中文件上传大小值设置大一点,然后再在代码中判断，从而给出友好提示
//    @ResponseBody
//    @RequestMapping(value = "/test")//, produces = { "application/json;charset=UTF-8" }
//    public Result test(HttpServletRequest request, @RequestParam("file") MultipartFile file) {
//    	Result result=Results.success();
//        // 判断文件是否为空
//        if (!file.isEmpty()) {
//            System.out.println(file.getSize());
//            if (file.getSize() > 10240000) {
//                System.err.println("大于1K了");
//                result.setSuccess(false);
//                result.setMsg("大于1K了");
//                return result;
//            }
//            try {
//                // 文件保存路径
//                String filePath = "D:/" + file.getOriginalFilename();
//                // 转存文件
//                file.transferTo(new File(filePath));
//            } catch (Exception e) {
//                e.printStackTrace();
//                result.setSuccess(false);
//                result.setMsg("锤子老");
//                return result;
//            }
//        }
//        return result;
//    }
    @ResponseBody
    @RequestMapping(value = "/test")//, produces = { "application/json;charset=UTF-8" }
    public Result test(HttpServletRequest request, @RequestParam("file") MultipartFile[] file) {
    	Result result=Results.success();
    	if(file.length>0){
    		for (MultipartFile f : file) {
    			// 判断文件是否为空
    	    	if (!f.isEmpty()) {
    	    		System.out.println(f.getSize());
    	    		if (f.getSize() > 10240000) {
    	    			System.err.println("大于1K了");
    	    			result.setSuccess(false);
    	    			result.setMsg("大于1K了");
    	    			return result;
    	    		}
    	    		try {
    	    			// 文件保存路径
    	    			String filePath = "D:/" + f.getOriginalFilename();
    	    			// 转存文件
    	    			f.transferTo(new File(filePath));
    	    		} catch (Exception e) {
    	    			e.printStackTrace();
    	    			result.setSuccess(false);
    	    			result.setMsg("锤子老");
    	    			return result;
    	    		}
    	    	}
			}
    	}else{
    		result.setSuccess(false);
    	}
    	
    	return result;
    }

    // private WebErrors validate(String filename, MultipartFile file, HttpServletRequest request) {
    // WebErrors errors = WebErrors.create(request);
    // if (file == null) {
    // errors.addErrorCode("imageupload.error.noFileToUpload");
    // return errors;
    // }
    // // 限制上传文件2M内
    // if (file.getSize() > 2097152) {
    // errors.addError("imageupload.error.maxSize");
    // return errors;
    // }
    // if (StringUtils.isBlank(filename)) {
    // filename = file.getOriginalFilename();
    // }
    // String ext = FilenameUtils.getExtension(filename);
    // if (!ImageUtils.isValidImageExt(ext)) {
    // errors.addErrorCode("imageupload.error.notSupportExt", ext);
    // return errors;
    // }
    // try {
    // if (!ImageUtils.isImage(file.getInputStream())) {
    // errors.addErrorCode("imageupload.error.notImage", ext);
    // return errors;
    // }
    // } catch (IOException e) {
    // log.error("image upload error", e);
    // errors.addErrorCode("imageupload.error.ioError", ext);
    // return errors;
    // }
    // return errors;
    // }
}
