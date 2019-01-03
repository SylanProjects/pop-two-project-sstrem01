import fraction.Fraction;
import fraction.FractionImpl;
import java.lang.Number;

/**
 * Created by sstrem01 on 28/11/2018.
 */
public class Main {

    public static void main(String[] args){
        FractionImpl f1 = new FractionImpl(15, 14);
        Fraction f2 = new FractionImpl(2, 4);
        //System.out.println(f1.divide(f2));

        Fraction f3 = new FractionImpl(1, 2);
        //System.out.println(f2.abs());

        System.out.println(f3.equals(f2));




        //FractionImpl f4 = (FractionImpl) f1.subtract(f2);
        //System.out.println(f4.toString());
        //FractionImpl f3 = new FractionImpl(" 10/8");
        //System.out.println(f3.toString());


    }
}