package sunshop.com.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "chitietdathang")
public class chiTietDatHang implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private Pk pk;
	
	 @Embeddable
	  public static class Pk implements Serializable {
	    private static final long serialVersionUID = 1L;
	    	    
	    @Column(name="MaSoDatHang")
	    private int maSoDatHang;
	    
	    @Column(name="MaSoSach")
	    private int maSoSach;

		public int getMaSoDatHang() {
			return maSoDatHang;
		}

		public void setMaSoDatHang(int maSoDatHang) {
			this.maSoDatHang = maSoDatHang;
		}

		public int getMaSoSach() {
			return maSoSach;
		}

		public void setMaSoSach(int maSoSach) {
			this.maSoSach = maSoSach;
		}
	    
	 }
	
	@Column(name = "SoLuong")
	private int soLuong;
	
	@Column(name="GiaDatHang")
	private double giaDatHang;
	
	@ManyToOne
	@JoinColumn(name = "MaSoDatHang",insertable=false, updatable=false)
	private datHang maSoDatHang;
	
	@ManyToOne
	@JoinColumn(name = "MaSoSach",insertable=false, updatable=false)
	private sach maSoSach;

	public chiTietDatHang() {
	}

	

	
	public chiTietDatHang(Pk pk, int soLuong, double giaDatHang, datHang maSoDatHang, sach maSoSach) {
		super();
		this.pk = pk;
		this.soLuong = soLuong;
		this.giaDatHang = giaDatHang;
		this.maSoDatHang = maSoDatHang;
		this.maSoSach = maSoSach;
	}




	public Pk getPk() {
		return pk;
	}

	public void setPk(Pk pk) {
		this.pk = pk;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public double getGiaDatHang() {
		return giaDatHang;
	}

	public void setGiaDatHang(double giaDatHang) {
		this.giaDatHang = giaDatHang;
	}

	public datHang getMaSoDatHang() {
		return maSoDatHang;
	}

	public void setMaSoDatHang(datHang maSoDatHang) {
		this.maSoDatHang = maSoDatHang;
	}

	public sach getMaSoSach() {
		return maSoSach;
	}

	public void setMaSoSach(sach maSoSach) {
		this.maSoSach = maSoSach;
	}

	
}
