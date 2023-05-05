package Licenses;

import Interfaces.IPrintInfo;

import java.util.Iterator;
import java.util.logging.Logger;

public class LicenseLinkedList<T> implements IPrintInfo, Iterable {
    Logger log = Logger.getLogger(LicenseLinkedList.class.getName());
    private Link<T> head;
    private Link<T> tail;
    private int size;

    public int getSize() {
        return size;
    }

    public LicenseLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void addAtEnd(T data) {
        Link<T> newNode = new Link<T>(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.previous = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public void addAtStart(T data) {
        Link<T> newNode = new Link<T>(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.previous = newNode;
            head = newNode;

        }
        size++;
    }

    @Override
    public void printInfo() {
        Link<T> traversalNode = head;
        if (head == null) {
            log.info("Empty Linked List");
        } else {
            while (traversalNode != null) {
                System.out.print(traversalNode.data + "->");
                traversalNode = traversalNode.next;
            }
        }
    }

    public T remove(int index) {
        int i = 1;
        Link<T> traversalNode = head;
        while (i < index) {
            traversalNode = traversalNode.next;
            i++;
        }

        if (traversalNode.next == null) {
            removefromEnd();
        } else if (traversalNode.previous == null) {
            removeFromStart();
        } else {
            traversalNode.previous.next = traversalNode.next;
            traversalNode.next.previous = traversalNode.previous;
            traversalNode.next = null;
            traversalNode.previous = null;

        }
        return traversalNode.data;
    }

    public T removefromEnd() {
        Link<T> nodeToRemove = tail;
        tail = nodeToRemove.previous;
        tail.next = null;
        size--;

        return nodeToRemove.data;
    }

    public T removeFromStart() {
        Link<T> nodeToRemove = head;
        head = nodeToRemove.next;
        head.previous = null;
        size--;

        return nodeToRemove.data;
    }

    public T get(int index) {
        Link<T> returnedNode = head;
        int i = 1;
        while (i < index) {
            returnedNode = returnedNode.next;
            i++;
        }
        return returnedNode.data;
    }

    private class Link<T> {
        private T data;
        private Link<T> next = null;
        private Link<T> previous = null;

        public Link(T data) {
            this.data = data;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int position = 1;

            @Override
            public boolean hasNext() {
                if (position <= getSize()) {
                    return true;
                }
                return false;
            }

            @Override
            public T next() {
                T data = get(position);
                position++;
                return data;
            }

            @Override
            public void remove() {
                LicenseLinkedList.this.remove(position);
            }

        };

    }
}
