package strategies.botPlayingStrategy;

import Model.*;

public class SimpleBotPlayingStrategy implements BotPlayingStrategy {
    @Override
    public Move makeMove(Board board, Player player) {
        int row = (int) (Math.random() * board.getSize());
        int column = (int) (Math.random() * board.getSize());
        while (!board.getCells().get(row).get(column).getState().equals(CellState.EMPTY)) {
            row = (int) (Math.random() * board.getSize());
            column = (int) (Math.random() * board.getSize());
        }
        board.getCells().get(row).get(column).setPlayer(player);
        return new Move(player, board.getCells().get(row).get(column));
    }
}
