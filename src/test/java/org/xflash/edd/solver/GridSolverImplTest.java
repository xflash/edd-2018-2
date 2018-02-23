package org.xflash.edd.solver;

import org.junit.Test;
import org.xflash.edd.FileUtils;
import org.xflash.edd.reader.GridReader;

public class GridSolverImplTest {

    @Test
    public void name() throws Exception {
        GridReader.from(FileUtils.classpath("grid1.txt"));

    }
}