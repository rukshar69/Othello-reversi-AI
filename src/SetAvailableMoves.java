import java.util.ArrayList;

/**
 * Created by Rukshar Alam on 12/10/2017.
 */
public class SetAvailableMoves {

    int b_w_blank[] = {1,2,0};

    private int board_size = 8;
    public ArrayList<int[]> determineSetOfMoves(int playerColor,int[][] board){
        ArrayList<int[]> availableMoves = new ArrayList<>();

        int i = 1;
        while(i<=board_size){
            int j=1;
            while(j<=board_size){
                ValidityMove v = new ValidityMove();
                boolean t = v.isAvailable(i,j,playerColor, board);
                if(t){
                    int[] pair = new int[2];
                    pair[0] = i;pair[1]=j;
                    availableMoves.add(pair);
                }

                ;j++;
            }

            ;i++;
        }
        return availableMoves;
    }

    public boolean isNoMoveAvailable(int[][] board){
        ArrayList<int[]> b = determineSetOfMoves(b_w_blank[0],board);
        boolean condB = b.size()==0;

        ArrayList<int[]> w = determineSetOfMoves(b_w_blank[1],board);
        boolean condW = w.size()==0;

        boolean combinedCond = condB && condW;
        int temp = 0;
        if(combinedCond){
            temp = 1;
        }
        switch (temp){
            case 1: return true;
            case 0: return false;
        }

        return false;
    }
}
