package io.swagger.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import io.swagger.model.ApprovingPdf;
import io.swagger.model.CGHSCity;
import io.swagger.model.Department;
import io.swagger.model.Ministry;
import io.swagger.model.NodalApplicationDetail;
import io.swagger.model.NodalPdf;
import io.swagger.model.Organization;
import io.swagger.model.StateModel;
import io.swagger.repository.ApprovingPdfRepo;
import io.swagger.repository.CGHSCityRepo;
import io.swagger.repository.DepartmentRepo;
import io.swagger.repository.MinistryRepo;
import io.swagger.repository.NodalApplicationDetailRepo;
import io.swagger.repository.NodalPdfRepo;
import io.swagger.repository.OrganizationRepo;
import io.swagger.repository.StateRepo;

@Component
@CrossOrigin(origins="http://localhost:4200")
public class Detail {
	
	@Autowired
    private NodalApplicationDetailRepo nodalApplicationdetail;
	
	@Autowired
	private NodalPdfRepo nodalpdf;
	
	@Autowired
	private ApprovingPdfRepo approvingpdfrepo;
	
	@Autowired
	private MinistryRepo ministryrepo;
	
	@Autowired
	private DepartmentRepo departmentrepo;
	
	@Autowired
	private OrganizationRepo organizationrepo;
	
	@Autowired
	private StateRepo staterepo;
	
	@Autowired
	private CGHSCityRepo cghsrepo;
	
	
	public NodalApplicationDetail getdetail(long applicationId) {
		NodalApplicationDetail detail = nodalApplicationdetail.findById(applicationId).get();
		System.out.println("detailservice"+detail);
		return detail;
	}

	public String getnodalpdf(int applicationId) {
		NodalPdf pdf = nodalpdf.findByNodalPdf(applicationId);
		return pdf.getNodalpath();
	}
	
	
	
	public Ministry getMinistryDetail(String ministryId) {
		Ministry ministrymodel = ministryrepo.findByMinistryId(ministryId);
		System.out.println("ministrydetail"+ministrymodel);
		return ministrymodel;
	}
	
	public Department getDepartmentDetail(String departmentId) {
		Department deparmentmodel = departmentrepo.findByDepartmentId(departmentId);
		System.out.println("deptdetail"+deparmentmodel);
		return deparmentmodel;
	}
	
	public Organization getOrganizationDetail(String organizationId) throws Exception {
		Optional<Organization> orgOptional = organizationrepo.findById(organizationId);
		if(!orgOptional.isPresent())
			throw new Exception("Data error: invalid organization id "+ organizationId);
		return orgOptional.get();
	}
	
	public StateModel getStateName(int stateid) {
		StateModel statemodel = staterepo.findByStateName(stateid);
		System.out.println("statename"+statemodel);
		return statemodel;
	}
	
	public CGHSCity getCghscity(Long cityid) {
		return  cghsrepo.findById(cityid).get();
	}
}
