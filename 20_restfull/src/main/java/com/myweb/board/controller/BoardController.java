package com.myweb.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.myweb.board.domain.BoardVO;
import com.myweb.board.service.BoardService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/board/")
public class BoardController {
	@Autowired
	private BoardService bsv;
	
	@GetMapping("/register")
	public void register() {}
	
	@PostMapping("/register")
	public String register(BoardVO bvo) {
		log.debug("롬복 버전 이슈");
		bsv.register(bvo);
		return "redirect:/board/list";
	}
	
	@GetMapping("/list") 
	public void list(Model model){
		model.addAttribute("list", bsv.getList());
	}
	
	@GetMapping("/detail")
	public void detail(@RequestParam("bno") int bno, Model model) {
		model.addAttribute("bvo", bsv.getDetail(bno));
	}
	
	@PostMapping("/modify")
	public String modify(BoardVO bvo) {
		bsv.modify(bvo);
		return "redirect:/detail?bno=" + bvo.getBno();
	}

	@PostMapping("/remove")
	public String modify(@RequestParam("bno") int bno) {
		bsv.remove(bno);
		return "redirect:/board/list";
	}
}
