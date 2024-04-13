package Model;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private int size;
    private List<List<Cell>> cells;
    public Board(int size){
        this.size = size;
        this.cells = new ArrayList<>();
        for(int i = 0; i < size; i++){
            List<Cell> row = new ArrayList<>();
            for(int j = 0; j < size; j++){
                row.add(new Cell(i, j));
            }
            cells.add(row);
        }

    }
    public List<List<Cell>> getCells() {
        return cells;
    }
    public int getSize() {
        return size;
    }
    public void displayBoard(){
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                cells.get(i).get(j).display();
            }
            System.out.println();
        }
    }
}
