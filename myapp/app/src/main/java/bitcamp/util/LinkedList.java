package bitcamp.util;

public class LinkedList implements List {

  Node head;
  Node tail;
  int size;

  @Override
  public boolean add(Object value) {

    // 1. 새 노드를 생성한다.
    // 2. 노드의 value에 값을 세팅한다.
    // 3. 다음 노드와 연결한다.
    Node node = new Node();
    node.value = value;

    if (head == null) {
      head = node;
    } else if (this.tail != null) {
      this.tail.next = node;
    }

    this.tail = node;
    this.size++;
    return true;
  }

  @Override
  public Object[] toArray() {
    Object[] arr = new Object[this.size];

    Node cursor = this.head;
    for (int i = 0; i < this.size; i++) {
      arr[i] = cursor.value;
      cursor = cursor.next;
    }

    return arr;
  }

  @Override
  public Object get(int index) {
    if (!isValid(index)) {
      return null;
    }

    Node cursor = this.head;

    for (int i = 0; i < index; i++) {
      cursor = cursor.next;
    }

    return cursor.value;
  }

  @Override
  public Object remove(int index) {
    if (!isValid(index)) {
      return null;
    }
    // 삭제하려는 값이 있는 노드까지 이동
    Node cursor = this.head;
    for (int i = 0; i < index; i++) {
      cursor = cursor.next;
    }

    Node prev = null;
    cursor = this.head;

    for (int i = 0; i < index; i++) {
      prev = cursor; // 다음 노드로 이동하기 전에 현재 커서가 가리키는 노드를 prev에 보관
      cursor = cursor.next;
    }

    // 삭제할 값을 리턴할 수 있도록 보관한다.
    Object obj = cursor.value;

    if (prev == null) {
      // 삭제할 노드가 시작 노드라면
      head = cursor.next;

      // 삭제할 노드가 시작이자 끝 노드라면
      if (head == null) {
        tail = null;
      }

    } else if (cursor.next == null) {
      // 삭제할 노드가 끝 노드라면
      tail = prev;
      tail.next = null;
    } else {
      prev.next = cursor.next; // 현재 커서의 다음 노드를 현재 커서의 이전 노드와 연결한다.
    }
    size--;

    cursor.next = null;
    cursor.value = null;

    return obj;
  }

  @Override
  public boolean remove(Object value) {
    Node prev = null;
    Node cursor = this.head;

    while (cursor != null) {
      if (cursor.value.equals(value)) {

        if (prev == null) {
          // 삭제할 노드가 시작 노드라면
          head = cursor.next;

          // 삭제할 노드가 시작이자 끝 노드라면
          if (head == null) {
            tail = null;
          }

        } else if (cursor.next == null) {
          // 삭제할 노드가 끝 노드라면
          tail = prev;
          tail.next = null;
        } else {
          prev.next = cursor.next;
        }
        size--;

        cursor.next = null;
        cursor.value = null;

        return true;
      }
      prev = cursor;
      cursor = cursor.next;
    }
    return false;
  }

  @Override
  public int size() {
    return this.size;
  }

  private boolean isValid(int index) {
    return index >= 0 && index < this.size;
  }

  static class Node {
    Object value;
    Node next;
  }

}
