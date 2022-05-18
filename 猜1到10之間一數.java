import java.util.*;

public class Main{
	private static Random ran = new Random();
	private static int ans = ran.nextInt(10)+1;
	public static void main(String args[]) {
		int en = 0;
		System.out.print("**The answer is "+String.valueOf(ans));
		System.out.println(" **");
		Scanner s = new Scanner(System.in);
		System.out.println("Please enter a number to guess the answer between 1 to 10");
		while (en != ans) {
			en = s.nextInt();
			if(en>10) {
				System.out.println("You can't higher then 10!");
				continue;
			}
			if(en<1) {
				System.out.println("You can't lower then 1!");
				continue;
			}
			if(en>ans) {
				System.out.println("Answer is more lower");
				continue;
			}
			else if(en<ans) {
				System.out.println("Answer is more higher");
				continue;
			}
			else {
				System.out.println("Congratulation! the answer is "+ans);
				s.close();
			}
		}
	}
}
