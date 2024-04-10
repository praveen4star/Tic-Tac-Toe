package Model;

public interface WinningStrategy {
    public Player checkWinner(Board board, Move lastMove);
}
