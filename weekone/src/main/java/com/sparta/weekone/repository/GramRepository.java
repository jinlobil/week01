package com.sparta.weekone.repository;

import com.sparta.weekone.model.Gram;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GramRepository extends JpaRepository<Gram, Long> {



    List<Gram> findAllById(Long id);
}
