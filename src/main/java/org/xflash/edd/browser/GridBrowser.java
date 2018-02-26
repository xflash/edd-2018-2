package org.xflash.edd.browser;

import javafx.util.Pair;
import org.xflash.edd.model.Coord;
import org.xflash.edd.model.Grid;
import org.xflash.edd.model.GridPart;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class GridBrowser {
    private final Grid grid;

    public GridBrowser(Grid grid) {
        this.grid = grid;
    }

    public void forEachOrdered(BiConsumer<Integer, Coord> consumer) {
        List<Pair<Integer, Coord>> pairs = new ArrayList<>();
        forEach((v, c) -> pairs.add(new Pair<>(v, c)));
        pairs.sort((o1, o2) -> Integer.compare(o2.getKey(), o1.getKey()));
        for (Pair<Integer, Coord> pair : pairs) {
            consumer.accept(pair.getKey(), pair.getValue());
        }
    }

    private void forEach(BiConsumer<Integer, Coord> consumer) {
        for (int y = 0; y < grid.cells.length; y++) {
            int[] row = grid.cells[y];
            for (int x = 0; x < row.length; x++) {
                int cell = row[x];
                if (cell > 0)
                    consumer.accept(cell, new Coord(x, y));
            }
        }
    }

    /*
0 0 0 0
3 2 0 4
0 2 0 0
3 0 0 2
     */
    public void forEachGridParts(Coord coord, Consumer<GridPart> gridPartConsumer) {
        if (coord.y >= grid.cells.length || coord.x >= grid.cells[coord.y].length)
            throw new IllegalArgumentException("Coord are out of cell length");
        int v = grid.cells[coord.y][coord.x];
        if (v == 1) {
            gridPartConsumer.accept(GridPart.build(coord, coord));
            return;
        }

        if ((v % 2) != 0) {
            // odd
            findOddRects(coord, gridPartConsumer);

        } else {
            // even

        }

    }

    void findOddRects(Coord coord, Consumer<GridPart> gridPartConsumer) {
        int v = grid.cells[coord.y][coord.x];

        //find most-left coord
        int x0 = coord.x;
        while (x0 > 0
                && grid.cells[coord.y][x0] > 0
                && (coord.x - x0) <= v) {
            x0--;
        }

        for (int j = x0; j <= coord.x; j++) {
            boolean found = false;
            for (int i = j; i < coord.x + v; i++) {
                if (i >= grid.w) break;
                if (coord.x == i) continue;
                if (grid.cells[coord.y][i] != 0) found = true;
            }
            if (!found)
                gridPartConsumer.accept(GridPart.build(new Coord(x0, coord.y), new Coord(j + v - 1, coord.y)));
        }
    }

}
