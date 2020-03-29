package chapter3.set.interfaces;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import chapter3.set.interfaces.model.Book;

public class Main {

	public static void main(String[] args) {
		
		//runHashSetSample();
		
		//runBookSample();
		
		runTreeSetSamples();
	}
	
	public static void runHashSetSample() {
		
		Set<String> brands = new HashSet<String>();
		brands.add("Honda");
		brands.add("Mazda");
		brands.add("Toyota");
		brands.add("Kia");
		brands.add("Audi");
		brands.add("Mercedes");
		brands.add("Ford");
		brands.add("Fiat");
		brands.add("Audi");
		brands.add("Ford");
		
		System.out.println("Markalar");
		printAll(brands);
		
		System.out.println("Elemanlara erişmek için bir iterator nesnesi oluşturmak gerekiyor");
		
		Iterator<String> iteratorObject = brands.iterator();
		
		System.out.println(iteratorObject.next());
		System.out.println(iteratorObject.next());
		System.out.println(iteratorObject.next());
		
		System.out.println(iteratorObject.hasNext());
		
		System.out.println("arta kalanlar");
		while(iteratorObject.hasNext()) 
		{
			System.out.println(iteratorObject.next());
		}
	}
	
	public static void runBookSample() {
		
		Book book1 = new Book("Javascript Book", "ABC Yayınevi", 2010, 300, 20);
		Book book2 = new Book("Javascript Book", "ABC Yayınevi", 2010, 300, 20);
		Book book3 = new Book("Javascript Book", "ABC Yayınevi", 2010, 300, 20);
		
		System.out.println(book1.hashCode());
		System.out.println(book2.hashCode());
		System.out.println(book3.hashCode());
		
		
		Set<Book> books = new HashSet<Book>();
		books.add(new Book("Java Book", "Penguen Yayınevi", 2019, 500, 50));
		books.add(new Book("Python Book", "Panda Yayınevi", 2019, 250, 45.5));
		books.add(new Book("C# Book", "Elma Yayınevi", 2020, 660, 70));
		books.add(new Book("Ruby Book", "Beyaz Balina Yayınevi", 2019, 450, 28));
		books.add(new Book("Go Book", "Kanarya Yayınevi", 2017, 420, 80));
		books.add(book1);
		books.add(book2);
		books.add(book3);
		
		System.out.println("Mükerrer eleman içermeyen kitap listesi");
		printAll(books);
	}
	
	
	public static void runTreeSetSamples() {
		
		Set<Long> yearSet = new TreeSet<Long>();
		yearSet.add(2019l);
		yearSet.add(2014l);
		yearSet.add(2020l);
		yearSet.add(2001l);
		yearSet.add(2017l);
		yearSet.add(2010l);
		yearSet.add(2009l);
		yearSet.add(2005l);
		
		System.out.println("Doğal bir şekilde sıralanmış TreeSet");
		printAll(yearSet);
		
		Set<Book> books = new TreeSet<Book>();
		books.add(new Book("Java Book", "Penguen Yayınevi", 2019, 500, 50));
		books.add(new Book("Python Book", "Panda Yayınevi", 2019, 250, 45.5));
		books.add(new Book("C# Book", "Elma Yayınevi", 2020, 660, 70));
		books.add(new Book("Ruby Book", "Beyaz Balina Yayınevi", 2014, 450, 28));
		books.add(new Book("Go Book", "Kanarya Yayınevi", 2017, 420, 80));
		books.add(new Book("Javascript Book", "ABC Yayınevi", 2019, 300, 20));
		books.add(new Book("Javascript Book", "ABC Yayınevi", 2010, 300, 20));
		books.add(new Book("Javascript Book", "ABC Yayınevi", 2010, 300, 20));
		
		System.out.println("Doğal bir şekilde sıralanmış kitap listesi");
		printAll(books);
		
		
		
		BookComparatorByPublisher comparatorByPublisher = new BookComparatorByPublisher();
		
		Set<Book> sortedBooksByPublisher = new TreeSet<Book>(comparatorByPublisher);
		
		sortedBooksByPublisher.addAll(books);
		
		System.out.println("Yayınevi ismine göre sıralanmış kitap listesi");
		printAll(sortedBooksByPublisher);
		
		
		
		
		BookComparatorByPublishYear comparatorByPublisheryear = new BookComparatorByPublishYear();
		
		Set<Book> sortedBooksByPublishyear = new TreeSet<Book>(comparatorByPublisheryear);
		
		sortedBooksByPublishyear.addAll(sortedBooksByPublisher);
		
		
		System.out.println("Yayın yılı bilgisine göre sıralanmış kitap listesi");
		printAll(sortedBooksByPublishyear);
		
	}

	public static <T> void printAll(Set<T> set) {
		
		for(T item : set) {
			
			System.out.println(item);
		}
		System.out.println();
	}
}
