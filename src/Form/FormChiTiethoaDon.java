package Form;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import DatabaseAccessObject_DAO.*;
import vanphongpham.HoaDon;
import vanphongpham.NhanVien;
import vanphongpham.ChiTietHoaDon;
import vanphongpham.SanPham;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTextPane;
import com.toedter.calendar.JDateChooser;

import java.util.*;
import java.io.*;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FormChiTiethoaDon extends JFrame {

	private JPanel contentPane;
	private JTextField txtidsp;
	private JTextField txtsoluong;
	private JTextField txtidhoadon;
	private JTable table;
	private JTextField txtIDhd1;
	private JTextField txtIDnv;
	private JTable table_1;
	private JTextField txttennv;
	private JTable table_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormChiTiethoaDon frame = new FormChiTiethoaDon();
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
	public FormChiTiethoaDon() {
		setTitle("Quản lý chi tiết hóa đơn");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1133, 756);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton_4 = new JButton("Quay lại");
		btnNewButton_4.setIcon(new ImageIcon("E:\\eclipse-workspace\\chvanphongpham\\src\\icon\\Logout-icon.png"));
		btnNewButton_4.setBounds(966, 10, 143, 31);
		contentPane.add(btnNewButton_4);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NhanVien nv = new NhanVien();
				nv = NhanVienDAO.getNVByID(Login.id);
				if (nv.getIDVaiTro() == 2) {
					dispose();
					Menu frame = new Menu();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} else {
					dispose();
					MenuNhanVien frame = new MenuNhanVien();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				}

			}
		});
		btnNewButton_4.setForeground(Color.RED);
		btnNewButton_4.setFont(new Font("Times New Roman", Font.BOLD, 20));

		JPanel panel = new JPanel();
		panel.setBackground(new Color(250, 240, 230));
		panel.setBounds(23, 22, 543, 677);
		contentPane.add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(240, 255, 240));
		panel_1.setBounds(576, 179, 523, 530);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblIdSnPhm = new JLabel("ID Sản Phẩm");
		lblIdSnPhm.setBounds(104, 192, 155, 41);
		panel.add(lblIdSnPhm);
		lblIdSnPhm.setFont(new Font("Times New Roman", Font.PLAIN, 20));

		txtidsp = new JTextField();
		txtidsp.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtidsp.setBounds(238, 202, 200, 25);
		panel.add(txtidsp);
		txtidsp.setColumns(10);

		JLabel lblSLng = new JLabel("Số lượng");
		lblSLng.setBounds(104, 249, 155, 41);
		panel.add(lblSLng);
		lblSLng.setFont(new Font("Times New Roman", Font.PLAIN, 20));

		txtsoluong = new JTextField();
		txtsoluong.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtsoluong.setBounds(238, 259, 200, 25);
		panel.add(txtsoluong);
		txtsoluong.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 480, 477, 187);
		panel.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = table.getSelectedRow();
				TableModel model = table.getModel();
				txtidhoadon.setText(model.getValueAt(index, 0).toString());
				txtidsp.setText(model.getValueAt(index, 1).toString());
				txtsoluong.setText(model.getValueAt(index, 4).toString());
			}
		});
		table.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null }, },
				new String[] { "ID H\u00F3a \u0111\u01A1n", "ID S\u1EA3n ph\u1EA3m", "T\u00EAn s\u1EA3n ph\u1EA3m",
						"\u0110\u01A1n gi\u00E1", "S\u1ED1 l\u01B0\u1EE3ng", "Th\u00E0nh ti\u1EC1n" }));
		table.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		scrollPane.setViewportView(table);

		JLabel lblNewLabel_1_1 = new JLabel("Chi Tiết Hóa Đơn");
		lblNewLabel_1_1.setBounds(169, 38, 237, 49);
		panel.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 24));

		JLabel lblNewLabel = new JLabel("ID Hóa đơn");
		lblNewLabel.setBounds(104, 125, 155, 41);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));

		txtidhoadon = new JTextField();
		txtidhoadon.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtidhoadon.setBounds(238, 135, 200, 25);
		panel.add(txtidhoadon);
		txtidhoadon.setColumns(10);

		JDateChooser dcngayban = new JDateChooser();
		dcngayban.setBounds(213, 243, 195, 25);
		dcngayban.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel_1.add(dcngayban);

		JTextPane txtTonggia = new JTextPane();
		txtTonggia.setEditable(false);
		txtTonggia.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtTonggia.setBounds(349, 449, 148, 34);
		panel_1.add(txtTonggia);

		JButton btnNewButton_1_3_1_1_1 = new JButton("Thêm");
		btnNewButton_1_3_1_1_1
				.setIcon(new ImageIcon("E:\\eclipse-workspace\\chvanphongpham\\src\\icon\\Sign-Add-icon.png"));
		btnNewButton_1_3_1_1_1.setBackground(new Color(255, 222, 173));
		btnNewButton_1_3_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					int idsanpham;
					int soluong;
					idsanpham = Integer.parseInt(txtidsp.getText());
					soluong = Integer.parseInt(txtsoluong.getText());
					
					SanPham sp = new SanPham();
					sp = SanPhamDAO.getSanPhamByID(idsanpham);
					if (sp.getSoLuong() >= soluong) {
						soluong = sp.getSoLuong() - soluong;
						sp.setSoLuong(soluong);
						if (sp.getSoLuong() == 0) {
							sp.setTrangThai("đã bán");
						}
						SanPhamDAO.update(sp);
						
						ChiTietHoaDon ct = new ChiTietHoaDon();
						ct.setIDHoaDon(Integer.parseInt(txtidhoadon.getText()));
						ct.setIDSanPham(Integer.parseInt(txtidsp.getText()));
						ct.setSoLuong(Integer.parseInt(txtsoluong.getText()));
						ct.setDonGia(sp.getGia());
						ct.setThanhTien(ct.getDonGia() * ct.getSoLuong());						
						ChiTietHoaDonDAO.insert(ct);
						
						showdata(ChiTietHoaDonDAO.selectAll());
						showdataSP(SanPhamDAO.selectAll());
						JOptionPane.showMessageDialog(null, "Xong");
					} else {
						JOptionPane.showMessageDialog(null, "Sản phẩm không đủ!");
					}											
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Không hợp lệ!");
				}
				
			}
		});
		btnNewButton_1_3_1_1_1.setBounds(29, 344, 139, 41);
		panel.add(btnNewButton_1_3_1_1_1);
		btnNewButton_1_3_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 18));

		JButton btnXoa = new JButton("Xóa");
		btnXoa.setIcon(new ImageIcon("E:\\eclipse-workspace\\chvanphongpham\\src\\icon\\trash-icon.png"));
		btnXoa.setBackground(new Color(255, 222, 173));
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ChiTietHoaDon ct = new ChiTietHoaDon();
					ct.setIDHoaDon(Integer.parseInt(txtidhoadon.getText()));
					ct.setIDSanPham(Integer.parseInt(txtidsp.getText()));
					ct.setSoLuong(Integer.parseInt(txtsoluong.getText()));
					ChiTietHoaDonDAO.delete(ct);
					JOptionPane.showMessageDialog(null, "Xong!");
					showdata(ChiTietHoaDonDAO.selectAll());
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Không hợp lệ!");
				}
			}
		});
		btnXoa.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnXoa.setBounds(211, 344, 139, 41);
		panel.add(btnXoa);

		JButton btnNewButton_1_3_1_1_1_1 = new JButton("Tìm Kiếm");
		btnNewButton_1_3_1_1_1_1
				.setIcon(new ImageIcon("E:\\eclipse-workspace\\chvanphongpham\\src\\icon\\search-b-icon.png"));
		btnNewButton_1_3_1_1_1_1.setBackground(new Color(255, 222, 173));
		btnNewButton_1_3_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int idhoadon;
					ChiTietHoaDon ct = new ChiTietHoaDon();
					txtIDhd1.setText("" + txtidhoadon.getText());
					idhoadon = Integer.parseInt(txtidhoadon.getText());

					HoaDon hd = new HoaDon();
					hd = HoaDonDAO.getHoaDon(idhoadon);
					txtIDnv.setText("" + hd.getIDNhanVien());
					txttennv.setText("" + hd.getTen());
					dcngayban.setDate(hd.getNgayBan());

					ct = ChiTietHoaDonDAO.Tonggia(idhoadon);
					txtTonggia.setText("" + ct.getThanhTien());
					ct.setIDHoaDon(Integer.parseInt(txtidhoadon.getText()));
					ct.setDonGia(ct.getDonGia());
					hd.setTongGia(Integer.parseInt(txtTonggia.getText()));
					HoaDonDAO.update(hd);
					showdataHD(ChiTietHoaDonDAO.getCTHD(idhoadon));

				} catch (Exception ex) {
					ex.printStackTrace();
				}

			}
		});

		btnNewButton_1_3_1_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton_1_3_1_1_1_1.setBounds(199, 405, 155, 49);
		panel.add(btnNewButton_1_3_1_1_1_1);

		JButton btnLmMi = new JButton("Làm mới");
		btnLmMi.setIcon(new ImageIcon("E:\\eclipse-workspace\\chvanphongpham\\src\\icon\\delete-icon.png"));
		btnLmMi.setBackground(new Color(255, 222, 173));
		btnLmMi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtidhoadon.setText("");
				txtidsp.setText("");
				txtsoluong.setText("");
			}
		});
		btnLmMi.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnLmMi.setBounds(380, 344, 139, 41);
		panel.add(btnLmMi);

		JLabel lblNewLabel_1_1_1 = new JLabel("Hóa Đơn");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblNewLabel_1_1_1.setBounds(154, 22, 237, 49);
		panel_1.add(lblNewLabel_1_1_1);

		JLabel lblNewLabel_1 = new JLabel("ID Hóa đơn");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(78, 81, 155, 41);
		panel_1.add(lblNewLabel_1);

		txtIDhd1 = new JTextField();
		txtIDhd1.setEditable(false);
		txtIDhd1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtIDhd1.setColumns(10);
		txtIDhd1.setBounds(212, 91, 200, 25);
		panel_1.add(txtIDhd1);

		JLabel lblIdNhnVin = new JLabel("ID Nhân viên");
		lblIdNhnVin.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblIdNhnVin.setBounds(78, 132, 155, 41);
		panel_1.add(lblIdNhnVin);

		txtIDnv = new JTextField();
		txtIDnv.setEditable(false);
		txtIDnv.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtIDnv.setColumns(10);
		txtIDnv.setBounds(212, 142, 200, 25);
		panel_1.add(txtIDnv);

		JLabel lblNewLabel_3 = new JLabel("Ngày bán");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(78, 234, 155, 41);
		panel_1.add(lblNewLabel_3);

		JLabel txt = new JLabel("Tổng giá");

		txt.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txt.setBounds(242, 449, 155, 41);
		panel_1.add(txt);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(20, 285, 477, 126);
		panel_1.add(scrollPane_1);

		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null },
				{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
				{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
				{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null }, },
				new String[] { "ID s\u1EA3n ph\u1EA9m", "T\u00EAn s\u1EA3n ph\u1EA9m", "\u0110\u01A1n gi\u00E1",
						"S\u1ED1 l\u01B0\u1EE3ng", "Th\u00E0nh ti\u1EC1n" }));
		table_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		scrollPane_1.setViewportView(table_1);

		JLabel lblTnNhnVin = new JLabel("Tên Nhân viên");
		lblTnNhnVin.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblTnNhnVin.setBounds(78, 183, 155, 41);
		panel_1.add(lblTnNhnVin);

		txttennv = new JTextField();
		txttennv.setEditable(false);
		txttennv.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txttennv.setColumns(10);
		txttennv.setBounds(212, 193, 200, 25);
		panel_1.add(txttennv);

		JButton btnXutHan = new JButton("Xuất hóa đơn");
		btnXutHan.setIcon(new ImageIcon("E:\\eclipse-workspace\\chvanphongpham\\src\\icon\\note-add-icon.png"));
		btnXutHan.setBackground(new Color(255, 222, 173));
		btnXutHan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					File file = new File("D:\\hoadon.txt");
					FileOutputStream output = new FileOutputStream(file);
					OutputStreamWriter outputWrite = new OutputStreamWriter(output);

					int idhoadon;
					idhoadon = Integer.parseInt(txtidhoadon.getText());
					List<ChiTietHoaDon> cthd = new ArrayList<>();
					cthd = ChiTietHoaDonDAO.getCTHD(idhoadon);

					HoaDon hd = new HoaDon();
					hd = HoaDonDAO.getHoaDon(idhoadon);
					String tennv = hd.getTen();
					Date ngayban = hd.getNgayBan();
					String txt1 = "ID hóa đơn: " + idhoadon + "\n" + "Tên nhân viên: " + tennv + "\n" + "Ngày bán: "
							+ ngayban;
					String txt2 = "\n-------------------------\n";
					outputWrite.write(txt1 + txt2);
					for (int i = 0; i < cthd.size(); i++) {

						String tensp = cthd.get(i).getTenSanPham();
						int dongia = cthd.get(i).getDonGia();
						int soluong = cthd.get(i).getSoLuong();
						int thanhtien = cthd.get(i).getThanhTien();

						String txt3 = "\nTenSP: " + tensp + "\n" + "Don gia: " + dongia + "\n" + "So luong: " + soluong
								+ "\n" + "Thanh tien: " + thanhtien + "\n";
						String txt4 = "-------------------------\n";
						String txt = txt3 + txt4;
						outputWrite.write(txt);

					}
					int tonggia = hd.getTongGia();
					String txt5 = "\n" + "Tổng giá: " + tonggia;
					outputWrite.write(txt5);
					outputWrite.flush();
					output.close();
					JOptionPane.showMessageDialog(null, "Xong!");
				} catch (Exception ex) {
					ex.getStackTrace();
				}

			}
		});
		btnXutHan.setForeground(new Color(0, 0, 0));
		btnXutHan.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnXutHan.setBounds(20, 449, 184, 41);
		panel_1.add(btnXutHan);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(603, 51, 491, 118);
		contentPane.add(scrollPane_2);

		table_2 = new JTable();
		table_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = table_2.getSelectedRow();
				TableModel model = table_2.getModel();
				txtidsp.setText(model.getValueAt(index, 0).toString());
			}
		});
		table_2.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null }, },
				new String[] { "Id s\u1EA3n ph\u1EA9m", "T\u00EAn s\u1EA3n ph\u1EA9m", "Gi\u00E1",
						"S\u1ED1 l\u01B0\u1EE3ng", "Ng\u00E0y nh\u1EADp", "Tr\u1EA1ng th\u00E1i" }));
		table_2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		scrollPane_2.setViewportView(table_2);

		JLabel lblNewLabel_2 = new JLabel("Bảng sản phẩm");
		lblNewLabel_2.setBounds(593, 22, 157, 31);
		contentPane.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 20));

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 218, 185));
		panel_2.setBounds(576, 22, 523, 156);
		contentPane.add(panel_2);

		showdata(ChiTietHoaDonDAO.selectAll());
		showdataHD(ChiTietHoaDonDAO.selectAll());
		showdataSP(SanPhamDAO.selectAll());
	}

	public void showdata(List<ChiTietHoaDon> ct1) {
		List<ChiTietHoaDon> cthdList = new ArrayList<>();
		cthdList = ct1;
		DefaultTableModel tableModel1;
		table.getModel();
		tableModel1 = (DefaultTableModel) table.getModel();
		tableModel1.setRowCount(0);

		cthdList.forEach((ct) -> {
			tableModel1.addRow(new Object[] { ct.getIDHoaDon(), ct.getIDSanPham(), ct.getTenSanPham(), ct.getDonGia(),
					ct.getSoLuong(), ct.getThanhTien() });
		});
	}

	public void showdataHD(List<ChiTietHoaDon> ct1) {
		List<ChiTietHoaDon> cthdList = new ArrayList<>();
		cthdList = ct1;
		DefaultTableModel tableModel1;
		table_1.getModel();
		tableModel1 = (DefaultTableModel) table_1.getModel();
		tableModel1.setRowCount(0);

		cthdList.forEach((ct) -> {
			tableModel1.addRow(new Object[] { ct.getIDSanPham(), ct.getTenSanPham(), ct.getDonGia(), ct.getSoLuong(),
					ct.getThanhTien() });
		});
	}

	public void showdataSP(List<SanPham> sp1) {
		List<SanPham> spList = new ArrayList<>();
		spList = sp1;
		DefaultTableModel tableModel1;
		table_2.getModel();
		tableModel1 = (DefaultTableModel) table_2.getModel();
		tableModel1.setRowCount(0);

		spList.forEach((sanpham) -> {
			tableModel1.addRow(new Object[] { sanpham.getIDSanPham(), sanpham.getTenSanPham(), sanpham.getGia(),
					sanpham.getSoLuong(), sanpham.getNgayNhap(), sanpham.getTrangThai() });
		});
	}
}
