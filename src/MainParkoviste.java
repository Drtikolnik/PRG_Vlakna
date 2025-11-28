import java.util.InputMismatchException;
import java.util.*;
import java.util.Scanner;

public class MainParkoviste {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws InterruptedException {

        Parkoviste p = new Parkoviste();


        Thread t1 = new Thread(()->{
            p.vjezd((int)((Math.random() * (5-1)) +1));
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){
                System.out.println(e);
            }
        });


        Thread t2 = new Thread(()->{
            p.vyjezd((int)((Math.random() * (5-1)) +1));
            try{
                Thread.sleep(2000);
            }catch(InterruptedException e){
                System.out.println(e);
            }
        });


        Thread t3 = new Thread(()->{
                System.out.println("Kolik aut má vjet na parkoviště?");
                int kolik = sc.nextInt();
                sc.nextLine();
                p.vjezd(kolik);

                System.out.println("Kolik aut má vyjet z parkoviště?");
                int kolik2 = sc.nextInt();
                sc.nextLine();
                p.vjezd(kolik2);

                p.vyjezd((int)((Math.random() * (5-1)) +1));
                try {
                    Thread.sleep(1);
                }catch(InterruptedException e){
                    System.out.println(e);
                }


        });

        try{
            t1.join();
            t2.join();
            t3.join();
        }catch(InterruptedException e){
            System.out.println(e);
        }


        t1.start();
        t2.start();
        t3.start();

        t1.setUncaughtExceptionHandler((t, e) ->
                System.out.println("Kriticka chyba ve vlakne " + t.getName() + " error: " + e.getMessage())
        );

        t2.setUncaughtExceptionHandler((t, e) ->
                System.out.println("Kriticka chyba ve vlakne " + t.getName() + " error: " + e.getMessage())
        );

        t3.setUncaughtExceptionHandler((t, e) ->
                System.out.println("Kriticka chyba ve vlakne " + t.getName() + " error: " + e.getMessage())
        );

























    }
}
