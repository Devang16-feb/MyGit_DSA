// Given a head of the singly linked list. If a loop is present 
// in the list then return the first node of the loop else return 
// NULL.

// Custom Input format:
// A head of a singly linked list and a pos (1-based index) which 
// denotes the position of the node to which the last node points to. 
// If pos = 0, it means the last node points to null, indicating there 
// is no loop.

class Node
{
    int data;
    Node next;

    Node(int x)
    {
        data = x;
        next = null;
    }
}

class Solution {
    public static Node findFirstNode(Node head) 
    {
        if(head == null)
        {
            return null;
        }
        
        Node slow = head;
        Node fast = head;
        
        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow == fast)
            {
                slow = head;
                
                while(slow != fast)
                {
                    fast = fast.next;
                    slow = slow.next;            
                }
                return slow;
            }
        }
        return null;
        // code here
    }
}