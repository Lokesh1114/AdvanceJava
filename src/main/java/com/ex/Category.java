package com.ex;

public class Category {
private String category;
private Book bk;
public Category(Book bk) {
	super();
	this.bk = bk;
}
public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}
void show() {
	System.out.println(bk.getBname()+" "+bk.getAuthor()+" "+bk.getPages()+" "+bk.getPrice());
}
//public Book getBk() {
//	return bk;
//}
//public void setBk(Book bk) {
//	this.bk = bk;
//}
}
