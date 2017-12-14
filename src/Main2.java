import java.util.ArrayList;
import java.util.Scanner;


public class Main2 {
    /*BLACK = 1;
    WHITE = 2;
    BLANK = 0;*/




    static int b_w_blank[] = {1, 2, 0};


    static int p1 ;
    static int p2 ;
    static String p1String;


    static   int DEPTH ;



    public static void initialize(){

        p1 = b_w_blank[0]; //player
        p2 = b_w_blank[1];  //opponent
        p1String = "BLACK";

        DEPTH = 9;

    }

    public static void whitePlayer(){
        p1=b_w_blank[1];
        p1String="WHITE";
        p2=b_w_blank[0];
    }

    public static void blackPlayer(){
        p1=b_w_blank[0];
        p1String="BLACK";
        p2=b_w_blank[1];
    }

    public static void player_switch(){
        if(p1==b_w_blank[0]){
            whitePlayer();
        }
        else{
            blackPlayer();
        }
    }

    public static void whoWins(Board_Maintenance gameBoard){


        BoardFunctions bb = new BoardFunctions();
        int blackScore = bb.scoreOfAPlayer(b_w_blank[0],gameBoard.getBoard());
        int whiteScore = bb.scoreOfAPlayer(b_w_blank[1],gameBoard.getBoard());

        if(blackScore<whiteScore){
            System.out.println("White wins the game.");


        }
        else if(whiteScore<blackScore){
            System.out.println("black wins the game.");

        }
        else if (whiteScore == blackScore){
            System.out.println("it's a draw.");

        }
    }

    public static boolean gameWon(Board_Maintenance gameBoard){
        BoardFunctions bb = new BoardFunctions();
        boolean filledUp = bb.isTheBoardFull(gameBoard.getBoard());

        SetAvailableMoves setAvailableMoves = new SetAvailableMoves();

        boolean noMoreMoves = setAvailableMoves.isNoMoveAvailable(gameBoard.getBoard());


        if(noMoreMoves||filledUp|| isTheBoardFilledUpByOnly1(gameBoard)){

            whoWins(gameBoard);
            return true;
        }

        return false;

    }

    public static boolean isTheBoardFilledUpByOnly1(Board_Maintenance gameBoard){

        BoardFunctions bb = new BoardFunctions();
        int blackScore = bb.scoreOfAPlayer(b_w_blank[0],gameBoard.getBoard());
        int whiteScore = bb.scoreOfAPlayer(b_w_blank[1],gameBoard.getBoard());

        if(whiteScore==0 || blackScore==0) return true;
        return false;

    }

    public static boolean endGameCondition(Board_Maintenance gameBoard){
        BoardFunctions bb = new BoardFunctions();
        boolean filledUp = bb.isTheBoardFull(gameBoard.getBoard());
        SetAvailableMoves setAvailableMoves = new SetAvailableMoves();

        boolean noMoreMoves = setAvailableMoves.isNoMoveAvailable(gameBoard.getBoard());




        if(noMoreMoves||filledUp || isTheBoardFilledUpByOnly1(gameBoard)){
            return true;
        }

        return false;

    }

    public static int max_value_determination(int nodeAlpha,int nodeBeta,int d, Board_Maintenance gameBoard, int choiceOfHeurestic){

        if(d==DEPTH){

            int retVal = gameBoard.getHeuristics(p1,choiceOfHeurestic);
            return retVal;
        }

        if(endGameCondition(gameBoard)){

            int retVal =gameBoard.getHeuristics(p1,choiceOfHeurestic);
            return retVal;
        }

        int a = nodeAlpha;
        int b = nodeBeta;

        ArrayList<int[]> movesList = gameBoard.determineSetOfMoves(p1);
        int sizeMoves = movesList.size();


        int maxValTillNow = Integer.MIN_VALUE;

        int i=0;
        while(i<sizeMoves){
            int[] move = movesList.get(i);
            BoardFunctions bb = new BoardFunctions();
            int[][] tempBoard = bb.copyConstructor(gameBoard.getBoard());
            Board_Maintenance newbie = new Board_Maintenance(tempBoard);

            int row = move[0];
            int col = move[1];

            newbie.turn(row,col,p1);
            int nextDepth = d + 1;
            int retVal = min_value_determination(a,b,nextDepth,newbie,choiceOfHeurestic);

            if(maxValTillNow<retVal){
                maxValTillNow = retVal;
            }

            int[] t = update_max_a_b(maxValTillNow,a,b);
            if(t[0] == 1) return maxValTillNow;
            a = t[1];

            i++;

        }

        return maxValTillNow;
    }

    public static int[] update_max_a_b(int maxValTillNow,int a, int b){
        int [] array = new int[2];
        array[0] = 0;
        if(maxValTillNow>=b)
            array[0]=1;
        a = Integer.max(a,maxValTillNow);
        array[1] = a;
        return array;
    }

    public static int min_value_determination(int nodeAlpha,int nodeBeta,int d, Board_Maintenance gameBoard, int choiceOfHeurestic){

        if(d==DEPTH){

            int retVal = gameBoard.getHeuristics(p1,choiceOfHeurestic);
            return retVal;
        }

        boolean endGame = endGameCondition(gameBoard);

        if(endGame){

            int retVal = gameBoard.getHeuristics(p1,choiceOfHeurestic);
            return retVal;
        }

        int a = nodeAlpha;
        int b = nodeBeta;

        ArrayList<int[]> movesList = gameBoard.determineSetOfMoves(p2);

        int i=0;

        int minValTillNow = Integer.MAX_VALUE;

        while (i<movesList.size()){
            int[] move = movesList.get(i);
            BoardFunctions bb = new BoardFunctions();
            int[][] tempBoard = bb.copyConstructor(gameBoard.getBoard());

            Board_Maintenance newbie = new Board_Maintenance(tempBoard);
            int row = move[0];
            int col = move[1];

            newbie.turn(row,col,p2);
            int nextDepth = d + 1;

            int retVal = max_value_determination(a,b,nextDepth,newbie,choiceOfHeurestic);



            if(minValTillNow>retVal){
                minValTillNow = retVal;
            }
            int[] check = update_min_ab(minValTillNow, a , b);
            if(check[0] == 1) return minValTillNow;
            b = check[1];

            i++;

        }

        return minValTillNow;

    }

    public static int[] update_min_ab(int minValTillNow,int a , int b){
        int [] array = new int[2];
        array[0] = 0;
        if(minValTillNow<=a)
            array[0] = 1;
        b = Integer.min(b,minValTillNow);
        array[1] = b;
        return array;
    }

    public static int[] miniMax( int rA, int rB, Board_Maintenance gameBoard, int choiceOfHeurestic){



        int i=0;
        int index_of_optimum_move = 0;

        ArrayList<int[]> moves = gameBoard.determineSetOfMoves(p1);
        int size_of_moves = moves.size();





        int a = rA;
        int valMax = Integer.MIN_VALUE;
        int b = rB;

        while(i<size_of_moves){
            int[] move = moves.get(i);
            BoardFunctions bb = new BoardFunctions();
            int[][] tempBoard = bb.copyConstructor(gameBoard.getBoard());

            Board_Maintenance newbie = new Board_Maintenance(tempBoard);
            newbie.turn(move[0],move[1],p1);
            int val = min_value_determination(a,b,1,newbie,choiceOfHeurestic);


            int curIndex = i;

            int[] check = updateVals(valMax,val,a,index_of_optimum_move,curIndex);
            valMax = check[0];
            a = check[1];
            index_of_optimum_move=check[2];


            i++;
        }



        int[] retMove =  moves.get(index_of_optimum_move);
        return retMove;
    }
    public static int[] updateVals(int valMax, int val,int a,int index_of_optimum_move,int curIndex){
        int[] retArray = new int[3];

        valMax= Integer.max(valMax,val);
        retArray[0] = valMax;
        boolean isAlphaToBeChanged = valMax>=a;
        if(isAlphaToBeChanged){
            a=valMax;
            index_of_optimum_move=curIndex;
        }
        retArray[1] = a;
        retArray[2] = index_of_optimum_move;
        return retArray;
    }


    public static void main(String[] args) {



        initialize();
        BoardFunctions boardFunctions = new BoardFunctions();
        Scanner sc  = new Scanner(System.in);
        System.out.println("Which Algo do you want to use!! ");
        System.out.println("1. POSITIONAL\n 2 MOBILITY\n 3 ABSOLUTECOUNT");
        int choice = sc.nextInt();




        int numberOfGameSimulation = 1;
        int totalNumberOfSimution = 100;
        ArrayList<Long> timesPerSimulation  = new ArrayList<Long>();

        while(numberOfGameSimulation<=totalNumberOfSimution) {


            Board_Maintenance state = new Board_Maintenance();
            ArrayList<int[]> movesList;



            long startTime = System.currentTimeMillis();
            while (true) {

                if (gameWon(state))
                    break;

                movesList = state.determineSetOfMoves(p1);

                boardFunctions.board_printer(state.getBoard());

                int sizeOfMove = movesList.size();
                if(sizeOfMove == 0)
                {
                    System.out.println("There are no more valid moves left\n\n");
                }
                else if (sizeOfMove > 0) {
                    int[] m = miniMax( Integer.MIN_VALUE,Integer.MAX_VALUE,state, choice);//sending alpha,beta for root
                    int row = m[0];
                    int col = m[1];
                    System.out.println("Computer "+p1+" played move at row " + row + ", col " + col);
                    state.turn(row, col, p1);
                }



                player_switch();

            }

            long endTime = System.currentTimeMillis();


            timesPerSimulation.add((endTime - startTime)/1000);

            long tempTime = (endTime - startTime)/1000;

            boardFunctions.board_printer(state.getBoard());



            System.out.println("Iteration no: "+numberOfGameSimulation+" time: " + tempTime);


            numberOfGameSimulation++;
        }



        long totalTime = 0 ;

        int sizeOfTimeArray = timesPerSimulation.size();
        for(int i = 0;i<sizeOfTimeArray;i++){
            totalTime += timesPerSimulation.get(i);
        }

        float averageTime  = (float)totalTime/(float)totalNumberOfSimution;

        String heuristicAlgo = "";
        switch (choice){

            case 1: heuristicAlgo= "Positional";break;
            case 2: heuristicAlgo= "mobility";break;
            case 3: heuristicAlgo= "absolute";break;
        }

        System.out.println("Average with "+heuristicAlgo+": "+averageTime);

    }


}
