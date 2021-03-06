package com.sparta.weekone.repository;

import com.sparta.weekone.dto.BenqRequestDto;
import com.sparta.weekone.model.Benq;
import com.sparta.weekone.model.Gram;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BenqRepository extends JpaRepository<Benq, Long> {

}
