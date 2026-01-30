package com.member.domain;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class Member {
	
	private int no;
	private String id;
	private String pw;
	private String name;
	private int coin;
	private Date regDate;
	private Date modDate;
	
	private List<MemberAuth> authList;
	
	//검색어를 받기위한 변수선언
	private String searchType;
	private String keyword;
	
}
