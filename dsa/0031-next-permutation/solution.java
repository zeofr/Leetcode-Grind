            for(int i = n-1; i > ind; i --){
                if(nums[ind] < nums[i]){
                    int temp = nums[i];
                    nums[i] = nums[ind];
                    nums[ind] = temp;
                    break;
                }
            }
            rev(nums, ind+1, n-1);
        }
        else{
            rev(nums, ind+1, n-1);
        }

    }

    public void rev(int[] nums, int l,int r){
        while(l<r){
            int t = nums[l];
            nums[l] = nums[r];
            nums[r] = t;
            l++;
            r--;
        }
    }
}
