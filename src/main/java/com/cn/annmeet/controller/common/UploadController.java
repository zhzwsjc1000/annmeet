package com.cn.annmeet.controller.common;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Controller
public class UploadController {
	@RequestMapping(value="/upload")
	@ResponseBody
	public String upload(CommonsMultipartFile file,HttpServletRequest request) {
		if(!file.isEmpty()) {
			String type =file.getOriginalFilename().substring(file.getOriginalFilename().indexOf("."));
			String fileName=System.currentTimeMillis()+type;
			String path=request.getSession().getServletContext().getRealPath("/upload/"+fileName);
			File uploadFile = new File(path);
			try {
				FileUtils.copyInputStreamToFile(file.getInputStream(), uploadFile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return "success";
	}
}
