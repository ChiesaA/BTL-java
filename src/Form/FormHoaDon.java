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

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import com.toedter.calendar.JDateChooser;

import ConnectionDB.ConvertDate;
import DatabaseAccessObject_DAO.*;
import vanphongpham.ChiTietHoaDon;
import vanphongpham.HoaDon;
import vanphongpham.NhanVien;
import vanphongpham.SanPham;

import Form.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextPane;

public class FormHoaDon extends JFrame {

	private JPanel contentPane;
	private JTextField txtIDhoadon;
	private JTextField txtIDnhanvien;
	private JTable table1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormHoaDon frame = new FormHoaDon();
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
	public FormHoaDon() {
		setTitle("Quản lý hóa đơn");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1073, 774);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLUE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(27, 490, 1004, 187);
		contentPane.add(scrollPane_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 230, 140));
		panel.setBounds(0, 10, 556, 470);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JDateChooser dcngayban = new JDateChooser();
		dcngayban.setBounds(239, 251, 200, 25);
		dcngayban.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel.add(dcngayban);		

		table1 = new JTable();
		table1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = table1.getSelectedRow();
				TableModel model = table1.getModel();
				txtIDhoadon.setText(model.getValueAt(index, 0).toString());
				txtIDnhanvien.setText(model.getValueAt(index, 1).toString());
				dcngayban.setDate(ConvertDate.convertDate((java.util.Date)model.getValueAt(index, 3)));				
			}
		});
		table1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"ID h\u00F3a \u0111\u01A1n", "ID nh\u00E2n vi\u00EAn", "T\u00EAn nh\u00E2n vi\u00EAn", "Ng\u00E0y B\u00E1n", "T\u1ED5ng gi\u00E1"
			}
		));
		table1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		scrollPane_1.setViewportView(table1);
		

		
		JLabel lblNewLabel_1 = new JLabel("Hóa Đơn");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 28));
		lblNewLabel_1.setBounds(201, 26, 164, 49);
		panel.add(lblNewLabel_1);
		
		JButton btnNewButton_1_3 = new JButton("");
		btnNewButton_1_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_1_3.setBounds(125, 640, 123, 41);
		panel.add(btnNewButton_1_3);
		
		JButton btnNewButton_1_4 = new JButton("Mua");
		btnNewButton_1_4.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_1_4.setBounds(316, 640, 123, 41);
		panel.add(btnNewButton_1_4);
		
		JLabel lblNgyAbsn = new JLabel("Ngày bán");
		lblNgyAbsn.setBounds(105, 245, 155, 41);
		panel.add(lblNgyAbsn);
		lblNgyAbsn.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		
		JLabel lblNgyBn = new JLabel("ID Nhân viên");
		lblNgyBn.setBounds(105, 185, 155, 41);
		panel.add(lblNgyBn);
		lblNgyBn.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		txtIDnhanvien = new JTextField();
		txtIDnhanvien.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtIDnhanvien.setBounds(239, 195, 200, 25);
		panel.add(txtIDnhanvien);
		txtIDnhanvien.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("ID Hóa đơn");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(105, 120, 155, 41);
		panel.add(lblNewLabel_2);
		
		txtIDhoadon = new JTextField();
		txtIDhoadon.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtIDhoadon.setBounds(239, 130, 200, 25);
		panel.add(txtIDhoadon);
		txtIDhoadon.setColumns(10);
		
		JTextPane txtDoanhThu = new JTextPane();
		txtDoanhThu.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtDoanhThu.setEditable(false);
		txtDoanhThu.setBounds(782, 687, 174, 34);
		contentPane.add(txtDoanhThu);
		
		JButton btnNewButton_1_3_1_3_1 = new JButton("Làm mới");
		btnNewButton_1_3_1_3_1.setBackground(new Color(255, 222, 173));
		btnNewButton_1_3_1_3_1.setIcon(new ImageIcon("E:\\eclipse-workspace\\chvanphongpham\\src\\icon\\delete-icon.png"));
		btnNewButton_1_3_1_3_1.setBounds(93, 419, 148, 41);
		panel.add(btnNewButton_1_3_1_3_1);
		btnNewButton_1_3_1_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtIDhoadon.setText("");
				txtIDnhanvien.setText("");
				dcngayban.setDate(null);
			}
		});
		btnNewButton_1_3_1_3_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		JButton btnNewButton_1_3_1_1 = new JButton("Thêm");
		btnNewButton_1_3_1_1.setBackground(new Color(255, 222, 173));
		btnNewButton_1_3_1_1.setIcon(new ImageIcon(FormHoaDon.class.getResource("/icon/Sign-Add-icon.png")));
		btnNewButton_1_3_1_1.setBounds(10, 353, 143, 41);
		panel.add(btnNewButton_1_3_1_1);
		btnNewButton_1_3_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					HoaDon hd = new HoaDon();		
					hd.setIDHoaDon(Integer.parseInt(txtIDhoadon.getText()));
					hd.setIDNhanVien(Integer.parseInt(txtIDnhanvien.getText()));
					hd.setTongGia(0);
					hd.setNgayBan(dcngayban.getDate());					
					HoaDonDAO.insert(hd);					
					JOptionPane.showMessageDialog(null,"Xong!");
					showdata(HoaDonDAO.selectAll());
					}catch (Exception ex) {
						JOptionPane.showMessageDialog(null,"Không hợp lệ!");
						ex.printStackTrace();
					}
			}
		});
		btnNewButton_1_3_1_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		JButton btnNewButton_1_3_1_2 = new JButton("Cập nhật");
		btnNewButton_1_3_1_2.setBackground(new Color(255, 222, 173));
		btnNewButton_1_3_1_2.setIcon(new ImageIcon(FormHoaDon.class.getResource("/icon/system-software-update-icon.png")));
		btnNewButton_1_3_1_2.setBounds(195, 353, 155, 41);
		panel.add(btnNewButton_1_3_1_2);
		btnNewButton_1_3_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					HoaDon hd = new HoaDon();
					hd.setIDHoaDon(Integer.parseInt(txtIDhoadon.getText()));
					hd.setIDNhanVien(Integer.parseInt(txtIDnhanvien.getText()));
					hd.setNgayBan(dcngayban.getDate());
					hd.setTongGia(0);
					HoaDonDAO.update(hd);
					JOptionPane.showMessageDialog(null,"Xong!");
					showdata(HoaDonDAO.selectAll());
					}catch (Exception ex) {
						JOptionPane.showMessageDialog(null,"Không hợp lệ!");
					}
			}
		});
		btnNewButton_1_3_1_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		JButton btnNewButton_1_3_1_3 = new JButton("Xóa");
		btnNewButton_1_3_1_3.setBackground(new Color(255, 222, 173));
		btnNewButton_1_3_1_3.setIcon(new ImageIcon(FormHoaDon.class.getResource("/icon/trash-icon.png")));
		btnNewButton_1_3_1_3.setBounds(383, 353, 143, 41);
		panel.add(btnNewButton_1_3_1_3);
		btnNewButton_1_3_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
	
					HoaDon hd = new HoaDon();
					hd.setIDHoaDon(Integer.parseInt(txtIDhoadon.getText()));		
					HoaDonDAO.delete(hd);					
					JOptionPane.showMessageDialog(null,"Xong!");
					showdata(HoaDonDAO.selectAll());
				}catch (Exception ex) {
					JOptionPane.showMessageDialog(null,"Không hợp lệ!");
				}
			}
		});
		btnNewButton_1_3_1_3.setFont(new Font("Times New Roman", Font.BOLD, 18));
		

		
		JButton btnNewButton_1_3_1_1_1 = new JButton("Tìm kiếm");
		btnNewButton_1_3_1_1_1.setBackground(new Color(255, 222, 173));
		btnNewButton_1_3_1_1_1.setIcon(new ImageIcon("E:\\eclipse-workspace\\chvanphongpham\\src\\icon\\search-b-icon.png"));
		btnNewButton_1_3_1_1_1.setBounds(296, 419, 155, 41);
		panel.add(btnNewButton_1_3_1_1_1);
		btnNewButton_1_3_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					HoaDon hd = new HoaDon();
					if(!txtIDhoadon.getText().isEmpty()) {
						hd.setIDHoaDon(Integer.parseInt(txtIDhoadon.getText()));
					}
					if(!txtIDnhanvien.getText().isEmpty()) {
						hd.setIDNhanVien(Integer.parseInt(txtIDnhanvien.getText()));
					}
					if(dcngayban.getDate()!=null) {
					hd.setNgayBan(dcngayban.getDate());
					}		
					JOptionPane.showMessageDialog(null,"Xong!");
					showdata(HoaDonDAO.search(hd));
					
					txtDoanhThu.setText("" + DoanhThu());					
					}catch (Exception ex) {
						JOptionPane.showMessageDialog(null,"Không hợp lệ!");
					}	
			}
		});
		btnNewButton_1_3_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(152, 251, 152));
		panel_1.setBounds(566, 10, 494, 429);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Thống kê");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 28));
		lblNewLabel.setBounds(208, 39, 166, 41);
		panel_1.add(lblNewLabel);
		
		JButton btnNewButton_4 = new JButton("Quay lại");
		btnNewButton_4.setIcon(new ImageIcon("E:\\eclipse-workspace\\chvanphongpham\\src\\icon\\Logout-icon.png"));
		btnNewButton_4.setBackground(new Color(255, 222, 173));
		btnNewButton_4.setBounds(332, 10, 152, 31);
		panel_1.add(btnNewButton_4);
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
		
		JLabel lblTNgy = new JLabel("Từ ngày");
		lblTNgy.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblTNgy.setBounds(74, 133, 155, 41);
		panel_1.add(lblTNgy);
		
		JDateChooser dateForm = new JDateChooser();
		dateForm.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		dateForm.setBounds(208, 139, 200, 25);
		panel_1.add(dateForm);
		
		JLabel lblnNgy = new JLabel("Đến ngày");
		lblnNgy.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblnNgy.setBounds(74, 206, 155, 41);
		panel_1.add(lblnNgy);
		
		JDateChooser dateTo = new JDateChooser();
		dateTo.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		dateTo.setBounds(208, 212, 200, 25);
		panel_1.add(dateTo);
		
		JLabel lblDoanhThu = new JLabel("Doanh Thu");
		lblDoanhThu.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblDoanhThu.setBounds(653, 687, 155, 41);
		contentPane.add(lblDoanhThu);
		
		
		JButton btnNewButton_1_3_1_3_1_1 = new JButton("Làm mới");
		btnNewButton_1_3_1_3_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 dateForm.setDate(null);
				 dateTo.setDate(null);
			}
		});
		btnNewButton_1_3_1_3_1_1.setIcon(new ImageIcon(FormHoaDon.class.getResource("/icon/delete-icon.png")));
		btnNewButton_1_3_1_3_1_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton_1_3_1_3_1_1.setBackground(new Color(255, 222, 173));
		btnNewButton_1_3_1_3_1_1.setBounds(81, 302, 148, 41);
		panel_1.add(btnNewButton_1_3_1_3_1_1);
		
		JButton btnNewButton_1_3_1_1_1_2 = new JButton("Tìm kiếm");
		btnNewButton_1_3_1_1_1_2.setIcon(new ImageIcon(FormHoaDon.class.getResource("/icon/search-b-icon.png")));
		btnNewButton_1_3_1_1_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				showdata(HoaDonDAO.report(ConvertDate.convertDate(dateForm.getDate()),ConvertDate.convertDate(dateTo.getDate())));;				
				txtDoanhThu.setText("" + DoanhThu());
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		});
		btnNewButton_1_3_1_1_1_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton_1_3_1_1_1_2.setBackground(new Color(255, 222, 173));
		btnNewButton_1_3_1_1_1_2.setBounds(302, 302, 155, 41);
		panel_1.add(btnNewButton_1_3_1_1_1_2);
		
		JButton btnNewButton_1_3_1_1_1_1 = new JButton("ListHD");
		btnNewButton_1_3_1_1_1_1.setBounds(886, 449, 145, 41);
		contentPane.add(btnNewButton_1_3_1_1_1_1);
		btnNewButton_1_3_1_1_1_1.setIcon(new ImageIcon("E:\\eclipse-workspace\\chvanphongpham\\src\\icon\\Actions-view-calendar-list-icon.png"));
		btnNewButton_1_3_1_1_1_1.setBackground(new Color(255, 222, 173));
		btnNewButton_1_3_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showdata(HoaDonDAO.selectAll());
				txtDoanhThu.setText("" + DoanhThu());
			}
		});
		btnNewButton_1_3_1_1_1_1.setForeground(new Color(220, 20, 60));
		btnNewButton_1_3_1_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		showdata(HoaDonDAO.selectAll());		
		txtIDnhanvien.setText("" + Login.id);
			
	}
	public int DoanhThu() {
		int sum = 0;
		TableModel model = table1.getModel();
		for(int i = 0; i < table1.getRowCount(); i++) {
			sum += Integer.parseInt(model.getValueAt(i, 4).toString());
		}
		return sum;
	}
	public void showdata(List<HoaDon>hd1) {
		List<HoaDon> hdList = new ArrayList<>();
		hdList = hd1;
		DefaultTableModel tableModel1;
		table1.getModel();
		tableModel1 = (DefaultTableModel)table1.getModel();
		tableModel1.setRowCount(0);
		
		hdList.forEach((hoadon) -> {
			tableModel1.addRow(new Object[] {
					hoadon.getIDHoaDon(), hoadon.getIDNhanVien(),hoadon.getTen(), 
					hoadon.getNgayBan(),hoadon.getTongGia()
			});
		});
	}
	
}
