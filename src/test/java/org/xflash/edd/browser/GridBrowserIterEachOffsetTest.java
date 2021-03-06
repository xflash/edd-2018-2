package org.xflash.edd.browser;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.xflash.edd.model.Coord;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

@RunWith(Parameterized.class)
public class GridBrowserIterEachOffsetTest {

    private final int v;
    private final Coord[] offsets;

    public GridBrowserIterEachOffsetTest(int v, Coord[] offsets) {
        this.v = v;
        this.offsets = offsets;
    }

    @Parameterized.Parameters(name = "pair {0}")
    public static Collection<Object[]> data() {
        return Arrays.asList(
                new Object[]{
                        1,
                        new Coord[]{
                                new Coord(0, 0),
                        }
                },
                new Object[]{
                        2,
                        new Coord[]{
                                new Coord(0, -1),
                                new Coord(0, 0),
                                new Coord(-1, 0),
                        }
                },
                new Object[]{
                        3,
                        new Coord[]{
                                new Coord(0, -2),
                                new Coord(0, -1),
                                new Coord(0, 0),
                                new Coord(-2, 0),
                                new Coord(-1, 0),
//                                new Coord(0, 0),
                        }
                },
                new Object[]{
                        4,
                        new Coord[]{
                                //1x4
                                new Coord(0, -3),
                                new Coord(0, -2),
                                new Coord(0, -1),
                                new Coord(0, 0),
                                //4x1
                                new Coord(-3, 0),
                                new Coord(-2, 0),
                                new Coord(-1, 0),
                                new Coord(0, 0),
                                //2x2
                                new Coord(-1, -1),
                                new Coord(-1, 0),
                                new Coord(0, -1),
                                new Coord(0, 0),
                        }
                },
                new Object[]{
                        5,
                        new Coord[]{
                                //1x5
                                new Coord(0, -4),
                                new Coord(0, -3),
                                new Coord(0, -2),
                                new Coord(0, -1),
                                new Coord(0, 0),
                                //5x1
                                new Coord(-4, 0),
                                new Coord(-3, 0),
                                new Coord(-2, 0),
                                new Coord(-1, 0),
                                new Coord(0, 0),
                        }
                },
                new Object[]{
                        6,
                        new Coord[]{
                                //1x6
                                new Coord(0, -5),
                                new Coord(0, -4),
                                new Coord(0, -3),
                                new Coord(0, -2),
                                new Coord(0, -1),
                                new Coord(0, 0),
                                //6x1
                                new Coord(-5, 0),
                                new Coord(-4, 0),
                                new Coord(-3, 0),
                                new Coord(-2, 0),
                                new Coord(-1, 0),
                                new Coord(0, 0),
                                //2x3
                                new Coord(-1, -2),
                                new Coord(-1, -1),
                                new Coord(-1, 0),
                                new Coord(0, -2),
                                new Coord(0, -1),
                                new Coord(0, 0),
                                //3x2
                                new Coord(-2, -1),
                                new Coord(-2, 0),
                                new Coord(-1, -1),
                                new Coord(-1, 0),
                                new Coord(0, -1),
                                new Coord(0, 0),
                        }

                }
//                ,
//                new Object[]{
//                        7,
//                        new Coord[]{
//                                new Coord(1, 7),
//                                new Coord(7, 1),
//                        }
//                },
//                new Object[]{
//                        8,
//                        new Coord[]{
//                                new Coord(1, 8),
//                                new Coord(2, 4),
//                                new Coord(4, 2),
//                                new Coord(8, 1),
//                        }
//
//                },
//                new Object[]{
//                        9,
//                        new Coord[]{
//                                new Coord(1, 9),
//                                new Coord(3, 3),
//                                new Coord(9, 1),
//                        }
//                },
//                new Object[]{
//                        10,
//                        new Coord[]{
//                                new Coord(1, 10),
//                                new Coord(2, 5),
//                                new Coord(5, 2),
//                                new Coord(10, 1),
//                        }
//                },
//                new Object[]{
//                        11,
//                        new Coord[]{
//                                new Coord(1, 11),
//                                new Coord(11, 1),
//                        }
//                },
//                new Object[]{
//                        12,
//                        new Coord[]{
//                                new Coord(1, 12),
//                                new Coord(2, 6),
//                                new Coord(3, 4),
//                                new Coord(4, 3),
//                                new Coord(12, 1),
//                        }
//                }
        );
    }

    @Test
    public void iterEachDims() throws Exception {
        GridBrowser gb = new GridBrowser(null);
        HashSet<Coord> set = new HashSet<>();
        gb.forEachOffset(v, (dim, offset) -> set.add(offset));
        for (Coord offset : offsets) {
            Assert.assertTrue("should contains offset " + offset, set.contains(offset));
        }
    }
}