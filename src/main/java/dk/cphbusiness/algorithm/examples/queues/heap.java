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
public class heap implements PriorityQueue<Passenger> {

    private Passenger[] data;
    private int size = 0;

    //nodes parrent = place /2
    private int parentOf(int p) {
        return p / 2;
    }

    public heap(int capacity) {
        this.data = new Passenger[capacity];
    }

    private int leftOf(int p) {
        return p * 2;
    }

    private int rightOf(int p) {
        return p * 2 + 1;
    }

    @Override
    public void enqueue(Passenger item) {
        int p = ++size;
        data[p] = item;
        while (true) {
            int pp = parentOf(p);
            if (pp == 0 || data[p].compareTo(data[pp]) > 0) {
                return;
            }
            data[0] = data[pp];
            data[pp] = data[p];
            data[p] = data[0];
            p = pp;
        }
    }

    @Override
    public Passenger dequeue() {
        if (size == 0) {
            throw new NoSuchElementException();
        }

        Passenger result = data[1];
        sort(1);
        size--;
        return result;
    }

    private void sort(int i) {
        if (rightOf(i) > size) {
            return;
        } else if (data[leftOf(i)].compareTo(data[rightOf(i)]) < 0) {
            swap(i, leftOf(i));
            sort(leftOf(i));
        } else {
            swap(i,rightOf(i));
            sort(rightOf(i));
        }
    }

    private void swap(int i, int leftOf) {
        data[0] = data[i];
        data[leftOf] = data[i];
        data[i] = data[0];
    }

    @Override
    public Passenger peek() {
        if (size == 0) {
            throw new NoSuchElementException();
        }

        Passenger result = data[1];
        return result;
    }

    @Override
    public int size() {
        return size;
    }

}
