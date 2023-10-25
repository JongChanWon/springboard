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

}
