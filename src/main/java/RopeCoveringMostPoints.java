public class RopeCoveringMostPoints {

    /**
     * 左右两个指针分别从最左开始向右移，
     * 如果右指针值-左指针值>k，则左指针向右移一位，否则右指针一直向右移
     * 注意左右指针的越界问题
     * 理想和平均情况下是O(N) 最坏时O(2N)
     * @param nums
     * @param k
     * @return
     */
    public static int solution1(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int length = nums.length;
        int result = 0;
        while(left < length) {
            while(right < length && (nums[right] - nums[left]) <= k) {
                right ++;
            }
            result = Math.max(result, right-left);
            left ++;
        }
        return result;
    }

    /**
     * 小贪心，从左到右，
     * 每次都去找当前index左边里在绳子范围内的最远点
     * 找这个点用二分的方式，每次花费logn，整体是O(nlogn)
     * @param nums
     * @param k
     * @return
     */
    public static int solution2(int[] nums, int k) {
        int res = 1;
        for (int i = 0; i < nums.length; i++) {
            res = Math.max(res, i - nearestIndex(nums, i, nums[i]-k) + 1);
        }
        return res;
    }

    public static int nearestIndex(int[] nums, int right, int value) {
        int left = 0;
        int index = right;
        while (left <= right) {
            int mid = left + (right-left)/2;
            if (nums[mid] >= value) {
                index = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,4,7,13,16,17};
        int k = 4;
        System.out.println(solution1(nums, k));
        System.out.println(solution2(nums, k));
    }
}
