public class String_984 {
    public String strWithout3a3b(int A, int B) {
        StringBuilder res = new StringBuilder();
        if (B > A) strWithout3a3b(B, A, 'b', 'a', res);
        else strWithout3a3b(A, B, 'a', 'b', res);
        return res.toString();
    }

    private void strWithout3a3b(int A, int B, char a, char b, StringBuilder sb) {
        while (A-- > 0) {
            sb.append(a);
            if (A > B) {sb.append(a); A--;}
            if (B-- > 0) sb.append(b);
        }
    }
}
