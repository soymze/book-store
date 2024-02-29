package com.folksdev.bookstore;

import com.folksdev.bookstore.model.Book;
import com.folksdev.bookstore.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class BookStoreApplication implements CommandLineRunner {


	private final BookRepository bookRepository;

    public BookStoreApplication(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public static void main(String[] args) {

		SpringApplication.run(BookStoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Book book1 = Book.builder().name("Simyacı").author("Paulho Coelho").price(10.0).stock(10).build();
		Book book2 = Book.builder().name("Bazı Şeyler").author("David Copperfield").price(14.0).stock(13).build();
		Book book3 = Book.builder().name("Neden").author("Graham Bloom").price(11.0).stock(12).build();

		bookRepository.saveAll(Arrays.asList(book1, book2, book3));
	}
}
