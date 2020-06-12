import java.io.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Desktop;
import java.awt.*;

import javax.swing.*;
import java.net.URI;

import javax.swing.JButton;
import javax.swing.JFrame;


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
				System.out.println("Could not execute");
			}
    }
    JFrame mainWindow = new JFrame("Commissioner Program Shortcuts V2.0.0");
    mainWindow.getContentPane().setBackground(new Color(0, 0, 0));
    mainWindow.setLocation(0,0);
    mainWindow.setLayout(new GridLayout(0, 4, 10, 15));
    UIManager.put("Button.select", new Color(43, 39, 39));
    final GUIButton vibeViewButton = new GUIButton("VibeView");
    mainWindow.add(vibeViewButton);
    final GUIButton vibeReviewButton = new GUIButton("VibeReview");
    mainWindow.add(vibeReviewButton);
    final GUIButton sssConsoleButton = new GUIButton("SSS Console");
    mainWindow.add(sssConsoleButton);
    final GUIButton mfmDataConverterButton = new GUIButton("MFM for Flow Jig");
    mainWindow.add(mfmDataConverterButton);
    final GUIButton sssHMIButton = new GUIButton("SSS HMI Launch Window");
    mainWindow.add(sssHMIButton);
    final GUIButton excelMacrosButton = new GUIButton("Excel Programs");
    mainWindow.add(excelMacrosButton);
    final GUIButton aSiMonButton = new GUIButton("AS-iMon");
    mainWindow.add(aSiMonButton);
    final GUIButton stkConverterButton = new GUIButton("STK Data Converter");
    mainWindow.add(stkConverterButton);
    final GUIButton xGVisionButton = new GUIButton("XGVision Camera");
    mainWindow.add(xGVisionButton);
    final GUIButton ipButtons = new GUIButton("Show IP Switches");
    mainWindow.add(ipButtons);

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
    ipButtons.addActionListener(new ActionListener(){

      @Override
      public void actionPerformed(ActionEvent e){
        try{
          ipWindowBuilder(mainWindow);
        }
        catch(Exception ex){
          System.out.println (ex.toString());
  				System.out.println("Problem loading buttons, please contact maintainer.");
        }
      }
    });

    mainWindow.pack();
    mainWindow.setVisible(true);
    mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

  }

  private static void ipWindowBuilder(JFrame name){
    JFrame ipWindow = new JFrame("IP Switches");
    ipWindow.setLocationRelativeTo(name);
    ipWindow.getContentPane().setBackground(new Color(0, 0, 0));
    ipWindow.setLayout(new GridLayout(0, 3, 10, 15));
    final GUIButton mainSSS = new GUIButton("Switch to main SSS IP");
    ipWindow.add(mainSSS);
    final GUIButton altSSS = new GUIButton("Switch to alternate SSS IP");
    ipWindow.add(altSSS);
    final GUIButton flowJig = new GUIButton("Switch to Flow Jig IP");
    ipWindow.add(flowJig);

    mainSSS.addActionListener(new ActionListener(){

      @Override
      public void actionPerformed(ActionEvent e) {
        try{
          Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"netsh interface ip set address name=\"Ethernet\" static 172.16.1.231 255.255.240.0 172.16.1.254 && exit \"");
        }
        catch(IOException ex){
          System.out.println (ex.toString());
          System.out.println("Could not execute");
        }
      }
    });
    
    altSSS.addActionListener(new ActionListener(){

      @Override
      public void actionPerformed(ActionEvent e) {
        try{
          Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"netsh interface ip set address name=\"Ethernet\" static 172.16.1.232 255.255.240.0 172.16.1.254 && exit \"");
        }
        catch(IOException ex){
          System.out.println (ex.toString());
          System.out.println("Could not execute");
        }
      }
    });

    flowJig.addActionListener(new ActionListener(){

      @Override
      public void actionPerformed(ActionEvent e) {
        try{
          Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"netsh int ip set address name=\"Ethernet\" static address=192.168.10.10 mask=255.255.240.0 && exit \"");
        }
        catch(IOException ex){
          System.out.println (ex.toString());
          System.out.println("Could not execute");
        }
      }
    });

    ipWindow.pack();
    ipWindow.setVisible(true);
    ipWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

  }

}

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
