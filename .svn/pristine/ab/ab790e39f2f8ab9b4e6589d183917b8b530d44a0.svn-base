package com.olive.main.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.olive.main.service.MainService;
import com.olive.main.vo.BaseVo;

@Controller
@RequestMapping("/main")
public class MainController {
	
	@Autowired
	private MainService mainService;
	
	
	@ModelAttribute("serverTime")
	public String getServerTime(Locale locale) {
		Date date = new Date();
	    DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
	    return dateFormat.format(date);
	}

	@RequestMapping("/index") 
	public String view(HttpServletRequest request, Model model, RedirectAttributes flash) throws Exception {

		HashMap<String, Object> resultMap = mainService.getUserInfo();
		
		return "index"; 
	}
	
	@ResponseBody
	@RequestMapping("/tableList")
	public HashMap<String,Object> tableList(HttpServletRequest request, Model model, RedirectAttributes flash)throws Exception {
		HashMap<String, Object> resultMap = mainService.getUserInfo();
		return resultMap;
	}
	
	

	
}




