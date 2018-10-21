package com.pygrow.xblog.myblog.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
* @author E先生
* @version 创建时间：2018年8月16日 下午2:02:54
* @ClassName Comment
* @Description 存储用户评论信息
*/
@Entity
@Table(name="comment")
public class Comment implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="commentId")
	private Long id;
	
	@Column(name="logId")
	private Long logId;
	
	@Column(name="userName")
	private String visitorName;
	
	@Column(name="image_src")
	private String visitorImg;
	
	@Column(name="userRank")
	private byte userRank;
	
	@Column(name="pubtime")
	@Temporal(TemporalType.TIMESTAMP)
	private Date pubtime;
	
	@Column(name="sortID")
	private Long sortID;
	
	@Column(name="sortName")
	private String sortName;
	
	@Column(name="blog_src")
	private String blog_src;
	
	@Column(name="content")
	private String content;
	
	@Column(name="userEmail")
	private String visitorEmail;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getLogId() {
		return logId;
	}

	public void setLogId(Long logId) {
		this.logId = logId;
	}

	public String getVisitorName() {
		return visitorName;
	}

	public void setVisitorName(String visitorName) {
		this.visitorName = visitorName;
	}

	public String getVisitorImg() {
		return visitorImg;
	}

	public void setVisitorImg(String visitorImg) {
		this.visitorImg = visitorImg;
	}

	public byte getUserRank() {
		return userRank;
	}

	public void setUserRank(byte userRank) {
		this.userRank = userRank;
	}

	public Date getPubtime() {
		return pubtime;
	}

	public void setPubtime(Date pubtime) {
		this.pubtime = pubtime;
	}

	public Long getSortID() {
		return sortID;
	}

	public void setSortID(Long sortID) {
		this.sortID = sortID;
	}

	public String getSortName() {
		return sortName;
	}

	public void setSortName(String sortName) {
		this.sortName = sortName;
	}

	public String getBlog_src() {
		return blog_src;
	}

	public void setBlog_src(String blog_src) {
		this.blog_src = blog_src;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getVisitorEmail() {
		return visitorEmail;
	}

	public void setVisitorEmail(String visitorEmail) {
		this.visitorEmail = visitorEmail;
	}
	
	
	
}
