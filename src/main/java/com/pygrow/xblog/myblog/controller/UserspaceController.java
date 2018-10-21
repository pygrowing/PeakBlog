package com.pygrow.xblog.myblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//import com.mysql.cj.api.log.Log;

import ch.qos.logback.core.rolling.SizeAndTimeBasedRollingPolicy;

/**
* @author E先生
* @version 创建时间：2018年7月3日 上午12:30:28
* @ClassName 用户主页控制器
* @Description 类描述
*/
@Controller
@RequestMapping("/u")
public class UserspaceController {

	/**
	 * 用户主页
	 * @param userName 用户名
	 * @return
	 */
	@GetMapping("/{userName}")
	public String userSpace(@PathVariable("userName")String userName) {
		return "/userspace/u";
	}
	
	/**
	 * 用户博客主页
	 * @param userName 用户名称
	 * @param order 排序方式  默认为new最新
	 * @param category 分类
	 * @param keyword 关键字
	 * @return
	 */
	@GetMapping("/{userName}/blogs")
	public String listBlogsByOrder(@PathVariable("userName") String userName,
			@RequestParam(value = "order", required = false, defaultValue = "new") String order,
			@RequestParam(value="category",required=false)Long category,
			@RequestParam(value="keyword",required=false)String keyword) {
		
		if (category != null) {
			return "/userspace/u";
		}else if(keyword != null && keyword.isEmpty() ==false){
			return "/userspace/u";
		}
		return "/userspace/u";
	}
	
	/**
	 * 根据ID来查询文章
	 * @param id 
	 * @return
	 */
	@GetMapping("/{userName}/blog/{id}")
	public String listBlogsById(@PathVariable("id")Long id) {
		return "/userspace/blog";
	}
	
	/**
	 * 编辑博客
	 * @return
	 */
	@GetMapping("/{userName}/blog/edit")
	public String enditBlog() {
		return "/userspace/blogedit";
	}
}
