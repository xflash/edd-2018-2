package org.xflash.edd.browser;

import org.junit.Assert;
import org.junit.Test;
import org.xflash.edd.model.Coord;
import org.xflash.edd.model.Grid;
import org.xflash.edd.model.GridPart;

import java.util.ArrayList;

public class GridBrowser4Test {

    @Test
    public void checkFor4() throws Exception {

        ArrayList<GridPart> gridParts = new ArrayList<>();
        new GridBrowser(new Grid(new int[][]{
                {4, 0, 0, 0},
                {0, 1, 1, 1},
                {0, 1, 1, 1},
                {0, 1, 1, 1},
        })).forEachGridParts(new Coord(0, 0), gridParts::add);
        Assert.assertEquals(2, gridParts.size());
        Assert.assertTrue(gridParts.contains(GridPart.build(0, 0, 0, 3)));
        Assert.assertTrue(gridParts.contains(GridPart.build(0, 0, 3, 0)));
    }

    @Test
    public void checkFor4Other() throws Exception {

        ArrayList<GridPart> gridParts = new ArrayList<>();
        new GridBrowser(new Grid(new int[][]{
                {1, 1, 1, 0},
                {1, 1, 1, 0},
                {1, 1, 1, 0},
                {0, 0, 0, 4},
        })).forEachGridParts(new Coord(3, 3), gridParts::add);
        Assert.assertEquals(2, gridParts.size());
        Assert.assertTrue(gridParts.contains(GridPart.build(3, 0, 3, 3)));
        Assert.assertTrue(gridParts.contains(GridPart.build(0, 3, 3, 3)));
    }

    @Test
    public void checkFor4MiddleV() throws Exception {

        ArrayList<GridPart> gridParts = new ArrayList<>();
        new GridBrowser(new Grid(new int[][]{
                {1, 1, 0, 1},
                {1, 1, 0, 1},
                {1, 1, 0, 1},
                {0, 0, 4, 0},
        })).forEachGridParts(new Coord(2, 3), gridParts::add);
        Assert.assertEquals(2, gridParts.size());
        Assert.assertTrue(gridParts.contains(GridPart.build(2, 0, 2, 3)));
        Assert.assertTrue(gridParts.contains(GridPart.build(0, 3, 3, 3)));
    }

    @Test
    public void checkFor4MiddleH() throws Exception {

        ArrayList<GridPart> gridParts = new ArrayList<>();
        new GridBrowser(new Grid(new int[][]{
                {0, 1, 1, 1},
                {4, 0, 0, 0},
                {0, 1, 1, 1},
                {0, 1, 1, 1},
        })).forEachGridParts(new Coord(0, 1), gridParts::add);
        Assert.assertEquals(2, gridParts.size());
        Assert.assertTrue(gridParts.contains(GridPart.build(0, 0, 0, 3)));
        Assert.assertTrue(gridParts.contains(GridPart.build(0, 1, 3, 1)));
    }

    @Test
    public void checkFor4Wide() throws Exception {

        ArrayList<GridPart> gridParts = new ArrayList<>();
        new GridBrowser(new Grid(new int[][]{
                {4, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1, 1},
        })).forEachGridParts(new Coord(0, 0), gridParts::add);
        Assert.assertEquals(2, gridParts.size());
        Assert.assertTrue(gridParts.contains(GridPart.build(0, 0, 0, 3)));
        Assert.assertTrue(gridParts.contains(GridPart.build(0, 0, 3, 0)));
    }


    @Test
    public void checkFor4Wide1() throws Exception {

        ArrayList<GridPart> gridParts = new ArrayList<>();
        new GridBrowser(new Grid(new int[][]{
                {1, 0, 1, 1, 1, 1},
                {0, 4, 0, 0, 0, 0},
                {1, 0, 1, 1, 1, 1},
                {1, 0, 1, 1, 1, 1},
                {1, 0, 1, 1, 1, 1},
                {1, 0, 1, 1, 1, 1},
        })).forEachGridParts(new Coord(1, 1), gridParts::add);
        Assert.assertEquals(4, gridParts.size());
        Assert.assertTrue(gridParts.contains(GridPart.build(0, 1, 3, 1)));
        Assert.assertTrue(gridParts.contains(GridPart.build(1, 1, 4, 1)));
        Assert.assertTrue(gridParts.contains(GridPart.build(1, 0, 1, 3)));
        Assert.assertTrue(gridParts.contains(GridPart.build(1, 1, 1, 4)));
    }

    @Test
    public void checkFor4Wide2() throws Exception {

        ArrayList<GridPart> gridParts = new ArrayList<>();
        new GridBrowser(new Grid(new int[][]{
                {1, 1, 0, 1, 1, 1},
                {1, 1, 0, 1, 1, 1},
                {0, 0, 4, 0, 0, 0},
                {1, 1, 0, 1, 1, 1},
                {1, 1, 0, 1, 1, 1},
                {1, 1, 0, 1, 1, 1},
        })).forEachGridParts(new Coord(2, 2), gridParts::add);
        Assert.assertEquals(6, gridParts.size());
        Assert.assertTrue(gridParts.contains(GridPart.build(2, 0, 2, 3)));
        Assert.assertTrue(gridParts.contains(GridPart.build(2, 1, 2, 4)));
        Assert.assertTrue(gridParts.contains(GridPart.build(2, 2, 2, 5)));

        Assert.assertTrue(gridParts.contains(GridPart.build(0, 2, 3, 2)));
        Assert.assertTrue(gridParts.contains(GridPart.build(1, 2, 4, 2)));
        Assert.assertTrue(gridParts.contains(GridPart.build(2, 2, 5, 2)));
    }


    @Test
    public void checkFor4Wide2WithSq() throws Exception {

        ArrayList<GridPart> gridParts = new ArrayList<>();
        new GridBrowser(new Grid(new int[][]{
                {1, 1, 0, 1, 1, 1},
                {1, 0, 0, 0, 1, 1},
                {0, 0, 4, 0, 0, 0},
                {1, 0, 0, 0, 1, 1},
                {1, 1, 0, 1, 1, 1},
                {1, 1, 0, 1, 1, 1},
        })).forEachGridParts(new Coord(2, 2), gridParts::add);
        Assert.assertEquals(10, gridParts.size());
        Assert.assertTrue(gridParts.contains(GridPart.build(2, 0, 2, 3)));
        Assert.assertTrue(gridParts.contains(GridPart.build(2, 1, 2, 4)));
        Assert.assertTrue(gridParts.contains(GridPart.build(2, 2, 2, 5)));

        Assert.assertTrue(gridParts.contains(GridPart.build(0, 2, 3, 2)));
        Assert.assertTrue(gridParts.contains(GridPart.build(1, 2, 4, 2)));
        Assert.assertTrue(gridParts.contains(GridPart.build(2, 2, 5, 2)));

        Assert.assertTrue(gridParts.contains(GridPart.build(1, 1, 2, 2)));
        Assert.assertTrue(gridParts.contains(GridPart.build(2, 1, 3, 2)));
        Assert.assertTrue(gridParts.contains(GridPart.build(2, 2, 3, 3)));
        Assert.assertTrue(gridParts.contains(GridPart.build(1, 2, 2, 3)));
    }


}