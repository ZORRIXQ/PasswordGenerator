import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.*;

public class myUi extends JFrame{
    JButton copy = new JButton("Copy");
    JCheckBox upper = new JCheckBox("UpperText");
    JCheckBox lower = new JCheckBox("LowerText");
    JCheckBox nums = new JCheckBox("Nums");
    JCheckBox spec = new JCheckBox("Special symbols");
    JLabel label = new JLabel();
    JTextField text = new JTextField("Password", 10);

    public static Long count = 8l;

    JTextField elemCount = new JTextField("Password symbols", 10);

    JButton generate = new JButton("Generate password");
    myUi(){
        elemCount.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                elemCount.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {

            }
        });

        generate.addActionListener(e -> {
            if (elemCount.getText().equals("Password symbols") || elemCount.getText().isEmpty()){
                text.setText(symbols.createPass());
            }
            else {
                count = Long.parseLong(elemCount.getText());
                text.setText(symbols.createPass());
            }
        });

        copy.addActionListener(e -> {
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(
                    new StringSelection(text.getText()), null);
        });

        upper.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                symbols.Upper(e.getStateChange() == 1);
            }
        });

        lower.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                symbols.Lower(e.getStateChange() == 1);
            }
        });

        nums.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                symbols.Nums(e.getStateChange() == 1);
            }
        });

        spec.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                symbols.Symbols(e.getStateChange() == 1);
            }
        });

        text.setEditable(false);
        label.add(text);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1));
        panel.add(upper);
        panel.add(lower);
        panel.add(nums);
        panel.add(spec);
        elemCount.setLayout(new GridLayout());

        panel.add(elemCount);

        //indentation
        getRootPane().setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        ImageIcon img = new ImageIcon("pass.png");
        this.setIconImage(img.getImage());
        this.add(text);
        this.add(copy);
        this.add(panel);
        this.add(generate);
        this.setLayout(new GridLayout(4,2));
        this.setTitle("Password generator");
        this.setBounds(20, 20, 400, 300);
        centeringFrame(this.getWidth(), this.getHeight(), this);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private static void centeringFrame(int sizeWidth, int sizeHeight, JFrame frame) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int X = (screenSize.width - sizeWidth) / 2;
        int Y = (screenSize.height - sizeHeight) / 2;
        frame.setBounds(X, Y, sizeWidth, sizeHeight);
    }

}
