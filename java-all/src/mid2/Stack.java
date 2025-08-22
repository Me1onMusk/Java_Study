package mid2;

import java.util.EmptyStackException;

public class Stack<E> {

    private Node<E> top;
    private int size;

    private static class Node<E> {
        E item;
        Node<E> next;

        public Node(E newItem, Node<E> node) {
            this.item = newItem;
            this.next = node;
        }
    }

    // 생성자 //
    public Stack() {
        top = null;
        size = 0;
    }

    // 넣기 //
    public void push(E item) {
        Node<E> newNode = new Node<>(item, top);
        top = newNode;
        size++;
    }

    // 꺼내기 //
    public E pop() {
        if(isEmpty())
            throw new EmptyStackException();
        Node<E> removedNode = top;  // 지워지는 노드를 백업
        top = top.next;
        removedNode.next = null;
        if(size == 1)
            top = null;
        size--;
        return removedNode.item;
    }

    //
    public E peek() {
        if(isEmpty())
            throw new EmptyStackException();
        return top.item;
    }

    // 사이즈 //
    public int size() {
        return size;
    }

    // 비었는지 확인 //
    public boolean isEmpty() {
        return size == 0;
    }

}
