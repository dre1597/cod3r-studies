package evens;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

public class Evens<K extends Number, V> {

  private final Set<Even<K, V>> items =  new LinkedHashSet<>();

  public void add(K key, V value) {
    if(key == null) {
      return;
    }

    Even<K,V> newEven = new Even<>(key, value);

    items.remove(newEven);

    items.add(newEven);
  }

  public V getValue(K key) {
    if(key == null) {
      return null;
    }

    Optional<Even<K,V>> optionalEven = items.stream().filter(even -> key.equals(even.getKey())).findFirst();

    return optionalEven.map(Even::getValue).orElse(null);
  }
}
