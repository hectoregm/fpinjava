package com.fpinjava.makingjavafunctional.exercise03_05;

import com.fpinjava.common.Function;

import java.util.List;

public class Fold {

  public static Integer fold(List<Integer> is, Integer identity,
                             Function<Integer, Function<Integer, Integer>> f) {
    Integer accum = identity;
    for (Integer ivalue : is) {
      accum = f.apply(accum).apply(ivalue);
    };

    return accum;
  }
}
