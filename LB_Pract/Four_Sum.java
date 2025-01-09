package HashMaps;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Four_Sum 
{
    public static ArrayList<List<Integer>> four_sum(int []nums, int target)
    {
        ArrayList<List<Integer>> list = new ArrayList<>();

        if(nums == null || nums.length == 0)
        {
            return list;
        }

        int n = nums.length;
        Arrays.sort(nums);

        for(int i=0; i<n; i++)
        {
            for(int j=i+1; j<n; j++)
            {
                int result =target - (nums[i]+nums[j]);

                int front = j+1;
                int back = n-1;

                while(front < back)
                {
                    int two_sum = nums[front] + nums[back];
                    if(two_sum < result)
                    {
                        front++;
                    }
                    else if(two_sum > result)
                    {
                        back--;
                    }
                    else
                    {
                        List<Integer> lst = new ArrayList<>();
                        lst.add(nums[i]);
                        lst.add(nums[j]);
                        lst.add(nums[front]);
                        lst.add(nums[back]);
                        list.add(lst);
                    }
                }HashSet<Character> set = new HashSet<>()
            }
        }
        return list;
    }
    public static void main(String[] args) 
    {
        int nums[] = new int[]{4,3,3,4,4,2,1,2,1,1};
        
        ArrayList<List<Integer>> list = four_sum(nums, 9);
        System.out.println(list);
    }
}
