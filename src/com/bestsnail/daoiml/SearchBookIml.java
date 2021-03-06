/**
 * SearchBookIml.java
 * com.bestsnail.daoiml
 *
 * Function： TODO 
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2016年5月3日 		liang
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
import com.bestsnail.bean.LibraryAddressTable;
import com.bestsnail.minterface.dao.SearchBook;
import com.bestsnail.utils.CloseDb;
import com.bestsnail.utils.DBconnection;

/**
 * ClassName:SearchBookIml Function: TODO ADD FUNCTION Reason: TODO ADD REASON
 *
 * @author liang
 * @version
 * @since Ver 1.1
 * @Date 2016年5月3日 下午5:43:30
 *
 * @see
 * 
 */
public class SearchBookIml implements SearchBook {

	@Override
	public List<BookTable> SearchBookList() {
		PreparedStatement prepare = null;
		ResultSet query = null;
		Connection conn = DBconnection.getConnection();
		String sql = "select * from book_table";
		try {
			prepare = conn.prepareStatement(sql);

			query = prepare.executeQuery();
			List<BookTable> list = new ArrayList<BookTable>();
			BookTable bookTable = new BookTable();
			while (query.next()) {
				bookTable = new BookTable();

				bookTable.setBook_id(query.getInt("book_id"));

				bookTable.setLlLibraryAddressTable(sLibAddressById(query.getInt("lc_id")));
				bookTable.setBook_name(query.getString("book_name"));
				bookTable.setBook_author(query.getString("book_author"));
				bookTable.setBook_isbn(query.getString("book_isbn"));
				bookTable.setBook_category_number(query.getString("book_category_number"));
				bookTable.setBook_publishing_house(query.getString("book_publishing_house"));
				bookTable.setBook_publishing_house_time(query.getDate("book_publishing_house_time"));
				bookTable.setBook_price(query.getFloat("book_price"));
				bookTable.setBook_keywords(query.getString("book_keywords"));
				bookTable.setBook_image(query.getString("book_image"));
				bookTable.setBook_cd_down(query.getString("book_cd_down"));
				bookTable.setBook_introduction(query.getString("book_introduction"));
				bookTable.setBook_time(query.getDate("book_time"));

				bookTable.setBook_num(query.getInt("book_num"));
				list.add(bookTable);
			}
			return list;
		} catch (SQLException e) {

			e.printStackTrace();

		} finally {
			CloseDb.close(conn, query, prepare);
		}

		return null;

	}

	// 模糊随机查询用于模仿获得热门图书
	public List<BookTable> SearchBookList(int ii) {
		PreparedStatement prepare = null;
		ResultSet query = null;
		Connection conn = DBconnection.getConnection();
		/*
		 * SELECT * FROM book_table AS r1 JOIN (SELECT ROUND(RAND() * (SELECT
		 * MAX(book_id) FROM book_table)) AS id) AS r2 WHERE r1.id >= r2.id
		 * ORDER BY r1.id ASC LIMIT 5;
		 */
		String sql = "SELECT * FROM book_table ORDER BY rand() LIMIT 9  ";
		try {
			prepare = conn.prepareStatement(sql);

			query = prepare.executeQuery();
			List<BookTable> list = new ArrayList<BookTable>();
			BookTable bookTable = new BookTable();
			while (query.next()) {
				bookTable = new BookTable();

				bookTable.setBook_id(query.getInt("book_id"));

				bookTable.setLlLibraryAddressTable(sLibAddressById(query.getInt("lc_id")));
				bookTable.setBook_name(query.getString("book_name"));
				bookTable.setBook_author(query.getString("book_author"));
				bookTable.setBook_isbn(query.getString("book_isbn"));
				bookTable.setBook_category_number(query.getString("book_category_number"));
				bookTable.setBook_publishing_house(query.getString("book_publishing_house"));
				bookTable.setBook_publishing_house_time(query.getDate("book_publishing_house_time"));
				bookTable.setBook_price(query.getFloat("book_price"));
				bookTable.setBook_keywords(query.getString("book_keywords"));
				bookTable.setBook_image(query.getString("book_image"));
				bookTable.setBook_cd_down(query.getString("book_cd_down"));
				bookTable.setBook_introduction(query.getString("book_introduction"));
				bookTable.setBook_time(query.getDate("book_time"));

				bookTable.setBook_num(query.getInt("book_num"));
				list.add(bookTable);
			}
			return list;
		} catch (SQLException e) {

			e.printStackTrace();

		} finally {
			CloseDb.close(conn, query, prepare);
		}

		return null;

	}

	@Override
	public LibraryAddressTable sLibAddressById(int id) {
		Connection conn = DBconnection.getConnection();
		PreparedStatement statement = null;
		ResultSet executeQuery = null;
		String sql = "select * from library_collection_table where lc_id=?";
		try {
			statement = conn.prepareStatement(sql);
			statement.setInt(1, id);
			executeQuery = statement.executeQuery();
			if (executeQuery.next()) {
				LibraryAddressTable addressTable = new LibraryAddressTable();
				addressTable.setLc_id(id);
				addressTable.setLc_address(executeQuery.getString("lc_address"));
				addressTable.setLc_name(executeQuery.getString("lc_name"));
				return addressTable;
			}

		} catch (SQLException e) {

			//
			e.printStackTrace();

		} finally {
			CloseDb.close(conn, executeQuery, statement);
		}
		return null;

	}

	@Override
	public List<BookTable> DSearchBookListByAll(String searchName, String guancangflag) {
		PreparedStatement prepare = null;
		ResultSet query = null;
		Connection conn = DBconnection.getConnection();
		String sql = "select * from book_table where lc_id=? and book_name LIKE ? ;";
		try {
			prepare = conn.prepareStatement(sql);
			prepare.setString(1, guancangflag);
			prepare.setString(2, "%" + searchName + "%");
			query = prepare.executeQuery();
			List<BookTable> list = new ArrayList<BookTable>();
			BookTable bookTable = new BookTable();
			while (query.next()) {
				bookTable = new BookTable();

				bookTable.setBook_id(query.getInt("book_id"));
				;
				bookTable.setLlLibraryAddressTable(sLibAddressById(query.getInt("lc_id")));
				bookTable.setBook_name(query.getString("book_name"));
				bookTable.setBook_author(query.getString("book_author"));
				bookTable.setBook_isbn(query.getString("book_isbn"));
				bookTable.setBook_category_number(query.getString("book_category_number"));
				bookTable.setBook_publishing_house(query.getString("book_publishing_house"));
				bookTable.setBook_publishing_house_time(query.getDate("book_publishing_house_time"));
				bookTable.setBook_price(query.getFloat("book_price"));
				bookTable.setBook_keywords(query.getString("book_keywords"));
				bookTable.setBook_image(query.getString("book_image"));
				bookTable.setBook_cd_down(query.getString("book_cd_down"));
				bookTable.setBook_introduction(query.getString("book_introduction"));
				bookTable.setBook_time(query.getDate("book_time"));

				bookTable.setBook_num(query.getInt("book_num"));
				list.add(bookTable);
			}
			return list;
		} catch (SQLException e) {

			e.printStackTrace();

		} finally {
			CloseDb.close(conn, query, prepare);
		}

		return null;

	}

	List<BookTable> list = new ArrayList<BookTable>();

	/**
	 * 
	 * DSearchBookListByAll:(快速检索查询与图书名相关的图书)<br/>
	 */
	public List<BookTable> DSearchBookListByName(String searchName) {
		PreparedStatement prepare = null;
		ResultSet query = null;
		Connection conn = DBconnection.getConnection();
		String sql = "select * from book_table where  book_name LIKE ? ;";
		try {
			prepare = conn.prepareStatement(sql);

			prepare.setString(1, "%" + searchName + "%");
			query = prepare.executeQuery();

			BookTable bookTable = new BookTable();
			while (query.next()) {
				bookTable = new BookTable();

				bookTable.setBook_id(query.getInt("book_id"));
				;
				bookTable.setLlLibraryAddressTable(sLibAddressById(query.getInt("lc_id")));
				bookTable.setBook_name(query.getString("book_name"));
				bookTable.setBook_author(query.getString("book_author"));
				bookTable.setBook_isbn(query.getString("book_isbn"));
				bookTable.setBook_category_number(query.getString("book_category_number"));
				bookTable.setBook_publishing_house(query.getString("book_publishing_house"));
				bookTable.setBook_publishing_house_time(query.getDate("book_publishing_house_time"));
				bookTable.setBook_price(query.getFloat("book_price"));
				bookTable.setBook_keywords(query.getString("book_keywords"));
				bookTable.setBook_image(query.getString("book_image"));
				bookTable.setBook_cd_down(query.getString("book_cd_down"));
				bookTable.setBook_introduction(query.getString("book_introduction"));
				bookTable.setBook_time(query.getDate("book_time"));

				bookTable.setBook_num(query.getInt("book_num"));
				if (!list.contains(bookTable)) {
					System.out.println("DSearchBookListByName------" + bookTable.getBook_name());
					this.list.add(bookTable);
				}

			}
			return this.list;
		} catch (SQLException e) {

			e.printStackTrace();

		} finally {
			CloseDb.close(conn, query, prepare);
		}

		return null;

	}

	public List<BookTable> DSearchBookListByAuthor(String searchName) {
		PreparedStatement prepare = null;
		ResultSet query = null;
		Connection conn = DBconnection.getConnection();
		String sql = "select * from book_table where  book_author LIKE ? ;";
		try {
			prepare = conn.prepareStatement(sql);

			prepare.setString(1, "%" + searchName + "%");
			query = prepare.executeQuery();

			BookTable bookTable = new BookTable();
			while (query.next()) {
				bookTable = new BookTable();

				bookTable.setBook_id(query.getInt("book_id"));
				;
				bookTable.setLlLibraryAddressTable(sLibAddressById(query.getInt("lc_id")));
				bookTable.setBook_name(query.getString("book_name"));
				bookTable.setBook_author(query.getString("book_author"));
				bookTable.setBook_isbn(query.getString("book_isbn"));
				bookTable.setBook_category_number(query.getString("book_category_number"));
				bookTable.setBook_publishing_house(query.getString("book_publishing_house"));
				bookTable.setBook_publishing_house_time(query.getDate("book_publishing_house_time"));
				bookTable.setBook_price(query.getFloat("book_price"));
				bookTable.setBook_keywords(query.getString("book_keywords"));
				bookTable.setBook_image(query.getString("book_image"));
				bookTable.setBook_cd_down(query.getString("book_cd_down"));
				bookTable.setBook_introduction(query.getString("book_introduction"));
				bookTable.setBook_time(query.getDate("book_time"));

				bookTable.setBook_num(query.getInt("book_num"));
				if (!list.contains(bookTable)) {
					// System.out.println("DSearchBookListByAuthor------"+bookTable.getBook_name());
					this.list.add(bookTable);
				}
			}
			return this.list;
		} catch (SQLException e) {

			e.printStackTrace();

		} finally {
			CloseDb.close(conn, query, prepare);
		}

		return null;

	}

	public List<BookTable> DSearchBookListByzhutici(String searchName) {
		PreparedStatement prepare = null;
		ResultSet query = null;
		Connection conn = DBconnection.getConnection();
		String sql = "select * from book_table where  book_keywords LIKE ? ;";
		try {
			prepare = conn.prepareStatement(sql);

			prepare.setString(1, "%" + searchName + "%");
			query = prepare.executeQuery();

			BookTable bookTable = new BookTable();
			while (query.next()) {
				bookTable = new BookTable();

				bookTable.setBook_id(query.getInt("book_id"));
				;
				bookTable.setLlLibraryAddressTable(sLibAddressById(query.getInt("lc_id")));
				bookTable.setBook_name(query.getString("book_name"));
				bookTable.setBook_author(query.getString("book_author"));
				bookTable.setBook_isbn(query.getString("book_isbn"));
				bookTable.setBook_category_number(query.getString("book_category_number"));
				bookTable.setBook_publishing_house(query.getString("book_publishing_house"));
				bookTable.setBook_publishing_house_time(query.getDate("book_publishing_house_time"));
				bookTable.setBook_price(query.getFloat("book_price"));
				bookTable.setBook_keywords(query.getString("book_keywords"));
				bookTable.setBook_image(query.getString("book_image"));
				bookTable.setBook_cd_down(query.getString("book_cd_down"));
				bookTable.setBook_introduction(query.getString("book_introduction"));
				bookTable.setBook_time(query.getDate("book_time"));

				bookTable.setBook_num(query.getInt("book_num"));
				if (!list.contains(bookTable)) {
					// System.out.println("DSearchBookListByzhutici------"+bookTable.getBook_name());
					this.list.add(bookTable);
				}
			}
			return this.list;
		} catch (SQLException e) {

			e.printStackTrace();

		} finally {
			CloseDb.close(conn, query, prepare);
		}

		return null;

	}

	public List<BookTable> DSearchBookListByIsbn(String searchName) {
		PreparedStatement prepare = null;
		ResultSet query = null;
		Connection conn = DBconnection.getConnection();
		String sql = "select * from book_table where  book_isbn LIKE ? ;";
		try {
			prepare = conn.prepareStatement(sql);

			prepare.setString(1, "%" + searchName + "%");
			query = prepare.executeQuery();

			BookTable bookTable = new BookTable();
			while (query.next()) {
				bookTable = new BookTable();

				bookTable.setBook_id(query.getInt("book_id"));
				;
				bookTable.setLlLibraryAddressTable(sLibAddressById(query.getInt("lc_id")));
				bookTable.setBook_name(query.getString("book_name"));
				bookTable.setBook_author(query.getString("book_author"));
				bookTable.setBook_isbn(query.getString("book_isbn"));
				bookTable.setBook_category_number(query.getString("book_category_number"));
				bookTable.setBook_publishing_house(query.getString("book_publishing_house"));
				bookTable.setBook_publishing_house_time(query.getDate("book_publishing_house_time"));
				bookTable.setBook_price(query.getFloat("book_price"));
				bookTable.setBook_keywords(query.getString("book_keywords"));
				bookTable.setBook_image(query.getString("book_image"));
				bookTable.setBook_cd_down(query.getString("book_cd_down"));
				bookTable.setBook_introduction(query.getString("book_introduction"));
				bookTable.setBook_time(query.getDate("book_time"));

				bookTable.setBook_num(query.getInt("book_num"));
				if (!list.contains(bookTable)) {
					// System.out.println("DSearchBookListByIsbn------"+bookTable.getBook_name());
					this.list.add(bookTable);
				}
			}
			return this.list;
		} catch (SQLException e) {

			e.printStackTrace();

		} finally {
			CloseDb.close(conn, query, prepare);
		}

		return null;

	}

	/**
	 * 
	 * DSearchBookListByAlle:(查询电子资源通过图书名)<br/>
	 * TODO(这里描述这个方法适用条件 – 可选)<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选)<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选)<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选)<br/>
	 *
	 * @param @param
	 *            searchName
	 * @param @return
	 *            设定文件
	 * @return List<BookTable> DOM对象
	 * @throws @since
	 *             CodingExample Ver 1.1
	 */
	public List<BookTable> DSearchBookListByNamee(String searchName) {
		PreparedStatement prepare = null;
		ResultSet query = null;
		Connection conn = DBconnection.getConnection();
		String sql = "select * from book_table where book_cd_down<>'无' and book_name LIKE ? ;";
		try {
			prepare = conn.prepareStatement(sql);

			prepare.setString(1, "%" + searchName + "%");
			query = prepare.executeQuery();
			BookTable bookTable = new BookTable();
			while (query.next()) {
				bookTable = new BookTable();

				bookTable.setBook_id(query.getInt("book_id"));
				;
				bookTable.setLlLibraryAddressTable(sLibAddressById(query.getInt("lc_id")));
				bookTable.setBook_name(query.getString("book_name"));
				bookTable.setBook_author(query.getString("book_author"));
				bookTable.setBook_isbn(query.getString("book_isbn"));
				bookTable.setBook_category_number(query.getString("book_category_number"));
				bookTable.setBook_publishing_house(query.getString("book_publishing_house"));
				bookTable.setBook_publishing_house_time(query.getDate("book_publishing_house_time"));
				bookTable.setBook_price(query.getFloat("book_price"));
				bookTable.setBook_keywords(query.getString("book_keywords"));
				bookTable.setBook_image(query.getString("book_image"));
				bookTable.setBook_cd_down(query.getString("book_cd_down"));
				bookTable.setBook_introduction(query.getString("book_introduction"));
				bookTable.setBook_time(query.getDate("book_time"));

				bookTable.setBook_num(query.getInt("book_num"));
				if (!list.contains(bookTable)) {
					// System.out.println("DSearchBookListByNamee------"+bookTable.getBook_name());
					this.list.add(bookTable);
				}
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
	 * DSearchBookListByAlle:(查询电子资源通过图书名)<br/>
	 * TODO(这里描述这个方法适用条件 – 可选)<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选)<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选)<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选)<br/>
	 *
	 * @param @param
	 *            searchName
	 * @param @return
	 *            设定文件
	 * @return List<BookTable> DOM对象
	 * @throws @since
	 *             CodingExample Ver 1.1
	 */
	public List<BookTable> DSearchBookListByAuthere(String searchName) {
		PreparedStatement prepare = null;
		ResultSet query = null;
		Connection conn = DBconnection.getConnection();
		String sql = "select * from book_table where book_cd_down<>'无' and book_author LIKE ? ;";
		try {
			prepare = conn.prepareStatement(sql);

			prepare.setString(1, "%" + searchName + "%");
			query = prepare.executeQuery();
			BookTable bookTable = new BookTable();
			while (query.next()) {
				bookTable = new BookTable();

				bookTable.setBook_id(query.getInt("book_id"));
				;
				bookTable.setLlLibraryAddressTable(sLibAddressById(query.getInt("lc_id")));
				bookTable.setBook_name(query.getString("book_name"));
				bookTable.setBook_author(query.getString("book_author"));
				bookTable.setBook_isbn(query.getString("book_isbn"));
				bookTable.setBook_category_number(query.getString("book_category_number"));
				bookTable.setBook_publishing_house(query.getString("book_publishing_house"));
				bookTable.setBook_publishing_house_time(query.getDate("book_publishing_house_time"));
				bookTable.setBook_price(query.getFloat("book_price"));
				bookTable.setBook_keywords(query.getString("book_keywords"));
				bookTable.setBook_image(query.getString("book_image"));
				bookTable.setBook_cd_down(query.getString("book_cd_down"));
				bookTable.setBook_introduction(query.getString("book_introduction"));
				bookTable.setBook_time(query.getDate("book_time"));

				bookTable.setBook_num(query.getInt("book_num"));
				if (!list.contains(bookTable)) {
					this.list.add(bookTable);
				}
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
	 * DSearchBookListByAlle:(查询电子资源通过图书名)<br/>
	 * TODO(这里描述这个方法适用条件 – 可选)<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选)<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选)<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选)<br/>
	 *
	 * @param @param
	 *            searchName
	 * @param @return
	 *            设定文件
	 * @return List<BookTable> DOM对象
	 * @throws @since
	 *             CodingExample Ver 1.1
	 */
	public List<BookTable> DSearchBookListByguanjianzie(String searchName) {
		PreparedStatement prepare = null;
		ResultSet query = null;
		Connection conn = DBconnection.getConnection();
		String sql = "select * from book_table where book_cd_down<>'无' and book_keywords LIKE ? ;";
		try {
			prepare = conn.prepareStatement(sql);

			prepare.setString(1, "%" + searchName + "%");
			query = prepare.executeQuery();
			BookTable bookTable = new BookTable();
			while (query.next()) {
				bookTable = new BookTable();

				bookTable.setBook_id(query.getInt("book_id"));
				;
				bookTable.setLlLibraryAddressTable(sLibAddressById(query.getInt("lc_id")));
				bookTable.setBook_name(query.getString("book_name"));
				bookTable.setBook_author(query.getString("book_author"));
				bookTable.setBook_isbn(query.getString("book_isbn"));
				bookTable.setBook_category_number(query.getString("book_category_number"));
				bookTable.setBook_publishing_house(query.getString("book_publishing_house"));
				bookTable.setBook_publishing_house_time(query.getDate("book_publishing_house_time"));
				bookTable.setBook_price(query.getFloat("book_price"));
				bookTable.setBook_keywords(query.getString("book_keywords"));
				bookTable.setBook_image(query.getString("book_image"));
				bookTable.setBook_cd_down(query.getString("book_cd_down"));
				bookTable.setBook_introduction(query.getString("book_introduction"));
				bookTable.setBook_time(query.getDate("book_time"));

				bookTable.setBook_num(query.getInt("book_num"));
				if (!list.contains(bookTable)) {
					this.list.add(bookTable);
				}
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
	 * DSearchBookListByAlle:(查询电子资源通过图书名)<br/>
	 * TODO(这里描述这个方法适用条件 – 可选)<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选)<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选)<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选)<br/>
	 *
	 * @param @param
	 *            searchName
	 * @param @return
	 *            设定文件
	 * @return List<BookTable> DOM对象
	 * @throws @since
	 *             CodingExample Ver 1.1
	 */
	public List<BookTable> DSearchBookListByIsbne(String searchName) {
		PreparedStatement prepare = null;
		ResultSet query = null;
		Connection conn = DBconnection.getConnection();
		String sql = "select * from book_table where book_cd_down<>'无' and book_isbn LIKE ? ;";
		try {
			prepare = conn.prepareStatement(sql);

			prepare.setString(1, "%" + searchName + "%");
			query = prepare.executeQuery();
			BookTable bookTable = new BookTable();
			while (query.next()) {
				bookTable = new BookTable();

				bookTable.setBook_id(query.getInt("book_id"));
				;
				bookTable.setLlLibraryAddressTable(sLibAddressById(query.getInt("lc_id")));
				bookTable.setBook_name(query.getString("book_name"));
				bookTable.setBook_author(query.getString("book_author"));
				bookTable.setBook_isbn(query.getString("book_isbn"));
				bookTable.setBook_category_number(query.getString("book_category_number"));
				bookTable.setBook_publishing_house(query.getString("book_publishing_house"));
				bookTable.setBook_publishing_house_time(query.getDate("book_publishing_house_time"));
				bookTable.setBook_price(query.getFloat("book_price"));
				bookTable.setBook_keywords(query.getString("book_keywords"));
				bookTable.setBook_image(query.getString("book_image"));
				bookTable.setBook_cd_down(query.getString("book_cd_down"));
				bookTable.setBook_introduction(query.getString("book_introduction"));
				bookTable.setBook_time(query.getDate("book_time"));

				bookTable.setBook_num(query.getInt("book_num"));
				if (!list.contains(bookTable)) {
					this.list.add(bookTable);
				}
			}
			return list;
		} catch (SQLException e) {

			e.printStackTrace();

		} finally {
			CloseDb.close(conn, query, prepare);
		}

		return null;

	}

	@Override
	public List<BookTable> DSearchBookListByTiming(String searchName, String guancangflag) {

		PreparedStatement prepare = null;
		ResultSet query = null;
		Connection conn = DBconnection.getConnection();
		String sql = "select * from book_table where lc_id=? " + "and book_name LIKE ? ";
		try {
			prepare = conn.prepareStatement(sql);
			prepare.setString(1, guancangflag);
			prepare.setString(2, "%" + searchName + "%");
			query = prepare.executeQuery();
			List<BookTable> list = new ArrayList<BookTable>();
			BookTable bookTable = new BookTable();
			while (query.next()) {
				bookTable = new BookTable();

				bookTable.setBook_id(query.getInt("book_id"));

				bookTable.setLlLibraryAddressTable(sLibAddressById(query.getInt("lc_id")));
				bookTable.setBook_name(query.getString("book_name"));
				bookTable.setBook_author(query.getString("book_author"));
				bookTable.setBook_isbn(query.getString("book_isbn"));
				bookTable.setBook_category_number(query.getString("book_category_number"));
				bookTable.setBook_publishing_house(query.getString("book_publishing_house"));
				bookTable.setBook_publishing_house_time(query.getDate("book_publishing_house_time"));
				bookTable.setBook_price(query.getFloat("book_price"));
				bookTable.setBook_keywords(query.getString("book_keywords"));
				bookTable.setBook_image(query.getString("book_image"));
				bookTable.setBook_cd_down(query.getString("book_cd_down"));
				bookTable.setBook_introduction(query.getString("book_introduction"));
				bookTable.setBook_time(query.getDate("book_time"));

				bookTable.setBook_num(query.getInt("book_num"));
				list.add(bookTable);
			}
			return list;
		} catch (SQLException e) {

			e.printStackTrace();

		} finally {
			CloseDb.close(conn, query, prepare);
		}

		return null;

	}

	@Override
	public List<BookTable> DSearchBookListByzuozhe(String searchName, String guancangflag) {

		PreparedStatement prepare = null;
		ResultSet query = null;
		Connection conn = DBconnection.getConnection();
		String sql = "select * from book_table where lc_id=? and book_author LIKE ? ;";
		try {
			prepare = conn.prepareStatement(sql);
			prepare.setString(1, guancangflag);
			prepare.setString(2, "%" + searchName + "%");
			query = prepare.executeQuery();
			List<BookTable> list = new ArrayList<BookTable>();
			BookTable bookTable = new BookTable();
			while (query.next()) {
				bookTable = new BookTable();

				bookTable.setBook_id(query.getInt("book_id"));
				;
				bookTable.setLlLibraryAddressTable(sLibAddressById(query.getInt("lc_id")));
				bookTable.setBook_name(query.getString("book_name"));
				bookTable.setBook_author(query.getString("book_author"));
				bookTable.setBook_isbn(query.getString("book_isbn"));
				bookTable.setBook_category_number(query.getString("book_category_number"));
				bookTable.setBook_publishing_house(query.getString("book_publishing_house"));
				bookTable.setBook_publishing_house_time(query.getDate("book_publishing_house_time"));
				bookTable.setBook_price(query.getFloat("book_price"));
				bookTable.setBook_keywords(query.getString("book_keywords"));
				bookTable.setBook_image(query.getString("book_image"));
				bookTable.setBook_cd_down(query.getString("book_cd_down"));
				bookTable.setBook_introduction(query.getString("book_introduction"));
				bookTable.setBook_time(query.getDate("book_time"));

				bookTable.setBook_num(query.getInt("book_num"));
				list.add(bookTable);
			}
			return list;
		} catch (SQLException e) {

			e.printStackTrace();

		} finally {
			CloseDb.close(conn, query, prepare);
		}

		return null;

	}

	@Override
	public List<BookTable> DSearchBookListByzhutici(String searchName, String guancangflag) {

		PreparedStatement prepare = null;
		ResultSet query = null;
		Connection conn = DBconnection.getConnection();
		String sql = "select * from book_table where lc_id=? and book_name LIKE ? ;";
		try {
			prepare = conn.prepareStatement(sql);
			prepare.setString(1, guancangflag);
			prepare.setString(2, "%" + searchName + "%");
			query = prepare.executeQuery();
			List<BookTable> list = new ArrayList<BookTable>();
			BookTable bookTable = new BookTable();
			while (query.next()) {
				bookTable = new BookTable();
				// book_id

				//

				bookTable.setBook_id(query.getInt("book_id"));
				;
				bookTable.setLlLibraryAddressTable(sLibAddressById(query.getInt("lc_id")));
				bookTable.setBook_name(query.getString("book_name"));
				bookTable.setBook_author(query.getString("book_author"));
				String isbn = query.getString("book_isbn");
				bookTable.setBook_isbn(isbn);
				bookTable.setBook_borrow_num(DQueryBorrowBokkNum(isbn));
				bookTable.setBook_category_number(query.getString("book_category_number"));
				bookTable.setBook_publishing_house(query.getString("book_publishing_house"));
				bookTable.setBook_publishing_house_time(query.getDate("book_publishing_house_time"));
				bookTable.setBook_price(query.getFloat("book_price"));
				bookTable.setBook_keywords(query.getString("book_keywords"));
				bookTable.setBook_image(query.getString("book_image"));
				bookTable.setBook_cd_down(query.getString("book_cd_down"));
				bookTable.setBook_introduction(query.getString("book_introduction"));
				bookTable.setBook_time(query.getDate("book_time"));

				bookTable.setBook_num(query.getInt("book_num"));
				list.add(bookTable);
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
	 * DSearchBookByISBN:(通过isbn号查询图书)<br/>
	 *
	 * @param @param
	 *            isbn
	 * @param @return
	 *            设定文件
	 * @return BookTable DOM对象
	 * @throws @since
	 *             CodingExample Ver 1.1
	 */
	public BookTable DSearchBookByISBN(String isbn) {

		PreparedStatement prepare = null;
		ResultSet query = null;
		Connection conn = DBconnection.getConnection();
		String sql = "select * from book_table where book_isbn=?  ;";
		try {
			prepare = conn.prepareStatement(sql);
			prepare.setString(1, isbn);
			query = prepare.executeQuery();
			BookTable bookTable = new BookTable();
			if (query.next()) {
				bookTable = new BookTable();
				// book_id

				//

				bookTable.setBook_id(query.getInt("book_id"));
				;
				bookTable.setLlLibraryAddressTable(sLibAddressById(query.getInt("lc_id")));
				bookTable.setBook_name(query.getString("book_name"));
				bookTable.setBook_author(query.getString("book_author"));

				bookTable.setBook_isbn(isbn);
				bookTable.setBook_borrow_num(DQueryBorrowBokkNum(isbn));
				bookTable.setBook_category_number(query.getString("book_category_number"));
				bookTable.setBook_publishing_house(query.getString("book_publishing_house"));
				bookTable.setBook_publishing_house_time(query.getDate("book_publishing_house_time"));
				bookTable.setBook_price(query.getFloat("book_price"));
				bookTable.setBook_keywords(query.getString("book_keywords"));
				bookTable.setBook_image(query.getString("book_image"));
				bookTable.setBook_cd_down(query.getString("book_cd_down"));
				bookTable.setBook_introduction(query.getString("book_introduction"));
				bookTable.setBook_time(query.getDate("book_time"));

				bookTable.setBook_num(query.getInt("book_num"));

			}
			return bookTable;
		} catch (SQLException e) {

			e.printStackTrace();

		} finally {
			CloseDb.close(conn, query, prepare);
		}

		return null;

	}

	public BookTable DSearchBookByISBNe(String isbn) {

		PreparedStatement prepare = null;
		ResultSet query = null;
		Connection conn = DBconnection.getConnection();
		String sql = "select * from book_table where book_isbn=? and book_cd_down<>'无' ;";
		try {
			prepare = conn.prepareStatement(sql);
			prepare.setString(1, isbn);
			query = prepare.executeQuery();
			BookTable bookTable = new BookTable();
			if (query.next()) {
				bookTable = new BookTable();
				// book_id

				//

				bookTable.setBook_id(query.getInt("book_id"));
				;
				bookTable.setLlLibraryAddressTable(sLibAddressById(query.getInt("lc_id")));
				bookTable.setBook_name(query.getString("book_name"));
				bookTable.setBook_author(query.getString("book_author"));

				bookTable.setBook_isbn(isbn);
				bookTable.setBook_borrow_num(DQueryBorrowBokkNum(isbn));
				bookTable.setBook_category_number(query.getString("book_category_number"));
				bookTable.setBook_publishing_house(query.getString("book_publishing_house"));
				bookTable.setBook_publishing_house_time(query.getDate("book_publishing_house_time"));
				bookTable.setBook_price(query.getFloat("book_price"));
				bookTable.setBook_keywords(query.getString("book_keywords"));
				bookTable.setBook_image(query.getString("book_image"));
				bookTable.setBook_cd_down(query.getString("book_cd_down"));
				bookTable.setBook_introduction(query.getString("book_introduction"));
				bookTable.setBook_time(query.getDate("book_time"));

				bookTable.setBook_num(query.getInt("book_num"));

			}
			return bookTable;
		} catch (SQLException e) {

			e.printStackTrace();

		} finally {
			CloseDb.close(conn, query, prepare);
		}

		return null;

	}

	/**
	 * 
	 * DSearchBookByid:(通过Id查询图书)<br/>
	 *
	 * @param @param
	 *            id
	 * @param @return
	 *            设定文件
	 * @return BookTable DOM对象
	 * @throws @since
	 *             CodingExample Ver 1.1
	 */
	public BookTable DSearchBookByid(String book_id) {

		PreparedStatement prepare = null;
		ResultSet query = null;
		Connection conn = DBconnection.getConnection();
		String sql = "select * from book_table where book_id=?  ;";
		try {
			prepare = conn.prepareStatement(sql);
			prepare.setString(1, book_id);
			query = prepare.executeQuery();
			BookTable bookTable = new BookTable();
			if (query.next()) {
				bookTable = new BookTable();
				// book_id

				//

				bookTable.setBook_id(query.getInt("book_id"));
				;
				bookTable.setLlLibraryAddressTable(sLibAddressById(query.getInt("lc_id")));
				bookTable.setBook_name(query.getString("book_name"));
				bookTable.setBook_author(query.getString("book_author"));
				String isbn = query.getString("book_isbn");
				bookTable.setBook_isbn(isbn);
				// 通过ISBN号查询已借图书
				bookTable.setBook_borrow_num(DQueryBorrowBokkNum(isbn));

				bookTable.setBook_category_number(query.getString("book_category_number"));
				bookTable.setBook_publishing_house(query.getString("book_publishing_house"));
				bookTable.setBook_publishing_house_time(query.getDate("book_publishing_house_time"));
				bookTable.setBook_price(query.getFloat("book_price"));
				bookTable.setBook_keywords(query.getString("book_keywords"));
				bookTable.setBook_image(query.getString("book_image"));
				bookTable.setBook_cd_down(query.getString("book_cd_down"));
				bookTable.setBook_introduction(query.getString("book_introduction"));
				bookTable.setBook_time(query.getDate("book_time"));

				bookTable.setBook_num(query.getInt("book_num"));

			}
			return bookTable;
		} catch (SQLException e) {

			e.printStackTrace();

		} finally {
			CloseDb.close(conn, query, prepare);
		}

		return null;

	}

	private int DQueryBorrowBokkNum(String isbn) {
		PreparedStatement prepare = null;
		ResultSet query = null;
		Connection conn = DBconnection.getConnection();
		String sql = "select count(*) from book_table where book_isbn=? ;";
		try {
			prepare = conn.prepareStatement(sql);
			prepare.setString(1, isbn);

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

	@Override
	public List<BookTable> kuaisuSearchBook(String searchName) {

		DSearchBookListByName(searchName);
		DSearchBookListByIsbn(searchName);
		DSearchBookListByAuthor(searchName);
		DSearchBookListByzhutici(searchName);
		return list;

	}

	@Override
	public List<BookTable> SearcheBookList(String searchName) {
		
		
		  DSearchBookListByNamee(searchName);
		 DSearchBookListByAuthere(searchName);
		 DSearchBookListByguanjianzie(searchName);
		 DSearchBookListByIsbne(searchName);

		return list;

		
	}

}
