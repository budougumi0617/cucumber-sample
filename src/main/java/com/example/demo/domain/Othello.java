package com.example.demo.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Othello {
  Board board;

  public void start() {
    this.board = new Board();
    this.board.setOthelloBoard();
  }

  public boolean canSetPiece(int player, int row, int column) {
    return false;
  }
}
