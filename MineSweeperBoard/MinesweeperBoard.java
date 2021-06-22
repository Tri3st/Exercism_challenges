import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//I found it hard to calculate how many mines are around a certain square. Especially when the square is in a corner.
//So I made the board bigger by placing an extra square around it. Do watch out with counting .. not to take the wrong coordinates ;)
//  board        bigBoard
//  1 2 3 4     1 2 3 4 5 6
//1 . . x .   1 . . . . . .
//2 . . . .   2 . . . x . .
//3 . . . .   3 . . . . . .
//4 . x . .   4 . . . . . .
//            5 . . x . . .
//            6 . . . . . .

public class MinesweeperBoard {
    private char[][] board;
    private char[][] result;
    private char[][] bigBoard;
    private List<String> boardList;

    public MinesweeperBoard(List<String> inputBoard){
        if (inputBoard.isEmpty()) boardList = Collections.emptyList();
        else {
            int dimi = inputBoard.size();
            int dimj = inputBoard.get(0).length();
            board = list2array(inputBoard);
            result = new char[dimi][dimj];
            initLargeBoard();
            calcBoard();
            boardList = array2List(result);
        }
    }

    public List<String> withNumbers(){
        return boardList;
    }

    private void initLargeBoard(){
        int dimi = board.length;
        int dimj = board[0].length;
        int dimLi = dimi + 2;
        int dimLj = dimj + 2;
        bigBoard = new char[dimLi][dimLj];
        for(int i = 0; i<dimLi;i++){
            for(int j=0; j<dimLj;j++){
                if(i>0 && j>0 && i<dimLi-1 && j<dimLj-1 && board[i-1][j-1]=='*') bigBoard[i][j]='*';
                else bigBoard[i][j]=' ';
            }
        }
    }

    private char[][] list2array(List<String> l1){
        int dim1 = l1.size();
        int dim2 = l1.get(0).length();
        char[][] tmp = new char[dim1][dim2];
        for(int i = 0; i<dim1;i++){
            String line1 = l1.get(i);
            for(int j=0; j<dim2;j++){
                tmp[i][j] = line1.charAt(j);
            }
        }
        return tmp;
    }

    private int countMines(int x, int y){
        int mines = 0;
        for (int i=0; i< 3; i++){
            for (int j=0; j<3; j++){
                if(!(i==1 && j==1) && bigBoard[x-i+1][y-j+1] == '*') mines++;
            }
        }
        return mines;
    }

    private void calcBoard(){
        for(int i = 1; i<bigBoard.length-1;i++){
            for(int j=1; j<bigBoard[0].length-1;j++){
                if(bigBoard[i][j]!='*'){     bigBoard[i][j] = (char)(countMines(i, j) + 48);
                    result[i-1][j-1] = countMines(i,j)==0?' ':(char)(countMines(i, j) + 48);
                } else result[i-1][j-1] ='*';
            }
        }
    }

    private List<String> array2List(char[][] arr){
        List<String> tmp = new ArrayList<>();
        for(int i=0; i<arr.length;i++){
            String line1 = "";
            for(int j=0; j<arr[0].length; j++){
                line1 += "" + arr[i][j];
            }
            tmp.add(line1);
        }
        return tmp;
    }
}
