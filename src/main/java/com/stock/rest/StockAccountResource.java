package com.stock.rest;

import java.util.Collection;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.stock.domain.StockAccount;
import com.stock.persistence.StockAccountRepository;
import com.stock.service.StockAccountService;

//TODO Declare the class is a REST Controller
//TODO Map the entire class to the /accounts URI
@RestController
@RequestMapping("/accounts")
public class StockAccountResource {

	static final String JSON = "application/json";

	//TODO Inject the stock account service
//	private AnnotationConfigApplicationContext ctx;
//	StockAccountService service = ctx.getBean("stockAccountService", StockAccountService.class);
	@Autowired
	StockAccountService service;
	
	
	//TODO Create a method to retrieve all the stock accounts
	@GetMapping(path = "/info", produces = JSON)
	@ResponseBody
	public Collection<StockAccount> getAccounts(HttpServletResponse response) {
		  response.setStatus(HttpServletResponse.SC_OK);
		  return service.findAll();
	}
	
	//TODO Create a method to retrieve a stock account by id
	@GetMapping(path = "/{id}", produces = JSON)
	@ResponseBody
	public StockAccount getAccountByID(@PathVariable Long id, HttpServletResponse response) {
		  response.setStatus(HttpServletResponse.SC_OK);
		  return service.findById(id);
	}
	
	//TODO Create a method to retrieve a stock account by name
	@GetMapping(path = "/{name}", produces = JSON)
	@ResponseBody
	public Collection<StockAccount> getAccountByID(@PathVariable String name, HttpServletResponse response) {
		  response.setStatus(HttpServletResponse.SC_OK);
		  return service.findByName(name);
	}
	

}
