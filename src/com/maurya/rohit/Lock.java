package com.maurya.rohit;

/**
 * Thread 1: rwlock.acquireWrite() - 0
 * Thread 2: rwlock.acquireWrite() --> BLOCKED!  1
 * Thread 3: rwlock.acquireWrite() --> BLOCKED!  2
 * Thread 1: rwlock.releaseWrite() --> THREAD 2 UNBLOCKED
 */
public class Lock {
    // getRead()
    // getWrite();
    // release();

    int readers=0;
    int writers=0;
    final Object object = new Object();


    public void getReadLock() throws InterruptedException {
        synchronized (object) {
            while (writers > 0) {
                wait();
            }
            readers++;
        }
    }

    public void getWriterLock() throws InterruptedException {
//        synchronized (object) {
//            if (writers > 0 || readers > 0) {
//                wait();
//            }
//        }

        synchronized (object) {
            while (writers > 0 || readers > 0) {
                wait();
            }
            writers++;
        }
    }

    public synchronized void releaseReaderLock() throws InterruptedException {
        readers--;
        notifyAll();
    }

    public synchronized void releaseWriterLock() throws InterruptedException {
        writers--;
        notifyAll();
    }


}
