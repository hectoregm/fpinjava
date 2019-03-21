package com.fpinjava.recursion.exercise04_01;

import java.math.BigInteger;

public class Fibonacci {
  
  public static BigInteger fib(int x) {
    return fib_(BigInteger.valueOf(x), BigInteger.ZERO, BigInteger.ONE);
  }

  private static BigInteger fib_(BigInteger x, BigInteger accum1, BigInteger accum2) {
    if (x.equals(BigInteger.ZERO)) {
      return accum1;
    }

    return fib_(x.subtract(BigInteger.ONE), accum2, accum1.add(accum2));
  }
}
