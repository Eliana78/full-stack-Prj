package com.Esame.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Esame.entities.Teatro;


@Repository
public interface TeatroRepo extends JpaRepository<Teatro, String> {

}
