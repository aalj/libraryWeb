/**
 * SearchBookSiml.java
 * com.bestsnail.serviceiml
 *
 * Function： TODO 
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2016年5月3日 		liang
 *
 * Copyright (c) 2016, TNT All Rights Reserved.
*/

package com.bestsnail.serviceiml;

import java.util.List;

import com.bestsnail.bean.BookTable;
import com.bestsnail.minterface.dao.SearchBook;
import com.bestsnail.minterface.service.SearchBookS;

/**
 * ClassName:SearchBookSiml Function: TODO ADD FUNCTION Reason: TODO ADD REASON
 *
 * @author liang
 * @version
 * @since Ver 1.1
 * @Date 2016年5月3日 下午7:28:05
 *
 * @see
 * 
 */
public class SearchBookSiml implements SearchBookS {
	SearchBook sea = null;

	public SearchBookSiml(SearchBook sea) {

		this.sea = sea;
	}

	@Override
	public List<BookTable> SearchBookSiml() {
		return sea.SearchBookList();

	}

	@Override
	public List<BookTable> SearchBookSimlByAll(String searchName) {

		return sea.DSearchBookListByAll(searchName);

	}

	@Override
	public List<BookTable> SearchBookSimlByTiming(String searchName) {

		return sea.DSearchBookListByTiming(searchName);

	}

	@Override
	public List<BookTable> SearchBookSimlByzuozhe(String searchName) {

		return sea.DSearchBookListByzuozhe(searchName);

	}

	@Override
	public List<BookTable> SearchBookSimlByzhutuci(String searchName) {

		return sea.DSearchBookListByzhutici(searchName);

	}

}
