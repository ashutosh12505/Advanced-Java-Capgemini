package com.group.library.repository;

import org.springframework.stereotype.Repository;
import com.group.library.model.Member;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MemberRepository {

    private List<Member> members = new ArrayList<>();
    private Long idCounter = 1L;

    public Member save(String name, String email) {
        Member member = new Member(idCounter++, name, email);
        members.add(member);
        return member;
    }

    public Member findById(Long id) {
        return members.stream()
                .filter(m -> m.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}