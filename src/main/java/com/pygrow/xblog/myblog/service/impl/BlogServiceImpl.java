package com.pygrow.xblog.myblog.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pygrow.xblog.myblog.entity.Blog;
import com.pygrow.xblog.myblog.repository.BlogRepository;
import com.pygrow.xblog.myblog.service.BlogService;

/**
* @author E先生
* @version 创建时间：2018年8月20日 下午9:38:04
* @ClassName 类名称
* @Description 类描述
*/
@Service
public class BlogServiceImpl implements BlogService {
	
	@Autowired
	private BlogRepository blogRepository;

	@Transactional
	@Override
	public Blog saveBlog(Blog blog) {
		Blog returnBlog = blogRepository.save(blog);
		return returnBlog;
	}

}
