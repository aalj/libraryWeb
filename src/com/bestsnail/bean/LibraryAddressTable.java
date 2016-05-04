/**
 * LibraryAddressTable.java
 * com.bestsnail.bean
 *
 * Function： TODO 
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2016年5月2日 		liang
 *
 * Copyright (c) 2016, TNT All Rights Reserved.
*/

package com.bestsnail.bean;

/**
 * ClassName:LibraryAddressTable Function: TODO ADD FUNCTION Reason: TODO ADD
 * REASON
 *
 * @author liang
 * @version
 * @since Ver 1.1
 * @Date 2016年5月2日 下午4:43:32
 *
 * @see
 * 
 */
public class LibraryAddressTable {
	public LibraryAddressTable() {
		super();
	}

	public LibraryAddressTable(int lc_id, String lc_name, String lc_address) {
		super();
		this.lc_id = lc_id;
		this.lc_name = lc_name;
		this.lc_address = lc_address;
	}

	public int getLc_id() {
		return lc_id;
	}

	public void setLc_id(int lc_id) {
		this.lc_id = lc_id;
	}

	public String getLc_name() {
		return lc_name;
	}

	public void setLc_name(String lc_name) {
		this.lc_name = lc_name;
	}

	public String getLc_address() {
		return lc_address;
	}

	public void setLc_address(String lc_address) {
		this.lc_address = lc_address;
	}

	private int lc_id;
	private String lc_name;
	private String lc_address;

}
