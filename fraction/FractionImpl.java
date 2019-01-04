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

    private final int n;
    private final int d;



    public FractionImpl(int numerator, int denominator) {

        checkDivideZero(denominator);

        this.n = numerator;
        this.d = denominator;



    }

    /**
     * The parameter is the numerator and <pre>1</pre> is the implicit denominator.
     *
     * @param wholeNumber representing the numerator
     */
    public FractionImpl(int wholeNumber) {

        this.n = wholeNumber;
        this.d = 1;

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

        String nume = fraction.substring(0, fraction.indexOf('/'));
        int num = Integer.parseInt(nume.trim());
        String deno = fraction.substring(fraction.indexOf('/')+1);
        int den = Integer.parseInt(deno.trim());

        checkDivideZero(den);

        this.n = num;
        this.d = den;



    }
    //Helper methods:
    private static void checkDivideZero(int n1){
        /*
         Input: Integer
         Checks if the denominator is zero.

         This method throws an Arithmetic Exception
        */
        if (n1 == 0){ throw new ArithmeticException("Divide by zero"); }
    }
    private int GCD( int n1, int n2){
        /*
         Input: two Integers, numerator and denominator
         Output: Greatest Common Divisor

         This method uses recursion to find the greatest common divisor.
        */
        if (n2 == 0){ return n1; }
        else{ return GCD(n2, n1 % n2); }
    }
    private int getNumerator( Fraction f ) {
        /*
        Input: Fraction
        Output: numerator integer

        This method takes the fraction and returns an integer value of the numerator
        to make it easier to access it throughout the class.
         */
        FractionImpl fr = (FractionImpl) f;
        return fr.n;
    }
    private int getDenominator( Fraction f ) {
        /*
        Input: Fraction
        Output: denominator integer

        This method takes the fraction and returns an integer value of the denominator
        to make it easier to access it throughout the class.
         */
        FractionImpl fr = (FractionImpl) f;
        return fr.d;
    }


    /**
     * @inheritDoc
     */
    @Override
    public Fraction add(Fraction f) {
        /*
        Input: Fraction
        Output: new fraction (this + f)

        This method returns a new fraction that is the sum of two fractions.
        The parameter passed to this method is a fraction "f" that will be
        added to this fraction.
        It uses the (ad+bc)/bd equation.
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
        Input: Fraction
        Output: new fraction (this - f)

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
        Input: Fraction
        Output: new fraction (this * f)

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
        Input: Fraction
        Output: new fraction (this / f)

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
        /*
        Input: None
        Output: new fraction

        This method returns this' fraction absolute value.
         */
        if(this.n < 0){
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
        /*
        Input: None
        Output: new fraction

        This method returns a new fraction which is a negative of this fraction,
        it does not negate this fraction.
         */
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
    public boolean equals(Object o) {
        /*
        Input: Object
        Output: boolean

        This method checks if the object is a fraction and checks if this is equal to
        the passed object.
         */
        if(o instanceof Fraction){
            FractionImpl f = (FractionImpl) o;
            if(this.n == f.n && this.d == f.d){
                return true; }
            else{ return false; }
        }
        else{ return false; }



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
        Output: new Fraction
        This method returns a new fraction which is the reverse of this fraction.
         */
        return new FractionImpl(this.d, this.n);
    }

    /**
     * @inheritDoc
     */
    @Override
    public int compareTo(Fraction f) {
        /*
        Input: Fraction
        Output: integer

        This method compares the two fractions and returns 1 if this is bigger than f,
        -1 if f is bigger than this and 0 if they are equal.
         */

        if(f != null){
            FractionImpl fr = (FractionImpl) f;
            double a = this.n/(double)this.d;
            double b = fr.n/(double)fr.d;
            if(a > b){
                return 1;
            }else if (a < b){
                return -1;
            }else{
                return 0;
            }
        }else{
            throw new ClassCastException();
        }



    }

    /**
     * @inheritDoc
     */
    @Override
    public String toString() {
        /*
        This method returns a normalized string representation of this fraction.
        It does not change the value of this numerator and denominator,
        it simply return new values.
        It first normalizes the representation of the fraction, then it makes
        sure that only the numerator is negative and lastly it returns a string
        representation of the fraction by storing the numerator and denominator in a
        new string variable "ret".
        */


        int num = n;
        int den = d;


        // Normalize
        int common_divisor = GCD(num, den);
        num = num / common_divisor;
        den = den / common_divisor;

        // MMake sure that only the numerator is negative
        if (num > 0 && den < 0){
            num = -num;
            den = -den;
        }

        String ret = "";
        ret += Integer.toString(num);
        // If the denominator is 1, return the whole number.
        if(den != 1){
            ret+= "/";
            ret += Integer.toString(den);
        }


        return ret;
    }
}