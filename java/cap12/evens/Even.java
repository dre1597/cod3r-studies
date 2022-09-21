package evens;

import java.util.Objects;

public class Even<K, V> {
  private final K key;
  private final V value;

  public Even(K key, V value) {
    super();
    this.key = key;
    this.value = value;
  }

  public K getKey() {
    return key;
  }

  public V getValue() {
    return value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Even<?, ?> even = (Even<?, ?>) o;

    if (!Objects.equals(key, even.key)) return false;
    return Objects.equals(value, even.value);
  }

  @Override
  public int hashCode() {
    int result = key != null ? key.hashCode() : 0;
    result = 31 * result + (value != null ? value.hashCode() : 0);
    return result;
  }
}
