package com.fpinjava.advancedtrees.exercise11_04;


import com.fpinjava.common.List;
import com.fpinjava.common.Result;
import com.fpinjava.common.Tuple;

import static com.fpinjava.advancedtrees.exercise11_04.MapEntry.mapEntry;


public class Map<K, V> {

  protected final Tree<MapEntry<Integer, List<Tuple<K, V>>>> delegate;

  private Map() {
    this.delegate = Tree.empty();
  }

  public Map(Tree<MapEntry<Integer, List<Tuple<K, V>>>> delegate) {
    this.delegate = delegate;
  }

  public Map<K, V> add(K key, V value) {
    Tuple<K, V> tuple = new Tuple<>(key, value);
    List<Tuple<K, V>> listKV = getAll(key).map(list -> list.foldLeft(List.list(tuple), l -> t -> t._1.equals(key) ? l : l.cons(t))).getOrElse(() -> List.list(tuple));

    return new Map<>(delegate.insert(mapEntry(key.hashCode(), listKV)));
  }

  public boolean contains(K key) {
    return getAll(key).map(list -> list.exists(t -> t._1.equals(key))).getOrElse(false);
  }

  public Map<K, V> remove(K key) {
    List<Tuple<K, V>> listKV = getAll(key).map(list -> list.foldLeft(List.<Tuple<K, V>>list(), l -> t -> t._1.equals(key) ? l : l.cons(t))).getOrElse(List::list);

    return listKV.isEmpty() ? new Map<>(delegate.delete(mapEntry(key.hashCode())))
            : new Map<>(delegate.insert(mapEntry(key.hashCode(), listKV)));
  }

  public Result<Tuple<K, V>> get(K key) {
    return getAll(key).flatMap(list -> list.first(tuple -> tuple._1.equals(key)));
  }

  private Result<List<Tuple<K, V>>> getAll(K key) {
    return delegate.get(mapEntry(key.hashCode())).flatMap(x -> x.value.map(list -> list.map(t -> t)));
  }

  public boolean isEmpty() {
    return delegate.isEmpty();
  }

  public static <K, V> Map<K, V> empty() {
    return new Map<>();
  }

  @Override
  public String toString() {
    return String.format("Map[%s]", this.delegate);
  }
}
