package com.fpinjava.state.exercise12_09;


import com.fpinjava.common.Function;
import com.fpinjava.common.List;
import com.fpinjava.common.Tuple;

public class State<S, A> {

  public final Function<S, Tuple<A, S>> run;

  public State(Function<S, Tuple<A, S>> run) {
    super();
    this.run = run;
  }

  public static <S, A> State<S, A> unit(A a) {
    return new State<>(s -> new Tuple<>(a, s));
  }

  public <B> State<S, B> map(Function<A, B> f) {
    return flatMap(a -> unit(f.apply(a)));
  }

  public <B, C> State<S, C> map2(State<S, B> sb, Function<A, Function<B, C>> f) {
    return flatMap(a -> sb.map(b -> f.apply(a).apply(b)));
  }

  public <B> State<S, B> flatMap(Function<A, State<S, B>> f) {
    return new State<>(s -> {
      Tuple<A, S> result = run.apply(s);
      return f.apply(result._1).run.apply(result._2);
    });
  }

  public static <S, A> State<S, List<A>> sequence(List<State<S, A>> fs) {
    return fs.foldRight(unit(List.list()), f -> acc -> f.map2(acc, x -> y -> y.cons(x)));
  }

}
