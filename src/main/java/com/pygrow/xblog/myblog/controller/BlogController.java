package com.pygrow.xblog.myblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
* @author E先生
* @version 创建时间：2018年7月3日 上午12:30:28
* @ClassName blog控制器
* @Description 类描述
*/
@Controller
@RequestMapping("/blogs")
public class BlogController {

	/**
	 * 
	 * @param order 排序规则
	 * @param keyword 关键字 标签
	 * @return
	 */
	@GetMapping
	public String listblogs(@RequestParam(value = "order", required = false, defaultValue = "new") String order,
			@RequestParam(value = "keyword", required = false) String keyword) {
		System.out.println("order"+order +";keyword"+keyword);
		return "redirect:/index?order="+order+"&keyword="+keyword;
	}
}
