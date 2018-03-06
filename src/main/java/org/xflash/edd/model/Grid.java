package org.xflash.edd.model;

public class Grid {

    private static final String WHITESPACE = " ";
    private static final String DWHITESPACE = "  ";
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
//        print first row
        sb.append(DWHITESPACE + WHITESPACE);
        sb.append(Ansis.ANSI_BLUE);
        for (int i = 0; i < w; i++) {
            sb.append(i)
                    .append(i < 10 ? DWHITESPACE : WHITESPACE);
        }
        sb.append(Ansis.ANSI_RESET);
        sb.append("\n");


        String sep2 = "";
        for (int r = 0; r < cells.length; r++) {
            int[] cell = cells[r];

            sb.append(sep2);

            sb.append(Ansis.ANSI_RESET)
                    .append(Ansis.ANSI_RED)
                    .append(r)
                    .append(r < 10 ? DWHITESPACE : WHITESPACE)
                    .append(Ansis.ANSI_RESET);
            for (int v : cell) {
                sb.append(Ansis.ANSI_BOLD)
                        .append(v == 0 ? "." : v)
                        .append(Ansis.ANSI_RESET)
                        .append(v < 10 ? DWHITESPACE : WHITESPACE);
            }
            sep2 = "\n";
        }
        return sb.toString();
    }
}
