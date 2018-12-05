package fraction;

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
    private int n;
    private int d;
    private int ret_n;
    private int ret_d;

    public FractionImpl(int numerator, int denominator) {
        // TODO
        // set public or private or ...
        if (denominator == 0){
            throw new ArithmeticException("Divide by zero");
        }
        n = numerator;
        d = denominator;
        int t1;
        int t2;

        int common_divisor = GCD(n, d);
        n = n / common_divisor;
        d = d / common_divisor;
        //if(n>d){t1 = n; t2 = d;
        //}else{t1 = d; t2 = n;}

        //while (t1 != 0 && t2 != 0){

        //}


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
        // TODO

    }
    public static int GCD( int number1, int number2){
        if (number2 == 0){
            return number1;
        }
        else{
            return GCD(number2, number1 % number2);
        }
    }


    /**
     * @inheritDoc
     */
    @Override
    public Fraction add(Fraction f) {

        int n2 = 2;
        int d2 = 2;
        FractionImpl rf = new FractionImpl(n2, d2);
        return rf;
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction subtract(Fraction f) {
        return null;
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction multiply(Fraction f) {
        return null;
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction divide(Fraction f) {
        return null;
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction abs() {
        return null;
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction negate() {
        return null;
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
        return null;
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
        String ret = "";
        ret += Integer.toString(n);
        if (this.d != 1){
            ret+= ", ";
            ret += Integer.toString(d);
        }

        return ret;
    }
}