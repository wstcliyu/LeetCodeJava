class Binary_1018 {
    // My first solution
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> res = new ArrayList<>();
        int prefix = 0;
        for (int a : A) {
            // prefix = (prefix * 2 + a) % 5;
            prefix = ((prefix << 1) ^ a) % 5;
            res.add(prefix == 0);
        }
        return res;
    }
}