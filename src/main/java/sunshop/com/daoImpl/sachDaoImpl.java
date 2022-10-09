package sunshop.com.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sunshop.com.dao.sachDao;
import sunshop.com.model.sach;

@Repository
public class sachDaoImpl implements sachDao{

	@Autowired
	private SessionFactory sessionfactory;
	
	@Override
	public List<sach> getAllHangHoa(String page) {
		Session session = sessionfactory.getCurrentSession();
		String hql = "From sach";
		List<sach> l_hangHoa = session.createQuery(hql, sach.class).setFirstResult((Integer.valueOf(page)-1)*100).setMaxResults(100).list();	
		return l_hangHoa;
	}
	

	@Override
	public void updateHangHoa(sach hh) {
		Session session = sessionfactory.getCurrentSession();
		session.update(hh);	
	}

	@Override
	public void deleteHangHoa(int mshh) {
		Session session = sessionfactory.getCurrentSession();
		session.delete(getHangHoaByMshh(mshh));	
	}

	@Override
	public void saveHangHoa(sach hh) {
		Session session = sessionfactory.getCurrentSession();
		session.save(hh);	
	}

	@Override
	public sach getHangHoaByMshh(int mshh) {
		Session session = sessionfactory.getCurrentSession();
		sach hh = session.get(sach.class, mshh);
		return hh;
	}

	@Override
	public List<sach> search(String sach) {
		Session session = sessionfactory.getCurrentSession();
		List<sach> l_hangHoa = session.createQuery("From sach where tenSach like :sach",sach.class)
				.setParameter("sach","%"+sach+"%").list();
		return l_hangHoa;
	}

	@Override
	public long getCountHh() {
		return sessionfactory.getCurrentSession().createQuery("select count(*) from sach", Long.class)
				.getSingleResult();
	}


}
