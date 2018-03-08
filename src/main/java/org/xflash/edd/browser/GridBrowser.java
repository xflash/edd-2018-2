package org.xflash.edd.browser;

import javafx.util.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xflash.edd.model.Coord;
import org.xflash.edd.model.Dim;
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

    private static List<Integer> findDivisors(int num) {
        List<Integer> res = new ArrayList<>();
        res.add(1);
        res.add(num);
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                res.add(i);
            }
        }
        res.sort(Integer::compareTo);
        return res;
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

    public void forEachGridParts(Coord origin, Consumer<GridPart> consumer) {
        int v = getVal(origin);
        LOGGER.info("Iterating each grid parts available at {} : {}", origin, v);

        forEachOffset(v, ((dim, offset) -> {
            Coord lu = origin.move(offset.x, offset.y);
            Coord rb = lu.move(dim.w - 1, dim.h - 1);
            GridPart gridPart = GridPart.build(lu, rb);
            LOGGER.debug("Checking if gridPart {} fit the grid", gridPart);
            checkAndConsume(origin, gridPart, consumer);
        }));
    }

    private int getVal(Coord origin) {
        if (origin.y >= grid.cells.length || origin.x >= grid.cells[origin.y].length)
            throw new IllegalArgumentException("Coord are out of cell length");
        return grid.cells[origin.y][origin.x];
    }

    void forEachOffset(int val, BiConsumer<Dim, Coord> offsetConsumer) {
        if (val == 1) {
            offsetConsumer.accept(new Dim(1, 1), new Coord(0, 0));
            return;
        }
        iterEachDims(val, (dim) -> {
            for (int x = -dim.w + 1; x <= 0; x++) {
                for (int y = -dim.h + 1; y <= 0; y++) {
                    Coord offset = new Coord(x, y);
                    LOGGER.debug("Proposing offset {}", offset);
                    offsetConsumer.accept(dim, offset);
                }
            }
        });
    }

    void iterEachDims(int num, Consumer<Dim> consumer) {
        for (Integer divisor : findDivisors(num)) {
            Dim dim = new Dim(divisor, num / divisor);
            LOGGER.debug("Trying dim {}", dim);
            consumer.accept(dim);
        }
    }

    private boolean isPrime(int n) {
        if (n % 2 == 0) return false;
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0)
                return false;
        }
        return true;
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
