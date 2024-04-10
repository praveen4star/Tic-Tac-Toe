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
}
