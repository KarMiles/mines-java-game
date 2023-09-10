import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		// Common
		Scanner sc = new Scanner(System.in);
		Map map = new Map();

		
		// Create character 
		System.out.println(
				"WELCOME TO *Special Agent Bomb Technician* GAME!"
				+ "\nFind dangerous material on the field to win."
				+ "\nHow should I call you? : ");
		String userName = sc.nextLine();
		
		
		// Create custom map size 
		System.out.println(
				"How large a square would you like? : ");
		map.enterCustomSize();
		

		// Welcome player
		System.out.println(
				String.format("Hello, %s!", userName)
				);
		System.out.println(
				String.format(
						"Size of the field is %s x %s,"
						+ "\nYour starting position is %s %s.",
						map.getSizeX(),
						map.getSizeY(),
						map.getCurrentX(), 
						map.getCurrentY())
				);
		// show map
		map.printMap();

		
		while (!map.isWin()) {

			// Get move directions from player
			System.out.println(
					"Enter your move (choose only between N, E, S and W): ");
			String userDirection = sc.nextLine().toUpperCase();
			
			
			// Execute move
			map.move(userDirection);
			
			
			// Confirm move to user and inform of result of the move
			System.out.println(
					String.format(
							"After moving %s your new position is %s %s.",
							userDirection,
							map.getCurrentX(), 
							map.getCurrentY()
							)
					);
			map.printMap();
			
			
			// check if move is a win
			if (map.isWin()) {
				System.out.println(
						String.format("\n*** Congrats, %s! You WIN!!! ***",
								userName)
						);
			}
			
		}
		
		
	}

}
