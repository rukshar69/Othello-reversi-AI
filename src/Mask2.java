/**
 * Created by Rukshar Alam on 12/11/2017.
 */
public class Mask2 {
    private  int row1[] = {100,-20,10,5,5,10,-20,100};
    private  int row2[] = {-20,-50,-2,-2,-2,-2,-50,-20};
    private  int row3[] = {10,-2,-1,-1,-1,-1,-2,10};
    private  int row4[] ={5,-2,-1,-1,-1,-1,-2,5} ;
    private  int row5[]= {5,-2,-1,-1,-1,-1,-2,5};
    private  int row6[] = {10,-2,-1,-1,-1,-1,-2,10};
    private  int row7[] = {-20,-50,-2,-2,-2,-2,-50,-20};
    private  int row8[] = {100,-20,10,5,5,10,-20,100};





    public Mask2(){

    }

    public int[][] getMask1() {

        int mask1[][] = {
                row1, row2, row3, row4,
                row5, row6, row7, row8
        };
        return mask1;
    }
}
