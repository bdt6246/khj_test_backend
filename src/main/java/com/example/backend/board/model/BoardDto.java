package com.example.backend.board.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
    private List<BoardInstanceResp> boardList;

    public static BoardListResp from(List<Board> board) {
      return BoardListResp.builder()
          .boardList(board.stream().map(BoardDto.BoardInstanceResp::from).collect(Collectors.toList()))
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

    public static BoardInstanceResp from (Board board){
      return BoardInstanceResp.builder()
          .idx(board.getIdx())
          .title(board.getTitle())
          .content(board.getContent())
          .writer(board.getWriter())
          .build();
    }
  }
}
