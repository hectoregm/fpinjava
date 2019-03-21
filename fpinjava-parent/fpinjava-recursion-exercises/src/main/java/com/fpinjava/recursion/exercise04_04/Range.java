package com.fpinjava.recursion.exercise04_04;

import java.util.List;

import com.fpinjava.recursion.listing04_03.TailCall;
import static com.fpinjava.recursion.listing04_03.TailCall.*;
import static com.fpinjava.common.CollectionUtilities.*;

public class Range {

  public static List<Integer> range(Integer start, Integer end) {
    return range_(start, end, list()).eval();
  }

  private static TailCall<List<Integer>> range_(Integer start, Integer end, List<Integer> accum) {
    return start >= end ? ret(accum) : sus(() -> range_(start + 1, end, append(accum, start)));
  }
}
