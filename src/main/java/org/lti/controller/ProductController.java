package org.lti.controller;

import java.time.LocalDate;
import java.util.List;

import org.lti.dto.ProductDto;
import org.lti.exception.ItemNotFoundException;
import org.lti.model.Product;
import org.lti.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	
	
	
	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody ProductDto product) {
	  Product p=service.save(product);	
	  if(p==null) {
		  return new ResponseEntity<String>("Product Not Saved",HttpStatus.FAILED_DEPENDENCY);
	  }
	  return new ResponseEntity<Product>(p,HttpStatus.CREATED); 
	}
	
	
	@GetMapping("/getAllProduct")
	public ResponseEntity<?>getallProducts() throws ItemNotFoundException{
		System.out.println("getAllProduct");
		List<Product>productList=service.getAllProduct();
		if(!productList.isEmpty()) {
			return new ResponseEntity<List<Product>>(productList,HttpStatus.OK);
		}else
			 throw new ItemNotFoundException("Product List Not Found In DataBase");
		
		  //return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}

	@GetMapping("/getbydesc/{desc}")
	private ResponseEntity<?> getByDescription(@PathVariable("desc")String desc) throws ItemNotFoundException {
	  ProductDto dto=service.getByDescrption(desc);
	  
		if(dto!=null) {
			return new ResponseEntity<ProductDto>(dto,HttpStatus.OK);
		}else
			throw new ItemNotFoundException("Product Not Found");
	}
	
	@GetMapping("/calculateExpiryDate/{id}")
	private ResponseEntity<?> setExpiryProductExpiryDate(@PathVariable("id")Integer id) throws ItemNotFoundException {
	  LocalDate expiryDate=service.calcalulateExpiryDate(id);
	  
		if(expiryDate!=null) {
			return new ResponseEntity<>(expiryDate,HttpStatus.OK);
		}else
			throw new ItemNotFoundException("Product Not Found");
	}

   @GetMapping("/getproductByExpiryDateDec")
   public ResponseEntity<?>getProductsByExpiryDateDec() throws ItemNotFoundException{
	
	   List<Product>productList=service.decOrderByExpiryDate();
	   if(productList.isEmpty()) 
		   throw new ItemNotFoundException("Product Not Found");
	   
	   return new ResponseEntity<List<Product>>(productList,HttpStatus.OK);
	   
   }
   
   @DeleteMapping("/deleteExpiredProductsc")
   public ResponseEntity<?>deleteExpiredProduct() throws ItemNotFoundException{
	
	  Integer d= service.deleteExpiredProduct();
	   if(d==0) {
		   return new ResponseEntity<>("No Expired Prduct Found",HttpStatus.NOT_FOUND);
	   }else {
		   return new ResponseEntity<Integer>(d,HttpStatus.OK);
	   }
   }
   
   @GetMapping("/discount")
   public ResponseEntity<?>discount() throws ItemNotFoundException{
	   Integer d= service.discount();
	   if(d==0) {
		   return new ResponseEntity<>("No  Prduct Expiry Date Fount within 6 Months",HttpStatus.NOT_FOUND);
	   }else {
		   return new ResponseEntity<Integer>(d,HttpStatus.OK);
	   }
   }


   
}
