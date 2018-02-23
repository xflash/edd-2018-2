package org.xflash.edd;

import org.xflash.edd.model.Grid;
import org.xflash.edd.model.GridSolution;
import org.xflash.edd.reader.GridReader;
import org.xflash.edd.solver.GridSolver;
import org.xflash.edd.solver.GridSolverImpl;

import java.util.Collection;

public class Runner {

    public static void main(String[] args) {

        Grid grid1 = GridReader.from(FileUtils.classpath("grid1.txt"));

        GridSolver gridSolver = new GridSolverImpl();
        Collection<GridSolution> solutions = gridSolver.solve(grid1);

        for (GridSolution solution : solutions) {
            System.out.println("solution = " + solution);
        }

    }
}
