package com.kodilla.patterns.builder.checkers;

/**
 *
 */
public class Board {
  public static final int MIN_INDEX = 0;
  public static final int MAX_INDEX = 9;
  Figure[][] board = new Figure[10][];

  public Board() {
    for (int n = 0; n < 10; n++) {
      board[n] = new Figure[10];
    }
  }

  public Figure getFigure(final int x, final int y) {
    return board[x][y];
  }

  public void setFigure(final Figure figure, final int x, final int y) {
    board[x][y] = figure;
  }

}