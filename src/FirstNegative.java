import java.util.*;

public class FirstNegative {

	public static void main(String[] args) {
		int[] arr = {-3, -1, -5, 7, -2, -1};
		
		Queue<Integer> q = new LinkedList<Integer>();
		int k = 3;
		
		for (int i = 0; i < k; i++) {
			if (arr[i] < 0) {
				q.add(i);
			}
		}
		
		for (int i = k; i < arr.length; i++) {
			if (!q.isEmpty()) {
				System.out.println(arr[q.peek()]);
			} else {
				System.out.println("0");
			}
			
			while (!q.isEmpty() && q.peek() <= i-k) {
				q.remove();
			}
			if (arr[i] < 0) {
				q.add(i);
			}
		}
		
		if (!q.isEmpty()) {
			System.out.println(arr[q.peek()]);
		} else {
			System.out.println("0");
		}
	}

}
