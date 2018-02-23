package org.xflash.edd.model;

public class GridPart {
    Coord lu;
    Coord rb;

    private GridPart(Coord lu, Coord rb) {
        this.lu = lu;
        this.rb = rb;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GridPart gridPart = (GridPart) o;

        if (lu != null ? !lu.equals(gridPart.lu) : gridPart.lu != null) return false;
        return rb != null ? rb.equals(gridPart.rb) : gridPart.rb == null;
    }

    @Override
    public int hashCode() {
        int result = lu != null ? lu.hashCode() : 0;
        result = 31 * result + (rb != null ? rb.hashCode() : 0);
        return result;
    }

    public static GridPart build(final int lux, final int luy, final int rbx, final int rby) {
        return build(new Coord(lux, luy), new Coord(rbx, rby));
    }

    public static GridPart build(Coord lu, Coord rb) {
        return new GridPart(lu, rb);
    }
}
