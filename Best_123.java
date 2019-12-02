public class Best_123 {
    public static int maxProfit(int[] prices) {
        // p1 = max(-x)
        // p2 = max(-x+y)
        // p3 = max(-x+y-z)
        // p4 = max(-x+y-z+w)
        int p1 = Integer.MIN_VALUE, p3 = Integer.MIN_VALUE;
        int p2 = 0, p4 = 0;
        for (int i:prices) {
            p1 = Math.max(p1, -i);
            p2 = Math.max(p2, p1+i);
            p3 = Math.max(p3, p2-i);
            p4 = Math.max(p4, p3+i);
        }
        return p4;
    }



    // Print optimal strategy
    /*
    public int maxProfit(int[] prices) {
        int p1 = Integer.MIN_VALUE;
        int p2 = 0;
        int p3 = Integer.MIN_VALUE;
        int p4 = 0;
        Tuple t1 = new Tuple();
        Tuple t2 = new Tuple();
        Tuple t3 = new Tuple();
        Tuple t4 = new Tuple();
        for (int i = 0; i < prices.length; i++) {
            int p = prices[i];
            
            if (-p > p1) {
                p1 = -p;
                t1 = new Tuple(i);
            }
            if (p1 + p > p2) {
                p2 = p1 + p;
                t2 = new Tuple(t1.a, i);
            }
            if (p2 - p > p3) {
                p3 = p2 - p;
                t3 = new Tuple(t2.a, t2.b, i);
            }
            if (p3 + p > p4) {
                p4 = p3 + p;
                t4 = new Tuple(t3.a, t3.b, t3.c, i);
            }
        }
        System.out.println("buy on: " + t4.a);
        System.out.println("sell on: " + t4.b);
        System.out.println("buy on: " + t4.c);
        System.out.println("sell on: " + t4.d);
        return p4;
    }
    
    class Tuple {
        int a, b, c, d;
        Tuple() {
            a = b = c = d = -1;
        }
        Tuple(int a) {
            this.a = a;
        }
        Tuple(int a, int b) {
            this.a = a;
            this.b = b;
        }
        Tuple(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
        Tuple(int a, int b, int c, int d) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
        }
    }
    */



    public static void main (String args[]) {
        int[] testPrices = {1,4,2,1};
        System.out.println(maxProfit(testPrices));
    }
}
