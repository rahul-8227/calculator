/*LOGIC: This program parse string into integer  
to get two numbers and save the operator  in the string which user 
enter and perform that operation on the numbers then
again parse integer into the string to print the result.*/

//***************************CALCULATOR*******************************


import java.awt.*;
import java.awt.event.*;         //importing packages




class Calculator extends Frame implements ActionListener{            //source and listener


   TextField b = new TextField(20);
   Button list[] = new Button[16];


   //variables
   String msg ="0"; 
   String msg2 ="";
   String msg3 ="";
   String msg4 ="";
   String operator =" "; 


   int num=0;
   int num2=0;






   public Calculator()              //constructor
 {


    setLayout(new FlowLayout());


    Panel p = new Panel();       //creating object of panel


    b.setEditable(false);
    add(b);                         //adding  TextField


    b.addActionListener(this);
   
   
   
   list[0] = new Button("0");
   list[1] = new Button("1");
   list[2] = new Button("2");
   list[3] = new Button("3");
   list[4] = new Button("4");
   list[5] = new Button("5");
   list[6] = new Button("6");
   list[7] = new Button("7");
   list[8] = new Button("8");
   list[9] = new Button("9");
   list[10] = new Button("+");
   list[11] = new Button("-");
   list[12] = new Button("*");
   list[13] = new Button("/");
   list[14] = new Button("=");
   list[15] = new Button("C");


   for(int i=0;i<16;i++){


   list[i].addActionListener(this);
   }




   p.setLayout(new GridLayout(4,4,30,30));

   
   for(int i=0;i<16;i++){


   p.add(list[i]);
   }




   add(p);                        //adding panel to frame










  addWindowListener(new WindowAdapter(){


  public void windowClosing(WindowEvent we){


  System.exit(0);
  }
  });


 }




public void actionPerformed(ActionEvent ae){


// handling when a number( 0,1,2,3,4,5,6,7,8,9) is pressed


for(int i =0; i<=9;i++)
{
     if(ae.getSource() == list[i])
  {
      if(msg.isEmpty())
   {
       msg2+= list[i].getLabel();
       msg3+= msg2;
       msg2 = "";
       b.setText(msg3);
   }
  
   else{
   msg += list[i].getLabel();
   b.setText(msg);


   }


  }
}


// when operator is pressed


if(ae.getSource() == list[10])
{


   if(msg.length()>=1)
  { 
       num = Integer.parseInt(msg);
       msg = "";
  }


  operator= list[10].getLabel();
  msg2 += num+ operator;
  msg3 = msg2;
  b.setText(msg2);
  msg2="";
}


if(ae.getSource() == list[11])
{


if(msg.length()>=1)
  { 
       num = Integer.parseInt(msg);
       msg = "";
  }


  operator= list[11].getLabel();
  msg2 += num+ operator;
  msg3 = msg2;
  b.setText(msg2);
  msg2="";
}


if(ae.getSource() == list[12])
{


if(msg.length()>=1)
  { 
       num = Integer.parseInt(msg);
       msg = "";
  }


  operator= list[12].getLabel();
  msg2 += num+ operator;
  msg3 = msg2;
  b.setText(msg2);
  msg2="";
}


if(ae.getSource() == list[13])
{


if(msg.length()>=1)
  { 
       num = Integer.parseInt(msg);
       msg = "";
  }


  operator= list[13].getLabel();
  msg2 += num+ operator;
  msg3 = msg2;
  b.setText(msg2);
  msg2="";
}


// when equal(=) is pressed to print the result in text field  


if(ae.getSource() == list[14])
{
   if(operator=="+")
   {
      String part[] = msg3.split("\\+");


      String part2 = part[1];
      num2 = Integer.parseInt(part2);


      msg4 =String.valueOf(num + num2);
      b.setText(msg4);
   }


   if(operator=="-")
   {
      String part[] = msg3.split("\\-");


      String part2 = part[1];
      num2 = Integer.parseInt(part2);


      msg4 = String.valueOf(num -num2);
      b.setText(msg4);
   }


   if(operator=="*")
  {
    String part[] = msg3.split("\\*");


    String part2 = part[1];
    num2 = Integer.parseInt(part2);


    msg4 = String.valueOf(num*num2);
    b.setText(msg4);
  }




  if(operator=="/")
  {
    String part[] = msg3.split("\\/");


    String part2 = part[1];
    num2 = Integer.parseInt(part2);


    try{
    if(num2==0)
    throw new ArithmeticException();
    }
    catch(ArithmeticException a)
    {
         msg4= " ERROR !!! Div by 0 . PRESS C";
         b.setText(msg4);
    }


    msg4 =String.valueOf(num/num2);
    b.setText(msg4);
    }


 }


// when C is pressed to clear eveything 


if(ae.getSource() == list[15])
{


 msg = "0";
 msg3="";
 msg2="";
 num=0;
 num2 = 0;
 b.setText(msg);
}


}


  public static void main(String args[])
  {


          Calculator c = new Calculator();
          c.setSize(new Dimension(260,250));
          c.setBackground(Color.GREEN);
          c.setTitle("CALCULATOR");
          c.setVisible(true);
  }
}