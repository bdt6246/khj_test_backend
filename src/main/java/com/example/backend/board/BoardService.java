package com.example.backend.board;

import com.example.backend.board.model.Board;
import com.example.backend.board.model.BoardDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
  private final BoardRepository boardRepository;

  public void register(BoardDto.BoardRegisterReq dto) {
    boardRepository.save(dto.toEntity());
  }

  public List<BoardDto.BoardListResp> list() {
    List<Board> boardList = boardRepository.findAll();
    List<BoardDto.BoardListResp> responseList = new ArrayList<>();
    for (Board board : boardList) {
      responseList.add(BoardDto.BoardListResp.from(board));
    }

    return responseList;
  }

  public BoardDto.BoardInstanceResp read(Long boardIdx) {
    Board board = boardRepository.findById(boardIdx).orElseThrow();
    return  BoardDto.BoardInstanceResp.from(board);
  }
}
