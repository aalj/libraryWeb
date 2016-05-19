package com.bestsnail.daoiml;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.util.Date;

import com.bestsnail.utils.DBconnection;

public class SavbookDao {
	public boolean addCoupon(String name,String isbn,String suo,String zuozhe,String chubanshe,String dizhi){
		// 1、连数据库
				PreparedStatement prep = null;
				Connection conn = null;
				try {
					conn = DBconnection.getConnection();
					// 2、SQL语句
					String sql = "insert into book_table (book_name,book_isbn,book_category_number,book_time,book_author,book_publishing_house,lc_id)" + "values (?,?,?,?,?,?,?)";
					// 3、获得preparedStatement对象
					prep = conn.prepareStatement(sql);
					// 4、设置？的值
					//sto_id,cou_info,cou_num,cou_Validity,cou_redeem_points,cou_name,cou_price
					//
					prep.setString(1, name);
					prep.setString(2, isbn);
					
					prep.setString(3, suo);
					prep.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
					prep.setString(5, zuozhe);
					prep.setString(6, chubanshe);
					prep.setString(7, dizhi);
					// 5、执行sql语句
					int executeUpdate = prep.executeUpdate();
					if(executeUpdate>0){
						return true;
					}
				} catch (Exception e) {
					// 一定要处理异常,异常的信息要存在日志文件
					// 转化为应用程序的异常，再抛出
					throw new RuntimeException(e);
				} finally {
					// 6、关闭资源
					try {
						if (prep != null)
							prep.close();
						if (conn != null)
							conn.close();
					} catch (Exception e) {
						throw new RuntimeException(e);
					}
				}
				return false;
			}

	
	
	
	
}
