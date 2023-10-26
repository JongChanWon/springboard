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
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
@Slf4j
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

    @GetMapping
    public String findById(@RequestParam("id") Long id, Model model) {
    	boardService.updateHits(id);
    	BoardDTO boardDTO = boardService.findById(id);
    	model.addAttribute("board", boardDTO);

    	return "detail";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") Long id, Model model) {
    	int cnt = boardService.delete(id);

    	if(cnt > 0) {
    		return "redirect:/board/";

    	} else {
    		return "redirect:/board/delete";
    	}
    }

    // jsp에서 링크를 타고 왔기 때문에 getmapping
    // requestparam에 적어준 아이디(쿼리스트링 파라미터)를 요청을 해야하는데 파라미터 값이 없으면 400에러 뜸
    @GetMapping("/update")
    public String updateForm(@RequestParam("id") Long id, Model model) {
    	BoardDTO boardDTO = boardService.findById(id);
    	model.addAttribute("board", boardDTO);

    	return "update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute BoardDTO boardDTO, Model model) {
    	int cnt = boardService.updateBoard(boardDTO);
    	log.info("update cnt >>>>>> " + cnt);

    	if(cnt > 0) {
    		// 업데이트 성공
    		boardDTO = boardService.findById(boardDTO.getId());
    		model.addAttribute("board", boardDTO);
    		return "detail"; // 조회수 증가 방지하기 위해 업데이트 처리 하고 상세조회를 다시하자.. 조회수 빼고
        	// return "redirect:/board?id=" + boardDTO.getId(); // 이런식으로 하면 업데이트하고 상세로 돌아갈때 조회수가 증가함
    	} else {
    		// 업데이트 실패
    		return "redirect:/board/update";
    	}
    }

    // /board/paging?page=2 이렇게 요청이 오지 않고 /board/paging 이렇게 요청이 오기 때문에 파라미터가 날라오지 않기 때문에 @RequestParam씀
    // 처음 페이지 요청은 1페이지를 보여줌
    // required = false는 필수가 아니다... paging의 파라미터가 없어도 에러가 발생하지 않고 파라미터가 없으면 디폴트로 1이 들어가고
    // /board/paging?page=2 이렇게 오면 page라는 변수에는 2가 들어감
    // value는 파라미터값
    // required=true면 필수
    @GetMapping("/paging")
    public String paging(Model model, @RequestParam(value = "page", required = false, defaultValue = "1") int page) {
    	System.out.println("page = " + page);
    	// 해당 페이지에서 보여줄 글 목록
    	List<BoardDTO> pagingList = boardService.pagingList(page);

    	return "index";
    }
}










