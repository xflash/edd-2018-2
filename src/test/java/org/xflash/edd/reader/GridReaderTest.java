package org.xflash.edd.reader;

import org.junit.Assert;
import org.junit.Test;
import org.xflash.edd.FileUtils;
import org.xflash.edd.model.Grid;

public class GridReaderTest {

    @Test
    public void checkCorrectRead() throws Exception {
        assertGrid1(GridReader.from(FileUtils.classpath("grid1.txt")));
    }

    @Test
    public void checkReadWithSpace() throws Exception {
        assertGrid1(GridReader.from(FileUtils.classpath("grid1_with_spaces.txt")));
    }

    @Test
    public void checkReadWithComments() throws Exception {
        assertGrid1(GridReader.from(FileUtils.classpath("grid1_with_comments.txt")));
    }


    @Test(expected = IllegalArgumentException.class)
    public void checkBadRead() throws Exception {
        GridReader.from(FileUtils.classpath("bad_grid1.txt"));
    }

    private void assertGrid1(Grid grid) {
        Assert.assertEquals(4, grid.w);
        Assert.assertEquals(4, grid.h);
        Assert.assertEquals(4, grid.cells.length);
        Assert.assertArrayEquals(new int[]{0, 0, 0, 0}, grid.cells[0]);
        Assert.assertArrayEquals(new int[]{3, 2, 0, 4}, grid.cells[1]);
        Assert.assertArrayEquals(new int[]{0, 2, 0, 0}, grid.cells[2]);
        Assert.assertArrayEquals(new int[]{3, 0, 0, 2}, grid.cells[3]);
    }
}