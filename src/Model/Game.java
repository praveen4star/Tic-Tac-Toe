package Model;

import exception.InvalidBotCountException;
import exception.InvalidDimensionException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Game {
    private Board board;
    private List<Player> playerList;
    private Player winner;
    private int nextPlayerIndex;
    private List<Move> moves;
    private GameStatus status;
    private List<WinningStrategy> winningStrategies;
    private Game(Board board, List<Player> playerList, List<WinningStrategy> winningStrategies){
        this.board = board;
        this.playerList = playerList;
        this.winningStrategies = winningStrategies;
        this.status = GameStatus.IN_PROGRESS;
        this.nextPlayerIndex = 0;
        this.moves = new ArrayList<>();
    }
    public static class GameBuilder{
        private int dimension;
        private List<Player> playerList;
        private List<WinningStrategy> winningStrategies;
        private Board board;
        public GameBuilder(){
            this.playerList = new ArrayList<>();
            this.winningStrategies = new ArrayList<>();
        }
        public GameBuilder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }
        public GameBuilder addPlayer(Player player){
            this.playerList.add(player);
            return this;
        }
        public GameBuilder addWinningStrategy(WinningStrategy winningStrategy){
            this.winningStrategies.add(winningStrategy);
            return this;
        }
        private void validateDimension(){
            if(dimension < 3 || dimension > 10){
                throw new InvalidDimensionException("Invalid dimension");
            }

        }
        private void validateBotCount(){
            int botCount = 0;
            for(Player player : playerList){
                if(player.getPlayerType().equals(PlayerType.BOT)){
                    botCount++;
                }
            }
            if(botCount > 1){
                throw new InvalidBotCountException("Invalid bot count");
            }
        }
        private void validateUniquePlayerSymbol(){
            Set<Character> set = new HashSet<>();
            for(Player player : playerList){
                set.add(player.getSymbol().getSymbolChar());
            }
            if(set.size() != playerList.size()){
                throw new IllegalArgumentException("Player symbols must be unique");
            }
        }
        private void validator(){
            validateDimension();
            validateBotCount();
            validateUniquePlayerSymbol();
        }
        public Game build(){
            validator();
            board = new Board(dimension);
            return new Game(board, playerList, winningStrategies);
        }
    }
}
