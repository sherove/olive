package com.olive.main.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.olive.main.vo.UploadVo;

@Service
public interface MainService {

	public HashMap<String, Object> getUserInfo() throws Exception;

	public List<UploadVo> getUploadList() throws Exception;
	
}
