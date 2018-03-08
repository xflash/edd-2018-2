package org.xflash.edd.browser;

import javafx.util.Pair;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

@RunWith(Parameterized.class)
public class GridBrowserIterEachDimsTest {

    private final int v;
    private final Pair<Integer, Integer>[] pairs;

    public GridBrowserIterEachDimsTest(int v, Pair<Integer, Integer>[] pairs) {
        this.v = v;
        this.pairs = pairs;
    }

    @Parameterized.Parameters(name = "pair {0}")
    public static Collection<Object[]> data() {
        return Arrays.asList(
                new Object[]{
                        1,
                        new Pair[]{
                                new Pair<>(1, 1),
                        }
                },
                new Object[]{
                        2,
                        new Pair[]{
                                new Pair<>(2, 1),
                                new Pair<>(1, 2),
                        }
                },
                new Object[]{
                        3,
                        new Pair[]{
                                new Pair<>(3, 1),
                                new Pair<>(1, 3),
                        }
                },
                new Object[]{
                        4,
                        new Pair[]{
                                new Pair<>(1, 4),
                                new Pair<>(2, 2),
                                new Pair<>(4, 1),
                        }
                },
                new Object[]{
                        5,
                        new Pair[]{
                                new Pair<>(1, 5),
                                new Pair<>(5, 1),
                        }
                },
                new Object[]{
                        6,
                        new Pair[]{
                                new Pair<>(1, 6),
                                new Pair<>(2, 3),
                                new Pair<>(3, 2),
                                new Pair<>(6, 1),
                        }

                },
                new Object[]{
                        7,
                        new Pair[]{
                                new Pair<>(1, 7),
                                new Pair<>(7, 1),
                        }
                },
                new Object[]{
                        8,
                        new Pair[]{
                                new Pair<>(1, 8),
                                new Pair<>(2, 4),
                                new Pair<>(4, 2),
                                new Pair<>(8, 1),
                        }

                },
                new Object[]{
                        9,
                        new Pair[]{
                                new Pair<>(1, 9),
                                new Pair<>(3, 3),
                                new Pair<>(9, 1),
                        }
                },
                new Object[]{
                        10,
                        new Pair[]{
                                new Pair<>(1, 10),
                                new Pair<>(2, 5),
                                new Pair<>(5, 2),
                                new Pair<>(10, 1),
                        }
                },
                new Object[]{
                        11,
                        new Pair[]{
                                new Pair<>(1, 11),
                                new Pair<>(11, 1),
                        }
                },
                new Object[]{
                        12,
                        new Pair[]{
                                new Pair<>(1, 12),
                                new Pair<>(2, 6),
                                new Pair<>(3, 4),
                                new Pair<>(4, 3),
                                new Pair<>(12, 1),
                        }
                }
        );
    }

    @Test
    public void iterEachDims() throws Exception {
        GridBrowser gb = new GridBrowser(null);
        HashSet<Pair<Integer, Integer>> set = new HashSet<>();
        gb.iterEachDims(v, set::add);

        for (Pair<Integer, Integer> pair : pairs) {
            Assert.assertTrue("should contains " + pair, set.contains(pair));
        }
    }


}