public class UglyNum_263 {
    public boolean isUgly(int num) {

        /** most voted solution
         for (int i=2; i<6 && num>0; i++)
         while (num % i == 0)
         num /= i;
         return num == 1;
         */

        if (num <= 0)
            return false;
        if(num == 1)
            return true;
        while(num%5 == 0){
            num = num/5;
        }
        if(num == 1)
            return true;
        while(num%3 == 0){
            num = num/3;
        }
        if(num == 1)
            return true;
        while(num%2 == 0){
            num = num/2;
        }
        if(num == 1)
            return true;
        return false;
    }
}
