import java.util.ArrayList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.offcn.dao.MobileDao;
import com.offcn.po.Mobile;

public class TestDao {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-dao.xml");

		//ScDao dao = context.getBean(ScDao.class);
		/*Sc sc = new Sc();
		sc.setName("大白菜");
		sc.setAvgprice(0.55F);
		sc.setLowprice(0.5F);
		sc.setHprice(0.7F);
		sc.setGuige("普通");
		sc.setUnit("斤");
		sc.setCreatedate(new Date());
		dao.save(sc);
		System.out.println("save ok");*/
		
	/*	List<Sc> list = dao.getScByBeginEndTime("2018-11-20", "2018-11-22");
		for (Sc sc : list) {
			System.out.println(sc);
		}*/
		
		MobileDao mdao = context.getBean(MobileDao.class);
		List<Mobile> list=new ArrayList<Mobile>();
		
		Mobile m1=new Mobile();
		
		m1.setNumber("1300000");
		m1.setArea("山东 济南");
		m1.setAreacode("0531");
		m1.setMobiletype("联通");
		m1.setPostcode("1908761");
		
Mobile m2=new Mobile();
		
		m2.setNumber("1880000");
		m2.setArea("陕西 西安");
		m2.setAreacode("029");
		m2.setMobiletype("移动");
		m2.setPostcode("1008761");
		
		list.add(m1);
		list.add(m2);
		mdao.saves(list);
	}

}
