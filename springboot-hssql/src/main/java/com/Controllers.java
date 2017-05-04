package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entity.Trade;
import com.services.ITradeService;

@Controller
@RequestMapping(value = "/trade")
public class Controllers {

	

	@Autowired
	ITradeService tradeServices;





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


}
