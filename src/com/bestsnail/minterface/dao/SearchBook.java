/**
 * SearchBook.java
 * com.bestsnail.minterface.dao
 *
 * Function： TODO 
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2016年5月3日 		liang
 *
 * Copyright (c) 2016, TNT All Rights Reserved.
*/

package com.bestsnail.minterface.dao;

import java.util.List;

import com.bestsnail.bean.BookTable;
import com.bestsnail.bean.LibraryAddressTable;

/**
 * ClassName:SearchBook Function: TODO ADD FUNCTION Reason: TODO ADD REASON
 *
 * @author liang
 * @version
 * @since Ver 1.1
 * @Date 2016年5月3日 下午5:40:34
 *
 * @see
 * 
 */
public interface SearchBook {

	/**
	 * 
	 * SearchBookList:(查询全部的图书，这只是有个测试方法，后期不能采用)<br/>
	 * TODO(这里描述这个方法适用条件 – 可选)<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选)<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选)<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选)<br/>
	 *
	 * @param @return
	 *            设定文件
	 * @return List<BookTable> DOM对象
	 * @throws @since
	 *             CodingExample Ver 1.1
	 */
	public List<BookTable> SearchBookList();

	public LibraryAddressTable sLibAddressById(int id);

	public List<BookTable> DSearchBookListByAll(String searchName,String guancangflag);

	public List<BookTable> DSearchBookListByTiming(String searchName,String guancangflag);

	public List<BookTable> DSearchBookListByzuozhe(String searchName,String guancangflag);

	public List<BookTable> DSearchBookListByzhutici(String searchName,String guancangflag);
	
//	public List<BookTable> DSearchBookListByName(String searchName);
//	public List<BookTable> DSearchBookListByAuthor(String searchName);
//	public List<BookTable> DSearchBookListByzhutici(String searchName);
//	public List<BookTable> DSearchBookListByIsbn(String searchName);
	public List<BookTable> kuaisuSearchBook(String searchName);
	
	
	public List<BookTable> SearcheBookList(String searchName) ;
//	public List<BookTable> DSearchBookListByNamee(String searchName) ;
//	public List<BookTable> DSearchBookListByAuthere(String searchName) ;
//	public List<BookTable> DSearchBookListByguanjianzie(String searchName) ;
//	public List<BookTable> DSearchBookListByIsbne(String searchName) ;
}
