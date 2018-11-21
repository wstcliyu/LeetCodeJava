import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Reorder_937 {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (log1, log2) -> {
            int i1 = log1.indexOf(' ') + 1;
            int i2 = log2.indexOf(' ') + 1;
            if (Character.isDigit(log1.charAt(i1)) && Character.isDigit(log2.charAt(i2)))
                return 0;
            else if (Character.isLetter(log1.charAt(i1)) && Character.isLetter(log2.charAt(i2))) {
                int r = log1.substring(i1).compareTo(log2.substring(i2));
                return r != 0 ? r : log1.substring(0, i1 - 1).compareTo(log2.substring(0, i2 - 1));
            }
            else if (Character.isLetter(log1.charAt(i1)))
                return -1;
            else
                return 1;
        });
        return logs;
    }
    /*
    // My first solution
    public String[] reorderLogFiles(String[] logs) {
        int N = logs.length;
        String[] res = new String[N];
        ArrayList<String[]> charLogs = new ArrayList<>();
        ArrayList<String> digitLogs = new ArrayList<>();
        for (String log : logs) {
            int idx = log.indexOf(" ");
            if (Character.isDigit(log.charAt(idx + 1)))
                digitLogs.add(log);
            else if(Character.isLetter(log.charAt(idx + 1))) {
                String[] tmp = new String[2];
                tmp[0] = log.substring(0, idx);
                tmp[1] = log.substring(idx + 1);
                charLogs.add(tmp);
            }
        }


        charLogs.sort(new Comparator<String[]>() {
            @Override
            public int compare(String[] cL1, String[] cL2) {
                if (cL1[1].equals(cL2[1]))
                    return cL1[0].compareTo(cL2[0]);
                else
                    return cL1[1].compareTo(cL2[1]);
            }
        });


        charLogs.sort((cL1, cL2) -> {
            if (cL1[1].equals(cL2[1]))
                return cL1[0].compareTo(cL2[0]);
            else
                return cL1[1].compareTo(cL2[1]);
        });

        int i = 0;
        for (String[] cL : charLogs)
            res[i++] = cL[0] + " " + cL[1];
        for (String dL : digitLogs)
            res[i++] = dL;
        return res;
    }
    */
}
