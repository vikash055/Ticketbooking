package com.example.demo.repository;

import java.sql.Date;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

//import com.example.demo.model.Passenger;
import com.example.demo.model.Pessanger;
@Repository
public interface PessangerRepository extends JpaRepository<Pessanger,Integer>{

	Optional<Pessanger> findByPassportNoAndDoj(int passportNo, Date doj);
    
	@Query(value="select passport_no,fname from Pessanger where fname  IS NOT NULL",nativeQuery=true)
	Pessanger findByFname(String fname);
	
	

	//@Query("from Pessanger where passportno=?1")
//	Pessanger findOne(int passportNo);

	//Pessanger findOne(int passportNo);

	

	
//	@Query("from Pessanger where passportno=?1 and date(doj)=date(?2)")
//	Optional<Pessanger> findByPassportNoAndDoj1(int passportNo, Date doj);
	
	//Optional<Pessanger> findBypassportNoAnddoj(int Passportno, Date doj);
	
		
}
