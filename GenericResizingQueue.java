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
    private Item stck[], quue[];
    private int counterStck,counterQuue,head;

    //Constructor
    public GenericResizingQueue() {
       stck = (Item[]) new Object[1];
       quue = (Item[]) new Object[1];
        counterStck = 0;
        counterQuue=0;
        head=0;
    }

    //Functional Methods
    //Resize
    private void resize(int capacity,Item []arr,int counter) {
        Item temp[] = (Item[]) new Object[capacity];
        for (int i = 0; i < counter; i++) {
            temp[i] = arr[i];
        }
        arr = temp;
    }

    //Add into Stack
    public void push(Item data) {
        if (counterStck == stck.length) {
            resize(2 * stck.length, stck,counterStck);
        }
        stck[counterStck++] = data;
    }

    //Add into Queue
    public void enqueue (Item data){
        if (counterQuue == quue.length){
            resize(2*quue.length,quue,counterQuue);
        }
        quue[counterQuue++]=data;
    }
    
    //Delete into Stack
    public Item pop() {
        Item temp = stck[--counterStck];
        stck[counterStck] = null;
        if (counterStck > 0 && counterStck == stck.length / 4) {
            resize(stck.length / 2,stck,counterStck);
        }
        return temp;
    }
    //Delete into Queue
    public Item dequeue(){
        Item temp = quue[head];
        quue[head++]=null;
        if(counterQuue>0 && counterQuue == quue.length /4){
            resize(stck.length / 2,stck,counterStck);
        }
        return temp;
    }

    //Check if stack is empty
    public boolean isEmpty() {
        return counterStck == 0;
    }

    //Return size of array
    public int size() {
        return counterStck;
    }

    public Item peek() {
        return stck[counterStck - 1];
    }

    @Override
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

   private class ReverseArrayIterator implements Iterator<Item> {

        private int i;
        
        public ReverseArrayIterator(){
            i = counterStck-1;
        }

        @Override
        public boolean hasNext() {
            return i >= 0;
        }

        @Override
        public Item next() {
            return stck[--i];
        }
    }
}

