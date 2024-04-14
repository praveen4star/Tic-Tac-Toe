import Model.*;
import controller.GameController;
import strategies.winningStrategy.OrderOneWinningStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TicTacToeGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Tic Tac Toe\n");

        System.out.println("Enter the dimension of the board");

        int dimension = sc.nextInt();
        System.out.println("Do you have a bot? (Y/N)");
        int iterations = dimension-1;
        String hasBot = sc.next();
        if(hasBot.equals("Y")){
            iterations = dimension-2;
        }
        List<Player> players = new ArrayList<>();
        for(int i = 0; i<iterations; i++){
            System.out.println("Enter the name of player "+(i+1));
            String name = sc.next();
            System.out.println("Enter the symbol of player "+(i+1));
            char symbol = sc.next().charAt(0);
            Player player = new Player(name, new Symbol(symbol), PlayerType.HUMAN);
            players.add(player);
        }
        if(hasBot.equals("Y")){
            System.out.println("Enter the name of the bot");
            String name = sc.next();
            System.out.println("Enter the symbol of the bot");
            char symbol = sc.next().charAt(0);
            Player bot = new BotPlayer(name, new Symbol(symbol), BotDifficultyLevel.EASY);
            players.add(bot);
        }
        Board board = new Board(dimension);
        List<WinningStrategy> winningStrategies = new ArrayList<>();
        winningStrategies.add(new OrderOneWinningStrategy(dimension));
        GameController gameController = new GameController();
        Game game = gameController.createGame(dimension, players, winningStrategies);
        while(gameController.getGameState(game).equals(GameState.IN_PROGRESS)){
            gameController.displayBoard(game);
            gameController.executeMove(game);
            System.out.println('\n');
        }

        System.out.println("Game Over");
        gameController.displayBoard(game);
        if(gameController.getGameState(game).equals(GameState.DRAW)){
            System.out.println("The game is a draw");
        }
        if(gameController.getGameState(game).equals(GameState.SUCCESS)){
            System.out.println("The game is won by "+gameController.getWinner(game).getName());
        }
    }
}
