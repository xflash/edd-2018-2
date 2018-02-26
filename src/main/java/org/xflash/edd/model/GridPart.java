package org.xflash.edd.model;

public class GridPart {
    Coord lu;
    Coord rb;

    private GridPart(Coord lu, Coord rb) {
        this.lu = lu;
        this.rb = rb;
    }

    public static GridPart build(final int lux, final int luy, final int rbx, final int rby) {
        return build(new Coord(lux, luy), new Coord(rbx, rby));
    }

    public static GridPart build(Coord lu, Coord rb) {
        return new GridPart(lu, rb);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GridPart gridPart = (GridPart) o;

        return lu.equals(gridPart.lu) && rb.equals(gridPart.rb);
    }

    @Override
    public int hashCode() {
        int result = lu != null ? lu.hashCode() : 0;
        result = 31 * result + (rb != null ? rb.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append(lu)
                .append(", ")
                .append(rb).toString();
    }
}
