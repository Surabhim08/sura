package com.cg.sports.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.sports.entity.Card;

public interface ICardRepository extends JpaRepository<Card, Long> {

}
