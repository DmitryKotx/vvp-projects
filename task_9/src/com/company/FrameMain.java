package com.company;


import com.util.ArrayUtils;
import com.util.JTableUtils;
import com.util.SwingUtils;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class FrameMain extends JFrame {
    private JPanel panelMain;
    private JTable tableInput1;
    private JTable tableInput2;
    private JButton buttonLoadInputFromFile1;
    private JButton buttonResult;
    private JTable result;
    private JButton buttonSaveOutputIntoFile;


    private JFileChooser fileChooserOpen;
    private JFileChooser fileChooserSave;
    private JMenuBar menuBarMain;
    private JMenu menuLookAndFeel;


    public FrameMain() {
        this.setTitle("FrameMain");
        this.setContentPane(panelMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();

        JTableUtils.initJTableForArray(tableInput1, 40, false, true, false, true);
        tableInput1.setRowHeight(25);
        JTableUtils.initJTableForArray(tableInput2, 40, false, true, false, true);
        tableInput2.setRowHeight(25);
        JTableUtils.initJTableForArray(result, 40, true, true, true, true);
        result.setRowHeight(25);

        fileChooserOpen = new JFileChooser();
        fileChooserSave = new JFileChooser();
        fileChooserOpen.setCurrentDirectory(new File("."));
        fileChooserSave.setCurrentDirectory(new File("."));
        FileFilter filter = new FileNameExtensionFilter("Text files", "txt");
        fileChooserOpen.addChoosableFileFilter(filter);
        fileChooserSave.addChoosableFileFilter(filter);

        fileChooserSave.setAcceptAllFileFilterUsed(false);
        fileChooserSave.setDialogType(JFileChooser.SAVE_DIALOG);
        fileChooserSave.setApproveButtonText("Save");

        menuBarMain = new JMenuBar();
        setJMenuBar(menuBarMain);

        menuLookAndFeel = new JMenu();
        menuLookAndFeel.setText("Вид");
        menuBarMain.add(menuLookAndFeel);
        SwingUtils.initLookAndFeelMenu(menuLookAndFeel);

        JTableUtils.writeArrayToJTable(tableInput1, new int[][]{
        });
        this.pack();
        JTableUtils.writeArrayToJTable(tableInput2, new int[][]{
        });
        this.pack();

        buttonLoadInputFromFile1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    if (fileChooserOpen.showOpenDialog(panelMain) == JFileChooser.APPROVE_OPTION) {
                        int[][] arr = ArrayUtils.readIntArray2FromFile(fileChooserOpen.getSelectedFile().getPath());
                        JTableUtils.writeArrayToJTable(tableInput1, arr[0]);
                        JTableUtils.writeArrayToJTable(tableInput2, arr[1]);
                    }
                } catch (Exception e) {
                    SwingUtils.showErrorMessageBox(e);
                }
            }
        });
        buttonSaveOutputIntoFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    if (fileChooserSave.showSaveDialog(panelMain) == JFileChooser.APPROVE_OPTION) {
                        int[] arr = JTableUtils.readIntArrayFromJTable(result);
                        String file = fileChooserSave.getSelectedFile().getPath();
                        if (!file.toLowerCase().endsWith(".txt")) {
                            file += ".txt";
                        }
                        ArrayUtils.writeArrayToFile(file, arr);
                    }
                } catch (Exception e) {
                    SwingUtils.showErrorMessageBox(e);
                }
            }
        });

        buttonResult.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    int[] arr1 = JTableUtils.readIntArrayFromJTable(tableInput1);
                    int[] arr2 = JTableUtils.readIntArrayFromJTable(tableInput2);
                    List<Integer> list1 = new ArrayList<>();
                    List<Integer> list2 = new ArrayList<>();
                    for (int j = 0; j < arr1.length; j++) {
                        list1.add(arr1[j]);
                    }
                    for (int k = 0; k < arr2.length; k++) {
                        list2.add(arr2[k]);
                    }
                    int[] arr = new int [Solution.solution(list1, list2).size()];
                    for (int i = 0; i < Solution.solution(list1, list2).size(); i++) {
                       arr[i] = Solution.solution(list1, list2).get(i);
                    }
                    JTableUtils.writeArrayToJTable(result, arr);
                } catch (Exception e) {
                    SwingUtils.showErrorMessageBox(e);
                }
            }
        });

    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panelMain;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
