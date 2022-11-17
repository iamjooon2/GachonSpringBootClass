package com.board.service;

import java.util.List;

import com.board.domain.CommentDTO;

// 댓글 서비스의 인터페이스
public interface CommentService {
    // 댓글을 등록하는 메서드
    // parameter로 CommentDTO를 받으며, 사용자가 특정 게시글에 댓글을 남겼을때 이 메서드를 이용한다
    public boolean registerComment(CommentDTO params);

    // 댓글을 삭제하는 메서드
    // 이 메서드를 통해 commment table의 delete 여부를 변경해준다
    public boolean deleteComment(Long idx);

    // 댓글 목록을 가져오는 메서드
    // 이 메서드를 통해 특정 게시글의 활성화된 댓글 목록을 모두 가져온다
    public List<CommentDTO> getCommentList(CommentDTO params);
}