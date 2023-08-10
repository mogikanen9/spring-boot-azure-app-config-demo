package com.example.bootdemoazappconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.bootdemoazappconfig.model.Book;
import com.example.bootdemoazappconfig.repository.BookRepository;

@Component
public class DataLoader implements CommandLineRunner {

	@Autowired
	private BookRepository bookRepository;

	@Override
	public void run(String... args) throws Exception {

		bookRepository.save(new Book("My Title 1", "My Author 1", "QWE231"));
		bookRepository.save(new Book("My Title 2", "My Author 2", "QWE232"));
		bookRepository.save(new Book("My Title 3", "My Author 3", "QWE233"));

	}
}
