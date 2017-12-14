/**
 * Created by Rukshar Alam on 12/10/2017.
 */
public class Flips {

    int board_size = 8 ;
    int b_w_blank[] = {1, 2, 0};


    private int[] whoIswho(int key){
        int opponent=0;

        switch (key){
            case 1: opponent = b_w_blank[1]; break;
            case 2: opponent = b_w_blank[0]; break;
        }

        int[] who = {key, opponent};
        return who;
    }



    public int[][] up(int x, int y, int player,int opponent,int[][] board){

        int i;
        boolean isUp = board[x - 1][y] == opponent;
        if (isUp) {
            i = x - 1;
            while ( i >= 1) {
                if (board[i][y] == b_w_blank[2])
                    break;
                if (board[i][y] == player) {
                    while ( i <= x) {
                        board[i][y] = player;
                        i++;
                    }
                    break;
                }

                i--;
            }
        }
        return board;
    }


    public int[][] down(int x, int y, int player,int opponent,int[][] board){
        int i;
        boolean isDown =board[x + 1][y] == opponent;
        if (isDown) {
            i = x + 1;
            while ( i <= board_size) {
                if (board[i][y] == b_w_blank[2])
                    break;
                if (board[i][y] == player) {
                    while ( i >= x) {
                        board[i][y] = player;
                        i--;
                    }
                    break;
                }

                i++;
            }
        }
        return board;
    }

    public int[][] left(int x, int y, int player,int opponent,int[][] board){

        int i;
        boolean isLeft =board[x][y - 1] == opponent;
        if (isLeft) {
            i = y - 1;
            while ( i >= 1) {
                if (board[x][i] ==  b_w_blank[2])
                    break;
                if (board[x][i] == player) {
                    while ( i <= y) {
                        board[x][i] =  player;
                        i++;
                    }
                    break;
                }

                i--;
            }
        }
        return board;
    }

    public int[][] right(int x, int y, int player,int opponent,int[][] board){
        int i;
        boolean isLeft =board[x][y + 1] == opponent;
        if (isLeft) {
            i = y + 1;
            while ( i <=board_size) {
                if (board[x][i] ==  b_w_blank[2])
                    break;
                if (board[x][i] == player) {
                    while ( i >= y) {
                        board[x][i] =  player;
                        i--;
                    }
                    break;
                }

                i++;
            }
        }
        return board;
    }

    public int[][] upper_left(int x, int y, int player,int opponent,int[][] board){


        int ix; int iy;

        boolean isUperLeftOpponent = board[x-1][y-1]==opponent;


        iy = y - 1;
        ix = x - 1;

        if(isUperLeftOpponent) {

            //boolean limit1 = ;
            boolean breakOut = false;
            while (ix >= 1 && iy >= 1) {

                boolean isBlank =board[ix][iy]==b_w_blank[2];

                boolean isPlayer  = board[ix][iy] == player;

                if (isPlayer) {
                    while ( iy <= y && ix <= x ) {
                        board[ix][iy] = player;
                        breakOut = true;
                        ix++;
                        iy++;
                    }
                    if(breakOut)
                        break;
                }
                if(isBlank)
                    break;
                ix--;
                iy--;
            }
        }
        return board;
    }

    public int[][] upper_right(int x, int y, int player,int opponent,int[][] board){

        int ix; int iy;

        boolean isUperRightOpponent = board[x - 1][y + 1] == opponent;


        iy = y + 1;
        ix = x - 1;

        if(isUperRightOpponent) {

            //boolean limit1 = ;
            while (ix >= 1 && iy <= board_size) {

                boolean isBlank =board[ix][iy]==b_w_blank[2];

                boolean isPlayer  = board[ix][iy] == player;

                if (isPlayer) {
                    while ( iy >= y && ix <= x ) {
                        board[ix][iy] = player;
                        ix++;
                        iy--;
                    }
                    break;
                }
                if(isBlank)
                    break;
                ix--;
                iy++;
            }
        }
        return board;
    }

    public int[][] lower_left(int x, int y, int player,int opponent,int[][] board){

        int ix; int iy;

        boolean islowerLeftOpponent = board[x - 1][y + 1] == opponent;


        iy = y - 1;
        ix = x + 1;

        if(islowerLeftOpponent) {

            //boolean limit1 = ;
            while (  ix <= board_size && iy >= 1 ) {

                boolean isBlank =board[ix][iy]==b_w_blank[2];

                boolean isPlayer  = board[ix][iy] == player;

                if (isPlayer) {
                    while ( iy <= y && ix >= x ) {
                        board[ix][iy] = player;
                        ix--;
                        iy++;
                    }
                    break;
                }
                if(isBlank)
                    break;
                ix++;
                iy--;
            }
        }
        return board;
    }

    public int[][] lower_right(int x, int y, int player,int opponent,int[][] board){

        int ix; int iy;


        boolean islowerLeftOpponent = board[x + 1][y + 1] == opponent;


        iy = y + 1;
        ix = x + 1;

        if(islowerLeftOpponent) {

            //boolean limit1 = ;
            boolean breakOutOfLoop = false;
            while (  iy <= board_size && ix <= board_size  ) {

                boolean isBlank =board[ix][iy]==b_w_blank[2];

                boolean isPlayer  = board[ix][iy] == player;

                if (isPlayer) {
                    while (  iy >= y && ix >= x ) {

                        board[ix][iy] = player;
                        breakOutOfLoop = true;
                        ix--;
                        iy--;

                    }
                    if(breakOutOfLoop)
                        break;
                }
                if(isBlank)
                    break;
                ix++;
                iy++;
            }
        }
        return board;
    }

    private  int [][] moveInDir(int x, int y, int player, int opponent, int [][] board){
        //UP
        board = up(x,y,player,opponent,board);


        //DOWN

        board = down(x,y,player,opponent,board);


        //LEFT
        board = left(x,y,player,opponent,board);


        //RIGHT
        board = right(x,y,player,opponent,board);


        //UPPER LEFT
        board = upper_left(x,y,player,opponent,board);


        //UPPER RIGHT
        board = upper_right(x,y,player,opponent,board);

        //LOWER LEFt

        board = lower_left(x,y,player,opponent,board);

        //LOWER RIGHT

        board = lower_right(x,y,player,opponent,board);

        return board;
    }
    public int[][] flipCoins(int x, int y, int p,int[][] board) {
        int[] who = whoIswho(p);
        int player = who[0];
        int opponent = who[1];

        board = moveInDir(x,y,player,opponent,board);

        return board;
    }
}
