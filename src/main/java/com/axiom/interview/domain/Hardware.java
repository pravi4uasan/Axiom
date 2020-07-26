package com.axiom.interview.domain;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Hardware {
	
	private String audioJack;
	private String gps;
	private String battery;

}
