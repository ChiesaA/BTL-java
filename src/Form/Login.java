package Form;

import java.awt.BorderLayout;
import vanphongpham.*;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicOptionPaneUI.ButtonActionListener;
import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

import vanphongpham.*;
import DatabaseAccessObject_DAO.*;
import java.awt.Color;
import java.awt.Window.Type;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
public class Login extends JFrame {

	private JPanel contentPane;
	private JPasswordField password;
	private JTextField txttaikhoan;
	static int  id;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setTitle("Đăng nhập");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 607, 415);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Đăng nhập");
		lblNewLabel.setForeground(new Color(85, 107, 47));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 34));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(171, 33, 243, 52);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tên tài khoản");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1.setBounds(87, 120, 102, 36);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Mật khẩu");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(87, 203, 94, 36);
		contentPane.add(lblNewLabel_1_1);
		
		password = new JPasswordField();
		password.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		password.setBounds(199, 205, 232, 36);
		contentPane.add(password);
		
		
		txttaikhoan = new JTextField();
		txttaikhoan.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txttaikhoan.setBounds(199, 122, 232, 36);
		contentPane.add(txttaikhoan);
		txttaikhoan.setColumns(10);
		
		JButton btnNewButton = new JButton("Đăng nhập");
		btnNewButton.setToolTipText("");
		btnNewButton.setBackground(new Color(230, 230, 250));
		btnNewButton.setIcon(new ImageIcon("E:\\eclipse-workspace\\chvanphongpham\\src\\icon\\Login-icon.png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				String taiKhoan = txttaikhoan.getText().trim();
		        String matKhau =  password.getText().trim();
		        int idnhanvien = Integer.parseInt(txttaikhoan.getText().trim());
		        id = idnhanvien;

		        if (!taiKhoan.isEmpty() && matKhau.isEmpty()) {
		        	JOptionPane.showMessageDialog(null, "Vui lòng nhập mật khẩu!");
		            return;
		        }
		        
		        NhanVien nv = new NhanVien();
		        nv = NhanVienDAO.getNVByID(idnhanvien);
	//Phân quyền

		        if(idnhanvien == nv.getIDNhanVien() && matKhau.equals(nv.getSdt())) {
		        	    if(nv.getIDVaiTro()==2) {
		        		Menu menu = new Menu();
			        	dispose();
			        	menu.setLocationRelativeTo(null);
			        	menu.setVisible(true); 
		        	    }
		        	    else{		 
		        	    	MenuNhanVien menu = new MenuNhanVien();
				        	dispose();
				        	menu.setLocationRelativeTo(null);
				        	menu.setVisible(true);
		        	    }
		        }
		         else {
		            JOptionPane.showMessageDialog(null, "Tài khoản, mật khẩu không chính xác!!");
		            txttaikhoan.setText("");
					password.setText("");
		        }
				}catch(Exception ex) {
					ex.getStackTrace();
				}
				
				try {
					String taiKhoan = txttaikhoan.getText().trim();
			        String matKhau =  password.getText().trim();
			        if(taiKhoan.equals("admin") && matKhau.equals("admin")) {
			        	FormNhanVien nv = new FormNhanVien();
			        	dispose();
			        	nv.setLocationRelativeTo(null);
			        	nv.setVisible(true);			        	
			        }		        	
			        }catch(Exception ex) {
			        	
			        }
				}
 
			
			
		});
		password.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					btnNewButton.doClick();
				}
			}
		});
		
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton.setBounds(402, 301, 157, 43);
		contentPane.add(btnNewButton);
		
		JButton btnLmMi = new JButton("Làm mới");
		btnLmMi.setBackground(new Color(255, 248, 220));
		btnLmMi.setIcon(new ImageIcon("E:\\eclipse-workspace\\chvanphongpham\\src\\icon\\Extras-Close-icon.png"));
		btnLmMi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txttaikhoan.setText("");
				password.setText("");
			}
		});
		btnLmMi.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnLmMi.setBounds(221, 301, 143, 43);
		contentPane.add(btnLmMi);
		
		JButton btnThot = new JButton("Thoát");
		btnThot.setBackground(new Color(255, 245, 238));
		btnThot.setIcon(new ImageIcon("E:\\eclipse-workspace\\chvanphongpham\\src\\icon\\Logout-icon.png"));
		btnThot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnThot.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnThot.setBounds(25, 301, 143, 43);
		contentPane.add(btnThot);
	}	
}
