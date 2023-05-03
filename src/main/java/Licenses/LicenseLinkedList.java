package Licenses;

import Interfaces.IPrintInfo;

import java.util.Objects;
import java.util.logging.Logger;

public class LicenseLinkedList<T> implements IPrintInfo {
    Logger log = Logger.getLogger(LicenseLinkedList.class.getName());
    private Node head;

    class Node {
        private T value;
        private Node next;

        public Node(T value) {
            this.value = value;
            this.next = null;
        }
    }


    public void add(T element) {
        Node node = new Node(element);
        if (this.head == null) {
            this.head = node;
        } else {
            Node iterator = this.head;
            while (iterator.next != null) {
                iterator = iterator.next;
            }
            iterator.next = node;
        }
    }

    @Override
    public void printInfo() {
        Node iterator = head;
        while (iterator != null) {
            log.info(iterator.value + " ");
            iterator = iterator.next;
        }
    }
}
