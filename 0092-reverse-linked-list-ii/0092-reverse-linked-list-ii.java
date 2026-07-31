/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // Create a dummy node that points to the head
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        // Move `prev` to the node just before the `left` position
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }

        // Start reversing the sublist
        ListNode start = prev.next; // This is the first node of the sublist
        ListNode then = start.next; // This is the node that will be moved

        // Reverse the nodes between `left` and `right`
        for (int i = 0; i < right - left; i++) {
            start.next = then.next; // Connect start to the node after then
            then.next = prev.next; // Move then to the front of the reversed section
            prev.next = then; // Connect prev to the new front
            then = start.next; // Move then to the next node to be reversed
        }

        return dummy.next; // Return the new head of the list
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna