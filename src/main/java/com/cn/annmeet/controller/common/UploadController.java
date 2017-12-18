package com.cn.annmeet.controller.common;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.cn.annmeet.common.utils.POIUtil;

@Controller
public class UploadController {
	private static Logger logger =Logger.getLogger(UploadController.class);
	@RequestMapping(value="/upload")
	@ResponseBody
	public String upload(CommonsMultipartFile file,HttpServletRequest request) {
		if(!file.isEmpty()) {
			try {
				POIUtil.readExcel(file);
			} catch (IOException e) {
				logger.error("读取异常");
				e.printStackTrace();
			}
		}
		
		return "success";
	}
}
