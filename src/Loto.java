import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Loto {
	public static void main(String[] args) {
		new App();
	}
}

class App {
	
	private final Scanner sc;
	private final Set<Integer> lotoSet; // 正解ロト
	private final Set<Integer> playerSet; // 使用者ロト
	
	public App() {
		this.sc = new Scanner(System.in);
		this.lotoSet = new HashSet<Integer>();
		this.playerSet = new HashSet<Integer>();
		this.run();
		this.sc.close();
	}
	private void run() {
		int input;
		
		this.setRandomNumbers(this.lotoSet);
		while (true) {
			this.println("1.直接入力\t2.ランダム入力");
			try {
				input = this.sc.nextInt();				
			} catch (Exception e) {
				this.println("番号を入力してください");
				continue;
			}
			if (input == 1) {
				this.manual();
			} else if (input == 2) {
				this.setRandomNumbers(this.playerSet);
			} else {
				this.println("番号を入力してください");
				continue;
			}
			break;
		}
		this.println("入力した数値: " + this.playerSet);
		this.lotoSet.retainAll(this.playerSet);
		this.println("当たった数値: " + this.lotoSet);
		this.println("当たった数: " + this.lotoSet.size());
	}
	private void manual() {
		int input;
		
		while (this.playerSet.size() < 7) {
			input = this.sc.nextInt();
			if (input > 50) {
				this.println("50以下の数値で入力してください");
				continue;
			}
			if (!this.playerSet.add(input)) {
				this.println("前回入力と重複です");
				continue;
			}
		}
	}
	private void setRandomNumbers(Set<Integer> set) {
		while (set.size() < 7) set.add((int) (Math.random() * 50 + 1));
	}
	private void println(String s) {
		System.out.println(s);
	}
}
