package Model;

import java.util.List;

public class Game {
    private Board board;
    private List<Player> playerList;
    private Player winner;
    private int nextPlayerIndex;
    private List<Move> moves;
    private GameStatus status;
    private List<WinningStrategy> winningStrategies;


}
