package com.codingrecipe.board.service;

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

}
