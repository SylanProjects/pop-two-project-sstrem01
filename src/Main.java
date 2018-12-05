import fraction.FractionImpl;

/**
 * Created by sstrem01 on 28/11/2018.
 */
public class Main {
    public static int GCD( int number1, int number2){
        if (number2 == 0){
            return number1;
        }
        else{
            return GCD(number2, number1 % number2);
        }
    }
    public static void main(String[] args){
        FractionImpl f1 = new FractionImpl(36, 14);
        FractionImpl f2 = new FractionImpl(52, 14);
        System.out.println(f1.toString());
        //System.out.println(f1.add(2, 2));
        FractionImpl f3;
        System.out.println(f1.add(f2).toString());
        //System.out.println(f2.toString());
       // FractionImpl f2 = new FractionImpl(4);
        //System.out.println(f2.toString());
        //System.out.print("Hello");




    }
}
