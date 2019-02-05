package com.example.demo.controller;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.http.ResponseEntity;
//import org.springframework.http.ResponseEntity;
//import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//import com.example.demo.model.Passenger;
import com.example.demo.model.Pessanger;
//import com.letsstartcoding.springbootrestapiexample.model.Employee;

import com.example.demo.service.PessangerDao;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
//import com.example.demo.service.PassengerService;
//import com.example.demo.service.PessangerService;

@Api(value="ticketbooking")
@RestController
@RequestMapping("/api")
public class ControllerDetail {

	@Autowired
	PessangerDao pd;

	
	@ApiOperation(value="addPessanger")
	@PostMapping("/add")
	public Pessanger adddetail(@RequestBody  @Valid Pessanger p) {
		
		return pd.adddetail(p);
	}
	
	@ApiOperation(value="getallPessanger")
	@GetMapping("/getAll")
	public List<Pessanger> getPessanger() {
		
		return pd.getPessanger();
	}
	
	@ApiOperation(value="getpessangerviapassport")
	@GetMapping("/getPassport")
	public Pessanger getPessanger1(int passportNo) {
		
		return pd.findOne(passportNo);
	}
	
	@ApiOperation(value="getpessangervianame")
	@GetMapping("/get/{name}")
	public Pessanger getPessanger2(String fname) {
		
		return pd.findByName(fname);
	}
	
	
	
	
	@ApiOperation(value="getallPessangerdetail")
	@GetMapping(value = "/get/{passportNo}/{doj}")
	public ResponseEntity<Optional<Pessanger>> getPessanger( @PathVariable("passportNo") int passportNo,@PathVariable("doj") Date doj ) {
			
		Optional<Pessanger> p=pd.getPessanger(passportNo, doj);
		if(p==null)
		{
			
			return ResponseEntity.notFound().build();
		}
		
		
		return ResponseEntity.ok().body(p);
			
			
		}
	
	
	
	@ApiOperation(value="deletPessanger")
	@DeleteMapping("/delete/{passportNo}")
	public  String deletePessanger(@PathVariable int passportNo) {
	//	Pessanger p=pd.findOne(passportNo);
	//	if(p==null)
	//	{
	//		return ResponseEntity.notFound().build();
	//	}
		
	//	pd.deletePessanger(passportNo);
	//	return ResponseEntity.ok().body(p);
		return pd.deletePessanger(passportNo);
	}
	
	
	
	@PutMapping("/employees/{passportNo}")
	public ResponseEntity<Pessanger> updateEmployee(@PathVariable(value="passportNo") int passportNo,@Valid @RequestBody Pessanger p){
		
		Pessanger emp=pd.findOne(passportNo);
		if(emp==null) {
			return ResponseEntity.notFound().build();
		}
		
		p.setFname(p.getFname());
		p.setLname(p.getLname());
		p.setId(p.getId());
		p.setPassportNo(p.getPassportNo());
		p.setDoj(p.getDoj());
		
		Pessanger updatePessanger=pd.adddetail(p);
		return ResponseEntity.ok().body(updatePessanger);
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}	
	
	
	
	
	//@Autowired
 //PessangerService ps;
	/*
	 * public PessangerDao getPa() { return pa; } public void setPa(PessangerDao pa)
	 * { this.pa = pa; }
	 */
	/*
	 * @RequestMapping(value = "/home") public String home() { return "home"; }
	 
	@ApiOperation(value="addPessanger")
	@PostMapping("/add")
	public Pessanger adddetail(@RequestBody  @Valid Pessanger p) {
		pa.save(p);
		return p;
	}
	@ApiOperation(value="deletPessanger")
	@DeleteMapping("/delete/{passportNo}")
	public String deletePessanger(@PathVariable int passportNo) {
		Pessanger p= pa.getOne(passportNo);
		//System.out.println(p1);
		pa.delete(p);
		return "deleted";
	}
	
	@ApiOperation(value="getallPessanger")
	@GetMapping("/getAll")
	public List<Pessanger> getPessanger() {
		
		return pa.findAll();
	}
	
	/*
	@ApiOperation(value="Pessanger")
	@GetMapping("/pessanger/{passportno}")
	public ResponseEntity<Pessanger> getEmployeeById(@PathVariable(value="passportno") int passportNo){
		
		Pessanger p=pa.findOne(passportNo);
		
		if(p==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(p);
		
	}
	
	
	
	
	@ApiOperation(value="getallPessangerdetail")
	@GetMapping(value = "/get/{passportNo}/{doj}")
	public Optional<Pessanger> getPessanger(@PathVariable("passportNo") int passportNo,@PathVariable("doj") Date doj ) {
			return pa.findByPassportNoAndDoj(passportNo,doj);
			
		}
	
	@PutMapping("/update")
	public Pessanger addorupdate(@RequestBody  @Valid Pessanger p) {
		pa.save(p);
		return p;
	}
	
	/*	
	@GetMapping(value = "/get/{passportNo}/{doj}")
public Optional<Pessanger> getPessanger(@PathVariable("passportNo") int passportNo,@PathVariable("doj") Date doj ) {
		return pa.findByPassportNoAndDoj(passportNo,doj);
	}
	

	@GetMapping(value = "/get/{passportNo}/{doj}")
 // @RequestMapping("/reg/{doj}")
  public String registerPassenger(Pessanger p) {
  String exists; 
  if(ps.validateUserDate(p)) 
  {
	  pa.save(p); 
	  exists = "The user exists on registered date";
  } 
  else 
  { 
exists = "The user doesn't exist on the registered date";
  } 
  return exists; 
  }
  */
  
 