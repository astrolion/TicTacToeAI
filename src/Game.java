import javax.swing.*;

public class Game {

    private  int board[][];
    private boolean isGameOver;

    Game(){

        board = new int[3][3];
        isGameOver = false;
        clearBoard();

    }

    public  int solve( int i, int j ){

        if( board[i][j]  == -1 ){
            board[i][j] = 0;
            boolean gameState = gameOver();
            if( gameState == false ){



            }
            else{



            }

            return 1;
        }
        else{
            return 0;
        }

    }





    public boolean gameOver(){

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(board[i][j] == -1){
                    return false;
                }
            }
        }

        isGameOver = true;

        return true;

    }


    private  void clearBoard(){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                board[i][j] = -1;
            }
        }
    }



}
