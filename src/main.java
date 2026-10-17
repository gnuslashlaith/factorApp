import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;

public class main extends JFrame {
    private JTextField f1;
    private JButton b;
    private JLabel l1;
    private JLabel l2;



    public main()
    {
        this.setTitle("Factoring App");
        this.setSize(300,300);


        JPanel contentPane = new JPanel(null);
        contentPane.setBackground(new Color(100,100,100));
        contentPane.setPreferredSize(new Dimension(300, 150));
        

        b = new JButton();
        b.setEnabled(true);
        b.setText("Submit");
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                runSubmit(e);
            }
        });

        l1 = new JLabel("Enter expression: ");
        l2 = new JLabel("answer");
        
        f1 = new JTextField();
        f1.setText("Enter");
        f1.setEnabled(true);

        contentPane.add(f1);
        contentPane.add(b);
        contentPane.add(l1);
        contentPane.add(l2);
       

       this.add(contentPane);
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.pack();
       this.setVisible(true);

        










    }
    public String getValues(String exp)
    {


        int a;
        int b;
        int c;
        // first,second, and third occurance of space
        int placeFirstSpace = exp.indexOf(" ");
        int placeSecondSpace = exp.indexOf(" ", placeFirstSpace + 1);
        int placeThirdSpace = exp.indexOf(" ", placeSecondSpace + 1);
        int placeFourthSpace = exp.indexOf(" ", placeThirdSpace + 1);

        int placeFx = exp.indexOf("x");
        String as = exp.substring(0, placeFx);

        if(as == "")
        {
            a = 1;

        } else {

            a = Integer.parseInt(as);
        }

        int placeSx = exp.indexOf("x", placeFx +1);
        
        String bs = exp.substring((placeSecondSpace + 1), placeSx);
        b = Integer.parseInt(bs);


        String cs = exp.substring((placeFourthSpace + 1));
        c = Integer.parseInt(cs);


        return "a" + a + "b" + b + "c" + c;

    }
    public String calculation(String values)
    {

        String value1 = values.substring(0,values.indexOf("b"));
        int a = Integer.parseInt(value1);
        String value2 = values.substring((values.indexOf("b")+1), values.indexOf("c"));
        int b = Integer.parseInt(value2);
        String value3 = values.substring((values.indexOf("c")+1));
        int c = Integer.parseInt(value3);

        double discriminant = Math.pow(Math.abs(b),2) - (4*a*c);
        double factor1;
        double factor2;


        if(discriminant < 0)
        {
            return null;
        }


        factor1 = (-b + Math.sqrt(discriminant)) / (2*a);
        factor2 = (-b - Math.sqrt(discriminant)) / (2*a);

        return factor1 + " " + factor2; 



        

    }

    private void runSubmit(ActionEvent evt)
    {
            String values = getValues(f1.getText());
            String answer = calculation(values);

            l2.setText(answer);


        
    }  

    public static void main(String[] args)
    {
        new main();

    }




}
