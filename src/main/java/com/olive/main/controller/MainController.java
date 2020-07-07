package com.olive.main.controller;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.olive.main.service.MainService;
import com.olive.main.vo.UploadVo;

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
	
	//파일업로드 리스트
	@RequestMapping("/uploadList") 
	public String uploadList(HttpServletRequest request, Model model, RedirectAttributes flash) throws Exception {
		List<UploadVo> list = mainService.getUploadList();
		return "uploadList"; 
	}

	//파일업로드 등록
	@RequestMapping("/UploadService")
	protected void UploadService(HttpServletRequest request, HttpServletResponse response , @RequestParam("report") MultipartFile report) throws ServletException, IOException {
        
		//파일명
		String fileName = request.getParameter("fileName");
        //MultipartRequest multi = new MultipartRequest(request, saveDir, maxSize, encoding, new DefaultFileRenamePolicy());
        
        //파일명
        String originalFile = report.getOriginalFilename();
        //확장자
        String originalFileExtension = originalFile.substring(originalFile.lastIndexOf("."));
        
        //업무에서 사용하는 리눅스, UNIX는 한글지원이 안 되는 운영체제 
        //파일업로드시 파일명은 ASCII코드로 저장되므로, 한글명으로 저장 필요
        //UUID클래스 - (특수문자를 포함한)문자를 랜덤으로 생성                    "-"라면 생략으로 대체
        String storedFileName = UUID.randomUUID().toString().replaceAll("-", "") + originalFileExtension;
        
        String filePath = "C:\\Users\\user\\Desktop\\yye\\"; //파일패스는 내가 알아서 해줌
      //파일을 저장하기 위한 파일 객체 생성
        File file = new File(filePath + storedFileName);
        report.transferTo(file);
        
   
   }
}




