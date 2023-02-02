package com.company;

import com.util.ArrayUtils;
import com.util.SwingUtils;

import java.io.PrintStream;
import java.util.ArrayList;
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
                int[] arr1 = arr[0];
                int[] arr2 = arr[1];
                List<Integer> list1 = new ArrayList<>();
                List<Integer> list2 = new ArrayList<>();
                for (int j = 0; j < arr1.length; j++) {
                    list1.add(arr1[j]);
                }
                for (int k = 0; k < arr2.length; k++) {
                    list2.add(arr2[k]);
                }
                int[] arr3 = new int[Solution.solution(list1, list2).size()];
                for (int i = 0; i < Solution.solution(list1, list2).size(); i++) {
                    arr3[i] = Solution.solution(list1, list2).get(i);
                }
                PrintStream out = (params.outputFile != null) ? new PrintStream(params.outputFile) : System.out;
                out.println(ArrayUtils.toString(arr3));
                out.close();
            }
        }
    }
}

