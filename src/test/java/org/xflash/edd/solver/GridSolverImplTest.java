package org.xflash.edd.solver;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.xflash.edd.FileUtils;
import org.xflash.edd.model.Grid;
import org.xflash.edd.model.GridPart;
import org.xflash.edd.model.GridSolution;
import org.xflash.edd.reader.GridReader;

import java.util.Collection;

public class GridSolverImplTest {

    private Grid grid;

    @Before
    public void setUp() throws Exception {
        grid = GridReader.from(FileUtils.classpath("grid1.txt"));
    }

    @Test
    public void checkKnownSolution() throws Exception {
        Collection<GridSolution> gridSolutions = new GridSolverImpl().solve(grid);
        Assert.assertEquals(1, gridSolutions.size());
        GridSolution gs = gridSolutions.iterator().next();
        Collection<GridPart> parts = gs.getParts();
        Assert.assertTrue(parts.contains(GridPart.build(0, 0, 0, 2)));
        Assert.assertTrue(parts.contains(GridPart.build(1, 0, 1, 1)));
        Assert.assertTrue(parts.contains(GridPart.build(2, 0, 3, 1)));
        Assert.assertTrue(parts.contains(GridPart.build(1, 2, 2, 2)));
        Assert.assertTrue(parts.contains(GridPart.build(3, 2, 3, 3)));
        Assert.assertTrue(parts.contains(GridPart.build(0, 3, 2, 3)));

    }

}