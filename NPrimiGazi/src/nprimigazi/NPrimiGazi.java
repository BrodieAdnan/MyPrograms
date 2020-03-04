package nprimigazi;
/**
 * @param output primo milione di numeri primi
 * @author Adnan Gazi Latif
 * @Date 21/12/2016
 */

public class NPrimiGazi {
    public static void main(String[] args) {
        int cont=1;
        int n = 3;
        while (cont < 1E6) {
            if (controllo(n))cont++;
            n+=2;
            System.out.println(n-2);
        }
        
    }
    public static boolean controllo(int num){
        int div=3;
        int rad=(int) Math.sqrt(num);
        while(div <= rad){
            if(num%div==0) return false;
            div+=2;
        }
        return true;
    } 
}
