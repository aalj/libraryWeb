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
	public List<BookTable> SearchBookSimlByAll(String searchName,String guancangflag) {

		return sea.DSearchBookListByAll(searchName,guancangflag);

	}

	@Override
	public List<BookTable> SearchBookSimlByTiming(String searchName,String guancangflag) {

		return sea.DSearchBookListByTiming(searchName,guancangflag);

	}

	@Override
	public List<BookTable> SearchBookSimlByzuozhe(String searchName,String guancangflag) {

		return sea.DSearchBookListByzuozhe(searchName,guancangflag);

	}

	@Override
	public List<BookTable> SearchBookSimlByzhutuci(String searchName,String guancangflag) {

		return sea.DSearchBookListByzhutici(searchName,guancangflag);

	}

}
