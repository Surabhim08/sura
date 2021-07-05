package com.cg.sports.controller;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.sports.entity.Card;
import com.cg.sports.service.CardService;

@RestController
@RequestMapping
public class CardController {
	org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private CardService cardService;


	@PostMapping
	public ResponseEntity<Card> addCard(@RequestBody Card card) {
		logger.info("Called POST mapping addCard() method");
		return new ResponseEntity<>(cardService.addCard(card), HttpStatus.CREATED);
	}

	
	@DeleteMapping("/{id}")
	public ResponseEntity<Card> removeCard(@PathVariable("id") Long id)  {
		logger.info("Called DELETE mapping removeCard() method");
		return new ResponseEntity<Card>(cardService.removeCard(id), HttpStatus.OK);

	}
	
	
	@PutMapping
	public ResponseEntity<Card> updateCard(@RequestBody Card card) {
		logger.info("Called PUT mapping updateCard() method");
		return new ResponseEntity<Card>(cardService.updateCard(card.getId(), card), HttpStatus.ACCEPTED);

	}

	
	@GetMapping("/{id}")
	public ResponseEntity<Card> getCard(@PathVariable("id") Long id) {
		logger.info("Called GET mapping addCard() method");

		return new ResponseEntity<Card>(cardService.getCard(id), HttpStatus.OK);
	}
	
	
	@GetMapping
	public ResponseEntity<List<Card>> getAllCard() {
		logger.info("Called GET mapping addAllCard() method");
		List<Card> allCard = cardService.getAllCard();
		ResponseEntity<List<Card>> entity = new ResponseEntity<List<Card>>(allCard, HttpStatus.OK);
		return entity;
	}
}

