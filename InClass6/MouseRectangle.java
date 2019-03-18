//Evan Swanson
//Inclass 6, 3/18/2019
//Draw a rectangle where clicked

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/**
   This applet demonstrates how mouse events and mouse
   motion events can be handled. It lets the user draw
   boxes by dragging the mouse.
*/

public class MouseRectangle extends JApplet
{
   private int currentX = 0; // Mouse cursor's X position
   private int currentY = 0; // Mouse cursor's Y position
   private int width = 40;    // The rectangle's width
   private int height = 20;   // The rectangle's height
               
   /**
      init method
   */
   
   public void init()
   {
      // Add a mouse listener and a mouse motion listener.
      addMouseListener(new MyMouseListener());
   }
   
   /**
      paint method
      @param g The applet's Graphics object.
   */
   
   public void paint(Graphics g)
   {
      // Call the superclass's paint method.
      super.paint(g);
      
      // Draw a rectangle.
      g.drawRect(currentX, currentY, width, height);
   }
   
   /**
      Mouse listener class
   */

   private class MyMouseListener
                       implements MouseListener
   {
      public void mousePressed(MouseEvent e)
      {
         // Get the mouse cursor coordinates.
         currentX = e.getX();
         currentY = e.getY();
         repaint();
      }

      //
      // The following methods are unused, but still
      // required by the MouseListener interface.
      //

      public void mouseClicked(MouseEvent e)
      {
      }

      public void mouseReleased(MouseEvent e)
      {
      }

      public void mouseEntered(MouseEvent e)
      {
      }

      public void mouseExited(MouseEvent e)
      {
      }
   }
   
   /**
      Mouse Motion listener class
   */

}