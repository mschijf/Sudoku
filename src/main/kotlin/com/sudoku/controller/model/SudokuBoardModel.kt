package com.sudoku.controller.model

import com.sudoku.game.*
import com.sudoku.game.SudokuBoard.MAX_COL
import com.sudoku.game.SudokuBoard.MAX_ROW

class SudokuBoardModel(private val board: SudokuBoard)  {
    val fields = Array(MAX_ROW) {
            row -> Array(MAX_COL) {
            col -> FieldModel(col, row, squareToString(col, row), board.isLastSquarePlayed(row, col), board.getSquarePossibleValueString(row, col))
            } }
    val takeBackPossible = board.canUndo()
    val computePossible = board.hasSolutionStep()

    private fun squareToString(col: Int, row: Int): String {
        if (board.getSquareValue(row, col) <= 0)
            return ""
        return board.getSquareValue(row, col).toString()
    }
}


data class FieldModel(val col: Int, val row: Int, val value: String, val lastSquarePlayed: Boolean, val possibilitiesList:String)
