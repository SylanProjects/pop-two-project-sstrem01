package fraction;
import java.util.*;

public class FractionImpl implements Fraction {
    /**
     * Parameters are the <em>numerator</em> and the <em>denominator</em>.
     * Normalize the fraction as you create it.
     * For instance, if the parameters are <pre>(8, -12)</pre>, create a <pre>Fraction</pre> with numerator
     * <pre>-2</pre> and denominator <pre>3</pre>.
     *
     * The constructor should throw an <pre>ArithmeticException</pre> if the denominator is zero.
     *
     * @param numerator
     * @param denominator
     */
    int n;
    private int d;
    private int ret_n;
    private int ret_d;

    public FractionImpl(int numerator, int denominator) {
        // TODO
        // set public or private or ...

        //checkDivideZero(denominator);

        n = numerator;
        d = denominator;
        checkDivideZero(d);

        int common_divisor = GCD(n, d);
        //System.out.print(common_divisor);
        n = n / common_divisor;
        d = d / common_divisor;

        if (n > 0 && d < 0){
            n = -n;
            d = -d;
        }
        // TODO
        // What happens when numerator and denominator are both negative?


    }

    /**
     * The parameter is the numerator and <pre>1</pre> is the implicit denominator.
     *
     * @param wholeNumber representing the numerator
     */
    public FractionImpl(int wholeNumber) {

        // TODO
        n = wholeNumber;
        d = 1;
    }

    /**
     * The parameter is a <pre>String</pre> containing either a whole number, such as `5` or `-3`, or a fraction,
     * such as "8/-12".
     * Allow blanks around (but not within) integers.
     * The constructor should throw an <pre>ArithmeticException</pre>
     * if given a string representing a fraction whose denominator is zero.
     * <p>
     * You may find it helpful to look at the available String API methods in the Java API.
     *
     * @param fraction the string representation of the fraction
     */
    public FractionImpl(String fraction) {

        String[] ch = (fraction.replaceAll("\\s", "")).split("/");
        // TODO
        // fix that replaceAll function to not get rid of the spaces before and after "/"


        n = Integer.valueOf(ch[0]);
        if(ch.length > 1) {d = Integer.valueOf(ch[1]);}
        else{d = 1;}
        checkDivideZero(d);



        int common_divisor = GCD(n, d);
        n = n / common_divisor;
        d = d / common_divisor;

        if (n > 0 && d < 0){
            n = -n;
            d = -d;
        }


    }

    private static void checkDivideZero(int n1){
        /*
        Checks if the denominator is zero.
         */
        if (n1 == 0){
            throw new ArithmeticException("Divide by zero");
        }
    }
    // TODO
    // STATIC?
    private int GCD( int number1, int number2){
        if (number2 == 0){
            return number1;
        }
        else{
            return GCD(number2, number1 % number2);
        }
    }
    private int getNumerator( Fraction f ) {
        String[] ch = f.toString().split("/");
        return Integer.valueOf(ch[0]);
    }
    private int getDenominator( Fraction f ) {
        String[] ch = f.toString().split("/");
        return Integer.valueOf(ch[1]);
    }


    /**
     * @inheritDoc
     */
    @Override
    public Fraction add(Fraction f) {
        /*
        This method returns a new fraction that is the sum of two fractions.
        The parameter passed to this method is a fraction "f" that will be
        added to this fraction.
        It uses the (ad+bc)/bd equation. //TODO
        For clarity, the return numerator and denominator are held in new
        variables so it is easier to see what is happening.
         */
        int new_numerator = ((this.n * getDenominator(f))+(this.d * getNumerator(f)));
        int new_denominator = this.d * getDenominator(f);

        return new FractionImpl(new_numerator, new_denominator);
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction subtract(Fraction f) {
        /*
        Same as the "add" method, it returns a new fraction which is the difference
        of the first fraction minus the second fraction.
        The parameter passed to this method is a fraction "f" that will be
        subtracted from this fraction.
        It uses the (ad-bc)/bd equation.
        As before, new values are held in new variables for a better readability.
         */
        int new_numerator = ((this.n * getDenominator(f)) - (this.d * getNumerator(f)));
        int new_denominator = this.d * getDenominator(f);
        return new FractionImpl(new_numerator, new_denominator);

    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction multiply(Fraction f) {
        /*
        This method returns a new fraction, which is the product of the two fractions.
        The parameter passed to this method is a fraction that this fraction will
        be multiplied by.
        (a*c)/(b*d) is used to calculate the product.
        The two variables store the new numerator and denominator.
         */
        int new_numerator = this.n * getNumerator(f);
        int new_denominator = this.d * getDenominator(f);
        return new FractionImpl(new_numerator, new_denominator);
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction divide(Fraction f) {
        /*
        This method return a new fraction, which is the quotient of dividing the main
        fraction by the second.
        The parameter passed to this method is the fraction that this fraction
        will be divided by.
        (a*d)/(b*c) is used to calculate the quotient.
        The two variables store the new numerator and denominator.
         */
        int new_numerator = this.n * getDenominator(f);
        int new_denominator = this.d * getNumerator(f);
        return new FractionImpl(new_numerator, new_denominator);
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction abs() {
        if(n < 0){
            return new FractionImpl(-n, d);
        }else{
            return new FractionImpl(n, d);
        }

    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction negate() {
        return new FractionImpl(-n, d);
    }

    /**
     * @inheritDoc
     */
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    /**
     * @inheritDoc
     */
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    /**
     * @inheritDoc
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction inverse() {
        /*
        This method return a new fraction which is the reverse of this fraction.
         */
        return new FractionImpl(this.d, this.n);
    }

    /**
     * @inheritDoc
     */
    @Override
    public int compareTo(Fraction o) {
        return 0;
    }

    /**
     * @inheritDoc
     */
    @Override
    public String toString() {
        // TODO
        /*
        How many / / / can there be?
        Make sure that 2/3/4 is not accepted
         */

        String ret = "";
        ret += Integer.toString(n);
        //if (this.d != 1){
            ret+= "/";
            ret += Integer.toString(d);
        //}
        // Should it 2/1 or 2 ??
        return ret;
    }
}