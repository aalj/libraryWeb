/**
 * BookRecommend.java
 * com.bestsnail.bean
 *
 * Function： TODO 
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2016年5月2日 		liang
 *
 * Copyright (c) 2016, TNT All Rights Reserved.
*/

package com.bestsnail.bean;

import java.util.Date;

/**
 * ClassName:BookRecommend 图书推荐
 * Function: TODO ADD FUNCTION Reason: TODO ADD REASON
 *
 * @author liang
 * @version
 * @since Ver 1.1
 * @Date 2016年5月2日 下午5:05:32
 *
 * @see
 * 
 */
public class BookRecommend {
	private int recommend_id;
	private BookTable book;
	private Student student;
	public int getRecommend_id() {
		return recommend_id;
	}
	public BookRecommend() {
		super();
	}
	public BookRecommend(int recommend_id, BookTable book, Student student, Date create_time) {
		super();
		this.recommend_id = recommend_id;
		this.book = book;
		this.student = student;
		this.create_time = create_time;
	}
	public void setRecommend_id(int recommend_id) {
		this.recommend_id = recommend_id;
	}
	public BookTable getBook() {
		return book;
	}
	public void setBook(BookTable book) {
		this.book = book;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	private Date create_time;

}
