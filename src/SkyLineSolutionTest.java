import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SkyLineSolutionTest {

    @Test
    void getSkyline() {
        SkyLineSolution sl = new SkyLineSolution();

        //sl.getSkyline2(new int[][] {
        //    {2, 9, 10},
        //    {3, 7, 15},
        //    {5, 12, 12},
        //    {15, 20, 10},
        //        {19,24,8}
        //});

        sl.getSkyline(new int[][] {
                {1, 2, 1},
                {1, 2, 2},
                {1, 2, 3}
        });

        sl.getSkyline(new int[][] {
                //{2, 9, 10},
                //{3, 7, 15},
                //{5, 12, 12},
                //{15, 20, 10},
                //{19,24,8},
                {43325,568099,982005},
                {47356,933141,123943},
                {59810,561434,119381},
                {75382,594625,738524},
                {111895,617442,587304},
                {143767,869128,471633},
                {195676,285251,107127},
                {218793,772827,229219},
                {316837,802148,899966}
        });



        //sl.getSkyline2(new int[][] {
        //        {0, 2147483647, 2147483647}
        //});

        sl.getSkyline(new int[][] {
                {0, 2147483647, 2147483647}
        });

        //sl.getSkyline2(new int[][] {
        //        {2, 4, 70},
        //        {3, 8, 30},
        //        {6, 100, 41}
        //});
        sl.getSkyline(new int[][] {
                {2, 4, 70},
                {3, 8, 30},
                {6, 100, 41}
        });

        //sl.getSkyline2(new int[][] {
        //        {2, 13, 10},
        //        {10, 17, 25},
        //        {12, 20, 14}
        //});

        sl.getSkyline(new int[][] {
                {2, 13, 10},
                {10, 17, 25},
                {12, 20, 14}
        });
    }
}