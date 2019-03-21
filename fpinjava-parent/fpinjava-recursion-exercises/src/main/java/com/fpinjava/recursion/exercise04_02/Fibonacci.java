package com.fpinjava.recursion.exercise04_02;

import java.math.BigInteger;

import com.fpinjava.recursion.listing04_03.TailCall;
import static com.fpinjava.recursion.listing04_03.TailCall.ret;
import static com.fpinjava.recursion.listing04_03.TailCall.sus;


public class Fibonacci {

  public static BigInteger fib(int x) {
    return fib_(BigInteger.valueOf(x), BigInteger.ZERO, BigInteger.ONE).eval();
  }

  private static TailCall<BigInteger> fib_(BigInteger x, BigInteger accum1, BigInteger accum2) {
    if (x.equals(BigInteger.ZERO)) {
      return ret(accum1);
    }

    return sus(() -> fib_(x.subtract(BigInteger.ONE), accum2, accum1.add(accum2)));
  }
}
