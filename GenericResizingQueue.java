/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adts;

import java.util.Iterator;

/**
 *
 * @author diego.gutierrezf
 */
public class GenericResizingQueue<Item> implements Iterable<Item> {
    //Attributes
    private Item a[];
    private int counter;

    //Constructor
    public GenericResizingQueue() {
        a = (Item[]) new Object[1];
        counter = 0;
    }

    //Functional Methods
    //Resize
    private void resize(int capacity) {
        Item temp[] = (Item[]) new Object[capacity];
        for (int i = 0; i < counter; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }

    //Add
    public void push(Item data) {
        if (counter == a.length) {
            resize(2 * a.length);
        }
        a[counter++] = data;
    }

    //Delete
    public Item pop() {
        Item temp = a[--counter];
        a[counter] = null;
        if (counter > 0 && counter == a.length / 4) {
            resize(a.length / 2);
        }
        return temp;
    }

    //Check if stack is empty
    public boolean isEmpty() {
        return counter == 0;
    }

    //Return size of array
    public int size() {
        return counter;
    }

    public Item peek() {
        return a[counter - 1];
    }

    @Override
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item> {

        private int i;
        
        public ReverseArrayIterator(){
            i = counter-1;
        }

        @Override
        public boolean hasNext() {
            return i >= 0;
        }

        @Override
        public Item next() {
            return a[--i];
        }
    }
}
