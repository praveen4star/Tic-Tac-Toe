package Model;

public class Cell {
    private  int row;
    private int col;
    private CellState state;
    private  Player player;
    public Cell(int row, int col){
        this.row = row;
        this.col = col;
        this.state = CellState.EMPTY;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public CellState getState() {
        return state;
    }

    public Player getPlayer() {
        return player;
    }

    public void setState(CellState state) {
        this.state = state;
    }

    public void setPlayer(Player player) {
        state = CellState.FILLED;
        this.player = player;
    }

    public void display(){
        if(player == null){
            System.out.print("| |");
        } else if(state.equals(CellState.BLOCKED)){
            System.out.print("||||");
        } else {
            System.out.print("|" + player.getSymbol().getSymbolChar()+ "|");
        }
    }
}
