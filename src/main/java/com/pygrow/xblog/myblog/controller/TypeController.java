package com.pygrow.xblog.myblog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pygrow.xblog.myblog.entity.Type;
import com.pygrow.xblog.myblog.service.TypeService;
import com.pygrow.xblog.myblog.util.ToolUtil;
import com.pygrow.xblog.myblog.vo.Response;

/**
* @author E先生
* @version 创建时间：2018年11月13日 下午4:37:37
* @ClassName 类名称
* @Description 类描述
*/
@RestController
@Controller
@RequestMapping("/admins")
public class TypeController {
	
	@Autowired
	private TypeService typeService;
	
	@GetMapping("/showType")
	public ResponseEntity<Response> showType(){
		List<Type> listType = typeService.listTypeAll();
		if(null == listType || listType.size() ==0 ){
			return ResponseEntity.ok().body(new Response(false, "没有相关类型", listType));
		}else {
			return ResponseEntity.ok().body(new Response(true, "查询成功", listType));
		}
	}
}
