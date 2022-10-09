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
@Table(name = "khachhang")
public class khachHang implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "MaSoKhachHang")
	private int id;

	@Column(name = "HoTen")
	private String hoTen;

	@Column(name = "Email")
	private String email;

	@Column(name = "DiaChi")
	private String diaChi;

	@Column(name = "SoDienThoai")
	private String soDienThoai;

	@OneToMany(mappedBy = "maSoKhachHang")
	private List<datHang> datHang;

	public khachHang() {
	}

	public khachHang(int id, String hoTen, String email, String diaChi, String soDienThoai,
			List<sunshop.com.model.datHang> datHang) {
		this.id = id;
		this.hoTen = hoTen;
		this.email = email;
		this.diaChi = diaChi;
		this.soDienThoai = soDienThoai;
		this.datHang = datHang;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public List<datHang> getDatHang() {
		return datHang;
	}

	public void setDatHang(List<datHang> datHang) {
		this.datHang = datHang;
	}

}
