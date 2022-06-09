package com.sparta.weekone.service;

import com.sparta.weekone.dto.BenqRequestDto;
import com.sparta.weekone.dto.GramRequestDto;
import com.sparta.weekone.model.Benq;
import com.sparta.weekone.model.Gram;
import com.sparta.weekone.repository.BenqRepository;
import com.sparta.weekone.repository.GramRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;
import java.util.List;


@Service
@RequiredArgsConstructor
public class GramService {
    private final BenqRepository benqRepository;
    private final GramRepository gramRepository;

    public Gram create(GramRequestDto requestDto, Long benqId) {

        Benq benq = benqRepository.findById(benqId).orElseThrow(
                () -> new IllegalArgumentException("게시글이 존재하지 않습니다."));
        System.out.println("benq = " + benq);
        Gram gram = new Gram(requestDto);
        return gramRepository.save(gram);
    }

    public List<Gram> gramList(Long id) {
        return gramRepository.findAllById(id);

    }
    @Transactional
    public String update(GramRequestDto requestDto, @PathVariable Long id) {
        Gram gram = gramRepository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("댓글이 존재하지 않습니다."));
        Long password1 = gram.getPass();
        System.out.println("password1 = " + password1);
        Long password2 = requestDto.getPass();
        System.out.println("password2 = " + password2);
        System.out.println("나와라 얍!");
        if (!password2.equals(password1)){

            return "비밀번호가 다릅니다.";
        }else {
            gram.update(requestDto);
            return "대성공!";
        }

    }
    @Transactional
    public String delete(GramRequestDto requestDto, @PathVariable Long id) {
        Gram gram = gramRepository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("댓글이 존재하지 않습니다."));
        Long password1 = gram.getPass();
        Long password2 = requestDto.getPass();
        if (password2.equals(password1)){
            gramRepository.delete(gram);
            return "대성공!";
        }else {
            return "비밀번호가 다릅니다.";
        }

    }
    }


