package com.pygrow.xblog.myblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pygrow.xblog.myblog.entity.Blog;

/**
* @author E先生
* @version 创建时间：2018年7月4日 上午11:35:32
* @ClassName 管理员后台管理控制器
* @Description ·管理后台页面跳转
*/

@Controller
@RequestMapping("/admin")
public class AdminController {

	/**
	 * 获取后台管理主页
	 * @param model
	 * @return
	 */
	@GetMapping
	public ModelAndView login(Model model) {
		return new ModelAndView("admin/login","menuList",model);
	}
	
	/**
	 * 获取后台管理主页
	 * @param model
	 * @return
	 */
	@GetMapping("/index")
	public ModelAndView listUser(Model model) {
		model.addAttribute("staff","1" );
		return new ModelAndView("admin/index","menuList",model);
	}
	
	/**
	 * 获取文章撰写页
	 * @param model
	 * @return
	 */
	@GetMapping("/edit")
	public ModelAndView edit(@ModelAttribute("blog")Blog blog, Model model) {
		model.addAttribute("staff","2" );
		return new ModelAndView("admin/article_edit","menuList",model);
	}
	
	@GetMapping("/editManage")
	public ModelAndView editManage(@ModelAttribute("blog")Blog blog, Model model) {
		model.addAttribute("staff","3" );
		return new ModelAndView("admin/article_manage","menuList",model);
	}
}
