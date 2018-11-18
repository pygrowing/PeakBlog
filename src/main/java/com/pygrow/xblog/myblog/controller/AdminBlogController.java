package com.pygrow.xblog.myblog.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.pygrow.xblog.myblog.entity.Blog;
import com.pygrow.xblog.myblog.entity.Type;
import com.pygrow.xblog.myblog.service.BlogService;
import com.pygrow.xblog.myblog.util.ToolUtil;
import com.pygrow.xblog.myblog.util.UtilConstants;
import com.pygrow.xblog.myblog.vo.Response;

/**
* @author E先生
* @version 创建时间：2018年8月20日 下午11:05:04
* @ClassName AdminBlogController
* @Description 管理员博客控制
*/
@RestController
@Controller
@RequestMapping("/admins")
public class AdminBlogController implements UtilConstants{
	private static Logger logger = LoggerFactory.getLogger(AdminBlogController.class);
	
	@Autowired
	private BlogService blogService;
	
	@PostMapping("/saveblog")
	@ResponseBody
	public ResponseEntity<Response> saveBlog(Blog blog,MultipartFile MutiImage,Long typeID){
		UploadController uploadController = new UploadController();
		Map<String, Object> map = new HashMap<String, Object>();
		Type type = new Type();
		type.setId(typeID);
		blog.setType(type);
		if(blog.getPost() == null) 
			blog.setPost(blog.getId().toString());
		
		if(blogService.getBlogByPost(blog.getPost()))
			return ResponseEntity.ok().body(new Response(false, "您输入的post已存在，请重新输入"));
		
		if(MutiImage.getSize() == 0 && blog.getId() != null) {
			logger.info(">>>>修改中没有替换图片");
		}else {
			logger.info(">>>>图片上传");
			String imagePath = uploadController.upload(MutiImage);
			blog.setHandImage(FASTDFS_URL+imagePath);
		}
		//判断博客是新增还是修改
		if(blog.getId() != null) {
			logger.info(">>>>进入修改操作");
			Blog orignalBlog = blogService.getBlogById(blog.getId());
			orignalBlog.setTitle(blog.getTitle());
			orignalBlog.setPost(blog.getPost());
			orignalBlog.setContent(blog.getContent());
			orignalBlog.setHtmlContent(blog.getHtmlContent());
			orignalBlog.setType(blog.getType());
			orignalBlog.setTags(blog.getTags());
			orignalBlog.setCanComment(blog.getCanComment());
			orignalBlog.setRecommended(blog.getRecommended());
			orignalBlog.setCanPrivate(blog.getCanPrivate());
			if(MutiImage.getSize() != 0)
				orignalBlog.setHandImage(blog.getHandImage());
			blogService.saveBlog(orignalBlog);
			map.put("MutiImage", blog.getHandImage());
			map.put("blogId", blog.getId());
			if(blog.getDrafts() == 1) {
				return ResponseEntity.ok().body(new Response(true, "博文修改成功     "+ToolUtil.getTimeShort(), map));
			}else {
				return ResponseEntity.ok().body(new Response(true, "草稿修改成功     "+ToolUtil.getTimeShort(), map));
			}
		}else {
			blog.setCreateTime(ToolUtil.getStringDateShort());
			blogService.saveBlog(blog);
			map.put("MutiImage", blog.getHandImage());
			map.put("blogId", blog.getId());
			if(blog.getDrafts() == 1) {
				return ResponseEntity.ok().body(new Response(true, "博文发表成功     "+ToolUtil.getTimeShort(), map));
			}else {
				return ResponseEntity.ok().body(new Response(true, "草稿保存成功     "+ToolUtil.getTimeShort(), map));
			}
		}
	}
	
	@GetMapping("/showBlog")
	public Map<String,Object> listBlog(@RequestParam(value = "page", required = false, defaultValue = "1") int page,
			@RequestParam(value = "limit", required = false, defaultValue = "5") int limit) {
		Sort sort = new Sort(Direction.ASC,"id");
		Pageable pageable = PageRequest.of(page-1, limit, sort);
		List<Blog> blogs = blogService.ListBlogAll(pageable);
		Long count = blogService.countBlog();
//		model.addAttribute("data",page);
//		return new ModelAndView("admin/article_manage","blogModel", model);
		Map<String,Object> map =new HashMap<String,Object>();
		map.put("data", blogs);
		map.put("code", "0");
		map.put("msg", "");
		map.put("count", count);
		return map;
	}
	
	@GetMapping("/conditionBlog")
	public Map<String, Object> listBlogByCondition(
			@RequestParam(value = "page", required = false, defaultValue = "1") int page,
			@RequestParam(value = "limit", required = false, defaultValue = "5") int limit,
			@RequestParam(value = "id", required = false) String id,
			@RequestParam(value = "title", required = false) String title,
			@RequestParam(value = "typeid", required = false) String typeid) {
		Sort sort = new Sort(Direction.ASC,"logId");
		Pageable pageable = PageRequest.of(page-1, limit, sort);
		List<Blog> blogs = new ArrayList<Blog>();
//		Long count = null;
//		if(id == null) {
//			count = blogService.countBlog();
//			blogs = blogService.ListBlogAll(pageable);
//		}else {
//			blogs = blogService.ListBlogById(id, pageable);
//		}
		
//		Type type = new Type();
//		type.setId(typeid);
		blogs = blogService.ListBlogByIdAndTitleAndTypeid(id, title, typeid, pageable);
		Map<String,Object> map =new HashMap<String,Object>();
		map.put("data", blogs);
		map.put("code", "0");
		map.put("msg", "");
		map.put("count", 15);
		return map;
	}
	

}
