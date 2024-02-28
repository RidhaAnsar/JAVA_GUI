//TEXTFIELD
import java.io.*;
import java.awt.*;
import java.awt.event.*;
class CTF extends Frame implements ActionListener {
	Button b1, b2,b3;
	TextField t1,t2;
	public CTF() {
		super("TEXTFIELD DEMO");
		t1=new TextField(10);
		t2=new TextField(10);
		b1=new Button("Move");
		b2=new Button("Exit");
	setLayout(new FlowLayout());
	add(t1);
	add(t2);
	add(b1);
	add(b2);
	b1.addActionListener(this);
	b2.addActionListener(this);
	setSize(500,500);
	setVisible(true);
}
public void actionPerformed(ActionEvent ae) {
	if(ae.getSource()==b1) {
	String str=t1.getText();
	t1.setText(str); 
}
  else if(ae.getSource()==b3) {
	System.exit(0); } } }

class Textfieldemo {	
	public static void main(String args[]) {
	CTF obj=new CTF();
} }

