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
	
	//���Ͼ��ε� ����Ʈ
	@RequestMapping("/uploadList") 
	public String uploadList(HttpServletRequest request, Model model, RedirectAttributes flash) throws Exception {
		List<UploadVo> list = mainService.getUploadList();
		return "uploadList"; 
	}

	//���Ͼ��ε� ���
	@RequestMapping("/UploadService")
	protected void UploadService(HttpServletRequest request, HttpServletResponse response , @RequestParam("report") MultipartFile report) throws ServletException, IOException {
        
		//���ϸ�
		String fileName = request.getParameter("fileName");
        //MultipartRequest multi = new MultipartRequest(request, saveDir, maxSize, encoding, new DefaultFileRenamePolicy());
        
        //���ϸ�
        String originalFile = report.getOriginalFilename();
        //Ȯ����
        String originalFileExtension = originalFile.substring(originalFile.lastIndexOf("."));
        
        //�������� ����ϴ� ������, UNIX�� �ѱ������� �� �Ǵ� �ü�� 
        //���Ͼ��ε�� ���ϸ��� ASCII�ڵ�� ����ǹǷ�, �ѱ۸����� ���� �ʿ�
        //UUIDŬ���� - (Ư�����ڸ� ������)���ڸ� �������� ����                    "-"��� �������� ��ü
        String storedFileName = UUID.randomUUID().toString().replaceAll("-", "") + originalFileExtension;
        
        String filePath = "C:\\Users\\user\\Desktop\\yye\\"; //�����н��� ���� �˾Ƽ� ����
      //������ �����ϱ� ���� ���� ��ü ����
        File file = new File(filePath + storedFileName);
        report.transferTo(file);
        
   
   }
}




