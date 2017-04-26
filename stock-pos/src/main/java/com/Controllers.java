package com;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entity.Trade;
import com.services.ITradeService;
import com.services.TradeService;

@Controller
@RequestMapping(value = "/trade")
public class Controllers {

	@Autowired
	TradeService tradeService;

	@Autowired
	ITradeService tradeServices;

	@RequestMapping(value = "/load")
	@ResponseBody
	public String getByEmail(String email) {
		// Trade trade=new Trade("100", "JPM");
		try {

			for (int i = 1; i < 10000; i++) {

				Trade trade = new Trade("" + i, "JPM");
				tradeService.savetrade(trade);
				String threadId = Thread.currentThread().getName();
				System.out.println("I am thread " + threadId + " of " + 20);

			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return "Can Not loadTrade";
		}
		return "success";
	}

	@RequestMapping(value = "/save")
	@ResponseBody
	public String saveGTrade(String email) {
		// Trade trade=new Trade("100", "JPM");
		try {
			Trade trade = new Trade("100000", "IBM");
			tradeServices.savetrade(trade);

		} catch (Exception ex) {
			ex.printStackTrace();
			return "Can Not loadTrade";
		}
		return "success";
	}

	@RequestMapping(value = "/saveJdbc")
	@ResponseBody
	public String saveTradeUsingJdbc(String email) {
		
		System.out.println("Exceuting using JDBC Connection !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		try {
			Trade trade = new Trade("100000", "google");
			tradeServices.saveTradeUsingJdbc(trade);
		} catch (Exception ex) {
			ex.printStackTrace();
			return "Can Not loadTrade";
		}
		return "success";
	}

	@RequestMapping(value = "/getTrade")
	@ResponseBody
	public String getAllTrade(String email) {
		// Trade trade=new Trade("100", "JPM");
		try {
			Trade trade = new Trade("100", "JPM");
			List<Trade> list = tradeServices.getAllTrade();
			System.out.println("list " + list);

		} catch (Exception ex) {
			ex.printStackTrace();
			return "Can Not loadTrade";
		}
		return "success";
	}
}
