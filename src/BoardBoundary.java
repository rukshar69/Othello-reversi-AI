/**
 * Created by Rukshar Alam on 12/9/2017.
 */
public class BoardBoundary {

    int b_w_blank[] = {1,2,0};
    private int board_size = 8;
    private int board[][];
    private int BLANK = 0;

    public BoardBoundary(int board_size, int[][] board) {
        this.board_size = board_size;
        this.board = board;
    }

    public int[][] row_boundary(int[][] board, int rowNumber){
        int i = 0;
        while (i<=board_size){
            board[rowNumber][i]=-1;
            i++;
        }
        return board;
    }

    public int[][] col_boundary(int[][] board, int colNumber){
        int i = 0;
        while (i<=board_size){
            board[i][colNumber]=-1;
            i++;
        }
        return board;
    }

    public int[][] initialize_board(int[][] board){
        int i = 1;
        while (i<=board_size){

            int j = 1;

            while(j<=board_size){
                board[i][j]=BLANK;

                j++;
            }

            i++;
        }
        return board;
    }


    public  int[][] createBoundary(){


        board = row_boundary(board, 0);

        board = col_boundary(board, 0);


        board = row_boundary(board,board_size+1 );

        board = col_boundary(board, board_size+1);

        board = initialize_board(board);

        board[5][4]=b_w_blank[0]; //black
        board[5][5]=b_w_blank[1]; //white
        board[4][4]=b_w_blank[1]; //white
        board[4][5]=b_w_blank[0]; //black


        return board;
    }


}
