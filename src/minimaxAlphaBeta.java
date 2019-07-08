public class minimaxAlphaBeta {

    private int board[][];

    minimaxAlphaBeta( int Board[][] ){

        board = new int[3][3];
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                board[i][j] = Board[i][j];
            }
        }

    }



    private int evalution(int b[][] ){


        for(int i=0;i<3;i++){

            // row check
            if( b[i][0] == b[i][1] && b[i][1] == b[i][2] ){
                if( b[i][0] == 1 ) return +100;
                else return -100;
            }

            // column check

            if( b[0][i] == b[1][i] && b[1][i] == b[2][i] ){
                if(b[0][i] == 1) return +100;
                else return -100;
            }

        }

        if( b[1][1] == b[2][2] && b[0][0] == b[1][1] ){
            if( b[0][0] == 1 ) return +100;
            else return -100;
        }

        if( b[2][2] == b[0][2] && b[2][2] == b[2][0] ){
            if( b[2][2] == 1 ) return +100;
            else return -100;
        }

        return 0;

    }






}
