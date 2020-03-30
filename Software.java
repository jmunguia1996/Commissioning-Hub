import java.io.*;
import java.lang.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Desktop;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.URI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class Software{

  public static void main(String[] args) {

    String programPath = System.getProperty("user.dir");
    File libCheck = new File(programPath + "\\lib");
    if(libCheck.exists() == false){
      try{
        Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"jar xf lib.zip && exit \"");
      }
      catch(IOException ex){
				System.out.println (ex.toString());
				System.out.println("Could not find file");
			}
    }
    JFrame f = new JFrame("Commissioner Program Shortcuts V1.0.0");
    f.getContentPane().setBackground(new Color(0, 0, 0));
    f.setLocation(0,0);
    f.setLayout(new GridLayout(0, 4, 10, 15));
    UIManager.put("Button.select", new Color(43, 39, 39));
    final JButton vibeViewButton = new JButton("VibeView");
    vibeViewButton.setBackground(new Color(43, 39, 39));
    vibeViewButton.setForeground(new Color(255, 243, 133));
    vibeViewButton.setFocusPainted(false);
    final JButton vibeReviewButton = new JButton("VibeReview");
    vibeReviewButton.setBackground(new Color(43, 39, 39));
    vibeReviewButton.setForeground(new Color(255, 243, 133));
    vibeReviewButton.setFocusPainted(false);
    final JButton sssConsoleButton = new JButton("SSS Console");
    sssConsoleButton.setBackground(new Color(43, 39, 39));
    sssConsoleButton.setForeground(new Color(255, 243, 133));
    sssConsoleButton.setFocusPainted(false);
    final JButton mfmDataConverterButton = new JButton("MFM for Flow Jig");
    mfmDataConverterButton.setBackground(new Color(43, 39, 39));
    mfmDataConverterButton.setForeground(new Color(255, 243, 133));
    mfmDataConverterButton.setFocusPainted(false);
    final JButton sssHMIButton = new JButton("SSS HMI Launch Window");
    sssHMIButton.setBackground(new Color(43, 39, 39));
    sssHMIButton.setForeground(new Color(255, 243, 133));
    sssHMIButton.setFocusPainted(false);
    final JButton excelMacrosButton = new JButton("Excel Programs");
    excelMacrosButton.setBackground(new Color(43, 39, 39));
    excelMacrosButton.setForeground(new Color(255, 243, 133));
    excelMacrosButton.setFocusPainted(false);
    final JButton aSiMonButton = new JButton("AS-iMon");
    aSiMonButton.setBackground(new Color(43, 39, 39));
    aSiMonButton.setForeground(new Color(255, 243, 133));
    aSiMonButton.setFocusPainted(false);
    final JButton stkConverterButton = new JButton("STK Data Converter");
    stkConverterButton.setBackground(new Color(43, 39, 39));
    stkConverterButton.setForeground(new Color(255, 243, 133));
    stkConverterButton.setFocusPainted(false);
    final JButton xGVisionButton = new JButton("XGVision Camera");
    xGVisionButton.setBackground(new Color(43, 39, 39));
    xGVisionButton.setForeground(new Color(255, 243, 133));
    xGVisionButton.setFocusPainted(false);
    f.add(vibeViewButton);
    vibeViewButton.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
			try{
				Runtime.getRuntime().exec(programPath + "\\lib\\VibeView.exe");
			}
			catch(IOException ex){
				System.out.println (ex.toString());
				System.out.println("Could not find file");
			}
        }
    });
	f.add(vibeReviewButton);
    vibeReviewButton.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            try{
				Runtime.getRuntime().exec(programPath + "\\lib\\VibeReview.exe");
			}
			catch(IOException ex){
				System.out.println (ex.toString());
				System.out.println("Could not find file");
			}
        }
    });
	f.add(sssConsoleButton);
    sssConsoleButton.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            try{
				Runtime.getRuntime().exec("cmd /c start \"\" .\\lib\\SSSConsoleWorkaround.bat");
        Desktop.getDesktop().open(new File(programPath + "\\lib\\SSS_Console"));
			}
			catch(IOException ex){
				System.out.println (ex.toString());
				System.out.println("Could not find file");
			}
        }
    });
	f.add(mfmDataConverterButton);
    mfmDataConverterButton.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            try{
              Runtime.getRuntime().exec(programPath + "\\lib\\MFM_Data_Converter_Horiba_V3.10\\MFM_Data_Converter_Horiba_V3.10.exe");
              Desktop.getDesktop().open(new File(programPath + "\\lib\\MFM_Data_Converter_Horiba_V3.10\\Pattern Lists"));
            }
			catch(IOException ex){
        System.out.println (ex.toString());
				System.out.println("Could not find file");
      }
    }
    });
    f.add(sssHMIButton);
      sssHMIButton.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
          try{
            URI hmi = new URI("http://10.32.158.11/?lang=en");
            java.awt.Desktop.getDesktop().browse(hmi);
          }
        catch(Exception ex){
            ex.printStackTrace();
      }
    }
    });
    f.add(excelMacrosButton);
    excelMacrosButton.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e){
        try{
          Desktop.getDesktop().open(new File(programPath + "\\lib\\Excel Programs"));
        }
        catch(IOException ex){
          System.out.println (ex.toString());
  				System.out.println("Could not find file");
        }
      }
    });
    f.add(aSiMonButton);
    aSiMonButton.addActionListener(new ActionListener(){

      @Override
      public void actionPerformed(ActionEvent e){
        try{
          Runtime.getRuntime().exec(programPath + "\\lib\\asimon\\ASiMon3.exe");
        }
        catch(IOException ex){
          System.out.println (ex.toString());
  				System.out.println("Could not find file");
        }
      }
    });
    f.add(stkConverterButton);
    stkConverterButton.addActionListener(new ActionListener(){

      @Override
      public void actionPerformed(ActionEvent e){
        try{
          Runtime.getRuntime().exec(programPath + "\\lib\\STK Learn Data Calculator_v2.0.0.2.exe");
        }
        catch(IOException ex){
          System.out.println (ex.toString());
  				System.out.println("Could not find file");
        }
      }
    });
    f.add(xGVisionButton);
    xGVisionButton.addActionListener(new ActionListener(){

      @Override
      public void actionPerformed(ActionEvent e){
        try{
          Runtime.getRuntime().exec(programPath + "\\lib\\XG VisionTerminal\\XG VisionTerminal.exe");
        }
        catch(IOException ex){
          System.out.println (ex.toString());
  				System.out.println("Could not find file");
        }
      }
    });

    f.pack();
    f.setVisible(true);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

  }

}
