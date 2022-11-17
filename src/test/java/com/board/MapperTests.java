package com.board;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.CollectionUtils;

import com.board.domain.PostDTO;
import com.board.mapper.PostMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@SpringBootTest
public class MapperTests {

	@Autowired
	private PostMapper postMapper;

	@Test
	public void testOfInsert() {
		PostDTO params = new PostDTO();
		params.setTitle("1번 게시글 제목");
		params.setContent("1번 게시글 내용");
		params.setWriter("테스터");

		int result = postMapper.insertBoard(params);
		System.out.println("결과는 " + result + "입니다.");
	}

	@Test
	public void testOfSelectDetail() {
		PostDTO board = postMapper.selectBoardDetail((long)1);
		try {
			String boardJson = new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(board);
			System.out.println("=========================");
			System.out.println(boardJson);
			System.out.println("=========================");

		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testOfUpdate() {
		PostDTO params = new PostDTO();
		params.setTitle("1번 게시글 제목을 수정합니다.");
		params.setContent("1번 게시글 내용을 수정합니다.");
		params.setWriter("홍길동");
		params.setIdx((long)1);

		int result = postMapper.updateBoard(params);
		if (result == 1) {
			PostDTO board = postMapper.selectBoardDetail((long)1);
			try {
				String boardJson = new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(board);
				System.out.println("=========================");
				System.out.println(boardJson);
				System.out.println("=========================");

			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		}
	}

	@Test
	public void testOfDelete() {
		int result = postMapper.deleteBoard((long)1);
		if (result == 1) {
			PostDTO board = postMapper.selectBoardDetail((long)1);
			try {
				String boardJson = new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(board);
				System.out.println("=========================");
				System.out.println(boardJson);
				System.out.println("=========================");

			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		}
	}

	@Test
	public void testSelectList() {
		int boardTotalCount = postMapper.selectBoardTotalCount(null);
		if(boardTotalCount > 0) {
			List<PostDTO> boardList = postMapper.selectBoardList(null);
			if(CollectionUtils.isEmpty(boardList) == false) {
				for(PostDTO board : boardList) {
					System.out.println("=========================");
					System.out.println(board.getTitle());
					System.out.println(board.getContent());
					System.out.println(board.getWriter());
					System.out.println("=========================");
				}
			}
		}
	}

}