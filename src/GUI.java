import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;

/**
 * Created by Arne on 01-Oct-16.
 */
public class GUI {
    private static int giantRunCount;
    private static int giantWinCount;
    private static int dragonRunCount;
    private static int dragonWinCount;
    private static int necroRunCount;
    private static int necroWinCount;
    private JButton giantRun;
    private JButton dragonRun;
    private JButton necroRun;
    private JButton dragonWin;
    private JButton giantWin;
    private JButton necroWin;
    private JTextField giantSuccess;
    private JTextField dragonSuccess;
    private JTextField necroSuccess;
    private JPanel Panel;

    public void reloadFields(){
        giantSuccess.setText((giantRunCount>0?""+(double)giantWinCount/giantRunCount:""+0)+" ("+giantWinCount+"/"+giantRunCount+")");
        dragonSuccess.setText((dragonRunCount>0?""+(double)dragonWinCount/dragonRunCount:""+0)+" ("+dragonWinCount+"/"+dragonRunCount+")");
        necroSuccess.setText((necroRunCount>0?""+(double)necroWinCount/necroRunCount:""+0)+" ("+necroWinCount+"/"+necroRunCount+")");
    }

    public GUI() {
        giantRun.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                ++giantRunCount;
                reloadFields();
            }
        });
        giantWin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                ++giantWinCount;
                reloadFields();
            }
        });
        dragonRun.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                ++dragonRunCount;
                reloadFields();
            }
        });
        dragonWin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                ++dragonWinCount;
                reloadFields();
            }
        });
        necroRun.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                ++necroRunCount;
                reloadFields();
            }
        });
        necroWin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                ++necroWinCount;
                reloadFields();
            }
        });
        reloadFields();
    }

    public static void main(String[] args) {
        Scanner s = null;
        try {
            s = new Scanner(new BufferedReader(new FileReader("RunValues.txt")));
            if(s.hasNextInt())
                giantRunCount = s.nextInt();
            if(s.hasNextInt())
                giantWinCount = s.nextInt();
            if(s.hasNextInt())
                dragonRunCount = s.nextInt();
            if(s.hasNextInt())
                dragonWinCount = s.nextInt();
            if(s.hasNextInt())
                necroRunCount = s.nextInt();
            if(s.hasNextInt())
                necroWinCount = s.nextInt();
        } catch (FileNotFoundException e) {
        } finally {
            if (s != null) {
                s.close();
            }
        }
        JFrame frame = new JFrame("GUI");
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                PrintWriter writer = null;
                try {
                    writer = new PrintWriter("RunValues.txt", "UTF-8");
                    writer.println(giantRunCount);
                    writer.println(giantWinCount);
                    writer.println(dragonRunCount);
                    writer.println(dragonWinCount);
                    writer.println(necroRunCount);
                    writer.println(necroWinCount);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                } finally {
                    writer.close();
                }
                System.exit(0);
            }
        });
        frame.setContentPane(new GUI().Panel);
        frame.setTitle("RandomSW");
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setAlwaysOnTop(true);
    }
}
