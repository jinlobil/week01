package com.sparta.weekone.controller;

import com.sparta.weekone.dto.BenqRequestDto;
import com.sparta.weekone.dto.GramRequestDto;
import com.sparta.weekone.model.Gram;
import com.sparta.weekone.repository.GramRepository;
import com.sparta.weekone.service.GramService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class GramController {
    private final GramService gramService;
    private final GramRepository gramRepository;

    // 댓글  게시글id 참조로 생성
    @PostMapping ("/api/benq/{benqId}/gram/register")
    public Gram createGram(@RequestBody GramRequestDto requestDto, @PathVariable Long benqId) {
        return gramService.create(requestDto, benqId);
    }
    // 댓글  게시글id 참조로 조회
    @GetMapping("/api/benq/{benqId}/gram")
    public List<Gram> gramList(@PathVariable Long benqId) {
        return gramService.gramList(benqId);
    }
    // 댓글 전체 조회
    @GetMapping("/api/gram")
    public List<Gram> gramList() {
        return gramRepository.findAll();
    }
    // 댓글 비밀번호 비교 후 수정
    @PutMapping("/api/gram/{id}")
    public String updateGram(@RequestBody GramRequestDto requestDto, @PathVariable Long id) {
        System.out.println(requestDto);
        return gramService.update(requestDto, id);
    }
    // 댓글 비밀번호 비교후 삭제
    @DeleteMapping("/api/gram/{id}")
    public String deleteGram(@RequestBody GramRequestDto requestDto, @PathVariable Long id) {
        return gramService.delete(requestDto, id);
    }


}
