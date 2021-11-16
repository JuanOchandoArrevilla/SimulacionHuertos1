package com.juan;

public class Customer extends Thread{

    private Garden garden;
    private int product;
    private int time;

    public Customer(Garden garden, int product, int time) {
        this.garden = garden;
        this.product = product;
        this.time = time;
    }

    @Override
    public void run() {

        String buying;

        for (int i = 0; i < product; i++) {

            try {
                buying = garden.buy();
                System.out.println("el cliente " + i + " ha comprado " + buying);
                sleep((int) (Math.random() * time));

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
