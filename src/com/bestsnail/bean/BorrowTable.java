/**
 * BorrowTable.java
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
 * ClassName:BorrowTable Function: TODO ADD FUNCTION Reason: TODO ADD REASON
 *
 * @author liang
 * @version
 * @since Ver 1.1
 * @Date 2016年5月2日 下午4:40:08
 *
 * @see
 * 
 */
public class BorrowTable {
	private int borrow_id;
	private int borrow_num;
	private Student student;
	private BookTable book;
	private Date borrow_time;
	/**
	 * 是否还书
	 */
	private int borrow_is;

	public BorrowTable(int borrow_id, int borrow_num, Student student, BookTable book, Date borrow_time,
			int borrow_is) {
		super();
		this.borrow_id = borrow_id;
		this.borrow_num = borrow_num;
		this.student = student;
		this.book = book;
		this.borrow_time = borrow_time;
		this.borrow_is = borrow_is;
	}

	public BorrowTable() {
		super();
	}

	public int getBorrow_id() {
		return borrow_id;
	}

	public void setBorrow_id(int borrow_id) {
		this.borrow_id = borrow_id;
	}

	public int getBorrow_num() {
		return borrow_num;
	}

	public void setBorrow_num(int borrow_num) {
		this.borrow_num = borrow_num;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public BookTable getBook() {
		return book;
	}

	public void setBook(BookTable book) {
		this.book = book;
	}

	public Date getBorrow_time() {
		return borrow_time;
	}

	public void setBorrow_time(Date borrow_time) {
		this.borrow_time = borrow_time;
	}

	public int getBorrow_is() {
		return borrow_is;
	}

	public void setBorrow_is(int borrow_is) {
		this.borrow_is = borrow_is;
	}

}
