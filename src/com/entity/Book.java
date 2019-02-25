package com.entity;

public class Book {
		private String bookISBN;
		private String bookPic;
		private String bookName;
		private String bookAuthor;
		private float  bookPrice;
		private String bookPublish;
		private String bookAbstract;
		private String bookEvaluate;
		public String getBookISBN() {
			return bookISBN;
		}
		public void setBookISBN(String bookISBN) {
			this.bookISBN = bookISBN;
		}
		public String getBookPic() {
			return bookPic;
		}
		public void setBookPic(String bookPic) {
			this.bookPic = bookPic;
		}
		public String getBookName() {
			return bookName;
		}
		public void setBookName(String bookName) {
			this.bookName = bookName;
		}
		public String getBookAuthor() {
			return bookAuthor;
		}
		public void setBookAuthor(String bookAuthor) {
			this.bookAuthor = bookAuthor;
		}
		public float getBookPrice() {
			return bookPrice;
		}
		public void setBookPrice(float bookPrice) {
			this.bookPrice = bookPrice;
		}
		public String getBookPublish() {
			return bookPublish;
		}
		public void setBookPublish(String bookPublish) {
			this.bookPublish = bookPublish;
		}
		public String getBookAbstract() {
			return bookAbstract;
		}
		public void setBookAbstract(String bookAbstract) {
			this.bookAbstract = bookAbstract;
		}
		public String getBookEvaluate() {
			return bookEvaluate;
		}
		public void setBookEvaluate(String bookEvaluate) {
			this.bookEvaluate = bookEvaluate;
		}
		public Book() {
			super();
		}
		public Book(String bookISBN, String bookPic, String bookName, String bookAuthor, float bookPrice,
				String bookPublish, String bookAbstract, String bookEvaluate) {
			super();
			this.bookISBN = bookISBN;
			this.bookPic = bookPic;
			this.bookName = bookName;
			this.bookAuthor = bookAuthor;
			this.bookPrice = bookPrice;
			this.bookPublish = bookPublish;
			this.bookAbstract = bookAbstract;
			this.bookEvaluate = bookEvaluate;
		}
		@Override
		public String toString() {
			return "Book [bookISBN=" + bookISBN + ", bookPic=" + bookPic + ", bookName=" + bookName + ", bookAuthor="
					+ bookAuthor + ", bookPrice=" + bookPrice + ", bookPublish=" + bookPublish + ", bookAbstract="
					+ bookAbstract + ", bookEvaluate=" + bookEvaluate + "]";
		}
		
		
}
