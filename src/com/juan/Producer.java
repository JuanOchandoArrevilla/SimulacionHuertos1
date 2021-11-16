package com.juan;

public class Producer extends Thread {
    private Garden garden;
    private int accountVegetal;
    private int time;
    private final String[] vegetables = {"Lettuce","Cabbage","Onion","Spinach","Potato","Celery","Asparagus",
            "Radish","Broccoli","Artichoke","Tomato","Cucumber","Eggplant","Carrot","Green bean"};

    public Producer(Garden garden, int accountVegetal, int time) {
        this.garden = garden;
        this.accountVegetal = accountVegetal;
        this.time = time;
    }

    @Override
    public void run() {
        String sowing;


        for (int i = 0; i < accountVegetal; i++) {
            sowing = RandomVegetal();
            try {
                garden.sow(sowing);
                System.out.println("sembrando " + sowing);
                sleep((int) (Math.random() * time));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public String RandomVegetal() {
        return (String) vegetables[(int) (Math.random() * vegetables.length)];
    }
}
