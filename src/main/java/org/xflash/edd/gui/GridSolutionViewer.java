package org.xflash.edd.gui;

import org.xflash.edd.model.Grid;
import org.xflash.edd.model.GridSolution;

import java.awt.*;

public class GridSolutionViewer extends Canvas {
    private final Grid grid;
    private final GridSolution solution;
    private final int offset;
    private final int sq;

    public GridSolutionViewer(Grid grid, GridSolution solution, int offset, int sq) {
        this.grid = grid;
        this.solution = solution;
        this.offset = offset;
        this.sq = sq;
    }


    @Override
    public void paint(Graphics g) {
        drawGrid(g, grid);
        drawSolution(g, solution);
    }

    private void drawGrid(Graphics g, Grid grid) {

        printDeubgLines(g);

        g.setColor(Color.BLACK);

//        drawHeaderRow(g, grid);
//        drawHeaderColumn(g, grid);

        g.drawRect(offset + sq, offset + sq, grid.w * sq, grid.h * sq);

        for (int y = 0; y < grid.h; y++) {
            for (int x = 0; x < grid.w; x++) {
//                g.drawRect(headerColOffset+(x*sq), headerRowOffset+(y*sq), sq, sq);
            }
        }
    }

    private void printDeubgLines(Graphics g) {
        g.setColor(Color.RED);

        g.drawLine(offset, 0, offset, getHeight());
        g.drawLine(0, offset, getWidth(), offset);

        int x1 = offset + grid.w * sq;
        int y1 = offset + grid.h * sq;
        g.drawLine(x1, 0, x1, y1);
        g.drawLine(0, y1, x1, y1);

//        for (int i = 0; i < grid.w; i++) {
//            int x1 = offset + (i * sq);
//            g.drawLine(x1, 0, x1, getHeight());
//        }
//        for (int i = 0; i < grid.w; i++) {
//            int y1 = offset + (i * sq);
//            g.drawLine(0, y1, getWidth(), y1);
//        }
    }

    private void drawHeaderRow(Graphics g, Grid grid) {
        FontMetrics fontMetrics = g.getFontMetrics();
        int headerRowOffset = offset + sq;
        for (int x = 0; x < grid.w; x++) {
            String str = String.format("%d", x + 1);
//            int i = fontMetrics.stringWidth(str);
            g.drawString(str, headerRowOffset + (x * sq), offset);
        }
    }

    private void drawHeaderColumn(Graphics g, Grid grid) {
        FontMetrics fontMetrics = g.getFontMetrics();
        int headerColOffset = offset + sq;
        for (int y = 0; y < grid.h; y++) {
            String str = String.format("%d", y + 1);
            int i = fontMetrics.stringWidth(str);
            g.drawString(str, offset, headerColOffset + (y * sq));
        }
    }

    private void drawSolution(Graphics g, GridSolution gridSolution) {

    }

    public Dimension getDimension() {
        return new Dimension(
                (3 * 5) + ((grid.w + 1) * sq),
                (5 * 5) + ((grid.h + 1) * sq));
    }
}
