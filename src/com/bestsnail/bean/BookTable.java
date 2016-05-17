package com.bestsnail.bean;

import java.util.Date;

/**
 * 
 * ClassName:BookTable<br/>
 * 
 * Function: TODO ADD FUNCTION<br/>
 * 
 * Reason: TODO ADD REASON<br/>
 *
 * @author liang
 * @version
 * @since Ver 1.1
 * @Date 2016 2016年5月2日 下午4:39:39
 *
 * @see
 */
public class BookTable {

	private int book_id;
	private LibraryAddressTable llLibraryAddressTable;
	private String book_name;
	private String book_author;
	private String book_isbn;
	private String book_category_number;
	private String book_publishing_house;
	private Date book_publishing_house_time;
	private float book_price;
	private String book_keywords;
	private String book_image;
	private String book_cd_down;
	private String book_introduction;
	private Date book_time;
	private int book_num;
	private int book_borrow_num;

	public int getBook_id() {
		return book_id;
	}

	public int getBook_borrow_num() {
		return book_borrow_num;
	}

	public void setBook_borrow_num(int book_borrow_num) {
		this.book_borrow_num = book_borrow_num;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

	public String getBook_name() {
		return book_name;
	}

	public BookTable() {
		super();
	}

	public BookTable(int book_id, LibraryAddressTable llLibraryAddressTable, String book_name, String book_author,
			String book_isbn, String book_category_number, String book_publishing_house,
			Date book_publishing_house_time, float book_price, String book_keywords, String book_image,
			String book_cd_down, String book_introduction, Date book_time, int book_num) {
		super();
		this.book_id = book_id;
		this.llLibraryAddressTable = llLibraryAddressTable;
		this.book_name = book_name;
		this.book_author = book_author;
		this.book_isbn = book_isbn;
		this.book_category_number = book_category_number;
		this.book_publishing_house = book_publishing_house;
		this.book_publishing_house_time = book_publishing_house_time;
		this.book_price = book_price;
		this.book_keywords = book_keywords;
		this.book_image = book_image;
		this.book_cd_down = book_cd_down;
		this.book_introduction = book_introduction;
		this.book_time = book_time;
		this.book_num = book_num;
	}

	public LibraryAddressTable getLlLibraryAddressTable() {
		return llLibraryAddressTable;
	}

	public void setLlLibraryAddressTable(LibraryAddressTable llLibraryAddressTable) {
		this.llLibraryAddressTable = llLibraryAddressTable;
	}

	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}

	public String getBook_author() {
		return book_author;
	}

	public void setBook_author(String book_author) {
		this.book_author = book_author;
	}

	public String getBook_isbn() {
		return book_isbn;
	}

	public void setBook_isbn(String book_isbn) {
		this.book_isbn = book_isbn;
	}

	public String getBook_category_number() {
		return book_category_number;
	}

	public void setBook_category_number(String book_category_number) {
		this.book_category_number = book_category_number;
	}

	public String getBook_publishing_house() {
		return book_publishing_house;
	}

	public void setBook_publishing_house(String book_publishing_house) {
		this.book_publishing_house = book_publishing_house;
	}

	public Date getBook_publishing_house_time() {
		return book_publishing_house_time;
	}

	public void setBook_publishing_house_time(Date book_publishing_house_time) {
		this.book_publishing_house_time = book_publishing_house_time;
	}

	public float getBook_price() {
		return book_price;
	}

	public void setBook_price(float book_price) {
		this.book_price = book_price;
	}

	public String getBook_keywords() {
		return book_keywords;
	}

	public void setBook_keywords(String book_keywords) {
		this.book_keywords = book_keywords;
	}

	public String getBook_image() {
		return book_image;
	}

	public void setBook_image(String book_image) {
		this.book_image = book_image;
	}

	public String getBook_cd_down() {
		return book_cd_down;
	}

	public void setBook_cd_down(String book_cd_down) {
		this.book_cd_down = book_cd_down;
	}

	public String getBook_introduction() {
		return book_introduction;
	}

	public void setBook_introduction(String book_introduction) {
		this.book_introduction = book_introduction;
	}

	public Date getBook_time() {
		return book_time;
	}

	public void setBook_time(Date book_time) {
		this.book_time = book_time;
	}

	public int getBook_num() {
		return book_num;
	}

	public void setBook_num(int book_num) {
		this.book_num = book_num;
	}
	@Override
    public boolean equals(Object obj) {
        if (obj instanceof BookTable) {
            BookTable name = (BookTable) obj;
            return (book_id == name.book_id);
        }
        return false;
    }

    public int hashCode() {
        return book_id + "".hashCode();

    }
}
