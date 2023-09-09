import java.util.Random;
import java.util.Scanner;


public class Map {
	
	// Positions
	Random rand = new Random();
	
	// set custom field size
	private int sizeX;
	private int sizeY;
	
	// winning position
	private int winX;
	private int winY;
	
	// starting position
	private int currentX;
	private int currentY;	
	
	private int userSquare;
	
	
	public void enterCustomSize() {
		
		// common
		Scanner sc = new Scanner(System.in);		
		String userSquare;
		
		try {
			userSquare = sc.nextLine();
		} catch (NumberFormatException e) {
			System.out.println(
					"Please only enter a number!"
					+ "\nHow large a square would you like? : ");
			userSquare = sc.nextLine();
		} catch (Exception e) {
			System.out.println("Unchecked Exception cought - \r\n");
			e.printStackTrace();
			System.out.println(
					"Please only enter a number!"
					+ "\nHow large a square would you like? : ");
			userSquare = sc.nextLine();
		}
		
		
		if (Integer.valueOf(userSquare) < 2) {
			System.out.println(
					String.format(
							"Don't be silly! Choose a number bigger than %s next time!", 
							userSquare)
					);
			enterCustomSize();
		}
		
		Map map = new Map();
		map.setSizeX(Integer.valueOf(userSquare));
		map.setSizeY(Integer.valueOf(userSquare));
		map.setUserSquare(Integer.valueOf(userSquare));
	
	
	// Create custom map size

		// set map size
		sizeX = Integer.valueOf(userSquare);
		sizeY = Integer.valueOf(userSquare);

		// winning position
		winX = rand.nextInt(sizeX) + 1;
		winY = rand.nextInt(sizeY) + 1;
		
		// starting position
		currentX = rand.nextInt(sizeX) + 1;
		currentY = rand.nextInt(sizeY) + 1;;
		
		// change winning position if it's the same as starting position
		while ( (currentX == winX) && (currentY == winY) ) {
			winX = rand.nextInt(sizeX) + 1;
			winY = rand.nextInt(sizeY) + 1;
		}
			
	}	
	

	public void move(String direction) {
		
		switch(direction) {
			case "N":
				if (currentY < sizeY) {
					currentY++;
				} else {
					currentY = 1;
				}
				break; 
			case "E":
				if (currentX < sizeX) {
					currentX++;
				} else {
					currentX = 1;
				}
				break; 
			case "S":
				if (currentY > 1) {
					currentY--;
				} else {
					currentY = sizeY;
				}
				break; 
			case "W":
				if (currentX > 1) {
					currentX--;
				} else {
					currentX = sizeX;
				}
				break; 
			default:
			  System.out.println(
					  "To make a move "
					  + "enter letter N, E, S or W) : "
					  );
		}
	}
	
	
	// Check if move is a win
	public boolean isWin() {
		boolean isWin = false;
		if (currentX == winX && currentY == winY) {
			isWin = true;
		}
		return isWin;
	}
	
	
	// Draw map
	public void printMap() {
        
        int x = 1;
        int y = sizeY;
        
        String line;
        String lineBreak = "";
        while (y > 0 ) {
            line = "|";
            lineBreak = "+";
            while (x <= sizeY) {
                if ( ( x == currentX ) && ( y == currentY) ) {
                    line = line + "x|";
                } else {
                    line = line + " |";
                }
                lineBreak = lineBreak + "-+";
                x++;
            }
            x = 1;
            System.out.println(lineBreak);
            System.out.println(line);
            y--;
        }
        System.out.println(lineBreak);

	}
	
	
	// Getters and setters
	public int getCurrentX() {
		return currentX;
	}


	public void setCurrentX(int currentX) {
		this.currentX = currentX;
	}


	public int getCurrentY() {
		return currentY;
	}


	public void setCurrentY(int currentY) {
		this.currentY = currentY;
	}


	public int getSizeX() {
		return sizeX;
	}


	public int getSizeY() {
		return sizeY;
	}

	public int getWinX() {
		return winX;
	}


	public int getWinY() {
		return winY;
	}

	public void setSizeX(int userSquare) {
		this.sizeX = userSquare;
	}
	
	public void setSizeY(int userSquare) {
		this.sizeY = userSquare;
	}
		
	public void setUserSquare(int userSquare) {
		this.userSquare = userSquare;
	}
	
//	public void getUserSquare() {
//		return userSquare;
//	}

	
}
