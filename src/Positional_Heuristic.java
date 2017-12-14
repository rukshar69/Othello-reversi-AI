/**
 * Created by Rukshar Alam on 12/10/2017.
 */
public class Positional_Heuristic {
    private  int b_w_blank[] = {1,2,0};
    private int W_positional[] = {+1, -1};

    private int board_size = 8;



    private int[] whoIswho(int key){
        int opponent=0;

        switch (key){
            case 1: opponent = b_w_blank[1]; break;
            case 2: opponent = b_w_blank[0]; break;
        }

        int[] who = {key, opponent};
        return who;
    }

    private int indexOfW(int key,int player, int opponent){
        if(key == player) return  0;
        else if(key == opponent) return 1;

        return -1;
    }


    public int positional(int color,int[][] board){
        int[] who = whoIswho(color);
        int player = who[0];
        int opponent = who[1];

        //Mask mask = new Mask();
        Mask2 mask = new Mask2();


        int[][] maskMatrix = mask.getMask1();
        int heurestic=0;

        int i=1;
        while(i<=board_size){
            int j=1;
            while(j<=board_size){

                int index = indexOfW(board[i][j],player,opponent);
                if(index != -1) {
                    int temp = W_positional[index];
                    int valueAdded = temp * maskMatrix[i - 1][j - 1];
                    heurestic += valueAdded;
                }

                j++;
            }

            i++;
        }
        return heurestic;
    }
}
