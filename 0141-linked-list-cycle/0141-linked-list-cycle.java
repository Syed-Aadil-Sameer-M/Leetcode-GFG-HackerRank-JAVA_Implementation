/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false; // No cycle if list is empty or has only one node
        }

        ListNode slow = head; // Initialize slow pointer
        ListNode fast = head; // Initialize fast pointer

        while (fast != null && fast.next != null) {
            slow = slow.next; // Move slow pointer by one
            fast = fast.next.next; // Move fast pointer by two

            if (slow == fast) {
                return true; // Cycle detected
            }
        }
        return false; // No cycle
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna