import javax.swing.*;

public class main {
    public static void main(String[] args)
    {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(300,300);

        JButton b = new JButton("Press");
        f.getContentPane().add(b);
        f.setVisible(true);



    }
}
