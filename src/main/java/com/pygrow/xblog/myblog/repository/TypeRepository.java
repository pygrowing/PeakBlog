package com.pygrow.xblog.myblog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pygrow.xblog.myblog.entity.Type;

/**
* @author E先生
* @version 创建时间：2018年11月13日 下午4:23:41
* @ClassName TypeRepository
* @Description 类型持久层接口
*/
public interface TypeRepository extends JpaRepository<Type, Long> {

	
	List<Type> findAll();
}
