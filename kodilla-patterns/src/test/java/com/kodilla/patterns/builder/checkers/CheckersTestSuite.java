package com.kodilla.patterns.builder.checkers;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 */
public class CheckersTestSuite {
  @Test
  public void testCheckersBuilder() {
    //Given
    final Checkers checkers = new Checkers.CheckersBuilder()
        .playerOne("John")
        .playerTwo("Theresa")
        .figure(FigureFactory.PAWN, Figure.WHITE, 0, 3)
        .figure(FigureFactory.PAWN, Figure.BLACK, 9, 7)
        .figure(FigureFactory.QUEEN, Figure.WHITE, 0, 2)
        .build();
    System.out.println(checkers.getBoard());

    //When
    final Figure figureOne = checkers.getBoard().getFigure(0, 3);
    final Figure figureTwo = checkers.getBoard().getFigure(9, 7);
    final Figure figureThree = checkers.getBoard().getFigure(0, 2);
    final Figure figureFour = checkers.getBoard().getFigure(1, 1);

    //Then
    Assert.assertEquals(Figure.WHITE, figureOne.getColor());
    Assert.assertEquals(Pawn.class, figureTwo.getClass());
    Assert.assertEquals(Queen.class, figureThree.getClass());
    Assert.assertNull(figureFour);
  }
}