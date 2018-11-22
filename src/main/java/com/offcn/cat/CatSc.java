package com.offcn.cat;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.offcn.po.Sc;
import com.offcn.service.ScService;

public class CatSc {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		ScService service = context.getBean(ScService.class);
		for(int i=1;i<36;i++){
		String url="http://www.xinfadi.com.cn/marketanalysis/0/list/"+i+".shtml?prodname=%E5%A4%A7%E7%99%BD%E8%8F%9C&begintime=2017-01-01&endtime=2018-11-21";
 
		String html = catUrlgetHtml(url);
		//System.out.println(html);
		List<Sc> list = parseHtml(html);
		for (Sc sc : list) {
			if(sc!=null){
			service.save(sc);
			}
		}
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
	
	//抓取指定url地址的网页源码
	public static String catUrlgetHtml(String url){
		
		String html=null;
		
		CloseableHttpClient client = HttpClients.createDefault();
		
		HttpGet get = new HttpGet(url);
		
		try {
			CloseableHttpResponse response = client.execute(get);
			
			int code=response.getStatusLine().getStatusCode();
			if(code==200){
				HttpEntity entity = response.getEntity();
				html=EntityUtils.toString(entity, "utf-8");
			}
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			client.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return html;
	}
	
	//解析html源码，获取里面蔬菜数据
	public static List<Sc> parseHtml(String html){
		List<Sc> list=new ArrayList<Sc>();
		
		Document doc = Jsoup.parse(html);
		
		Element table = doc.select(".hq_table").first();
		
		Elements trs = table.select("tr");
		
		trs.remove(0);
		
		for (Element e : trs) {
			String rowStr=e.text();
			//System.out.println(rowStr);
			String[] ss = rowStr.split(" ");
			Sc sc = new Sc();
			sc.setName(ss[0]);
			sc.setLowprice(Float.parseFloat(ss[1]));
			sc.setAvgprice(Float.parseFloat(ss[2]));
			sc.setHprice(Float.parseFloat(ss[3]));
			sc.setGuige(ss[4]);
			sc.setUnit(ss[5]);
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			try {
				sc.setCreatedate(df.parse(ss[6]));
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			list.add(sc);
		}
		return list;
	}
	public void test111(){
		System.out.println("新增方法");
	}

}
