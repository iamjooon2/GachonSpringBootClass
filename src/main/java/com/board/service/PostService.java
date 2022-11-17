package com.board.service;

import java.util.List;

import com.board.domain.PostDTO;

public interface PostService {
	public boolean registerBoard(PostDTO params);
	public PostDTO getBoardDetail(long idx);
	public boolean deleteBoard(long idx);
	public List<PostDTO> getBoardList(PostDTO params);
}
