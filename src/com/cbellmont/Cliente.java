package com.cbellmont;

public class Cliente extends Thread {


    @Override
    public void run() {
        try {
            while (true) {
                synchronized (Main.list) {
                    if (Main.list.isEmpty()){
                        System.out.println("Cliente - Voy a esperar a que me traigan comida...");
                        Main.list.notify();
                        Main.list.wait();
                    } else {
                        System.out.println("Cliente - Voy a consumir un " + Main.list.get(0) + " 3 segundos");
                        Main.list.remove(0);
                        sleep(3000);
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
