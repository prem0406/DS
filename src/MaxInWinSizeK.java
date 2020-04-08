import java.util.*;
public class MaxInWinSizeK {
	public static void main(String[] args) {
		int[] arr = {3, -1, -5, 7, -2, 1};
		int k = 3; //window size
		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < k; i++) {
			while (!q.isEmpty() && q.peek() < arr[i]) {
				q.remove();
			}
			q.add(i);
		}
		
		for (int i = k; i < arr.length; i++) {
			System.out.println(arr[q.peek()]);
			
			if (!q.isEmpty() && q.peek() <= i-k) {
				q.remove();
			}
			
			while (!q.isEmpty() && q.peek() < arr[i]) {
				q.remove();
			}
			q.add(i);
		}
		if (!q.isEmpty()) {
			System.out.println(arr[q.peek()]);
		} else {
			System.out.println("0");
		}
	}
}
