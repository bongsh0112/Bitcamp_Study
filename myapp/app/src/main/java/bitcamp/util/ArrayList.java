package bitcamp.util;

public class ArrayList implements List {
  private static final int DEFAULT_SIZE = 10;

  private Object[] list = new Object[DEFAULT_SIZE];
  private int size;

  @Override
  public boolean add(Object obj) {
    if (this.size == list.length) {
      increase();
    }
    this.list[this.size++] = obj;
    return true;
  }

  private void increase() {
    Object[] arr = new Object[list.length + (list.length >> 1)];
    for (int i = 0; i < list.length; i++) {
      arr[i] = list[i];
    }
    list = arr;
    //System.out.println("배열 확장: " + list.length);
  }

  @Override
  public Object[] toArray() {
    Object[] arr = new Object[this.size];
    for (int i = 0; i < this.size; i++) {
      arr[i] = this.list[i];
    }
    return arr;
  }

  @Override
  public Object get(int index) {
    if (!isValid(index)) {
      return null;
    }
    return this.list[index];
  }

  @Override
  public boolean remove(Object obj) {
    int deletedIndex = indexOf(obj);
    if (deletedIndex == -1) {
      return false;
    }

    for (int i = deletedIndex; i < this.size - 1; i++) {
      this.list[i] = this.list[i + 1];
    }
    this.list[--this.size] = null;
    return true;
  }

  @Override
  public int size() {
    return this.size;
  }

  @Override
  public Object remove(int index) {
    if (!isValid(index)) {
      return null;
    }
    Object obj = this.list[index];

    for (int i = index; i < this.size - 1; i++) {
      this.list[i] = this.list[i + 1];
    }
    this.list[--this.size] = null;
    return obj;
  }

  private int indexOf(Object obj) {
    for (int i = 0; i < this.size; i++) {
      Object item = this.list[i];
      if (item.equals(obj)) {
        return i;
      }
    }
    return -1;
  }

  private boolean isValid(int index) {
    return index >= 0 && index < this.size;
  }
}
