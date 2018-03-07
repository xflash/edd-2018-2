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
public class GridBrowser7Test {

    private final GridPart[] gridParts;
    private final Grid grid;
    private final Coord coord;

    public GridBrowser7Test(final String name, final int[][] cells, final Coord coord, final GridPart[] gridParts) {
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
                                {7, 0, 0, 0, 0, 0, 0},
                                {0, 1, 1, 1, 1, 1, 1},
                                {0, 1, 1, 1, 1, 1, 1},
                                {0, 1, 1, 1, 1, 1, 1},
                                {0, 1, 1, 1, 1, 1, 1},
                                {0, 1, 1, 1, 1, 1, 1},
                                {0, 1, 1, 1, 1, 1, 1},
                        },
                        new Coord(0, 0),
                        new GridPart[]{
                                GridPart.build(0, 0, 0, 6),
                                GridPart.build(0, 0, 6, 0)
                        }
                },
                new Object[]{
                        "checkForRB",
                        new int[][]{
                                {1, 1, 1, 1, 1, 1, 0},
                                {1, 1, 1, 1, 1, 1, 0},
                                {1, 1, 1, 1, 1, 1, 0},
                                {1, 1, 1, 1, 1, 1, 0},
                                {1, 1, 1, 1, 1, 1, 0},
                                {1, 1, 1, 1, 1, 1, 0},
                                {0, 0, 0, 0, 0, 0, 7},
                        },
                        new Coord(6, 6),
                        new GridPart[]{
                                GridPart.build(6, 0, 6, 6),
                                GridPart.build(0, 6, 6, 6)
                        }
                },
                new Object[]{
                        "checkForMiddleV",
                        new int[][]{
                                {1, 1, 1, 1, 1, 0, 1},
                                {1, 1, 1, 1, 1, 0, 1},
                                {1, 1, 1, 1, 1, 0, 1},
                                {1, 1, 1, 1, 1, 0, 1},
                                {1, 1, 1, 1, 1, 0, 1},
                                {1, 1, 1, 1, 1, 0, 1},
                                {0, 0, 0, 0, 0, 7, 0},
                        },
                        new Coord(5, 6),
                        new GridPart[]{
                                GridPart.build(5, 0, 5, 6),
                                GridPart.build(0, 6, 6, 6)
                        }
                },
                new Object[]{
                        "checkForMiddleH",
                        new int[][]{
                                {0, 1, 1, 1, 1, 1, 1},
                                {7, 0, 0, 0, 0, 0, 0},
                                {0, 1, 1, 1, 1, 1, 1},
                                {0, 1, 1, 1, 1, 1, 1},
                                {0, 1, 1, 1, 1, 1, 1},
                                {0, 1, 1, 1, 1, 1, 1},
                                {0, 1, 1, 1, 1, 1, 1},
                        },
                        new Coord(0, 1),
                        new GridPart[]{
                                GridPart.build(0, 0, 0, 6),
                                GridPart.build(0, 1, 6, 1)
                        }
                },
                new Object[]{
                        "checkForWider",
                        new int[][]{
                                {7, 0, 0, 0, 0, 0, 0, 0},
                                {0, 1, 1, 1, 1, 1, 1, 1},
                                {0, 1, 1, 1, 1, 1, 1, 1},
                                {0, 1, 1, 1, 1, 1, 1, 1},
                                {0, 1, 1, 1, 1, 1, 1, 1},
                                {0, 1, 1, 1, 1, 1, 1, 1},
                                {0, 1, 1, 1, 1, 1, 1, 1},
                                {0, 1, 1, 1, 1, 1, 1, 1},
                        },
                        new Coord(0, 0),
                        new GridPart[]{
                                GridPart.build(0, 0, 0, 6),
                                GridPart.build(0, 0, 6, 0)
                        }
                },
                new Object[]{
                        "checkForWider1",
                        new int[][]{
                                {1, 0, 1, 1, 1, 1, 1, 1},
                                {0, 7, 0, 0, 0, 0, 0, 0},
                                {1, 0, 1, 1, 1, 1, 1, 1},
                                {1, 0, 1, 1, 1, 1, 1, 1},
                                {1, 0, 1, 1, 1, 1, 1, 1},
                                {1, 0, 1, 1, 1, 1, 1, 1},
                                {1, 0, 1, 1, 1, 1, 1, 1},
                                {1, 0, 1, 1, 1, 1, 1, 1},
                        },
                        new Coord(1, 1),
                        new GridPart[]{
                                GridPart.build(0, 1, 6, 1),
                                GridPart.build(1, 1, 7, 1),
                                GridPart.build(1, 0, 1, 6),
                                GridPart.build(1, 1, 1, 7),
                        }
                },
                new Object[]{
                        "checkForWider2",
                        new int[][]{
                                {1, 1, 0, 1, 1, 1, 1, 1},
                                {1, 1, 0, 1, 1, 1, 1, 1},
                                {0, 0, 7, 0, 0, 0, 0, 0},
                                {1, 1, 0, 1, 1, 1, 1, 1},
                                {1, 1, 0, 1, 1, 1, 1, 1},
                                {1, 1, 0, 1, 1, 1, 1, 1},
                                {1, 1, 0, 1, 1, 1, 1, 1},
                                {1, 1, 0, 1, 1, 1, 1, 1},
                        },
                        new Coord(2, 2),
                        new GridPart[]{
                                GridPart.build(0, 2, 6, 2),
                                GridPart.build(1, 2, 7, 2),
                                GridPart.build(2, 0, 2, 6),
                                GridPart.build(2, 1, 2, 7),
                        }
                },
                new Object[]{
                        "checkForWiderWithSq",
                        new int[][]{
                                {1, 1, 0, 1, 1, 1, 1, 1},
                                {1, 0, 0, 0, 1, 1, 1, 1},
                                {0, 0, 7, 0, 0, 0, 0, 0},
                                {1, 0, 0, 0, 1, 1, 1, 1},
                                {1, 1, 0, 1, 1, 1, 1, 1},
                                {1, 1, 0, 1, 1, 1, 1, 1},
                                {1, 1, 0, 1, 1, 1, 1, 1},
                                {1, 1, 0, 1, 1, 1, 1, 1},
                        },
                        new Coord(2, 2),
                        new GridPart[]{
                                GridPart.build(0, 2, 6, 2),
                                GridPart.build(1, 2, 7, 2),
                                GridPart.build(2, 0, 2, 6),
                                GridPart.build(2, 1, 2, 7),
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