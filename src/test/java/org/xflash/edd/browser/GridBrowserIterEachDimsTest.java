package org.xflash.edd.browser;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.xflash.edd.model.Dim;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

@RunWith(Parameterized.class)
public class GridBrowserIterEachDimsTest {

    private final int v;
    private final Dim[] dims;

    public GridBrowserIterEachDimsTest(int v, Dim[] dims) {
        this.v = v;
        this.dims = dims;
    }

    @Parameterized.Parameters(name = "pair {0}")
    public static Collection<Object[]> data() {
        return Arrays.asList(
                new Object[]{
                        1,
                        new Dim[]{
                                new Dim(1, 1),
                        }
                },
                new Object[]{
                        2,
                        new Dim[]{
                                new Dim(2, 1),
                                new Dim(1, 2),
                        }
                },
                new Object[]{
                        3,
                        new Dim[]{
                                new Dim(3, 1),
                                new Dim(1, 3),
                        }
                },
                new Object[]{
                        4,
                        new Dim[]{
                                new Dim(1, 4),
                                new Dim(2, 2),
                                new Dim(4, 1),
                        }
                },
                new Object[]{
                        5,
                        new Dim[]{
                                new Dim(1, 5),
                                new Dim(5, 1),
                        }
                },
                new Object[]{
                        6,
                        new Dim[]{
                                new Dim(1, 6),
                                new Dim(2, 3),
                                new Dim(3, 2),
                                new Dim(6, 1),
                        }

                },
                new Object[]{
                        7,
                        new Dim[]{
                                new Dim(1, 7),
                                new Dim(7, 1),
                        }
                },
                new Object[]{
                        8,
                        new Dim[]{
                                new Dim(1, 8),
                                new Dim(2, 4),
                                new Dim(4, 2),
                                new Dim(8, 1),
                        }

                },
                new Object[]{
                        9,
                        new Dim[]{
                                new Dim(1, 9),
                                new Dim(3, 3),
                                new Dim(9, 1),
                        }
                },
                new Object[]{
                        10,
                        new Dim[]{
                                new Dim(1, 10),
                                new Dim(2, 5),
                                new Dim(5, 2),
                                new Dim(10, 1),
                        }
                },
                new Object[]{
                        11,
                        new Dim[]{
                                new Dim(1, 11),
                                new Dim(11, 1),
                        }
                },
                new Object[]{
                        12,
                        new Dim[]{
                                new Dim(1, 12),
                                new Dim(2, 6),
                                new Dim(3, 4),
                                new Dim(4, 3),
                                new Dim(12, 1),
                        }
                }
        );
    }

    @Test
    public void iterEachDims() throws Exception {
        GridBrowser gb = new GridBrowser(null);
        HashSet<Dim> set = new HashSet<>();
        gb.iterEachDims(v, set::add);

        for (Dim dim : dims) {
            Assert.assertTrue("should contains " + dim, set.contains(dim));
        }
    }


}