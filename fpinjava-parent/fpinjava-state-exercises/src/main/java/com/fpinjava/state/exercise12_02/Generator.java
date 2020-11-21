package com.fpinjava.state.exercise12_02;


import com.fpinjava.common.List;
import com.fpinjava.common.Result;
import com.fpinjava.common.Tuple;

public class Generator {

  public static Tuple<Integer, RNG> integer(RNG rng) {
    return rng.nextInt();
  }

  public static Tuple<Integer, RNG> integer(RNG rng, int limit) {
    Tuple<Integer, RNG> random = rng.nextInt();
    return new Tuple<>(Math.abs(random._1 % limit), random._2);
  }

  public static Tuple<List<Integer>, RNG> integers(RNG rng, int length) {
    List<Integer> range = List.range(0, length);

    List<Tuple<Integer, RNG>> list = range.foldLeft(List.list(), accum -> elem -> {
      RNG randomGenerator = accum.headOption().map(t -> t._2).getOrElse(rng);
      return accum.cons(randomGenerator.nextInt());
    });

    return new Tuple<>(list.map(t -> t._1), list.headOption().map(t -> t._2).getOrElse(rng));
  }
}
