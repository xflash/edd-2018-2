package org.xflash.edd;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xflash.edd.model.Grid;
import org.xflash.edd.model.GridSolution;
import org.xflash.edd.reader.GridReader;
import org.xflash.edd.solver.GridSolver;
import org.xflash.edd.solver.GridSolverImpl;

import java.util.Collection;

public class Runner {

    private static final Logger LOGGER = LoggerFactory.getLogger(Runner.class);

    public static void main(String[] args) {

        Grid grid1 = GridReader.from(FileUtils.classpath("grid2.txt"));

        GridSolver gridSolver = new GridSolverImpl();
        Collection<GridSolution> solutions = gridSolver.solve(grid1);

        LOGGER.info("Founded solution for grid {}", grid1);
        for (GridSolution solution : solutions) {
            System.out.println("solution = " + solution);
        }

    }
}
