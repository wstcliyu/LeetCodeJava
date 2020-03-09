/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf); 
 */
public class Read_158 extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    // Rewrite good solution
    // Another good solution in C++: https://leetcode.com/problems/read-n-characters-given-read4-ii-call-multiple-times/discuss/188293/Google-follow-up-question.-Speed-up-the-copy.
    private int buf4Size = 0;
    private int buf4Ptr = 0;
    private char[] buf4 = new char[4];
    
    public int read(char[] buf, int n) {
        int size = 0;
        while (size < n) {
            while (size < n && buf4Ptr < buf4Size) {
                buf[size++] = buf4[buf4Ptr++];
            }
            if (buf4Ptr == buf4Size) {
                buf4Ptr = 0;
                buf4Size = read4(buf4);
                if (buf4Size == 0) break;
            }
        }
        return size;
    }
}