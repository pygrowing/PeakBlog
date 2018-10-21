package com.pygrow.xblog.myblog.service;
/**
* @author E先生
* @version 创建时间：2018年8月18日 下午3:33:02
* @ClassName 类名称
* @Description 类描述
*/

import com.pygrow.xblog.myblog.entity.Blog;

public interface BlogService {

	/**
	 * 保存Blog
	 * @param blog
	 * @return
	 */
	Blog saveBlog(Blog blog);
}
