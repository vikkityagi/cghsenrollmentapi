package io.swagger.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.swagger.model.CghspayScaleBean;

public interface PayscaleRepo extends JpaRepository<CghspayScaleBean, Long>{

}
