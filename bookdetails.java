import java.util.Scanner;
class Book {
String name;
String author;
int price;
int numPages;
public Book(String name, String author, int price, int numPages) {
this.name = name;
this.author = author;
this.price = price;
this.numPages = numPages;
}
public String toString() {
String name, author, price, numPages;
name = "Book name: " + this.name + "\n";
author = "Author name: " + this.author + "\n";
price = "Price: " + this.price + "\n";
numPages = "Number of pages: " + this.numPages + "\n";
return name + author + price + numPages;
}}
public class Main_book {
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
System.out.print("Enter the number of books: ");
int n = scanner.nextInt();
scanner.nextLine(); 
Book[] books = new Book[n];
for (int i = 0; i < n; i++) {
System.out.println("Enter details for book " + (i + 1) + ":");
System.out.print("Name: ");
String name = scanner.nextLine();
System.out.print("Author: ");
String author = scanner.nextLine();
System.out.print("Price: ");
int price = scanner.nextInt();
System.out.print("Number of pages: ");
int numPages = scanner.nextInt();
scanner.nextLine(); 
books[i] = new Book(name, author, price, numPages);
}
System.out.println("\nBook Details:");
for (int i = 0; i < n; i++) {
System.out.println(books[i].toString());
}
scanner.close();
}}
