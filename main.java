import java.lang.reflect.Array;
import java.util.*;

public class main {
    // initilize two arraylist to save inputs
    static ArrayList<Integer> playerPos = new ArrayList<Integer>();
    static ArrayList<Integer> computerPos = new ArrayList<Integer>();
    public static void main(String[] args) {
// initilize 2D array of char as a board

        char[][] gameBoard = {{' ', '|', ' ', '|', ' ', '|', ' ', '|'}, {' ', '-', '-', '-', '-', '-', '-', '-'},
                {' ', '|', ' ', '|', ' ', '|', ' ', '|'}, {' ', '-', '-', '-', '-', '-', '-', '-'}, {' ', '|', ' ', '|', ' ', '|', ' ', '|'}};


while(true) {
    Scanner scan = new Scanner(System.in);
    System.out.println("PLEASE CHOOSE THE PLACE DESTINATION 1-9");
    int playerTurn = scan.nextInt();
    // checking if place already taken
    while (playerPos.contains(playerTurn) || computerPos.contains(playerTurn)){
        System.out.println(" PLACE AS BEEN TAKEN" ) ;

        return;
    }
    // placing X in user input requirments
    Placement(playerTurn, gameBoard, "player");

    // getting random number as the computer input from 1-9
    Random rand = new Random();
    int computerTurn = rand.nextInt(9) + 1;
    // checking if place already taken
    while (playerPos.contains(computerTurn) || computerPos.contains(computerTurn)){
        System.out.println(" PLACE AS BEEN TAKEN" ) ;
        computerTurn = rand.nextInt(9) + 1;
    }
    // placing O in computer requirmnet
    Placement(computerTurn, gameBoard, "computer");
    Print(gameBoard);
   String result= winner();
   System.out.println(result);
}

    }

// printing the array
    public static void Print(char[][] gameboard) {
        for (char[] y : gameboard) {
            for (char x : y) {
                System.out.print(x);
            }
            System.out.println();
        }

    }
    // placing X \ O in array
    public static void Placement(int position, char [][] gameBoard,String user){
        char symbol=' ';
        if(user.equals("player")){
            symbol='X';
            playerPos.add(position);
        }
     else   if(user.equals("computer")){
            symbol='O';
            computerPos.add(position);
        }
        switch (position){
            case 1 : gameBoard[0][2]=symbol;
                break;
            case 2 : gameBoard[0][4]=symbol;
                break;
            case 3 : gameBoard[0][6]=symbol;
                break;
            case 4 : gameBoard[2][2]=symbol;
                break;
            case 5 : gameBoard[2][4]=symbol;
                break;
            case 6 : gameBoard[2][6]=symbol;
                break;
            case 7 : gameBoard[4][2]=symbol;
                break;
            case 8 : gameBoard[4][4]=symbol;
                break;
            case 9 : gameBoard[4][6]=symbol;
                break;
            default:
                break;
        }

    }
    // return the result of the game
    public static String  winner(){
        // win cases

        List topRow = Arrays.asList(1,2,3);
        List middleRow = Arrays.asList(4,5,6);
        List buttomRow = Arrays.asList(7,8,9);
        List leftmRow = Arrays.asList(1,4,7);
        List middle2Row = Arrays.asList(2,5,8);
        List rightRow = Arrays.asList(3,6,9);
        List slant1Row = Arrays.asList(1,5,9);
        List slant2Row = Arrays.asList(3,5,7);
        // creating another arraylist save the winning options
        List<List> winnigCondition = new ArrayList<List>();
        winnigCondition.add(topRow);
        winnigCondition.add(buttomRow);
        winnigCondition.add(middleRow);
        winnigCondition.add(leftmRow);
        winnigCondition.add(rightRow);
        winnigCondition.add(slant1Row);
        winnigCondition.add(slant2Row);
        for(List l : winnigCondition){
            if(playerPos.containsAll(l) ){
                return "WINNER!";
            }
            else if (computerPos.containsAll(l)){
                return "LOSER";

            }
            else if (playerPos.size()+ computerPos.size()==9){
                return "DRAW";
            }
        }
return " ";
    }
}


