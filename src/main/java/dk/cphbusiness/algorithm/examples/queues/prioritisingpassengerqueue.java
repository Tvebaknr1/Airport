/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.cphbusiness.algorithm.examples.queues;

import dk.cphbusiness.airport.template.Passenger;
import java.util.NoSuchElementException;

/**
 *
 * @author Emil
 */
public class prioritisingpassengerqueue implements PriorityQueue<Passenger>{
    //heapmap 
    private Passenger[] Items;
    private int tail = 0;
    private int pointer = 0;
    
    public prioritisingpassengerqueue(int capacity) {
      //items = (T[])new Object[capacity];
      Items = new Passenger[capacity];
      }

    @Override
    public void enqueue(Passenger item) {

        if (pointer >= Items.length && Items[0] == null) {
            pointer = 0;
            this.enqueue(item);
        } else if (pointer == tail) {
            //the world is ending
        }
        else{
            Items[pointer] = item;
            pointer++;
        }
    }

    @Override
    public Passenger dequeue() throws NoSuchElementException {
        Passenger temp = Items[tail];
        Items[tail] = null;
        if(tail == Items.length)
            tail = 0;
        else tail++;
        return temp;
    }

    @Override
    public Passenger peek() throws NoSuchElementException {
        return Items[tail];
    }

    @Override
    public int size() {
        int res = 0;
        for (int i = 0; i < Items.length; i++) {
            if(Items[i] !=null)
                res++;
        }
        return res;
    }
    
}
