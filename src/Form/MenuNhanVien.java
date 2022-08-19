package Form;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DatabaseAccessObject_DAO.NhanVienDAO;
import vanphongpham.NhanVien;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuNhanVien extends JFrame {

	private JPanel contentPane;
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
					MenuNhanVien frame = new MenuNhanVien();
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
	public MenuNhanVien() {
		setTitle("Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1080, 730);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 248, 220));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Quản lý cửa hàng văn phòng phẩm");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(85, 107, 47));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 40));
		lblNewLabel.setBounds(144, 144, 782, 72);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Thoát");
		btnNewButton.setIcon(new ImageIcon(MenuNhanVien.class.getResource("/icon/Logout-icon.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Login login = new Login();
				login.setLocationRelativeTo(null);
				login.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton.setBackground(new Color(250, 240, 230));
		btnNewButton.setBounds(851, 614, 150, 59);
		contentPane.add(btnNewButton);
		
		JButton btnquanlysanpham = new JButton("Sản phẩm");
		btnquanlysanpham.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				FormSanPham frame = new FormSanPham();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		});
		btnquanlysanpham.setIcon(new ImageIcon(MenuNhanVien.class.getResource("/icon/Box-icon.png")));
		btnquanlysanpham.setForeground(new Color(219, 112, 147));
		btnquanlysanpham.setFont(new Font("Times New Roman", Font.BOLD, 27));
		btnquanlysanpham.setBackground(new Color(230, 230, 250));
		btnquanlysanpham.setBounds(549, 265, 278, 150);
		contentPane.add(btnquanlysanpham);
		
		JButton btnquanlihoadon = new JButton("Hóa đơn");
		btnquanlihoadon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				FormHoaDon frame = new FormHoaDon();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		});
		btnquanlihoadon.setIcon(new ImageIcon(MenuNhanVien.class.getResource("/icon/Actions-view-calendar-list-icon.png")));
		btnquanlihoadon.setForeground(new Color(106, 90, 205));
		btnquanlihoadon.setFont(new Font("Times New Roman", Font.BOLD, 27));
		btnquanlihoadon.setBackground(new Color(255, 228, 181));
		btnquanlihoadon.setBounds(222, 265, 278, 150);
		contentPane.add(btnquanlihoadon);
		
		JButton btnchitiethoadon = new JButton("Chi tiết hóa đơn");
		btnchitiethoadon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				FormChiTiethoaDon frame = new FormChiTiethoaDon();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		});
		btnchitiethoadon.setIcon(new ImageIcon(MenuNhanVien.class.getResource("/icon/Actions-view-pim-contacts-icon.png")));
		btnchitiethoadon.setForeground(new Color(135, 206, 250));
		btnchitiethoadon.setFont(new Font("Times New Roman", Font.BOLD, 27));
		btnchitiethoadon.setBackground(new Color(240, 230, 140));
		btnchitiethoadon.setBounds(386, 456, 288, 150);
		contentPane.add(btnchitiethoadon);
		
		JLabel lblNewLabel_1 = new JLabel("IDNhanVien");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(82, 54, 132, 39);
		contentPane.add(lblNewLabel_1);
		
		txtID = new JTextField();
		txtID.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtID.setEditable(false);
		txtID.setColumns(10);
		txtID.setBounds(208, 52, 111, 39);
		contentPane.add(txtID);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tên");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(357, 52, 132, 39);
		contentPane.add(lblNewLabel_1_1);
		
		txtTen = new JTextField();
		txtTen.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtTen.setText((String) null);
		txtTen.setEditable(false);
		txtTen.setColumns(10);
		txtTen.setBounds(434, 54, 132, 39);
		contentPane.add(txtTen);
		
		JLabel lblNewLabel_1_2 = new JLabel("Vai trò");
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(611, 54, 132, 39);
		contentPane.add(lblNewLabel_1_2);
		
		txtVaiTro = new JTextField();
		txtVaiTro.setText((String) null);
		txtVaiTro.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtVaiTro.setEditable(false);
		txtVaiTro.setColumns(10);
		txtVaiTro.setBounds(709, 56, 132, 39);
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
