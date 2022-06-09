package com.sparta.weekone.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sparta.weekone.dto.GramRequestDto;
import com.sparta.weekone.repository.GramRepository;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Gram {

    @GeneratedValue
    @Id
    private Long id;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "benqId")
    private Benq benq;

    @Column(nullable = false)
    private String reply;

    @Column(nullable = false)
    private Long pass;

    public Gram(GramRequestDto requestDto) {
        this.reply = requestDto.getReply();
        this.pass = requestDto.getPass();

    }

    public void update(GramRequestDto requestDto) {
        this.reply = requestDto.getReply();
        this.pass = requestDto.getPass();
    }

    public void delete(GramRequestDto requestDto) {
        this.reply = requestDto.getReply();
        this.pass = requestDto.getPass();
    }
}
