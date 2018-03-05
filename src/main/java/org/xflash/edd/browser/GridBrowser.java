package org.xflash.edd.browser;

import javafx.util.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xflash.edd.model.Coord;
import org.xflash.edd.model.Grid;
import org.xflash.edd.model.GridPart;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class GridBrowser {
    public static final Logger LOGGER = LoggerFactory.getLogger(GridBrowser.class);
    private final Grid grid;

    public GridBrowser(Grid grid) {
        this.grid = grid;
    }

    public void forEachOrdered(BiConsumer<Integer, Coord> consumer) {
        LOGGER.info("Iterating on each val in grid : {}", grid);

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
            case 3:
            case 5:
            case 7:
            case 9:
            case 11:
            case 13:
                iterOddParts(coord, v, consumer);
                return;
            case 2:
                checkAndConsume(consumer, GridPart.build(coord.move(0, -1), coord));
                checkAndConsume(consumer, GridPart.build(coord, coord.move(1, 0)));
                checkAndConsume(consumer, GridPart.build(coord, coord.move(0, 1)));
                checkAndConsume(consumer, GridPart.build(coord.move(-1, 0), coord));
                return;
            case 4:
                checkAndConsume(consumer, GridPart.build(coord.move(0, -1), coord.move(1, 0)));
                checkAndConsume(consumer, GridPart.build(coord, coord.move(1, 1)));
                checkAndConsume(consumer, GridPart.build(coord.move(-1, 0), coord.move(0, 1)));
                checkAndConsume(consumer, GridPart.build(coord.move(-1, -1), coord));
                return;
            default:
                throw new IllegalArgumentException("Value " + v + " is not handled actually");
        }
    }

    private void iterOddParts(Coord coord, int nb, Consumer<GridPart> consumer) {
        for (int x = (-nb + 1); x <= 0; x++) {
            checkAndConsume(consumer, GridPart.build(coord.move(x, 0), coord.move(x + nb - 1, 0)));
        }
        for (int y = (-nb + 1); y <= 0; y++) {
            checkAndConsume(consumer, GridPart.build(coord.move(0, y), coord.move(0, y + nb - 1)));
        }
    }

    private void checkAndConsume(Consumer<GridPart> consumer, GridPart gridPart) {
        if (!checkInGrid(gridPart)) return;
        consumer.accept(gridPart);
    }

    private boolean checkInGrid(GridPart gridPart) {
        Coord lu = gridPart.lu;
        Coord rb = gridPart.rb;
        return lu.x >= 0 && lu.x < grid.w
                && lu.y >= 0 && lu.y < grid.h
                && rb.x >= 0 && rb.x < grid.w
                && rb.y >= 0 && rb.y < grid.h;
    }



}
