public class Fraction {

    private int numerator;
    private int denominator;


    public Fraction(int n, int d){

        if(d == 0){
            throw new IllegalArgumentException("denominator can not be zero");
        }

        else if((n<0 && d<0) || (n>0 && d<0)){
            this.numerator = -1 * n;
            this.denominator = -1 * d;
        }

        else{
            this.numerator = n;
            this.denominator = d;
        }
    }

    public Fraction(int n){
        this(n, 1);
    }

    public Fraction(){
        this(0, 1);
    }

    public int getNumerator(){
        return this.numerator;
    };
    public int getDenominator(){
        return this.denominator;
    };
    public String toString(){
        String strFraction = this.numerator + "/" + this.denominator;
        return strFraction;
    };
    public double toDouble(){
        double results = this.numerator/this.denominator;
        return results;
    };
    public Fraction add(Fraction fr){
        int newNu = fr.numerator*this.denominator + this.numerator*fr.denominator;
        int newDe = this.denominator * fr.denominator;
        Fraction addedFr = new Fraction(newNu, newDe);
        return addedFr;
    };
    public Fraction subtract(Fraction fr){
        int newNu = fr.numerator*this.denominator - this.numerator*fr.denominator;
        int newDe = this.multiply(fr).denominator;
        Fraction subtractedFr = new Fraction(newNu, newDe);
        return subtractedFr;
    };
    public Fraction multiply(Fraction fr){
        int newNu = this.numerator * fr.numerator;
        int newDe = this.denominator * fr.denominator;
        Fraction multipliedFr = new Fraction(newNu, newDe);
        return multipliedFr;
    };
    public Fraction divide(Fraction fr){
        int newNu = this.numerator * fr.denominator;
        int newDe = this.denominator * fr.numerator;
        Fraction dividedFr = new Fraction(newNu, newDe);
        return dividedFr;
    };
    //public boolean equals(){};
    public int gcd(int nu, int de){
        while(nu!=0 && de!=0){
            int remainder = nu%de;
            nu = de;
            de = remainder;
        }
        return nu;
    };
    public void toLowestTerms() {
        int gcd = this.gcd(this.numerator, this.denominator);
        this.numerator = this.numerator / gcd;
        this.denominator = this.denominator / gcd;
    };




}