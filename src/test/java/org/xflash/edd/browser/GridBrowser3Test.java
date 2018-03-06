package org.xflash.edd.browser;

import org.junit.Assert;
import org.junit.Test;
import org.xflash.edd.model.Coord;
import org.xflash.edd.model.Grid;
import org.xflash.edd.model.GridPart;

import java.util.ArrayList;

public class GridBrowser3Test {

    @Test
    public void checkFor3LU() throws Exception {

        ArrayList<GridPart> gridParts = new ArrayList<>();
        new GridBrowser(new Grid(new int[][]{
                {3, 0, 0, 0},
                {0, 1, 1, 1},
                {0, 1, 1, 1},
                {0, 1, 1, 1},
        })).forEachGridParts(new Coord(0, 0), gridParts::add);
        Assert.assertEquals(2, gridParts.size());
        Assert.assertTrue(gridParts.contains(GridPart.build(0, 0, 0, 2)));
        Assert.assertTrue(gridParts.contains(GridPart.build(0, 0, 2, 0)));
    }

    @Test
    public void checkFor3RB() throws Exception {

        ArrayList<GridPart> gridParts = new ArrayList<>();
        new GridBrowser(new Grid(new int[][]{
                {1, 1, 1, 0},
                {1, 1, 1, 0},
                {1, 1, 1, 0},
                {0, 0, 0, 3},
        })).forEachGridParts(new Coord(3, 3), gridParts::add);
        Assert.assertEquals(2, gridParts.size());
        Assert.assertTrue(gridParts.contains(GridPart.build(1, 3, 3, 3)));
        Assert.assertTrue(gridParts.contains(GridPart.build(3, 1, 3, 3)));
    }

    @Test
    public void checkFor3MiddleV() throws Exception {

        ArrayList<GridPart> gridParts = new ArrayList<>();
        new GridBrowser(new Grid(new int[][]{
                {1, 1, 0, 1},
                {1, 1, 0, 1},
                {1, 1, 0, 1},
                {0, 0, 3, 0},
        })).forEachGridParts(new Coord(2, 3), gridParts::add);
        Assert.assertEquals(3, gridParts.size());
        Assert.assertTrue(gridParts.contains(GridPart.build(2, 1, 2, 3)));
        Assert.assertTrue(gridParts.contains(GridPart.build(0, 3, 2, 3)));
        Assert.assertTrue(gridParts.contains(GridPart.build(1, 3, 3, 3)));
    }

    @Test
    public void checkFor3MiddleH() throws Exception {

        ArrayList<GridPart> gridParts = new ArrayList<>();
        new GridBrowser(new Grid(new int[][]{
                {0, 1, 1, 1},
                {3, 0, 0, 0},
                {0, 1, 1, 1},
                {0, 1, 1, 1},
        })).forEachGridParts(new Coord(0, 1), gridParts::add);
        Assert.assertEquals(3, gridParts.size());
        Assert.assertTrue(gridParts.contains(GridPart.build(0, 0, 0, 2)));
        Assert.assertTrue(gridParts.contains(GridPart.build(0, 1, 0, 3)));
        Assert.assertTrue(gridParts.contains(GridPart.build(0, 1, 2, 1)));
    }

    @Test
    public void checkFor3Wide() throws Exception {

        ArrayList<GridPart> gridParts = new ArrayList<>();
        new GridBrowser(new Grid(new int[][]{
                {3, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1, 1},
        })).forEachGridParts(new Coord(0, 0), gridParts::add);
        Assert.assertEquals(2, gridParts.size());
        Assert.assertTrue(gridParts.contains(GridPart.build(0, 0, 0, 2)));
        Assert.assertTrue(gridParts.contains(GridPart.build(0, 0, 2, 0)));
    }


    @Test
    public void checkFor3Wide1() throws Exception {

        ArrayList<GridPart> gridParts = new ArrayList<>();
        new GridBrowser(new Grid(new int[][]{
                {1, 0, 1, 1, 1, 1},
                {0, 3, 0, 0, 0, 0},
                {1, 0, 1, 1, 1, 1},
                {1, 0, 1, 1, 1, 1},
                {1, 0, 1, 1, 1, 1},
                {1, 0, 1, 1, 1, 1},
        })).forEachGridParts(new Coord(1, 1), gridParts::add);
        Assert.assertEquals(4, gridParts.size());
        Assert.assertTrue(gridParts.contains(GridPart.build(1, 0, 1, 2)));
        Assert.assertTrue(gridParts.contains(GridPart.build(1, 1, 1, 3)));
        Assert.assertTrue(gridParts.contains(GridPart.build(0, 1, 2, 1)));
        Assert.assertTrue(gridParts.contains(GridPart.build(1, 1, 3, 1)));
    }

    @Test
    public void checkFor3Wide2() throws Exception {

        ArrayList<GridPart> gridParts = new ArrayList<>();
        new GridBrowser(new Grid(new int[][]{
                {1, 1, 0, 1, 1, 1},
                {1, 1, 0, 1, 1, 1},
                {0, 0, 3, 0, 0, 0},
                {1, 1, 0, 1, 1, 1},
                {1, 1, 0, 1, 1, 1},
                {1, 1, 0, 1, 1, 1},
        })).forEachGridParts(new Coord(2, 2), gridParts::add);
        Assert.assertEquals(6, gridParts.size());
        Assert.assertTrue(gridParts.contains(GridPart.build(2, 0, 2, 2)));
        Assert.assertTrue(gridParts.contains(GridPart.build(2, 1, 2, 3)));
        Assert.assertTrue(gridParts.contains(GridPart.build(2, 2, 2, 4)));

        Assert.assertTrue(gridParts.contains(GridPart.build(0, 2, 2, 2)));
        Assert.assertTrue(gridParts.contains(GridPart.build(1, 2, 3, 2)));
        Assert.assertTrue(gridParts.contains(GridPart.build(2, 2, 4, 2)));

    }


    @Test
    public void checkFor3Wide2WithSq() throws Exception {

        ArrayList<GridPart> gridParts = new ArrayList<>();
        new GridBrowser(new Grid(new int[][]{
                {1, 1, 0, 1, 1, 1},
                {1, 0, 0, 0, 1, 1},
                {0, 0, 3, 0, 0, 0},
                {1, 0, 0, 0, 1, 1},
                {1, 1, 0, 1, 1, 1},
                {1, 1, 0, 1, 1, 1},
        })).forEachGridParts(new Coord(2, 2), gridParts::add);
        Assert.assertEquals(6, gridParts.size());
        Assert.assertTrue(gridParts.contains(GridPart.build(2, 0, 2, 2)));
        Assert.assertTrue(gridParts.contains(GridPart.build(2, 1, 2, 3)));
        Assert.assertTrue(gridParts.contains(GridPart.build(2, 2, 2, 4)));

        Assert.assertTrue(gridParts.contains(GridPart.build(0, 2, 2, 2)));
        Assert.assertTrue(gridParts.contains(GridPart.build(1, 2, 3, 2)));
        Assert.assertTrue(gridParts.contains(GridPart.build(2, 2, 4, 2)));
    }


}