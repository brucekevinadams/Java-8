/*
 * Author: Bruce Adams
 * email: ezaroth@gmail.com
 * website: austingamestudios.com
 * 
*/

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

// Write your Checker class here
public class Checker implements Comparator<Player> {
	@Override
	public int compare(Player a, Player b) {
		if (a.score == b.score) {
			return a.name.compareTo(b.name);// alphabetically
		} else {
			return b.score - a.score;// decreasing
		}
	}
}

class Player {
	String name;
	int score;

	Player(String name, int score) {
		this.name = name;
		this.score = score;
	}

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();

		Player[] player = new Player[n];
		Checker checker = new Checker();

		for (int i = 0; i < n; i++) {
			player[i] = new Player(scan.next(), scan.nextInt());
		}
		scan.close();

		Arrays.sort(player, checker);
		for (int i = 0; i < player.length; i++) {
			System.out.printf("%s %s\n", player[i].name, player[i].score);
		}
	}
}
