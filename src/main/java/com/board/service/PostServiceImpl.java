package com.board.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.board.domain.PostDTO;
import com.board.mapper.PostMapper;
import com.board.paging.PaginationInfo;

@Service
public class PostServiceImpl implements PostService {
	@Autowired
	private PostMapper postMapper;
	
	@Override
	public boolean registerBoard(PostDTO params) {
		int queryResult = 0;
		
		if(params.getIdx() == null) {
			queryResult = postMapper.insertBoard(params);
		} else {
			queryResult = postMapper.updateBoard(params);
		}
		return (queryResult == 1) ? true : false;
	}
	
	@Override
	public PostDTO getBoardDetail(long idx) {
		int result = updateBoardCount(idx);
		return postMapper.selectBoardDetail(idx);
	}

	public int updateBoardCount(Long idx) {
		//관련된 글 조회수 올리기
		int result = postMapper.updateBoardCount(idx);
		return result;
	}
	@Override
	public boolean deleteBoard(long idx) {
		// TODO Auto-generated method stub
		int queryResult = 0;
		
		PostDTO board = postMapper.selectBoardDetail(idx);
		
		if (board != null && "N".equals(board.getDeleteYn())) {
			queryResult = postMapper.deleteBoard(idx);
		}
		return (queryResult == 1) ? true : false;
	}

	@Override
	public List<PostDTO> getBoardList(PostDTO params) {
		// TODO Auto-generated method stub
		List<PostDTO> boardList = Collections.emptyList();
		
		int boardTotalCount = postMapper.selectBoardTotalCount(params);
		
		PaginationInfo paginationInfo = new PaginationInfo(params);
		paginationInfo.setTotalRecordCount(boardTotalCount);
		
		params.setPaginationInfo(paginationInfo);
		
		if(boardTotalCount > 0) {
			boardList = postMapper.selectBoardList(params);
		}
		return boardList;
	}
}
