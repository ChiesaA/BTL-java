package Form;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import ConnectionDB.ConvertDate;
import vanphongpham.NhanVien;
import vanphongpham.SanPham;
import DatabaseAccessObject_DAO.*;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class FormSanPham extends JFrame {

	private JPanel contentPane;
	private JTextField txtIDsp;
	private JTextField txtTensp;
	private JTextField txtGia;
	private JTextField txtSoluong;
	private JTable table;
	private JTextField txtTensp1;
	private JTextField txtIDsp1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormSanPham frame = new FormSanPham();
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
	public FormSanPham() {
		setTitle("Quản lý sản phẩm");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1125, 764);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(253, 245, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID sản phẩm");
		lblNewLabel.setBounds(48, 51, 144, 45);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		contentPane.add(lblNewLabel);
		
		JLabel lblTnSnPhm = new JLabel("Tên sản phẩm");
		lblTnSnPhm.setBounds(48, 106, 144, 45);
		lblTnSnPhm.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		contentPane.add(lblTnSnPhm);
		
		JLabel lblGi = new JLabel("Giá");
		lblGi.setBounds(48, 164, 144, 45);
		lblGi.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		contentPane.add(lblGi);
		
		JLabel lblSLng = new JLabel("Số lượng");
		lblSLng.setBounds(48, 231, 144, 45);
		lblSLng.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		contentPane.add(lblSLng);
		
		JLabel lblNgyNhp = new JLabel("Ngày nhập");
		lblNgyNhp.setBounds(48, 303, 144, 45);
		lblNgyNhp.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		contentPane.add(lblNgyNhp);
		
		JLabel lblThi = new JLabel("Trạng thái");
		lblThi.setBounds(48, 372, 144, 45);
		lblThi.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		contentPane.add(lblThi);
		
		txtIDsp = new JTextField();
		txtIDsp.setBounds(187, 59, 188, 33);
		txtIDsp.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		contentPane.add(txtIDsp);
		txtIDsp.setColumns(10);
		
		txtTensp = new JTextField();
		txtTensp.setBounds(187, 114, 188, 33);
		txtTensp.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtTensp.setColumns(10);
		contentPane.add(txtTensp);
		
		txtGia = new JTextField();
		txtGia.setBounds(187, 172, 188, 33);
		txtGia.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtGia.setColumns(10);
		contentPane.add(txtGia);
		
		txtSoluong = new JTextField();
		txtSoluong.setBounds(187, 239, 188, 33);
		txtSoluong.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtSoluong.setColumns(10);
		contentPane.add(txtSoluong);
		
		JDateChooser dcNgaynhap = new JDateChooser();
		dcNgaynhap.setBounds(187, 314, 184, 33);
		dcNgaynhap.getCalendarButton().setFont(new Font("Times New Roman", Font.PLAIN, 20));
		dcNgaynhap.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		contentPane.add(dcNgaynhap);
		
		JComboBox cbTrangthai = new JComboBox();
		cbTrangthai.setModel(new DefaultComboBoxModel(new String[] {"chưa bán", "đã bán"}));
		cbTrangthai.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		cbTrangthai.setBounds(187, 378, 188, 33);
		contentPane.add(cbTrangthai);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 204, 204));
		panel.setBounds(655, 51, 414, 362);
		contentPane.add(panel);
		panel.setLayout(null);

		JComboBox cbTrangthai1 = new JComboBox();
		cbTrangthai1.setModel(new DefaultComboBoxModel(new String[] {"chưa bán", "đã bán"}));
		cbTrangthai1.setBounds(183, 228, 188, 33);
		panel.add(cbTrangthai1);
		cbTrangthai1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		JButton btnNewButton = new JButton("Thêm");
		btnNewButton.setBackground(new Color(238, 232, 170));
		btnNewButton.setIcon(new ImageIcon("E:\\eclipse-workspace\\chvanphongpham\\src\\icon\\Sign-Add-icon.png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					SanPham sp = new SanPham();
					sp.setIDSanPham(Integer.parseInt(txtIDsp.getText()));
					sp.setTenSanPham(txtTensp.getText());
					sp.setGia(Integer.parseInt(txtGia.getText()));
					sp.setSoLuong(Integer.parseInt(txtSoluong.getText()));
					sp.setNgayNhap(dcNgaynhap.getDate());
					if(cbTrangthai.getSelectedIndex() == 0) {
						sp.setTrangThai("chưa bán");
					}else sp.setTrangThai("đã bán");
					SanPhamDAO.insert(sp);
					JOptionPane.showMessageDialog(null,"Xong!");
					showdata(SanPhamDAO.selectAll());
					}catch (Exception ex) {
						JOptionPane.showMessageDialog(null,"Không hợp lệ!");
					}
			}
		});
		btnNewButton.setBounds(444, 75, 154, 51);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		contentPane.add(btnNewButton);
		
		JButton btnCpNht = new JButton("Cập nhật");
		btnCpNht.setBackground(new Color(238, 232, 170));
		btnCpNht.setIcon(new ImageIcon("E:\\eclipse-workspace\\chvanphongpham\\src\\icon\\system-software-update-icon.png"));
		btnCpNht.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					SanPham sp = new SanPham();
					sp.setIDSanPham(Integer.parseInt(txtIDsp.getText()));
					sp.setTenSanPham(txtTensp.getText());
					sp.setGia(Integer.parseInt(txtGia.getText()));
					sp.setSoLuong(Integer.parseInt(txtSoluong.getText()));
					sp.setNgayNhap(dcNgaynhap.getDate());
					if(cbTrangthai.getSelectedIndex() == 0) {
						sp.setTrangThai("chưa bán");
					}else sp.setTrangThai("đã bán");
					SanPhamDAO.update(sp);
					JOptionPane.showMessageDialog(null,"Xong!");
					showdata(SanPhamDAO.selectAll());
					}catch (Exception ex) {
						JOptionPane.showMessageDialog(null,"Không hợp lệ!");
					}
			}
		});
		btnCpNht.setBounds(444, 164, 154, 51);
		btnCpNht.setFont(new Font("Times New Roman", Font.BOLD, 18));
		contentPane.add(btnCpNht);
		
		JButton btnXa = new JButton("Xóa");
		btnXa.setBackground(new Color(238, 232, 170));
		btnXa.setIcon(new ImageIcon("E:\\eclipse-workspace\\chvanphongpham\\src\\icon\\trash-icon.png"));
		btnXa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					SanPham sp = new SanPham();
					sp.setIDSanPham(Integer.parseInt(txtIDsp.getText()));
					SanPhamDAO.delete(sp);
					JOptionPane.showMessageDialog(null,"Xong!");
					showdata(SanPhamDAO.selectAll());
					}catch (Exception ex) {
						JOptionPane.showMessageDialog(null,"Không hợp lệ!");
					}
			}
		});
		btnXa.setBounds(444, 262, 154, 51);
		btnXa.setFont(new Font("Times New Roman", Font.BOLD, 18));
		contentPane.add(btnXa);
		
		JButton btnLmMi = new JButton("Làm mới");
		btnLmMi.setBackground(new Color(238, 232, 170));
		btnLmMi.setIcon(new ImageIcon(FormSanPham.class.getResource("/icon/delete-icon.png")));
		btnLmMi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtIDsp.setText("");
				txtTensp.setText("");
				txtGia.setText("");
				dcNgaynhap.setDate(null);
				txtSoluong.setText("");
				cbTrangthai1.setSelectedIndex(0);;
			}
		});
		btnLmMi.setBounds(444, 352, 154, 51);
		btnLmMi.setFont(new Font("Times New Roman", Font.BOLD, 18));
		contentPane.add(btnLmMi);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(69, 500, 977, 188);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = table.getSelectedRow();
				TableModel model = table.getModel();
				txtIDsp.setText(model.getValueAt(index, 0).toString());
				txtTensp.setText(model.getValueAt(index, 1).toString());
				txtGia.setText(model.getValueAt(index, 2).toString());
				txtSoluong.setText(model.getValueAt(index, 3).toString());
				dcNgaynhap.setDate(ConvertDate.convertDate((java.util.Date)model.getValueAt(index, 4)));
				if(model.getValueAt(index, 5).toString().equals("chưa bán")) {
					cbTrangthai.setSelectedIndex(0);
				}else cbTrangthai.setSelectedIndex(1);
				
			}
		});
		table.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		table.setForeground(new Color(0, 0, 0));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"ID s\u1EA3n ph\u1EA9m", "T\u00EAn s\u1EA3n ph\u1EA9m", "Gi\u00E1", "S\u1ED1 l\u01B0\u1EE3ng", "Ng\u00E0y nh\u1EADp", "Tr\u1EA1ng th\u00E1i"
			}
		));
		scrollPane.setViewportView(table);
		
		
		JDateChooser dcNgaynhap1 = new JDateChooser();
		dcNgaynhap1.getCalendarButton().setFont(new Font("Times New Roman", Font.PLAIN, 20));
		dcNgaynhap1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		dcNgaynhap1.setBounds(183, 177, 184, 33);
		panel.add(dcNgaynhap1);
		
		JButton btnNewButton_1 = new JButton("Tìm kiếm");
		btnNewButton_1.setBackground(new Color(238, 232, 170));
		btnNewButton_1.setIcon(new ImageIcon(FormSanPham.class.getResource("/icon/search-b-icon.png")));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					SanPham sp = new SanPham();
					if(!txtIDsp1.getText().isEmpty()) {
						sp.setIDSanPham(Integer.parseInt(txtIDsp1.getText()));
					}
					sp.setTenSanPham(txtTensp1.getText());
					if(dcNgaynhap1.getDate()!=null) {
					sp.setNgayNhap(dcNgaynhap1.getDate());
					}
					if(cbTrangthai1.getSelectedIndex() == 0) {
						sp.setTrangThai("chưa bán");
					}else sp.setTrangThai("đã bán");
					JOptionPane.showMessageDialog(null,"Xong!");
					showdata(SanPhamDAO.search(sp));
					}catch (Exception ex) {
						JOptionPane.showMessageDialog(null,"Không hợp lệ!");
					}	
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton_1.setBounds(40, 289, 151, 51);
		panel.add(btnNewButton_1);
		
		
		JButton btnNewButton_2 = new JButton("Làm mới");
		btnNewButton_2.setBackground(new Color(238, 232, 170));
		btnNewButton_2.setIcon(new ImageIcon(FormSanPham.class.getResource("/icon/delete-icon.png")));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtIDsp1.setText("");
				txtTensp1.setText("");
				dcNgaynhap1.setDate(null);
				cbTrangthai1.setSelectedIndex(0);
			}
		});
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton_2.setBounds(237, 289, 144, 51);
		panel.add(btnNewButton_2);
		
		JLabel lblNewLabel_1 = new JLabel("ID sản phẩm");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(29, 62, 144, 45);
		panel.add(lblNewLabel_1);
		
		JLabel lblTnSnPhm_1 = new JLabel("Tên sản phẩm");
		lblTnSnPhm_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblTnSnPhm_1.setBounds(29, 117, 144, 45);
		panel.add(lblTnSnPhm_1);
		
		JLabel lblNgyNhp_1 = new JLabel("Ngày nhập");
		lblNgyNhp_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNgyNhp_1.setBounds(29, 167, 144, 45);
		panel.add(lblNgyNhp_1);
		
		JLabel lblThi_1 = new JLabel("Trạng thái");
		lblThi_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblThi_1.setBounds(29, 222, 144, 45);
		panel.add(lblThi_1);
		
		txtTensp1 = new JTextField();
		txtTensp1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtTensp1.setColumns(10);
		txtTensp1.setBounds(183, 123, 188, 33);
		panel.add(txtTensp1);
		
		txtIDsp1 = new JTextField();
		txtIDsp1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtIDsp1.setColumns(10);
		txtIDsp1.setBounds(183, 68, 188, 33);
		panel.add(txtIDsp1);
		
		JLabel lblNewLabel_2 = new JLabel("Tìm kiếm");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(new Color(0, 128, 0));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewLabel_2.setBackground(new Color(34, 139, 34));
		lblNewLabel_2.setBounds(141, 10, 145, 36);
		panel.add(lblNewLabel_2);
		
		
		
		
		
		JButton btnNewButton_3 = new JButton("ListSP");
		btnNewButton_3.setIcon(new ImageIcon(FormSanPham.class.getResource("/icon/Actions-view-calendar-list-icon.png")));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showdata(SanPhamDAO.selectAll());
			}
		});
		btnNewButton_3.setForeground(new Color(0, 102, 204));
		btnNewButton_3.setBackground(new Color(255, 239, 213));
		btnNewButton_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_3.setBounds(911, 452, 135, 39);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Quay lại");
		btnNewButton_4.setIcon(new ImageIcon(FormSanPham.class.getResource("/icon/Logout-icon.png")));
		btnNewButton_4.setBackground(new Color(238, 232, 170));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NhanVien nv = new NhanVien();
				nv = NhanVienDAO.getNVByID(Login.id);
				if(nv.getIDVaiTro() == 2) {
					dispose();
					Menu frame = new Menu();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				}else {
					dispose();
					MenuNhanVien frame = new MenuNhanVien();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				}
				
			}
		});
		btnNewButton_4.setForeground(Color.RED);
		btnNewButton_4.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_4.setBounds(913, 10, 143, 31);
		contentPane.add(btnNewButton_4);
		
		showdata(SanPhamDAO.selectAll());
	}
	public void showdata(List<SanPham>sp1) {
		List<SanPham> spList = new ArrayList<>();
		spList = sp1;
		DefaultTableModel tableModel1;
		table.getModel();
		tableModel1 = (DefaultTableModel)table.getModel();
		tableModel1.setRowCount(0);
		
		spList.forEach((sanpham) -> {
			tableModel1.addRow(new Object[] {
					sanpham.getIDSanPham(), sanpham.getTenSanPham(),sanpham.getGia(), 
					sanpham.getSoLuong(),sanpham.getNgayNhap(),sanpham.getTrangThai()
			});
		});
	}
}
