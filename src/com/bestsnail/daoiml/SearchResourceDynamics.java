/**
 * SearchResourceDynamics.java
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
import com.bestsnail.bean.ResourceDynamicsTable;
import com.bestsnail.utils.CloseDb;
import com.bestsnail.utils.DBconnection;

/**
 * ClassName:SearchResourceDynamics
 * Function: TODO ADD FUNCTION
 * Reason:	 TODO ADD REASON
 *
 * @author   liang
 * @version  
 * @since    Ver 1.1
 * @Date	 2016年5月8日		下午12:17:40
 *
 * @see 	 

 */
public class SearchResourceDynamics {
	/**
	 * 
	 * SearchResourceByLimit:(进行分页查询动态资源按照时间排序)<br/>
	 *
	 * @param  @param page
	 * @param  @param pagenum
	 * @param  @return    设定文件
	 * @return List<ResourceDynamicsTable>    DOM对象
	 * @throws 
	 * @since  CodingExample　Ver 1.1
	 */
	public List<ResourceDynamicsTable> SearchResourceByLimit(int page,int pagenum) {
		PreparedStatement prepare = null;
		ResultSet query = null;
		Connection conn = DBconnection.getConnection();
		String sql = "select * from resource_dynamics_table   order by rdt_time desc  limit ?,?  ; ";
		try {
			prepare = conn.prepareStatement(sql);
			prepare.setInt(1, (page-1)*pagenum);
			prepare.setInt(2, pagenum);
			query = prepare.executeQuery();
			List<ResourceDynamicsTable> list = new ArrayList<ResourceDynamicsTable>();
			ResourceDynamicsTable dynamicsTable = null;
			while (query.next()) {
				dynamicsTable = new ResourceDynamicsTable();
				dynamicsTable.setRdt_id(query.getInt("rdt_id"));
				dynamicsTable.setRdt_title(query.getString("rdt_title"));
				dynamicsTable.setRdt_info(query.getString("rdt_info"));
				dynamicsTable.setRdt_author(query.getString("rdt_author"));
				dynamicsTable.setRdt_time(query.getDate("rdt_time"));
				

				list.add(dynamicsTable);
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

