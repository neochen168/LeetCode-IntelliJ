import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SkyLineSolutionTest {

    @Test
    void getSkyline() {
        SkyLineSolution sl = new SkyLineSolution();

        sl.getSkyline(new int[][] {
            {2, 9, 10},
            {3, 7, 15},
            {5, 12, 12},
            {15, 20, 10},
                {19,24,8}
        });



        //sl.getSkyline(new int[][] {
        //        {0, 2147483647, 2147483647}
        //});

        sl.getSkyline(new int[][] {
                {2, 4, 70},
                {3, 8, 30},
                {6, 100, 41}
        });

    }
}