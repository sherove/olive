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
import org.springframework.web.multipart.MultipartHttpServletRequest;
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
	public HashMap<String, Object> tableList(HttpServletRequest request, Model model, RedirectAttributes flash)
			throws Exception {
		HashMap<String, Object> resultMap = mainService.getUserInfo();
		return resultMap;
	}

	// 파일업로드 리스트
	@RequestMapping("/uploadList")
	public String uploadList(HttpServletRequest request, Model model, RedirectAttributes flash) throws Exception {
		List<UploadVo> list = mainService.getUploadList();
		return "uploadList";
	}

	// 단일 파일업로드 등록
	@RequestMapping("/UploadService")
	protected void UploadService(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("fileObj") MultipartFile fileObj) throws ServletException, IOException {

		// 파일명
		String fileName = request.getParameter("fileObj");
		// MultipartRequest multi = new MultipartRequest(request, saveDir, maxSize,
		// encoding, new DefaultFileRenamePolicy());

		// 파일명
		String originalFile = fileObj.getOriginalFilename();
		// 확장자
		String originalFileExtension = originalFile.substring(originalFile.lastIndexOf("."));

		// 업무에서 사용하는 리눅스, UNIX는 한글지원이 안 되는 운영체제
		// 파일업로드시 파일명은 ASCII코드로 저장되므로, 한글명으로 저장 필요
		// UUID클래스 - (특수문자를 포함한)문자를 랜덤으로 생성 "-"라면 생략으로 대체
		String storedFileName = UUID.randomUUID().toString().replaceAll("-", "") + originalFileExtension;

		String filePath = "C:\\Users\\user\\Desktop\\yye\\"; // 파일패스는 내가 알아서 해줌
		// 파일을 저장하기 위한 파일 객체 생성
		File file = new File(filePath + storedFileName);
		fileObj.transferTo(file);

	}

	// 단일 파일업로드 등록
	@RequestMapping("/UploadService3")
	protected void UploadService3(HttpServletRequest request, HttpServletResponse response, MultipartHttpServletRequest mpRequest) throws ServletException, IOException {
		System.out.println("ㅎㅎㅇ");
		
		 List<MultipartFile> fileList = mpRequest.getFiles("fileObj"); 
		 String src = mpRequest.getParameter("src"); 
		 String path = "C:\\Users\\user\\Desktop\\yye\\";
		 
		 for(MultipartFile mf : fileList) { 
			 String originFileName =mf.getOriginalFilename(); //원본 파일 명 long fileSize = mf.getSize();
		 
			 String safeFile = path + System.currentTimeMillis() + originFileName; 
			 
			 try {
				 mf.transferTo(new File(safeFile)); 
			 } catch(IllegalStateException e) {
				 e.printStackTrace(); 
			 } catch(IOException e) { 
				 e.printStackTrace(); 
			 } 
		 }
		 
		System.out.println("ㅎㅎ");

	}

	// 다중 파일 업로드 등록
	@RequestMapping("/UploadService2")
	public void UploadService2(HttpServletRequest request) throws ServletException, IOException { // ,
																									// MultipartHttpServletRequest
																									// mpRequest
		System.out.println("오니");
		/*
		 * List<MultipartFile> fileList = mpRequest.getFiles("fileObj"); String src =
		 * mpRequest.getParameter("src"); String path =
		 * "C:\\Users\\user\\Desktop\\yye\\";
		 * 
		 * for(MultipartFile mf : fileList) { String originFileName =
		 * mf.getOriginalFilename(); //원본 파일 명 long fileSize = mf.getSize();
		 * 
		 * String safeFile = path + System.currentTimeMillis() + originFileName; try {
		 * mf.transferTo(new File(safeFile)); } catch(IllegalStateException e) {
		 * e.printStackTrace(); } catch(IOException e) { e.printStackTrace(); } }
		 */

	}

}
