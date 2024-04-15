package Streams;

import java.math.BigInteger;

public class FibonacciPair {

    private BigInteger n1;
    private BigInteger n2;

    public FibonacciPair(BigInteger n1, BigInteger n2){
        this.n1 = n1;
        this.n2 = n2;
    }

    public BigInteger getN1() {
        return n1;
    }

    public void setN1(BigInteger n1) {
        this.n1 = n1;
    }

    public BigInteger getN2() {
        return n2;
    }

    public void setN2(BigInteger n2) {
        this.n2 = n2;
    }
}
