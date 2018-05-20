public class Convert_405 {
    public static String toHex(int num) {
        /* Most voted solution
        if(num == 0)
            return "0";
        char[] map = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        String result = "";
        while(num != 0){
            result = map[(num & 15)] + result;
            num = (num >>> 4);
        }
        return result;
        */
        StringBuilder res = new StringBuilder();
        int risidual = 0;
        for (int i=0; i<8; i++) {
            risidual = (num>>>(4*i)) & 15;
            if (risidual < 10)
                res.append(risidual);
            else {
                res.append((char)(risidual-10+'a'));
            }
        }
        if (res.charAt(7) == '0') {
            int i = 7;
            while(i>0) {
                if (res.charAt(i) != '0')
                    break;
                res.deleteCharAt(i--);
            }
        }
        return res.reverse().toString();
    }
    public static void main (String args[]) {
        int testNum = 0;
        System.out.println(toHex(testNum));
    }
}
