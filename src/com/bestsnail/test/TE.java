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

import org.junit.Test;

import com.bestsnail.daoiml.BookRecommendDaoIml;
import com.bestsnail.daoiml.BorrowingDaoIml;
import com.bestsnail.daoiml.SearchLectures;

/**
 * ClassName:TE Function: TODO ADD FUNCTION Reason: TODO ADD REASON
 *
 * @author liang
 * @version
 * @since Ver 1.1
 * @Date 2016年5月4日 下午8:31:32
 *
 * @see
 * 
 */
public class TE {
	@Test
	public void Testma() {
	System.out.println(	new BookRecommendDaoIml().saveBookRecommend(1+"", "aa", "aa", "123465798", "456465") );
	}

}
