package io.swagger.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.model.CGHSCity;
import io.swagger.repository.CGHSCityRepo;

@RestController
@CrossOrigin
@RequestMapping(value="/api/v1/")
public class CghsCityController {
	
	@Autowired
	private CGHSCityRepo cghscityrepo;
	
	@RequestMapping(value="/CghsCity/{cityid}",method= RequestMethod.GET)
	public ResponseEntity<CGHSCity> getCityName(@PathVariable Long cityid) {
		CGHSCity cghscity = cghscityrepo.findById(cityid).get();
		return new ResponseEntity<CGHSCity>(cghscity,HttpStatus.OK);
	}
	
	@RequestMapping(value="/CghsCities",method= RequestMethod.GET)
	public ResponseEntity<List<CGHSCity>> getCitiesDetail() {
		List<CGHSCity> cghscity = cghscityrepo.findAll();
		System.out.println(cghscity);
		return new ResponseEntity<List<CGHSCity>>(cghscity,HttpStatus.OK);
	}

}
