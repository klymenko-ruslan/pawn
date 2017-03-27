package com.klymenko.pawn.scala

/**
  * Created by Unicorn on 26.03.2017.
  */
class Board(val boardSize : Integer, val straightStep : Integer, val diagonalStep : Integer) {
  private val board = Array.ofDim[Integer](boardSize, boardSize)
  private val cellsAmount = boardSize * boardSize
  var cellsVisited : Integer = 0

  def shouldBeVisited(cell : GameCell) = {
    cell.x < boardSize &&
    cell.y < boardSize &&
    board(cell.y)(cell.x) == null
  }

  def visit(cell : GameCell) = {
    if(shouldBeVisited(cell)) {
      cellsVisited += 1
      board(cell.y)(cell.x) = cellsVisited
    }
  }

  def isBoardFullyVisited() = cellsVisited == cellsAmount

  override def toString() : java.lang.String = {
    val res = new StringBuilder()
    for(i <- 0 until board.length){
      for(j <- 0 until board(0).length){
        res.append(board(i)(j)).append(" ")
      }
      res.append("\n")
    }
    res.toString()
  }
}
object Board {
  val DEFAULT_BOARD_SIZE = 10
  val DEFAULT_STRAIGHT_STEP = 3
  val DEFAULT_DIAGONAL_STEP = 2
}
