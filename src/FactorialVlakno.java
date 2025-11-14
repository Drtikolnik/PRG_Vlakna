import java.math.BigInteger;

public class FactorialVlakno {
    BigInteger factorial = new BigInteger("1");



    public BigInteger spoctiFactorial(long n){
        for(int i=1; i<=n; i++ ){
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }

        return factorial;
    }


    public BigInteger getFactorial(){
        return factorial;
    }

    public void setFactorial(BigInteger factorial){
        this.factorial = factorial;
    }

}
