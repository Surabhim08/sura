package com.cg.sports.service;
import java.util.List;

import com.cg.sports.entity.Card;
//import com.cg.sports.exceptions.CardNotFoundException;

public interface ICardService {
	public Card addCard(Card card);

	public Card removeCard(Long id);

	public Card updateCard(Long id, Card card) ;
	public Card getCard(Long id) ;

	public List<Card> getAllCard();

//	public List<Booking> getCardByCustomer(Long id);

}

