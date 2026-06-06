import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    
    private Queue<Integer> q1;
    private Queue<Integer> q2;
    private int topElement; 

    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(int x) {
        q1.offer(x);
        topElement = x; 
    }

    public int pop() {
        
        while (q1.size() > 1) {
            int val = q1.poll();
            q2.offer(val);
            topElement = val; 
        }
        
        int popped = q1.poll();
        
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
        return popped;
    }

    public int top() {
        
        return topElement;
    }

    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna