import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameOfLife {
    private JPanel GameOfLife;
    private JButton Button;
    private JPanel tekenpanel;

    public GameOfLife() {
        Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("start game of life");
                Rooster();
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("GameOfLife");
        frame.setSize(500,500);
        frame.setResizable(false);
        frame.setContentPane(new GameOfLife().GameOfLife);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    public void Rooster() {
        tekenpanel = new JPanel();
        tekenpanel.setPreferredSize(new Dimension(400, 400));
        GameOfLife.add(tekenpanel);
        tekenpanel.setVisible(true);

    }
}
