//Evan Swanson
//Inclass Assignment 5, 2/27/2019
//Book checkout

import java.io.*;         // Needed for the File class
import java.util.Scanner; // Needed for the Scanner class
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
   This program reads data from a file.
*/

public class bookPrices extends JFrame
{
      private JPanel listOfBooks;
      private JPanel shoppingCart;
      private JPanel buttons;
      private JButton resetCart;
      private JButton addBook;
      private JButton removeBook;
      private JButton checkOut;
      private JList booksJList;
      private JList shoppingCartList;
      private DefaultListModel listModel;
      private String[] bookList;
      private double[] priceList;
      private int index;

   public bookPrices()
   {
      try{
      // Open the file.
      File file = new File("BookPrices.txt");
      Scanner inputFile = new Scanner(file);
      String[] books = new String[20];
      index = 0;



      // Read lines from the file until no more are left.
      while (inputFile.hasNext())
      {
         // Read the next name.
         books[index] = inputFile.nextLine();
         index++;
      }

      bookList = new String[20];
      String [] currentBook;
      priceList = new double[20];

      for(int i = 0; i < index; i++)
      {
         currentBook = books[i].split(","); 
         bookList[i] = currentBook[0];
         priceList[i] = Double.parseDouble(currentBook[1]);
      }

      // Close the file.
      inputFile.close();
      // Set the title.
      setTitle("Book Shopping Cart");

      // Specify an action for the close button.
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      // Create a BorderLayout manager.
      setLayout(new GridLayout(1,3));

      listOfBooks = new JPanel();
      listModel = new DefaultListModel();
      shoppingCart = new JPanel();
      buttons = new JPanel();
      resetCart = new JButton("Clear Cart");
      resetCart.addActionListener(new ButtonListener());
      addBook = new JButton("Add book");
      addBook.addActionListener(new ButtonListener());
      removeBook = new JButton("Remove book");
      removeBook.addActionListener(new ButtonListener());
      checkOut = new JButton("Checkout");
      checkOut.addActionListener(new ButtonListener());
      booksJList = new JList(bookList);
      shoppingCartList = new JList(listModel);
      shoppingCartList.setVisibleRowCount(6);

      listOfBooks.setLayout(new FlowLayout());
      listOfBooks.add(booksJList);
      buttons.setLayout(new FlowLayout());
      buttons.add(addBook);
      buttons.add(removeBook);
      buttons.add(resetCart);
      buttons.add(checkOut);
      shoppingCart.setLayout(new BorderLayout());
      shoppingCart.add(shoppingCartList, BorderLayout.CENTER);
      

      // Add the panels to the content pane.
      add(listOfBooks);
      add(buttons);
      add(shoppingCart);

      // Pack and display the window.
      //pack();
      setSize(800,200);
      setVisible(true);
      }
         catch (FileNotFoundException ex)  
    {
        // insert code to run when exception occurs
    }
   }
      private class ButtonListener implements ActionListener
      {
            public void actionPerformed(ActionEvent e)
            {
               if (e.getSource() == resetCart)
                  listModel.clear();
               else if (e.getSource() == addBook)
               {
                  if (!booksJList.isSelectionEmpty())
                     listModel.addElement(booksJList.getSelectedValue());
               }
               else if (e.getSource() == removeBook)
               {
                  if (!shoppingCartList.isSelectionEmpty())
                  listModel.remove(shoppingCartList.getSelectedIndex());
               }
               else if (e.getSource() == checkOut)
               {
                  double totalPrice = 0;
                  int bookIndex = 0;
                  for(int i = 0; i< shoppingCartList.getModel().getSize();i++)
                  {
                     String current = (String)shoppingCartList.getModel().getElementAt(i);
                     //System.out.println(current);
                     for(int j = 0; j < index; j++)
                     {
                        if(bookList[j].equals(current))
                           bookIndex = j; 
                     }
                     totalPrice += priceList[bookIndex];
                  }
                  JOptionPane.showMessageDialog(null, "SubTotal: $" + totalPrice + "\nTax :$ " + (totalPrice*.06) + "\nTotal: $" + (totalPrice*1.06));
               }
               

            }
            
      }


   public static void main(String[] args) throws IOException
   {
      new bookPrices();
   }
}