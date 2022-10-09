package sunshop.com.dao;

import java.util.List;

import sunshop.com.model.chiTietDatHang;

public interface chiTietDatHangDao {
	public void saveChiTietDatHang(chiTietDatHang ctdh);
	public List<chiTietDatHang> getAllChiTietDatHang(Integer iddh);
}
