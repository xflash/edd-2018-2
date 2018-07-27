package org.xflash.edd.solver;

import javafx.util.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xflash.edd.browser.GridBrowser;
import org.xflash.edd.model.Coord;
import org.xflash.edd.model.Grid;
import org.xflash.edd.model.GridPart;
import org.xflash.edd.model.GridSolution;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class GridSolverImpl implements GridSolver {

    private static final Logger LOGGER = LoggerFactory.getLogger(GridSolverImpl.class);

    @Override
    public Collection<GridSolution> solve(Grid grid) {
        GridBrowser gb = new GridBrowser(grid);

        HashMap<Pair<Integer, Coord>, Set<GridSolution>> map = new HashMap<>();

        final Pair<Integer, Coord>[] lastCoords = new Pair[]{null};

        gb.forEachOrderedValue((val, coord) -> {

            Pair<Integer, Coord> key = new Pair<>(val, coord);
            HashSet<GridSolution> currentCoordSolutions = new HashSet<>();
            Pair<Integer, Coord> lastCoord = lastCoords[0];

            gb.forEachGridParts(coord, gp -> {
                LOGGER.debug("Building new GridSolution with gp {} ", gp, coord);
                if (lastCoord == null)
                    currentCoordSolutions.add(new GridSolution(gp));
                else {
                    Set<GridSolution> lastGridSolutions = map.get(lastCoord);
                    boolean added = false;
                    for (GridSolution lastGridSolution : lastGridSolutions) {
                        if (!isGridSolutionCollapsingWithGridPart(lastGridSolution, gp)) {
                            currentCoordSolutions.add(new GridSolution(lastGridSolution, gp));
                            added = true;
                        }
                    }
                    if (!added)
                        LOGGER.debug("GridPart {} will be ignored as it don't fit to any previous solutions", gp);
                }
            });
            if (!currentCoordSolutions.isEmpty()) {
                if (lastCoord != null) {
                    LOGGER.debug("Remove outdated GridSolutions for {}", lastCoord);
                    map.remove(lastCoord);
                }
                LOGGER.debug("Storing updated GridSolutions for {} : {}", key, currentCoordSolutions);
                map.put(key, currentCoordSolutions);
            } else {

            }
            lastCoords[0] = key;
        });
        return map.get(lastCoords[0]);
    }

    private boolean isGridSolutionCollapsingWithGridPart(GridSolution gridSolution, GridPart gp) {
        for (GridPart gridPart : gridSolution.getParts()) {
            if (gridPart.collapse(gp))
                return true;
        }
        return false;
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
