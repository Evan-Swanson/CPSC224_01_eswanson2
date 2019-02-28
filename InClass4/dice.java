//Evan Swanson
//Inclass Assignment 4, 2/21/2019
//Dice simulator

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

/**
   This class demonstrates how to use an ImageIcon
   and a JLabel to display an image.
*/

public class dice extends JFrame
{
   private JPanel imagePanel;     // To hold the label
   private JPanel buttonPanel;    // To hold a button
   private JLabel imageLabel;     // To show an image
   private JLabel imageLabel2;
   private JButton button;        // To get an image


   /**
      Constructor
   */

   public dice()
   {
      // Set the title.
      setTitle("Dice simulator");

      // Specify an action for the close button.
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      // Create a BorderLayout manager.
      setLayout(new BorderLayout());

      // Build the panels.
      buildImagePanel();
      buildButtonPanel();

      // Add the panels to the content pane.
      add(imagePanel, BorderLayout.CENTER);
      add(buttonPanel, BorderLayout.SOUTH);

      // Pack and display the window.
      pack();
      setVisible(true);
   }

   /**
      The buildImagePanel method adds a label to a panel.
   */

   private void buildImagePanel()
   {
      // Create a panel.
      imagePanel = new JPanel();

      // Create a label.
      ImageIcon dieImage1 = new ImageIcon("Die1.png");
      ImageIcon dieImage2 = new ImageIcon("Die1.png");
      imageLabel = new JLabel(dieImage1);
      imageLabel2 = new JLabel(dieImage2);
      
      // Add the label to the panel.
      imagePanel.add(imageLabel);
      imagePanel.add(imageLabel2);
   }

   /**
      The buildButtonPanel method adds a button
      to a panel.
   */

   private void buildButtonPanel()
   {
      // Create a panel.
      buttonPanel = new JPanel();

      // Create a button.
      button = new JButton("Roll the dice");

      // Register an action listener with the button.
      button.addActionListener(new ButtonListener());

      // Add the button to the panel.
      buttonPanel.add(button);
   }

   /**
      Private inner class that handles the event when
      the user clicks the button.
   */

   private class ButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         Random rand = new Random();
         int n = rand.nextInt(6) + 1;

         // Read the image file into an ImageIcon object.
         ImageIcon newImage = new ImageIcon("Die" + Integer.toString(n) + ".png");

         // Display the image in the label.
         imageLabel.setIcon(newImage);

         n = rand.nextInt(6) + 1;
         // Read the image file into an ImageIcon object.
         newImage = new ImageIcon("Die" + Integer.toString(n) + ".png");
         imageLabel2.setIcon(newImage);

         // Pack the frame again to accomodate the 
         // new size of the label.
         pack();
      }
   }
   
   /**
      The main method creates an instance of the
      MyCatImage class which causes it to display
      its window.
   */
   public static void main(String[] args)
   {
      new dice();
   }
}