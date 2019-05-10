package com.fpinjava.advancedtrees.exercise11_02;


import com.fpinjava.common.Result;

import static com.fpinjava.advancedtrees.exercise11_02.MapEntry.mapEntry;

public class Map<K extends Comparable<K>, V> {

  protected final Tree<MapEntry<K, V>> delegate;

  private Map() {
    this.delegate = Tree.empty();
  }

  private Map(Tree<MapEntry<K, V>> delegate) {
    this.delegate = delegate;
  }

  public Map<K, V> add(K key, V value) {
    return new Map<>(delegate.insert(MapEntry.mapEntry(key, value)));
  }

  public boolean contains(K key) {
    return delegate.member(MapEntry.mapEntry(key));
  }

  public Result<MapEntry<K, V>> get(K key) {
    return delegate.get(mapEntry(key));
  }

  public Map<K, V> remove(K key) {
    return new Map<>(delegate.delete(MapEntry.mapEntry(key)));
  }

  public boolean isEmpty() {
    return delegate.isEmpty();
  }

  public static <K extends Comparable<K>, V> Map<K, V> empty() {
    return new Map<>();
  }
}
