//package io.swagger.model;
//
//import javax.persistence.OneToOne;
//
//import org.springframework.data.annotation.Id;
//
//import org.springframework.data.mongodb.core.mapping.Document;
//
//
//@Document("nodalpdf")
//public class NodalPdf {
//	@Id
//	private String nodalpath;
//	
//	Integer nodalofficerId;
//	
//	public NodalPdf() {
//		
//	}
//
//	public NodalPdf(String nodalpath, Integer nodalofficerId) {
//		super();
//		this.nodalpath = nodalpath;
//		this.nodalofficerId = nodalofficerId;
//	}
//
//	public String getNodalpath() {
//		return nodalpath;
//	}
//
//	public void setNodalpath(String nodalpath) {
//		this.nodalpath = nodalpath;
//	}
//
//	public Integer getNodalofficerId() {
//		return nodalofficerId;
//	}
//
//	public void setNodalofficerId(Integer nodalofficerId) {
//		this.nodalofficerId = nodalofficerId;
//	}
// 
//	
//	
//	
//	
//	
//	
//	
//}





package io.swagger.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Document("nodalpdf")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString

public class NodalPdf {
	
	@Field("nodalPdf")
	private String nodalpath;
	
	long nodalofficerId;
	
	
}


