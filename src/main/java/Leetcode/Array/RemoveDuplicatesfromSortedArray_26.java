package Leetcode.Array;

public class RemoveDuplicatesfromSortedArray_26 {
    public int removeDuplicates(int[] nums) {
        if (nums.length<2)
            return nums.length;
        int count=1;
        for (int i=0; i<nums.length-1; i++){
            if (nums[i+1]!=nums[i])
                nums[count++] = nums[i+1];
        }
        return count;
    }

    public static void main(String[] args){
        RemoveDuplicatesfromSortedArray_26 obj = new RemoveDuplicatesfromSortedArray_26();
        System.out.println(obj.removeDuplicates(new int[]{1,1,2}));
    }
}
