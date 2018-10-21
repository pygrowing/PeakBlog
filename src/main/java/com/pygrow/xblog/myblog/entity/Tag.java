package com.pygrow.xblog.myblog.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
* @author E先生
* @version 创建时间：2018年8月16日 下午2:50:14
* @ClassName Tag
* @Description 将所有使用的tag统一存储
*/
@Entity
@Table(name="tag")
public class Tag implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="tagId")
	private Long id;
	@Column(name="text")
	private String tagname;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTagname() {
		return tagname;
	}
	public void setTagname(String tagname) {
		this.tagname = tagname;
	}
	
	
}
