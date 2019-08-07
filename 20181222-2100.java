import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


class calculator extends JFrame {

	private int ind = 0;
	private JTextField textfield;
	private JButton eq, one, two, three, four, five, six, seven, eight, nine, dot, zero, clear, plus, minus, divide, multiply, power, ln, log, factorial, e, pi, openbra, closebra;


	private calculator() {
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		textfield = new JTextField("0");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 3;
		add(textfield, c);

		eq = new JButton("=");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 3;
		c.gridwidth = 1;
		add(eq, c);

		seven = new JButton("7");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 1;
		add(seven, c);

		eight = new JButton("8");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		add(eight, c);

		nine = new JButton("9");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		add(nine, c);

		plus = new JButton("+");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 3;
		add(plus, c);

		four = new JButton("4");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 2;
		add(four, c);

		five = new JButton("5");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 2;
		add(five, c);

		six = new JButton("6");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 2;
		add(six, c);

		minus = new JButton("-");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 3;
		c.gridy = 2;
		add(minus, c);

		one = new JButton("1");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 3;
		add(one, c);

		two = new JButton("2");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 3;
		add(two, c);

		three = new JButton("3");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 3;
		add(three, c);

		multiply = new JButton("*");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 3;
		c.gridy = 3;
		add(multiply, c);

		dot = new JButton(".");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 4;
		add(dot, c);

		zero = new JButton("0");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 4;
		add(zero, c);

		clear = new JButton("CE");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 4;
		add(clear, c);

		divide = new JButton("/");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 3;
		c.gridy = 4;
		add(divide, c);

		power = new JButton("^");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 5;
		add(power, c);

		ln = new JButton("ln");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 5;
		add(ln, c);

		log = new JButton("log");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 5;
		add(log, c);

		factorial = new JButton("!");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 3;
		c.gridy = 5;
		add(factorial, c);

		e = new JButton("e");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 6;
		add(e, c);

		openbra = new JButton("(");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		add(openbra, c);

		closebra = new JButton(")");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		add(closebra, c);

		pi = new JButton("pi");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 3;
		c.gridy = 6;
		add(pi, c);

		event a = new event();
		eq.addActionListener(a);
		seven.addActionListener(a);
		eight.addActionListener(a);
		nine.addActionListener(a);
		plus.addActionListener(a);
		four.addActionListener(a);
		five.addActionListener(a);
		six.addActionListener(a);
		minus.addActionListener(a);
		one.addActionListener(a);
		two.addActionListener(a);
		three.addActionListener(a);
		multiply.addActionListener(a);
		dot.addActionListener(a);
		zero.addActionListener(a);
		clear.addActionListener(a);
		divide.addActionListener(a);
		power.addActionListener(a);
		ln.addActionListener(a);
		log.addActionListener(a);
		factorial.addActionListener(a);
		e.addActionListener(a);
		pi.addActionListener(a);
		openbra.addActionListener(a);
		closebra.addActionListener(a);
	}

	public class event implements ActionListener {

		public void actionPerformed(ActionEvent a) {
			//stringcal sc = new stringcal();
			String bp = a.getActionCommand();
			if(bp=="CE"){
				textfield.setText("0");
				ind = 0;
			}
			else if(bp=="="){

				stringcal sc = new stringcal();
				textfield.setText(sc.calculate(textfield.getText()));
			}			//algo to operate calculation
			else {
				tfedit(bp);
			}
		}
	}

	private void tfedit(String bp) {
			if(bp=="ln"|| bp =="log")
				bp=bp + "(";
			String s = textfield.getText();
			if(ind == 0){
				textfield.setText(bp);
				ind = 1;
			}
			else
				textfield.setText(s+bp);
		}

	public static void main(String args[]) {
		calculator g = new calculator();
		g.setTitle("Calculator");
		g.pack();
		g.setVisible(true);
		g.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
