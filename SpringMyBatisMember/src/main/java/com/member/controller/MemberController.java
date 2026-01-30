package com.member.controller;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.member.domain.Member;
import com.member.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/member")
@MapperScan(basePackages = "com.member.mapper")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/insertForm")
	public String memberInsertForm(Model model) {
		return "member/insertForm";
	}
	
	@PostMapping("/insert")
	public String memberInsert(Member member, Model model) {
		log.info("insert member = " + member.toString());
		try {
			int count = memberService.register(member);
			if(count > 0) {
				model.addAttribute("message", "%s님 가입에 성공하였습니다.".formatted(member.getName()));
				return "member/success";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("message", "%s님 가입에 실패하였습니다.".formatted(member.getName()));
		return "member/failed";
	}
	
	@GetMapping("/memberList")
	public String memberList(Model model) {
		log.info("memberList");
		
		try {
			List<Member> memberList = memberService.list();
			
			model.addAttribute("memberList",memberList);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "member/memberList";
	}
	
	@GetMapping("/detail")
	public String memberDetail(Member member, Model model) {
		
		try {
			Member m = memberService.read(member);
			if(m == null) {
				model.addAttribute("message", "해당 번호의 정보를 찾을 수 없습니다.");
				return "member/failed";
			}
			log.info("memberDetail member = "+ m.toString());
			model.addAttribute("member",m);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "member/detail";
	}
	
//	@GetMapping("/delete")
//	public String boardDelete(Board board, Model model) {
//		log.info("boardDetail board = "+board.toString());
//		
//		try {
//			boardService.delete(board);
//		} catch (Exception e) {
//			e.printStackTrace();
//			model.addAttribute("message", "%d 님의 정보 삭제가 실패하였습니다.".formatted(board.getNo()));
//			return "board/failed";
//		}
//		model.addAttribute("message", "%d 님의 정보가 삭제되었습니다.".formatted(board.getNo()));
//		return "board/success";
//	}
//	
	@GetMapping("/updateForm")
	public String memberUpdateForm(Member member, Model model) {
		log.info("updateForm board = "+member.toString());
		
		try {
			Member member_ = memberService.read(member);
			if(member_ == null) {
				model.addAttribute("message", "%d 님의 정보가 없습니다".formatted(member.getNo()));
				return "board/failed";
			}
			model.addAttribute("member", member_);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "member/updateForm";
	}
	
	@PostMapping("/update")
	public String updateMember(Model model, Member member) {
		log.info("updateBoard board = "+member.toString());
		
		try {
			int count = memberService.update(member);
			if(count > 0) {
				model.addAttribute("message", "%d 님의 회원정보가 수정되었습니다.".formatted(member.getNo()));
				return "member/success";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("message", "%d 님의 회원정보가 수정되지 않았습니다.".formatted(member.getNo()));
		return "member/failed";
	}
	
//	@GetMapping("/search")
//	public String boardSearch(Model model, Board board) {
//		log.info("searchType = " + board.toString());
//		
//		try {
//			List<Board> boardList = boardService.boardSearch(board);
//			
//			model.addAttribute("boardList",boardList);
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return "board/boardList";
//	}
	
}
