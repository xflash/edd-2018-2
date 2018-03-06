package org.xflash.edd.browser;

import org.junit.Assert;
import org.junit.Test;
import org.xflash.edd.model.Coord;
import org.xflash.edd.model.Grid;
import org.xflash.edd.model.GridPart;

import java.util.ArrayList;

public class GridBrowser2Test {

    @Test
    public void checkFor2LU() throws Exception {

        ArrayList<GridPart> gridParts = new ArrayList<>();
        new GridBrowser(new Grid(new int[][]{
                {2, 0, 0, 0},
                {0, 1, 1, 1},
                {0, 1, 1, 1},
                {0, 1, 1, 1},
        })).forEachGridParts(new Coord(0, 0), gridParts::add);
        Assert.assertEquals(2, gridParts.size());
        Assert.assertTrue(gridParts.contains(GridPart.build(0, 0, 0, 1)));
        Assert.assertTrue(gridParts.contains(GridPart.build(0, 0, 1, 0)));
    }

    @Test
    public void checkFor2RB() throws Exception {

        ArrayList<GridPart> gridParts = new ArrayList<>();
        new GridBrowser(new Grid(new int[][]{
                {1, 1, 1, 0},
                {1, 1, 1, 0},
                {1, 1, 1, 0},
                {0, 0, 0, 2},
        })).forEachGridParts(new Coord(3, 3), gridParts::add);
        Assert.assertEquals(2, gridParts.size());
        Assert.assertTrue(gridParts.contains(GridPart.build(2, 3, 3, 3)));
        Assert.assertTrue(gridParts.contains(GridPart.build(3, 2, 3, 3)));
    }

    @Test
    public void checkFor2MiddleV() throws Exception {

        ArrayList<GridPart> gridParts = new ArrayList<>();
        new GridBrowser(new Grid(new int[][]{
                {1, 1, 0, 1},
                {1, 1, 0, 1},
                {1, 1, 0, 1},
                {0, 0, 2, 0},
        })).forEachGridParts(new Coord(2, 3), gridParts::add);
        Assert.assertEquals(3, gridParts.size());
        Assert.assertTrue(gridParts.contains(GridPart.build(2, 2, 2, 3)));
        Assert.assertTrue(gridParts.contains(GridPart.build(2, 3, 3, 3)));
        Assert.assertTrue(gridParts.contains(GridPart.build(1, 3, 2, 3)));
    }

    @Test
    public void checkFor2MiddleH() throws Exception {

        ArrayList<GridPart> gridParts = new ArrayList<>();
        new GridBrowser(new Grid(new int[][]{
                {0, 1, 1, 1},
                {2, 0, 0, 0},
                {0, 1, 1, 1},
                {0, 1, 1, 1},
        })).forEachGridParts(new Coord(0, 1), gridParts::add);
        Assert.assertEquals(3, gridParts.size());
        Assert.assertTrue(gridParts.contains(GridPart.build(0, 0, 0, 1)));
        Assert.assertTrue(gridParts.contains(GridPart.build(0, 1, 1, 1)));
        Assert.assertTrue(gridParts.contains(GridPart.build(0, 1, 0, 2)));
    }

    @Test
    public void checkFor2Wide() throws Exception {

        ArrayList<GridPart> gridParts = new ArrayList<>();
        new GridBrowser(new Grid(new int[][]{
                {2, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1, 1},
        })).forEachGridParts(new Coord(0, 0), gridParts::add);
        Assert.assertEquals(2, gridParts.size());
        Assert.assertTrue(gridParts.contains(GridPart.build(0, 0, 0, 1)));
        Assert.assertTrue(gridParts.contains(GridPart.build(0, 0, 1, 0)));
    }


    @Test
    public void checkFor2Wide1() throws Exception {

        ArrayList<GridPart> gridParts = new ArrayList<>();
        new GridBrowser(new Grid(new int[][]{
                {1, 0, 1, 1, 1, 1},
                {0, 2, 0, 0, 0, 0},
                {1, 0, 1, 1, 1, 1},
                {1, 0, 1, 1, 1, 1},
                {1, 0, 1, 1, 1, 1},
                {1, 0, 1, 1, 1, 1},
        })).forEachGridParts(new Coord(1, 1), gridParts::add);
        Assert.assertEquals(4, gridParts.size());
        Assert.assertTrue(gridParts.contains(GridPart.build(1, 0, 1, 1)));
        Assert.assertTrue(gridParts.contains(GridPart.build(1, 1, 2, 1)));
        Assert.assertTrue(gridParts.contains(GridPart.build(1, 1, 1, 2)));
        Assert.assertTrue(gridParts.contains(GridPart.build(0, 1, 1, 1)));
    }

    @Test
    public void checkFor2Wide2() throws Exception {

        ArrayList<GridPart> gridParts = new ArrayList<>();
        new GridBrowser(new Grid(new int[][]{
                {1, 1, 0, 1, 1, 1},
                {1, 1, 0, 1, 1, 1},
                {0, 0, 2, 0, 0, 0},
                {1, 1, 0, 1, 1, 1},
                {1, 1, 0, 1, 1, 1},
                {1, 1, 0, 1, 1, 1},
        })).forEachGridParts(new Coord(2, 2), gridParts::add);
        Assert.assertEquals(4, gridParts.size());
        Assert.assertTrue(gridParts.contains(GridPart.build(2, 1, 2, 2)));
        Assert.assertTrue(gridParts.contains(GridPart.build(2, 2, 3, 2)));
        Assert.assertTrue(gridParts.contains(GridPart.build(2, 2, 2, 3)));
        Assert.assertTrue(gridParts.contains(GridPart.build(1, 2, 2, 2)));
    }


    @Test
    public void checkFor2Wide2WithSq() throws Exception {

        ArrayList<GridPart> gridParts = new ArrayList<>();
        new GridBrowser(new Grid(new int[][]{
                {1, 1, 0, 1, 1, 1},
                {1, 0, 0, 0, 1, 1},
                {0, 0, 2, 0, 0, 0},
                {1, 0, 0, 0, 1, 1},
                {1, 1, 0, 1, 1, 1},
                {1, 1, 0, 1, 1, 1},
        })).forEachGridParts(new Coord(2, 2), gridParts::add);
        Assert.assertEquals(4, gridParts.size());
        Assert.assertTrue(gridParts.contains(GridPart.build(2, 1, 2, 2)));
        Assert.assertTrue(gridParts.contains(GridPart.build(2, 2, 3, 2)));
        Assert.assertTrue(gridParts.contains(GridPart.build(2, 2, 2, 3)));
        Assert.assertTrue(gridParts.contains(GridPart.build(1, 2, 2, 2)));
    }


}