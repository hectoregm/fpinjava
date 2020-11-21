package com.fpinjava.state.exercise12_01;


import com.fpinjava.common.Tuple;

public class Generator {

  public static Tuple<Integer, RNG> integer(RNG rng) {
    return rng.nextInt();
  }

  public static Tuple<Integer, RNG> integer(RNG rng, int limit) {
    Tuple<Integer, RNG> result = rng.nextInt();

    return new Tuple<>(Math.abs(result._1 % limit), result._2);
  }
}
