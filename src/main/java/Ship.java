import java.util.List;

/**
 * Created by kot on 07.11.14.
 */
public class Ship {

    private final String name;
    private final List<Cell> cells;

    public Ship(List<Cell> cells, String name) {

        this.cells = cells;
        this.name = name;

    }

    public List<Cell> getCells() {
        return this.cells;
    }

    public String getName() {
        return name;
    }

    public boolean contains(Cell cell) {
        for (Cell _cell: this.cells) {
            if (_cell.equals(cell)) {
                return true;
            }
        }
        return false;
    }
}


