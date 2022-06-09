package com.sparta.weekone.controller;


import com.sparta.weekone.dto.BenqRequestDto;
import com.sparta.weekone.model.Benq;
import com.sparta.weekone.repository.BenqRepository;
import com.sparta.weekone.service.BenqService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class BenqController {
    private final BenqService benqService;
    private final BenqRepository benqRepository;

    // 게시글 생성
    @PostMapping("/api/benq/register")
    public Benq createBenq(@RequestBody BenqRequestDto requestDto) {
        return benqService.create(requestDto);
    }

    // 게시글 전체 조회
    @GetMapping("/api/benq")
    public List<Benq> benqList() {
        return benqRepository.findAll();
    }

    // 게시글 id값 조회
    @GetMapping("/api/benq/{id}")
    public Optional<Benq> getBenq(@PathVariable Long id) {
        Optional<Benq> benq = benqRepository.findById(id);
        return benq;
    }

    // 게시글 수정
    @PutMapping("/api/benq/{id}")
    public String updateBenq(@PathVariable Long id, @RequestBody BenqRequestDto requestDto) {
        System.out.println(requestDto);
        return benqService.update(id, requestDto);
    }
    // 게시글 삭제
    @DeleteMapping("/api/benq/{id}")
    public String deleteBenq(@PathVariable Long id, @RequestBody BenqRequestDto requestDto) {
        System.out.println(requestDto);
        return benqService.delete(id, requestDto);
    }
}