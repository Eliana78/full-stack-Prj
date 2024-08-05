package com.Esame.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Esame.entities.Replica;


@Repository
public interface ReplicaRepo extends JpaRepository<Replica, String> {

}
