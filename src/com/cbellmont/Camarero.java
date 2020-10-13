package com.cbellmont;

public class Camarero extends Thread {

    @Override
    public void run() {
        try {
            while (true) {
                synchronized (Main.list){
                    Main.list.wait();
                    System.out.println("Camarero - Si he llegado aqui es porque el cliente ha pedido comida. Debo llevarla");
                    Main.list.add("Zumo");
                    Main.list.add("Tostada");
                    Main.list.add("Mermelada");
                    System.out.println("Camarero - El pedido ya esta listo. Tardo 5 segundos en llevarle la comida al cliente");
                    sleep(5000);
                    Main.list.notify();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

