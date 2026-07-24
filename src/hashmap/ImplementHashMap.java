package hashmap;

import java.util.Scanner;

class MyHashMap<K, V> {

    private static final int DEFAULT_CAPACITY = 5;
    private static final double DEFAULT_LOAD_FACTOR = 0.75;

    private Node<K, V>[] buckets;
    private int size;

    static class Node<K, V> {
        K key;
        V value;
        Node<K, V> next;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    @SuppressWarnings("unchecked")
    public MyHashMap() {
        buckets = new Node[DEFAULT_CAPACITY];
        size = 0;
    }

    private int hash(K key) {
        return Math.abs(key.hashCode()) % buckets.length;
    }

    public void put(K key, V value) {
        int index = hash(key);

        Node<K, V> head = buckets[index];

        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }

        Node<K, V> newNode = new Node<>(key, value);
        newNode.next = buckets[index];
        buckets[index] = newNode;
        size++;

        if ((double) size / buckets.length > DEFAULT_LOAD_FACTOR) {
            rehash();
        }
    }

    public V get(K key) {
        int index = hash(key);

        Node<K, V> current = buckets[index];

        while (current != null) {
            if (current.key.equals(key))
                return current.value;

            current = current.next;
        }

        return null;
    }

    public boolean containsKey(K key) {
        return get(key) != null;
    }

    public V remove(K key) {

        int index = hash(key);

        Node<K, V> current = buckets[index];
        Node<K, V> prev = null;

        while (current != null) {

            if (current.key.equals(key)) {

                if (prev == null)
                    buckets[index] = current.next;
                else
                    prev.next = current.next;

                size--;
                return current.value;
            }

            prev = current;
            current = current.next;
        }

        return null;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @SuppressWarnings("unchecked")
    private void rehash() {

        Node<K, V>[] oldBuckets = buckets;

        buckets = new Node[oldBuckets.length * 2];
        size = 0;

        for (Node<K, V> node : oldBuckets) {

            while (node != null) {
                put(node.key, node.value);
                node = node.next;
            }
        }
    }

    public void display() {

        for (int i = 0; i < buckets.length; i++) {

            System.out.print(i + " -> ");

            Node<K, V> current = buckets[i];

            while (current != null) {
                System.out.print("(" + current.key + "," + current.value + ") -> ");
                current = current.next;
            }

            System.out.println("null");
        }
    }
}

public class ImplementHashMap{
    public static void main(String...args){


    }
}