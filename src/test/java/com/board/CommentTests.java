package com.board;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.board.domain.CommentDTO;
import com.board.service.CommentService;

@SpringBootTest
class CommentTests {

    @Autowired
    private CommentService commentService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void registerComments() {
        int number = 20;

        for (int i = 1; i <= number; i += 1) {
            CommentDTO params = new CommentDTO();
            params.setBoardIdx((long) 1); // 댓글을 추가할 게시글 번호
            params.setContent(i + "번 댓글을 추가합니다!");
            params.setWriter(i + "번 회원");
            commentService.registerComment(params);
        }
    }

    @Test
    public void deleteComment() {
        commentService.deleteComment((long) 1); // 삭제할 댓글 번호

        getCommentList();
    }

    @Test
    public void getCommentList() {
        CommentDTO params = new CommentDTO();
        params.setBoardIdx((long) 1); // 댓글을 추가할 게시글 번호

        commentService.getCommentList(params);
    }

}