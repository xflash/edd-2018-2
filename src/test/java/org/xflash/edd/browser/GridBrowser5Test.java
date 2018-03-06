package org.xflash.edd.browser;

import org.junit.Assert;
import org.junit.Test;
import org.xflash.edd.model.Coord;
import org.xflash.edd.model.Grid;
import org.xflash.edd.model.GridPart;

import java.util.ArrayList;

public class GridBrowser5Test {

    @Test
    public void checkForLU() throws Exception {

        ArrayList<GridPart> gridParts = new ArrayList<>();
        new GridBrowser(new Grid(new int[][]{
                {5, 0, 0, 0, 0},
                {0, 1, 1, 1, 1},
                {0, 1, 1, 1, 1},
                {0, 1, 1, 1, 1},
                {0, 1, 1, 1, 1},
        })).forEachGridParts(new Coord(0, 0), gridParts::add);
        Assert.assertEquals(2, gridParts.size());
        Assert.assertTrue(gridParts.contains(GridPart.build(0, 0, 0, 4)));
        Assert.assertTrue(gridParts.contains(GridPart.build(0, 0, 4, 0)));
    }

    @Test
    public void checkForRB() throws Exception {

        ArrayList<GridPart> gridParts = new ArrayList<>();
        new GridBrowser(new Grid(new int[][]{
                {1, 1, 1, 1, 0},
                {1, 1, 1, 1, 0},
                {1, 1, 1, 1, 0},
                {1, 1, 1, 1, 0},
                {0, 0, 0, 0, 5},
        })).forEachGridParts(new Coord(4, 4), gridParts::add);
        Assert.assertEquals(2, gridParts.size());
        Assert.assertTrue(gridParts.contains(GridPart.build(4, 0, 4, 4)));
        Assert.assertTrue(gridParts.contains(GridPart.build(0, 4, 4, 4)));
    }

    @Test
    public void checkForMiddleV() throws Exception {

        ArrayList<GridPart> gridParts = new ArrayList<>();
        new GridBrowser(new Grid(new int[][]{
                {1, 1, 1, 0, 1},
                {1, 1, 1, 0, 1},
                {1, 1, 1, 0, 1},
                {1, 1, 1, 0, 1},
                {0, 0, 0, 5, 0},
        })).forEachGridParts(new Coord(3, 4), gridParts::add);
        Assert.assertEquals(2, gridParts.size());
        Assert.assertTrue(gridParts.contains(GridPart.build(3, 0, 3, 4)));
        Assert.assertTrue(gridParts.contains(GridPart.build(0, 4, 4, 4)));
    }

    @Test
    public void checkForMiddleH() throws Exception {

        ArrayList<GridPart> gridParts = new ArrayList<>();
        new GridBrowser(new Grid(new int[][]{
                {0, 1, 1, 1, 1},
                {5, 0, 0, 0, 0},
                {0, 1, 1, 1, 1},
                {0, 1, 1, 1, 1},
                {0, 1, 1, 1, 1},
        })).forEachGridParts(new Coord(0, 1), gridParts::add);
        Assert.assertEquals(2, gridParts.size());
        Assert.assertTrue(gridParts.contains(GridPart.build(0, 0, 0, 4)));
        Assert.assertTrue(gridParts.contains(GridPart.build(0, 1, 4, 1)));
    }

    @Test
    public void checkForWider() throws Exception {

        ArrayList<GridPart> gridParts = new ArrayList<>();
        new GridBrowser(new Grid(new int[][]{
                {5, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1, 1, 1},
        })).forEachGridParts(new Coord(0, 0), gridParts::add);
        Assert.assertEquals(2, gridParts.size());
        Assert.assertTrue(gridParts.contains(GridPart.build(0, 0, 0, 4)));
        Assert.assertTrue(gridParts.contains(GridPart.build(0, 0, 4, 0)));
    }


    @Test
    public void checkForWider1() throws Exception {

        ArrayList<GridPart> gridParts = new ArrayList<>();
        new GridBrowser(new Grid(new int[][]{
                {1, 0, 1, 1, 1, 1, 1},
                {0, 5, 0, 0, 0, 0, 0},
                {1, 0, 1, 1, 1, 1, 1},
                {1, 0, 1, 1, 1, 1, 1},
                {1, 0, 1, 1, 1, 1, 1},
                {1, 0, 1, 1, 1, 1, 1},
                {1, 0, 1, 1, 1, 1, 1},
        })).forEachGridParts(new Coord(1, 1), gridParts::add);
        Assert.assertEquals(4, gridParts.size());
        Assert.assertTrue(gridParts.contains(GridPart.build(0, 1, 4, 1)));
        Assert.assertTrue(gridParts.contains(GridPart.build(1, 1, 5, 1)));
        Assert.assertTrue(gridParts.contains(GridPart.build(1, 0, 1, 4)));
        Assert.assertTrue(gridParts.contains(GridPart.build(1, 1, 1, 5)));
    }

    @Test
    public void checkForWider2() throws Exception {

        ArrayList<GridPart> gridParts = new ArrayList<>();
        new GridBrowser(new Grid(new int[][]{
                {1, 1, 0, 1, 1, 1, 1},
                {1, 1, 0, 1, 1, 1, 1},
                {0, 0, 5, 0, 0, 0, 0},
                {1, 1, 0, 1, 1, 1, 1},
                {1, 1, 0, 1, 1, 1, 1},
                {1, 1, 0, 1, 1, 1, 1},
                {1, 1, 0, 1, 1, 1, 1},
        })).forEachGridParts(new Coord(2, 2), gridParts::add);
        Assert.assertEquals(6, gridParts.size());
        Assert.assertTrue(gridParts.contains(GridPart.build(2, 0, 2, 4)));
        Assert.assertTrue(gridParts.contains(GridPart.build(2, 1, 2, 5)));
        Assert.assertTrue(gridParts.contains(GridPart.build(2, 2, 2, 6)));

        Assert.assertTrue(gridParts.contains(GridPart.build(0, 2, 4, 2)));
        Assert.assertTrue(gridParts.contains(GridPart.build(1, 2, 5, 2)));
        Assert.assertTrue(gridParts.contains(GridPart.build(2, 2, 6, 2)));
    }


    @Test
    public void checkForWiderWithSq() throws Exception {

        ArrayList<GridPart> gridParts = new ArrayList<>();
        new GridBrowser(new Grid(new int[][]{
                {1, 1, 0, 1, 1, 1, 1},
                {1, 0, 0, 0, 1, 1, 1},
                {0, 0, 5, 0, 0, 0, 0},
                {1, 0, 0, 0, 1, 1, 1},
                {1, 1, 0, 1, 1, 1, 1},
                {1, 1, 0, 1, 1, 1, 1},
                {1, 1, 0, 1, 1, 1, 1},
        })).forEachGridParts(new Coord(2, 2), gridParts::add);
        Assert.assertEquals(6, gridParts.size());
        Assert.assertTrue(gridParts.contains(GridPart.build(2, 0, 2, 4)));
        Assert.assertTrue(gridParts.contains(GridPart.build(2, 1, 2, 5)));
        Assert.assertTrue(gridParts.contains(GridPart.build(2, 2, 2, 6)));

        Assert.assertTrue(gridParts.contains(GridPart.build(0, 2, 4, 2)));
        Assert.assertTrue(gridParts.contains(GridPart.build(1, 2, 5, 2)));
        Assert.assertTrue(gridParts.contains(GridPart.build(2, 2, 6, 2)));
    }


}