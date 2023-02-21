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

        String[] rottenOranges = sc.nextLine().split(" ");
        for (int i = 0; i < 1; i++) {
            rottenRow = Integer.parseInt(rottenOranges[0]);
            rottenColumn = Integer.parseInt(rottenOranges[1]);
        }

        int[][] grid = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                grid[i][j] = 1;
                if(j == rottenColumn - 1 && i == rottenRow - 1){
                    grid[i][j] = 0;
                }
            }
        }
        
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    if(days == 0){
                        break;
                    }else{
                        if(grid[i][j] == 0){
                            if (inMatrix(i + 1, j) && grid[i + 1][j] == 1) {
                                grid[i + 1][j] = 0;
                            }
                            if (inMatrix(i, j + 1) && grid[i][j + 1] == 1) {
                                grid[i][j + 1] = 0;
                            }
                            if (inMatrix(i - 1, j) && grid[i - 1][j] == 1) {
                                grid[i - 1][j] = 0;
                            }
                            if (inMatrix(i, j - 1) && grid[i][j - 1] == 1) {
                                grid[i][j - 1] = 0;
                            }
                            --days;
                        }
                    }
                }
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
