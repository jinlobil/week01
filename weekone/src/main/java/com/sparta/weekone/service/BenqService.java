package com.sparta.weekone.service;

import com.sparta.weekone.dto.BenqRequestDto;
import com.sparta.weekone.model.Benq;
import com.sparta.weekone.repository.BenqRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class BenqService {
    private final BenqRepository benqRepository;
    public Benq create(BenqRequestDto requestDto) {
        Benq benq = new Benq(requestDto);
        benqRepository.save(benq);
        return benq;


    }
    @Transactional
    public String update(@PathVariable Long id, @RequestBody BenqRequestDto requestDto) {
        Benq benq = benqRepository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("게시글이 존재하지 않습니다."));
        Long password1 = benq.getPassword();
        System.out.println("password1 = " + password1);
        Long password2 = requestDto.getPassword();
        System.out.println("password2 = " + password2);
        System.out.println("나와라 얍!");
        if (!password2.equals(password1)){

            return "비밀번호가 다릅니다.";
        }else {
            benq.update(requestDto);
            return "대성공!";
        }

    }

    public String delete(@PathVariable Long id, @RequestBody BenqRequestDto requestDto) {
        Benq benq = benqRepository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("게시글이 존재하지 않습니다."));
        Long password1 = benq.getPassword();
        Long password2 = requestDto.getPassword();
        if (password2.equals(password1)){
            benqRepository.delete(benq);
            return "대성공!";
        }else {
            return "비밀번호가 다릅니다.";
        }

    }
    }

