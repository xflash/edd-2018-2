package org.xflash.edd.solver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xflash.edd.browser.GridBrowser;
import org.xflash.edd.model.Coord;
import org.xflash.edd.model.Grid;
import org.xflash.edd.model.GridPart;
import org.xflash.edd.model.GridSolution;

import java.util.*;

public class GridSolverImpl implements GridSolver {

    private static final Logger LOGGER = LoggerFactory.getLogger(GridSolverImpl.class);

    @Override
    public Collection<GridSolution> solve(Grid grid) {
        GridBrowser gb = new GridBrowser(grid);

        HashMap<Coord, Set<GridSolution>> map = new HashMap<>();

//        Coord lastCoord=null;

        gb.forEachOrderedValue((val, coord) -> {

            map.put(coord, new HashSet<>());

            gb.forEachGridParts(coord, gp -> {
                LOGGER.info("Checking if Gridpart {} collapse with {}", gp, coord);
                Set<GridSolution> solutionNodes = map.get(coord);
                if (solutionNodes.isEmpty()) {
                    LOGGER.info("Create a GridSolution with {}", gp);
                    solutionNodes.add(new GridSolution(gp));
                } else {
                    Set<GridSolution> gridSolutions = new HashSet<>();

                    LOGGER.info("Checking GridPart {} matchs with all {}", gp, solutionNodes);

                    for (GridSolution gridSolution : solutionNodes) {

                        if (!isGridPartCollapsingGridSolution(gridSolution, gp))
                            gridSolutions.add(new GridSolution(gridSolution, gp));
                    }
                    solutionNodes.addAll(gridSolutions);
                }

            });
        });

        return Collections.emptyList();
    }


    private boolean isGridPartCollapsingGridSolution(GridSolution gridSolution, GridPart gp) {
        boolean collapsing = false;
        for (GridPart gridPart : gridSolution.getParts()) {
            if (gp.collapse(gridPart)) {
                collapsing = true;
                break;
            }
        }
        return collapsing;
    }


}
