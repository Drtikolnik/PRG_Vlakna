import java.util.InputMismatchException;
import java.util.*;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws InterruptedException {

//1----------

        Thread vlakno11 = new Thread(()->{
            for(int i = 0; i < 1000; i++) {
                System.out.println(i);
            }
        });

        Thread vlakno21 = new Thread(()->{
            for(char i = 'a'; i <= 'z'; i++) {
                System.out.println(i);
            }
        });

        vlakno11.start();
        vlakno21.start();


//2----------

        Thread spiciVlakno = new Thread(()->{

                System.out.println(Thread.currentThread().getName()); ;
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("vlákno " +Thread.currentThread().getName()+ " uběhlo");

        });
        spiciVlakno.setName("Spícivlákno");

        spiciVlakno.start();

        Thread.sleep(1000);

        spiciVlakno.interrupt();


//4----------

        Thread zdravitko = new Thread(()->{
            while(!Thread.currentThread().isInterrupted()) {

                System.out.println("Ahoj");

            }

        });
        zdravitko.setName("Zdravítko");


        Thread stopka = new Thread(()->{
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {}
            System.out.println("STAČILO!");
            zdravitko.interrupt();

        });
        stopka.setName("Stopka");

        zdravitko.start();
        stopka.start();


//5----------

        long[] faktorialy = {15, 89, 75, 6};
        Factorial f = new Factorial();
        for (long faktorial : faktorialy) {
            System.out.println(f.spoctiFactorial(faktorial));
            System.out.println("----------------------------");
        }



//6----------

        long[] faktorials = {15, 89, 75, 6};

        Factorial fa = new Factorial();

        List<Thread> threads = new ArrayList<>();
        for(long faktorial : faktorials){
           threads.add(new Thread(()->{
                System.out.println(fa.spoctiFactorial(faktorial));
                System.out.println("----------------------------");
            }));
        }

        for(Thread t : threads){
            t.start();
            t.join();
        }

        System.out.println("Vlakna doběhla");


//7----------
        int x = 5;
        int y = 10;
        int vysledek = secti(x,y);

    }
    static int secti (int a , int b){
        int soucet = a+b;
        return soucet;
    }



}