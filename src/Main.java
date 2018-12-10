import fraction.FractionImpl;

/**
 * Created by sstrem01 on 28/11/2018.
 */
public class Main {

    public static void main(String[] args){
        FractionImpl f1 = new FractionImpl(36, 14);
        FractionImpl f2 = new FractionImpl(3, 1);
        System.out.println(f1.add(f2));

        FractionImpl f4 = (FractionImpl) f1.add(f2);
        //System.out.println(f4.toString());
        FractionImpl f3 = new FractionImpl(" 10/8");
        //System.out.println(f3.toString());


    }
}