import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.io.ObjectOutputStream;


public class Window extends JFrame {
    private Button[][] grid = new Button[3][3];
    private boolean isActive;

    public void init() {
        if(Main.isHost == true) { // Host gets to go first
            isActive = true;
        } else {
            isActive = false;
        }

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setTitle("TicTacToe");
        this.setLayout(new GridLayout(3,3));

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                grid[i][j] = new Button();
                grid[i][j].coordinate[0] = i;
                grid[i][j].coordinate[1] = j;
                grid[i][j].addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if(isActive == true) {
                            isActive = false;
                            ((JButton) e.getComponent()).setIcon((new ImageIcon(Main.oIcon)));
                            try {
                                ObjectOutputStream outStream = (ObjectOutputStream) Main.endpoint.getOutputStream();
                                outStream.write(((Button) e.getComponent()).coordinate[0]); // Write y
                                outStream.write(((Button) e.getComponent()).coordinate[1]); // Write x
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                        }
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {

                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {

                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {

                    }

                    @Override
                    public void mouseExited(MouseEvent e) {

                    }
                });
                this.add(grid[i][j]);
            }
        }






        this.setVisible(true);
    }
}
