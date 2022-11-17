package com.board.domain;

import lombok.Getter;
import lombok.Setter;

// 댓글의 레이어간 이동을 위해 정의해둔 클래스
// 컨트롤러 <-> 서비스 <-> 매퍼 <-> 데이터베이스간 이 CommentDTO 형태로 데이터를 주고받는다
@Getter
@Setter
public class CommentDTO extends CommonDTO {

    private Long idx;

    private Long boardIdx;

    private String content;

    private String writer;

}