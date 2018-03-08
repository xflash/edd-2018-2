package org.xflash.edd.model;

public class Dim {
    public int w;
    public int h;

    public Dim(int w, int h) {
        this.w = w;
        this.h = h;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dim dim = (Dim) o;

        return w == dim.w && h == dim.h;
    }

    @Override
    public int hashCode() {
        int result = w;
        result = 31 * result + h;
        return result;
    }

    @Override
    public String toString() {
        return "" + w + "x" + h;
    }

}
