import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static boolean[][] Generate_grid(double threshold) {
        boolean[][] grid = new boolean[3][3];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                double rand = Math.random();
                grid[i][j] = !(rand > threshold);
            }
        }
        return grid;
    }


    static int[] checker(boolean[][] array) {
        int[][] new_array = new int[3][3];
        List<Integer> priority_list = new ArrayList<Integer>();
        int count = 9;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (array[i][j] && i != 1 && j != 1) {
                    new_array[i][j] = 0;
                } else if (i != 1 && j != 1) {
                    new_array[i][j] = count;
                    priority_list.add(count);
                    count--;
                }
            }
        }

        int minimum = Collections.min(priority_list);
        System.out.println("***");
        for (Integer i : priority_list) {
            System.out.print(i + " ");
        }
//        System.out.println(minimum);
        int i_th = 0;
        int j_th = 0;
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                if (new_array[i][j] == minimum) {
                    i_th = i;
                    j_th = j;
                    break;
                }
            }
        int[] position_array = {i_th, j_th};
        return position_array;
    }


    public static void main(String[] args) {
        int t = 10;
        int w = 5000, temp = 1;
        double thrs = 0.10;
        while (w > temp) {
            boolean[][] grid = new boolean[3][3];
            grid = Generate_grid(thrs);
            if (grid[1][1]) {
                t = t + 10;
                System.out.println("## " + t);
            } else {
                int[] new_center_position = checker(grid);
                t = t + 10;
                temp++;
                System.out.println("@ " + temp + " " + t + " @");

            }
        }

        System.out.println("Reached");
    }
}