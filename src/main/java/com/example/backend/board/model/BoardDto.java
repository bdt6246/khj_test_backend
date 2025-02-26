package com.example.backend.board.model;

import com.example.backend.comment.model.CommentDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BoardDto {

  @Getter
  public static class BoardRegisterReq {
    private String title;
    private String content;
    private String writer;

    public Board toEntity() {
      return Board.builder()
          .title(title)
          .content(content)
          .writer(writer)
          .build();
    }
  }

  @Getter
  @AllArgsConstructor
  @NoArgsConstructor
  @Builder
  public static class BoardListResp{
    private Long idx;
    private String title;
    private String writer;
    private int commentCnt;

    public static BoardListResp from(Board board) {
      return BoardListResp.builder()
          .idx(board.getIdx())
          .title(board.getTitle())
          .writer(board.getWriter())
          .commentCnt((int) board.getComments().stream().map(CommentDto.CommentInstanceResp::from).count())
          .build();
    }
  }

  @Getter
  @AllArgsConstructor
  @NoArgsConstructor
  @Builder
  public static class BoardInstanceResp {
    private Long idx;
    private String title;
    private String content;
    private String writer;
    private List<CommentDto.CommentInstanceResp>comments = new ArrayList<>();

    public static BoardInstanceResp from (Board board){
      return BoardInstanceResp.builder()
          .idx(board.getIdx())
          .title(board.getTitle())
          .content(board.getContent())
          .writer(board.getWriter())
          .comments(board.getComments().stream().map(CommentDto.CommentInstanceResp::from).collect(Collectors.toList()))
          .build();
    }
  }


}
