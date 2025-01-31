// Given the head of two sorted linked lists consisting 
// of nodes respectively. The task is to merge both lists
// and return the head of the sorted merged list.

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    Node sortedMerge(Node head1, Node head2) {
        // code here
        
        List<Integer> list = new ArrayList<>();
        Node temp = null;
        
        temp = head1;
        while(temp != null)
        {
            list.add(temp.data);
            temp = temp.next;
        }
        
        temp = head2;
        while(temp != null)
        {
            list.add(temp.data);
            temp = temp.next;
        }
        
        Collections.sort(list);
        
        Node head = null;
        int i=0;
        
        while(i < list.size())
        {
            Node newn = new Node(list.get(i));
            
            if(head == null)
            {
                head = newn;
            }
            else
            {
                temp = head;
                
                while(temp.next != null)
                {
                    temp = temp.next;
                }
                temp.next = newn;
            }
            i++;
        }
        
        return head;
    }
}