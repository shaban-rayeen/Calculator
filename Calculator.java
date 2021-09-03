import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Calculator implements ActionListener{
	Frame f;
	JButton[] btn;
	TextField tf;
	String[] bv;
	int i, x, y, row;
	String value;
	Calculator(String s, int w, int h){
		f = new Frame(s);
		tf = new TextField();
		tf.setBounds(25,70,247, 70);
		f.add(tf);
		bv = new String[]{"MC", "MR", "MS", "M+", "M-", "\u2190", "CE", "C", "\u00B1", "\u221A", "7", "8", "9", "/", "%", "4", "5", "6", "*", "1/x", "1", "2","3", "-", "=", "0", ".", "+"};
		btn = new JButton[bv.length];
		for(i=0, x = 25, y = 150, row = 1; i < bv.length; i++, x+=50, row++){
			btn[i] = new JButton(bv[i]);
			btn[i].setBounds(x, y, 45, 35);
			btn[i].setFont(new Font("", Font.PLAIN, 14));
			btn[i].addActionListener(this);
			
		
			/*btn[i].addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					tf.setText("Welcome");
				}
			});*/
			
			f.add(btn[i]);
			if(row == 5){ x = -25; 	y = (y +40); row = 0;	}
		}
		f.setSize(w,h);
		f.setLayout(null);
		f.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icon.png")));
		f.setVisible(true);
		
	}
	
	public static void main(String...a){
		new Calculator("WASP Calculator", 300, 420);
	}

	   
	

	public void actionPerformed(ActionEvent e){
		JButton button = (JButton)e.getSource();
		String btnVal = button.getText();
		
		String value = tf.getText();
		
		
		if(btnVal.equals("=")){
			String s1 = doArithmatic(value);
			tf.setText(s1);
			value="";
		}
		else if(btnVal == "C"){
			tf.setText("");
		}
		else{
			value+= button.getText();
			System.out.println(value);
			tf.setText(value);
		}
		
		
	}
	
	

	public String doArithmatic(String s){
		char[] c = s.toCharArray();
		String sb = "";
		int sum  = 0;
		String cal = "";
		double calculated = 0;
		if(c[i] <48 || c[i] > 57){ return "";}
		for(int i=0; i < c.length; i++){
			
			if(c[i] == '+'){
				calculated += Double.parseDouble(sb);
				sb = "";
			}else if(c[i] == '*'){
				if(calculated == 0){ calculated = 1; }
				calculated *= Double.parseDouble(sb);
				sb = "";
			}
			else if(c[i] == '/'){
				if(calculated == 0){ calculated = 1; }
				calculated = Double.parseDouble(sb) / calculated;
				sb = "";
			}
			else if(c[i] == '-'){
				calculated = Double.parseDouble(sb) - calculated;
				sb = "";
			}
			else if((c.length - 1) == i){
				sb += c[i];
				calculated = findAndCalculate(c, sb, calculated);
				sb="";
			}else{
				sb+=c[i];
			}
		}
		cal = Double.toString(calculated);
		calculated = 0;
		return cal;
	}
	
	public double findAndCalculate(char[] c, String sb,double calculated){
		
		for(int i=c.length-1; i>=0; i--){
			if(c[i] == '+'){
				return calculated += Double.parseDouble(sb);
			}else if(c[i] == '*'){
				return calculated *= Double.parseDouble(sb);
			}
			else if(c[i] == '/'){
				return calculated /= Double.parseDouble(sb);
			}
			else if(c[i] == '-'){
				return calculated = calculated - Double.parseDouble(sb);
			}
		}
		return calculated;
	}
	 
	
	
}