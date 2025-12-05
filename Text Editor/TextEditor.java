import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Execute
{
    File currentFile = null;   // to remember the file for "Save"

    Execute()
    {
        JFrame f = new JFrame("Text Editor in Java by Besto");
        f.setSize(1366,768);
        f.setLayout(new FlowLayout());

        JButton saveas= new JButton("Save As");
        JButton save = new JButton("Save");
        JButton open = new JButton("Open");

        JTextArea ta = new JTextArea(50,50);
        ta.setLineWrap(true);
        ta.setWrapStyleWord(true);

        // ------------------ SAVE AS -----------------------
        saveas.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                JFileChooser fc = new JFileChooser();
                int result = fc.showSaveDialog(f);

                if (result == JFileChooser.APPROVE_OPTION)
                {
                    currentFile = fc.getSelectedFile();
                    try (FileWriter fw = new FileWriter(currentFile))
                    {
                        fw.write(ta.getText());
                    }
                    catch (Exception ex) { ex.printStackTrace(); }
                }
            }
        });

        // --------------------- SAVE -----------------------
        save.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e)
            {
                if (currentFile == null)
                {
                    JOptionPane.showMessageDialog(f,
                        "Use Save As first (no file selected yet)");
                    return;
                }
                
                try (FileWriter fw = new FileWriter(currentFile))
                {
                    fw.write(ta.getText());
                }
                catch (Exception ex) { ex.printStackTrace(); }
            }
        });

        // ---------------------- OPEN -----------------------
        open.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                JFileChooser fc = new JFileChooser();
                int result = fc.showOpenDialog(f);

                if (result == JFileChooser.APPROVE_OPTION)
                {
                    currentFile = fc.getSelectedFile();

                    try (BufferedReader br = new BufferedReader(new FileReader(currentFile)))
                    {
                        ta.setText("");   // clear
                        String line;
                        while ((line = br.readLine()) != null)
                            ta.append(line + "\n");
                    }
                    catch (Exception ex) { ex.printStackTrace(); }
                }
            }
        });

        f.add(saveas);
        f.add(save);
        f.add(open);
        f.add(new JScrollPane(ta));  // scrollable editor

        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

public class TextEditor
{
    public static void main(String[] args)
    {
        new Execute();
    }
}
