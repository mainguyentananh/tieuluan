package sunshop.com.dao;

import java.util.List;

import sunshop.com.model.sach;

public interface sachDao {
	public List<sach> getAllHangHoa(String page);
	public void updateHangHoa(sach hh);
	public void deleteHangHoa(int mshh);
	public void saveHangHoa(sach hh);
	public sach getHangHoaByMshh(int mshh);
	public List<sach> search(String sach, String page);
	public long getCountHh();
	public long getCountSearch(String sach);
}
