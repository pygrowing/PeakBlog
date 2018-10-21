package com.pygrow.xblog.myblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pygrow.xblog.myblog.entity.Blog;

/**
* @author E先生
* @version 创建时间：2018年8月17日 下午3:56:22
* @ClassName 类名称
* @Description 类描述
*/
public interface BlogRepository extends JpaRepository<Blog, Long> {

}
