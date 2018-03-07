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
public class GridBrowser8Test {

    private final GridPart[] gridParts;
    private final Grid grid;
    private final Coord coord;

    public GridBrowser8Test(final String name, final int[][] cells, final Coord coord, final GridPart[] gridParts) {
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
                                {8, 0, 0, 0, 0, 0, 0, 0},
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
                                GridPart.build(0, 0, 0, 7),
                                GridPart.build(0, 0, 7, 0)
                        }
                },
                new Object[]{
                        "checkForRB",
                        new int[][]{
                                {1, 1, 1, 1, 1, 1, 1, 0},
                                {1, 1, 1, 1, 1, 1, 1, 0},
                                {1, 1, 1, 1, 1, 1, 1, 0},
                                {1, 1, 1, 1, 1, 1, 1, 0},
                                {1, 1, 1, 1, 1, 1, 1, 0},
                                {1, 1, 1, 1, 1, 1, 1, 0},
                                {1, 1, 1, 1, 1, 1, 1, 0},
                                {0, 0, 0, 0, 0, 0, 0, 8},
                        },
                        new Coord(7, 7),
                        new GridPart[]{
                                GridPart.build(7, 0, 7, 7),
                                GridPart.build(0, 7, 7, 7)
                        }
                },
                new Object[]{
                        "checkForMiddleV",
                        new int[][]{
                                {1, 1, 1, 1, 1, 1, 0, 1},
                                {1, 1, 1, 1, 1, 1, 0, 1},
                                {1, 1, 1, 1, 1, 1, 0, 1},
                                {1, 1, 1, 1, 1, 1, 0, 1},
                                {1, 1, 1, 1, 1, 1, 0, 1},
                                {1, 1, 1, 1, 1, 1, 0, 1},
                                {1, 1, 1, 1, 1, 1, 0, 1},
                                {0, 0, 0, 0, 0, 0, 8, 0},
                        },
                        new Coord(6, 7),
                        new GridPart[]{
                                GridPart.build(6, 0, 6, 7),
                                GridPart.build(0, 7, 7, 7)
                        }
                },
                new Object[]{
                        "checkForMiddleH",
                        new int[][]{
                                {0, 1, 1, 1, 1, 1, 1, 1},
                                {8, 0, 0, 0, 0, 0, 0, 0},
                                {0, 1, 1, 1, 1, 1, 1, 1},
                                {0, 1, 1, 1, 1, 1, 1, 1},
                                {0, 1, 1, 1, 1, 1, 1, 1},
                                {0, 1, 1, 1, 1, 1, 1, 1},
                                {0, 1, 1, 1, 1, 1, 1, 1},
                                {0, 1, 1, 1, 1, 1, 1, 1},
                        },
                        new Coord(0, 1),
                        new GridPart[]{
                                GridPart.build(0, 0, 0, 7),
                                GridPart.build(0, 1, 7, 1)
                        }
                },
                new Object[]{
                        "checkForWider",
                        new int[][]{
                                {8, 0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 1, 1, 1, 1, 1, 1, 1, 1},
                                {0, 1, 1, 1, 1, 1, 1, 1, 1},
                                {0, 1, 1, 1, 1, 1, 1, 1, 1},
                                {0, 1, 1, 1, 1, 1, 1, 1, 1},
                                {0, 1, 1, 1, 1, 1, 1, 1, 1},
                                {0, 1, 1, 1, 1, 1, 1, 1, 1},
                                {0, 1, 1, 1, 1, 1, 1, 1, 1},
                                {0, 1, 1, 1, 1, 1, 1, 1, 1},
                        },
                        new Coord(0, 0),
                        new GridPart[]{
                                GridPart.build(0, 0, 0, 7),
                                GridPart.build(0, 0, 7, 0)
                        }
                },
                new Object[]{
                        "checkForWider1",
                        new int[][]{
                                {1, 0, 1, 1, 1, 1, 1, 1, 1},
                                {0, 8, 0, 0, 0, 0, 0, 0, 0},
                                {1, 0, 1, 1, 1, 1, 1, 1, 1},
                                {1, 0, 1, 1, 1, 1, 1, 1, 1},
                                {1, 0, 1, 1, 1, 1, 1, 1, 1},
                                {1, 0, 1, 1, 1, 1, 1, 1, 1},
                                {1, 0, 1, 1, 1, 1, 1, 1, 1},
                                {1, 0, 1, 1, 1, 1, 1, 1, 1},
                                {1, 0, 1, 1, 1, 1, 1, 1, 1},
                        },
                        new Coord(1, 1),
                        new GridPart[]{
                                GridPart.build(0, 1, 7, 1),
                                GridPart.build(1, 1, 8, 1),
                                GridPart.build(1, 0, 1, 7),
                                GridPart.build(1, 1, 1, 8),
                        }
                },
                new Object[]{
                        "checkForWider2",
                        new int[][]{
                                {1, 1, 0, 1, 1, 1, 1, 1, 1},
                                {1, 1, 0, 1, 1, 1, 1, 1, 1},
                                {0, 0, 8, 0, 0, 0, 0, 0, 0},
                                {1, 1, 0, 1, 1, 1, 1, 1, 1},
                                {1, 1, 0, 1, 1, 1, 1, 1, 1},
                                {1, 1, 0, 1, 1, 1, 1, 1, 1},
                                {1, 1, 0, 1, 1, 1, 1, 1, 1},
                                {1, 1, 0, 1, 1, 1, 1, 1, 1},
                                {1, 1, 0, 1, 1, 1, 1, 1, 1},
                        },
                        new Coord(2, 2),
                        new GridPart[]{
                                GridPart.build(0, 2, 7, 2),
                                GridPart.build(1, 2, 8, 2),
                                GridPart.build(2, 0, 2, 7),
                                GridPart.build(2, 1, 2, 8),
                        }
                },
                new Object[]{
                        "checkForWiderWithSq",
                        new int[][]{
                                {1, 1, 0, 1, 1, 1, 1, 1, 1},
                                {1, 0, 0, 0, 1, 1, 1, 1, 1},
                                {0, 0, 8, 0, 0, 0, 0, 0, 0},
                                {1, 0, 0, 0, 1, 1, 1, 1, 1},
                                {1, 1, 0, 1, 1, 1, 1, 1, 1},
                                {1, 1, 0, 1, 1, 1, 1, 1, 1},
                                {1, 1, 0, 1, 1, 1, 1, 1, 1},
                                {1, 1, 0, 1, 1, 1, 1, 1, 1},
                                {1, 1, 0, 1, 1, 1, 1, 1, 1},
                        },
                        new Coord(2, 2),
                        new GridPart[]{
                                GridPart.build(0, 2, 7, 2),
                                GridPart.build(1, 2, 8, 2),
                                GridPart.build(2, 0, 2, 7),
                                GridPart.build(2, 1, 2, 8),
                        }
                },
                new Object[]{
                        "checkForWiderWith2x4",
                        new int[][]{
                                {1, 1, 1, 1, 1, 1, 1, 1, 1},
                                {1, 0, 0, 1, 1, 1, 1, 1, 1},
                                {1, 0, 8, 1, 1, 1, 1, 1, 1},
                                {1, 0, 0, 1, 1, 1, 1, 1, 1},
                                {1, 0, 0, 1, 1, 1, 1, 1, 1},
                                {1, 1, 1, 1, 1, 1, 1, 1, 1},
                                {1, 1, 1, 1, 1, 1, 1, 1, 1},
                                {1, 1, 1, 1, 1, 1, 1, 1, 1},
                                {1, 1, 1, 1, 1, 1, 1, 1, 1},
                        },
                        new Coord(2, 2),
                        new GridPart[]{
                                GridPart.build(1, 1, 2, 4),
                        }
                },
                new Object[]{
                        "checkForWiderWith2x4",
                        new int[][]{
                                {1, 1, 1, 1, 1, 1, 1, 1, 1},
                                {1, 0, 0, 0, 1, 1, 1, 1, 1},
                                {1, 0, 8, 0, 1, 1, 1, 1, 1},
                                {1, 0, 0, 0, 1, 1, 1, 1, 1},
                                {1, 0, 0, 0, 1, 1, 1, 1, 1},
                                {1, 1, 1, 1, 1, 1, 1, 1, 1},
                                {1, 1, 1, 1, 1, 1, 1, 1, 1},
                                {1, 1, 1, 1, 1, 1, 1, 1, 1},
                                {1, 1, 1, 1, 1, 1, 1, 1, 1},
                        },
                        new Coord(2, 2),
                        new GridPart[]{
                                GridPart.build(1, 1, 2, 4),
                                GridPart.build(2, 1, 3, 4),
                        }
                },
                new Object[]{
                        "checkForFull",
                        new int[][]{
                                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 8, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                        },
                        new Coord(4, 4),
                        new GridPart[]{
                                //CROSS
                                GridPart.build(0, 4, 7, 4),
                                GridPart.build(1, 4, 8, 4),
                                GridPart.build(4, 0, 4, 7),
                                GridPart.build(4, 1, 4, 8),


                                GridPart.build(3, 1, 4, 4),
                                GridPart.build(3, 2, 4, 5),
                                GridPart.build(3, 3, 4, 6),
                                GridPart.build(3, 4, 4, 7),

                                GridPart.build(4, 1, 5, 4),
                                GridPart.build(4, 2, 5, 5),
                                GridPart.build(4, 3, 5, 6),
                                GridPart.build(4, 4, 5, 7),


                                GridPart.build(1, 3, 4, 4),
                                GridPart.build(2, 3, 5, 4),
                                GridPart.build(3, 3, 6, 4),
                                GridPart.build(4, 3, 7, 4),

                                GridPart.build(1, 4, 4, 5),
                                GridPart.build(2, 4, 5, 5),
                                GridPart.build(3, 4, 6, 5),
                                GridPart.build(4, 4, 7, 5),

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