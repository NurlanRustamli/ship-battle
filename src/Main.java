import java.util.Arrays;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int bombNumber = 25;
        short fiveTypeShip = 0;
        short fourTypeShip = 0;
        short threeTypeShip = 0;
        short twoTypeShip = 0;
        int[][] map = new int[10][10];

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                map[i][j] = 0;
            }
        }
        shipLocate(5, map);
        shipLocate(4, map);
        shipLocate(3, map);
        shipLocate(3, map);
        shipLocate(2, map);
        shipLocate(2, map);




        while (true) {
            print2D(map);

            if (bombNumber > 0) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                if (map[x][y] == 5) {
                    System.out.println("hit");
                    bombNumber--;
                    map[x][y] = -5;
                    fiveTypeShip++;
                } else if (map[x][y] == 4) {
                    System.out.println("hit");
                    fourTypeShip++;
                    bombNumber--;
                    map[x][y] = -4;
                } else if (map[x][y] == 3) {
                    threeTypeShip++;
                    System.out.println("hit");
                    bombNumber--;
                    map[x][y] = -3;
                } else if (map[x][y] == 2) {
                    System.out.println("hit");
                    twoTypeShip++;
                    bombNumber--;
                    map[x][y] = -2;
                } else if (map[x][y] == 0) {
                    System.out.println("missed");
                    bombNumber--;
                    map[x][y] = -11;
                } else if (map[x][y] == -11) {
                    System.out.println("Yeniden daxil edin evvel vurmusuz bu yeri");
                }
                if (fiveTypeShip==5&&fourTypeShip==4&&threeTypeShip==6&&twoTypeShip==4){
                    System.out.println("You won");
                    break;
                }

            } else {
                System.out.println("There is no bomb");
                System.out.println("Ships with the length of 2 destroyed : " + (twoTypeShip / 2));
                System.out.println("Ships with the length of 3 destroyed : " + (threeTypeShip / 3));
                System.out.println("Ships with the length of 4 destroyed : " + (fourTypeShip / 4));
                System.out.println("Ships with the length of 5 destroyed : " + (fiveTypeShip / 5));
                break;
            }
        }
    }

    public static void shipLocate(int typeCount, int[][] map) {
        while (true) {
            short trial = 0;
            // Random starting position
            int colStart = (int) (Math.random() * 10);
            int rowStart = (int) (Math.random() * 10);
            boolean horizontal = Math.random() >= 0.5;
            //<5 dise horizontal,>=5 dise vertical

            // Ensure the ship fits within the map
            if (rowStart + typeCount < map.length && colStart + typeCount < map[0].length && !horizontal) {
                // Place the ship horizontally on the map
                for (int i = 0; i < typeCount; i++) {
                    if (map[rowStart][colStart + i] == 0) {
                        // Mark the ship on the map
                        trial++;
                    }
                }
                if (trial == typeCount) {
                    for (int i = 0; i < typeCount; i++) {
                        map[rowStart][colStart + i] = typeCount;
                    }
                    break; // Exit the loop after placing the ship

                } else {
                    continue;
                }
            } else if (rowStart + typeCount < map.length && colStart + typeCount < map[0].length && horizontal) {
                // Place the ship vertically on the map
                for (int i = 0; i < typeCount; i++) {
                    if (map[rowStart + i][colStart] == 0) {
                        // Mark the ship on the map
                        trial++;
                    }

                }
                if (trial == typeCount) {
                    for (int i = 0; i < typeCount; i++) {
                        map[rowStart + i][colStart] = typeCount;
                    }
                    break; // Exit the loop after placing the ship

                } else {
                    continue;
                }
            }
        }
    }

    public static void print2D(int mat[][]) {
        // Loop through all rows
        for (int[] row : mat)

            // converting each row as string
            // and then printing in a separate line
            System.out.println(Arrays.toString(row));
    }
}


