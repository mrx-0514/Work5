package Find;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class GraphFunction extends JPanel {

    ArrayList<Float> Mass_x = new ArrayList<>();
    ArrayList<Float> Mass_y = new ArrayList<>();
    Double x_start, x_end;
    double xmax = -Float.MAX_VALUE;
    double ymax = Float.MIN_VALUE;
    double xmin, ymin, ansmin, ansmax, absMax, step, r;
    double option,joop=0,Root=0,hord,HButton,buttun = 0;

    public GraphFunction() {
        this.setBounds(400, 30, 500, 470);
        setLayout(null);
    }

    public void setRoot(double ans) {
        Root = ans;

    }
    public void setDecimal(double ans) {

        joop = ans;
    }

    public void setHord(double ans) {
        hord=ans;
    }

    public void setHButtun(double ans){
        HButton=ans;
    }
    public void setOption(double ans) {
        option = ans;
    }

    public void setButtun(double ans) {
        buttun = ans;
    }

    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2=(Graphics2D) g;

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.drawLine(10, 193, 400, 193);
        g2.drawLine(193, 10, 193, 400);

        System.out.println("GETMASS "+getMass_x().size());


        for (int i=0;i<this.getMass_x().size();i++){
            if (Mass_x.get(i)>xmax){
                xmax=Mass_x.get(i);
            }
            if(Mass_y.get(i)>ymax){
                ymax=Mass_y.get(i);
            }
            if (Mass_x.get(i)<xmin){
                xmin=Mass_x.get(i);
            }
            if(Mass_y.get(i)<ymin){
                ymin=Mass_y.get(i);
            }
        }


        if (Math.abs(ymax)>=Math.abs(xmax)){
            ansmax=ymax;
        }
        if(Math.abs(ymax)<Math.abs(xmax)){
            ansmax=xmax;
        }
        if (Math.abs(ymin)>=Math.abs(xmin)){
            ansmin=ymin;
        }
        if(Math.abs(ymin)<Math.abs(xmin)){
            ansmin=xmin;
        }
        if (Math.abs(ansmax)>=Math.abs(ansmin)){
            absMax=ansmax;
        }
        if(Math.abs(ansmax)<Math.abs(ansmin)){
            absMax=ansmin;
        }

        step=Math.abs(absMax/5);
        System.out.println("step "+step+" absMax "+absMax);


        if (option==1) {
            DecimalFormat value = new DecimalFormat();
            double maxx = 0;
            double maxy = absMax;

            for (float i = 190; i < 330; i += 30) {
                g2.drawString((value.format(maxx)), (int) i, 180);
                g2.drawOval((int) i, 191, 4, 4);
                maxx += step;
            }
            maxx = -maxx;
            maxx += step;

            for (float i = 70; i < 180; i += 30) {
                g2.drawString((value.format(maxx)), (int) i, 180);
                g2.drawOval((int) i, 191, 4, 4);
                maxx += step;
            }
            //y
            for (float i = 10 + 30; i < 200; i += 30) {
                if (maxy != 0) {
                    g2.drawString((value.format(Math.abs(maxy))), 205, (int) i);
                    g2.drawOval(191, (int) i, 4, 4);
                }
                maxy -= step;
            }
            maxy = 0;
            for (float i = 190; i < 350; i += 30) {
                if (maxy != 0) {
                    g2.drawString((value.format(maxy)), 205, (int) i);
                    g2.drawOval(191, (int) i, 4, 4);
                }
                maxy -= step;
            }


            Polygon p3 = new Polygon();
            g2.setColor(Color.ORANGE);
            for (int i = 0; i < this.getMass_x().size(); i++) {
                // g2.drawOval((int));
                p3.addPoint((int) (193 + this.getMass_x().get(i) * (30 / step)), (int) (193 - this.getMass_y().get(i) * (30 / step)));

                //g2.draw(new Ellipse2D.Double(191+Mass_x.get(i)*(30/step), 191-Mass_y.get(i)*30/step, 3, 3));
            }

            g2.drawPolyline(p3.xpoints, p3.ypoints, p3.npoints);

        }
        if (Root==1){
            g2.setColor(Color.RED);
            g2.drawOval((int)(191+joop*(30/step)),191,4,5);
            g2.drawString("bisection method="+joop,20,400);

        }
        if (Root==2){
            g2.setColor(Color.BLACK);
            g2.drawOval((int)(191+hord*(30/step)),191,5,5);
            g2.drawString("H Root="+hord,20,420);
        }
    }

    public ArrayList<Float> getMass_x() {
        return Mass_x;
    }
    public void setMass_x(ArrayList<Float> mass_x) {
        this.Mass_x = mass_x;
    }
    public ArrayList<Float> getMass_y() {
        return Mass_y;
    }
    public void setMass_y(ArrayList<Float> mass_y) {
        this.Mass_y = mass_y;
    }
}
