package com.arthur.hr.client.ui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import mybeans.interfaces.EmployeeDAORemote;
import entities.Employee;

public class EmployeeFrame extends JFrame {

	private static final long serialVersionUID = -5694658585441335289L;
	private JPanel contentPane;
	private JLabel lblStatus;
	private JTextField txtEmployeedaomybeans;
	private JTextField textField;
	
	@EJB
	EmployeeDAORemote dao;

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
		
		JButton btnTestConnection = new JButton("Test Connection");
		btnTestConnection.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				testConnectionActionPerformed();
			}
		});
		
		txtEmployeedaomybeans = new JTextField(); 
		txtEmployeedaomybeans.setText("java:global.com.arthur.hr.ear.ejb-0.0.1-SNAPSHOT.EmployeeDAO");
		txtEmployeedaomybeans.setColumns(10);
		
		lblStatus = new JLabel("waiting for test");
		
		JButton btnRetrieveEmployeeFirstname = new JButton("Retrieve Employee Firstname");
		btnRetrieveEmployeeFirstname.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				retrieveEmployeeFirstnameActionPerformed();
			}
		});
		
		
		textField = new JTextField();
		textField.setText("100");
		textField.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnRetrieveEmployeeFirstname)
								.addComponent(btnTestConnection))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(txtEmployeedaomybeans, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(139)
							.addComponent(lblStatus)))
					.addContainerGap(95, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(9)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnTestConnection)
						.addComponent(txtEmployeedaomybeans, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnRetrieveEmployeeFirstname)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(63)
					.addComponent(lblStatus)
					.addContainerGap(101, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	public void retrieveEmployeeFirstnameActionPerformed() {
		String status = "";
		EmployeeDAORemote dao;
		try {
			dao = (EmployeeDAORemote) getContext().lookup(txtEmployeedaomybeans.getText());
			Employee e = dao.get(Long.parseLong(textField.getText()));
			status = e.getFirstname();
			closeContext();
		} catch (NamingException e1) {
			status = "Erreur lookup";
			e1.printStackTrace();
		} catch (Exception e) {
			status = "Erreur";
			e.printStackTrace();
		}
		lblStatus.setText(status);
	}
	
	public void testConnectionActionPerformed() {
		String status = "";
		if (getContext()!=null) {
			status = "context ok";
			try {
				Object o = getContext().lookup(txtEmployeedaomybeans.getText());
				status += " : " + o.getClass();
				closeContext();
			} catch (NamingException e) {
				status += " - lookup ko";
				e.printStackTrace();
			}
		}
		lblStatus.setText(status);
	}
	
	private Context ctx;
	private Context getContext() {
		if (ctx==null) {
			Properties p = new Properties();
			p.put("java.naming.factory.initial", "weblogic.jndi.WLInitialContextFactory");
			p.put("java.naming.provider.url", "t3://localhost:7001");
			p.put("java.naming.security.principal", "admin");
			p.put("java.naming.security.credentials", "pwd4admin");
			try {
				ctx = new InitialContext(p);
			} catch (NamingException e) {
				e.printStackTrace();
			}
		}
		return ctx;
	}
	private void closeContext() {
		if (ctx!=null) {
			try {
				ctx.close();
			} catch (NamingException e) {
				e.printStackTrace();
			}
			ctx=null;
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
