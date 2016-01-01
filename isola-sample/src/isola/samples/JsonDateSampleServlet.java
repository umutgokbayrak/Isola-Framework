package isola.samples;

import isola.model.JsonDateSampleItem;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.arnx.jsonic.JSON;

/**
 * Servlet implementation class JsonDateSampleServlet
 */
public class JsonDateSampleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Expires", "-1");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-control", "no-cache");
		response.setHeader("Content-Type", "text/html; charset=utf-8");

		List<JsonDateSampleItem> items = new ArrayList<JsonDateSampleItem>(); 
		for (int i=0;i<10;i++) {
			JsonDateSampleItem item = new JsonDateSampleItem();
			item.setId(i);
			item.setName("name " + i);
			item.setDtSample(getRandomDate());
			item.setTsSample(new Timestamp(getRandomDate().getTime()));
			items.add(item);
		}
		
		Map<String, List<JsonDateSampleItem>> result = new HashMap<String, List<JsonDateSampleItem>>();
		result.put("result", items);
		String enc = JSON.encode(result);
		response.getWriter().write(enc);
	}
	
	private Date getRandomDate() {
		int rnd = (int)(Math.random() * 365d);
		
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, rnd);
		return cal.getTime();
	}
	
}
