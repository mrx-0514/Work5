package Find;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Work4 extends JFrame implements ActionListener {
    private Container cont;
    private JLabel label1, label2, la, lb, lc, lstep,le;
    private JRadioButton r1, r2, r3;
    private JButton b1,b2,b3;
    private JTextArea ta1,ta2;
    private JLabel x, y;
    private JTextField t1, t2, ta, tb, tc, tstep,te;
    private ButtonGroup g;
    private GraphFunction G;

    public Work4() {
        setTitle("WORK 3");
        setBounds(300, 90, 1000, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //setResizable(false);

        g = new ButtonGroup();

        cont = getContentPane();
        cont.setLayout(null);

        label1 = new JLabel("Xstart");
        label1.setSize(150, 40);
        label1.setLocation(10, 30);
        cont.add(label1);

        t1 = new JTextField();
        t1.setSize(150, 30);
        t1.setLocation(60, 30);
        t1.setText("-5");
        cont.add(t1);

        label2 = new JLabel("Xend");
        label2.setSize(150, 40);
        label2.setLocation(10, 60);
        cont.add(label2);

        t2 = new JTextField();
        t2.setSize(150, 30);
        t2.setLocation(60, 70);
        t2.setText("5");
        cont.add(t2);

        r1 = new JRadioButton("y=a*x+bx+c");
        r1.setSize(150, 20);
        r1.setLocation(10, 100);
        g.add(r1);
        cont.add(r1);

        r2 = new JRadioButton("y=a*x^2+b*x+c",true);
        r2.setSize(150, 20);
        r2.setLocation(10, 140);
        g.add(r2);
        cont.add(r2);

        r3 = new JRadioButton("y=a*x^3+b*x^2+c*x");
        r3.setSize(170, 20);
        r3.setLocation(10, 180);
        g.add(r3);
        cont.add(r3);

        la = new JLabel("a");
        la.setLocation(10,240 );
        la.setSize(20, 20);
        cont.add(la);

        lb = new JLabel("b");
        lb.setLocation(10, 280);
        lb.setSize(20, 20);
        cont.add(lb);

        lc = new JLabel("c");
        lc.setSize(20, 20);
        lc.setLocation(10, 320);
        cont.add(lc);

        lstep = new JLabel("step");
        lstep.setLocation(10, 360);
        lstep.setSize(50, 20);
        cont.add(lstep);

        tstep = new JTextField();
        tstep.setSize(150, 30);
        tstep.setLocation(60, 400);
        tstep.setText("1");
        cont.add(tstep);

        ta = new JTextField();
        ta.setLocation(60,240 );
        ta.setSize(150, 30);
        cont.add(ta);

        tb = new JTextField("1");
        tb.setSize(150, 30);
        tb.setLocation(60, 280);
        cont.add(tb);

        tc = new JTextField("2");
        tc.setLocation(60, 320);
        tc.setSize(150, 30);
        cont.add(tc);

        te = new JTextField("0.001");
        te.setSize(150,30);
        te.setLocation(60,360);
        cont.add(te);

        le=new JLabel("E");
        le.setSize(150,30);
        le.setLocation(10,400);
        cont.add(le);

        b1 = new JButton("Calculate");
        b1.setSize(100, 30);
        b1.setLocation(60, 450);
        cont.add(b1);

        b2 = new JButton("Bisection");
        b2.setLocation(60,490);
        b2.setSize(100,30);
        cont.add(b2);

        b3 = new JButton("chord");
        b3.setSize(100,30);
        b3.setLocation(60,530);
        cont.add(b3);

        ta1 = new JTextArea();
        ta1.setSize(150, 470);
        ta1.setLocation(250, 30);
        cont.add(ta1);

        x = new JLabel("X");
        x.setSize(20, 20);
        x.setLocation(300, 10);
        cont.add(x);

        y = new JLabel("Y");
        y.setSize(20, 20);
        y.setLocation(400, 10);
        cont.add(y);

        setVisible(true);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==b1) {
            float a, b, c, step, Xn, Xk, ans, Te;
            int type = 0;
            Xn = Float.parseFloat(t1.getText());
            Xk = Float.parseFloat(t2.getText());
            a = Float.parseFloat(ta.getText());
            b = Float.parseFloat(tb.getText());
            c = Float.parseFloat(tc.getText());
            step = Float.parseFloat(tstep.getText());
            Te = Float.parseFloat(te.getText());
            String result = "";


            H hesap = new H(Xn, Xk, a, b, c, step, Te);
            if (r1.isSelected()) {
                type = 1;
            }
            if (r2.isSelected()) {
                type = 2;
            }
            if (r3.isSelected()) {
                type = 3;
            }

            G = new GraphFunction();
            add(G);
            hesap.function(type);

            ta1.setText(hesap.getText());
            G.setMass_y(hesap.getMass_yh());
            G.setMass_x(hesap.getMass_xh());
            G.setDecimal(hesap.Bisection(Xn,Xk,type));
            G.setHord(hesap.method_chord(Xn,Xk,type));
            G.setButtun(1);
            G.setOption(1);
            G.repaint();
        }

        if (e.getSource()==b2){
            G.setRoot(1);
            G.repaint();
        }
        if (e.getSource()==b3){
            G.setHButtun(1);
            G.setRoot(2);
            G.repaint();
        }
    }
    public static void main(String args[]) {

        Work4 work4 = new Work4();
    }
}
