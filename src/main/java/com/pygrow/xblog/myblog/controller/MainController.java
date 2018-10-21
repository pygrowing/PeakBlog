package com.pygrow.xblog.myblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
* @author E先生
* @version 创建时间：2018年7月3日 上午12:30:28
* @ClassName 主页控制器
* @Description 控制页面跳转
*/
@Controller
public class MainController {

	@GetMapping("/")
	public String root() {
		return "redirect:/admin/index";
	}
	
	@GetMapping("/index")
	public String index() {
		return "index";
	}
	
	@GetMapping("/login")
	public String login() {
		return "admin/login";
	}
	
	@GetMapping("/login-error")
	public String loginError(Model model) {
		model.addAttribute("loginError", true);
		model.addAttribute("errorMsg", "登录失败，用户名或密码错误！");
		return "admin/login";
	}
	
	@GetMapping("/register")
	public String register() {
		return "register";
	}
}
