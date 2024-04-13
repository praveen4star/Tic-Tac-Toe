package controller;

import Model.*;

import java.util.List;

public class GameController {
    public Game createGame(int dimension, List<Player> players, List<WinningStrategy> winningStrategies){
        try {
            return Game.getGameBuilder()
                    .setDimension(dimension)
                    .setPlayerList(players)
                    .setWinningStrategy(winningStrategies)
                    .build();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    public void displayBoard(Game game){
        game.getBoard().displayBoard();
    }
    public GameState getGameState(Game game){
        return game.getState();
    }
    public void executeMove(Game game){
        int nextPlayerIndex = game.getNextPlayerIndex();
        Player player = game.getPlayerList().get(nextPlayerIndex);
        Move move = player.makeMove(game.getBoard());
        game.addMove(move);
    }
    public Player getWinner(Game game){
        return game.getWinner();
    }
}
