package com.test.todo.repository;

import com.test.todo.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Long> {
    Member findByMembername(String membername);
}
