import java.lang.reflect.Array;
import java.util.ArrayList;

public class LifeLijst {
    public static void main(String[] args) {
        int[][] table = new int[10][10];
        table[1][1] = 1;
        table[1][2] = 1;
        table[2][1] = 1;
        table[2][2] = 1;
//        System.out.println(nextgeneration(table)[5][5]);
//        System.out.println(nextgeneration(table)[0][0]);
        System.out.println(nextgeneration(table)[2][2]);


    }

    public static int[][] nextgeneration(int[][] table) {
        int s = 0;
        for (int i = 0; i < 10; i++) {
            for (int k = 0; k < 10; k++) {
                if (i ==0&&k==0) {
                    s = table[i + 1][k] + table[i][k + 1] + table[i + 1][k + 1];
                }else if (i ==9&&k==0) {
                    s = table[i - 1][k] + table[i][k + 1] + table[i - 1][k + 1];
                } else if (i ==0&&k==9) {
                    s = table[i + 1][k] + table[i][k - 1] + table[i + 1][k - 1];
                } else if (i ==9&&k==9) {
                    s = table[i - 1][k] + table[i][k - 1] + table[i - 1][k - 1];
                }

                else if (i == 0) {
                    s = table[i][k - 1] + table[i + 1][k - 1] +
                            table[i + 1][k] +
                            table[i][k + 1] + table[i + 1][k + 1];
                } else if (i ==9) {
                    s = table[i - 1][k - 1] + table[i][k - 1] +
                            table[i - 1][k] +
                            table[i - 1][k + 1] + table[i][k + 1];
                } else if (k == 0) {
                    s = table[i - 1][k] + table[i + 1][k] +
                            table[i - 1][k + 1] + table[i][k + 1] + table[i + 1][k + 1];
                } else if (k == 9) {
                    s = table[i - 1][k - 1] + table[i][k - 1] + table[i + 1][k - 1] +
                            table[i - 1][k] + table[i + 1][k];
                }
                else {
                    s = table[i - 1][k - 1] + table[i][k - 1] + table[i + 1][k - 1] +
                            table[i - 1][k] + table[i + 1][k] +
                            table[i - 1][k + 1] + table[i][k + 1] + table[i + 1][k + 1];
                }

                if (table[i][k] == 1) {
                    if (s == 2 || s==3) {
                        table[i][k] = 1;
                    }else{
                        table[i][k] = 0;
                    }
            } else {
                    if (s ==3) {
                        table[i][k] = 1;
                    }

                    }
                }

            }
        return table;
    }
}
