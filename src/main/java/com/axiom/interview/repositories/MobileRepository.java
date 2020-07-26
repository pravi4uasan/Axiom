package com.axiom.interview.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.axiom.interview.domain.Mobile;

public interface MobileRepository extends CrudRepository<Mobile, Integer> {

	@Query("FROM Mobile WHERE ( (:id IS NULL OR id = :id)"
			+ "AND (:brand IS NULL OR brand LIKE %:brand%)"
			+ "AND (:phone IS NULL OR phone LIKE %:phone%)"
			+ "AND (:picture IS NULL OR picture LIKE %:picture%)"
			+ "AND (:announceDate IS NULL OR release.announceDate LIKE %:announceDate%)"
			+ "AND (:priceEur IS NULL OR release.priceEur = :priceEur)"
			+ "AND (:sim IS NULL OR sim LIKE %:sim%)"
			+ "AND (:resolution IS NULL OR resolution LIKE %:resolution%)"
			+ "AND (:audioJack IS NULL OR hardware.audioJack LIKE %:audioJack%)"
			+ "AND (:gps IS NULL OR hardware.gps LIKE %:gps%)"
			+ "AND (:battery IS NULL OR hardware.battery LIKE %:battery%) )")
	List<Mobile> search(@Param("id") Long id, @Param("brand") String brand,
			@Param("phone") String phone, @Param("picture") String picture,
			@Param("announceDate") String announceDate, @Param("priceEur") Long priceEur,
			@Param("sim") String sim, @Param("resolution") String resolution,
			@Param("audioJack") String audioJack, @Param("gps") String gps,
			@Param("battery") String battery);

}
