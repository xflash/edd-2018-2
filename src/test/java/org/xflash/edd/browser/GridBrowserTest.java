package org.xflash.edd.browser;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.xflash.edd.FileUtils;
import org.xflash.edd.model.Grid;
import org.xflash.edd.reader.GridReader;

import java.util.ArrayList;
import java.util.Arrays;

public class GridBrowserTest {

    private Grid grid;

    @Before
    public void setUp() throws Exception {
        grid = GridReader.from(FileUtils.classpath("grid1.txt"));
    }

    @Test
    public void checkArrays() throws Exception {

        GridBrowser gb = new GridBrowser(grid);
        ArrayList<Integer> integers = new ArrayList<>();
        gb.forEachOrdered(integers::add);

        Assert.assertEquals(6, integers.size());
        Assert.assertEquals(Arrays.asList(4, 3, 3, 2, 2, 2), integers);

    }
}