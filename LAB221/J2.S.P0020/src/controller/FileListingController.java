/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import view.FileListingForm;

/**
 *
 * @author vanhv
 */
public class FileListingController {

    public FileListingController(FileListingForm view) {

        view.setTitle("File listing");
        view.setLocationRelativeTo(null);
        view.setVisible(true);

        listFile(view);
        readTxtFile(view);
    }

    private void Files(FileListingForm view) {
        String directory = view.getTxtPath().getText();
        try {
            File file = new File(directory);
            if (file.exists()) {
                String[] files = file.list();
                view.getListBox().setListData(files);
            } else {
                throw new Exception();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "File path not exist !");
        }
    }

    private void listFile(FileListingForm view) {
        //Get list file by directory
        view.getBtnList().addActionListener((ActionEvent e) -> {
            Files(view);
        });

        //Update data file
        view.getBtnUpdate().addActionListener(((e) -> {
            try {
                String directory = view.getTxtPath().getText();
                String selectionFile = view.getListBox().getSelectedValue();
                String filePath = directory + "\\" + selectionFile;
                File file = new File(filePath);

                FileWriter fw = new FileWriter(filePath);
                fw.write(view.getTxtArea().getText());
                fw.close();

                view.getLblName().setText(file.getName());
                view.getLblSize().setText(view.getTxtArea().getText().length() + "");
                JOptionPane.showMessageDialog(null, "Update successful !");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }));

        //Delete selected file
        view.getBtnDelete().addActionListener((e) -> {

            String directory = view.getTxtPath().getText();
            String selectionFile = view.getListBox().getSelectedValue();
            String filePath = directory + "\\" + selectionFile;
            File file = new File(filePath);

            if (file.delete()) {
                JOptionPane.showMessageDialog(null, "Delete file " + file.getName());
                Files(view);
            } else {
                JOptionPane.showMessageDialog(null, "Failed to delete file " + filePath);
            }
        });
    }

    private void readTxtFile(FileListingForm view) {
        view.getListBox().addListSelectionListener((ListSelectionEvent e) -> {
            if (view.getListBox().getSelectedValue() != null) {

                String directory = view.getTxtPath().getText();
                String selectionFile = view.getListBox().getSelectedValue();
                String filePath = directory + "\\" + selectionFile;

                File file = new File(filePath);

                if (file.exists() && filePath.endsWith(".txt")) {
                    StringBuilder sb = new StringBuilder();
                    try {
                        BufferedReader br = new BufferedReader(new FileReader(filePath));
                        String line;
                        while ((line = br.readLine()) != null) {
                            sb.append(line).append("\n");
                        }
                        view.getTxtArea().setText(sb.toString().trim());
                        view.getLblName().setText(file.getName());
                        view.getLblSize().setText(sb.toString().trim().length() + "");
                        br.close();
                    } catch (IOException ex) {
                        Logger.getLogger(FileListingController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Selected file is not a text file, content cannot be shown.");
                }
            }
        });
    }
}
