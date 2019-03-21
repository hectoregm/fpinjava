package com.fpinjava.recursion.exercise04_09;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import com.fpinjava.common.Function;
import com.fpinjava.recursion.listing04_03.TailCall;
import static com.fpinjava.recursion.listing04_03.TailCall.*;
import static com.fpinjava.common.CollectionUtilities.*;


public class Memoization {

  public static String fibo(int number) {
    return makeString(fibo_(BigInteger.valueOf(number), BigInteger.ONE, BigInteger.ZERO, list(BigInteger.ZERO)).eval(), ", ");
  }

  private static TailCall<List<BigInteger>> fibo_(BigInteger number, BigInteger accum1, BigInteger accum2, List<BigInteger> accum) {
    if (number.equals(BigInteger.ZERO)) {
      return ret(accum);
    }

    return sus(() -> fibo_(number.subtract(BigInteger.ONE), accum2, accum1.add(accum2), append(accum,accum1.add(accum2))));
  }

  public static <T> String makeString(List<T> list, String separator) {
    return foldLeft(list, "", a -> b -> a.isEmpty() ? b.toString() : a + separator + b.toString());
  }
}
