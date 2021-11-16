package com.juan;

public class Main {

    public static void main(String[] args) {
        Garden huerto = new Garden(5);
        Producer productor = new Producer(huerto, 5,1000);
        Customer cliente = new Customer(huerto, 2,3000);
        Customer cliente1 = new Customer(huerto, 2,2000);
        Customer cliente2 = new Customer(huerto, 1,6000);

        productor.start();
        cliente.start();
        cliente1.start();
        cliente2.start();
        



    }
}
