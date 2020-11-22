import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui extends JFrame implements ActionListener {
    private JButton start_button;
    private JButton stop_button;
    private JPanel paper;
    int[][] table = new int[10][10];

    public static void main(String[] args) throws InterruptedException {
        Gui frame = new Gui();
        frame.setSize(600, 600);
        frame.createGui();
        frame.setResizable(false);
        frame.setVisible(true);
    }

    private void createGui() throws InterruptedException {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        start_button = new JButton("Start");
        window.add(start_button);
        start_button.addActionListener(this);

        stop_button = new JButton("Stop");
        window.add(stop_button);
        stop_button.addActionListener(this);

        paper = new JPanel();
        paper.setPreferredSize(new Dimension(500, 500));
        paper.setBackground(Color.white);
        window.add(paper);
        paper.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        NextGeneration nextgen = new NextGeneration();
        Graphics tekenveld = paper.getGraphics();
        boolean start = false;
        table[0][0] = 1;
        table[1][1] = 1;
        table[1][0] = 1;
        table[0][1] = 1;

        table[9][9] = 1;
        table[8][8] = 1;
        table[7][7] = 1;
        table[8][7] = 1;
        table[9][7] = 1;
        table[7][9] = 1;


        switch (e.getActionCommand()) {
            case "Start" -> {
                start = true;
                System.out.println("Start");
                while (start) {
                    for (int i = 0; i < 10; i++) {
                        for (int k = 0; k < 10; k++) {
                            if (table[i][k] == 1) {
                                tekenveld.setColor(Color.BLACK);
                            } else {
                                tekenveld.setColor(Color.white);
                            }
                            tekenveld.fillRect(i * 50, k * 50, 50, 50);
                        }
                    }table = nextgen.GetNext(table);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException interruptedException) {
                        interruptedException.printStackTrace();
                    }
                }
            }
            case "Stop" -> {
                start = false;
                System.out.println("Stop");
            }
        }
    }
}
