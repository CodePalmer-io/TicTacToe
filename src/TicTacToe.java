import java.lang.reflect.Array;
import java.util.*;

public class TicTacToe {


    static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
    static ArrayList<Integer> cpuPositions = new ArrayList<Integer>();

    public static void main(String[] args) {
        char[][] GAMEBOARD = {{' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}};


        printGameBoard(GAMEBOARD);

        while (true)
        {
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter your placement (1-9): ");
            int playerPos = scan.nextInt();
            while(playerPositions.contains(playerPos) || cpuPositions.contains(playerPositions)) {
                System.out.println("Position taken! Enter a correct position");
                playerPos = scan.nextInt();
            }


            placePiece(GAMEBOARD, playerPos, "player");
            String result = checkWinner();
            if(result.length() > 0) {
                System.out.println(result);
                break;
            }

            Random rand = new Random();
            int cpuPos = rand.nextInt(9) + 1;
            while(playerPositions.contains(cpuPos) || cpuPositions.contains(cpuPos)) {
                cpuPos = rand.nextInt(9) + 1;
            }
            placePiece(GAMEBOARD,cpuPos,"cpu");

            printGameBoard(GAMEBOARD);
            result = checkWinner();
            if(result.length() > 0) {
                System.out.println(result);
                break;
            }
            System.out.println(result);
        }

    }

        public static void printGameBoard(char[][] GAMEBOARD) {
            for (char[] row : GAMEBOARD) {
                for (char c : row) {
                    System.out.print(c);
                }

                System.out.println();
            }

        }

        public static void placePiece(char[][] GAMEBOARD,int pos, String user )
        {
            char symbol = ' ';

            if(user.equals("player"))   {
                symbol = 'X';
                playerPositions.add(pos);
            }
            else if (user.equals("cpu")) {
                symbol = '0';
                cpuPositions.add(pos);
            }


            switch(pos)
            {
                case 1:
                    GAMEBOARD[0][0] = symbol;
                    break;
                case 2:
                    GAMEBOARD[0][2] = symbol;
                    break;
                case 3:
                    GAMEBOARD[0][4] = symbol;
                    break;
                case 4:
                    GAMEBOARD[2][0] = symbol;
                    break;
                case 5:
                    GAMEBOARD[2][2] = symbol;
                    break;
                case 6:
                    GAMEBOARD[2][4] = symbol;
                    break;
                case 7:
                    GAMEBOARD[4][0] = symbol;
                    break;
                case 8:
                    GAMEBOARD[4][2] = symbol;
                    break;
                case 9:
                    GAMEBOARD[4][4] = symbol;
                    break;
                default:
                    break;

            }

        }

        public static String checkWinner()
        {
            List topRow = Arrays.asList(1, 2, 3);
            List midRow = Arrays.asList(4, 5, 6);
            List botRow = Arrays.asList(7, 8, 9);
            List leftCol = Arrays.asList(1, 4, 7);
            List midCol = Arrays.asList(2, 5, 8);
            List rightCol = Arrays.asList(3, 6, 9);
            List cross1 = Arrays.asList(1, 5, 9);
            List cross2 = Arrays.asList(7, 5, 3);

            List<List> winningCondition = new ArrayList<List>();
            winningCondition.add(topRow);
            winningCondition.add(midRow);
            winningCondition.add(botRow);
            winningCondition.add(leftCol);
            winningCondition.add(midCol);
            winningCondition.add(rightCol);
            winningCondition.add(cross1);
            winningCondition.add(cross2);

            for(List l : winningCondition) {
                if(playerPositions.containsAll(l)) {
                    return "Congratulations you won!";
                } else if (cpuPositions.containsAll(l)) {
                    return "CPU wins! Sorry :(";
                } else if (playerPositions.size() + cpuPositions.size() == 9)
                {
                    return "CAT!";
                }
            }


            return "";
        }

}




