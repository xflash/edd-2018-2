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
public class GridBrowserForEachGridPartTest {

    private final String name;
    private final Coord coord;
    private final List<GridPart> expected;
    private Grid grid;

    public GridBrowserForEachGridPartTest(String name, Coord coord, List<GridPart> expected) {
        this.name = name;
        this.coord = coord;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "{0}")
    public static Collection<Object[]> data() {

        return Arrays.asList(
                new Object[]{
                        "horizontal",
                        new Coord(0, 3),
                        Arrays.asList(GridPart.build(0, 3, 2, 3))
                },
                new Object[]{
                        "vertical",
                        new Coord(0, 1),
                        Arrays.asList(GridPart.build(0, 0, 0, 2))
                },
                new Object[]{
                        "vertical 2",
                        new Coord(1, 1),
                        Arrays.asList(GridPart.build(0, 0, 0, 1))
                },
                new Object[]{
                        "vertical 4",
                        new Coord(3, 1),
                        Arrays.asList(
                                GridPart.build(2, 0, 3, 1),
                                GridPart.build(2, 1, 3, 2)
                        )
                }


        );
    }

    @Before
    public void setUp() throws Exception {
        grid = GridReader.from(FileUtils.classpath("grid1.txt"));
    }

    /*
    0 0 0 0
    3 2 0 4
    0 2 0 0
    3 0 0 2
    */
    @Test
    public void checkForEachGridPart() throws Exception {
        GridBrowser gb = new GridBrowser(grid);

        ArrayList<GridPart> gridParts = new ArrayList<>();
        gb.forEachGridParts(coord, gridParts::add);
        Assert.assertEquals("For value " + grid.cells[coord.y][coord.x] + " in " + coord, expected, gridParts);

    }

}