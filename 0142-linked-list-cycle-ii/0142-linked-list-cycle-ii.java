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
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null; // No cycle if list is empty or has only one node
        }

        ListNode slow = head; // Initialize slow pointer
        ListNode fast = head; // Initialize fast pointer

        // Step 1: Detect cycle
        while (fast != null && fast.next != null) {
            slow = slow.next; // Move slow pointer by one
            fast = fast.next.next; // Move fast pointer by two

            if (slow == fast) { // Cycle detected
                break;
            }
        }

        // If no cycle was found
        if (fast == null || fast.next == null) {
            return null;
        }

        // Step 2: Find the entry point of the cycle
        slow = head; // Reset slow pointer to the head
        while (slow != fast) {
            slow = slow.next; // Move slow pointer by one
            fast = fast.next; // Move fast pointer by one
        }

        // The meeting point is the start of the cycle
        return slow;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna