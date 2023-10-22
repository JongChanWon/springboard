package com.codingrecipe.board.service;

import java.util.List;

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

}
