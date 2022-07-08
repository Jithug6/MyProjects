import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener{

	JFrame theframe;
	JTextField thetextfield;
	JButton[] numberButtons = new JButton[10];
	JButton[] functionButtons = new JButton[9];
	JButton addButton,subButton,mulButton,divButton;
	JButton decButton, equButton, delButton, clrButton, negButton;
	JPanel thepanel;
	
	Font myFont = new Font("Ariel",Font.BOLD,30);
	
	double num1=0,num2=0,result=0;
	char operator;
	
	Calculator(){
		
		theframe = new JFrame("My Calculator");
		theframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		theframe.setSize(420, 550);
		theframe.setLayout(null);
		
		thetextfield = new JTextField();
		thetextfield.setBounds(50, 25, 300, 50);
		thetextfield.setFont(myFont);
		thetextfield.setEditable(false);
		thetextfield.setHorizontalAlignment(JTextField.RIGHT);
		
		addButton = new JButton("+");
		subButton = new JButton("-");
		mulButton = new JButton("*");
		divButton = new JButton("/");
		decButton = new JButton(".");
		equButton = new JButton("=");
		delButton = new JButton("Del");
		clrButton = new JButton("Clr");
		
		functionButtons[0] = addButton;
		functionButtons[1] = subButton;
		functionButtons[2] = mulButton;
		functionButtons[3] = divButton;
		functionButtons[4] = decButton;
		functionButtons[5] = equButton;
		functionButtons[6] = delButton;
		functionButtons[7] = clrButton;
		
		for(int i =0;i<8;i++) {
			functionButtons[i].addActionListener(this);
			functionButtons[i].setFont(myFont);
			functionButtons[i].setFocusable(false);
		}
		
		for(int i =0;i<10;i++) {
			numberButtons[i] = new JButton(String.valueOf(i));
			numberButtons[i].addActionListener(this);
			numberButtons[i].setFont(myFont);
			numberButtons[i].setFocusable(false);
		}
		
		delButton.setBounds(50,410,140,50);
		clrButton.setBounds(210,410,140,50);
		
		thepanel = new JPanel();
		thepanel.setBounds(50, 100, 300, 300);
		thepanel.setLayout(new GridLayout(4,4,10,10));

		thepanel.add(numberButtons[1]);
		thepanel.add(numberButtons[2]);
		thepanel.add(numberButtons[3]);
		thepanel.add(addButton);
		thepanel.add(numberButtons[4]);
		thepanel.add(numberButtons[5]);
		thepanel.add(numberButtons[6]);
		thepanel.add(subButton);
		thepanel.add(numberButtons[7]);
		thepanel.add(numberButtons[8]);
		thepanel.add(numberButtons[9]);
		thepanel.add(mulButton);
		thepanel.add(decButton);
		thepanel.add(numberButtons[0]);
		thepanel.add(equButton);
		thepanel.add(divButton);
		
		theframe.add(thepanel);
		theframe.add(delButton);
		theframe.add(clrButton);
		theframe.add(thetextfield);
		theframe.setVisible(true);
	}
	
	public static void main(String[] args) {
		
		Calculator calc = new Calculator();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		for(int i=0;i<10;i++) {
			if(e.getSource() == numberButtons[i]) {
				thetextfield.setText(thetextfield.getText().concat(String.valueOf(i)));
			}
		}
		if(e.getSource()==decButton) {
			thetextfield.setText(thetextfield.getText().concat("."));
		}
		if(e.getSource()==addButton) {
			num1 = Double.parseDouble(thetextfield.getText());
			operator ='+';
			thetextfield.setText("");
		}
		if(e.getSource()==subButton) {
			num1 = Double.parseDouble(thetextfield.getText());
			operator ='-';
			thetextfield.setText("");
		}
		if(e.getSource()==mulButton) {
			num1 = Double.parseDouble(thetextfield.getText());
			operator ='*';
			thetextfield.setText("");
		}
		if(e.getSource()==divButton) {
			num1 = Double.parseDouble(thetextfield.getText());
			operator ='/';
			thetextfield.setText("");
		}
		if(e.getSource()==equButton) {
			num2=Double.parseDouble(thetextfield.getText());
			
			switch(operator) {
			case'+':
				result=num1+num2;
				break;
			case'-':
				result=num1-num2;
				break;
			case'*':
				result=num1*num2;
				break;
			case'/':
				result=num1/num2;
				break;
			}
			thetextfield.setText(String.valueOf(result));
			num1=result;
		}
		if(e.getSource()==clrButton) {
			thetextfield.setText("");
		}
		if(e.getSource()==delButton) {
			String string = thetextfield.getText();
			thetextfield.setText("");
			for(int i=0;i<string.length()-1;i++) {
				thetextfield.setText(thetextfield.getText()+string.charAt(i));
			}
		}
		
	}
}