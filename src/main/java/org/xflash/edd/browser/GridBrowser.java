package org.xflash.edd.browser;

import javafx.util.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xflash.edd.model.Coord;
import org.xflash.edd.model.Grid;
import org.xflash.edd.model.GridPart;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class GridBrowser {
    public static final Logger LOGGER = LoggerFactory.getLogger(GridBrowser.class);
    private final Grid grid;

    public GridBrowser(Grid grid) {
        this.grid = grid;
    }

    public void forEachOrderedValue(BiConsumer<Integer, Coord> consumer) {
        LOGGER.info("Iterating each values in : {}", grid);

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
    public void forEachGridParts(Coord origin, Consumer<GridPart> consumer) {
        if (origin.y >= grid.cells.length || origin.x >= grid.cells[origin.y].length)
            throw new IllegalArgumentException("Coord are out of cell length");
        int v = grid.cells[origin.y][origin.x];
        LOGGER.info("Iterating each grid parts available at {} : {}", origin, v);
        switch (v) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 9:
            case 11:
            case 13:
                iterOddParts(origin, v, consumer);
                return;
            case 2:
                checkAndConsume(origin, GridPart.build(origin.move(0, -1), origin), consumer);
                checkAndConsume(origin, GridPart.build(origin, origin.move(1, 0)), consumer);
                checkAndConsume(origin, GridPart.build(origin, origin.move(0, 1)), consumer);
                checkAndConsume(origin, GridPart.build(origin.move(-1, 0), origin), consumer);
                return;
            case 4:
                checkAndConsume(origin, GridPart.build(origin.move(0, -1), origin.move(1, 0)), consumer);
                checkAndConsume(origin, GridPart.build(origin, origin.move(1, 1)), consumer);
                checkAndConsume(origin, GridPart.build(origin.move(-1, 0), origin.move(0, 1)), consumer);
                checkAndConsume(origin, GridPart.build(origin.move(-1, -1), origin), consumer);
                return;

            case 6:
            case 8:
            case 10:
            case 12:
            default:
                throw new IllegalArgumentException("Value " + v + " is not handled actually");
        }
    }

    private void iterOddParts(Coord origin, int nb, Consumer<GridPart> consumer) {
        for (int x = (-nb + 1); x <= 0; x++) {
            checkAndConsume(origin, GridPart.build(origin.move(x, 0), origin.move(x + nb - 1, 0)), consumer);
        }
        for (int y = (-nb + 1); y <= 0; y++) {
            checkAndConsume(origin, GridPart.build(origin.move(0, y), origin.move(0, y + nb - 1)), consumer);
        }
    }

    private void checkAndConsume(final Coord origin, GridPart gridPart, Consumer<GridPart> consumer) {
        if (!checkInGrid(gridPart)) return;
        if (isGridPartCollapsing(gridPart, origin)) return;
        LOGGER.info("Proposing GridPart {} ", gridPart);
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


    public boolean isGridPartCollapsing(GridPart gp, Coord coord) {
        HashSet<Coord> collapsing = new HashSet<>();
        forEach((integer, coord1) -> {
            if (coord1.equals(coord)) return;
            if (gp.collapse(GridPart.build(coord1, coord1)))
                collapsing.add(coord1);
        });
        return !collapsing.isEmpty();
    }
}
