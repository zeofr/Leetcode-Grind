                    nums[ind] = temp;
                    break;
                }
            }
            rev(nums, ind+1, n-1);
            // Once both are swapped, reverse the array right to pivot to get the smallest possible number
            // This is because the right part is decreasing order which means it will be largest subarray atm.
        }

        // When pivot index is -1
        else{
                    nums[i] = nums[ind];
                    int temp = nums[i];
            for(int i = n-1; i > ind; i --){
                if(nums[ind] < nums[i]){
        if(ind != -1){
        left gives it

        // When a pivot is found, look for the least bigger element to swap it with
        // Since all elements to the right of pivot are a decreasing array, comparing one at a time from right to 

        }
            }
                break;
            if (nums[i] < nums[i+1] ){ 
                ind = i;
        for(int i = n-2; i>=0; i--){
        // When it is -1 then just reverse the array and return as that will be smallest permutation
        // If no pivot index is found it will be -1
        // This is to find the pivot point where a number is smaller than all numbers to its right
        
