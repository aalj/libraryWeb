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
import java.util.ArrayList;
import java.util.List;

import com.bestsnail.bean.BookTable;
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
public class SearchNews {
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
	public List<NewsTable> SearchNewsByLimit(int page, int pagenum) {
		PreparedStatement prepare = null;
		ResultSet query = null;
		Connection conn = DBconnection.getConnection();
		String sql = "select * from news_table   order by news_time desc limit ?,?  ; ";
		try {
			prepare = conn.prepareStatement(sql);
			prepare.setInt(1, (page ) * pagenum);
			prepare.setInt(2, pagenum);
			query = prepare.executeQuery();
			List<NewsTable> list = new ArrayList<NewsTable>();
			NewsTable newsTable = null;
			while (query.next()) {

				newsTable = new NewsTable();
				newsTable.setNews_id(query.getInt("news_id"));
				newsTable.setNews_title(query.getString("news_title"));
				newsTable.setNews_info(query.getString("news_info"));
				newsTable.setNews_author(query.getString("news_author"));
				newsTable.setNews_time(query.getDate("news_time"));

				list.add(newsTable);
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
