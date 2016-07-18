package day03;
import org.junit.Test;
import java.util.LinkedList;
import java.util.*;
public class day04 {
	@Test
	public void testComparable(){
		Queue<String> queue = new LinkedList<String>();
		queue.offer("a");
		queue.offer("b");
		queue.offer("c");
		queue.offer("d");
		queue.offer("e");
		System.out.println(queue);
		System.out.println(queue.peek());
		System.out.println(queue.size());
		int size = queue.size();
		for (int i = 0; i < size; i++){
			String str = queue.poll();
			System.out.print(str + " ");
		}
		System.out.println();
		System.out.println(queue);
	}
	@Test
	public void testStack(){
		Deque<String> stack = new LinkedList<String>();
		stack.push("a");
		stack.push("b");
		stack.push("c");
		stack.push("d");
		
		System.out.println(stack);
		System.out.println(stack.peek());
		System.out.println(stack);
		int size = stack.size();
		for (int i = 0; i < size; i++){
			String str = stack.pop();
			System.out.print(str + " ");
		}
		System.out.println();
		System.out.println(stack);
	}
	
}
