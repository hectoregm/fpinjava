package com.fpinjava.functions.exercise02_03;


public class FunctionExamples {

  public static final Function<Integer, Function<Integer, Integer>> add = leftArg -> rightArg -> leftArg + rightArg;

  public static final BinaryOperator add2 =  leftArg -> rightArg -> leftArg + rightArg;

  public static final BinaryOperator mult =  leftArg -> rightArg -> leftArg * rightArg;
}
