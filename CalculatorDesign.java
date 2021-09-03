import java.awt.*;
class CalculatorDesign{
	Frame f;
	Button[] btn;
	TextField tf;
	String[] bv;
	int i, x, y, row;
	CalculatorDesign(String s, int w, int h){
		f = new Frame(s);
		tf = new TextField();
		tf.setBounds(25,70,247, 70);
		f.add(tf);
		bv = new String[]{"MC", "MR", "MS", "M+", "M-", "\u2190", "CE", "C", "\u00B1", "\u221A", "7", "8", "9", "/", "%", "4", "5", "6", "*", "1/x", "1", "2","3", "-", "=", "0", ".", "+"};
		btn = new Button[bv.length];
		for(i=0, x = 25, y = 150, row = 1; i < bv.length; i++, x+=50, row++){
			btn[i] = new Button(bv[i]);
			btn[i].setBounds(x, y, 45, 35);
			btn[i].setFont(new Font("", Font.PLAIN, 14));
			f.add(btn[i]);
			if(row == 5){ x = -25; 	y = (y +40); row = 0;	}
		}
		f.setSize(w,h);
		f.setLayout(null);
		f.setVisible(true);
	}
	public static void main(String...a){
		new Calculator("WASP Calculator", 300, 420);
	}
}