package org.xflash.edd.browser;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.xflash.edd.model.Coord;
import org.xflash.edd.model.Grid;
import org.xflash.edd.model.GridPart;

import java.util.ArrayList;

public class GridBrowser6Test {

    private int V;

    @Before
    public void setUp() throws Exception {
        V = 6;
    }

    @Test
    public void checkForLU() throws Exception {

        ArrayList<GridPart> gridParts = new ArrayList<>();
        new GridBrowser(new Grid(new int[][]{
                {V, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1, 1},
        })).forEachGridParts(new Coord(0, 0), gridParts::add);
        Assert.assertEquals(2, gridParts.size());
        Assert.assertTrue(gridParts.contains(GridPart.build(0, 0, 0, 5)));
        Assert.assertTrue(gridParts.contains(GridPart.build(0, 0, 5, 0)));
    }

    @Test
    public void checkForRB() throws Exception {

        ArrayList<GridPart> gridParts = new ArrayList<>();
        new GridBrowser(new Grid(new int[][]{
                {1, 1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1, 0},
                {0, 0, 0, 0, 0, V},
        })).forEachGridParts(new Coord(5, 5), gridParts::add);
        Assert.assertEquals(2, gridParts.size());
        Assert.assertTrue(gridParts.contains(GridPart.build(5, 0, 5, 5)));
        Assert.assertTrue(gridParts.contains(GridPart.build(0, 5, 5, 5)));
    }

    @Test
    public void checkForMiddleV() throws Exception {

        ArrayList<GridPart> gridParts = new ArrayList<>();
        new GridBrowser(new Grid(new int[][]{
                {1, 1, 1, 1, 0, 1},
                {1, 1, 1, 1, 0, 1},
                {1, 1, 1, 1, 0, 1},
                {1, 1, 1, 1, 0, 1},
                {1, 1, 1, 1, 0, 1},
                {0, 0, 0, 0, V, 0},
        })).forEachGridParts(new Coord(4, 5), gridParts::add);
        Assert.assertEquals(2, gridParts.size());
        Assert.assertTrue(gridParts.contains(GridPart.build(4, 0, 4, 5)));
        Assert.assertTrue(gridParts.contains(GridPart.build(0, 5, 5, 5)));
    }

    @Test
    public void checkForMiddleH() throws Exception {

        ArrayList<GridPart> gridParts = new ArrayList<>();
        new GridBrowser(new Grid(new int[][]{
                {0, 1, 1, 1, 1, 1},
                {V, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1, 1},
        })).forEachGridParts(new Coord(0, 1), gridParts::add);
        Assert.assertEquals(2, gridParts.size());
        Assert.assertTrue(gridParts.contains(GridPart.build(0, 0, 0, 5)));
        Assert.assertTrue(gridParts.contains(GridPart.build(0, 1, 5, 1)));
    }

    @Test
    public void checkForWider() throws Exception {

        ArrayList<GridPart> gridParts = new ArrayList<>();
        new GridBrowser(new Grid(new int[][]{
                {V, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1, 1, 1, 1},
        })).forEachGridParts(new Coord(0, 0), gridParts::add);
        Assert.assertEquals(2, gridParts.size());
        Assert.assertTrue(gridParts.contains(GridPart.build(0, 0, 0, 5)));
        Assert.assertTrue(gridParts.contains(GridPart.build(0, 0, 5, 0)));
    }


    @Test
    public void checkForWider1() throws Exception {

        ArrayList<GridPart> gridParts = new ArrayList<>();
        new GridBrowser(new Grid(new int[][]{
                {1, 0, 1, 1, 1, 1, 1, 1},
                {0, V, 0, 0, 0, 0, 0, 0},
                {1, 0, 1, 1, 1, 1, 1, 1},
                {1, 0, 1, 1, 1, 1, 1, 1},
                {1, 0, 1, 1, 1, 1, 1, 1},
                {1, 0, 1, 1, 1, 1, 1, 1},
                {1, 0, 1, 1, 1, 1, 1, 1},
                {1, 0, 1, 1, 1, 1, 1, 1},
        })).forEachGridParts(new Coord(1, 1), gridParts::add);
        Assert.assertEquals(4, gridParts.size());
        Assert.assertTrue(gridParts.contains(GridPart.build(0, 1, 5, 1)));
        Assert.assertTrue(gridParts.contains(GridPart.build(1, 1, 6, 1)));
        Assert.assertTrue(gridParts.contains(GridPart.build(1, 0, 1, 5)));
        Assert.assertTrue(gridParts.contains(GridPart.build(1, 1, 1, 6)));
    }

    @Test
    public void checkForWider2() throws Exception {

        ArrayList<GridPart> gridParts = new ArrayList<>();
        new GridBrowser(new Grid(new int[][]{
                {1, 1, 0, 1, 1, 1, 1, 1},
                {1, 1, 0, 1, 1, 1, 1, 1},
                {0, 0, V, 0, 0, 0, 0, 0},
                {1, 1, 0, 1, 1, 1, 1, 1},
                {1, 1, 0, 1, 1, 1, 1, 1},
                {1, 1, 0, 1, 1, 1, 1, 1},
                {1, 1, 0, 1, 1, 1, 1, 1},
                {1, 1, 0, 1, 1, 1, 1, 1},
        })).forEachGridParts(new Coord(2, 2), gridParts::add);
        Assert.assertEquals(6, gridParts.size());
        Assert.assertTrue(gridParts.contains(GridPart.build(2, 0, 2, 5)));
        Assert.assertTrue(gridParts.contains(GridPart.build(2, 1, 2, 6)));
        Assert.assertTrue(gridParts.contains(GridPart.build(2, 2, 2, 7)));

        Assert.assertTrue(gridParts.contains(GridPart.build(0, 2, 5, 2)));
        Assert.assertTrue(gridParts.contains(GridPart.build(1, 2, 6, 2)));
        Assert.assertTrue(gridParts.contains(GridPart.build(2, 2, 7, 2)));
    }


    @Test
    public void checkForWiderWithSq() throws Exception {

        ArrayList<GridPart> gridParts = new ArrayList<>();
        new GridBrowser(new Grid(new int[][]{
                {1, 1, 0, 1, 1, 1, 1, 1},
                {1, 0, 0, 0, 1, 1, 1, 1},
                {0, 0, V, 0, 0, 0, 0, 0},
                {1, 0, 0, 0, 1, 1, 1, 1},
                {1, 1, 0, 1, 1, 1, 1, 1},
                {1, 1, 0, 1, 1, 1, 1, 1},
                {1, 1, 0, 1, 1, 1, 1, 1},
                {1, 1, 0, 1, 1, 1, 1, 1},
        })).forEachGridParts(new Coord(2, 2), gridParts::add);
        Assert.assertEquals(10, gridParts.size());
        Assert.assertTrue(gridParts.contains(GridPart.build(2, 0, 2, 5)));
        Assert.assertTrue(gridParts.contains(GridPart.build(2, 1, 2, 6)));
        Assert.assertTrue(gridParts.contains(GridPart.build(2, 2, 2, 7)));

        Assert.assertTrue(gridParts.contains(GridPart.build(0, 2, 5, 2)));
        Assert.assertTrue(gridParts.contains(GridPart.build(1, 2, 6, 2)));
        Assert.assertTrue(gridParts.contains(GridPart.build(2, 2, 7, 2)));

        Assert.assertTrue(gridParts.contains(GridPart.build(2, 1, 3, 3)));
//        Assert.assertTrue(gridParts.contains(GridPart.build(2, 1, 3, 3)));
    }


}