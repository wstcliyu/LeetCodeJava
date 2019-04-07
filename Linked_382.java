class Linked_382 {
    // https://leetcode.com/problems/linked-list-random-node/discuss/85659/Brief-explanation-for-Reservoir-Sampling
    // Brief Explanation for Reservoir Sampling
    // Similar with Random_398
    ListNode head;
    java.util.Random rand;

    public Solution(ListNode head) {
        this.head = head;
        rand = new java.util.Random();
    }
    
    public int getRandom() {
        int res = -1;
        int count = 0;
        ListNode p = head;
        while (p != null) {
            if (rand.nextInt(++count) == 0) res = p.val;
            p = p.next;
        }
        return res;
    }
}
