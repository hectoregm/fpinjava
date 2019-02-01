package com.fpinjava.makingjavafunctional.exercise03_14;

import com.fpinjava.makingjavafunctional.exercise03_13.CollectionUtilities;

import java.util.List;


public class Range {

  public static List<Integer> range(Integer start, Integer end) {
    if (start >= end) {
      return CollectionUtilities.list();
    }
    return CollectionUtilities.prepend(start, range(start + 1, end));
  }
}
