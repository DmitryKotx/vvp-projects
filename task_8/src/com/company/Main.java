package com.company;

import com.util.ArrayUtils;
import com.util.SwingUtils;

import java.io.PrintStream;
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
            int[][] arr2 = ArrayUtils.readIntArray2FromFile(params.inputFile);
            if (arr2 == null) {
                System.err.printf("Can't read array from \"%s\"%n", params.inputFile);
                System.exit(2);
            } else {
                String a = Boolean.toString(Solution.solution(arr2));
                PrintStream out = (params.outputFile != null) ? new PrintStream(params.outputFile) : System.out;
                out.println(a);
                out.close();
            }
        }
    }
}
