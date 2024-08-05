package com.Esame.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Esame.entities.Spettacolo;

@Repository
public interface SpettacoloRepo extends JpaRepository<Spettacolo, String> {

}
