package org.xflash.edd.solver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xflash.edd.browser.GridBrowser;
import org.xflash.edd.model.Grid;
import org.xflash.edd.model.GridSolution;

import java.util.Collection;
import java.util.Collections;

public class GridSolverImpl implements GridSolver {

    private static final Logger LOGGER = LoggerFactory.getLogger(GridSolverImpl.class);

    @Override
    public Collection<GridSolution> solve(Grid grid) {
        GridSolution gs = new GridSolution();

        GridBrowser gb = new GridBrowser(grid);
        gb.forEach(n -> {

        });
        return Collections.singletonList(gs);
    }


}
