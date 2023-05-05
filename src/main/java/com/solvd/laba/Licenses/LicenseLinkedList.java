package com.solvd.laba.Licenses;

import com.solvd.laba.Interfaces.IPrintInfo;

import java.util.*;


public class LicenseLinkedList<T> implements List<T>, IPrintInfo {
    private Node head;
    private int size;

    private class Node {
        T data;
        Node next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public boolean contains(Object obj) {
        Node curr = head;

        while (curr.next != null) {
            if (curr.data.equals(obj))
                return true;
        }

        return false;
    }

    @Override
    public boolean add(T obj) {
        Node newNode = new Node(obj);

        if (head == null) {
            head = newNode;
        } else {
            Node curr = head;
            while (curr.next != null)
                curr = curr.next;
            curr.next = newNode;
        }
        size++;

        return true;
    }

    @Override
    public boolean remove(Object obj) {
        Node prev = head;
        Node curr = head;
        boolean removed = false;

        if (head.equals(obj)) {
            head = head.next;
            removed = true;
        }

        while (!removed && curr.next != null) {
            if (curr.equals(obj)) {
                curr = curr.next;
                prev.next = curr;
                removed = true;
            }
            prev = curr;
            curr = curr.next;
        }

        if (!removed && curr.equals(obj)) {
            prev.next = null;
            removed = true;
        }

        if (removed)
            size--;

        return removed;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        Node curr = head;

        while (curr != null) {
            if (!contains(curr))
                return false;
            curr = curr.next;
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        throw new UnsupportedOperationException("don't use it here");
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        boolean modified = false;
        for (Object e : c)
            if (add((T) e))
                modified = true;
        return modified;
    }


    @Override
    public boolean removeAll(Collection<?> c) {
        for (Object obj : c)
            if (contains(obj))
                return remove(obj);
        return false;
    }

    @Override
    public void clear() {
        size = 0;
        head = null;
    }

    @Override
    public T get(int index) {
        Node curr = head;

        if (index < 0 || index > size)
            return null;

        while (index-- != 0)
            curr = curr.next;
        return curr.data;
    }

    @Override
    public T set(int index, T element) {
        Node curr = head;

        if (index < 0 || index > size)
            return null;

        while (index-- != 0)
            curr = curr.next;

        T temp = curr.data;
        curr.data = element;
        size++;

        return temp;
    }

    @Override
    public void add(int index, T element) {
        Node prev = head;
        Node curr = head;
        Node newNode = new Node(element);

        if (index < 0 || index > size)
            System.out.println("Invalid index.");
        else {
            while (index-- != 0) {
                prev = curr;
                curr = curr.next;
            }

            prev.next = newNode;
            newNode.next = curr;
        }
        size++;
    }

    @Override
    public T remove(int index) {
        Node prev = head;
        Node curr = head;

        if (index < 0 || index > size)
            return null;

        while (index-- != 0) {
            prev = curr;
            curr = curr.next;
        }

        T temp = curr.data;
        curr = curr.next;
        prev.next = curr;
        size--;

        return temp;
    }

    @Override
    public int indexOf(Object obj) {
        int index = 0;
        Node curr = head;

        while (curr != null) {
            if (curr.data.equals(obj))
                return index;
            index++;
            curr = curr.next;
        }

        return -1;
    }

    @Override
    public int lastIndexOf(Object obj) {
        int index = 0;
        int lastIndex = -1;
        Node curr = head;

        while (curr != null) {
            if (curr.data.equals(obj))
                lastIndex = index;
            index++;
            curr = curr.next;
        }

        return lastIndex;
    }

    @Override
    public void printInfo() {
        Node curr = head;
        int i = 0;

        if (curr == null)
            System.out.println("EMPTY LIST");

        while (curr != null) {
            System.out.println("[" + ++i + "] " + curr.data);
            curr = curr.next;
        }
    }

    @Override
    public String toString() {
        return "LicenseLinkedList{" +
                "head=" + head +
                ", size=" + size +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LicenseLinkedList<?> that = (LicenseLinkedList<?>) o;
        return size == that.size && Objects.equals(head, that.head);
    }

    @Override
    public int hashCode() {
        return Objects.hash(head, size);
    }

    @Override
    public Object[] toArray() {
        Object[] arr = new Object[size];
        Node curr = head;

        for (int i = 0; i < size; i++) {
            arr[i] = curr.data;
            curr = curr.next;
        }

        return arr;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("don't use it here");
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        throw new UnsupportedOperationException("don't use it here");
    }

    @Override
    public ListIterator<T> listIterator() {
        throw new UnsupportedOperationException("don't use it here");
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        throw new UnsupportedOperationException("don't use it here");
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException("don't use it here");
    }

    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException("don't use it here");
    }
}