// Given the head a linked list, the task is to reverse 
// every k node in the linked list. If the number of 
// nodes is not a multiple of k then the left-out nodes 
// in the end, should be considered as a group and must 
// be reversed.

import java.util.ArrayList;

class Solution {
    public static Node reverseKGroup(Node head, int k) 
    {
        ArrayList<Integer> list = new ArrayList<>();
        Node temp = null;
        int iStart = 0, iEnd = 0, iTemp = 0, i = 0;
        
        temp = head;
        while(temp != null)
        {
            list.add(temp.data);
            temp = temp.next;
        }
        
        for (i = 0; i < list.size(); i += k) 
        { 
          iStart = i;
          iEnd = Math.min(i + k - 1, list.size() - 1); 
    
          while (iStart < iEnd) 
          {
            iTemp = list.get(iStart);
            list.set(iStart, list.get(iEnd));
            list.set(iEnd, iTemp);
            iStart++;
            iEnd--;
          }
        }
        
        temp = head;
        i = 0;
        while(temp != null)
        {
            temp.data = list.get(i);
            temp = temp.next;
            i++;
        }
        
        return head;
    }
}