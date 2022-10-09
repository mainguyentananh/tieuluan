package sunshop.com.service;

import java.util.List;

import sunshop.com.model.chiTietDatHang;

public interface chiTietDatHangService {
	public void saveChiTietDatHang(chiTietDatHang ctdh);
	public List<chiTietDatHang> getAllChiTietDatHang(Integer iddh);
}
