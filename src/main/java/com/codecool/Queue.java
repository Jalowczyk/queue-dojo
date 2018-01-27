package com.codecool;

import java.util.NoSuchElementException;

public class Queue {

    private Node head;
    private Node tail;
    private int size = 0;

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public String peek() {
        if (isEmpty()) throw new NoSuchElementException("Error: queue underflow!");
        return head.getValue();
    }

    public void enqueue(String element) {

        Node oldTail = this.tail;
        this.tail = new Node(element);

        if (isEmpty()) {
            head = tail;
        }
        else {
            oldTail.setNextNode(tail);
        }
        size++;
    }

    public void dequeue() {

        if (isEmpty()) throw new NoSuchElementException("Error: queue underflow!");

        this.head = this.head.getNextNode();
        size--;
    }

    private class Node {
        private String value;
        private Node nextNode;

        public Node(String value){
            this.value = value;
        }

        public String getValue(){
            return this.value;
        }

        public Node getNextNode(){
            return this.nextNode;
        }

        public void setNextNode(Node node) {
            this.nextNode = node;
        }
    }
}
