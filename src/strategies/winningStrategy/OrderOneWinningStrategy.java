package strategies.winningStrategy;

import Model.Board;
import Model.Move;
import Model.Player;
import Model.WinningStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderOneWinningStrategy implements WinningStrategy {
    List<Map<Character, Integer>> rowWise;
    List<Map<Character, Integer>> columnWise;
    public OrderOneWinningStrategy(int size){
        rowWise = new ArrayList<>();
        columnWise = new ArrayList<>();
        for(int i = 0; i<size; i++){
            rowWise.add(new HashMap<>());
            columnWise.add(new HashMap<>());
        }
    }
    public boolean checkRowWiseWinner(Board board, Move LastMove){
        int row = LastMove.getCell().getRow();
        char symbol = LastMove.getPlayer().getSymbol().getSymbolChar();
        rowWise.get(row).put(symbol, rowWise.get(row).getOrDefault(symbol, 0)+1);
        return rowWise.get(row).get(symbol) == board.getSize();
    }
    public boolean checkColumnWiseWinner(Board board, Move LastMove){
        int column = LastMove.getCell().getCol();
        char symbol = LastMove.getPlayer().getSymbol().getSymbolChar();
        columnWise.get(column).put(symbol, columnWise.get(column).getOrDefault(symbol, 0)+1);
        return columnWise.get(column).get(symbol) == board.getSize();
    }
    @Override
    public boolean checkWinner(Board board, Move LastMove) {
        return checkRowWiseWinner(board, LastMove) ||  checkColumnWiseWinner(board, LastMove);
    }
}

/**
 * row wise winner
 * column wise winner
 * diagonal wise winner
 * anti-diagonal wise winner
 * corner wise winner
 * */