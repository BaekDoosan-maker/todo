package com.test.todo.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Todo {

    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="content",nullable = false)
    private String content;

    @Column(name="is_completed")
    private Boolean isCompleted;

    @Column(name="starred")
    private Boolean starred;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="member_id")
    private Member member;
}
