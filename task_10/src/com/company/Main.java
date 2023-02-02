package com.company;

import com.util.ArrayUtils;
import com.util.SwingUtils;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public class Main {
    public static class CmdParams {
        public String inputFile;
        public String outputFile;
        public boolean error;
        public boolean window;
    }


    public static CmdParams parseArgs(String[] args) {
        CmdParams params = new CmdParams();
        if (args.length > 0) {
            if (args[0].equals("--window")) {
                params.window = true;
                return params;
            }
            params.inputFile = args[0];
            if (args.length > 1) {
                params.outputFile = args[1];
            }
        } else {
            params.error = true;
        }
        return params;
    }

    public static void winMain(){
//SwingUtils.setLookAndFeelByName("Windows");
        Locale.setDefault(Locale.ROOT);
//UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        SwingUtils.setDefaultFont("Microsoft Sans Serif", 18);

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new FrameMain().setVisible(true));
    }

    public static void main(String[] args) throws Exception {
        CmdParams params = parseArgs(args);
        if (params.window) {
            winMain();
        } else {
            int[][] arr = ArrayUtils.readIntArray2FromFile(params.inputFile);
            if (arr == null) {
                System.err.printf("Can't read array from \"%s\"%n", params.inputFile);
                System.exit(2);
            } else {
                int[][] arr2 = new int [arr.length-1][2];
                for (int i = 0; i < arr.length -1; i++) {
                    arr2[i][0] = arr[i][0];
                    arr2[i][1] = arr[i][1];
                }
                ArrayList<Candy> candies = new ArrayList<>();
                for (int[] values : arr2) {
                    Candy element = new Candy(values[0],values[1]);
                    candies.add(element);
                }
                candies.sort(Comparator.comparing(x -> x.price));
                int money = arr[arr.length - 1][0];
                StringBuilder a = new StringBuilder();
                for (int i = 0; i < Solution.solution(candies, money).size() - 1; i++) {
                    a.append(Solution.solution(candies, money).get(i).name).append(" ");
                }
                System.out.println("Список конфет: " + a);
                System.out.println("Покупка конфет на " + (Solution.solution(candies, money).size() - 1) + " кг");
                System.out.println("Сдача: " + Solution.solution(candies, money).get(Solution.solution(candies, money ).size() - 1).price + " руб");
            }
        }
    }
}
