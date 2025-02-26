package com.example.backend.comment;

import com.example.backend.comment.model.CommentDto;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentController {
  private final  CommentService commentService;

  @Operation(summary = "댓글 등록", description = "게시글에 댓글을 등록하는 기능")
  @PostMapping("/register")
  public void commentRegister( @RequestBody CommentDto.CommentRegisterReq dto, @RequestParam Long boardIdx) {
    commentService.register(dto,  boardIdx);
  }
}
