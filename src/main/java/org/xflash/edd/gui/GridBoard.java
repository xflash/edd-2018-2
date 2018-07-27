package org.xflash.edd.gui;

import org.xflash.edd.browser.GridBrowser;
import org.xflash.edd.model.Grid;
import org.xflash.edd.model.GridSolution;
import org.xflash.tetris.Shape;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class GridBoard extends JPanel {

    private final Grid grid;
    private final GridSolution solution;

    public GridBoard(Grid grid, GridSolution solution) {
        this.grid = grid;
        this.solution = solution;
        setFocusable(true);
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawGrid(g);
    }

    private void drawGrid(Graphics g) {
        Dimension size = getSize();

        int boardTop = (int) size.getHeight() - grid.h * squareHeight();

        for (int i = 0; i < grid.h; ++i) {
            for (int j = 0; j < grid.w; ++j) {

                int cell = grid.cells[i][j];

                if (cell != 0)
                    drawSquare(g, 0 + j * squareWidth(),
                            boardTop + i * squareHeight(), cell);
            }
        }
    }

    private void drawSquare(Graphics g, int x, int y, int cell) {
        Color colors[] = { new Color(0, 0, 0),
                new Color(204, 102, 102),
                new Color(102, 204, 102),
                new Color(102, 102, 204),
                new Color(204, 204, 102),
                new Color(204, 102, 204),
                new Color(102, 204, 204),
                new Color(218, 170, 0)
        };

        Color color = colors[1];

        g.setColor(color);
        g.fillRect(x + 1, y + 1, squareWidth() - 2, squareHeight() - 2);
        g.setColor(color.brighter());
        String s = String.format("%d", cell);
        Rectangle2D bounds = g.getFontMetrics().getStringBounds(s, g);
        int width = (int) bounds.getWidth();
        int height = (int) bounds.getHeight();
        g.drawString(s,
                x+((squareWidth()-width)/2),
                y+ squareHeight()-((squareHeight()-height)/2)
                );

        g.setColor(color.brighter());
        g.drawLine(x, y + squareHeight() - 1, x, y);
        g.drawLine(x, y, x + squareWidth() - 1, y);

        g.setColor(color.darker());
        g.drawLine(x + 1, y + squareHeight() - 1,
                x + squareWidth() - 1, y + squareHeight() - 1);
        g.drawLine(x + squareWidth() - 1, y + squareHeight() - 1,
                x + squareWidth() - 1, y + 1);


    }

    private int squareWidth() { return (int) getSize().getWidth() / grid.w; }
    private int squareHeight() { return (int) getSize().getHeight() / grid.h; }
}
