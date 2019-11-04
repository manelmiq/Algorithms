package cs435.assignment2;

public class MergeSort {

    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length -1 );
        return nums;
    }

    void mergeSort(int[] nums, int l, int r){
        if(l < r){
            int m = l +  (r - l)/ 2;
            mergeSort(nums, l, m);
            mergeSort(nums, m + 1, r);
            merge(nums, l, m, r);
        }
    }
    void merge(int[] nums, int l, int m ,int r ){
        // Do I really need to create secondary arrays? I don't think so
        int s1 = m - l;
        int s2 = r - m + 1;
        System.out.println(s1 + " s2 -> "+ s2 );
        int[] L = new int[s1];
        int[] R = new int[s2];
        for(int i = 0; i < s1; i++){
            L[i] = nums[l + i];
        }
        for(int i = 0; i < s2; i++){
            R[i] = nums[m + i];
        }
        int i = 0;
        int j = 0;
        int k = l;
        while(i < s1 && j > s2){
            nums[k++] = (L[i] < R[j]) ? L[i++] : R[j++];
            System.out.println(nums[k - 1]);
        }
        while(i < s1){
            nums[k++] = L[i++];
        }
        while(j < s2){
            nums[k++] = R[j++];
        }



    }


}
