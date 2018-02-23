package org.xflash.edd.reader;

import org.xflash.edd.model.Grid;

import java.io.*;

public class GridReader {
    private GridReader() {
    }

    public static Grid from(File file) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {

            Grid grid = parseHeaderLine(readNextIntRow(br));
            grid.cells = new int[grid.h][grid.w];
            for (int i = 0; i < grid.h; i++) {
                int[] ints = readNextIntRow(br);
                if (ints.length != (grid.w))
                    throw new IllegalArgumentException("Line " + i + " should have " + (grid.w) + " elements");
                System.arraycopy(ints, 0, grid.cells[i], 0, ints.length);
            }


            return grid;
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Grid file not found: " + file, e);
        } catch (IOException e) {
            throw new RuntimeException("IOException during reading Grid file " + file, e);
        }
    }

    private static Grid parseHeaderLine(int[] row) {
        if (row.length != 2)
            throw new IllegalArgumentException("First readable line should contains 2 arguments");
        Integer w;
        Integer h;
        try {
            w = row[0];
            h = Integer.valueOf(row[1]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("First line should contain 2 integers W H");
        }
        return new Grid(w, h);
    }

    private static int[] readNextIntRow(BufferedReader br) throws IOException {
        String line = nextReadableLine(br);
        if (line == null) throw new IllegalArgumentException("Could not read an additional Line");
        String[] strings = line.split("\\s+");
        int[] integers = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            integers[i] = Integer.valueOf(strings[i]);
        }
        return integers;
    }

    private static String nextReadableLine(BufferedReader br) throws IOException {
        String s = br.readLine();
        if (s == null) return null;
        while (s.trim().startsWith("#")) {
            s = br.readLine();
            if (s == null) return null;
        }

        return s.trim();
    }
}
