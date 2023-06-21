package Solutions.ValidSudoku;

import java.util.HashSet;

/**
 * 2023/6/20
 *
 * @author Daniel Atlas
 */
public class ValidSudoku {
    public static void main(String[] args) {
        char[][] board = {{'8','.','.','.','7','.','.','.','.'}
                        ,{'6','.','.','1','9','5','.','.','.'}
                        ,{'.','9','8','.','.','.','.','6','.'}
                        ,{'8','.','.','.','6','.','.','.','3'}
                        ,{'4','.','.','8','.','3','.','.','1'}
                        ,{'7','.','.','.','2','.','.','.','6'}
                        ,{'.','6','.','.','.','.','2','8','.'}
                        ,{'.','.','.','4','1','9','.','.','5'}
                        ,{'.','.','.','.','8','.','.','7','9'}};
        System.out.println(isValidSudoku(board));
    }

    public static boolean isValidSudoku(char[][] board) {
        if(board.length!=9||board[0].length!=9){
            return false;
        }
        for(char[] row : board){
            HashSet<Character> rowCur = new HashSet<>();
            for(char cur : row){
                if(cur!='.'&&rowCur.contains(cur)){
                    return false;
                }
                rowCur.add(cur);
            }
        }
        for(int col=0;col<9;col++){
            HashSet<Character> colCur = new HashSet<>();
            for(int row=0;row<9;row++){
                if(board[row][col]!='.'&&colCur.contains(board[row][col])){
                    return false;
                }
                colCur.add(board[row][col]);
            }
        }
        for(int i=0;i<9;i+=3){
            for(int j=0;j<9;j+=3){
                HashSet<Character> blockCur = new HashSet<>();
                for(int row=i;row<i+3;row++){
                    for(int col=j;col<j+3;col++){
                        if(board[row][col]!='.'&&blockCur.contains(board[row][col])){
                            return false;
                        }
                        blockCur.add(board[row][col]);
                    }
                }
            }
        }
        return true;
    }
}
