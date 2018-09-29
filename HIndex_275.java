public class HIndex_275 {
    public int hIndex(int[] citations) {
        // Most voted solution
        // The ojective of the loop is to find the critical index i such that (len - i) equals the h-index
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


        // My first solution
        /*
        if (citations == null || citations.length == 0)
            return 0;
        if (citations.length == 1)
            return citations[0] == 0 ? 0 : 1;
        Arrays.sort(citations);
        int len = citations.length;
        int l = -1;
        int r = len - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            int h = len - mid - 1;
            if ((mid < 0 || citations[mid] <= h) && citations[mid + 1] >= h)
                return h;
            if (citations[mid + 1] < h)
                l = mid + 1;
            else if (citations[mid] > h)
                r = mid - 1;
        }
        return len - l - 1;
        */
    }
}
