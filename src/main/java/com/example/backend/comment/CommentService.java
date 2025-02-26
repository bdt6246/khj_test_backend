package com.example.backend.comment;

import com.example.backend.board.BoardRepository;
import com.example.backend.board.model.Board;
import com.example.backend.comment.model.Comment;
import com.example.backend.comment.model.CommentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentService {
  private final CommentRepository commentRepository;
  private final BoardRepository boardRepository;

  public void register(CommentDto.CommentRegisterReq dto, Long boardIdx) {
    Board board = boardRepository.findById(boardIdx).orElseThrow();
    Comment comment = dto.toEntity(board);
    commentRepository.save(comment);
  }
}
