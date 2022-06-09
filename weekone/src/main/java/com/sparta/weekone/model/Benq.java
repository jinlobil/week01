package com.sparta.weekone.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sparta.weekone.dto.BenqRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Setter
@NoArgsConstructor
public class Benq {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String contents;

    @Column(nullable = false)
    private Long password;

    @JsonBackReference
    @OneToMany(mappedBy = "benq", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Gram> gramList = new ArrayList<>();



    public Benq(BenqRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.name = requestDto.getName();
        this.contents = requestDto.getContents();
        this.password = requestDto.getPassword();
    }

    public void update(BenqRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.name = requestDto.getName();
        this.contents = requestDto.getContents();
        this.password = requestDto.getPassword();

    }

    public void delete(BenqRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.name = requestDto.getName();
        this.contents = requestDto.getContents();
        this.password = requestDto.getPassword();

    }

    public Benq(Long password){
        this.password = password;
    }
}
