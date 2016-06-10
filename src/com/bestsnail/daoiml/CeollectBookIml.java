/**
 * CeollectBookIml.java
 * com.bestsnail.daoiml
 *
 * Function： TODO 
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2016年5月10日 		liang
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

import com.bestsnail.bean.CollectBook;
import com.bestsnail.bean.NewsTable;
import com.bestsnail.utils.CloseDb;
import com.bestsnail.utils.DBconnection;

/**
 * ClassName:CeollectBookIml Function: TODO ADD FUNCTION Reason: TODO ADD REASON
 *
 * @author liang
 * @version
 * @since Ver 1.1
 * @Date 2016年5月10日 下午4:39:11
 *
 * @see
 * 
 */
public class CeollectBookIml {
	/**
	 * 
	 * setCeollectBook:(添加收藏的书籍)<br/>
	 * TODO(这里描述这个方法适用条件 – 可选)<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选)<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选)<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选)<br/>
	 *
	 * @param @param
	 *            book_id
	 * @param @param
	 *            stu_id
	 * @param @return
	 *            设定文件
	 * @return int DOM对象
	 * @throws @since
	 *             CodingExample Ver 1.1
	 */
	public int setCeollectBook(String  book_id, String stu_id) {

		PreparedStatement prepare = null;
		ResultSet query = null;
		Connection conn = DBconnection.getConnection();
		String sql = "insert into collect_book (book_id,stu_id,create_time) values(?,?,?); ";
		try {
			prepare = conn.prepareStatement(sql);
			prepare.setString(1, book_id);
			prepare.setString(2, stu_id);

			prepare.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
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
	 * isCeollectBook:(判断着个学生是否收藏过这本书)<br/>
	 *
	 * @param @param
	 *            book_id
	 * @param @param
	 *            stu_id
	 * @param @return
	 *            设定文件
	 * @return boolean DOM对象
	 * @throws @since
	 *             CodingExample Ver 1.1
	 */
	public boolean isCeollectBook(String book_id, String stu_id) {

		PreparedStatement prepare = null;
		ResultSet query = null;
		Connection conn = DBconnection.getConnection();
		String sql = "select * from   collect_book where book_id=? and stu_id=?  ;";
		try {

			prepare = conn.prepareStatement(sql);
			prepare.setString(1, book_id);
			prepare.setString(2, stu_id);

			ResultSet executeQuery = prepare.executeQuery();
			if (executeQuery.next()) {
				return false;

			}
			return true;
		} catch (SQLException e) {

			e.printStackTrace();

		} finally {
			CloseDb.close(conn, query, prepare);
		}

		return true;

	}
/**
 * 
 * getCollectBookByStuid:(通过学生id查询学生收藏的全部图书)<br/>
 *
 * @param  @param stu_id
 * @param  @return    设定文件
 * @return List<CollectBook>    DOM对象
 * @throws 
 * @since  CodingExample　Ver 1.1
 */
	public List<CollectBook> getCollectBookByStuid(int stu_id) {

		PreparedStatement prepare = null;
		ResultSet query = null;
		Connection conn = DBconnection.getConnection();
		String sql = "select * from collect_book  where stu_id = ?  order by create_time desc  ; ";
		try {
			prepare = conn.prepareStatement(sql);
			prepare.setInt(1, stu_id);
			query = prepare.executeQuery();
			List<CollectBook> list = new ArrayList<CollectBook>();
			CollectBook collectBook = null;
			SearchBookIml searchBookIml = new SearchBookIml();
			while (query.next()) {

				collectBook = new CollectBook();
				
				collectBook.setCollect_id(query.getInt("collect_id"));
				String  book_id =  query.getString("book_id");
				collectBook.setBook(searchBookIml.DSearchBookByid(book_id));
				collectBook.setStudent(null);
				collectBook.setCreate_time(query.getDate("create_time"));

				list.add(collectBook);
			}
			return list;
		} catch (SQLException e) {

			e.printStackTrace();

		} finally {
			CloseDb.close(conn, query, prepare);
		}

		return null;

	}
	/**
	 * 
	 * getCollectBookByStuid:(通过学生id查询学生收藏的全部图书)<br/>
	 *
	 * @param  @param stu_id
	 * @param  @return    设定文件
	 * @return List<CollectBook>    DOM对象
	 * @throws 
	 * @since  CodingExample　Ver 1.1
	 */
		public List<CollectBook> getCollectBookByStuid(int stu_id,int page) {

			PreparedStatement prepare = null;
			ResultSet query = null;
			Connection conn = DBconnection.getConnection();
			String sql = "select * from collect_book  where stu_id = ?  order by create_time desc limit ?,? ; ";
			try {
				prepare = conn.prepareStatement(sql);
				prepare.setInt(1, stu_id);
				prepare.setInt(2, (page-1)*30);
				prepare.setInt(3, 30);
				query = prepare.executeQuery();
				List<CollectBook> list = new ArrayList<CollectBook>();
				CollectBook collectBook = null;
				SearchBookIml searchBookIml = new SearchBookIml();
				while (query.next()) {

					collectBook = new CollectBook();
					
					collectBook.setCollect_id(query.getInt("collect_id"));
					String  book_id =  query.getString("book_id");
					collectBook.setBook(searchBookIml.DSearchBookByid(book_id));
					collectBook.setStudent(null);
					collectBook.setCreate_time(query.getDate("create_time"));

					list.add(collectBook);
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
