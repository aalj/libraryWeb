/**
 * Login.java
 * com.bestsnail.daoiml
 *
 * Function： TODO 
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2016年5月6日 		liang
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
import com.bestsnail.bean.Student;
import com.bestsnail.utils.CloseDb;
import com.bestsnail.utils.DBconnection;

/**
 * ClassName:Login
 * Function: TODO ADD FUNCTION
 * Reason:	 TODO ADD REASON
 *
 * @author   liang
 * @version  
 * @since    Ver 1.1
 * @Date	 2016年5月6日		下午6:13:54
 *
 * @see 	 

 */
public class LoginDao {
	/**
	 * 
	 * MLogin:(通过学号密码查询匹配学生用于登陆)<br/>
	 * @param  @param email
	 * @param  @param pwd
	 * @param  @return    设定文件
	 * @return Student    DOM对象
	 * @throws 
	 * @since  CodingExample　Ver 1.1
	 */
	public Student MLogin(String email,String pwd){
		PreparedStatement prepare = null;
		ResultSet query = null;
		Connection conn = DBconnection.getConnection();
		String sql = "select * from student where stu_number=? and stu_pwd=? ;";
		try {
			prepare = conn.prepareStatement(sql);
			prepare.setString(1, email);
			prepare.setString(2, pwd);
			query = prepare.executeQuery();
			Student student = new Student();
			if (query.next()) {
				student.setStu_id(query.getInt("stu_id")); 
				student.setStu_name(query.getString("stu_name"));
				student.setStu_number(query.getString("stu_number")); 
				student.setStu_pwd(query.getString("stu_pwd"));
				student.setStu_sex(query.getString("stu_sex"));
				student.setStu_age(query.getInt("stu_age"));
				student.setStu_grade(query.getString("stu_grade"));
				student.setStu_subject(query.getString("stu_subject"));
				student.setStu_college(query.getString("stu_college"));
				student.setStu_create_time(query.getDate("stu_create_time"));
			}
			return student;
		} catch (SQLException e) {

			e.printStackTrace();

		} finally {
			CloseDb.close(conn, query, prepare);
		}

		return null;

	}
	/**
	 * 
	 * MLogin:(通过ID查询学生信息)<br/>
	 *
	 * @param  @param id
	 * @param  @return    设定文件
	 * @return Student    DOM对象
	 * @throws 
	 * @since  CodingExample　Ver 1.1
	 */
	public Student MLogin(String id){
		PreparedStatement prepare = null;
		ResultSet query = null;
		Connection conn = DBconnection.getConnection();
		String sql = "select * from student where stu_id=? ;";
		try {
			prepare = conn.prepareStatement(sql);
			prepare.setString(1, id);
			query = prepare.executeQuery();
			Student student = new Student();
			if (query.next()) {
				student.setStu_id(query.getInt("stu_id")); 
				student.setStu_name(query.getString("stu_name"));
				student.setStu_number(query.getString("stu_number")); 
				student.setStu_pwd(query.getString("stu_pwd"));
				student.setStu_sex(query.getString("stu_sex"));
				student.setStu_age(query.getInt("stu_age"));
				student.setStu_grade(query.getString("stu_grade"));
				student.setStu_subject(query.getString("stu_subject"));
				student.setStu_college(query.getString("stu_college"));
				student.setStu_create_time(query.getDate("stu_create_time"));
			}
			return student;
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			CloseDb.close(conn, query, prepare);
		}
		
		return null;
		
	}
	
	
	

}

