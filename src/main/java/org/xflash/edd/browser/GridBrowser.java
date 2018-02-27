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
    public void forEachGridParts(Coord coord, Consumer<GridPart> consumer) {
        if (coord.y >= grid.cells.length || coord.x >= grid.cells[coord.y].length)
            throw new IllegalArgumentException("Coord are out of cell length");
        int v = grid.cells[coord.y][coord.x];
        switch (v) {
            case 1:
                GridPart build = GridPart.build(coord, coord);
                checkAndConsume(consumer, build);
                return;
            case 2:
                checkAndConsume(consumer, GridPart.build(coord.move(0, -1), coord));
                checkAndConsume(consumer, GridPart.build(coord, coord.move(1, 0)));
                checkAndConsume(consumer, GridPart.build(coord, coord.move(0, 1)));
                checkAndConsume(consumer, GridPart.build(coord.move(-1, 0), coord));
                return;
            case 3:
                checkAndConsume(consumer, GridPart.build(coord.move(-2, 0), coord));
                checkAndConsume(consumer, GridPart.build(coord.move(-1, 0), coord.move(1, 0)));
                checkAndConsume(consumer, GridPart.build(coord, coord.move(2, 0)));

                checkAndConsume(consumer, GridPart.build(coord.move(0, -2), coord));
                checkAndConsume(consumer, GridPart.build(coord.move(0, -1), coord.move(0, 1)));
                checkAndConsume(consumer, GridPart.build(coord, coord.move(0, 2)));
                return;
            case 4:
//                consumer.accept(GridPart.build(coord, coord));
                return;
            default:
                throw new IllegalArgumentException("Value v is not handled actually");
        }
    }

    private void checkAndConsume(Consumer<GridPart> consumer, GridPart gridPart) {
        Coord lu = gridPart.lu;
        if (lu.x < 0 || lu.x >= grid.w) return;
        if (lu.y < 0 || lu.y >= grid.h) return;
        Coord rb = gridPart.rb;
        if (rb.x < 0 || rb.x >= grid.w) return;
        if (rb.y < 0 || rb.y >= grid.h) return;
        consumer.accept(gridPart);
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
