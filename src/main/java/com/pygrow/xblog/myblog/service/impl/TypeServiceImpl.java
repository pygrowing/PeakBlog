package com.pygrow.xblog.myblog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pygrow.xblog.myblog.entity.Type;
import com.pygrow.xblog.myblog.repository.TypeRepository;
import com.pygrow.xblog.myblog.service.TypeService;

/**
* @author E先生
* @version 创建时间：2018年11月13日 下午4:26:55
* @ClassName 类名称
* @Description 类描述
*/
@Service
public class TypeServiceImpl implements TypeService {

	@Autowired
	private TypeRepository typeRepository;
	
	@Override
	public List<Type> listTypeAll() {
		// TODO Auto-generated method stub
		return typeRepository.findAll();
	}

}
