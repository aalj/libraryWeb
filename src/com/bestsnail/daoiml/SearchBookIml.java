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
	public List<BookTable> DSearchBookListByAll(String searchName) {
		PreparedStatement prepare = null;
		ResultSet query = null;
		Connection conn = DBconnection.getConnection();
		String sql = "select * from book_table where book_name LIKE '%"+searchName+"%' ";
		try {
			System.out.println("chauxn quanbu ");
			prepare = conn.prepareStatement(sql);

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
	public List<BookTable> DSearchBookListByTiming(String searchName) {

		PreparedStatement prepare = null;
		ResultSet query = null;
		Connection conn = DBconnection.getConnection();
		String sql = "select * from book_table where book_name LIKE '%"+searchName+"%'";
		try {
			prepare = conn.prepareStatement(sql);
//			prepare.setString(1, searchName);
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
	public List<BookTable> DSearchBookListByzuozhe(String searchName) {

		PreparedStatement prepare = null;
		ResultSet query = null;
		Connection conn = DBconnection.getConnection();
		String sql = "select * from book_table where  book_author LIKE '%"+searchName+"%';";
		try {
			prepare = conn.prepareStatement(sql);

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
	public List<BookTable> DSearchBookListByzhutici(String searchName) {

		PreparedStatement prepare = null;
		ResultSet query = null;
		Connection conn = DBconnection.getConnection();
		String sql = "select * from book_table where book_name LIKE '%"+searchName+"%'";
		try {
			prepare = conn.prepareStatement(sql);

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

}