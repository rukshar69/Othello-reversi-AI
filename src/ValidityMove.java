/**
 * Created by Rukshar Alam on 12/10/2017.
 */
public class ValidityMove {

    private int b_w_blank[]={1,2,0};
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

    private boolean up(int[][]board, int x, int y,int player, int opponent){

        boolean ok = board[x-1][y]==opponent;
        int temp = 0;
        if(ok)temp = 1;

        switch (temp){
            case 0: return  false;
            case 1:
                int i = x-1;
                while(i>=1){

                    int t = board[i][y];
                    if(t!= opponent) {
                        if (t == player) {
                            return true;
                        }
                        if (t == b_w_blank[2]) {
                            return false;
                        }
                    }


                    ;i--;
                }
        }

        return false;
    }


    private boolean down(int[][]board, int x, int y,int player, int opponent){

        boolean ok = board[x+1][y]==opponent;
        int temp = 0;
        if(ok)temp = 1;



        switch (temp){
            case 0: return  false;
            case 1:
                int i = x+1;
                while(i<=board_size){

                    int t = board[i][y];
                    if(t!= opponent) {
                        if (t == player) {
                            return true;
                        }
                        if (t == b_w_blank[2]) {
                            return false;
                        }
                    }


                    ;i++;
                }
        }

        return false;
    }

    private boolean left(int[][]board, int x, int y,int player, int opponent){

        boolean ok = board[x][y-1]==opponent;
        int temp = 0;
        if(ok)temp = 1;




        switch (temp){
            case 0: return  false;
            case 1:
                int i=y-1;
                while(i>=1){

                    int t = board[x][i];
                    if(t!= opponent) {
                        if (t == player) {
                            return true;
                        }
                        if (t == b_w_blank[2]) {
                            return false;
                        }
                    }


                    ;i--;
                }
        }

        return false;
    }

    private boolean right(int[][]board, int x, int y,int player, int opponent){

        boolean ok = board[x][y+1]==opponent;
        int temp = 0;
        if(ok)temp = 1;




        switch (temp){
            case 0: return  false;
            case 1:
                int i=y+1;
                while(i<=board_size){

                    int t = board[x][i];
                    if(t!= opponent) {
                        if (t == player) {
                            return true;
                        }
                        if (t == b_w_blank[2]) {
                            return false;
                        }
                    }


                    ;i++;
                }
        }

        return false;
    }

    private boolean upperLeft(int[][]board, int x, int y,int player, int opponent){

        boolean ok = board[x-1][y-1]==opponent;
        int temp = 0;
        if(ok)temp = 1;





        switch (temp){
            case 0: return  false;
            case 1:
                int i = x-1; int j = y-1;
                while(i>=1 && j>=1){

                    int t = board[i][j];
                    if(t!= opponent) {
                        if (t == player) {
                            return true;
                        }
                        if (t == b_w_blank[2]) {
                            return false;
                        }
                    }


                    ;i--; j--;
                }
        }

        return false;
    }

    private boolean upperRight(int[][]board, int x, int y,int player, int opponent){

        boolean ok = board[x-1][y+1]==opponent;
        int temp = 0;
        if(ok)temp = 1;





        switch (temp){
            case 0: return  false;
            case 1:
                int i = x-1; int j = y+1;
                while(i>=1 && j<=board_size){

                    int t = board[i][j];
                    if(t!= opponent) {
                        if (t == player) {
                            return true;
                        }
                        if (t == b_w_blank[2]) {
                            return false;
                        }
                    }


                    ;i--; j++;
                }
        }

        return false;
    }

    private boolean lowerLeft(int[][]board, int x, int y,int player, int opponent){

        boolean ok = board[x+1][y-1]==opponent;
        int temp = 0;
        if(ok)temp = 1;




        switch (temp){
            case 0: return  false;
            case 1:
                int i = x+1; int j = y-1;
                while(i<=board_size && j>=1){

                    int t = board[i][j];
                    if(t!= opponent) {
                        if (t == player) {
                            return true;
                        }
                        if (t == b_w_blank[2]) {
                            return false;
                        }
                    }


                    ;i++; j--;
                }
        }

        return false;
    }


    private boolean lowerRight(int[][]board, int x, int y,int player, int opponent){

        boolean ok = board[x+1][y+1]==opponent;
        int temp = 0;
        if(ok)temp = 1;




        switch (temp){
            case 0: return  false;
            case 1:
                int i = x+1; int j = y+1;
                while(i<=board_size && j<=board_size){

                    int t = board[i][j];
                    if(t!= opponent) {
                        if (t == player) {
                            return true;
                        }
                        if (t == b_w_blank[2]) {
                            return false;
                        }
                    }


                    ;i++; j++;
                }
        }

        return false;
    }



    public boolean isAvailable(int x,int y,int color,int[][] board){
        int[] who = whoIswho(color);
        int player = who[0];
        int opponent = who[1];


        if(board[x][y]!=0)
        {
            return false;
        }

        //UP

        boolean isUp = up(board,x,y,player,opponent);
        if(isUp)return true;

        //DOWN
        boolean isDown = down(board,x,y,player,opponent);
        if(isDown) return true;
        //LEFT
        boolean isLeft = left(board,x,y,player,opponent);
        if(isLeft) return true;

        //RIGHT
        boolean isRight = right(board,x,y,player,opponent);
        if(isRight) return true;

        //UPPER LEFT
        boolean isUpperLeft = upperLeft(board,x,y,player,opponent);
        if(isUpperLeft) return true;



        //UPPER RIGHT
        boolean isUpperRight = upperRight(board,x,y,player,opponent);
        if(isUpperRight) return true;


        //LOWER LEFT
        boolean isLowerLeft = lowerLeft(board,x,y,player,opponent);
        if(isLowerLeft) return true;

        //LOWER RIGHT
        boolean isLowerRight = lowerRight(board,x,y,player,opponent);
        if(isLowerRight) return true;

        return false;

    }
}
