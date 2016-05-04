/**
 * CollectBook.java
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
 * ClassName:CollectBook 图书收藏表 Function: TODO ADD FUNCTION Reason: TODO ADD
 * REASON
 *
 * @author liang
 * @version
 * @since Ver 1.1
 * @Date 2016年5月2日 下午4:40:51
 *
 * @see
 * 
 */
public class CollectBook {
	public CollectBook() {
		super();
	}

	public CollectBook(int collect_id, BookTable book, Student student, Date create_time) {
		super();
		this.collect_id = collect_id;
		this.book = book;
		this.student = student;
		this.create_time = create_time;
	}

	public int getCollect_id() {
		return collect_id;
	}

	public void setCollect_id(int collect_id) {
		this.collect_id = collect_id;
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

	private int collect_id;
	private BookTable book;
	private Student student;
	private Date create_time;

}
