/**
 * SearchNews.java
 * com.bestsnail.daoiml
 *
 * Function： TODO 
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2016年5月8日 		liang
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

import com.bestsnail.bean.BookTable;
import com.bestsnail.bean.LecturesTable;
import com.bestsnail.bean.NewsTable;
import com.bestsnail.bean.ResourceDynamicsTable;
import com.bestsnail.utils.CloseDb;
import com.bestsnail.utils.DBconnection;

/**
 * ClassName:SearchNews Function: TODO ADD FUNCTION Reason: TODO ADD REASON
 *
 * @author liang
 * @version
 * @since Ver 1.1
 * @Date 2016年5月8日 下午12:17:16
 *
 * @see
 * 
 */
public class SearchLectures {
	/**
	 * 
	 * SearchNewsByLimit:(通过分页查询的方式按照时间排序的方式查询新闻)<br/>
	 *
	 * @param  @param page
	 * @param  @param pagenum
	 * @param  @return    设定文件
	 * @return List<NewsTable>    DOM对象
	 * @throws 
	 * @since  CodingExample　Ver 1.1
	 */
	public List<LecturesTable> SearchLecturesByLimit(int page, int pagenum) {
		PreparedStatement prepare = null;
		ResultSet query = null;
		Connection conn = DBconnection.getConnection();
		String sql = "select * from lectures_table   order by lec_time   limit ?,?  ; ";
		try {
			prepare = conn.prepareStatement(sql);
			prepare.setInt(1, (page-1 ) * pagenum);
			prepare.setInt(2, pagenum);
			query = prepare.executeQuery();
			List<LecturesTable> list = new ArrayList<LecturesTable>();
			LecturesTable lecturesTable = null;
			while (query.next()) {

				lecturesTable = new LecturesTable();			
				lecturesTable.setLec_id(query.getInt("lec_id"));
				lecturesTable.setLec_longtime(query.getInt("lec_longtime"));
				lecturesTable.setLec_title(query.getString("lec_title"));
				lecturesTable.setLec_info(query.getString("lec_info"));
				lecturesTable.setLec_time(query.getTimestamp("lec_time"));
				lecturesTable.setLec_address(query.getString("lec_address"));
				lecturesTable.setLec_person(query.getString("lec_person"));
				lecturesTable.setLec_per_num(query.getInt("lec_per_num"));
				lecturesTable.setCreate_time(query.getTimestamp("create_time"));
				
				
				
				

				list.add(lecturesTable);
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
	 * SearchLecturesByid:(通过学生Id查询学生报名的讲座数)<br/>
	 * TODO(这里描述这个方法适用条件 – 可选)<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选)<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选)<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选)<br/>
	 *
	 * @param  @param id
	 * @param  @return    设定文件
	 * @return List<LecturesTable>    DOM对象
	 * @throws 
	 * @since  CodingExample　Ver 1.1
	 */
	public List<LecturesTable> SearchLecturesByid(int stu_id) {
		PreparedStatement prepare = null;
		ResultSet query = null;
		Connection conn = DBconnection.getConnection();
		String sql = "select * from lectures_table   where lec_id = ? ; ";
		try {
			prepare = conn.prepareStatement(sql);
			prepare.setInt(1, stu_id);
			
			query = prepare.executeQuery();
			List<LecturesTable> list = new ArrayList<LecturesTable>();
			LecturesTable lecturesTable = null;
			while (query.next()) {
				
				lecturesTable = new LecturesTable();			
				lecturesTable.setLec_id(query.getInt("lec_id"));
				lecturesTable.setLec_longtime(query.getInt("lec_longtime"));
				lecturesTable.setLec_title(query.getString("lec_title"));
				lecturesTable.setLec_info(query.getString("lec_info"));
				lecturesTable.setLec_time(query.getTimestamp("lec_time"));
				lecturesTable.setLec_address(query.getString("lec_address"));
				lecturesTable.setLec_person(query.getString("lec_person"));
				lecturesTable.setLec_per_num(query.getInt("lec_per_num"));
				lecturesTable.setCreate_time(query.getTimestamp("create_time"));
				
				
				
				
				
				list.add(lecturesTable);
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
	 * getLecturesRegistration:(查询该讲座的报名的人数)<br/>
	 *
	 * @param  @param id
	 * @param  @return    设定文件
	 * @return int    DOM对象
	 * @throws 
	 * @since  CodingExample　Ver 1.1
	 */
	public int getLecturesRegistration(int id){
		PreparedStatement prepare = null;
		ResultSet query = null;
		Connection conn = DBconnection.getConnection();
		String sql = "select count(*) from lectures_registration_table   where lec_id=? ; ";
		
		try {
			prepare = conn.prepareStatement(sql);
			prepare.setInt(1, id);
			
			query = prepare.executeQuery();
			
			if (query.next()) {
				return query.getInt("count(*)");
			}
			
		} catch (SQLException e) {

			e.printStackTrace();

		} finally {
			CloseDb.close(conn, query, prepare);
		}

		return 0;
	}
	/**
	 * 
	 * setLecturesRegistration:(进行报名处理)<br/>
	 *
	 * @param  @param lec_id
	 * @param  @param stu_id
	 * @param  @return    设定文件
	 * @return int    DOM对象
	 * @throws 
	 * @since  CodingExample　Ver 1.1
	 */
	public int  setLecturesRegistration(int lec_id,int stu_id){
		
		PreparedStatement prepare = null;
		ResultSet query = null;
		Connection conn = DBconnection.getConnection();
		String sql = "insert into lectures_registration_table (lec_id,stu_id,create_time) values(?,?,?); ";
		try {


			prepare = conn.prepareStatement(sql);
			prepare.setInt(1,lec_id);
			prepare.setInt(2, stu_id);
			
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
	 * isLecturesRegistration:(判断是否报名过)<br/>
	 *
	 * @param  @param lec_id
	 * @param  @param stu_id
	 * @param  @return    设定文件
	 * @return boolean    DOM对象
	 * @throws 
	 * @since  CodingExample　Ver 1.1
	 */
	public boolean  isLecturesRegistration(int lec_id,int stu_id){
		
		PreparedStatement prepare = null;
		ResultSet query = null;
		Connection conn = DBconnection.getConnection();
		String sql = "select * from   lectures_registration_table where lec_id=? and stu_id=?  ;";
		try {
			
			
			prepare = conn.prepareStatement(sql);
			prepare.setInt(1,lec_id);
			prepare.setInt(2, stu_id);
			
			ResultSet executeQuery = prepare.executeQuery();
			if(executeQuery.next()){
				return false;
				
			}
			return true;
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			CloseDb.close(conn, query, prepare);
		}
		
		return false;
		
		
		
		
		
	}
	
	
}
