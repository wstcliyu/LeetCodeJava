class Flatten_251 {
    // My first solution
    private int r, c;
    private int[][] v;

    public Vector2D(int[][] v) {
        r = 0;
        c = 0;
        this.v = v;
    }
    
    public int next() {
        while (r < v.length && c == v[r].length) {
            r++;
            c = 0;
        }
        return v[r][c++];
    }
    
    public boolean hasNext() {
        while (r < v.length && c == v[r].length) {
            r++;
            c = 0;
        }
        return r < v.length;
    }



    // Most voted solution from StefanPochmann
    /*
    private Iterator<List<Integer>> i;
    private Iterator<Integer> j;

    public Vector2D(List<List<Integer>> vec2d) {
        i = vec2d.iterator();
    }

    public int next() {
        hasNext();
        return j.next();
    }

    public boolean hasNext() {
        while ((j == null || !j.hasNext()) && i.hasNext())
            j = i.next().iterator();
        return j != null && j.hasNext();
    }
    */
}