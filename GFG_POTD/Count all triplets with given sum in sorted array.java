// Given a sorted array arr[] and a target value, the task 
// is to count triplets (i, j, k) of valid indices, such 
// that arr[i] + arr[j] + arr[k] = target and i < j < k.



class Solution {
    public int countTriplets(int[] arr, int target) {
        int count = 0;
        int n = arr.length;
        
        for (int i = 0; i <= n - 3; i++) {
            int j = i + 1, k = n - 1;
            
            while (j < k) {
                int sum = arr[i] + arr[j] + arr[k];
                
                if (sum > target) {
                    k--;
                } else if (sum < target) {
                    j++;
                } else {
                    count++;
                    int temp = j + 1;
                    while (temp < k && arr[temp] == arr[temp - 1]) {
                        count++;
                        temp++;
                    }
                    k--;
                }
            }
        }
        
        return count;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = {1, 2, 3, 4, 5, 6}; // Example array
        int target = 10; // Example target
        System.out.println("Count of triplets: " + sol.countTriplets(arr, target));
    }
}
