package io.swagger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.swagger.model.CardType;

@Repository
public interface CardTypeRepo extends JpaRepository<CardType,Long>{


    
}
