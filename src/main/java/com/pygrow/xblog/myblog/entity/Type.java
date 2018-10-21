package com.pygrow.xblog.myblog.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
* @author E先生
* @version 创建时间：2018年8月16日 下午2:54:39
* @ClassName 类名称
* @Description 类描述
*/
@Entity
@Table(name="type")
public class Type implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="typeId")
	private Long id;
	@Column(name="typeName")
	private String typeName;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
	
}
