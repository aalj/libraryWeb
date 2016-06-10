/**
 * DBconnection.java
 * com.xuetu.util
 *
 * Function： TODO 
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2016年1月6日 		Stone
 *
 * Copyright (c) 2016, TNT All Rights Reserved.
*/

package com.bestsnail.utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Properties;

/**
 * ClassName:DBconnection Function: TODO ADD FUNCTION Reason: TODO ADD REASON
 *
 * @author Stone
 * @version
 * @since Ver 1.1
 * @Date 2016年1月6日 上午10:46:30
 *
 * @see
 * 
 */
public class DBconnection {
	public static Connection getConnection() {
		try {

			Properties p = new Properties();
			p.load(DBconnection.class.getResourceAsStream("db.properties"));
			Class.forName(p.getProperty("driver"));
			//返回连接数据的对象
			return DriverManager.getConnection(
					p.getProperty("url"), //数据库地址
					p.getProperty("name"), //数据库用户名
					p.getProperty("pwd"));//数据库登陆密码
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} 

	}

}
