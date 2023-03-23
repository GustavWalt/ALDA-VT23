// Gustav Walter guwa7932
// Samarbetat med Julius Grönlund jugr8284 på discriminate metoden.

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyALDAQueue<E> implements ALDAQueue<E>{
    private Node<E> head;
    private Node<E> tail;
    private int size;
    private int capacity;
    
    // Constructor.
    public MyALDAQueue(int defaultCapacity) {
        if(defaultCapacity < 1){
            throw new IllegalArgumentException();
        }
        this.capacity = defaultCapacity;
    }
    
    // Node class that is used throughout the class. 
    private static class Node<E>{
        private E data;
        private Node<E> next;

        Node(E data){
            this.data = data;
            next = null;
        }
    }
    
    // Add method to add elements to the queue.
    @Override
    public void add(E element) {
        if(element == null){
            throw new NullPointerException();
        }
        if(isFull()){
            throw new IllegalStateException();
        }

        if (head == null) {
            head = new Node<E>(element);
            tail = head;
        } else {
            tail.next = new Node<E>(element);
            tail = tail.next;
        }
        this.size++;
    }
    
    @Override
    public void addAll(Collection<? extends E> coll) {
        if(coll == null){
            throw new NullPointerException();
        }

        for(E e : coll){
            add(e);
        }
    }
    
    // Remove method to remove elements in queue. 
    @Override
    public E remove() throws NoSuchElementException {
        if(isEmpty()){
            throw new NoSuchElementException("Fel!");
        }

        E elementToRemove = head.data;
        head = head.next;
        size--;
        if(isEmpty()){
            tail = null;
        }

        return elementToRemove;
    }

    @Override
    public E peek() {
        if(head == null){
            return null;
        }
        return head.data;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return totalCapacity() == size();
    }

    @Override
    public int totalCapacity() {
        return this.capacity;
    }

    @Override
    public int currentCapacity() {
        return totalCapacity() - size();
    }
    
    // Discriminate method to move element to the end of the queue.
    @Override
    public int discriminate(E e) {
        if (e == null) {
            throw new NullPointerException("e cannot be null");
        }

        if(size == 0){
            return 0;
        }

        int count = 0;
        MyALDAQueue<E> elementsToMove = new MyALDAQueue<>(size());
        MyALDAQueue<E> elementsToKeep = new MyALDAQueue<>(size());

        for(Node<E> temp=head; temp!=null; temp=temp.next){
            if(temp.data==e || temp.data.equals(e)){
                elementsToMove.add(temp.data);
                count++;
            } else {
                elementsToKeep.add(temp.data);
            }
        }

        clear();
        for(E element : elementsToKeep){
            add(element);
        }

        for(E element : elementsToMove){
            add(element);
        }

        return count;
    }

    // Iterator that is used throughout the class. 
    @Override
    public Iterator<E> iterator() throws NoSuchElementException {
        return new Iterator<>() {
            private Node<E> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                E data = current.data;
                current = current.next;
                return data;
            }
        };
    }
    
    // toString to make correct output.
    public String toString(){
        String output = "[";
        for(Node<E> node = head; node != null; node = node.next){
            output += node.data;
            if(node.next != null){
                output += ", ";
            }
        }
        output += "]";
        return output;
    }
}