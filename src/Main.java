import com.lehich.Matrix;
import java.io.BufferedReader;
import java.util.Scanner;

public class Main extends Matrix{
    public static void main(String[] args) {
        int x1,x2,y1,y2;
        int size = 10;
        Scanner sc = new Scanner(System.in);
        int[][] massive;
        massive = massCreate(size);
        massPrint(massive);
        
      System.out.println("Введите координаты x1:");
      x1 = sc.nextInt();
      System.out.println("Введите координаты x2:");
      x2 = sc.nextInt();
      System.out.println("Введите координаты y1:");
      y1 = sc.nextInt();
      System.out.println("Введите координаты y2:");
      y2 = sc.nextInt();
        
      Test(massive,x1,x2,y1,y2);
    }
}
