package com.kh.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kh.mvc.model.service.BoardService;
import com.kh.mvc.model.vo.Board;
import com.kh.mvc.model.vo.Criteria;
import com.kh.mvc.model.vo.Paging;

@Controller
@RequestMapping("/board/*")
public class BoardController {

	@Autowired
	private BoardService service;
	
	@GetMapping			//@RequestMapping("/list") // = @RequestMapping
	public void list(Criteria cri, Model model) {
		List<Board> list = service.selectAll(cri);
		model.addAttribute("list",list);
		model.addAttribute("paging", new Paging(cri, service.getTotal()));
	}
//	public ModelAndView list() {
//		List<Board> list = service.selectAll();
//		return new ModelAndView("board/list","list",list);
//	}
	
//	@PostMapping("/list")
//	@PutMapping
//	@DeleteMapping
	

	
	@GetMapping("/insert")
	public void insert() {
		
	}
	
	@PostMapping("/insert")
	public String insert(Board board) {
		service.insertboard(board);
		return "redirect:/board/list";
	}
	@GetMapping("/view")
	public void view(int no, Model model) {
		model.addAttribute("vo", service.selectBoard(no));
	}
	
	@PostMapping("/update")
	public String update(Board board) {
		service.updateBoard(board);
		return "redirect:/board/list";
	}
	
	@GetMapping("/delete")
	public String delete(int no) {
		service.deleteBoard(no);
		return "redirect:/board/list";
	}
	
}

















