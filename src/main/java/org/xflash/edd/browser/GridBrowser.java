package org.xflash.edd.browser;

import org.xflash.edd.model.Grid;

import java.util.ArrayList;
import java.util.function.Consumer;

public class GridBrowser {
    private final Grid grid;

    public GridBrowser(Grid grid) {
        this.grid = grid;
    }

    public void forEachOrdered(Consumer<Integer> consumer) {
        ArrayList<Integer> integers = new ArrayList<>();
        forEach(integers::add);
        integers.sort((o1, o2) -> Integer.compare(o2, o1));
        for (Integer integer : integers) {
            consumer.accept(integer);
        }
    }

    private void forEach(Consumer<Integer> consumer) {
        for (int[] row : grid.cells) {
            for (int cell : row) {
                if (cell > 0)
                    consumer.accept(cell);
            }
        }
    }
}
