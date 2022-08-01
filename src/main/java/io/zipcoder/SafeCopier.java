package io.zipcoder;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Make this extend the Copier like `UnsafeCopier`, except use locks to make sure that the actual intro gets printed
 * correctly every time.  Make the run method thread safe.
 */
public class SafeCopier extends Copier{
    public SafeCopier(String toCopy) {
        super(toCopy);
    }

    public void run() {
        ReentrantLock lock = new ReentrantLock();
        int count = 0;

        lock.lock();
        try{
        while(stringIterator.hasNext()){
            System.out.print(stringIterator.next() + " ");
            count++;
            }
        }finally {
            lock.unlock();
            }
    }
}
