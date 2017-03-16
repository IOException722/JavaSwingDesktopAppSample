package myfirstswing;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.jacob.com.JacobObject;

public class SwingUI extends JPanel{
	
    public void run() { 
    	           final JFrame f = new JFrame("Simple hello Example");
                     JButton save = new JButton("Save");
                     JButton cancel = new JButton("Cancel");
                     save.addActionListener(new ActionListener() {
                         public void actionPerformed(ActionEvent e) {
                             Word word = new Word();
                             String filePath = word.path;
                             String fileName = word.fileName;
                             try {
								AESFileEncryption aesFileEncryption = new AESFileEncryption(filePath, fileName);
								File f = new File(filePath+fileName+".doc");
								word.closeFile();
								deleteFile(f);
                             } catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
                             
           				     System.exit(0);
                         }
                       });
                     
                     cancel.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
						  System.exit(0);
						}
					});
                     
                     JacobObject ob = new JacobObject();
                     JPanel form = new JPanel();
                     f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                     f.getContentPane().add(form, BorderLayout.CENTER);
                     JPanel p1 = new JPanel();
                     JPanel p2 = new JPanel();
                     p1.add(save);
                     p2.add(cancel);
                     f.getContentPane().add(p1, BorderLayout.WEST);
                     f.getContentPane().add(p2, BorderLayout.EAST);

                     f.pack();
                     f.setVisible(true);
    }
    
    private void deleteFile(File tempFile)
    {
    	System.out.println("Attempting to delete " + tempFile.getAbsolutePath());
    	if (!tempFile.exists())
    	  System.out.println("  Doesn't exist");
    	else if (!tempFile.canWrite())
    	  System.out.println("  No write permission");
    	else
    	{
    	  if (tempFile.delete())
    	    System.out.println("  Deleted!");
    	  else
    	    System.out.println("  Delete failed - reason unknown");
    	}
    }
}
