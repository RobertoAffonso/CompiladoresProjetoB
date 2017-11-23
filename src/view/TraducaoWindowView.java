package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.CorrectionControl;
import control.TraducaoControl;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.DropMode;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JEditorPane;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

public class TraducaoWindowView extends JFrame {

	JPanel contentPane;
 	JTextArea inputField;
 	JTextArea resultField;
 	TraducaoControl TraducaoA = new TraducaoControl();
	CorrectionControl cc = new CorrectionControl();
	ArrayList lines = new ArrayList();

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TraducaoWindowView frame = new TraducaoWindowView();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public TraducaoWindowView() 
	{
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 512, 555);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnTraduzirB = new JButton("Iniciar Tradução");
		btnTraduzirB.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				lines = TraducaoA.textBreaker(getInputTextString());
				setResultText(cc.correctText(lines));
			}
		});
		btnTraduzirB.setBounds(167, 468, 119, 37);
		contentPane.add(btnTraduzirB);
		
		JTextArea txtrSejaBemVindo = new JTextArea();
		txtrSejaBemVindo.setEditable(false);
		txtrSejaBemVindo.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtrSejaBemVindo.setText("Seja bem vindo ao Projeto B do grupo composto pelos alunos: \r\nVitor Hugo Junqueira e Roberto Affonso.");
		txtrSejaBemVindo.setBounds(10, 11, 476, 48);
		contentPane.add(txtrSejaBemVindo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 163, 476, 138);
		contentPane.add(scrollPane);
		
		inputField = new JTextArea();
		scrollPane.setViewportView(inputField);
		inputField.setColumns(10);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 312, 476, 145);
		contentPane.add(scrollPane_1);
		
		resultField = new JTextArea();
		scrollPane_1.setViewportView(resultField);
		resultField.setColumns(10);
	}
	
	public String getInputTextString()
	{
		return inputField.getText();
	}
	
	public String getResultTextString()
	{
		return resultField.getText();
	}
	
	public void setResultText(String ResultText)
	{
		this.resultField.setText(ResultText);
	}
	
	public void setInputText(String InputText)
	{
		this.inputField.setText(InputText);
	}
	
	public void showResult()
	{
		JOptionPane.showMessageDialog(null, getInputTextString());
		setResultText(getInputTextString());
	}
}
