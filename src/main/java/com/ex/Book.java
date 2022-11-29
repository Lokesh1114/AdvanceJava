package com.ex;

public class Book {
private String Bname;
private int pages;
private int  price;
private String author;
public String getBname() {
	return Bname;
}
public void setBname(String bname) {
	Bname = bname;
}
public int getPages() {
	return pages;
}
public void setPages(int pages) {
	this.pages = pages;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public String getAuthor() {
	return author;
}
public void setAuthor(String category) {
	this.author = category;
}
}
