/**
 * Created by Rukshar Alam on 12/9/2017.
 */
public class Mask {

    private  int row1[] = {4,-3,2,2,2,2,-3,4};
    private  int row2[] = {-3,-3,-1,-1,-1,-1,-4,-3};
    private  int row3[] = {2,-1,1,0,0,1,-1,2};
    private  int row4[] ={2,-1,0,1,1,0,-1,2} ;
    private  int row5[]= {2,-1,0,1,1,0,-1,2};
    private  int row6[] = {2,-1,1,0,0,1,-1,2};
    private  int row7[] = {-3,-4,-1,-1,-1,-1,-4,-3};
    private  int row8[] = {4,-3,2,2,2,2,-3,4};





    public Mask(){

    }

    public int[][] getMask1() {

        int mask1[][] = {
                row1, row2, row3, row4,
                row5, row6, row7, row8
        };
        return mask1;
    }
}
