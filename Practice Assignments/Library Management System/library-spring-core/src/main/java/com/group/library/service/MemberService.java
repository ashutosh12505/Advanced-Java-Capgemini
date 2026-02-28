package com.group.library.service;

import org.springframework.stereotype.Service;
import com.group.library.repository.MemberRepository;
import com.group.library.model.Member;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public void registerMember(String name, String email) {
        memberRepository.save(name, email);
        System.out.println("Member Registered!");
    }

    public Member getMember(Long id) {
        return memberRepository.findById(id);
    }
}