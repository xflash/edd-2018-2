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

    private static List<Integer> findDivisors(int num) {
        List<Integer> res = new ArrayList<>();
        res.add(1);
        res.add(num);
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
//                System.out.print(i + " , ");
                res.add(i);
            }
        }
        res.sort(Integer::compareTo);
        return res;
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

        boolean prime = isPrime(v);
        List<Integer> divisors = findDivisors(v);
        LOGGER.info("Iterating each grid parts available at {} : {} prime: {} divisors {}", origin, v, prime, divisors);
        switch (v) {
            case 1:
                checkAndConsume(origin, GridPart.build(origin, origin), consumer);
            case 3:
                iterCrossParts(origin, v, consumer);
                return;
            case 5:
                iterCrossParts(origin, v, consumer);
                return;
            case 7:
                iterCrossParts(origin, v, consumer);
                return;
            case 9:
//                TODO review me as it is a square
                iterCrossParts(origin, v, consumer);
                return;
            case 11:
                iterCrossParts(origin, v, consumer);
                return;
            case 13:
                iterCrossParts(origin, v, consumer);
                return;
            case 2:
                iterCrossParts(origin, v, consumer);
//                checkAndConsume(origin, GridPart.build(origin.move(0, -1), origin), consumer);
//                checkAndConsume(origin, GridPart.build(origin, origin.move(1, 0)), consumer);
//                checkAndConsume(origin, GridPart.build(origin, origin.move(0, 1)), consumer);
//                checkAndConsume(origin, GridPart.build(origin.move(-1, 0), origin), consumer);
                return;
            case 4:
                iterCrossParts(origin, v, consumer);
                checkAndConsume(origin, GridPart.build(origin.move(0, -1), origin.move(1, 0)), consumer);
                checkAndConsume(origin, GridPart.build(origin, origin.move(1, 1)), consumer);
                checkAndConsume(origin, GridPart.build(origin.move(-1, 0), origin.move(0, 1)), consumer);
                checkAndConsume(origin, GridPart.build(origin.move(-1, -1), origin), consumer);
                return;

            case 6:
                iterCrossParts(origin, v, consumer);
                return;
            case 8:
                iterCrossParts(origin, v, consumer);
                return;
            case 10:
                iterCrossParts(origin, v, consumer);
                return;
            case 12:
                iterCrossParts(origin, v, consumer);
                return;
            default:
                throw new IllegalArgumentException("Value " + v + " is not handled actually");
        }
    }

    void iterEachDims(int num, BiConsumer<Integer, Integer> consumer) {
        List<Integer> divisors = findDivisors(num);
        for (Integer divisor : divisors) {
            consumer.accept(divisor, num / divisor);
        }
    }

    //checks whether an int is prime or not.
    private boolean isPrime(int n) {
        //check if n is a multiple of 2
        if (n % 2 == 0) return false;
        //if not, then just check the odds
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    private void iterCrossParts(Coord origin, int nb, Consumer<GridPart> consumer) {
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
