package com.myweb.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myweb.board.domain.entity.Board;
import com.myweb.board.service.BoardService;

@RestController
@RequestMapping("/api")
public class BoardAPi {
	@Autowired
	private BoardService bsv;
	
	@GetMapping("")
	public List<Board> list() {
		return bsv.getList();
	}
	
	@PostMapping("/register")
	public void register(@RequestBody Board board) {
		bsv.register(board);
	}
	
	@GetMapping("/{bno}")
	public Board detail(@PathVariable("bno") int bno) {
		return bsv.getDetail(bno);
	}
	
	@PutMapping("/{bno}")
	public void modify(@RequestBody Board board) {
		bsv.modify(board);
	}
	
	@DeleteMapping("/{bno}")
	public void remove(@PathVariable("bno") int bno) {
		bsv.remove(bno);
	}
}
