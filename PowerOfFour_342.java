public class PowerOfFour_342 {
    public boolean isPowerOfFour(int num) {
        // return num > 0 && (num&(num-1)) == 0 && (num & 0x55555555) != 0;
        // 0x55555555 is 1010101010101010101010101010101 in binary with a length of 32
        return (num>0) && (num&(num-1))==0 && num%3==1;
    }
}
