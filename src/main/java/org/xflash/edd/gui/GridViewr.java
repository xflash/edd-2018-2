package org.xflash.edd.gui;

import org.xflash.edd.model.Grid;
import org.xflash.edd.model.GridSolution;

import javax.swing.*;
import java.awt.*;

public class GridViewr extends JFrame {
    public GridViewr(Grid grid, GridSolution solution) throws HeadlessException {
        JLabel statusbar = new JLabel(" 0");
        add(statusbar, BorderLayout.SOUTH);

        GridBoard board = new GridBoard(grid, solution);
        add(board);

        setTitle("Grid");
        setSize(200, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

}
