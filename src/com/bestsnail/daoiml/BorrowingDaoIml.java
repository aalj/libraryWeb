/**
 * BorrowingHistory.java
 * com.bestsnail.daoiml
 *
 * Function： TODO 
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2016年5月18日 		liang
 *
 * Copyright (c) 2016, TNT All Rights Reserved.
*/

package com.bestsnail.daoiml;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bestsnail.bean.BookTable;
import com.bestsnail.bean.BorrowTable;
import com.bestsnail.utils.CloseDb;
import com.bestsnail.utils.DBconnection;

/**
 * ClassName:BorrowingHistory</br>
 * Function: 关于图书续借的
 *
 * @author liang
 * @version
 * @since Ver 1.1
 * @Date 2016年5月18日 上午10:33:48
 *
 * @see
 * 
 */
public class BorrowingDaoIml {

	/**
	 * 
	 * SearchBookList:(查询图书续借的方法)<br/>
	 *
	 * @param @return
	 *            设定文件
	 * @return List<BookTable> DOM对象
	 * @throws @since
	 *             CodingExample Ver 1.1
	 */
	public List<BorrowTable> BorrowingHByStuId(int stu_ida,int page ) {
		LoginDao loginDao = new LoginDao();
		SearchBookIml bookIml = new SearchBookIml();
		PreparedStatement prepare = null;
		ResultSet query = null;
		Connection conn = DBconnection.getConnection();
		// 查询图书续借的sql方法，需要判断学生id 需要时间排序，需要查询已经还书
		String sql = "select * from borrow_table where stu_id =? and borrow_is = 2 order by remand_time desc limit ?,?";
		try {
			prepare = conn.prepareStatement(sql);
			prepare.setInt(1, stu_ida);
			prepare.setInt(2, (page-1 ) * 30);
			prepare.setInt(3, 30);
			query = prepare.executeQuery();
			List<BorrowTable> list = new ArrayList<BorrowTable>();
			BorrowTable borrowTable = new BorrowTable();
			while (query.next()) {
				borrowTable = new BorrowTable();
				borrowTable.setBorrow_id(query.getInt("borrow_id"));
				int stu_id = query.getInt("stu_id");
				int book_id = query.getInt("book_id");
				borrowTable.setStudent(loginDao.MLogin(stu_id + ""));
				;
				borrowTable.setBook(bookIml.DSearchBookByid(book_id + ""));
				borrowTable.setRemand_time(query.getDate("remand_time"));
				borrowTable.setBorrow_time(query.getDate("borrow_time"));
				borrowTable.setBorrow_is(query.getInt("borrow_is"));
				list.add(borrowTable);
			}
			return list;
		} catch (SQLException e) {

			e.printStackTrace();

		} finally {
			CloseDb.close(conn, query, prepare);
		}

		return null;

	}
	public List<BorrowTable> BorrowingByStuId(int stu_ida,int page ) {
		LoginDao loginDao = new LoginDao();
		SearchBookIml bookIml = new SearchBookIml();
		PreparedStatement prepare = null;
		ResultSet query = null;
		Connection conn = DBconnection.getConnection();
		// 查询图书续借的sql方法，需要判断学生id 需要时间排序，需要查询已经还书
		String sql = "select * from borrow_table where stu_id =? and borrow_is = 1 order by remand_time desc limit ?,?";
		try {
			prepare = conn.prepareStatement(sql);
			prepare.setInt(1, stu_ida);
			prepare.setInt(2, (page-1 ) * 30);
			prepare.setInt(3, 30);
			query = prepare.executeQuery();
			List<BorrowTable> list = new ArrayList<BorrowTable>();
			BorrowTable borrowTable = new BorrowTable();
			while (query.next()) {
				borrowTable = new BorrowTable();
				borrowTable.setBorrow_id(query.getInt("borrow_id"));
				int stu_id = query.getInt("stu_id");
				int book_id = query.getInt("book_id");
				borrowTable.setStudent(loginDao.MLogin(stu_id + ""));
				;
				borrowTable.setBook(bookIml.DSearchBookByid(book_id + ""));
				borrowTable.setRemand_time(query.getDate("remand_time"));
				borrowTable.setBorrow_time(query.getDate("borrow_time"));
				borrowTable.setBorrow_is(query.getInt("borrow_is"));
				list.add(borrowTable);
			}
			return list;
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			CloseDb.close(conn, query, prepare);
		}
		
		return null;
		
	}

}
