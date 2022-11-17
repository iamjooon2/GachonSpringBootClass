package com.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.board.domain.CommentDTO;

// comment 테이블을 조작할 수 있게 미리 정의해둔 Mapper
@Mapper
public interface CommentMapper {

    // 댓글을 삽입하는 메서드
    public int insertComment(CommentDTO params);
    // 댓글의 세부 내역을 가져오는 메서드
    public CommentDTO selectCommentDetail(Long idx);
    // 댓글 내용을 업데이트 하는 메서드
    public int updateComment(CommentDTO params);
    // 댓글을 사용자로부터 보이지 않게 하는 메서드
    public int deleteComment(Long idx);
    // 특정 게시글의 댓글 목록을 가여오는 메서드
    public List<CommentDTO> selectCommentList(CommentDTO params);
    // 댓글의 총 총 개수를 가져오는 메서드
    public int selectCommentTotalCount(CommentDTO params);

}