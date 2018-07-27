package org.xflash.edd;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xflash.edd.gui.GridViewr;
import org.xflash.edd.model.Grid;
import org.xflash.edd.model.GridSolution;
import org.xflash.edd.reader.GridReader;
import org.xflash.edd.solver.GridSolver;
import org.xflash.edd.solver.GridSolverImpl;
import org.xflash.edd.gui.GridSolutionViewer;

import javax.swing.*;
import java.awt.*;
import java.util.Collection;

public class Runner {

    private static final Logger LOGGER = LoggerFactory.getLogger(Runner.class);

    public static void main(String[] args) {

        long l = System.currentTimeMillis();
        LOGGER.info("Reading grid file ...");
        Grid grid = GridReader.from(FileUtils.classpath("grid2.txt"));
        LOGGER.info("Computing solution for grid {}x{}", grid.w, grid.h);
        GridSolver gridSolver = new GridSolverImpl();
        Collection<GridSolution> solutions = gridSolver.solve(grid);
        LOGGER.info("Founded solution in {} ms ", System.currentTimeMillis() - l);

        LOGGER.info(grid.toString());
        for (GridSolution solution : solutions) {
//            printSolution(grid, solution);
            LOGGER.info(solution.toString());
        }

    }


}
