package com.kelly.producer.repository;

import com.kelly.producer.pojo.Depart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartRepository extends JpaRepository<Depart,Integer> {
}
