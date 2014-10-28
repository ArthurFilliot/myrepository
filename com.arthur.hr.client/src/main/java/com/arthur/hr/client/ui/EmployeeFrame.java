package com.arthur.hr.client.ui;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;

public class EmployeeFrame extends JFrame {

	private static final long serialVersionUID = -5694658585441335289L;
	private JPanel contentPane;
	private JLabel lblStatus;
	private JTextField txtEmployeedaomybeans;

	/**
	 * Create the frame.
	 */
	public EmployeeFrame() {
		initComponents();
	}
	
	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnTestConnection = new JButton("Test Connection");
		btnTestConnection.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				testConnectionActionPerformed();
			}
		});
		contentPane.add(btnTestConnection);
		
		txtEmployeedaomybeans = new JTextField();
		txtEmployeedaomybeans.setText("EmployeeDAO#mybeans");
		contentPane.add(txtEmployeedaomybeans);
		txtEmployeedaomybeans.setColumns(10);
		
		lblStatus = new JLabel("waiting for test");
		contentPane.add(lblStatus);
	}
	
	public void testConnectionActionPerformed() {
		Properties p = new Properties();
		p.put("java.naming.factory.initial", "weblogic.jndi.WLInitialContextFactory");
		p.put("java.naming.provider.url", "t3://localhost:7001");
		p.put("java.naming.security.principal", "admin");
		p.put("java.naming.security.credentials", "pwd4admin");
		Context ctx=null;
		try {
			ctx = new InitialContext(p);
			ctx.lookup(txtEmployeedaomybeans.getText());
			lblStatus.setText("ok");
		} catch (NamingException e) {
			e.printStackTrace();
			lblStatus.setText("Error : " + e.getMessage());
		} finally {
			try {
				if (ctx!=null) ctx.close();
			} catch (Exception e) {
				lblStatus.setText(lblStatus.getText() + " - Error : " + e.getMessage());
			}
		}
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeFrame frame = new EmployeeFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
