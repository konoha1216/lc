public class RopeCoveringMostPoints {
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

    public static void main(String[] args) {
        int[] nums = {1,3,4,7,13,16,17};
        int k = 4;
        System.out.printf(solution1(nums, k)+"");
    }
}
