/**
 * SearchBook.java
 * com.bestsnail.minterface.service
 *
 * Function： TODO 
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2016年5月3日 		liang
 *
 * Copyright (c) 2016, TNT All Rights Reserved.
*/

package com.bestsnail.minterface.service;

import java.util.List;

import com.bestsnail.bean.BookTable;

/**
 * ClassName:SearchBook
 * Function: TODO ADD FUNCTION
 * Reason:	 TODO ADD REASON
 *
 * @author   liang
 * @version  
 * @since    Ver 1.1
 * @Date	 2016年5月3日		下午6:56:27
 *
 * @see 	 

 */
public interface SearchBookS {
	/**
	 * 
	 * SearchBookSiml:(搜索图书
	 * )<br/>
	 * TODO(这里描述这个方法适用条件 – 可选)<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选)<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选)<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选)<br/>
	 *
	 * @param  @return    设定文件
	 * @return List<BookTable>    DOM对象
	 * @throws 
	 * @since  CodingExample　Ver 1.1
	 */
	public List<BookTable> SearchBookSiml(); 
	public List<BookTable> SearchBookSimlByAll(String searchName);
	public List<BookTable> SearchBookSimlByTiming(String searchName);
	public List<BookTable> SearchBookSimlByzuozhe(String searchName);
	public List<BookTable> SearchBookSimlByzhutuci(String searchName);

}

