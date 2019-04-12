class Bus_815 {
    // My solution by rewriting standard solution with bidirectional BFS
    // Very fast (17ms, faster than 99.00%)
    // Let N be the number of buses, and number of stops
    // Time: O(N^2 lgN), Space: O(N^2)
    /*
    public int numBusesToDestination(int[][] routes, int S, int T) {
        if (S == T) return 0;
        int N = routes.length;
        boolean[] usedNode = new boolean[N];

        List<List<Integer>> graph = new ArrayList<>();

        Set<Integer> beginSet = new HashSet<>();
        Set<Integer> endSet = new HashSet<>();

        // O(N^2 lgN)
        for (int i = 0; i < N; i++) {
            // O(N lgN)
            Arrays.sort(routes[i]);

            // O(lgN)
            if (Arrays.binarySearch(routes[i], S) >= 0) { 
                beginSet.add(i);
                usedNode[i] = true;
            }

            // O(lgN)
            if (Arrays.binarySearch(routes[i], T) >= 0) {
                endSet.add(i);
                if (usedNode[i]) return 1;
                usedNode[i] = true;
            }

            // O(N)
            graph.add(new ArrayList<>());
            for (int j = 0; j < i; j++) {
                if (intersect(routes[i], routes[j])) {
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }

        // O(N^2)
        int step = 2;
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<Integer> set = beginSet;
                beginSet = endSet;
                endSet = set;
            }

            Set<Integer> nextLevel = new HashSet<>();
            for (int begin : beginSet) {
                for (int r : graph.get(begin)) {
                    if (endSet.contains(r)) 
                        return step;
                    if (!usedNode[r]) {
                        usedNode[r] = true;
                        nextLevel.add(r);
                    }
                }
            } 

            beginSet = nextLevel;
            step++;
        }

        return -1;
    }

    private boolean intersect(int[] A, int[] B) {
        int i = 0, j = 0;
        while (i < A.length && j < B.length) {
            if (A[i] == B[j]) return true;
            if (A[i] < B[j]) i++; else j++;
        }
        return false;
    }
    */




    // Rewrite most voted solution
    public int numBusesToDestination(int[][] routes, int S, int T) {
        if (S == T) return 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < routes.length; i++) 
            for (int j = 0; j < routes[i].length; j++) 
                map.computeIfAbsent(routes[i][j], z -> new ArrayList<>()).add(i);

        // Bidirectional version
        /*
        Set<Integer> beginSet = new HashSet<>();
        beginSet.add(S);
        Set<Integer> endSet = new HashSet<>();
        endSet.add(T);
        boolean[] usedRoute = new boolean[routes.length];
        
        int step = 0;
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            step++;
            if (beginSet.size() > endSet.size()) {
                Set<Integer> set = beginSet;
                beginSet = endSet;
                endSet = set;
            }
            
            Set<Integer> nextLevel = new HashSet<>();
            for (int begin : beginSet) {
                for (int busIdx : map.getOrDefault(begin, new ArrayList<>())) {
                    if (usedRoute[busIdx]) continue;
                    usedRoute[busIdx] = true;
                    for (int stop : routes[busIdx]) {
                        if (endSet.contains(stop)) return step;
                        nextLevel.add(stop);
                    }
                }
            }
            
            beginSet = nextLevel;
        }

        return -1;
        */
        
        Deque<Integer> q = new ArrayDeque<>();
        q.add(S);
        boolean[] usedRoute = new boolean[routes.length];
        
        int step = 0;
        while (!q.isEmpty()) {
            step++;
            int size = q.size();
            for (int k = 0; k < size; k++) {
                int cur = q.removeFirst();
                for (int busIdx : map.getOrDefault(cur, new ArrayList<>())) {
                    if (usedRoute[busIdx]) continue;
                    usedRoute[busIdx] = true;
                    for (int stop : routes[busIdx]) {
                        if (stop == T) return step;
                        q.add(stop);
                    }
                }
            }
        }
        
        return -1;
    }




    // My first solution using BFS
    // I use bus stop instead of route, so this solution is very slow (1399 ms)
    /*
    public int numBusesToDestination(int[][] routes, int S, int T) {
        Set<Integer> beginSet = new HashSet<>();
        beginSet.add(S);
        Set<Integer> endSet = new HashSet<>();
        endSet.add(T);
        
        int N = routes.length;
        boolean[] usedRoute = new boolean[N];
        
        int step = 0;
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<Integer> set = beginSet;
                beginSet = endSet;
                endSet = set;
            }
            
            Set<Integer> nextLevel = new HashSet<>();
            for (int begin : beginSet) {
                if (endSet.contains(begin)) 
                    return step;
                for (int i = 0; i < N; i++) {
                    if (usedRoute[i]) continue;
                    boolean addAllToNext = false;
                    for (int stop : routes[i]) {
                        if (begin == stop) {
                            usedRoute[i] = true;
                            addAllToNext = true;
                            break;
                        }
                    }
                    if (addAllToNext) for (int stop : routes[i]) nextLevel.add(stop);
                }
            }
            
            beginSet = nextLevel;
            step++;
        }
        
        return -1;
    }
    */
}