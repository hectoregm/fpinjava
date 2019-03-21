package com.fpinjava.optionaldata.exercise06_07;


import com.fpinjava.common.Function;
import com.fpinjava.common.List;
import com.fpinjava.common.TailCall;
import com.fpinjava.optionaldata.exercise06_06.Option;

import static com.fpinjava.common.TailCall.*;

public class Variance {

  static Function<List<Double>, Double> sum = list -> list.foldLeft(0.0, x -> y -> x + y);

  static Function<List<Double>, Option<Double>> mean = list -> list.isEmpty() ? Option.none() : Option.some(sum.apply(list) / list.length());

  static Function<List<Double>, Option<Double>> variance = list -> mean.apply(list).flatMap(m -> mean.apply(list.map(elem -> Math.pow(elem - m, 2))));

}

