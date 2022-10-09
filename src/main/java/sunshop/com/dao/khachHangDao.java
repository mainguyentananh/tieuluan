package sunshop.com.dao;

import java.util.List;
import sunshop.com.model.khachHang;

public interface khachHangDao {
	public List<khachHang> getAllKhachHang();
	public void updateKhachHang(khachHang kh);
	public void deleteKhachHang(int mskh);
	public void saveKhachHang(khachHang kh);
	public khachHang getKhachHangByMskh(int mskh);
	public khachHang getKhachHangByPhone(String sdt);
}
