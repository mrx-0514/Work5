package Find;

import java.util.ArrayList;

public class H {
    ArrayList<Float> Mass_xh;
    ArrayList<Float> Mass_yh;
    float a, b, c, xn, xk, step,E,A,B;
    float ans;
    String result = "";
    H(float Xn, float Xk, float A, float B, float C, float STEP,float e) {
        xn = Xn;
        xk = Xk;
        A=Xn;
        B=Xk;
        a = A;
        b = B;
        c = C;
        step = STEP;
        E=e;
        Mass_xh=new ArrayList<>();
        Mass_yh=new ArrayList<>();
    }
    public String getText(){
        return result;
    }
    public float fun1(float A,int j){
        if (j==1) {
            ans = a * A + b * A + c;
        }
        if (j == 2) {
                ans = a * (A * A) + b * A + c;
        }
        if (j == 3) {
            ans = a * (A * A * A) + b * (A * A) + c * A;
        }
        result += "      " + String.valueOf(A) + "         " + String.valueOf(ans) + " \n";
        Mass_yh.add(ans);
        return ans;
    }

    public void function(int type){
        for (float i = xn; i <= xk; i += step) {
            fun1(i,type);
            Mass_xh.add(i);
        }
    }
    public float Bisection(float A,float B,int type){
        float c = A;
        while ((B-A) > E)
        {
            // Find middle point
            c = (A+B)/2;

            // Check if middle point is root
            if (fun1(c,type) == 0.0)
                break;

                // Decide the side to repeat the steps
            else if (fun1(c,type)*fun1(A,type) < 0)
                B = c;
            else
                A = c;
        }
        System.out.println("BISection="+c);
        return c;
    }

    public  float method_chord (float x_prev, float x_curr,int type) {
        float x_next = 0;
        float tmp;
        while (Math.abs(x_next - x_curr) > E)
        {
            tmp = x_next;
            x_next = x_curr - fun1(x_curr,type) * (x_prev - x_curr) / (fun1(x_prev,type) - fun1(x_curr,type));
            x_prev = x_curr;
            x_curr = tmp;
        }
        System.out.println("HORD="+x_next);
        return x_next;
    }

    public ArrayList<Float> getMass_xh() {
        return Mass_xh;
    }
    public void setMass_xh(ArrayList<Float> mass_x) {
        this.Mass_xh = mass_x;
    }
    public ArrayList<Float> getMass_yh() {
        return Mass_yh;
    }
    public void setMass_yh(ArrayList<Float> mass_y) {
        this.Mass_yh = mass_y;
    }
}

