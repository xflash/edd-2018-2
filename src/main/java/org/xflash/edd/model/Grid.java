package org.xflash.edd.model;

public class Grid {

    public final int w;
    public final int h;
    public int[][] cells;

    public Grid(int w, int h) {
        this.w = w;
        this.h = h;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("\n");
        String sep = "";
        sb.append("  ");
        sb.append(Ansis.ANSI_BLUE);
        for (int i = 0; i < w; i++) {
            sb.append(sep).append(i);
            sep = " ";
        }
        sb.append(Ansis.ANSI_RESET);
        sb.append("\n");


        String sep2 = "";
        for (int r = 0; r < cells.length; r++) {
            int[] cell = cells[r];

            sep = "";
            sb.append(sep2);

            sb.append(Ansis.ANSI_RESET)
                    .append(Ansis.ANSI_RED)
                    .append(r).append(" ")
                    .append(Ansis.ANSI_RESET);

            for (int i : cell) {
                sb.append(Ansis.ANSI_BOLD)
                        .append(sep).append(i == 0 ? "." : i)
                        .append(Ansis.ANSI_RESET);
                sep = " ";
            }
            sep2 = "\n";
        }
        return sb.toString();
    }
}
