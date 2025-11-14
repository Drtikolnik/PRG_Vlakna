public class CalculatorProcesor {

    public double calculateResult(double base1, double power1, double base2, double power2){
        double result = 0;

        ItemCalculator itemCalculator1 = new ItemCalculator(base1, power1);
        ItemCalculator itemCalculator2 = new ItemCalculator(base2, power2);

        Thread thread1 = new Thread(itemCalculator1);
        Thread thread2 = new Thread(itemCalculator2);

        thread1.start();
        thread2.start();

        try{
            thread1.join();
            thread2.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }

        return result = itemCalculator1.getResult() +  itemCalculator2.getResult();



    /*
        Thread thread1 = new Thread(()->{
            ItemCalculator c1 = new ItemCalculator(base1, power1);
            c1.calculate();
            num1 = c1.getResult();
        });

        Thread thread2 = new Thread(()->{
            ItemCalculator c2 = new ItemCalculator(base2, power2);
            c2.calculate();
            num2 = c2.getResult();
        });

        thread1.start();
        thread2.start();
        try{
            thread1.join();
            thread2.join();
            result = num1 + num2;
        }catch(InterruptedException e){
            e.printStackTrace();
        }

        return result;
    */
    }
}