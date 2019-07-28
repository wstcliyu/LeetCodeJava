class Output_544 {
    // Standard solution #1: Simulation
    // Time: O(N lgN), Space: O(N lgN)
    public String findContestMatch(int n) {
        String[] team = new String[n];
        for (int i = 0; i < n; i++) {
            team[i] = String.valueOf(i + 1);
        }
        
        for (; n > 1; n /= 2) {
            for (int i = 0; i < n/2; i++) {
                team[i] = "(" + team[i] + "," + team[n - 1 - i] + ")";
            }
        }
        
        return team[0];
    }



    // Standard solution #2: Linear write
    // https://leetcode.com/problems/output-contest-matches/solution/
    // Time: O(N), Space: O(N)
    // Require some math in number theory
    /*
    int[] team;
    int t;
    StringBuilder ans;

    public String findContestMatch(int n) {
        team = new int[n];
        t = 0;
        ans = new StringBuilder();
        write(n, Integer.numberOfTrailingZeros(n));
        return ans.toString();
    }

    // For N = 16
    // team = [1, 16, 8, 9, 4, 13, 5, 12, 2, 15, 7, 10, 3, 14, 6, 11]
    // indices that are 0 and 1 (mod 2) sum to 17. Also, indices 0 and 2 (mod 4) sum to 9, indices 0 and 4 (mod 8) sum to 5
    // w = Integer.lowestOneBit(t) = 2**r, 2w = 2**(r+1)
    // t % 2w = w, (t-w) % 2w = 0
    // team[t] + team[t - w] = 2**(lgN - r) + 1 = n/w + 1
    public void write(int n, int round) {
        if (round == 0) {
            int w = Integer.lowestOneBit(t);
            team[t] = w > 0 ? n / w + 1 - team[t - w] : 1;
            ans.append("" + team[t++]);
        } else {
            ans.append("(");
            write(n, round - 1);
            ans.append(",");
            write(n, round - 1);
            ans.append(")");
        }
    }
    */
}