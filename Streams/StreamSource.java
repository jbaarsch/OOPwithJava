package Streams;

import java.math.BigInteger;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class StreamSource {

    public static Stream<BigInteger> getCountingNumbers() {
        return Stream.iterate(BigInteger.ONE, n -> n.add(BigInteger.ONE));
    }

    public static Stream<BigInteger> getPrimeNumbers() {
        return Stream.iterate(BigInteger.TWO, StreamSource::nextPrime);
    }

    public static Stream<BigInteger> getFibonacciNumbers() {
        BigInteger lastValue = BigInteger.ONE;
        return Stream.iterate(new FibonacciPair(BigInteger.ZERO, BigInteger.ONE), new UnaryOperator<FibonacciPair>() {
            @Override
            public FibonacciPair apply(FibonacciPair n) {

                FibonacciPair nextPair = new FibonacciPair(n.getN2(),
                        n.getN1().add(n.getN2()));
                return nextPair;
            }
        }).map(n -> n.getN2());
    }







    private static BigInteger nextPrime(BigInteger num) {
        do {
            num = num.add(BigInteger.ONE);
        } while (num.isProbablePrime(1));
        return num;
    }

}
