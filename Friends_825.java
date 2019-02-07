public class Friends_825 {
    // Standard solution: Frequency array
    public int numFriendRequests(int[] ages) {
        int[] count = new int[121];
        for (int age: ages) count[age]++;

        int ans = 0;
        for (int ageA = 0; ageA <= 120; ageA++) {
            int countA = count[ageA];
            for (int ageB = 0; ageB <= ageA; ageB++) {
                int countB = count[ageB];
                if (ageA * 0.5 + 7 >= ageB) continue;
                if (ageA == ageB) ans -= countA;
                ans += countA * countB;
            }
        }

        return ans;
    }


    // Most voted solution
    /*
    public int numFriendRequests(int[] ages) {
        int res = 0;
        int[] numInAge = new int[121], sumInAge = new int[121];

        for(int i : ages) numInAge[i] ++;

        for(int i = 1; i <= 120; ++i) sumInAge[i] = numInAge[i] + sumInAge[i - 1];

        for(int i = 15; i <= 120; ++i) {
            if(numInAge[i] == 0) continue;
            int count = sumInAge[i] - sumInAge[i / 2 + 7];
            res += count * numInAge[i] - numInAge[i]; //people will not friend request themselves, so  - numInAge[i]
        }
        return res;
    }
    */
}
