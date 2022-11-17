package com.board.service;

import java.util.List;

import com.board.domain.PostDTO;

// 게시글 서비스의 인터페이스
public interface PostService {
	// 게시글 등록 메서드
	public boolean registerBoard(PostDTO params);
	// 게시글의 세부 내역을 불러오는 메서드
	// 게시글 내용을 보고 싶을때 해당 메서드를 사용한다
	public PostDTO getBoardDetail(long idx);
	// 게시글을 삭제하고 싶을때 사용하는 메서드
	// 해당 메서드를 통해 board 칼럼의 delete_yn의 값을 바꿔준다
	public boolean deleteBoard(long idx);
	// 게시글 목록을 가져오는 리스트
	// 페이지네이션도 이 메서드에서 함께 처리한다
	public List<PostDTO> getBoardList(PostDTO params);
}
