import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;


/* TODO:
 * Set up application to have basic functionality [done]
 * Create basic layout for simple standard form polynomial (up to two degrees)
 * Present factorization in more appealing way
 * Remove spaces within equation as to make it easier to parse [done]
 * add dropdown menu for degrees (and update functionality!)
 */

public class main extends JFrame {
    private JTextField f1;
    private JButton b;
    private JLabel l2;



    public main()
    {
        this.setTitle("Factoring App");
        this.setSize(1000,1000);


        JPanel contentPane = new JPanel(null);
        contentPane.setBackground(new Color(100,100,100));
        contentPane.setPreferredSize(new Dimension(1000, 1000));
        

        b = new JButton();
        b.setEnabled(true);
        b.setText("Submit");
        b.setBounds(850,50,100,50);
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                runSubmit(e);
            }
        });

        l2 = new JLabel("answer");
        l2.setBounds(75, 100, 800, 50);
        l2.setPreferredSize(new Dimension(800,400));
        
        f1 = new JTextField();
        f1.setText("Enter Expression");
        f1.setBounds(75,50,750,50);
        f1.setEnabled(true);

        contentPane.add(f1);
        contentPane.add(b);
        contentPane.add(l2);
       

       this.add(contentPane);
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.pack();
       this.setVisible(true);

        










    }
    public String getValues(String exp)
    {

        String expNoSpace = exp.replaceAll("\\s+", "");



        int a;
        int b;
        int c;
        // first,second, and third occurance of space


        int placeFirstTerm = 0;
        int placeSecondTerm = 0;


        // int placeThirdSpace = exp.indexOf(" ", placeSecondSpace + 1);
        // int placeFourthSpace = exp.indexOf(" ", placeThirdSpace + 1);


        if(exp.contains("+") && exp.contains("-"))
        {
            int placePlus = expNoSpace.indexOf("+");
            int placeMinus = expNoSpace.indexOf("-");

            if(placePlus < placeMinus)
            {
                placeFirstTerm = placePlus; 

                placeSecondTerm = placeMinus; 
            } else if (placePlus > placeMinus) {
                placeFirstTerm = placeMinus;
                placeSecondTerm = placePlus;
            }

        } else if (exp.contains("+") && !exp.contains("-")) {
            placeFirstTerm = expNoSpace.indexOf("+");
            
            placeSecondTerm = expNoSpace.indexOf("+", placeFirstTerm + 1);
        } else if (exp.contains("-") && !exp.contains("+")) {
            placeFirstTerm = expNoSpace.indexOf("-");
            placeSecondTerm = expNoSpace.indexOf("-", placeFirstTerm + 1);
        }


        int placeFx = expNoSpace.indexOf("x");
        String as = expNoSpace.substring(0,placeFx );

        if(as == "")
        {
            a = 1;

        } else {

            a = Integer.parseInt(as);
        }




        int placeSx = expNoSpace.indexOf("x", placeFx +1);
        
        String bs = expNoSpace.substring((placeFirstTerm), placeSx);
        b = Integer.parseInt(bs);


        String cs = expNoSpace.substring((placeSecondTerm));
        c = Integer.parseInt(cs);


        System.out.println("a:  " + a + " b: " + b + " c: " + c);  
        return "a" + a + "b" + b + "c" + c;

    }
    public String calculation(String values)
    {

        String value1 = values.substring(1,values.indexOf("b"));
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
            return "INVALID: No Real Solution";
        }


        factor1 = ((-1*b) + Math.sqrt(discriminant)) / (2*a);
        factor2 = ((-1*b) - Math.sqrt(discriminant)) / (2*a);

        return "x1 = " + factor1 + "  x2 = " + factor2; 



        

    }

    private void runSubmit(ActionEvent evt)
    {
            String values = getValues(f1.getText());
            String answer = calculation(values);

            if(answer == "INVALID: No Real Solution")
            {
                l2.setText("No Real Solution! Negative Discriminant");

            } else {
                l2.setText(answer);

            }




        
    }  

    public static void main(String[] args)
    {
        new main();

    }




}
