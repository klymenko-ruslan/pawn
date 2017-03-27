package com.klymenko.pawn.scala

import java.util

import scala.collection.mutable.ListBuffer

/**
  * Created by Unicorn on 26.03.2017.
  */
object UniqueMovementAlgorithm {
  def findPath(board: Board, currentCell: GameCell) {
    if(board.shouldBeVisited(currentCell)) {
      board.visit(currentCell)
      for(availableCell <- getAvailableCells(currentCell, board)) {
        if(board.shouldBeVisited(availableCell)) {
          findPath(board, availableCell)
        }
      }
    }
  }

  def getAvailableCells(currentCell : GameCell, board : Board) = {
    val availableCells = ListBuffer[GameCell]();
    if(currentCell.y - board.straightStep >= 0) availableCells += new GameCell(currentCell.x, currentCell.y - board.straightStep);
    if(currentCell.y + board.straightStep < board.boardSize) availableCells += new GameCell(currentCell.x, currentCell.y + board.straightStep);
    if(currentCell.x - board.straightStep >= 0) availableCells += new GameCell(currentCell.x - board.straightStep, currentCell.y);
    if(currentCell.x + board.straightStep < board.boardSize) availableCells += new GameCell(currentCell.x + board.straightStep, currentCell.y);
    if(currentCell.x + board.diagonalStep < board.boardSize && currentCell.y - board.diagonalStep >= 0) availableCells += new GameCell(currentCell.x + board.diagonalStep, currentCell.y - board.diagonalStep)
    if(currentCell.x - board.diagonalStep >= 0 && currentCell.y - board.diagonalStep >= 0) availableCells += new GameCell(currentCell.x - board.diagonalStep, currentCell.y - board.diagonalStep)
    if(currentCell.x + board.diagonalStep < board.boardSize && currentCell.y + board.diagonalStep < board.boardSize) availableCells += new GameCell(currentCell.x + board.diagonalStep, currentCell.y + board.diagonalStep)
    if(currentCell.x - board.diagonalStep >= 0 && currentCell.y + board.diagonalStep < board.boardSize) availableCells += new GameCell(currentCell.x - board.diagonalStep, currentCell.y + board.diagonalStep)
    availableCells;
  }
}
