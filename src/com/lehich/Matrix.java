package com.lehich;
import java.util.Random;
public class Matrix {
    private static int[][] matrix;
    public Matrix(){
    }
public static int[][] massCreate(int size) {
    double chanse = 0.4;
    Random rnd = new Random();
    matrix = new int[size][size];
    int counter = 0;
    for (int i = 0; i < size; i++)
    {
        for(int j = 0;j<size;j++)
        {
            matrix[i][j]= 0;
        }
    }
    while (counter <= 0.4*size*size)
    {
        int i = rnd.nextInt(size);
        int j = rnd.nextInt(size);
        if (matrix[i][j] != 1)
        {
            matrix[i][j] = 1;
            counter++;
        }
    }
    return matrix;
}
public static void massPrint(int[][] matrix) {
    for (int i = 0; i < matrix.length; i++)
    {
        for(int j = 0;j<matrix.length;j++)
        {
            System.out.printf("%2d  ", matrix[i][j]);
        }
        System.out.println();
    }
}


public static int[][] Test(int[][] matrix,int x1,int x2,int y1,int y2) {
    matrix[x1-1][x2-1] = 0;
    boolean add = true;
    int[][] battle = new int[12][12];
    for(int i = 0;i<10;i++){
        for(int j =0;j<10;j++){
            battle[i+1][j+1] = matrix[i][j];
        }
    }
    for(int i =0;i<12;i++){
        battle[i][0] = 1;
        battle[11][i] = 1;
        battle[0][i] = 1;
        battle[i][11] = 1;
    }

    int step = 0;
    for(int i = 0;i<battle.length;i++){
        for (int j =0;j<battle.length;j++)
        {
        if(battle[i][j]==1) battle[i][j] = -2;
        else battle[i][j] = -1;
        }
    }
    battle[y1][y2] = 0;
  //try {
      while (add == true) {
          add = false;
          for (int i = 0; i < battle.length; i++) {
              for (int j = 0; j < battle.length; j++) {
                      if (battle[i][j] == step) {
                          if (j - 1 >= 0 && battle[i][j - 1] != -2 && battle[i][j - 1] == -1)
                              battle[i][j - 1] = step + 1;
                          if (i - 1 >= 0 && battle[i - 1][j] != -2 && battle[i - 1][j] == -1)
                              battle[i - 1][j] = step + 1;
                          if (j + 1 >= 0 && battle[i][j + 1] != -2 && battle[i][j + 1] == -1)
                              battle[i][j + 1] = step + 1;
                          if (i + 1 >= 0 && battle[i + 1][j] != -2 && battle[i + 1][j] == -1)
                              battle[i + 1][j] = step + 1;
                      }
              }
          }
          step++;
          add = true;
          if (battle[x1][x2] > 0 ) {
              add = false;
          }
          if(step > battle.length*battle.length){
              add=false;
              System.out.println("Путь невозможен");}
      }
//      massPrint(battle);

    for(int i = 1;i<battle.length-1;i++){
        for (int j =1;j<battle.length-1;j++)
        {
            System.out.printf("%2d  ", battle[i][j]);
        }
        System.out.println();
    }

//  }
//  catch (Exception ex) {
//      System.out.println("Путь невозможен");
//  }



  return battle;
 }
}