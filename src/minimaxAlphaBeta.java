public class minimaxAlphaBeta {

    private int board[][];
    private  final int BEST = 100;
    private  final int HUMAN = 0;
    private  final int AI = 1;
    private  final int CLEAR = -1;

    private  Point point;

    minimaxAlphaBeta( int Board[][] ){

        board = new int[3][3];
        point = new Point(-1,-1);

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                board[i][j] = Board[i][j];
                System.out.print(board[i][j]+" ");
            }
            System.out.println("");
        }
        System.out.println("---------");

        int score = -BEST;

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){


                if( board[i][j] == CLEAR ){

                    board[i][j] = AI;
                    int ret = minimax(board,0,true,-BEST,+BEST);
                    if( ret > score ){
                        score = ret;
                        point.setXY(i,j);

                    }

                    System.out.print(ret+" ");

                    board[i][j] = CLEAR;
                }
                else{
                    System.out.print("* ");
                }

            }
            System.out.println("");
        }

        System.out.println("-------------");



    }

    public  Point getCordinate(){
        return point;
    }




    private int evalution(int b[][] ){


        for(int i=0;i<3;i++){

            // row check
            if( b[i][0] == b[i][1] && b[i][1] == b[i][2] && b[i][2]!=-1 ){
                if( b[i][0] == 1 ) return +100;
                else return -100;
            }

            // column check

            if( b[0][i] == b[1][i] && b[1][i] == b[2][i] && b[2][i]!=-1 ){
                if(b[0][i] == 1) return +100;
                else return -100;
            }

        }

        if( b[1][1] == b[2][2] && b[0][0] == b[1][1] && b[1][1]!=-1 ){
            if( b[0][0] == 1 ) return +100;
            else return -100;
        }

        if( b[1][1] == b[0][2] && b[1][1] == b[2][0] && b[2][0]!=-1 ){
            if( b[1][1] == 1 ) return +100;
            else return -100;
        }

        return 0;

    }

    int minimax( int board[][], int depth, boolean isMax, int alpha, int beta ){

        int value = evalution(board);

        if( value == +100 || value == -100 ){
            return value;
        }

        if( isBoardFull(board) ){

            return 0;

        }

        if ( isMax ){

            int best = -BEST;

            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){

                    if(board[i][j] == CLEAR ){

                        board[i][j] = AI;

                        best = Math.max(
                          best,
                          minimax(board,depth+1,!isMax,alpha,beta)
                        );

                        board[i][j] = CLEAR;
                        alpha = Math.max(best, alpha);

                        if( beta<=alpha ){
                            break;
                        }

                    }


                }
            }

            return best;



        }
        else{

            int best = +BEST;

            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){

                    if( board[i][j] == CLEAR ){

                        board[i][j] = HUMAN;
                        best = Math.min( best, minimax(board,depth+1, !isMax, alpha,beta ) );
                        board[i][j] = CLEAR;

                        beta = Math.min(beta, best);
                        if( beta <= alpha ) break;

                    }

                }
            }

            return best;

        }


    }


    boolean isBoardFull(int board[][]){

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(board[i][j] == -1){
                    return false;
                }
            }
        }
        return true;

    }






}
