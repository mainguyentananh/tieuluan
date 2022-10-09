package sunshop.com.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sunshop.com.dao.datHangDao;
import sunshop.com.model.datHang;

@Repository
public class datHangDaoImpl implements datHangDao{
	
	@Autowired
	private SessionFactory sessionfactory;
	
	@Override
	public List<datHang> getAllDatHang() {
		Session session = sessionfactory.getCurrentSession();
		String hql = "From datHang";
		List<datHang> l_datHang = session.createQuery(hql,datHang.class).list();
		return l_datHang;
	}

	@Override
	public void updateDatHang(datHang dh) {
		Session session = sessionfactory.getCurrentSession();
		session.update(dh);
		
	}

	@Override
	public void deleteDatHang(int msdh) {
		Session session = sessionfactory.getCurrentSession();
		session.delete(getDatHangByMsdh(msdh));
		
	}

	@Override
	public void saveDatHang(datHang dh) {
		Session session = sessionfactory.getCurrentSession();
		session.save(dh);
		
	}

	@Override
	public datHang getDatHangByMsdh(int msdh) {
		Session session = sessionfactory.getCurrentSession();
		datHang dh = session.get(datHang.class, msdh);
		return dh;
	}

	@Override
	public datHang getDatHangByMskh(int mskh) {
		Session session = sessionfactory.getCurrentSession();
		String hql = "from datHang where maSoKhachHang.id =:mskh";
		datHang dh = session.createQuery(hql,datHang.class).setParameter("mskh",mskh).list().get(0);
		return dh;
	}

}
