package com.example.demo.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;





import com.example.demo.model.Pessanger;
import com.example.demo.repository.PessangerRepository;



@Service
public class PessangerDao {
	@Autowired
	PessangerRepository pa;
	
	
	public Pessanger adddetail( Pessanger p) {
		pa.save(p);
		return p;
	}
	
	public String deletePessanger( int passportNo) {
		Pessanger p= pa.getOne(passportNo);
		//System.out.println(p1);
		pa.delete(p);
		return "deleted";
	}
	
	public Pessanger findOne(int passportNo)
	{
		return pa.getOne(passportNo);
		
	}
	
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
	
	*/
	
	

	public Optional<Pessanger> getPessanger( int passportNo, Date doj ) {
			return pa.findByPassportNoAndDoj(passportNo,doj);
			
		}

	public Pessanger findByName(String fname) {
		// TODO Auto-generated method stub
		return pa.findByFname(fname);
	}
	
	
	
	
	
}
