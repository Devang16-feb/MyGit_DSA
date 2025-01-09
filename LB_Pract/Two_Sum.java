package HashMaps;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Two_Sum 
{
    public static int[] twoSum(int[] numbers, int target)
    {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(int i=0; i<numbers.length; i++)
        {
            if(map.containsKey(target - numbers[i]))
            {
                result[1] = i;
                result[0] = map.get(target - numbers[i]);
                return result;
            }
            map.put(numbers[i], i);
        }
        return result;
    }
    public static void main(String[] args) 
    {
        int Arr[] = twoSum(new int[]{2,6,5,8,11}, 14);
        System.out.println(Arrays.toString(Arr));
    }
}
