package io.swagger.configuration;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import io.swagger.model.BenRegistrationApplication;
import io.swagger.model.CGHSInchargeApplication;
import io.swagger.model.FamilyMember;
import io.swagger.model.Role;
import io.swagger.resources.BenRegistrationApplicationResource;
import io.swagger.resources.CGHSInchargeRegistrationResource;
import io.swagger.resources.FamilyMemberResource;
import io.swagger.resources.RoleResource;

@Configuration
public class ModelMapperConfiguration {
      


    // @Autowired
    // @Qualifier("bbenRegistrationApplication")
    // private BenRegistrationApplication benRegistrationApplication;
    @Bean
    public ModelMapper mappings(){
        System.out.println("ModelMapperConfiguration is called");
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
        .setMatchingStrategy(MatchingStrategies.STRICT);
        TypeMap<FamilyMember,FamilyMemberResource> familyMemberMapper = modelMapper.createTypeMap(FamilyMember.class, FamilyMemberResource.class);
        familyMemberMapper.addMappings(new PropertyMap<FamilyMember, FamilyMemberResource>() {
                @Override
                protected void configure() {
                    map().setRelationName(source.getRelationshipType().getRelationName());
                    map().setBloodGroupName(source.getBloodGroup().getGroupName());
                }
            });

            TypeMap<BenRegistrationApplication,BenRegistrationApplicationResource> benRegistrationMapper = modelMapper.createTypeMap(BenRegistrationApplication.class, BenRegistrationApplicationResource.class);
            benRegistrationMapper.addMappings(new PropertyMap<BenRegistrationApplication, BenRegistrationApplicationResource>() {
                    @Override
                    protected void configure() {
                        map().setParichayId(source.getParichayId()); 
                     //  map().setBloodGroupName(source.getBloodGroup().getGroupName());
                    }
                });


                TypeMap<CGHSInchargeApplication,CGHSInchargeRegistrationResource>cghsRegistrationMapper = modelMapper.createTypeMap(CGHSInchargeApplication.class, CGHSInchargeRegistrationResource.class);
                cghsRegistrationMapper.addMappings(new PropertyMap<CGHSInchargeApplication, CGHSInchargeRegistrationResource>() {
                        @Override
                        protected void configure() {
                          //  map().setParichayId(source.getParichayId()); 
                         //  map().setBloodGroupName(source.getBloodGroup().getGroupName());

                        //  map().setnam
                        }
                    });

            
                    modelMapper.typeMap(Role.class, RoleResource.class)
                    .addMappings(mapper -> {
                        mapper.map(src -> src.getId(), RoleResource::setId);
                        mapper.map(src -> src.getRoleName(), RoleResource::setRoleName);
                    });
        return modelMapper;
    }
}
