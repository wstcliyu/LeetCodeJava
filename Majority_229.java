import java.util.*;

class Majority_229 {
    // https://leetcode.com/problems/majority-element-ii/discuss/63520/Boyer-Moore-Majority-Vote-algorithm-and-my-elaboration
    // https://gregable.com/2013/10/majority-vote-algorithm-find-majority.html
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums.length == 0) return res;
        int candidateA = 0, candidateB = 0, countA = 0, countB = 0;
        for (int num : nums) {
            if (num == candidateA) countA++;
            else if (num == candidateB) countB++;
            else if (countA == 0) {
                candidateA = num;
                countA = 1;
            } else if (countB == 0) {
                candidateB = num;
                countB = 1;
            } else {
                countA--;
                countB--;
            }
        }
        countA = 0;
        countB = 0;

        for (int num : nums) {
            if (num == candidateA) countA++;
            else if (num == candidateB) countB++;
        }
        
        if (countA > nums.length/3) res.add(candidateA);
        if (countB > nums.length/3) res.add(candidateB);
        return res;
    }
}