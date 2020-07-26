package com.axiom.interview.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axiom.interview.domain.Mobile;
import com.axiom.interview.repositories.MobileRepository;
import com.axiom.interview.service.MobileService;

@Service
public class MobileServiceImpl implements MobileService {
	
	@Autowired
	private MobileRepository mobileRepository;

	@Override
	public Iterable<Mobile> list() {
		return mobileRepository.findAll();
	}
	
    public Iterable<Mobile> save(List<Mobile> mobiles) {
        return mobileRepository.saveAll(mobiles);
    }

	@Override
	public List<Mobile> search(Long id, String brand, String phone, String picture, String announceDate,
			Long priceEur, String sim, String resolution, String audioJack, String gps, String battery) {
		
		return mobileRepository.search(id, brand, phone, picture, announceDate, priceEur, sim,
				resolution, audioJack, gps, battery);
		
	}


}
