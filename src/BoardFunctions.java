/**
 * Created by Rukshar Alam on 12/10/2017.
 */
public class BoardFunctions {
    private int board_size = 8;

    private String blank_string = "-"+" | ";
    private String black_string = "B"+" | ";
    private String white_string = "W"+" | ";

    int b_w_blank[] = {1,2,0};

    public boolean isTheBoardFull(int[][] board){

        boolean returnValue = true;
        int i = 1;
        while(i<=board_size){
            int j=1;
            while(j<=board_size){
                if(board[i][j]==0){
                    returnValue =  false;
                }
                j++;
            }
            i++;
        }
        return returnValue;
    }

    public BoardFunctions()
    {

    }

    private String forEachTile(int placeHolder){
        if(placeHolder == b_w_blank[0]) return black_string;
        else if(placeHolder == b_w_blank[1]) return white_string;
        else return blank_string;
        //return null;
    }

    public void board_printer(int[][] board){
        System.out.print(" ");
        int i = 1;
        while(i<=board_size) {
            System.out.print(i+" | ");
            i++;
        }
        System.out.print("\n");
        i= 1;
        while(i<=board_size){
            System.out.print(i);
            int j = 1;
            while(j<=board_size){

                int placeHolder = board[i][j];
                String temp = forEachTile(placeHolder);
                System.out.print(temp);
                j++;
            }
            System.out.print("\n");
            i++;
        }
    }
    public int scoreOfAPlayer(int color,int[][] board){
        int x = 0;


        int i = 1;
        while(i<=board_size){
            int j=1;
            while(j<=board_size){
                if(board[i][j]==color){
                    x++;
                }
                j++;
            }
            i++;
        }
        return x;
    }

    public int[][] copyConstructor(int[][] board){

        int actualSize = board_size+2;
        int[][] temp = new int[actualSize][actualSize];

        int i = 0;
        while(i<=board_size+1){
            int j = 0 ;
            while(j<=board_size){
                temp[i][j]=board[i][j];
                j++;
            }
            i++;
        }

        return temp;
    }

    private int[] cornerArray(int[][]board , int player){

        int[] temp = {0,0,0,0};

        int northWest = board[1][1];
        if(northWest == player) temp[0] = 1;

        int southEast = board[board_size][board_size];
        if(southEast == player) temp[1] = 1;

        int northEast = board[0][board_size];
        if(northEast == player) temp[2] = 1;

        int southWest = board[board_size][0];
        if(southWest == player) temp[3] = 1;

        return temp;
    }


    public int cornerOwners(int player, int[][] board){
        int s = 0;
        int[]temp = cornerArray(board,player);

        for(int i = 0;i<4;i++){
            if(temp[i]==1){
                s++;
            }
        }
        return s;
    }




}
