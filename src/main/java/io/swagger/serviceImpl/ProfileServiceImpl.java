package io.swagger.serviceImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import io.swagger.enums.RoleEnum;
import io.swagger.model.ApprovingAuthority;
import io.swagger.model.ApprovingAuthorityUser;
import io.swagger.model.BeneficiaryUser;
import io.swagger.model.CGHSCity;
import io.swagger.model.CGHSIncharge;
import io.swagger.model.CGHSUser;
import io.swagger.model.Department;
import io.swagger.model.Ministry;
import io.swagger.model.NodalUser;
import io.swagger.model.Organization;
import io.swagger.model.OrganizationOffice;
import io.swagger.model.ParichayUser;
import io.swagger.model.Role;
import io.swagger.repository.ApprovingAuthorityUserRepo;
import io.swagger.repository.BeneficiaryUserRepo;
import io.swagger.repository.CGHSCityRepo;
import io.swagger.repository.CGHSInchargeRepo;
import io.swagger.repository.CGHSUserRepo;
import io.swagger.repository.DepartmentRepo;
import io.swagger.repository.MinistryRepo;
import io.swagger.repository.NodalUserRepo;
import io.swagger.repository.OrganizationOfficeRepo;
import io.swagger.repository.OrganizationRepo;
import io.swagger.repository.ParichayUserRepo;
import io.swagger.repository.RoleRepo;
import io.swagger.resources.ParichayUserResource;
import io.swagger.resources.ProfileResource;
import io.swagger.service.ProfileService;


@Service
public class ProfileServiceImpl implements ProfileService {
	

    @Autowired
	private ModelMapper  modelMapper;
    @Autowired
	private RoleRepo roleRepo;
	@Autowired
	private OrganizationRepo organizationRepo;

	@Autowired
	private DepartmentRepo departmentRepo;

    @Autowired
	private BeneficiaryUserRepo beneficiaryUserRepo;

	@Autowired
	private NodalUserRepo nodalUserRepo;

    @Autowired
	private CGHSInchargeRepo cghsInchargeRepo;
	@Autowired
	private CGHSCityRepo cghsCityRepo;
	@Autowired
	private ApprovingAuthorityUserRepo approvingAuthorityUserRepo;

	@Autowired
	private OrganizationOfficeRepo organizationOfficeRepo;

    @Autowired
	private ParichayUserRepo parichayUserRepo;

    @Autowired
	private CGHSUserRepo cghsUserRepo;

    @Autowired
	private MinistryRepo ministryRepo;

	public ProfileServiceImpl(){
		super();
	}

    @Override
    public ParichayUserResource create(ProfileResource profileResource,HttpServletRequest request ) throws Exception {      
        ParichayUserResource parichayResource = new ParichayUserResource();
		Long parichayUserId = (Long) request.getAttribute("currentUserId");
         if(profileResource!=null){
            Optional<ParichayUser> optionalParichayUser = parichayUserRepo.findById(parichayUserId);
				if (!optionalParichayUser.isPresent())
					throw new Exception("Data error: invalid parichay user id");
				ParichayUser parichayUser = optionalParichayUser.get();
				long roleId = profileResource.getRoleId();
				Optional<Role> optionalRoleId = roleRepo.findById(roleId);
				if (!optionalRoleId.isPresent())
					throw new Exception("Data Error: Invalid role Id");
				Role role = optionalRoleId.get();
				if (role.getId() == RoleEnum.beneficiary.getValue()) {

					// BeneficiaryUser  beneficiaryUser =	this.modelMapper.map(profileResource, BeneficiaryUser.class);
					BeneficiaryUser beneficiaryUser = new BeneficiaryUser();
					beneficiaryUser.setParichayuser(parichayUser);
					beneficiaryUser.setUserName(profileResource.getUserName());
					beneficiaryUser.setEmpCode(profileResource.getEmpCode());
					beneficiaryUser.setEmail(profileResource.getEmail());
					beneficiaryUser.setMobileNo(profileResource.getMobile());
					beneficiaryUser.setDesignation(profileResource.getDesignation());

					Optional<Ministry> minOptional = ministryRepo.findById(profileResource.getMinistry());
					if (!minOptional.isPresent())
						throw new Exception("Data Error: Invalid ministry code");
					Optional<Organization> orgOptional = organizationRepo.findById(profileResource.getOrganization());
					if (!orgOptional.isPresent())
						throw new Exception("Data Error: Invalid organization code");
					Optional<Department> deptOptional = departmentRepo.findById(profileResource.getDepartment());
						if (!deptOptional.isPresent())
						throw new Exception("Data Error: Invalid department code");
						
					beneficiaryUser.setMinistry(minOptional.get());
					beneficiaryUser.setDepartment(deptOptional.get());
					beneficiaryUser.setOrganization(orgOptional.get());
					beneficiaryUser.setCreatedOn(LocalDateTime.now());
					beneficiaryUser.setUpdatedOn(LocalDateTime.now());
					beneficiaryUser.setCreatedBy(parichayUser);
					beneficiaryUser.setUpdatedBy(parichayUser);
					beneficiaryUser.setDeleted(false);
					beneficiaryUser.setRole(role);

					Optional<OrganizationOffice> orgOfficeOptional= organizationOfficeRepo.findById(profileResource.getOrganizationOfficeId());
					if(!orgOfficeOptional.isPresent())
						throw new Exception("Data error:invalid organization office id"+profileResource.getOrganizationOfficeId());
				
					beneficiaryUser.setOrganizationOffice(orgOfficeOptional.get());
					beneficiaryUserRepo.save(beneficiaryUser);
					Set<Role> rolelist = parichayUser.getRolelist();
					if (!rolelist.contains(role))
						rolelist.add(role);
					parichayUser.setRolelist(rolelist);
					parichayUser.setOrganizationOffice(orgOfficeOptional.get());
					parichayUserRepo.save(parichayUser);

				} else if (role.getId() == RoleEnum.nodal.getValue()) {

					// NodalUser nodalUser = this.modelMapper.map(profileResource, NodalUser.class);
					NodalUser nodalUser = new NodalUser();
					nodalUser.setParichayuser(parichayUser);
					nodalUser.setUserName(profileResource.getUserName());
					nodalUser.setEmpCode(profileResource.getEmpCode());
					nodalUser.setEmail(profileResource.getEmail());
					nodalUser.setMobileNo(profileResource.getMobile());
					nodalUser.setDesignation(profileResource.getDesignation());
					Optional<Ministry> minOptional = ministryRepo.findById(profileResource.getMinistry());
					if (!minOptional.isPresent())
						throw new Exception("Data Error: Invalid ministry code");
					Optional<Organization> orgOptional = organizationRepo.findById(profileResource.getOrganization());
					if (!orgOptional.isPresent())
						throw new Exception("Data Error: Invalid organization code");
						Optional<Department> deptOptional = departmentRepo.findById(profileResource.getDepartment());
						if (!deptOptional.isPresent())
						throw new Exception("Data Error: Invalid department code");
					nodalUser.setMinistry(minOptional.get());
					nodalUser.setDepartment(deptOptional.get());
					nodalUser.setOrganization(orgOptional.get());
					nodalUser.setCreatedOn(LocalDateTime.now());
					nodalUser.setUpdatedOn(LocalDateTime.now());
					nodalUser.setCreatedBy(parichayUser);
					nodalUser.setUpdatedBy(parichayUser);
					nodalUser.setDeleted(false);
					nodalUser.setRole(role);

					Optional<OrganizationOffice> orgOfficeOptional= organizationOfficeRepo.findById(profileResource.getOrganizationOfficeId());
					if(!orgOfficeOptional.isPresent())
						throw new Exception("Data error:invalid organization office id"+profileResource.getOrganizationOfficeId());
					nodalUser.setOrganizationOffice(orgOfficeOptional.get());
					nodalUserRepo.save(nodalUser);
					Set<Role> rolelist = parichayUser.getRolelist();
					if (!rolelist.contains(role))
						rolelist.add(role);
					parichayUser.setRolelist(rolelist);
					parichayUser.setOrganizationOffice(orgOfficeOptional.get());
					parichayUserRepo.save(parichayUser);

				} else if (role.getId() == RoleEnum.approvingauthority.getValue()) {

					ApprovingAuthorityUser approvingAuthorityUser = new ApprovingAuthorityUser();
					// ApprovingAuthorityUser approvingAuthorityUser = this.modelMapper.map(profileResource, ApprovingAuthorityUser.class);
					approvingAuthorityUser.setParichayUser(parichayUser);
					approvingAuthorityUser.setUserName(profileResource.getUserName());
					approvingAuthorityUser.setEmpCode(profileResource.getEmpCode());
					approvingAuthorityUser.setEmail(profileResource.getEmail());
					approvingAuthorityUser.setMobileNo(profileResource.getMobile());
					approvingAuthorityUser.setDesignation(profileResource.getDesignation());
					Optional<Ministry> minOptional = ministryRepo.findById(profileResource.getMinistry());
					if (!minOptional.isPresent())
						throw new Exception("Data Error: Invalid ministry code");
					Optional<Organization> orgOptional = organizationRepo.findById(profileResource.getOrganization());
					if (!orgOptional.isPresent())
						throw new Exception("Data Error: Invalid organization code");
					
					Optional<Department> deptOptional = departmentRepo.findById(profileResource.getDepartment());
					if (!deptOptional.isPresent())
						throw new Exception("Data Error: Invalid department code");
					
					approvingAuthorityUser.setMinistry(minOptional.get());
					approvingAuthorityUser.setDepartment(deptOptional.get());
					approvingAuthorityUser.setOrganization(orgOptional.get());
					approvingAuthorityUser.setCreatedOn(LocalDateTime.now());
					approvingAuthorityUser.setUpdatedOn(LocalDateTime.now());
					approvingAuthorityUser.setCreatedBy(parichayUser);
					approvingAuthorityUser.setUpdatedBy(parichayUser);
					approvingAuthorityUser.setDeleted(false);
					approvingAuthorityUser.setRole(role);

					Optional<OrganizationOffice> orgOfficeOptional= organizationOfficeRepo.findById(profileResource.getOrganizationOfficeId());
					if(!orgOfficeOptional.isPresent())
						throw new Exception("Data error:invalid organization office id"+profileResource.getOrganizationOfficeId());
				
					approvingAuthorityUser.setOrganizationOffice(orgOfficeOptional.get());
					approvingAuthorityUserRepo.save(approvingAuthorityUser);
					Set<Role> rolelist = parichayUser.getRolelist();
					if (!rolelist.contains(role))
						rolelist.add(role);
					parichayUser.setRolelist(rolelist);
					parichayUser.setOrganizationOffice(orgOfficeOptional.get());
					parichayUserRepo.save(parichayUser);

				} else if (role.getId() == RoleEnum.cghsuser.getValue()) {
					CGHSUser cghsUser = new CGHSUser();
					cghsUser.setParichayuser(parichayUser);
					cghsUser.setUserName(profileResource.getUserName());
					cghsUser.setEmpCode(profileResource.getEmpCode());
					cghsUser.setEmail(profileResource.getEmail());
					cghsUser.setMobileNo(profileResource.getMobile());
					cghsUser.setDesignation(profileResource.getDesignation());
					Optional<Ministry> minOptional = ministryRepo.findById(profileResource.getMinistry());
					if (!minOptional.isPresent())
						throw new Exception("Data Error: Invalid ministry code");
					Optional<Organization> orgOptional = organizationRepo.findById(profileResource.getOrganization());
					if (!orgOptional.isPresent())
						throw new Exception("Data Error: Invalid organization code");
					Optional<Department> deptOptional = departmentRepo.findById(profileResource.getDepartment());
					if (!deptOptional.isPresent())
						throw new Exception("Data Error: Invalid department code");
					List<String> cityIds = profileResource.getAdCity();
					Set<CGHSCity> cghsCitySet = new HashSet<CGHSCity>();
					for (String cityId : cityIds) {
						Optional<CGHSCity> cityOptional = cghsCityRepo.findById(Long.valueOf(cityId + ""));
						if (!cityOptional.isPresent())
						throw new Exception("Data Error: Invalid city code");
						cghsCitySet.add(cityOptional.get());
					}
					cghsUser.setMinistry(minOptional.get());
					cghsUser.setDepartment(deptOptional.get());
					cghsUser.setOrganization(orgOptional.get());
					cghsUser.setCreatedOn(LocalDateTime.now());
					cghsUser.setUpdatedOn(LocalDateTime.now());
					cghsUser.setCreatedBy(parichayUser);
					cghsUser.setUpdatedBy(parichayUser);
					cghsUser.setDeleted(false);
					cghsUser.setRole(role);
					Optional<OrganizationOffice> orgOfficeOptional= organizationOfficeRepo.findById(profileResource.getOrganizationOfficeId());
					if(!orgOfficeOptional.isPresent())
						throw new Exception("Data error:invalid organization office id"+profileResource.getOrganizationOfficeId());
					cghsUser.setOrganizationOffice(orgOfficeOptional.get());
					cghsUserRepo.save(cghsUser);
					// Create CghsIncharge to each cghs city
					for (CGHSCity cghsCity : cghsCitySet) {
						CGHSIncharge cghsIncharge = new CGHSIncharge();
						cghsIncharge.setCghsCity(cghsCity);
						cghsIncharge.setCghsUser(cghsUser);
						cghsIncharge.setCreatedOn(LocalDateTime.now());
						cghsIncharge.setUpdatedOn(LocalDateTime.now());
						cghsIncharge.setCreatedBy(parichayUser);
						cghsIncharge.setUpdatedBy(parichayUser);
						cghsIncharge.setDeleted(false);
						cghsInchargeRepo.save(cghsIncharge);

					}

					Set<Role> rolelist = parichayUser.getRolelist();
					if (!rolelist.contains(role))
						rolelist.add(role);
					parichayUser.setRolelist(rolelist);
					parichayUser.setOrganizationOffice(orgOfficeOptional.get());
					parichayUserRepo.save(parichayUser);

					

				}
				
				parichayResource.setId(parichayUser.getId());
        }
        return parichayResource;
    }

	@Override
	public ProfileResource get(Long parichayUserId) throws Exception {
		// TODO Auto-generated method stub
		try{
			Optional<ParichayUser> parichayOptional = parichayUserRepo.findById(parichayUserId);
		//ProfileResource resource = new ProfileResource();
		if(!parichayOptional.isPresent())
			throw new Exception("Data Error:"+" parichayId wrong");
			
		Optional<ParichayUser> parichayUser = parichayUserRepo.findById(parichayUserId);
		ProfileResource profileResource = new ProfileResource();
		Set<Role> roleList = parichayUser.get().getRolelist();
		for(Role roleIter: roleList){
			int result = Long.compare(roleIter.getId(), RoleEnum.cghsuser.getValue());
			if(result==0){
				System.out.println(roleIter.getId());
				CGHSUser cghsUserData = cghsUserRepo.findByRoleId(roleIter.getId());
				System.out.println(cghsUserData.getId());
				List<CGHSIncharge> cghsInchargeList = cghsInchargeRepo.findAllBycghsUser(cghsUserData.getId());
				List<String> cghsCitiesList = new ArrayList<String>();
				for(CGHSIncharge cghsInchargeIter: cghsInchargeList){
					cghsCitiesList.add(cghsInchargeIter.getCghsCity().getId()+"");
				}
				profileResource.setAdCity(cghsCitiesList);	
			}
		}
		// ProfileResource profileResource = new ProfileResource();
		profileResource.setId(parichayUser.get().getId());
		profileResource.setUserName(parichayUser.get().getFullName());
		profileResource.setEmail(parichayUser.get().getEmail());
		profileResource.setMobile(parichayUser.get().getMobileNo());
		profileResource.setDesignation(parichayUser.get().getDesignation());
		return profileResource;
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
		
		
	}

    ProfileResource prepareProfileResponseFromBeneficiaryUser(BeneficiaryUser beneficiaryUser) throws Exception {
		ProfileResource profile= new ProfileResource();
		profile.setId(beneficiaryUser.getId());
		profile.setUserName(beneficiaryUser.getUserName());
		profile.setDesignation(beneficiaryUser.getDesignation());
		profile.setEmpCode(beneficiaryUser.getEmpCode());
		profile.setEmail(beneficiaryUser.getEmail());
		profile.setMobile(beneficiaryUser.getMobileNo());
		profile.setMinistry(beneficiaryUser.getMinistry().getMinistryCode());
		profile.setMinistryName(beneficiaryUser.getMinistry().getMinistryName());
		profile.setDepartment(beneficiaryUser.getDepartment().getDepartmentCode());
		profile.setDepartmentName(beneficiaryUser.getDepartment().getDepartmentName());
		profile.setOrganization(beneficiaryUser.getOrganization().getOrganizationCode());
		profile.setOrganizationName(beneficiaryUser.getOrganization().getOrganizationName());
		profile.setRoleName(beneficiaryUser.getRole().getRoleName());
		if(beneficiaryUser.getId()!=null){
			profile.setCreatedOn(LocalDateTime.now());
			profile.setUpdatedOn(LocalDateTime.now());
		}else{
			profile.setCreatedOn(beneficiaryUser.getCreatedOn());
			profile.setUpdatedOn(beneficiaryUser.getUpdatedOn());
		}
		
		profile.setRoleId(1l);

		Optional<OrganizationOffice> orgOfficeOptional= organizationOfficeRepo.findById(beneficiaryUser.getOrganizationOffice().getId());
		if(!orgOfficeOptional.isPresent())
			throw new Exception("Data error:invalid organization office id"+beneficiaryUser.getOrganizationOffice().getId());
				
		profile.setOrganizationOfficeId(orgOfficeOptional.get().getId());
		return profile;
	}

	ProfileResource prepareProfileResponseFromNodalUser(NodalUser nodalUser) throws Exception {

		ProfileResource profile = new ProfileResource();
		profile.setId(nodalUser.getId());
		profile.setUserName(nodalUser.getUserName());
		profile.setEmpCode(nodalUser.getEmpCode());
		profile.setEmail(nodalUser.getEmail());
		profile.setMobile(nodalUser.getMobileNo());
		profile.setDesignation(nodalUser.getDesignation());
		profile.setMinistry(nodalUser.getMinistry().getMinistryCode());
		profile.setMinistryName(nodalUser.getMinistry().getMinistryName());
		profile.setDepartment(nodalUser.getDepartment().getDepartmentCode());
		profile.setDepartmentName(nodalUser.getDepartment().getDepartmentName());
		profile.setOrganization(nodalUser.getOrganization().getOrganizationCode());
		profile.setOrganizationName(nodalUser.getOrganization().getOrganizationName());
		profile.setRoleName(nodalUser.getRole().getRoleName());
		profile.setRoleId(2l);
		profile.setCreatedOn(nodalUser.getCreatedOn());
	 profile.setUpdatedOn(nodalUser.getUpdatedOn());

	 Optional<OrganizationOffice> orgOfficeOptional= organizationOfficeRepo.findById(nodalUser.getOrganizationOffice().getId());
					if(!orgOfficeOptional.isPresent())
						throw new Exception("Data error:invalid organization office id"+nodalUser.getOrganizationOffice().getId());
				
	profile.setOrganizationOfficeId(orgOfficeOptional.get().getId());

		return profile;
	}

	ProfileResource prepareProfileResponseFromApprovingAuthority(ApprovingAuthorityUser approvingAuthorityUser) throws Exception{
		ProfileResource profile = new ProfileResource();
		profile.setId(approvingAuthorityUser.getId());
		profile.setUserName(approvingAuthorityUser.getUserName());
		profile.setDesignation(approvingAuthorityUser.getDesignation());
		profile.setEmpCode(approvingAuthorityUser.getEmpCode());
		profile.setEmail(approvingAuthorityUser.getEmail());
		profile.setMobile(approvingAuthorityUser.getMobileNo());
		//ProfileResource   profile =this.modelMapper.map(approvingAuthorityUser, ProfileResource.class);
		profile.setMinistry(approvingAuthorityUser.getMinistry().getMinistryCode());
		profile.setMinistryName(approvingAuthorityUser.getMinistry().getMinistryName());
		profile.setDepartment(approvingAuthorityUser.getOrganization().getOrganizationCode());
		profile.setDepartmentName(approvingAuthorityUser.getDepartment().getDepartmentName());
		profile.setOrganization(approvingAuthorityUser.getOrganization().getOrganizationCode());
		profile.setOrganizationName(approvingAuthorityUser.getOrganization().getOrganizationName());
		profile.setRoleName(approvingAuthorityUser.getRole().getRoleName());
		profile.setRoleId(3l);
		if(approvingAuthorityUser.getId()!=null){
			profile.setCreatedOn(LocalDateTime.now());
			profile.setUpdatedOn(LocalDateTime.now());
		}else{
			profile.setCreatedOn(approvingAuthorityUser.getCreatedOn());
			profile.setUpdatedOn(approvingAuthorityUser.getUpdatedOn());
		}
		

		Optional<OrganizationOffice> orgOfficeOptional= organizationOfficeRepo.findById(approvingAuthorityUser.getOrganizationOffice().getId());
					if(!orgOfficeOptional.isPresent())
						throw new Exception("Data error:invalid organization office id"+approvingAuthorityUser.getOrganizationOffice().getId());
				
		profile.setOrganizationOfficeId(orgOfficeOptional.get().getId());

		return profile;
	}

	ProfileResource prepareProfileResponseFromCGHSUser(CGHSUser cghsUser) throws Exception {

	//	ProfileResource   profile = this.modelMapper.map(cghsUser, ProfileResource.class);

		 ProfileResource profile = new ProfileResource();
		 profile.setId(cghsUser.getId());
		 profile.setUserName(cghsUser.getUserName());
		 profile.setEmpCode(cghsUser.getEmpCode());
		 profile.setEmail(cghsUser.getEmail());
		 profile.setMobile(cghsUser.getMobileNo());
		 profile.setDesignation(cghsUser.getDesignation());
		 profile.setMinistry(cghsUser.getMinistry().getMinistryCode());
		 profile.setMinistryName(cghsUser.getMinistry().getMinistryName());
		 profile.setDepartment(cghsUser.getDepartment().getDepartmentCode());
		 profile.setDepartmentName(cghsUser.getDepartment().getDepartmentName());
		 profile.setOrganization(cghsUser.getOrganization().getOrganizationCode());
		 profile.setOrganizationName(cghsUser.getOrganization().getOrganizationName());
		 profile.setRoleName(cghsUser.getRole().getRoleName());
		 profile.setRoleId(4l);
		 profile.setCreatedOn(cghsUser.getCreatedOn());
		 profile.setUpdatedOn(cghsUser.getUpdatedOn());

		 Optional<OrganizationOffice> orgOfficeOptional= organizationOfficeRepo.findById(cghsUser.getOrganizationOffice().getId());
					if(!orgOfficeOptional.isPresent())
						throw new Exception("Data error:invalid organization office id"+cghsUser.getOrganizationOffice().getId());
				
		profile.setOrganizationOfficeId(orgOfficeOptional.get().getId());

		List<CGHSIncharge> cghsInchage = cghsInchargeRepo.findAllBycghsUser(cghsUser.getId());
		List<String> cityList = new ArrayList<String>();
		for(CGHSIncharge incharge: cghsInchage){
			cityList.add(incharge.getCghsCity().getId()+"");
		}
		profile.setAdCity(cityList);

		return profile;
	}

	@Override
	public List<ProfileResource> list(Long parichayUserId) throws Exception {
		// TODO Auto-generated method stub
		Optional<ParichayUser> optionalParichayUser = parichayUserRepo.findById(parichayUserId);
		if (!optionalParichayUser.isPresent())
			throw new Exception("Data error:" + "invalid parichay user id");
		ParichayUser parichayUser = optionalParichayUser.get();
		List<ProfileResource> profileList = new ArrayList<>();
		// get all roles held by the user
		Set<Role> roleList = parichayUser.getRolelist();

		// for each role get the relevent profile info 
		
		for (Role role : roleList) {
			if (role.getId() == RoleEnum.beneficiary.getValue())
				profileList.add(prepareProfileResponseFromBeneficiaryUser(parichayUser.getBeneficiaryUser()));
			if (role.getId() == RoleEnum.nodal.getValue())
				profileList.add(prepareProfileResponseFromNodalUser(parichayUser.getNodalUser()));
			if (role.getId() == RoleEnum.cghsuser.getValue())
				profileList.add(prepareProfileResponseFromCGHSUser(parichayUser.getCghsUser()));
			if (role.getId() == RoleEnum.approvingauthority.getValue())
				profileList.add(prepareProfileResponseFromApprovingAuthority(parichayUser.getApprovingAuthorityUser()));
		}
	return profileList;


	}

	@Override
	public String edit(long id,long RoleId,ProfileResource profileResource) {
		// TODO Auto-generated method stub
		try{
			if(RoleId == RoleEnum.approvingauthority.getValue()){
				Optional<ApprovingAuthorityUser> approvingOptional = approvingAuthorityUserRepo.findById(id);
				if(!approvingOptional.isPresent()){
					throw new Exception("sorry this id of approving authority user can't exist");
				}
				ApprovingAuthorityUser approvingAuthorityUser = approvingOptional.get();
				approvingAuthorityUser.setUserName(profileResource.getUserName());
				approvingAuthorityUser.setDesignation(profileResource.getDesignation());
				approvingAuthorityUser.setEmpCode(profileResource.getEmpCode());
				approvingAuthorityUser.setEmail(profileResource.getEmail());
				approvingAuthorityUser.setMobileNo(profileResource.getMobile());
				Optional<Ministry> minOptional = ministryRepo.findById(profileResource.getMinistry());
					if (!minOptional.isPresent())
						throw new Exception("Data Error: Invalid ministry code");
				Optional<Organization> orgOptional = organizationRepo.findById(profileResource.getOrganization());
					if (!orgOptional.isPresent())
						throw new Exception("Data Error: Invalid organization code");
					
				Optional<Department> deptOptional = departmentRepo.findById(profileResource.getDepartment());
					if (!deptOptional.isPresent())
						throw new Exception("Data Error: Invalid department code");
				approvingAuthorityUser.setMinistry(minOptional.get());
				approvingAuthorityUser.setDepartment(deptOptional.get());
				approvingAuthorityUser.setOrganization(orgOptional.get());
				Optional<OrganizationOffice> orgOfficeOptional= organizationOfficeRepo.findById(profileResource.getOrganizationOfficeId());
				if(!orgOfficeOptional.isPresent())
					throw new Exception("Data error:invalid organization office id"+profileResource.getOrganizationOfficeId());
				approvingAuthorityUser.setOrganizationOffice(orgOfficeOptional.get());
				approvingAuthorityUser.setCreatedOn(LocalDateTime.now());
				approvingAuthorityUser.setUpdatedOn(LocalDateTime.now());
				approvingAuthorityUserRepo.save(approvingAuthorityUser);
			}else if(RoleId == RoleEnum.beneficiary.getValue()){
				Optional<BeneficiaryUser> benOptional = beneficiaryUserRepo.findById(id);
				if(!benOptional.isPresent()){
					throw new Exception("sorry this id of approving authority user can't exist");
				}
				BeneficiaryUser beneficiaryUser = benOptional.get();
				beneficiaryUser.setUserName(profileResource.getUserName());
				beneficiaryUser.setDesignation(profileResource.getDesignation());
				beneficiaryUser.setEmpCode(profileResource.getEmpCode());
				beneficiaryUser.setEmail(profileResource.getEmail());
				beneficiaryUser.setMobileNo(profileResource.getMobile());
				Optional<Ministry> minOptional = ministryRepo.findById(profileResource.getMinistry());
					if (!minOptional.isPresent())
						throw new Exception("Data Error: Invalid ministry code");
				Optional<Organization> orgOptional = organizationRepo.findById(profileResource.getOrganization());
					if (!orgOptional.isPresent())
						throw new Exception("Data Error: Invalid organization code");
					
				Optional<Department> deptOptional = departmentRepo.findById(profileResource.getDepartment());
					if (!deptOptional.isPresent())
						throw new Exception("Data Error: Invalid department code");
				beneficiaryUser.setMinistry(minOptional.get());
				beneficiaryUser.setDepartment(deptOptional.get());
				beneficiaryUser.setOrganization(orgOptional.get());
				Optional<OrganizationOffice> orgOfficeOptional= organizationOfficeRepo.findById(profileResource.getOrganizationOfficeId());
				if(!orgOfficeOptional.isPresent())
					throw new Exception("Data error:invalid organization office id"+profileResource.getOrganizationOfficeId());
				beneficiaryUser.setOrganizationOffice(orgOfficeOptional.get());
				beneficiaryUser.setCreatedOn(LocalDateTime.now());
				beneficiaryUser.setUpdatedOn(LocalDateTime.now());
				beneficiaryUserRepo.save(beneficiaryUser);

			}else if(RoleId == RoleEnum.nodal.getValue()){
				Optional<NodalUser> nodalOptional = nodalUserRepo.findById(id);
				if(!nodalOptional.isPresent()){
					throw new Exception("sorry this id of approving authority user can't exist");
				}
				NodalUser nodalUser = nodalOptional.get();
				nodalUser.setUserName(profileResource.getUserName());
				nodalUser.setDesignation(profileResource.getDesignation());
				nodalUser.setEmpCode(profileResource.getEmpCode());
				nodalUser.setEmail(profileResource.getEmail());
				nodalUser.setMobileNo(profileResource.getMobile());
				Optional<Ministry> minOptional = ministryRepo.findById(profileResource.getMinistry());
					if (!minOptional.isPresent())
						throw new Exception("Data Error: Invalid ministry code");
				Optional<Organization> orgOptional = organizationRepo.findById(profileResource.getOrganization());
					if (!orgOptional.isPresent())
						throw new Exception("Data Error: Invalid organization code");
					
				Optional<Department> deptOptional = departmentRepo.findById(profileResource.getDepartment());
					if (!deptOptional.isPresent())
						throw new Exception("Data Error: Invalid department code");
				nodalUser.setMinistry(minOptional.get());
				nodalUser.setDepartment(deptOptional.get());
				nodalUser.setOrganization(orgOptional.get());

				Optional<OrganizationOffice> orgOfficeOptional= organizationOfficeRepo.findById(profileResource.getOrganizationOfficeId());
				if(!orgOfficeOptional.isPresent())
					throw new Exception("Data error:invalid organization office id"+profileResource.getOrganizationOfficeId());
				nodalUser.setOrganizationOffice(orgOfficeOptional.get());
				nodalUser.setCreatedOn(LocalDateTime.now());
				nodalUser.setUpdatedOn(LocalDateTime.now());
				nodalUserRepo.save(nodalUser);
			}else if(RoleId == RoleEnum.cghsuser.getValue()){
				Optional<CGHSUser> cghsOptional = cghsUserRepo.findById(id);
				if(!cghsOptional.isPresent()){
					throw new Exception("sorry this id of approving authority user can't exist");
				}
				CGHSUser cghsUser = cghsOptional.get();
				cghsUser.setUserName(profileResource.getUserName());
				cghsUser.setDesignation(profileResource.getDesignation());
				cghsUser.setEmpCode(profileResource.getEmpCode());
				cghsUser.setEmail(profileResource.getEmail());
				cghsUser.setMobileNo(profileResource.getMobile());
				Optional<Ministry> minOptional = ministryRepo.findById(profileResource.getMinistry());
					if (!minOptional.isPresent())
						throw new Exception("Data Error: Invalid ministry code");
				Optional<Organization> orgOptional = organizationRepo.findById(profileResource.getOrganization());
					if (!orgOptional.isPresent())
						throw new Exception("Data Error: Invalid organization code");
					
				Optional<Department> deptOptional = departmentRepo.findById(profileResource.getDepartment());
				if (!deptOptional.isPresent())
					throw new Exception("Data Error: Invalid department code");
				cghsUser.setMinistry(minOptional.get());
				cghsUser.setDepartment(deptOptional.get());
				cghsUser.setOrganization(orgOptional.get());

				Optional<OrganizationOffice> orgOfficeOptional= organizationOfficeRepo.findById(profileResource.getOrganizationOfficeId());
				if(!orgOfficeOptional.isPresent())
					throw new Exception("Data error:invalid organization office id"+profileResource.getOrganizationOfficeId());
				cghsUser.setOrganizationOffice(orgOfficeOptional.get());
				cghsUser.setCreatedOn(LocalDateTime.now());
				cghsUser.setUpdatedOn(LocalDateTime.now());
				cghsUserRepo.save(cghsUser);
				List<String> cityIds = profileResource.getAdCity();
				// Set<CGHSCity> cghsCitySet = new HashSet<CGHSCity>();
				// 	for (String cityId : cityIds) {
				// 		Optional<CGHSCity> cityOptional = cghsCityRepo.findById(Long.valueOf(cityId + ""));
				// 		if (!cityOptional.isPresent())
				// 		throw new Exception("Data Error: Invalid city code");
				// 		cghsCitySet.add(cityOptional.get());
				// 	}
				// cghsInchargeRepo.deleteBycghsUser(Integer.parseInt(cghsUser.getId()+""));
				// cghsInchargeRepo.deleteBycghsUser(Integer.parseInt(cghsUser.getId()+""));
				// for (CGHSCity cghsCity : cghsCitySet) {
				// 	CGHSIncharge cghsIncharge = new CGHSIncharge();
				// 	cghsIncharge.setCghsCity(cghsCity);
				// 	cghsIncharge.setCghsUser(cghsUser);
				// 	cghsIncharge.setCreatedOn(LocalDateTime.now());
				// 	cghsIncharge.setUpdatedOn(LocalDateTime.now());
				// 	cghsIncharge.setCreatedBy(parichayUserRepo.findById(profileResource.getParichayUserId()).get());
				// 	cghsIncharge.setUpdatedBy(parichayUserRepo.findById(profileResource.getParichayUserId()).get());
				// 	cghsIncharge.setDeleted(false);
				// 	cghsInchargeRepo.save(cghsIncharge);

				// }
				List<CGHSIncharge> cghsInchage = cghsInchargeRepo.findAllBycghsUser(cghsUser.getId());
				List<String> cityList = new ArrayList<String>();
				for(CGHSIncharge incharge: cghsInchage){
					if(!cityIds.contains(incharge.getCghsCity().getId()+"")){
						// drop that incharge
						cghsInchargeRepo.deleteBycghsUser(incharge.getId());
					}
					else{
						incharge.setCreatedOn(LocalDateTime.now());
						incharge.setUpdatedOn(LocalDateTime.now());
						cghsInchargeRepo.save(incharge);
					}
					cityList.add(incharge.getCghsCity().getId()+"");
				}
				for(String cityIdsIter: cityIds){
					if(!cityList.contains(cityIdsIter)){
						CGHSIncharge cghsIncharge = new CGHSIncharge();
						Optional<CGHSCity> cghsCity = cghsCityRepo.findById(Long.parseLong(cityIdsIter));
						cghsIncharge.setCghsCity(cghsCity.get());
						cghsIncharge.setCghsUser(cghsUser);
						cghsIncharge.setCreatedOn(LocalDateTime.now());
						cghsIncharge.setUpdatedOn(LocalDateTime.now());
						cghsIncharge.setCreatedBy(parichayUserRepo.findById(profileResource.getParichayUserId()).get());
						cghsIncharge.setUpdatedBy(parichayUserRepo.findById(profileResource.getParichayUserId()).get());
						cghsIncharge.setDeleted(false);
						cghsInchargeRepo.save(cghsIncharge);
					}
				}
			}
			return "Successfull";
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ProfileResource patch(long id, long roleId) {
		// TODO Auto-generated method stub
		try{
			ProfileResource profileResource = new ProfileResource();
			if(roleId == RoleEnum.beneficiary.getValue()){
				BeneficiaryUser beneficiaryUser = beneficiaryUserRepo.findById(id).get();
				profileResource = prepareProfileResponseFromBeneficiaryUser(beneficiaryUser);
			}else if(roleId == RoleEnum.nodal.getValue()){
				NodalUser nodalUser = nodalUserRepo.findById(id).get();
				profileResource = prepareProfileResponseFromNodalUser(nodalUser);
			}else if(roleId == RoleEnum.approvingauthority.getValue()){
				ApprovingAuthorityUser approvingAuthorityUser = approvingAuthorityUserRepo.findById(id).get();
				profileResource = prepareProfileResponseFromApprovingAuthority(approvingAuthorityUser);
			}else if(roleId == RoleEnum.cghsuser.getValue()){
				CGHSUser cghsUser = cghsUserRepo.findById(id).get();
				profileResource = prepareProfileResponseFromCGHSUser(cghsUser);

			}
			return profileResource;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
}

    

