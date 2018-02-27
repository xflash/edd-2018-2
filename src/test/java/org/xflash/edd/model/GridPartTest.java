package org.xflash.edd.model;

import org.junit.Assert;
import org.junit.Test;

public class GridPartTest {

    @Test
    public void checkBasicCollapse() throws Exception {
        GridPart gp = GridPart.build(0, 0, 1, 0);
        Assert.assertTrue(gp.collapse(GridPart.build(1, 0, 2, 0)));
        Assert.assertTrue(gp.collapse(GridPart.build(1, 0, 1, 1)));
        Assert.assertTrue(gp.collapse(GridPart.build(1, -1, 1, 0)));
        Assert.assertTrue(gp.collapse(GridPart.build(0, 0, 0, 1)));
        Assert.assertTrue(gp.collapse(GridPart.build(-1, 0, 0, 0)));

        Assert.assertFalse(gp.collapse(GridPart.build(2, 0, 3, 0)));
    }

    @Test
    public void checkSquareCollapse() throws Exception {
        GridPart gp = GridPart.build(0, 0, 1, 1);
        Assert.assertTrue(gp.collapse(GridPart.build(-1, -1, 0, 0)));
        Assert.assertTrue(gp.collapse(GridPart.build(1, 1, 2, 2)));

        Assert.assertFalse(gp.collapse(GridPart.build(2, 0, 3, 1)));
    }

}