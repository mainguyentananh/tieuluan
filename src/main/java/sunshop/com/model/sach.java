package sunshop.com.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "sach")
public class sach implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MaSoSach")
	private int maSoSach;

	@Column(name = "TenSach")
	private String tenSach;

	@Column(name = "TacGia")
	private String tacGia;

	@Column(name = "Gia")
	private double gia;

	@Column(name="NamXuatBan")
	private int namXuatBan;
	
	@Column(name="CongKhai")
	private String congKhai;

	@Column(name = "Hinh")
	private String hinh;
	
	@Column(name = "SoLuong")
	private int soLuong;

	@OneToMany(mappedBy = "maSoSach")
	private List<chiTietDatHang> chiTietDatHang;

	public sach() {
	}


	public sach(int maSoSach, String tenSach, String tacGia, double gia, int namXuatBan, String congKhai, String hinh,
			int soLuong, List<sunshop.com.model.chiTietDatHang> chiTietDatHang) {
		super();
		this.maSoSach = maSoSach;
		this.tenSach = tenSach;
		this.tacGia = tacGia;
		this.gia = gia;
		this.namXuatBan = namXuatBan;
		this.congKhai = congKhai;
		this.hinh = hinh;
		this.soLuong = soLuong;
		this.chiTietDatHang = chiTietDatHang;
	}



	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public int getMaSoSach() {
		return maSoSach;
	}

	public void setMaSoSach(int maSoSach) {
		this.maSoSach = maSoSach;
	}

	public String getTenSach() {
		return tenSach;
	}

	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}

	public String getTacGia() {
		return tacGia;
	}

	public void setTacGia(String tacGia) {
		this.tacGia = tacGia;
	}

	public double getGia() {
		return gia;
	}

	public void setGia(double gia) {
		this.gia = gia;
	}

	public int getNamXuatBan() {
		return namXuatBan;
	}

	public void setNamXuatBan(int namXuatBan) {
		this.namXuatBan = namXuatBan;
	}

	public String getCongKhai() {
		return congKhai;
	}

	public void setCongKhai(String congKhai) {
		this.congKhai = congKhai;
	}

	public List<chiTietDatHang> getChiTietDatHang() {
		return chiTietDatHang;
	}

	public void setChiTietDatHang(List<chiTietDatHang> chiTietDatHang) {
		this.chiTietDatHang = chiTietDatHang;
	}



	public String getHinh() {
		return hinh;
	}



	public void setHinh(String hinh) {
		this.hinh = hinh;
	}

	

}
