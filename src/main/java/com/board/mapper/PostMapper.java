package com.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.board.domain.PostDTO;

@Mapper
public interface PostMapper {
	public int insertBoard(PostDTO params);
	public PostDTO selectBoardDetail(long idx);
	public int updateBoard(PostDTO params);
	public int deleteBoard(long idx);
	public List<PostDTO> selectBoardList(PostDTO params);
	public int selectBoardTotalCount(PostDTO params);
	public int updateBoardCount(Long idx);
}
