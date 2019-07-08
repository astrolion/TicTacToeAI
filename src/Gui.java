import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui {


    Gui( String name ){

        JFrame window = new JFrame(name);

        window.setSize(300,300);

        window.setLayout(new GridLayout(3,3));

        JButton button[][] = new JButton[3][3];

        Game game = new Game();

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){

                button[i][j] = new JButton();

                button[i][j].setText("");

                final int posx = i;
                final int poxy = j;
                button[i][j].addActionListener(
                        new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent actionEvent) {


                                int solve = game.solve(posx, poxy);


                            }
                        }

                );

                window.add(button[i][j]);


            }
        }


        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);





    }

}
