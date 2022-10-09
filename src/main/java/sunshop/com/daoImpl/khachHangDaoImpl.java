package sunshop.com.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sunshop.com.dao.khachHangDao;
import sunshop.com.model.khachHang;

@Repository
public class khachHangDaoImpl implements khachHangDao{
	
	@Autowired
	private SessionFactory sessionfactory;
	
	@Override
	public List<khachHang> getAllKhachHang() {
		Session session = sessionfactory.getCurrentSession();
		String hql = "From khachHang";
		List<khachHang> l_khachHang = session.createQuery(hql,khachHang.class).list();
		return l_khachHang;
	}

	@Override
	public void updateKhachHang(khachHang kh) {
		Session session = sessionfactory.getCurrentSession();
		session.update(kh);
		
	}

	@Override
	public void deleteKhachHang(int mskh) {
		Session session = sessionfactory.getCurrentSession();
		session.delete(getKhachHangByMskh(mskh));
		
	}

	@Override
	public void saveKhachHang(khachHang kh) {
		Session session = sessionfactory.getCurrentSession();
		session.save(kh);	
	}

	@Override
	public khachHang getKhachHangByMskh(int mskh) {
		Session session = sessionfactory.getCurrentSession();
		khachHang kh = session.get(khachHang.class, mskh);
		return kh;
	}

	
	/*
	tại sao phải sắp xếp giảm dần theo id. vì 1 người đặt nhiều đơn hàng từ 1 số điện thoại. ví dụ đơn hàng 1 AG. Đơn hàng 2 SG. mà viết câu truy vấn
	như vậy thì nó sẽ lấy list bình thường theo id tăng dần sẽ lấy vị trí ở an giang tìm theo sdt. vì vậy cần phải sắp id giảm dần là lấy sdt và vị trí đặt
	hàng mới nhất.
	*/
	@Override
	public khachHang getKhachHangByPhone(String sdt) {
		Session session = sessionfactory.getCurrentSession();
		String hql = "from khachHang where soDienThoai like :sdt order by id desc";
		khachHang kh = session.createQuery(hql,khachHang.class).setParameter("sdt",sdt).list().get(0);
		return kh;
	}

}
