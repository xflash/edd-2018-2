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
}
