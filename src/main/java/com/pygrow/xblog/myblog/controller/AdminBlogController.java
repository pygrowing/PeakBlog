package com.pygrow.xblog.myblog.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.pygrow.xblog.myblog.util.ToolUtil;
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
	private static Logger logger = LoggerFactory.getLogger(AdminBlogController.class);
	
	@Autowired
	private BlogService blogService;
	
	@PostMapping("/saveblog")
	@ResponseBody
	public ResponseEntity<Response> saveBlog(Blog blog,MultipartFile MutiImage){
		UploadController uploadController = new UploadController();
		if(MutiImage.getSize() == 0) {
			logger.info(">>>>修改中没有替换图片");
		}else {
			logger.info(">>>>图片上传");
//			String imagePath = uploadController.upload(MutiImage);
		}
		//判断博客是新增还是修改
		if(blog.getId() != null) {
			
		}else {
			blog.setCreateTime(ToolUtil.getNowDateShort());
		}
		
		
		String redirectUrl = "admin/index";
		return ResponseEntity.ok().body(new Response(true, "博文发表成功     "+ToolUtil.getTimeShort(), redirectUrl));
	}
	

}
