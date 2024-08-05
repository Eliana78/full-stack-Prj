package com.Esame.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Esame.entities.Biglietto;


@Repository
public interface BigliettoRepo extends JpaRepository<Biglietto, Integer> {

}
