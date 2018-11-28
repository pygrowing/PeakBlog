package com.pygrow.xblog.myblog.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pygrow.xblog.myblog.entity.Blog;
import com.pygrow.xblog.myblog.entity.Type;

/**
* @author E先生
* @version 创建时间：2018年8月17日 下午3:56:22
* @ClassName BlogRepository
* @Description 博客持久层接口
*/
public interface BlogRepository extends JpaRepository<Blog, Long> {

	List<Blog> findByPostEquals(String post);
	
	Page<Blog> findAll(Pageable pageable);
	
	Page<Blog> findByIdLike(Long id ,Pageable pageable);
	
	@Query(value = "SELECT * FROM Blog WHERE IF(?1!='',logId=?1,1=1) AND IF(?2!='',title LIKE CONCAT('%',?2,'%'),1=1) AND IF(?3!='',typeId = ?3,1=1)", 
			countQuery = "SELECT COUNT(*) FROM Blog WHERE IF(?1!='',logId=?1,1=1) AND IF(?2!='',title LIKE CONCAT('%',?2,'%'),1=1) AND IF(?3!='',typeId = ?3,1=1)", 
			nativeQuery = true)
	Page<Blog> findByIdAndTitleAndTypeid(String id,String title,String type,Pageable pageable);
}
