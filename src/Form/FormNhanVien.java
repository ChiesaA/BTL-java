package Form;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.JTextField;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.JTabbedPane;

import java.awt.Panel;
import javax.swing.JSplitPane;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;
import java.awt.Label;
import ConnectionDB.*;
import vanphongpham.NhanVien;
import vanphongpham.VaiTro;
import DatabaseAccessObject_DAO.*;
import java.util.*;
import java.sql.*;
import java.sql.Date;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.*;
import javax.swing.JCheckBox;
import javax.swing.JToolBar;
import javax.swing.JFormattedTextField;
import javax.swing.JCheckBoxMenuItem;

import com.toedter.calendar.JDateChooser;
import java.awt.Window.Type;
import java.awt.Dialog.ModalExclusionType;

public class FormNhanVien extends JFrame {

	private JPanel contentPane;
	private JTextField txtID;
	private JTextField txtTen;
	private JTextField txtDiachi;
	private JTextField txtIDvaitro;
	private JTextField txtSDT;
	private static JTable table;
	private JTextField txtID1;
	private JTextField txtTen1;
	private JTextField txtVaitro1;
	private JTextField txttenvaitro;
	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		 
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormNhanVien frame = new FormNhanVien();
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
	
	public FormNhanVien() {
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setType(Type.POPUP);
		setTitle("Quản lý nhân viên");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1078, 779);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 248, 220));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID nhân viên");
		lblNewLabel.setBounds(40, 46, 134, 52);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		contentPane.add(lblNewLabel);
		
		JLabel lblTn = new JLabel("Tên");
		lblTn.setBounds(40, 118, 134, 52);
		lblTn.setFont(new Font("Times New Roman", Font.BOLD, 18));
		contentPane.add(lblTn);
		
		JLabel lblGiiTnh = new JLabel("Giới tính");
		lblGiiTnh.setBounds(350, 46, 134, 52);
		lblGiiTnh.setFont(new Font("Times New Roman", Font.BOLD, 18));
		contentPane.add(lblGiiTnh);
		
		JLabel lblaCh = new JLabel("Địa chỉ");
		lblaCh.setBounds(350, 188, 134, 52);
		lblaCh.setFont(new Font("Times New Roman", Font.BOLD, 18));
		contentPane.add(lblaCh);
		
		JLabel lblNgyVoLm = new JLabel("Ngày vào làm");
		lblNgyVoLm.setBounds(40, 194, 188, 52);
		lblNgyVoLm.setFont(new Font("Times New Roman", Font.BOLD, 18));
		contentPane.add(lblNgyVoLm);
		
		JLabel lblVaiTr = new JLabel("ID Vai trò");
		lblVaiTr.setBounds(40, 275, 134, 52);
		lblVaiTr.setFont(new Font("Times New Roman", Font.BOLD, 18));
		contentPane.add(lblVaiTr);
		
		txtID = new JTextField();
		txtID.setBounds(170, 59, 146, 31);
		txtID.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		contentPane.add(txtID);
		txtID.setColumns(10);
		
		txtTen = new JTextField();
		txtTen.setBounds(170, 131, 146, 31);
		txtTen.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtTen.setColumns(10);
		contentPane.add(txtTen);
		
		txtDiachi = new JTextField();
		txtDiachi.setBounds(446, 201, 146, 31);
		txtDiachi.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtDiachi.setColumns(10);
		contentPane.add(txtDiachi);
		
		txtIDvaitro = new JTextField();
		txtIDvaitro.setBounds(170, 283, 146, 31);
		txtIDvaitro.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtIDvaitro.setColumns(10);
		contentPane.add(txtIDvaitro);
		
		JComboBox cbGioiTinh = new JComboBox();
		cbGioiTinh.setBackground(new Color(255, 255, 255));
		cbGioiTinh.setToolTipText("");
		cbGioiTinh.setBounds(446, 54, 95, 31);
		cbGioiTinh.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		cbGioiTinh.setModel(new DefaultComboBoxModel(new String[] {"Nam", "Nữ"}));
		contentPane.add(cbGioiTinh);
		
		JDateChooser dcNgayvaolam = new JDateChooser();
		dcNgayvaolam.setBounds(170, 208, 146, 31);
		dcNgayvaolam.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		contentPane.add(dcNgayvaolam);
		
		JLabel lblSdt = new JLabel("SDT");
		lblSdt.setBounds(350, 112, 134, 52);
		lblSdt.setFont(new Font("Times New Roman", Font.BOLD, 18));
		contentPane.add(lblSdt);
		
		txtSDT = new JTextField();
		txtSDT.setBounds(446, 125, 146, 31);
		txtSDT.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtSDT.setColumns(10);
		contentPane.add(txtSDT);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(64, 504, 962, 208);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
				int index = table.getSelectedRow();
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				
				txtID.setText(model.getValueAt(index, 0).toString());
				txtTen.setText(model.getValueAt(index, 1).toString());
				txtSDT.setText(model.getValueAt(index, 2).toString());			
				if(model.getValueAt(index, 3).toString().equals("Nam")) {
					cbGioiTinh.setSelectedIndex(0);
				}else cbGioiTinh.setSelectedIndex(1);
				txtDiachi.setText(model.getValueAt(index, 4).toString());
				dcNgayvaolam.setDate(ConvertDate.convertDate((java.util.Date)model.getValueAt(index, 5)));
				txtIDvaitro.setText(model.getValueAt(index, 6).toString());
	
				
				}catch(Exception ex){
				ex.printStackTrace();
			}
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"ID nh\u00E2n vi\u00EAn", "T\u00EAn", "SDT", "Gi\u1EDBi T\u00EDnh", "\u0110\u1ECBa ch\u1EC9", "Ng\u00E0y v\u00E0o l\u00E0m", "ID vai tr\u00F2", "Vai tr\u00F2"
			}
		));
		table.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		scrollPane.setViewportView(table);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.setBackground(new Color(250, 235, 215));
		btnThem.setIcon(new ImageIcon("E:\\eclipse-workspace\\chvanphongpham\\src\\icon\\Actions-user-group-new-icon.png"));
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					if(!txttenvaitro.getText().isEmpty()) {
							VaiTro vt = new VaiTro();
							vt.setIDVaiTro(Integer.parseInt(txtIDvaitro.getText()));
							vt.setTenVaiTro(txttenvaitro.getText());
							VaiTroDAO.insert(vt);
							showdata(NhanVienDAO.selectAll());				
					}
					}catch (Exception ex) {
						//JOptionPane.showMessageDialog(null,"Không hợp lệ!");
					}
				
				try {
				NhanVien nv = new NhanVien();
				nv.setIDNhanVien(Integer.parseInt(txtID.getText()));
				nv.setTen(txtTen.getText());
				nv.setSdt(txtSDT.getText());
				if(cbGioiTinh.getSelectedIndex() == 0) {
					nv.setGioiTinh("Nam");
				}else nv.setGioiTinh("Nữ");
				nv.setNgayVaoLam(dcNgayvaolam.getDate());
				nv.setDiaChi(txtDiachi.getText());
				nv.setIDVaiTro(Integer.parseInt(txtIDvaitro.getText()));
				
				NhanVienDAO.insert(nv);
				
				JOptionPane.showMessageDialog(null,"Xong!");
				
				showdata(NhanVienDAO.selectAll());			
				}catch (Exception ex) {
					JOptionPane.showMessageDialog(null,"Không hợp lệ!");
				}
				
				
			}
		});
		btnThem.setBounds(10, 375, 134, 52);
		btnThem.setFont(new Font("Times New Roman", Font.BOLD, 18));
		contentPane.add(btnThem);
		
		JButton btnCapNhat = new JButton("Cập nhật");
		btnCapNhat.setBackground(new Color(250, 235, 215));
		btnCapNhat.setIcon(new ImageIcon("E:\\eclipse-workspace\\chvanphongpham\\src\\icon\\system-software-update-icon.png"));
		btnCapNhat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				NhanVien nv = new NhanVien();
				nv.setIDNhanVien(Integer.parseInt(txtID.getText()));
				nv.setTen(txtTen.getText());
				nv.setSdt(txtSDT.getText());
				if(cbGioiTinh.getSelectedIndex() == 0) {
					nv.setGioiTinh("Nam");
				}else nv.setGioiTinh("Nữ");
				nv.setNgayVaoLam(dcNgayvaolam.getDate());
				nv.setDiaChi(txtDiachi.getText());
				nv.setIDVaiTro(Integer.parseInt(txtIDvaitro.getText()));
				NhanVienDAO.update(nv);
				JOptionPane.showMessageDialog(null,"Xong!");
				showdata(NhanVienDAO.selectAll());
				}catch (Exception ex) {
					//JOptionPane.showMessageDialog(null,"Không hợp lệ!");
				}
				try{
					if(!txttenvaitro.getText().isEmpty()) {
							VaiTro vt = new VaiTro();
							vt.setIDVaiTro(Integer.parseInt(txtIDvaitro.getText()));
							vt.setTenVaiTro(txttenvaitro.getText());
							VaiTroDAO.update(vt);
							showdata(NhanVienDAO.selectAll());
							//JOptionPane.showMessageDialog(null,"Xong!");
					}
					}catch (Exception ex) {
						JOptionPane.showMessageDialog(null,"Không hợp lệ!");
					}
				
			}
		});
		btnCapNhat.setBounds(169, 375, 146, 52);
		btnCapNhat.setFont(new Font("Times New Roman", Font.BOLD, 18));
		contentPane.add(btnCapNhat);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setBackground(new Color(250, 235, 215));
		btnXoa.setIcon(new ImageIcon("E:\\eclipse-workspace\\chvanphongpham\\src\\icon\\trash-icon.png"));
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
				NhanVien nv = new NhanVien();
				nv.setIDNhanVien(Integer.parseInt(txtID.getText()));
				NhanVienDAO.delete(nv);
				JOptionPane.showMessageDialog(null,"Xong!");
				showdata(NhanVienDAO.selectAll());
				
				} catch (Exception ex) {
//					JOptionPane.showMessageDialog(null,"Không hợp lệ!");
//					ex.printStackTrace();
				}
				try {
					if(!txtIDvaitro.getText().isEmpty()) {
						VaiTro vt = new VaiTro();
						vt.setIDVaiTro(Integer.parseInt(txtIDvaitro.getText()));
						VaiTroDAO.delete(vt);
						showdata(NhanVienDAO.selectAll());
						}
				}catch (Exception ex) {
					JOptionPane.showMessageDialog(null,"Không hợp lệ!");
					ex.printStackTrace();
				}
				
			}
		});
		btnXoa.setBounds(337, 376, 134, 51);
		btnXoa.setFont(new Font("Times New Roman", Font.BOLD, 18));
		contentPane.add(btnXoa);
		
		JButton btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setBackground(new Color(250, 235, 215));
		btnLamMoi.setIcon(new ImageIcon("E:\\eclipse-workspace\\chvanphongpham\\src\\icon\\clear-icon.png"));
		btnLamMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtID.setText("");
				txtTen.setText("");
				txtDiachi.setText("");
				dcNgayvaolam.setDate(null);
				cbGioiTinh.setSelectedIndex(0);
				txtSDT.setText("");
				txtIDvaitro.setText("");
				txttenvaitro.setText("");
			}
		});
		btnLamMoi.setBounds(493, 378, 146, 47);
		btnLamMoi.setFont(new Font("Times New Roman", Font.BOLD, 18));
		contentPane.add(btnLamMoi);
		
		Panel panel = new Panel();
		panel.setBackground(new Color(230, 230, 250));
		panel.setBounds(653, 46, 389, 388);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("ID nhân viên");
		lblNewLabel_1.setBounds(57, 73, 103, 21);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		panel.add(lblNewLabel_1);
		
		JLabel lblTn_1 = new JLabel("Tên");
		lblTn_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblTn_1.setBounds(57, 108, 134, 52);
		panel.add(lblTn_1);
		
		JLabel lblTn_1_1 = new JLabel("ID Vai trò");
		lblTn_1_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblTn_1_1.setBounds(57, 159, 134, 52);
		panel.add(lblTn_1_1);
		
		JLabel lblGiiTnh_1 = new JLabel("Giới tính");
		lblGiiTnh_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblGiiTnh_1.setBounds(57, 203, 134, 52);
		panel.add(lblGiiTnh_1);
		
		JComboBox cbGioiTinh1 = new JComboBox();
		cbGioiTinh1.setBackground(new Color(255, 255, 255));
		cbGioiTinh1.setModel(new DefaultComboBoxModel(new String[] {"Nam", "Nữ"}));
		cbGioiTinh1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		cbGioiTinh1.setBounds(190, 214, 116, 31);
		panel.add(cbGioiTinh1);
		
		txtID1 = new JTextField();
		txtID1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtID1.setColumns(10);
		txtID1.setBounds(190, 73, 168, 31);
		panel.add(txtID1);
		
		txtTen1 = new JTextField();
		txtTen1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtTen1.setColumns(10);
		txtTen1.setBounds(190, 119, 168, 31);
		panel.add(txtTen1);
		
		txtVaitro1 = new JTextField();
		txtVaitro1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtVaitro1.setColumns(10);
		txtVaitro1.setBounds(190, 170, 168, 31);
		panel.add(txtVaitro1);
		
		JButton btnTmKim = new JButton("Tìm kiếm");
		btnTmKim.setBackground(new Color(250, 235, 215));
		btnTmKim.setIcon(new ImageIcon("E:\\eclipse-workspace\\chvanphongpham\\src\\icon\\search-b-icon.png"));
		btnTmKim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					try {
					NhanVien nv = new NhanVien();
					if(!txtID1.getText().isEmpty()) {
						nv.setIDNhanVien(Integer.parseInt(txtID1.getText()));
					}
					nv.setTen(txtTen1.getText());
					if(cbGioiTinh1.getSelectedIndex() == 0) {
						nv.setGioiTinh("Nam");
					}else nv.setGioiTinh("Nữ");
					if(!txtVaitro1.getText().isEmpty()) {
					nv.setIDVaiTro(Integer.parseInt(txtVaitro1.getText()));
					}
					JOptionPane.showMessageDialog(null,"Xong!");
					showdata(NhanVienDAO.search(nv));
					}catch (Exception ex) {
						JOptionPane.showMessageDialog(null,"Không hợp lệ!");
					}
			}
		});
		btnTmKim.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnTmKim.setBounds(212, 289, 146, 44);
		panel.add(btnTmKim);
		
		JButton btnNewButton_2_1_1 = new JButton("Làm mới");
		btnNewButton_2_1_1.setBackground(new Color(250, 235, 215));
		btnNewButton_2_1_1.setIcon(new ImageIcon("E:\\eclipse-workspace\\chvanphongpham\\src\\icon\\clear-icon.png"));
		btnNewButton_2_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtID1.setText("");
				txtTen1.setText("");
				txtVaitro1.setText("");
				cbGioiTinh1.setSelectedIndex(0);
				
			}
		});
		btnNewButton_2_1_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton_2_1_1.setBounds(58, 289, 144, 44);
		panel.add(btnNewButton_2_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("Tìm kiếm");
		lblNewLabel_2.setForeground(new Color(0, 128, 0));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBackground(new Color(34, 139, 34));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewLabel_2.setBounds(138, 10, 145, 36);
		panel.add(lblNewLabel_2);
		
		JButton btnList = new JButton("List");
		btnList.setIcon(new ImageIcon(FormNhanVien.class.getResource("/icon/Actions-view-calendar-list-icon.png")));
		btnList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showdata(NhanVienDAO.selectAll());
			}
		});
		btnList.setBackground(new Color(250, 235, 215));
		btnList.setForeground(new Color(255, 99, 71));
		btnList.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnList.setBounds(890, 453, 121, 39);
		contentPane.add(btnList);
		
		JButton btnNewButton = new JButton("Quay lại");
		btnNewButton.setIcon(new ImageIcon(FormNhanVien.class.getResource("/icon/Logout-icon.png")));
		btnNewButton.setBackground(new Color(250, 235, 215));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Login.id != 0) {
				dispose();
				Menu frame = new Menu();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				}else {
					dispose();
					Login frame = new Login();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				}
				
			}
		});
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton.setBounds(890, 9, 143, 31);
		contentPane.add(btnNewButton);
		
		JLabel lblTnVaiTr = new JLabel("Tên Vai trò");
		lblTnVaiTr.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblTnVaiTr.setBounds(344, 275, 134, 52);
		contentPane.add(lblTnVaiTr);
		
		txttenvaitro = new JTextField();
		txttenvaitro.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txttenvaitro.setColumns(10);
		txttenvaitro.setBounds(446, 286, 146, 31);
		contentPane.add(txttenvaitro);
		
		showdata(NhanVienDAO.selectAll());
	}
	public void showdata(List<NhanVien>nv1) {
		List<NhanVien> nvList = new ArrayList<>();
		nvList = nv1;
		DefaultTableModel tableModel1;
		table.getModel();
		tableModel1 = (DefaultTableModel)table.getModel();
		tableModel1.setRowCount(0);
		
		nvList.forEach((nhanvien) -> {
			tableModel1.addRow(new Object[] {
					nhanvien.getIDNhanVien(), nhanvien.getTen(),nhanvien.getSdt(), nhanvien.getGioiTinh(), nhanvien.getDiaChi(),
					nhanvien.getNgayVaoLam(), nhanvien.getIDVaiTro(), nhanvien.getTenVaiTro()
			});
		});
	}
}
