public class LeastSteps {
    /**
     * 一个由G或B组成的字符串，
     * 左右两个字符两两交换位置
     * 把所有的G都移到最左边或最右边，需要较少的步骤是多少
     * @param str
     * @return
     */
    public static int solution(String str) {
        if (str == null || str.equals("")) {
            return 0;
        }
        int left1 = 0;
        int res1 = 0;
        for (int index = 0; index < str.length(); index++) {
            if (str.charAt(index) == 'G') {
                res1 += index - left1;
                left1 ++;
            }
        }
        int left2 = 0;
        int res2 = 0;
        for (int index2 = 0; index2 < str.length(); index2++) {
            if (str.charAt(index2) == 'B') {
                res2 += index2 - left2;
                left2 ++;
            }
        }
        System.out.println("G to left:" + res1);
        System.out.println("B to left:" + res2);
        return Math.min(res1, res2);
    }

    public static void main(String[] args) {
        String str = "BBGBGGBG";
        System.out.println(solution(str));
    }
}
