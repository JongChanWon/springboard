package com.codingrecipe.board.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingrecipe.board.dto.BoardDTO;
import com.codingrecipe.board.service.BoardService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
	
	private final BoardService boardService;
	
    @GetMapping("save")
    public String saveForm() {
        return "save";
    }
    
    @PostMapping("save")
    public String save(@ModelAttribute BoardDTO boardDTO) {
    	int saveResult = boardService.save(boardDTO);
    	if(saveResult > 0) {
    		return "redirect:/board/";
    	} else {
    		return "save";
    	}
    }
    
    @GetMapping("/")
    public String findAll(Model model) { // 디비에서 뭔가를 가져와야 한다면 Model을 써야함
    	List<BoardDTO> boardList = boardService.findAll();
    	model.addAttribute("boardList", boardList);
    	
    	return "list";
    }
}
