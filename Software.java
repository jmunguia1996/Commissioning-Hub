import java.io.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Desktop;
import java.awt.*;

import javax.swing.*;
import java.net.URI;

import javax.swing.JButton;
import javax.swing.JFrame;


class GUIButton extends JButton{
  /**
   *
   */
  private static final long serialVersionUID = 1L;

  public GUIButton(String text) {
    super(text);
    setBackground(new Color(43, 39, 39));
    setForeground(new Color(255, 243, 133));
    setFocusPainted(false);
  }
}

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
    final GUIButton vibeViewButton = new GUIButton("VibeView");
    final GUIButton vibeReviewButton = new GUIButton("VibeReview");
    final GUIButton sssConsoleButton = new GUIButton("SSS Console");
    final GUIButton mfmDataConverterButton = new GUIButton("MFM for Flow Jig");
    final GUIButton sssHMIButton = new GUIButton("SSS HMI Launch Window");
    final GUIButton excelMacrosButton = new GUIButton("Excel Programs");
    final GUIButton aSiMonButton = new GUIButton("AS-iMon");
    final GUIButton stkConverterButton = new GUIButton("STK Data Converter");
    final GUIButton xGVisionButton = new GUIButton("XGVision Camera");
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
