package com.example.backend.board;

import com.example.backend.board.model.BoardDto;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
  private final BoardService boardService;

  @Operation(summary = "게시글 목록 조회", description = "등록된 게시글을 목록 형태로 확인하는 기능")
  @GetMapping("/list")
  public ResponseEntity<BoardDto.BoardListResp> list() {
    BoardDto.BoardListResp response = boardService.list();
    return ResponseEntity.ok(response);
  }

  @Operation(summary = "게시글 상세 조회", description = "게시글의 Idx 값을 이용해 게시글의 상세 내용을 확인하는 기능")
  @GetMapping("/{boardIdx}")
  public ResponseEntity<BoardDto.BoardInstanceResp> read(@PathVariable Long boardIdx) {
    BoardDto.BoardInstanceResp response = boardService.read(boardIdx);
    return ResponseEntity.ok(response);
  }

  @Operation(summary = "게시글 등록", description = "게시글을 등록하는 기능")
  @PostMapping("/register")
  public void register( @RequestBody BoardDto.BoardRegisterReq dto) {
    boardService.register(dto);
  }
}
