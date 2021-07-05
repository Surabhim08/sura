package com.cg.sports.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.cg.sports.controller.CardController;
import com.cg.sports.entity.Card;
import com.cg.sports.repository.ICardRepository;


@Service
public class CardService implements ICardService {
	org.jboss.logging.Logger logger = LoggerFactory.logger(this.getClass());

	@Autowired
	private ICardRepository cardRepository;

	@Override
	public Card addCard(Card card) {
		logger.info("Called addCard() method of CardService");

		return cardRepository.save(card);
	}

	@Override
	public Card removeCard(Long id) {
		logger.info("Called removeCard() method of CardService");
		
		if (cardRepository.findById(id).isPresent()) {
			Card cardToDelete = cardRepository.getById(id);
			cardRepository.delete(cardToDelete);
			return null;
		} else {
			// CardNotFoundException
			return null;
		}
	}

	@Override
	public Card updateCard(Long id, Card card){
		logger.info("Called updateCard() method of CardService");
		Optional<Card> searchedCard = cardRepository.findById(id);
		if (searchedCard.isPresent()) {
			return cardRepository.save(card);
		} else {
			//CardNotFoundException
			return null;
		}
	}

	@Override
	public Card getCard(Long id) {
		logger.info("Called getCard() method of CardService");
		Optional<Card> searchedCard = cardRepository.findById(id);
		if (searchedCard.isPresent()) {
			return searchedCard.get();
		} else {
			//CardNotFoundException
			return null;
		}
	}

	@Override
	public List<Card> getAllCard() {
		logger.info("Called getAllCard() method of CardService");
		return cardRepository.findAll();
	}

}
