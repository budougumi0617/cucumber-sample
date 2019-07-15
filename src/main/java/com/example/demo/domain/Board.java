package com.example.demo.domain;

import lombok.Data;

@Data
public class Board {
  int[][] board;


  void setOthelloBoard() {
    this.board = new int[CodeConstant.Othello.SQUARE][CodeConstant.Othello.SQUARE];
    this.board[3][3] = CodeConstant.Othello.piece.PLAYER_1;
    this.board[4][4] = CodeConstant.Othello.piece.PLAYER_1;
    this.board[3][4] = CodeConstant.Othello.piece.PLAYER_2;
    this.board[4][3] = CodeConstant.Othello.piece.PLAYER_2;
  }

  public boolean canSetOthelloPlayerPiece(int player, int row, int column) {
    int piece = board[row][column];
    if (piece != 0 || piece == player) {
      return false;
    }
    return true;
  }
}