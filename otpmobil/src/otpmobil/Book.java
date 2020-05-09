package otpmobil;

import java.time.LocalDateTime;

public class Book extends Item {
	
	private static int Id;
	public static int getId() {
		return Id;
	}
	public static void setId(int id) {
		Id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Book(double price, String title, String publisher, String author, int yearOfPublishing,
			String genre, int isbn, int numberOfPages, int weight) {
		super(price);
		this.title = title;
		this.publisher = publisher;
		this.author = author;
		this.yearOfPublishing = yearOfPublishing;
		this.genre = genre;
		this.isbn = isbn;
		this.numberOfPages = numberOfPages;
		this.weight = weight;
	}
	public int getYearOfPublishing() {
		return yearOfPublishing;
	}
	public void setDateOfPublishing(int yearOfPublishing) {
		this.yearOfPublishing = yearOfPublishing;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	public int getNumberOfPages() {
		return numberOfPages;
	}
	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	private String title;
	private String publisher;
	private String author;
	private int yearOfPublishing;
	private String genre;
	private int isbn;
	private int numberOfPages;
	private int weight;

	public String toString() {
		return "Book: "+ title;
		
	}
}


