package strategies.winningStrategy;

import Model.Board;
import Model.Move;
import Model.Player;
import Model.WinningStrategy;

public class OrderOneWinningStrategy implements WinningStrategy {

    public Player checkWinner(Board board, Move LastMove) {
        return null;
    }
}

/**
 * row wise winner
 * column wise winner
 * diagonal wise winner
 * anti-diagonal wise winner
 * corner wise winner
 * */