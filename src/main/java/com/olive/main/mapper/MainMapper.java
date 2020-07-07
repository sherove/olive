package com.olive.main.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.olive.main.vo.BaseVo;
import com.olive.main.vo.UploadVo;

@Mapper
public interface MainMapper {

	public BaseVo getUserInfo() throws Exception;

	public List<BaseVo> getUserList() throws Exception;

	public List<UploadVo> getUploadList() throws Exception;

}
