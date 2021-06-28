package recursion;

import javafx.util.Pair;

public class LinkedListR<E> {


    private class Node {
        public E e;
        public Node next;


        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }


    private Node head;

    private int size;


    public LinkedListR() {
        head = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    boolean isEmpty() {
        return size == 0;
    }

    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("add failed");
        }
        head = add(head, index, e);
        size++;
    }


    public void addFirst( E e) {

        add(0, e);

    }

    private Node add(Node node, int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("add failed");
        }

        if (index == 0) {
            return new Node(e, node);
        }
        node.next = add(node.next, index - 1, e);
        return node;

    }


    public void addLast(E e) {
        add(size, e);
    }

    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("get failed");
        }

        return get(head, index);
    }

    private E get(Node node, int index) {
        if (index == 0) {
            return node.e;
        }
        return get(node.next, index - 1);
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    public void set(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("set failed");
        }

        set(head, index, e);


    }

    private void set(Node node, int index, E e) {

        if (index == 0) {
            node.e = e;
            return;
        }
        set(node.next, index - 1, e);
    }

    private boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }
        if (node.e.equals(e)) {
            return true;
        }
        return contains(node.next, e);
    }

    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("set failed");
        }
        Pair<Node, E> res = remove(head, index);
        size--;
        head = res.getKey();
        return res.getValue();
    }

    private Pair<Node, E> remove(Node node, int index) {

        if (index == 0) {
            return new Pair<>(node.next, node.e);
        }
        Pair<Node, E> res = remove(node.next, index - 1);
        node.next = res.getKey();
        return new Pair<>(node, res.getValue());
    }

    //从链表中删除元素e;

    public void removeElement(E e) {
        head = removeElement(head, e);
    }

    private Node removeElement(Node node, E e) {
        if (node == null) {
            return null;
        }
        node.next = removeElement(node.next, e);
        if (node.e.equals(e)) {
            size--;
            return node.next;
        }
        return node;
    }

    @Override
    public String toString() {
        StringBuilder str =new StringBuilder();

        Node cur =head;
        while (cur!= null){
            str.append(cur +"->");
            cur =cur.next;
        }
        str.append("Null");
        return str.toString();
    }

    public static void main(String[] args) {
        LinkedListR listR =new LinkedListR();

        for (int i=0;i<10;i++){
            listR.addFirst(i);

        }

        for (int i =0;i<listR.size;i++)
            System.out.println(listR.get(i));

        listR.add(3,8);

        listR.removeElement(8);

        System.out.println(listR);
    }

}
