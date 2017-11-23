package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainWindowView extends JFrame 
{

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) 
//	{
//		EventQueue.invokeLater(new Runnable() 
//		{
//			public void run() 
//			{
//				try 
//				{
//					MainWindowView frame = new MainWindowView();
//					frame.setVisible(true);
//				}
//				
//				catch (Exception e) 
//				{
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public MainWindowView() 
	{

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblProjetoB = new JLabel("Projeto B");
		lblProjetoB.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblProjetoB.setBounds(175, 11, 90, 43);
		contentPane.add(lblProjetoB);
		
		JLabel lblNewLabel = new JLabel("Vitor Hugo Junqueira");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(62, 55, 139, 24);
		contentPane.add(lblNewLabel);
		
		JLabel lblRobertoAffonso = new JLabel("Roberto Affonso");
		lblRobertoAffonso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRobertoAffonso.setBounds(246, 55, 139, 24);
		contentPane.add(lblRobertoAffonso);
		
		JButton btnIniciarTraduo = new JButton("Iniciar");
		btnIniciarTraduo.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				TraducaoWindowView traducao = new TraducaoWindowView();
			}
		});
		btnIniciarTraduo.setBounds(159, 209, 120, 30);
		contentPane.add(btnIniciarTraduo);
		
		setVisible(true);
	}
}
