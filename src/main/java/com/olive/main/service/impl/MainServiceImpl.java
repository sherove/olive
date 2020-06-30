package com.olive.main.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olive.main.mapper.MainMapper;
import com.olive.main.service.MainService;
import com.olive.main.vo.BaseVo;

@Service
public class MainServiceImpl implements MainService {
	
	@Autowired
	private MainMapper mainMapper;

	@Override
	public HashMap<String, Object> getUserInfo() throws Exception{
		HashMap<String, Object> resultMap = new HashMap<String,Object>();
		//BaseVo vo = mainMapper.getUserInfo();
		//System.out.println("VOȮ�ΤѤѤѤѤѤѤѤѤ�"+vo);
		List<BaseVo> list = mainMapper.getUserList();
		BaseVo vo = new BaseVo();
		vo.setVolist(mainMapper.getUserList());
		resultMap.put("test","�׽�Ʈ����Դϴ�.");
		resultMap.put("list",list);
		resultMap.put("voList", vo.getVolist());
		return resultMap;
	}

}
