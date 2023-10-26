package com.codingrecipe.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.codingrecipe.board.dto.BoardDTO;
import com.codingrecipe.board.repository.BoardRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {

	private final BoardRepository boardRepository;

	public int save(BoardDTO boardDTO) {
		return boardRepository.save(boardDTO);
	}

	public List<BoardDTO> findAll() {
		return boardRepository.findAll();
	}

	public BoardDTO findById(Long id) {
		return boardRepository.findById(id);
	}

	public void updateHits(Long id) {
		boardRepository.updateHits(id);
	}

	public int delete(Long id) {
		return boardRepository.delete(id);
	}

	public int updateBoard(BoardDTO boardDTO) {
		return boardRepository.updateBoard(boardDTO);
	}

	public List<BoardDTO> pagingList(int page) {
		int pageLimit = 3;
		/*
		 * 1페이지당 보여지는 글 갯수 3
		 * 	1page => 0
		 *  2page => 3
		 *  3page => 6
		 */
		int pageStart = (page - 1) * pageLimit;
		Map<String, Integer> pagingParams = new HashMap<String, Integer>();
		pagingParams.put("start", pageStart);
		pagingParams.put("limit", pageLimit);

		List<BoardDTO> pagingList = boardRepository.pagingList()

		return null;
	}

}





















