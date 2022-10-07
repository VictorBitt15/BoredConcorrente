package br.ufrn.imd.interface_;

import br.ufrn.imd.service.ConsumerBoredThread;
import br.ufrn.imd.util.NumberThreads;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Menu implements IMenu{
    public NumberThreads numberThreads;

    public Menu(){
        System.out.println("Client iniciado");
        this.numberThreads = new NumberThreads();
        new MenuOptions().start();
    }
    private class MenuOptions extends Thread{

        public void run() {
            Scanner sc = new Scanner(System.in);
            while(true){
                String operacao;
                operacao= CreateMenu();
                switch(operacao){
                    case "0":
                    case "":
                        System.exit(0);
                }
                int qtdThread = numberThreads.getQTD_THREADS().get(Integer.parseInt(operacao));
                ExecutorService executor = Executors.newFixedThreadPool(qtdThread);

                long temp_inicial = System.nanoTime();
                for(int x = 0; x<qtdThread; x++){
                    Thread consumerBoredThread = new ConsumerBoredThread(x);
                    executor.execute(consumerBoredThread);
                    if(x==qtdThread-1){
                        executor.shutdownNow();
                        long temp_final = System.nanoTime();
                        double result = (temp_final-temp_inicial)/1000000;
                        System.out.println("\nTempo percorrido total: "+result+"ms");
                    }
                }
            }
        }
    }
    @Override
    public String CreateMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("---------------");
        System.out.println("Digite a quantidade de requisições desejada:");
        System.out.println("1 - 10 Requisições");
        System.out.println("2 - 100 Requisições");
        System.out.println("3 - 300 Requisições");
        System.out.println("4 - 500 Requisições");
        System.out.println("5 - 800 Requisições");
        System.out.println("6 - 1000 Requisições");
        System.out.println("7 - 1500 Requisições");
        System.out.println("0 - Sair");
        System.out.println("---------------");
        System.out.print("Operação: ");
        String operacao = sc.nextLine();
        return operacao;
    }
}
