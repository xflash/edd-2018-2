package org.xflash.edd.browser;

import org.junit.Before;
import org.junit.Test;
import org.xflash.edd.FileUtils;
import org.xflash.edd.model.Grid;
import org.xflash.edd.reader.GridReader;

public class GridBrowserTest {

    private Grid grid;

    @Before
    public void setUp() throws Exception {
        grid = GridReader.from(FileUtils.classpath("grid1.txt"));
    }

    @Test
    public void checkArrays() throws Exception {
        GridBrowser gb = new GridBrowser(grid);

        gb.forEachOrdered((v, coord) -> {
            System.out.println("v = " + v + " - coord " + coord);
        });
    }
}