/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf);
 */
public class Read_157 extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        int size = 0;
        int x = 4;
        while (size < n && x == 4) {
            char[] buf4 = new char[4];
            x = read4(buf4);
            for (int i = 0; i < x && size < n; i++) {
                buf[size++] = buf4[i];
            }
        }
        return size;
    }
}