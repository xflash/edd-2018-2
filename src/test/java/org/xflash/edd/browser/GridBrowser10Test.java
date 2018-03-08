package org.xflash.edd.browser;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.xflash.edd.model.Coord;
import org.xflash.edd.model.Grid;
import org.xflash.edd.model.GridPart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class GridBrowser10Test {

    private final GridPart[] gridParts;
    private final Grid grid;
    private final Coord coord;

    public GridBrowser10Test(final String name, final int[][] cells, final Coord coord, final GridPart[] gridParts) {
        this.grid = new Grid(cells);
        this.coord = coord;
        this.gridParts = gridParts;

    }

    @Parameterized.Parameters(name = "{0}")
    public static Collection<Object[]> data() {
        return Arrays.asList(
                new Object[]{
                        "checkForLU",
                        new int[][]{
                                {10, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                {0, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                {0, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                {0, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                {0, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                {0, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                {0, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                {0, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                {0, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        },
                        new Coord(0, 0),
                        new GridPart[]{
                                GridPart.build(0, 0, 0, 9),
                                GridPart.build(0, 0, 9, 0)
                        }
                },
                new Object[]{
                        "checkForRB",
                        new int[][]{
                                {1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                                {1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                                {1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                                {1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                                {1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                                {1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                                {1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                                {1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                                {1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0, 0, 10},
                        },
                        new Coord(9, 9),
                        new GridPart[]{
                                GridPart.build(9, 0, 9, 9),
                                GridPart.build(0, 9, 9, 9)
                        }
                },
                new Object[]{
                        "checkForMiddleV",
                        new int[][]{
                                {1, 1, 1, 1, 1, 1, 1, 1, 0, 1},
                                {1, 1, 1, 1, 1, 1, 1, 1, 0, 1},
                                {1, 1, 1, 1, 1, 1, 1, 1, 0, 1},
                                {1, 1, 1, 1, 1, 1, 1, 1, 0, 1},
                                {1, 1, 1, 1, 1, 1, 1, 1, 0, 1},
                                {1, 1, 1, 1, 1, 1, 1, 1, 0, 1},
                                {1, 1, 1, 1, 1, 1, 1, 1, 0, 1},
                                {1, 1, 1, 1, 1, 1, 1, 1, 0, 1},
                                {1, 1, 1, 1, 1, 1, 1, 1, 0, 1},
                                {0, 0, 0, 0, 0, 0, 0, 0, 10, 0},
                        },
                        new Coord(8, 9),
                        new GridPart[]{
                                GridPart.build(8, 0, 8, 9),
                                GridPart.build(0, 9, 9, 9)
                        }
                },
                new Object[]{
                        "checkForMiddleH",
                        new int[][]{
                                {0, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                {10, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                {0, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                {0, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                {0, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                {0, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                {0, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                {0, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                {0, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        },
                        new Coord(0, 1),
                        new GridPart[]{
                                GridPart.build(0, 0, 0, 9),
                                GridPart.build(0, 1, 9, 1)
                        }
                },
                new Object[]{
                        "checkForWider",
                        new int[][]{
                                {10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        },
                        new Coord(0, 0),
                        new GridPart[]{
                                GridPart.build(0, 0, 0, 9),
                                GridPart.build(0, 0, 9, 0)
                        }
                },
                new Object[]{
                        "checkForWider1",
                        new int[][]{
                                {1, 0, 1, 1, 1, 1, 1, 1, 1, 1},
                                {0, 10, 0, 0, 0, 0, 0, 0, 0, 0},
                                {1, 0, 1, 1, 1, 1, 1, 1, 1, 1},
                                {1, 0, 1, 1, 1, 1, 1, 1, 1, 1},
                                {1, 0, 1, 1, 1, 1, 1, 1, 1, 1},
                                {1, 0, 1, 1, 1, 1, 1, 1, 1, 1},
                                {1, 0, 1, 1, 1, 1, 1, 1, 1, 1},
                                {1, 0, 1, 1, 1, 1, 1, 1, 1, 1},
                                {1, 0, 1, 1, 1, 1, 1, 1, 1, 1},
                                {1, 0, 1, 1, 1, 1, 1, 1, 1, 1},
                        },
                        new Coord(1, 1),
                        new GridPart[]{
                                GridPart.build(0, 1, 9, 1),
                                GridPart.build(1, 1, 10, 1),
                                GridPart.build(1, 0, 1, 9),
                                GridPart.build(1, 1, 1, 10),
                        }
                },
                new Object[]{
                        "checkForWider2",
                        new int[][]{
                                {1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1},
                                {1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1},
                                {0, 0, 10, 0, 0, 0, 0, 0, 0, 0, 0},
                                {1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1},
                                {1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1},
                                {1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1},
                                {1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1},
                                {1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1},
                                {1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1},
                                {1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1},
                                {1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1},
                        },
                        new Coord(2, 2),
                        new GridPart[]{
                                GridPart.build(0, 2, 9, 2),
                                GridPart.build(1, 2, 10, 2),
                                GridPart.build(2, 0, 2, 9),
                                GridPart.build(2, 1, 2, 10),
                        }
                },
                new Object[]{
                        "checkForFull",
                        new int[][]{
                                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 10, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        },
                        new Coord(5, 5),
                        new GridPart[]{
                                //CROSS
                                //1x10
                                GridPart.build(0, 5, 9, 5),
                                GridPart.build(1, 5, 10, 5),
                                GridPart.build(2, 5, 11, 5),
                                //10x1
                                GridPart.build(5, 0, 5, 9),
                                GridPart.build(5, 1, 5, 10),
                                GridPart.build(5, 2, 5, 10),
//TODO decribe the 2x5, 5x2 possibilities
                        }
                }
        );
    }

    @Test
    public void checking() throws Exception {
        ArrayList<GridPart> gridParts = new ArrayList<>();
        new GridBrowser(grid).forEachGridParts(coord, gridParts::add);
        Assert.assertEquals("gridparts size should be of size: " + this.gridParts.length, this.gridParts.length, gridParts.size());
        for (GridPart gridPart : this.gridParts) {
            Assert.assertTrue("grid part " + gridPart + " should be present", gridParts.contains(gridPart));
        }
    }


}