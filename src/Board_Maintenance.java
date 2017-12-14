import java.util.ArrayList;


    /* BLACK = 1
     WHITE = 2
     BLANK = 0*/

public class Board_Maintenance {





    private int board_size = 8;

    public int[][] createBoundary(int[][] board) {

        BoardBoundary bb = new BoardBoundary(board_size, board);
        board = bb.createBoundary();
        return board;
    }

    public Board_Maintenance() {

        int actualBoardSize = board_size + 2;
        board = new int[actualBoardSize][actualBoardSize];
        board = createBoundary(board);
    }


    private int board[][];


    public Board_Maintenance(int[][] boardArray) {

        this.board = boardArray;
    }

    public int[][] getBoard() {
        return board;
    }


    public int getHeuristics(int color, int choiceOfHeurestic) {

        /*
        * positional 1
        * mobility 2
        * absolute 3*/

        int heuristics = 0;

        int choice = choiceOfHeurestic;

        switch (choice) {
            case 1:
                Positional_Heuristic p = new Positional_Heuristic();
                heuristics = p.positional(color, board);
                break;
            case 2:
                Mobility m = new Mobility();

                heuristics = m.mobility_count(color, board);
                break;
            //heuristics = mobilityHeurestic(color);break;
            case 3:
                AbsoluteCount h = new AbsoluteCount();
                heuristics = h.absolute_count(color, board);
                break;

        }

        return heuristics;

    }

    public void turn(int x, int y, int color) {

        board[x][y] = color;

        Flips f = new Flips();
        board = f.flipCoins(x,y,color,board);
    }

    public ArrayList<int[]> determineSetOfMoves(int playerColor) {

        SetAvailableMoves setAvailableMoves = new SetAvailableMoves();
        ArrayList<int[]> availableMoves = setAvailableMoves.determineSetOfMoves(playerColor, board);
        return availableMoves;
    }

}