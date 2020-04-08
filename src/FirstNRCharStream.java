import java.util.*;

public class FirstNRCharStream {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		char c = s.next().charAt(0);
		Queue<Character> q = new LinkedList<>();
		
		//This list is to store all the duplicate elements
		ArrayList<Character> duplicate = new ArrayList<>();
		
		while (c != '.') {
			if (!duplicate.contains(c)) {
				if (q.isEmpty()) {
					//System.out.println(c);
					q.add(c);
				} else {
					if (c == q.peek()) {			/* if the entered element is current unique then*/
						duplicate.add(q.peek());	/*remove it and also save it in list of duplicates*/
						q.remove();
					} else if (q.contains(c)) {
						
						duplicate.add(c);
						q.remove(c);
					} else {
						q.add(c);
					}
				}
			}
			System.out.println(q.peek());
			c = s.next().charAt(0);
		}
	}

}
