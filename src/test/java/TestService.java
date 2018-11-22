import java.util.ArrayList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.offcn.po.Mobile;
import com.offcn.po.Sc;
import com.offcn.service.MobileService;
import com.offcn.service.ScService;

public class TestService {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");

		/*ScService service = context.getBean(ScService.class);
		
		List<Sc> list = service.getScByBeginEndTime("2018-10-11", "2018-11-22");
	
	   for (Sc sc : list) {
		System.out.println(sc);
	}*/
		
		MobileService mservice = context.getBean(MobileService.class);
/*List<Mobile> list=new ArrayList<Mobile>();
		
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
		mservice.saves(list);
	}*/
		
		Mobile m = mservice.search("13000000011");
		System.out.println(m);
	}

}
