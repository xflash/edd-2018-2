package org.xflash.edd.browser;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.xflash.edd.FileUtils;
import org.xflash.edd.model.Coord;
import org.xflash.edd.model.Grid;
import org.xflash.edd.model.GridPart;
import org.xflash.edd.reader.GridReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
public class GridBrowser2Test {

    private final Coord coord;
    private final List<GridPart> expected;
    private Grid grid;

    public GridBrowser2Test(Coord coord, List<GridPart> expected) {
        this.coord = coord;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(
                new Object[]{new Coord(3, 1), Arrays.asList(GridPart.build(2, 0, 3, 1), GridPart.build(2, 1, 3, 2))},
                new Object[]{new Coord(0, 1), Arrays.asList()},
                new Object[]{new Coord(0, 3), Arrays.asList()},
                new Object[]{new Coord(1, 1), Arrays.asList()},
                new Object[]{new Coord(1, 2), Arrays.asList()},
                new Object[]{new Coord(3, 3), Arrays.asList()}
        );
    }

    @Before
    public void setUp() throws Exception {
        grid = GridReader.from(FileUtils.classpath("grid1.txt"));
    }

    @Test
    public void checkGridParts() {
        GridBrowser gb = new GridBrowser(grid);
        ArrayList<GridPart> gridParts = new ArrayList<>();

        gb.forEachGridParts(coord, (gp) -> {
            System.out.println("gp = " + gp);
            gridParts.add(gp);
        });
        Assert.assertEquals(expected, gridParts);

    }
}