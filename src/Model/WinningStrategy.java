package Model;

public interface WinningStrategy {
    public boolean checkWinner(Board board, Move lastMove);
}
