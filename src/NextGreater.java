
import java.util.Stack;


public class NextGreater {

	public static void main(String[] args) {
//		int[] arr = {3, 5, 1, 8, 7, 6};
		//int[] arr = {11, 13, 21, 3};
		
		int[] arr = {11, 9, 13, 21, 3};
		
		Stack<Integer> stack = new Stack<>();

		stack.push(arr[0]);
		for (int i = 1; i < arr.length; i++) {
			
			
			
			while (!stack.isEmpty() && stack.peek() < arr[i]) {
				System.out.println(stack.peek() + "," + arr[i]);
				stack.pop();
			}
			stack.push(arr[i]);
		}
		while (!stack.isEmpty()) {
			int x = stack.firstElement();
			stack.removeElement(x);
			
			System.out.println(x + "," + -1);
		}
	}
}
