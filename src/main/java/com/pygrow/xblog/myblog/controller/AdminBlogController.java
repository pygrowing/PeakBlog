package com.pygrow.xblog.myblog.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.pygrow.xblog.myblog.entity.Blog;
import com.pygrow.xblog.myblog.service.BlogService;
import com.pygrow.xblog.myblog.vo.Response;

/**
* @author E先生
* @version 创建时间：2018年8月20日 下午11:05:04
* @ClassName AdminBlogController
* @Description 管理员博客控制
*/
@Controller
@RequestMapping("/admins")
public class AdminBlogController {
	
	@Autowired
	private BlogService blogService;
	
	@PostMapping("/saveblog")
	@ResponseBody
	public ResponseEntity<Response> saveBlog(Blog blog,MultipartFile MutiImage){
		SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
		String createBlogTime = df.format(new Date());
		if (MutiImage != null) {	// 现在有文件上传
//			System.out.println("【*** 文件上传 ****】name = " + name); 
			System.out.println("【*** 文件上传 ****】photoName = " + MutiImage.getName());
			System.out.println("【*** 文件上传 ****】photoContentType = " + MutiImage.getContentType());
			System.out.println("【*** 文件上传 ****】photoSize = " + MutiImage.getSize());
			
		}
		String redirectUrl = "admin/index";
		System.out.println(createBlogTime);
		return ResponseEntity.ok().body(new Response(true, "博文发表成功     "+createBlogTime, redirectUrl));
	}
	

}
