package Form;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DatabaseAccessObject_DAO.NhanVienDAO;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JMenuBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenu;
import javax.swing.JRadioButtonMenuItem;

import vanphongpham.*;
import Form.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import Form.Login;
public class Menu extends JFrame {

	private JPanel contentPane;
	private JTextField textNV;
	private JTextField txtID;
	private JTextField txtTen;
	private JTextField txtVaiTro;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
		setBackground(new Color(255, 228, 181));
		
		setTitle("Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1120, 762);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 235, 215));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Quản lý cửa hàng văn phòng phẩm");
		lblNewLabel.setForeground(new Color(85, 107, 47));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 40));
		lblNewLabel.setBounds(168, 119, 782, 72);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Thoát");
		btnNewButton.setIcon(new ImageIcon("E:\\eclipse-workspace\\chvanphongpham\\src\\icon\\Logout-icon.png"));
		btnNewButton.setBackground(new Color(250, 240, 230));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Login login = new Login();
				login.setLocationRelativeTo(null);
				login.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton.setBounds(927, 635, 150, 59);
		contentPane.add(btnNewButton);
		
		JButton btnnhanvien = new JButton("Nhân viên");
		btnnhanvien.setIcon(new ImageIcon("E:\\eclipse-workspace\\chvanphongpham\\src\\icon\\user-group-icon.png"));
		btnnhanvien.setBackground(new Color(238, 232, 170));
		btnnhanvien.setBounds(186, 241, 314, 160);
		contentPane.add(btnnhanvien);
		btnnhanvien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				FormNhanVien frame = new FormNhanVien();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				
			}
		});
		btnnhanvien.setForeground(new Color(250, 128, 114));
		btnnhanvien.setFont(new Font("Times New Roman", Font.BOLD, 27));
		
		JButton btnquanlysanpham = new JButton("Sản phẩm");
		btnquanlysanpham.setBackground(new Color(230, 230, 250));
		btnquanlysanpham.setIcon(new ImageIcon("E:\\eclipse-workspace\\chvanphongpham\\src\\icon\\Box-icon.png"));
		btnquanlysanpham.setBounds(590, 241, 320, 160);
		contentPane.add(btnquanlysanpham);
		btnquanlysanpham.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				FormSanPham frame = new FormSanPham();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		});
		btnquanlysanpham.setForeground(new Color(219, 112, 147));
		btnquanlysanpham.setFont(new Font("Times New Roman", Font.BOLD, 27));
		
		JButton btnquanlihoadon = new JButton("Hóa đơn");
		btnquanlihoadon.setBackground(new Color(255, 228, 181));
		btnquanlihoadon.setIcon(new ImageIcon("E:\\eclipse-workspace\\chvanphongpham\\src\\icon\\Actions-view-calendar-list-icon.png"));
		btnquanlihoadon.setBounds(183, 468, 314, 160);
		contentPane.add(btnquanlihoadon);
		btnquanlihoadon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				FormHoaDon frame = new FormHoaDon();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		});
		btnquanlihoadon.setForeground(new Color(106, 90, 205));
		btnquanlihoadon.setFont(new Font("Times New Roman", Font.BOLD, 27));
		
		JButton btnchitiethoadon = new JButton("Chi tiết hóa đơn");
		btnchitiethoadon.setBackground(new Color(240, 230, 140));
		btnchitiethoadon.setIcon(new ImageIcon("E:\\eclipse-workspace\\chvanphongpham\\src\\icon\\Actions-view-pim-contacts-icon.png"));
		btnchitiethoadon.setBounds(590, 468, 320, 160);
		contentPane.add(btnchitiethoadon);
		btnchitiethoadon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				FormChiTiethoaDon frame = new FormChiTiethoaDon();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		});
		btnchitiethoadon.setForeground(new Color(135, 206, 250));
		btnchitiethoadon.setFont(new Font("Times New Roman", Font.BOLD, 27));
		
		JLabel lblNewLabel_1 = new JLabel("IDNhanVien");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(21, 25, 132, 39);
		contentPane.add(lblNewLabel_1);
		
		txtID = new JTextField();
		txtID.setEditable(false);
		txtID.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtID.setBounds(147, 23, 111, 39);
		contentPane.add(txtID);
		txtID.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tên");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(296, 23, 132, 39);
		contentPane.add(lblNewLabel_1_1);
		
		txtTen = new JTextField();
		txtTen.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtTen.setEditable(false);
		txtTen.setColumns(10);
		txtTen.setBounds(373, 25, 132, 39);
		contentPane.add(txtTen);
		
		JLabel lblNewLabel_1_2 = new JLabel("Vai trò");
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(550, 25, 132, 39);
		contentPane.add(lblNewLabel_1_2);
		
		txtVaiTro = new JTextField();
		txtVaiTro.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtVaiTro.setEditable(false);
		txtVaiTro.setColumns(10);
		txtVaiTro.setBounds(648, 27, 132, 39);
		contentPane.add(txtVaiTro);
		
		try {
		NhanVien nv = new NhanVien();
		nv = NhanVienDAO.getNVByID(Login.id);
		txtID.setText("" + nv.getIDNhanVien());
		txtTen.setText(nv.getTen());
		txtVaiTro.setText(nv.getTenVaiTro());
		}catch (Exception ex) {
		}
		
	}
}
