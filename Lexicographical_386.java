class LexicalOrder_386 {
    // https://leetcode.com/problems/lexicographical-numbers/discuss/86231/Simple-Java-DFS-Solution
    // Second voted solution using DFS
    // If we look at the order we can find out we just keep adding digit from 0 to 9 to every digit and make it a tree.
    // Then we visit every node in pre-order.
    //    1         2        3    ...
    //    /\        /\       /\
    // 10 ...19  20...29  30...39   ....
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>(n);
        for (int i = 1; i <= 9; i++) 
            dfs(i, n, res);
        return res;
    }
    
    private void dfs(int curr, int n, List<Integer> res) {
        if (curr > n) return;
        res.add(curr);
        curr *= 10;
        for (int i = 0; i <= 9 && curr + i <= n; i++)
            dfs(curr + i, n, res);
    }




    // https://leetcode.com/problems/lexicographical-numbers/discuss/86242/Java-O(n)-time-O(1)-space-iterative-solution-130ms
    // Most voted solution
    // The basic idea is to find the next number to add.
    // Take 45 for example: if the current number is 45, the next one will be 450 (450 == 45 * 10)(if 450 <= n), or 46 (46 == 45 + 1) (if 46 <= n) or 5 (5 == 45 / 10 + 1)(5 is less than 45 so it is for sure less than n).
    // We should also consider n = 600, and the current number = 499, the next number is 5 because there are all "9"s after "4" in "499" so we should divide 499 by 10 until the last digit is not "9".
    // It is like a tree, and we are easy to get a sibling, a left most child and the parent of any node.
    /*
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>(n);
        int curr = 1;
        for (int i = 1; i <= n; i++) {
            res.add(curr);
            if (curr * 10 <= n) {
                curr *= 10;
            } else if (curr % 10 != 9 && curr + 1 <= n) {
                curr++;
            } else {
                while ((curr / 10) % 10 == 9) {
                    curr /= 10;
                }
                curr = curr / 10 + 1;
            }
        }
        return res;
    }
    */

}