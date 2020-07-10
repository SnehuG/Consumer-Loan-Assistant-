package loanassistant;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import javax.swing.*;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DecimalFormat;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class LoanAssistant extends JFrame{
	boolean computePayment;
	JLabel balanceLabel = new JLabel("");
	JTextField balanceTextField = new JTextField();
	JLabel interestLabel = new JLabel("");
	JTextField interestTextField = new JTextField();
	JLabel monthsLabel = new JLabel("");
	JTextField monthsTextField = new JTextField();
	JLabel paymentLabel = new JLabel("");
	JTextField paymentTextField = new JTextField();
	JButton computeButton = new JButton();
	JButton paymentButton = new JButton();
	JButton newLoanButton = new JButton();
	JButton monthsButton = new JButton();
	JLabel analysisLabel = new JLabel();
	JTextArea analysisTextArea = new JTextArea();
	JButton exitButton = new JButton();
	
	
	public static void main(String[] args) {
		new LoanAssistant().show();
	}
	
	public LoanAssistant() {
		setResizable(false);
		setTitle("Loan Assistant");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				exitForm(arg0);
			}
		});
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWeights = new double[]{0.0, 1.0};
		getContentPane().setLayout(gridBagLayout);
		GridBagConstraints constraints;
		
		
		balanceLabel.setText("Loan Balance");
		balanceLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		constraints = new GridBagConstraints();
		constraints.insets = new Insets(10, 10, 0, 0);
		constraints.anchor = GridBagConstraints.WEST;
		constraints.gridx = 0;
		constraints.gridy = 0;
		getContentPane().add(balanceLabel, constraints);
		balanceTextField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				balanceTextFieldActionPerformed(e);
			}

			private void balanceTextFieldActionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				balanceTextField.transferFocus();
			}
		});
		
		
		balanceTextField.setPreferredSize(new Dimension(100, 25));
		balanceTextField.setHorizontalAlignment(SwingConstants.RIGHT);
		balanceTextField.setFont(new Font("Arial", Font.PLAIN, 16));
		constraints = new GridBagConstraints();
		constraints.insets = new Insets(10, 10, 0, 10);
		constraints.gridx = 1;
		constraints.gridy = 0;
		getContentPane().add(balanceTextField, constraints);
		
		
		interestLabel.setText("Interest Rate");
		interestLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		constraints = new GridBagConstraints();
		constraints.insets = new Insets(10, 10, 0, 0);
		constraints.anchor = GridBagConstraints.WEST;
		constraints.gridx = 0;
		constraints.gridy = 1;
		getContentPane().add(interestLabel, constraints);
		interestTextField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				interestTextFieldActionPerformed(e);
			}

			private void interestTextFieldActionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				interestTextField.transferFocus();
			}
		});
		
		
		interestTextField.setPreferredSize(new Dimension(100, 25));
		interestTextField.setHorizontalAlignment(SwingConstants.RIGHT);
		interestTextField.setFont(new Font("Arial", Font.PLAIN, 16));
		constraints = new GridBagConstraints();
		constraints.gridx = 1;
		constraints.gridy = 1;
		constraints.insets = new Insets(10, 10, 0, 10);
		getContentPane().add(interestTextField, constraints);
		
		
		monthsLabel.setText("Number of Payments");
		monthsLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = 2;
		constraints.anchor = GridBagConstraints.WEST;
		constraints.insets = new Insets(10, 10, 0, 0);
		getContentPane().add(monthsLabel, constraints);
		monthsTextField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				monthsTextFieldActionPerformed(e);
			}

			private void monthsTextFieldActionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				monthsTextField.transferFocus();
			}
		});
		
		
		monthsTextField.setFont(new Font("Arial", Font.PLAIN, 16));
		monthsTextField.setPreferredSize(new Dimension(100, 25));
		monthsTextField.setHorizontalAlignment(SwingConstants.RIGHT);
		constraints = new GridBagConstraints();
		constraints.gridx = 1;
		constraints.gridy = 2;
		constraints.insets = new Insets(10, 10, 0, 10);
		getContentPane().add(monthsTextField, constraints);
		
		
		paymentLabel.setText("Monthly Payment");
		paymentLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = 3;
		constraints.anchor = GridBagConstraints.WEST;
		constraints.insets = new Insets(10, 10, 0, 0);
		getContentPane().add(paymentLabel, constraints);
		paymentTextField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paymentTextFieldActionPerformed(e);
			}

			private void paymentTextFieldActionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				paymentTextField.transferFocus();
			}
		});
		
		
		paymentTextField.setFont(new Font("Arial", Font.PLAIN, 16));
		paymentTextField.setPreferredSize(new Dimension(100, 25));
		paymentTextField.setHorizontalAlignment(SwingConstants.RIGHT);
		constraints = new GridBagConstraints();
		constraints.gridx = 1;
		constraints.gridy = 3;
		constraints.insets = new Insets(10, 10, 0, 10);
		getContentPane().add(paymentTextField, constraints);
		
		
		computeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double balance,interest,payment;
				double loanBalance,finalPayment;
				int months;
				double monthlyInterest,multiplier;
				
				if(validateDecimalNumber(balanceTextField))
				{
					balance=Double.valueOf(balanceTextField.getText()).doubleValue();
				}
				else
				{
					JOptionPane.showConfirmDialog(null, "Invalid or empty Loan Balance entry.\nPlease correct.", "Balance Input Error", JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				
				if(validateDecimalNumber(interestTextField))
				{
					interest=Double.valueOf(interestTextField.getText()).doubleValue();
				}
				else
				{
					JOptionPane.showConfirmDialog(null, "Invalid or empty Interest Rate entry.\nPlease correct.", "Interest Input Error", JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				monthlyInterest=interest/1200;
				if(computePayment)
				{
					if (validateDecimalNumber(monthsTextField))
					{
						months=Integer.valueOf(monthsTextField.getText()).intValue();
					}
					else
					{
						JOptionPane.showConfirmDialog(null, "Invalid or empty Number of Payments entry.\nPlease correct.", "Number of Payments Input Error",JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
						return;
					}
					
					if(interest == 0)
					{
						payment = balance / months;
					}
					else
					{
						multiplier=Math.pow(1 + monthlyInterest, months);
						payment = balance * monthlyInterest * multiplier /(multiplier - 1);
					}
					paymentTextField.setText(new DecimalFormat("0.00").format(payment));
				}
				else
				{
					if (validateDecimalNumber(paymentTextField))
					{
						payment =Double.valueOf(paymentTextField.getText()).doubleValue();
						if (payment <= (balance * monthlyInterest + 1.0))
						{
							if (JOptionPane.showConfirmDialog(null, "Minimum payment must be $" +new DecimalFormat("0.00").format((int)(balance * monthlyInterest + 1.0)) + "\n" + "Do you want to use the minimum payment?", "Input Error", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION)
							{
								paymentTextField.setText(new DecimalFormat("0.00").format((int)(balance * monthlyInterest + 1.0)));
								payment =Double.valueOf(paymentTextField.getText()).doubleValue();
							}
							else
							{
								paymentTextField.requestFocus();
								return;
							}
						}
					}
					else
					{
						JOptionPane.showConfirmDialog(null, "Invalid or empty Monthly Payment entry.\nPlease correct.", "Payment Input Error", JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
						return;
					}
					
					if(interest == 0)
					{
						months = (int)(balance / payment);
					}
					else
					{
						months = (int)((Math.log(payment) - Math.log(payment - balance * monthlyInterest))/ Math.log(1 + monthlyInterest));
					}
					monthsTextField.setText(String.valueOf(months));
				}
				payment =Double.valueOf(paymentTextField.getText()).doubleValue();
				
				analysisTextArea.setText("Loan Balance: $" + new DecimalFormat("0.00").format(balance));
				analysisTextArea.append("\n" + "Interest Rate: " + new DecimalFormat("0.00").format(interest) + "%");;
				
				loanBalance = balance;
				for (int paymentNumber = 1; paymentNumber <= months - 1; paymentNumber++)
				{
					loanBalance += loanBalance * monthlyInterest - payment;
				}
				
				finalPayment = loanBalance;
				if (finalPayment > payment)
				{
					loanBalance += loanBalance * monthlyInterest - payment;
					finalPayment = loanBalance;
					months++;
					monthsTextField.setText(String.valueOf(months));
				}
				
				analysisTextArea.append("\n\n" + String.valueOf(months - 1) + " Payments of $" + new DecimalFormat("0.00").format(payment));
				analysisTextArea.append("\n" + "Final Payment of: $" + new DecimalFormat("0.00").format(finalPayment));
				analysisTextArea.append("\n" + "Total Payments: $" + new DecimalFormat("0.00").format((months - 1) * payment + finalPayment));
				analysisTextArea.append("\n" + "Interest Paid $" + new DecimalFormat("0.00").format((months - 1) * payment + finalPayment - balance));
				computeButton.setEnabled(false);
				newLoanButton.setEnabled(true);
				newLoanButton.requestFocus();
			}

			private boolean validateDecimalNumber(JTextField tf) {
				// TODO Auto-generated method stub
				String s = tf.getText().trim();
				boolean hasDecimal = false;
				boolean valid = true;
				if (s.length() == 0)
				{
					valid = false;
				}
				else
				{
					for (int i = 0; i < s.length(); i++)
					{
						char c = s.charAt(i);
						if (c >= '0' && c <= '9')
						{
							continue;
						}
						else if (c == '.' && !hasDecimal)
						{
							hasDecimal = true;
						}
						else
						{
							valid = false;
						}
					}
				}
				tf.setText(s);
				if (!valid)
				{
					tf.requestFocus();
				}
				return (valid);
			}
		});
		computeButton.setText("Compute Monthly Payment");
		constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = 4;
		constraints.gridwidth = 2;
		constraints.insets = new Insets(10, 0, 0, 0);
		getContentPane().add(computeButton, constraints);
		
		
		newLoanButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (computePayment)
				{
					paymentTextField.setText("");
				}
				else
				{
					monthsTextField.setText("");
				}
				analysisTextArea.setText("");
				computeButton.setEnabled(true);
				newLoanButton.setEnabled(false);
				balanceTextField.requestFocus();
			}
		});
		newLoanButton.setText("New Loan Analysis");
		newLoanButton.setEnabled(false);
		constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = 5;
		constraints.gridwidth = 2;
		constraints.insets = new Insets(10, 0, 10, 0);
		getContentPane().add(newLoanButton, constraints);
		
		
		monthsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				computePayment = false;
				paymentButton.setVisible(true);
				monthsButton.setVisible(false);
				monthsTextField.setText("");
				monthsTextField.setFocusable(false);
				monthsTextField.setEditable(false);
				monthsTextField.setBackground(new Color(255,255,128));
				paymentTextField.setEditable(true);
				paymentTextField.setBackground(Color.WHITE);
				paymentTextField.setFocusable(true);
				computeButton.setText("Compute Number of Payments");
				balanceTextField.requestFocus();
			}
		});
		monthsButton.setText("X");
		monthsButton.setFocusable(false);
		constraints = new GridBagConstraints();
		constraints.gridx = 2;
		constraints.gridy = 2;
		constraints.insets = new Insets(10, 0, 0, 0);
		getContentPane().add(monthsButton, constraints);
		
		
		paymentButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				computePayment=true;
				paymentButton.setVisible(false);
				monthsButton.setVisible(true);
				monthsTextField.setEditable(true);
				monthsTextField.setBackground(Color.WHITE);
				monthsTextField.setFocusable(true);
				paymentTextField.setText("");
				paymentTextField.setEditable(false);
				paymentTextField.setBackground(new Color(255,255,128));
				paymentTextField.setFocusable(false);
				computeButton.setText("compute Monthly Payment");
				balanceTextField.requestFocus();
			}
		});
		paymentButton.setText("X");
		paymentButton.setFocusable(false);
		constraints = new GridBagConstraints();
		constraints.gridx = 2;
		constraints.gridy = 3;
		constraints.insets = new Insets(10, 0, 0, 0);
		getContentPane().add(paymentButton, constraints);
		
		
		analysisLabel.setText("Loan Analysis:");
		analysisLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		constraints = new GridBagConstraints();
		constraints.gridx = 3;
		constraints.gridy = 0;
		constraints.anchor = GridBagConstraints.WEST;
		constraints.insets = new Insets(0, 10, 0, 0);
		getContentPane().add(analysisLabel, constraints);
		
		
		analysisTextArea.setPreferredSize(new Dimension(250, 150));
		analysisTextArea.setFocusable(false);
		analysisTextArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		analysisTextArea.setFont(new Font("Courier New", Font.PLAIN, 14));
		analysisTextArea.setEditable(false);
		analysisTextArea.setBackground(Color.WHITE);
		constraints = new GridBagConstraints();
		constraints.gridx = 3;
		constraints.gridy = 1;
		constraints.gridheight = 4;
		constraints.insets = new Insets(0, 10, 0, 10);
		getContentPane().add(analysisTextArea, constraints);
		
		
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		exitButton.setText("Exit");
		exitButton.setFocusable(false);
		constraints = new GridBagConstraints();
		constraints.gridx = 3;
		constraints.gridy = 5;
		getContentPane().add(exitButton, constraints);
		
		
		pack();
		
		Dimension screenSize =Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((int) (0.5 * (screenSize.width - getWidth())), (int) (0.5 * (screenSize.height- getHeight())), getWidth(), getHeight());
	}

	private void exitForm(WindowEvent arg0) {
		// TODO Auto-generated method stub
		System.exit(0);
	}
}