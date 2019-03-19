public class HIndex_275 {
    public int hIndex(int[] citations) {
        // My updated solution
        /*
        public int hIndex(int[] citations) {
            int N = citations.length;
            int l = 1, r = N + 1;
            while (l < r) {
                int h = (l + r) / 2;
                if (citations[N - h] < h)
                    r = h;
                else
                    l = h + 1;
            }
            return r - 1;
        }
        */



        // Most voted solution
        // The ojective of the loop is to find the critical index i such that (len - i) equals the h-index
        /*
        int left = 0, len = citations.length, right = len - 1,  mid;
        while(left <= right) {
            mid = (left + right) >> 1;
            if(citations[mid] == (len - mid))
                return citations[mid];
            else if(citations[mid] > (len - mid))
                right = mid - 1; // Actually mid may be the critical index, in this case the last loop will execute left = mid + 1
            else
                left = mid + 1;
        }
        // Since at last round of the loop, it must be left = right.
        // Thus, after last round, if the program doesn't return,
        // it must be right + 1 = left. And citations[right + 1] = citations[left] > len - left
        return len - (right + 1); // Or return len - left;
        */


        // My solution
        
        int len = citations.length;
        int l = 0, r = len;
        while (l < r) {
            int mid = (l + r) / 2;
            int h = len - mid;
            if ((mid == 0 || citations[mid - 1] <= h) && citations[mid] >= h)
                return h;
            if (citations[mid] < h)
                l = mid + 1;
            else if (citations[mid - 1] > h)
                r = mid;
        }
        // Or return len - l; because l == r
        return len - r;        
    }
}
