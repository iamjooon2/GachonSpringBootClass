package com.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.board.domain.PostDTO;

// post 테이블을 조작할 수 있게 미리 정의해둔 Mapper
@Mapper
public interface PostMapper {
	// 게시글을 삽입하는 메서드
	public int insertBoard(PostDTO params);
	// 게시글의 세부 내용(제목, 작성자, 내용 등)을 가지고 오는 메서드
	public PostDTO selectBoardDetail(long idx);
	// 게시글의 내용을 업데이트 하는 메서드
	public int updateBoard(PostDTO params);
	// 게시글을 삭제하는 메서드
	public int deleteBoard(long idx);
	// 게시글을 리스트 형태로 가지고 오는 메서드
	public List<PostDTO> selectBoardList(PostDTO params);
	// 게시글의 총 개수를 가지고 오는 메서드
	public int selectBoardTotalCount(PostDTO params);
	// 게시글의 조회수를 업데이트하는 메서드
	public int updateBoardCount(Long idx);
}
