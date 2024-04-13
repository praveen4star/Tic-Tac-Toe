package Model;

import java.util.Scanner;

public class Player {
    private String name;
    private Symbol symbol;
    private PlayerType playerType;
    private Scanner scanner;
    public Player(String name, Symbol symbol, PlayerType playerType) {
        this.name = name;
        this.symbol = symbol;
        this.playerType = playerType;
        this.scanner = new Scanner(System.in);
    }

    public String getName() {
        return name;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }
    private int[] getMovePosition(Board board){
        System.out.println(this.getName()+" enter row for the move");
        int row = scanner.nextInt();
        System.out.println(this.getName()+" enter column for the move");
        int column = scanner.nextInt();
        if(row < 0  || column < 0 || row >= board.getSize() || column >= board.getSize() || !board.getCells().get(row).get(column).getState().equals(CellState.EMPTY)){
            System.out.println("Invalid move, try again");
            return getMovePosition(board);
        }
        return new int[]{row, column};
    }

    public Move makeMove(Board board){

        int movePosition[] = getMovePosition(board);
        int row = movePosition[0];
        int column = movePosition[1];

        board.getCells().get(row).get(column).setPlayer(this);
        return new Move(this, board.getCells().get(row).get(column));
    }
}
