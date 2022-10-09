package sunshop.com.service;

import java.util.List;

import sunshop.com.model.datHang;

public interface datHangService {
	public List<datHang> getAllDatHang();
	public void updateDatHang(datHang dh);
	public void deleteDatHang(int msdh);
	public void saveDatHang(datHang dh);
	public datHang getDatHangByMsdh(int msdh);
	public datHang getDatHangByMskh(int mskh);
}
