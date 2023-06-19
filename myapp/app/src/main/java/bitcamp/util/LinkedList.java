package bitcamp.util;

public class LinkedList {

  Node head;
  Node tail;
  int size;

  /* public static void main(String[] args) {
    LinkedList list = new LinkedList();
    list.add(100);
    list.add(200);
    list.add(300);
    list.add(400);
    list.add(500);

    print(list);
    System.out.println(list.retrieve(300));
    list.remove(400);
    print(list);
    list.remove(100);
    print(list);
  }

  static void print(LinkedList list) {
    Object[] arr = list.getList();
    for (Object obj : arr) {
      System.out.print(obj);
      System.out.print(", ");
    }
    System.out.println();
  } */

  public void add(Object value) {

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
  }

  public Object[] getList() {
    Object[] arr = new Object[this.size];

    Node cursor = this.head;
    for (int i = 0; i < this.size; i++) {
      arr[i] = cursor.value;
      cursor = cursor.next;
    }

    return arr;
  }

  public Object retrieve(Object value) {
    Node cursor = this.head;

    while (cursor != null) {
      if (cursor.value.equals(value)) {
        return cursor.value;
      }
      cursor = cursor.next;
    }

    return null;
  }

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
          prev.next = cursor.next; // 다음 노드의 주소를 이전 노드에 저장
        }
        size--;

//     가비지 객체를 초기화시켜서 가비지가 인스턴스를 가리키지 않도록 한다.
        cursor.next = null;
        cursor.value = null;

        return true;
      }
      prev = cursor;
      cursor = cursor.next;
    }

//    while (cursor != null) {
//      if (cursor.value.equals(value)) {
//        cursor.next = cursor.next.next;
//        return true;
//      } else {
//        cursor = cursor.next;
//      }
//    }
    return false;
  }

  static class Node {
    Object value;
    Node next;
  }

}
