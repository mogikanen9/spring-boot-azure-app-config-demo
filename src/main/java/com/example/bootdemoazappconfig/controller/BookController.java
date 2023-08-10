package com.example.bootdemoazappconfig.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.azure.spring.cloud.feature.management.FeatureManager;
import com.example.bootdemoazappconfig.MessageProperties;
import com.example.bootdemoazappconfig.repository.BookRepository;

@RestController
public class BookController {

	private final BookRepository bookRepository;

	private final MessageProperties messageProperties;
	
	private final FeatureManager featureManager;

	public BookController(BookRepository bookRepository, MessageProperties messageProperties, FeatureManager featureManager) {
		super();
		this.bookRepository = bookRepository;
		this.messageProperties = messageProperties;
		this.featureManager = featureManager;
	}

	@GetMapping("/api/book/{isbn}")
	public ResponseEntity<BookDTO> getBookBy(@PathVariable("isbn") String isbn) {

		List<BookDTO> booksFound = this.bookRepository.findByIsbn(isbn).stream()
				.map(b -> new BookDTO(b.getTitle(), b.getAuthor(), b.getIsbn())).toList();

		if (booksFound.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(booksFound.iterator().next(), HttpStatus.OK);
		}
	}

	@GetMapping("/api/message")
	public ResponseEntity<String> getMessage() {
		return new ResponseEntity<>(
				"Message: " + this.messageProperties.getMessage()+
				"My Secret 1: "+this.messageProperties.getMysecret1(), HttpStatus.OK);
	}
	
	@GetMapping("/api/feature")
	public ResponseEntity<String> getFeatureFlag() {
		boolean rs = this.featureManager.isEnabled("MyFancyFeature1");
		return new ResponseEntity<>(
				"MyFancyFeature1 enabled: " + rs, HttpStatus.OK);
	}

}
