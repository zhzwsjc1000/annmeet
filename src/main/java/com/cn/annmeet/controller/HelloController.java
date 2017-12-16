package com.cn.annmeet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/hello")
public class HelloController {
	@RequestMapping("/say")
	public ModelAndView say() {
		ModelAndView model = new ModelAndView();
		model.setViewName("hello");
		return model;
	}
	
}
