import java.util.ArrayList;

/**
 * Created by Rukshar Alam on 12/10/2017.
 */
public class Mobility {
    int b_w_blank[] = {1,2,0};
    private int W_mobility[] = {10, 1};

    private int[] whoIswho(int key){
        int opponent=0;

        switch (key){
            case 1: opponent = b_w_blank[1]; break;
            case 2: opponent = b_w_blank[0]; break;
        }

        int[] who = {key, opponent};
        return who;
    }

    private int heuristicDetermination(int playerCornerCount, int opponentCornerCount, int numberOfPlayerMoves , int numberOfOpponentMoves){
        int cornerCountDiff = (playerCornerCount-opponentCornerCount);
        int w0  = W_mobility[0]*cornerCountDiff;
        int heurestic = w0;

        int playerMoveDiff =(numberOfPlayerMoves-numberOfOpponentMoves);
        int totalMoves = (numberOfPlayerMoves+numberOfOpponentMoves);
        float w1 = W_mobility[1]*((float)playerMoveDiff)/totalMoves;
        heurestic += w1;

        return heurestic;
    }

    public int mobility_count(int p, int[][]board){

        BoardFunctions bb = new BoardFunctions();


        int[] who = whoIswho(p);
        int player = who[0];
        int opponent = who[1];
        SetAvailableMoves setAvailableMoves = new SetAvailableMoves();


        ArrayList<int[]> playerMoves = setAvailableMoves.determineSetOfMoves(player,board);
        ArrayList<int[]> opponentMoves = setAvailableMoves.determineSetOfMoves(opponent,board);

        int playerCornerCount = bb.cornerOwners(player,board);
        int opponentCornerCount = bb.cornerOwners(opponent,board);




        int numberOfPlayerMoves = playerMoves.size();
        int numberOfOpponentMoves = opponentMoves.size();


        int heurestic = heuristicDetermination( playerCornerCount,  opponentCornerCount,  numberOfPlayerMoves ,  numberOfOpponentMoves);

        return heurestic;
    }
}
