/**
 * Created by Rukshar Alam on 12/10/2017.
 */
public class AbsoluteCount {

    int b_w_blank[] = {1,2,0};
    public AbsoluteCount(){

    }

    private int[] whoIswho(int key){
        int opponent=0;

       switch (key){
           case 1: opponent = b_w_blank[1]; break;
           case 2: opponent = b_w_blank[0]; break;
       }

        int[] who = {key, opponent};
        return who;
    }
    public int absolute_count(int color,int[][] board){
        BoardFunctions bb = new BoardFunctions();


        int[] who = whoIswho(color);
        int player = who[0];
        int opponent = who[1];

        int playerCount = bb.scoreOfAPlayer(player,board);
        int opponentCount = bb.scoreOfAPlayer(opponent,board);

        int absoluteDiff= playerCount - opponentCount;
        return absoluteDiff;
    }
}
