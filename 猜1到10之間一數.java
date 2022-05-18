import java.util.*;

public class Main{
	private static Random ran = new Random();
	private static int answer = ran.nextInt(10)+1;
	public static void main(String args[]) {
		int en = 0;
		System.out.print("**The answer is "+answer);	//確認答案為何
		System.out.println(" **");
		Scanner s = new Scanner(System.in);
		System.out.println("Please enter a number to guess the answer between 1 to 10");
		while (en != answer) {
			en = s.nextInt();
			if(en>10) {	//輸入的值大於10
				System.out.println("You can't higher then 10!");
				continue;
			}
			if(en<1) {	//輸入的值小於1
				System.out.println("You can't lower then 1!");
				continue;
			}
			if(en>answer) {	//輸入的值大於答案
				System.out.println("Answer is more lower");
				continue;
			}
			else if(en<answer) {	//輸入的值小於答案
				System.out.println("Answer is more higher");
				continue;
			}
			else {	//猜到答案
				System.out.println("Congratulation! the answer is "+answer);
				s.close();
			}
		}
	}
}
