package com.member.service;

import java.util.List;

import com.member.domain.Member;

public interface MemberService {
	//가입 -> 동시가입 (회원 및 회원 권한)
	public int register(Member member) throws Exception;
	
	//회원리스트, 회원정보, 회원수정, 회원삭제, 권한삭제
	public List<Member> list() throws Exception;
	public Member read(Member member) throws Exception;
	public int update(Member member) throws Exception;
	
	//삭제 -> 동시에 삭제 (회원 및 회원 권한)
	public int delete(Member member) throws Exception;

	public List<Member> search(Member member) throws Exception;
}
