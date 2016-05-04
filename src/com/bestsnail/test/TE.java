/**
 * TE.java
 * com.bestsnail.test
 *
 * Function： TODO 
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2016年5月4日 		liang
 *
 * Copyright (c) 2016, TNT All Rights Reserved.
*/

package com.bestsnail.test;

import java.util.List;

import org.junit.Test;

import com.bestsnail.bean.BookTable;
import com.bestsnail.daoiml.SearchBookIml;

/**
 * ClassName:TE
 * Function: TODO ADD FUNCTION
 * Reason:	 TODO ADD REASON
 *
 * @author   liang
 * @version  
 * @since    Ver 1.1
 * @Date	 2016年5月4日		下午8:31:32
 *
 * @see 	 

 */
public class TE {
	@Test
	public void Testma(){
		List<BookTable> dSearchBookListByTiming = new SearchBookIml().DSearchBookListByTiming("鼠标");
		System.out.println(dSearchBookListByTiming.get(0).getBook_name());
	}

}

