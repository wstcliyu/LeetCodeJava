public class Repeated_686 {
    // Standard Solution Approach 1
    // Time Complexity: O(N∗(N+M)), where M, N are the lengths of strings A, B.
    // We create two strings A * q, A * (q+1) which have length at most O(M+N).
    // When checking whether B is a substring of A, this check takes naively the product of their lengths.
    // Space complexity: As justified above, we created strings that used O(M+N) space.
    public int repeatedStringMatch(String A, String B) {
        int q = 1;
        StringBuilder sb = new StringBuilder(A);
        for (; sb.length() < B.length(); q++)
            sb.append(A);
        if (sb.toString().contains(B))
            return q;
        if (sb.append(A).toString().contains(B))
            return q + 1;
        return -1;
    }

    // The following is wrong. Corner Case: A = "aa", B = "a", output = 1.
    // But the following will output 0
    /*
    public int repeatedStringMatch(String A, String B) {
        int n = B.length() / A.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n; i++)
            sb.append(A);
        for (int i = 0; i < 3; i++)
            if (sb.append(A).toString().contains(B))
                return n + i;
        return -1;
    }
    */
}
