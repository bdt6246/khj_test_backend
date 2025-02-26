package com.example.backend.comment.model;

import com.example.backend.board.model.Board;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class CommentDto {
  @Getter
  public static class CommentRegisterReq {
    private String content;
    private String writer;
    private Long boardIdx;

    public Comment toEntity(Board board) {
      return Comment.builder()
          .content(content)
          .writer(writer)
          .board(board)
          .build();
    }
  }

  @Getter
  @AllArgsConstructor
  @NoArgsConstructor
  @Builder
  public static class CommentInstanceResp{
    private String content;
    private String writer;
    public static CommentInstanceResp from (Comment comment){
      return CommentInstanceResp.builder()
          .content(comment.getContent())
          .writer(comment.getWriter())
          .build();
    }
  }
}
