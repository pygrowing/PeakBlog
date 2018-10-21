package com.pygrow.xblog.myblog.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
* @author E先生
* @version 创建时间：2018年8月9日 下午10:48:27
* @ClassName 类名称
* @Description 类描述
*/
@Entity
@Table(name="blog")
public class Blog implements Serializable {

	private static final long serialVersionUID = 1L;
	
	//文章ID
	@Id
	@Column(name="logId")
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 自增长策略
	private Long id;
	//文章标题
	@Column(name="title")
	private String title;
	//自定义post请求
	@Column(name="post")
	private String post;
	//文章引导图
	@Column(name="handImage")
	private String handImage;
	//发表时间
	@Column(name="releaseTime")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createTime;
	//分类
	@Column(name="typeId")
	private int type;
	//标签
	@Column(name="tags")
	private String tags;
	//文章内容
	@Column(name="mdContent")
	private String content;
	//html文章内容
	@Column(name="htmlContent")
	private String htmlContent;
	//是否评论
	@Column(name="canComment")
	private byte canComment;
	//是否推荐
	@Column(name="recommended")
	private byte recommended;
	//是否私有
	@Column(name="canPrivate")
	private byte canPrivate;
	//访问量
	@Column(name="click")
	private int readSize = 0;
	//是否保存到草稿箱 默认给0 保存到草稿箱
	@Column(name="drafts")
	private byte drafts = 0;
	// 点赞量
	@Column(name="love")
	private int  voteSize = 0; 
	//评论量
	@Transient
	private int commentSize = 0;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public String getHandImage() {
		return handImage;
	}
	public void setHandImage(String handImage) {
		this.handImage = handImage;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getHtmlContent() {
		return htmlContent;
	}
	public void setHtmlContent(String htmlContent) {
		this.htmlContent = htmlContent;
	}
	public byte getCanComment() {
		return canComment;
	}
	public void setCanComment(byte canComment) {
		this.canComment = canComment;
	}
	public byte getRecommended() {
		return recommended;
	}
	public void setRecommended(byte recommended) {
		this.recommended = recommended;
	}
	public byte getCanPrivate() {
		return canPrivate;
	}
	public void setCanPrivate(byte canPrivate) {
		this.canPrivate = canPrivate;
	}
	public int getReadSize() {
		return readSize;
	}
	public void setReadSize(int readSize) {
		this.readSize = readSize;
	}
	public byte getDrafts() {
		return drafts;
	}
	public void setDrafts(byte drafts) {
		this.drafts = drafts;
	}
	public int getVoteSize() {
		return voteSize;
	}
	public void setVoteSize(int voteSize) {
		this.voteSize = voteSize;
	}
	public int getCommentSize() {
		return commentSize;
	}
	public void setCommentSize(int commentSize) {
		this.commentSize = commentSize;
	}
	
	
	
	
}
