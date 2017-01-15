import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * Created by tearsyu on 14/01/17.
 */
public class UIGame extends JFrame implements ActionListener, ItemListener{
    private GuessColor guessColor;
//    private static final String color1 = "RED";
//    private static final String color2 = "BLACK";
//    private static final String color3 = "WHITE";
//    private static final String color4 = "GREEN";
    private JButton check, re;
    private JComboBox box1, box2, box3, box4;
    private JPanel colorPanel1, colorPanel2, colorPanel3, colorPanel4;
    private String[] getColor = {null, null, null, null};
    private int nbGuess = 6;

    public UIGame(){
        super("Guess Color Author:Tearsyu");
        guessColor = new GuessColor();
        init();
    }

    public void init(){
        setSize(1000, 600);
        setLayout(new GridLayout(2,5));

        box1 = new JComboBox();
        box1.addItem(GuessColor.Color.RED);
        box1.addItem(GuessColor.Color.BLACK);
        box1.addItem(GuessColor.Color.WHITE);
        box1.addItem(GuessColor.Color.GREEN);
        box2 = new JComboBox();
        box2.addItem(GuessColor.Color.RED);
        box2.addItem(GuessColor.Color.BLACK);
        box2.addItem(GuessColor.Color.WHITE);
        box2.addItem(GuessColor.Color.GREEN);
        box3 = new JComboBox();
        box3.addItem(GuessColor.Color.RED);
        box3.addItem(GuessColor.Color.BLACK);
        box3.addItem(GuessColor.Color.WHITE);
        box3.addItem(GuessColor.Color.GREEN);
        box4 = new JComboBox();
        box4.addItem(GuessColor.Color.RED);
        box4.addItem(GuessColor.Color.BLACK);
        box4.addItem(GuessColor.Color.WHITE);
        box4.addItem(GuessColor.Color.GREEN);
        box1.addItemListener(this);
        box2.addItemListener(this);
        box3.addItemListener(this);
        box4.addItemListener(this);

        //panel color
        colorPanel1 = new JPanel();
        colorPanel1.setBackground(Color.RED);
        colorPanel2 = new JPanel();
        colorPanel2.setBackground(Color.RED);
        colorPanel3 = new JPanel();
        colorPanel3.setBackground(Color.RED);
        colorPanel4 = new JPanel();
        colorPanel4.setBackground(Color.RED);

        //button
        check = new JButton("CHECK");
        check.addActionListener(this);
        re = new JButton("RETRY");
        re.addActionListener(this);
        getContentPane().add(box1);
        getContentPane().add(box2);
        getContentPane().add(box3);
        getContentPane().add(box4);
        getContentPane().add(check);
        getContentPane().add(colorPanel1);
        getContentPane().add(colorPanel2);
        getContentPane().add(colorPanel3);
        getContentPane().add(colorPanel4);
        getContentPane().add(re);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void reStart(){
        nbGuess = 6;
        guessColor.initColor();
        box1.setSelectedItem(GuessColor.Color.RED);
        box2.setSelectedItem(GuessColor.Color.RED);
        box3.setSelectedItem(GuessColor.Color.RED);
        box4.setSelectedItem(GuessColor.Color.RED);

        colorPanel1.setBackground(Color.RED);
        colorPanel1.setBackground(Color.RED);
        colorPanel3.setBackground(Color.RED);
        colorPanel4.setBackground(Color.RED);
        check.removeActionListener(this);
        check.addActionListener(this);
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == check) {
            if(nbGuess > 0) {
                getColor[0] = box1.getSelectedItem().toString().toString();
                getColor[1] = box2.getSelectedItem().toString().toString();
                getColor[2] = box3.getSelectedItem().toString().toString();
                getColor[3] = box4.getSelectedItem().toString().toString();
                for (String str : getColor) {
                    System.out.print(str + " | ");
                }
                System.out.println();
                nbGuess--;
                if (!guessColor.equals(getColor)) {
                    JOptionPane.showMessageDialog(null,
                            guessColor.equalsInt(getColor) + " error. You have " + nbGuess + " times to try.");
                } else {
                    JOptionPane.showMessageDialog(null, "You win!");
                }
            }
        }
        if (e.getSource() == re){
            reStart();
        }
    }


    /**
     * Invoked when an item has been selected or deselected by the user.
     * The code written for this method performs the operations
     * that need to occur when an item is selected (or deselected).
     *
     * @param e
     */
    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == box1) {
            if (box1.getSelectedItem().toString().equals("RED")) {
                colorPanel1.setBackground(Color.RED);
            }
            if (box1.getSelectedItem().toString().equals("WHITE")) {
                colorPanel1.setBackground(Color.WHITE);
            }
            if (box1.getSelectedItem().toString().equals("BLACK")) {
                colorPanel1.setBackground(Color.BLACK);
            }
            if (box1.getSelectedItem().toString().equals("GREEN")) {
                colorPanel1.setBackground(Color.GREEN);
            }
        }
        if (e.getSource() == box2) {
            if (box2.getSelectedItem().toString().equals("RED")) {
                colorPanel2.setBackground(Color.RED);
            }
            if (box2.getSelectedItem().toString().equals("WHITE")) {
                colorPanel2.setBackground(Color.WHITE);
            }
            if (box2.getSelectedItem().toString().equals("BLACK")) {
                colorPanel2.setBackground(Color.BLACK);
            }
            if (box2.getSelectedItem().toString().equals("GREEN")) {
                colorPanel2.setBackground(Color.GREEN);
            }
        }
        if(e.getSource() == box3){
            if(box3.getSelectedItem().toString().equals("RED")){
                colorPanel3.setBackground(Color.RED);
            }
            if(box3.getSelectedItem().toString().equals("WHITE")){
                colorPanel3.setBackground(Color.WHITE);
            }
            if(box3.getSelectedItem().toString().equals("BLACK")){
                colorPanel3.setBackground(Color.BLACK);
            }
            if(box3.getSelectedItem().toString().equals("GREEN")){
                colorPanel3.setBackground(Color.GREEN);
            }
        }
        if(e.getSource() == box4) {
            if (box4.getSelectedItem().toString().equals("RED")) {
                colorPanel4.setBackground(Color.RED);
            }
            if (box4.getSelectedItem().toString().equals("WHITE")) {
                colorPanel4.setBackground(Color.WHITE);
            }
            if (box4.getSelectedItem().toString().equals("BLACK")) {
                colorPanel4.setBackground(Color.BLACK);
            }
            if (box4.getSelectedItem().toString().equals("GREEN")) {
                colorPanel4.setBackground(Color.GREEN);
            }
        }
    }
}
