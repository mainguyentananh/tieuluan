package sunshop.com.model;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;


@Entity
@Table(name = "nhanvien")
public class nhanVien implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "MaSoNhanVien")
	private int id;

	@Column(name = "HoTen")
	private String hoTen;

	@Column(name = "GioiTinh")
	private boolean gioiTinh;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	@Column(name = "NgaySinh")
	private Date ngaySinh;

	@Column(name = "Email")
	private String email;

	@Column(name = "MatKhau")
	private String matKhau;

	@Column(name = "DiaChi")
	private String diaChi;

	@Column(name = "ChucVu")
	private String chucVu;

	@Column(name = "SoDienThoai")
	private String soDienThoai;

	@OneToMany(mappedBy = "maSoNhanVien")
	private List<datHang> datHang;

	public nhanVien() {

	}

	public nhanVien(int id, String hoTen, boolean gioiTinh, Date ngaySinh, String email, String matKhau, String diaChi,
			String chucVu, String soDienThoai, List<sunshop.com.model.datHang> datHang) {
		this.id = id;
		this.hoTen = hoTen;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.email = email;
		this.matKhau = matKhau;
		this.diaChi = diaChi;
		this.chucVu = chucVu;
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

	public boolean isGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getChucVu() {
		return chucVu;
	}

	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
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

	@Transient
	public List<GrantedAuthority> getAuthorities() {
		String role = "ROLE_USER";
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		if(this.getChucVu().equals("Quản Lý") || this.getChucVu().equals("Admin")) {
			role = "ROLE_ADMIN";
		}
		authorities.add(new SimpleGrantedAuthority(role));
		return authorities;
	}
	
}
