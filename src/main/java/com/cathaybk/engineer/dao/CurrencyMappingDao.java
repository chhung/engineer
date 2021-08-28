package com.cathaybk.engineer.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cathaybk.engineer.model.CurrencyMappingModel;

@Repository
public interface CurrencyMappingDao extends JpaRepository<CurrencyMappingModel, Integer> {
	CurrencyMappingModel findByCode(String code);
	
	@Transactional
	@Modifying
	@Query(value="delete from currency_mapping where code = ?1", nativeQuery=true)
	Integer deleteByCode(String code);
	
	@Transactional
	@Modifying
	@Query(value="update currency_mapping set chinese = ?1 where code = ?2", nativeQuery=true)
	void updateByCode(String chinese, String code);
	
	@Transactional
	@Modifying
	@Query(value="insert into currency_mapping (code, chinese) values(?1, ?2)", nativeQuery=true)
	void insert(String code, String chinese);
}
