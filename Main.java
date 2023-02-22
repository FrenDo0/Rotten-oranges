package com.company;

import java.util.Scanner;

public class Main {
    static int columns = 0;
    static int rows = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] inputString = sc.nextLine().split(" ");

        int days = 0;

        for (int i = 0; i < 1; i++) {
            rows = Integer.parseInt(inputString[0]);
            columns = Integer.parseInt(inputString[1]);
            days = Integer.parseInt(inputString[2]);
        }

        int rottenColumn = 0;
        int rottenRow = 0;

        int rottenColumn2 = 0;
        int rottenRow2 = 0;

        int input = Integer.parseInt(sc.nextLine());
        if(input == 1){
            String[] rottenOranges1 = sc.nextLine().split(" ");
            for (int i = 0; i < 1; i++) {
                rottenRow = Integer.parseInt(rottenOranges1[0]);
                rottenColumn = Integer.parseInt(rottenOranges1[1]);
            }
        }else if(input == 2){
            String[] rottenOranges1 = sc.nextLine().split(" ");
            for (int i = 0; i < 1; i++) {
                rottenRow = Integer.parseInt(rottenOranges1[0]);
                rottenColumn = Integer.parseInt(rottenOranges1[1]);
            }
            String[] rottenOranges2 = sc.nextLine().split(" ");
            for (int i = 0; i < 1; i++) {
                rottenRow2 = Integer.parseInt(rottenOranges2[0]);
                rottenColumn2 = Integer.parseInt(rottenOranges2[1]);
            }
        }

        int[][] grid = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                grid[i][j] = 1;
                if(j == rottenColumn - 1 && i == rottenRow - 1){
                    grid[i][j] = 2;
                }
                if(rottenRow2 != 0 && rottenColumn2 != 0 && j == rottenColumn2 - 1 && i == rottenRow2 - 1){
                    grid[i][j] = 2;
                }
            }
        }

        int rottenOrange = 2;
        boolean checker = false;
        while(days > 0){
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                        if(grid[i][j] == rottenOrange){
                            if (inMatrix(i + 1, j) && grid[i + 1][j] == 1) {
                                grid[i + 1][j] = rottenOrange+1;
                                checker = true;
                            }
                            if (inMatrix(i, j + 1) && grid[i][j + 1] == 1) {
                                grid[i][j + 1] = rottenOrange+1;
                                checker = true;
                            }
                            if (inMatrix(i - 1, j) && grid[i - 1][j] == 1) {
                                grid[i - 1][j] = rottenOrange+1;
                                checker = true;
                            }
                            if (inMatrix(i, j - 1) && grid[i][j - 1] == 1) {
                                grid[i][j - 1] = rottenOrange+1;
                                checker = true;
                            }

                        }
                    }
                }
            if(checker == false){
                break;
            }
            rottenOrange++;
            days--;
            }

        int counter = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if(grid[i][j] == 1){
                    counter++;
                }
            }
        }
        System.out.println(counter);
    }

    static boolean inMatrix(int i, int j)
    {
        if (i >= 0 && i < rows && j >= 0 && j < columns){
            return true;
        }
        return false;
    }

}


