package com.axiom.interview.service;

import java.util.List;

import com.axiom.interview.domain.Mobile;

public interface MobileService {

	public Iterable<Mobile> list();
	
	public Iterable<Mobile> save(List<Mobile> users);

	public List<Mobile> search(Long id, String brand, String phone, String picture, String announceDate, Long priceEur, String sim, String resolution, String audioJack, String gps, String battery);

}
