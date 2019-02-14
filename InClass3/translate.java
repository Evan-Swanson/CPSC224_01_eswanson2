//Evan Swanson
//Inclass Assignment 3, 2/14/2019
//Basic GUI translator

import javax.swing.*;    // Needed for Swing classes
import java.awt.event.*; // Needed for event listener interface

/**
   This class demonstrates how to retrieve the action command
   from an event object.
*/

public class translate extends JFrame
{
   private JButton button1;    // Button 1
   private JButton button2;    // Button 2
   private JButton button3;    // Button 3
   private JPanel panel;       // A panel to hold components
   private JLabel messageLabel;      // To reference a label
   private final int WINDOW_WIDTH = 300; // Window width
   private final int WINDOW_HEIGHT = 100; // Window height

   /**
      Constructor
   */

   public translate()
   {
      // Set the title bar text.
      setTitle("Latin Translator");

      // Set the size of the window.
      setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

      // Specify what happens when the close button is clicked.
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      messageLabel = new JLabel("English translation: ");

      // Create the three buttons.
      button1 = new JButton("Sinister");
      button2 = new JButton("Dexter");
      button3 = new JButton("Medium");

      // Register an event listener with all 3 buttons.
      button1.addActionListener(new ButtonListener());
      button2.addActionListener(new ButtonListener());
      button3.addActionListener(new ButtonListener());

      // Create a panel and add the buttons to it.
      panel = new JPanel();
      panel.add(button1);
      panel.add(button2);
      panel.add(button3);
      panel.add(messageLabel);
      

      // Add the panel to the content pane.
      add(panel);

      // Display the window.
      setVisible(true);
   }

   /**
      Private inner class that handles the event when
      the user clicks a button.
   */

   private class ButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         // Get the action command.
         String actionCommand = e.getActionCommand();

         // Determine which button was clicked and display
         // a message.
         if (actionCommand.equals("Sinister"))
         {
            messageLabel.setText("English translation: Left");
         }
         else if (actionCommand.equals("Dexter"))
         {
            messageLabel.setText("English translation: Right");
         }
         else if (actionCommand.equals("Medium"))
         {
            messageLabel.setText("English translation: Center");
         }
      }
   }
   
   /**
      main method
   */
   
   public static void main(String[] args)
   {
      new translate();
   }
}