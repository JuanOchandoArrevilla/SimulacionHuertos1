package com.juan;

public class Garden {

    private String[] vegetables = null;
    private int account = 0;
    boolean full = false;
    boolean empty = true;

    public Garden(int amount) {
        this.vegetables = new String[amount];
    }

    public synchronized void sow(String vegetal) throws InterruptedException {
        while(full) {
            wait();
        }

        vegetables[account] = vegetal;
        account += 1;

        empty = false;
        full = account >= vegetables.length;
        notifyAll();
    }

    public synchronized String buy() throws InterruptedException {
        while(empty) {
            wait();
        }
        String buying = vegetables[--account];
        full = false;
        empty = account <=0;
        notifyAll();
        return buying;
    }



}
