package sunshop.com.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "dathang")
public class datHang implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "MaSoDatHang")
	private int id;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	@Column(name = "NgayDatHang")
	private Date ngayDatHang;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	@Column(name = "NgayGiaoHang")
	private Date ngayGiaoHang;

	@ManyToOne
	@JoinColumn(name = "MaSoNhanVien")
	private nhanVien maSoNhanVien;

	@ManyToOne
	@JoinColumn(name = "MaSoKhachHang")
	private khachHang maSoKhachHang;

	@OneToMany(mappedBy = "maSoDatHang")
	private List<chiTietDatHang> chiTietDatHang;

	public datHang() {
	}

	public datHang(int id, Date ngayDatHang, Date ngayGiaoHang, nhanVien maSoNhanVien, khachHang maSoKhachHang,
			List<sunshop.com.model.chiTietDatHang> chiTietDatHang) {

		this.id = id;
		this.ngayDatHang = ngayDatHang;
		this.ngayGiaoHang = ngayGiaoHang;
		this.maSoNhanVien = maSoNhanVien;
		this.maSoKhachHang = maSoKhachHang;
		this.chiTietDatHang = chiTietDatHang;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getNgayDatHang() {
		return ngayDatHang;
	}

	public void setNgayDatHang(Date ngayDatHang) {
		this.ngayDatHang = ngayDatHang;
	}

	public Date getNgayGiaoHang() {
		return ngayGiaoHang;
	}

	public void setNgayGiaoHang(Date ngayGiaoHang) {
		this.ngayGiaoHang = ngayGiaoHang;
	}

	public nhanVien getMaSoNhanVien() {
		return maSoNhanVien;
	}

	public void setMaSoNhanVien(nhanVien maSoNhanVien) {
		this.maSoNhanVien = maSoNhanVien;
	}

	public khachHang getMaSoKhachHang() {
		return maSoKhachHang;
	}

	public void setMaSoKhachHang(khachHang maSoKhachHang) {
		this.maSoKhachHang = maSoKhachHang;
	}

	public List<chiTietDatHang> getChiTietDatHang() {
		return chiTietDatHang;
	}

	public void setChiTietDatHang(List<chiTietDatHang> chiTietDatHang) {
		this.chiTietDatHang = chiTietDatHang;
	}

}
