package Arrays;

public class MoveZeroesToEndLC283 {

    public void moveZeroes(int[] nums) {

        int j = 0; 

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] != 0) {

                nums[j] = nums[i];

                j++;

            }

        }

        for (int i = j; i < nums.length; i++) {

            nums[i] = 0;

        }

    }
}


// this takes 2 passes , the below code takes a single pass only  both has same t.c = O(n) and sc= O(1)

/*
public void moveZeroes(int[] nums) {
    int j = 0;
    for (int i = 0; i < nums.length; i++) {
        if (nums[i] != 0) {
            if (i != j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
            j++;
        }
    }
}

 */
