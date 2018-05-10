package com.cg.retail.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.retail.entity.Customer;
import com.cg.retail.entity.Goods;
import com.cg.retail.entity.Retailer;
import com.cg.retail.entity.Supplier;
import com.cg.retail.exception.StoreException;
import com.cg.retail.service.CustomerService;
import com.cg.retail.service.GoodsService;
import com.cg.retail.service.RetailerService;
import com.cg.retail.service.SupplierService;

@RestController

public class StoreController {
	
	@Autowired
	private CustomerService custService;
	
	@Autowired
	private SupplierService supService;
	

	@Autowired
	private GoodsService goodsService;
	
	@Autowired
	private RetailerService retailService;
	
	
	@PostMapping(path="/addCustomer")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer)
	{
		Customer cust=custService.addCustomer(customer);
		if((customer.getCustomerName()==null)|| (customer.getCustomerAddress()==null)||(customer.getPaymentMode()==null))
		{
			throw new StoreException("unable to insert");
		}
		else
		{
		return new ResponseEntity<Customer>(cust,HttpStatus.CREATED); 
		}
	}
	
	@GetMapping(path="/viewCustomer")
	public ResponseEntity<List<Customer>> viewCustomer()
	{
		
		List<Customer> custList= custService.getCustomer();
		return new ResponseEntity<List<Customer>>(custList,HttpStatus.OK);

		
	}
	
	@DeleteMapping(path="/deleteCustomer")
	public ResponseEntity<Customer> deleteCustomer( @RequestBody Integer customerId)
	{
		Customer cust= custService.deleteCustomer(customerId);
		
		return  new ResponseEntity<Customer>(cust,HttpStatus.OK); 
	}
	
	@PutMapping(path="/updateCustomer")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Integer customerId)
	{
		Customer cust=  custService.updateCustomer(customerId);
		return  new ResponseEntity<Customer>(cust,HttpStatus.OK); 

	}
	
	@PutMapping(path="/viewCustomerById")
	public ResponseEntity<Object> viewCustomerById(@RequestBody Customer customer)
	{
		Object cust=custService.viewbyId(customer);
		return new ResponseEntity<Object>(cust,HttpStatus.OK);
		
	}
	//supplier
	
	@PostMapping(path="/addSupplier")
	public ResponseEntity<Supplier> addSupplier(@RequestBody Supplier Supplier)
	{
		Supplier cust=supService.addSupplier(Supplier);
		return new ResponseEntity<Supplier>(cust,HttpStatus.CREATED); 
		
	}
	
	@GetMapping(path="/viewSupplier")
	public ResponseEntity<List<Supplier>> viewSupplier()
	{
		
		List<Supplier> custList= supService.getSupplier();
		return new ResponseEntity<List<Supplier>>(custList,HttpStatus.OK);

		
	}
	
	@DeleteMapping(path="/deleteSupplier")
	public ResponseEntity<Supplier> deleteSupplier( @RequestBody Integer supplierId)
	{
		Supplier cust= supService.deleteSupplier(supplierId);
		return  new ResponseEntity<Supplier>(cust,HttpStatus.OK); 
	}
	
	@PutMapping(path="/updateSupplier")
	public ResponseEntity<Supplier> updateSupplier(@RequestBody Integer supplierId)
	{
		Supplier cust=  supService.updateSupplier(supplierId);
		return  new ResponseEntity<Supplier>(cust,HttpStatus.OK); 

	}
	
	@PutMapping(path="/viewSupplierById")
	public ResponseEntity<Object> viewSupplierById(@RequestBody Supplier Supplier)
	{
		Object cust=supService.viewbyId(Supplier);
		return new ResponseEntity<Object>(cust,HttpStatus.OK);
		
	}
	//Goods
	
	@PostMapping(path="/addGoods")
	public ResponseEntity<Goods> addGoods(@RequestBody Goods Goods)
	{
		Goods goods=goodsService.addGoods(Goods);
		return new ResponseEntity<Goods>(goods,HttpStatus.CREATED); 
		
	}
	
	@GetMapping(path="/viewGoods")
	public ResponseEntity<List<Goods>> viewGoods()
	{
		
		List<Goods> goodsList= goodsService.getGoods();
		return new ResponseEntity<List<Goods>>(goodsList,HttpStatus.OK);

		
	}
	
	@DeleteMapping(path="/deleteGoods")
	public ResponseEntity<Goods> deleteGoods( @RequestBody Integer GoodsId)
	{
		Goods goods= goodsService.deleteGoods(GoodsId);
		return  new ResponseEntity<Goods>(goods,HttpStatus.OK); 
	}
	
	@PutMapping(path="/updateGoods")
	public ResponseEntity<Goods> updateGoods(@RequestBody Integer GoodsId)
	{
		Goods goods=  goodsService.updateGoods(GoodsId);
		return  new ResponseEntity<Goods>(goods,HttpStatus.OK); 

	}
	
	@PutMapping(path="/viewGoodsById")
	public ResponseEntity<Object> viewGoodsById(@RequestBody Goods Goods)
	{
		Object goods=goodsService.viewbyId(Goods);
		return new ResponseEntity<Object>(goods,HttpStatus.OK);
		
	}
	
	//Retailer
	

	@PostMapping(path="/addRetailer")
	public ResponseEntity<Retailer> addRetailer(@RequestBody Retailer retailer)
	{
		Retailer cust=retailService.addRetailer(retailer);
		return new ResponseEntity<Retailer>(cust,HttpStatus.CREATED); 
		
	}
}
