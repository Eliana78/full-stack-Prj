package com.Esame.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Esame.entities.Cliente;


@Repository
public interface ClienteRepo extends JpaRepository<Cliente, Integer> {

}
