public class Water_365 {
    // My solution
    public static boolean canMeasureWater(int x, int y, int z) {
        if (z > x + y)
            return false;
        if( x == z || y == z || x + y == z ) return true;
        return helper(x, y, z);
    }
    private static boolean helper(int x, int y, int z) {
        if (x > y)
            return helper(y, x, z);
        if (x == 0)
            return false;
        if (z % x == 0)
            return true;
        return helper(y%x, x, z);
    }
    /* Most voted solution
        Bézout's identity (also called Bézout's lemma) is a theorem in the elementary theory of numbers:

        let a and b be nonzero integers and let d be their greatest common divisor. Then there exist integers x
        and y such that ax+by=d

        In addition, the greatest common divisor d is the smallest positive integer that can be written as ax + by.
        Every integer of the form ax + by is a multiple of the greatest common divisor d.
    */
    /*
    public boolean canMeasureWater(int x, int y, int z) {
        //limit brought by the statement that water is finallly in one or both buckets
        if(x + y < z) return false;
        //case x or y is zero
        if( x == z || y == z || x + y == z ) return true;

        //get GCD, then we can use the property of Bézout's identity
        return z%GCD(x, y) == 0;
    }

    public int GCD(int a, int b) {
        while(b != 0 ){
            int temp = b;
            b = a%b;
            a = temp;
        }
        return a;
    }
    */
    public static void main (String[] args) {
        System.out.println(canMeasureWater(1,2,3));
    }
}
