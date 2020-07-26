package com.axiom.interview.domain;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Mobile {
	
	@Id
	private Long id;
	private String brand;
	private String phone;
	private String picture;
	
	@Embedded
	private Release release;
	private String sim;
	private String resolution;
	
	@Embedded
	private Hardware hardware;

}
