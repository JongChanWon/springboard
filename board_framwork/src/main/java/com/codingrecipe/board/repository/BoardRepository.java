package com.codingrecipe.board.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.codingrecipe.board.dto.BoardDTO;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class BoardRepository {
	
	// 마이바티스에서 지원해주는 클래스 
	private final SqlSessionTemplate sql;
	
	public int save(BoardDTO boardDTO) {
		
		return sql.insert("Board.save", boardDTO);
	}

	public List<BoardDTO> findAll() {
		
		return sql.selectList("Board.findAll");
	}
}
