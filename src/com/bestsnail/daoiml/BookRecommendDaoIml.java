/**
 * BookRecommendDaoIml.java
 * com.bestsnail.daoiml
 *
 * Function： TODO 
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2016年5月22日 		liang
 *
 * Copyright (c) 2016, TNT All Rights Reserved.
*/

package com.bestsnail.daoiml;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.bestsnail.bean.BorrowTable;
import com.bestsnail.bean.RecommendedBookTable;
import com.bestsnail.utils.CloseDb;
import com.bestsnail.utils.DBconnection;

/**
 * ClassName:BookRecommendDaoIml Function: 与图书荐购相关 Reason: TODO ADD REASON
 *
 * @author liang
 * @version
 * @since Ver 1.1
 * @Date 2016年5月22日 下午3:47:04
 *
 * @see
 * 
 */
public class BookRecommendDaoIml {
	/**
	 * 
	 * saveBookRecommend:(推荐图书购买)<br/>
	 *
	 * @param stu_id
	 * @param book_name
	 * @param rebo_author
	 * @param rebo_isbn
	 * @param rebo_press
	 * @param 设定文件
	 * @return int DOM对象
	 * @throws @since
	 *             CodingExample Ver 1.1
	 */
	public int saveBookRecommend(String stu_id, String book_name, String rebo_author, String rebo_isbn,
			String rebo_press) {

		PreparedStatement prepare = null;
		ResultSet query = null;
		Connection conn = DBconnection.getConnection();
		String sql = "insert into recommended_book_table (stu_id,rebo_book_name,rebo_anthor,rebo_isbn,rebo_press,create_time) values(?,?,?,?,?,?); ";
		try {

			prepare = conn.prepareStatement(sql);
			prepare.setString(1, stu_id);
			prepare.setString(2, book_name);
			prepare.setString(3, rebo_author);
			prepare.setString(4, rebo_isbn);
			prepare.setString(5, rebo_press);

			prepare.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
			int executeUpdate = prepare.executeUpdate();

			return executeUpdate;
		} catch (SQLException e) {

			e.printStackTrace();

		} finally {
			CloseDb.close(conn, query, prepare);
		}

		return 0;

	}
	/**
	 * 
	 * getBookRecommend:(通过学生id查询某一个学生推荐的图书历史)<br/>
	 * TODO(这里描述这个方法适用条件 – 可选)<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选)<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选)<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选)<br/>
	 *
	 * @param  @param stu_id
	 * @param  @return    设定文件
	 * @return List<RecommendedBookTable>    DOM对象
	 * @throws 
	 * @since  CodingExample　Ver 1.1
	 */
	public List<RecommendedBookTable> getBookRecommend(String stu_id){
		PreparedStatement prepare = null;
		ResultSet query = null;
		Connection conn = DBconnection.getConnection();
		// 查询图书续借的sql方法，需要判断学生id 需要时间排序，需要查询已经还书
		String sql = "select * from recommended_book_table where stu_id =?  ORDER BY create_time";
		try {
			prepare = conn.prepareStatement(sql);
			prepare.setString(1, stu_id);
			 
			query = prepare.executeQuery();
			List<RecommendedBookTable> list = new ArrayList<RecommendedBookTable>();
			RecommendedBookTable recommendedBookTable = null;
			while (query.next()) {
				recommendedBookTable = new RecommendedBookTable();
				recommendedBookTable.setCreate_time(query.getTimestamp("create_time"));
				recommendedBookTable.setRebo_anthor(query.getString("rebo_anthor"));
				recommendedBookTable.setRebo_book_name(query.getString("rebo_book_name"));
				recommendedBookTable.setRebo_id(query.getInt("rebo_id"));
				recommendedBookTable.setRebo_isbn(query.getString("rebo_isbn"));
				recommendedBookTable.setRebo_press(query.getString("rebo_press"));
				list.add(recommendedBookTable);
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
