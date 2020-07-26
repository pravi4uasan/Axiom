package com.axiom.interview.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.axiom.interview.domain.Mobile;
import com.axiom.interview.service.MobileService;

@RestController
@RequestMapping("/mobile")
public class MobileController {
	
	@Autowired
	private MobileService mobileService;
	
	@GetMapping("/list")
    public Iterable<Mobile> list() {
        return mobileService.list();
    }
	
	@GetMapping("/search")
	public List<Mobile> search(@RequestParam(value = "id", required = false) Long id,
			@RequestParam(value = "brand", required = false) String brand,
			@RequestParam(value = "phone", required = false) String phone,
			@RequestParam(value = "picture", required = false) String picture,
			@RequestParam(value = "announceDate", required = false) String announceDate,
			@RequestParam(value = "priceEur", required = false) Long priceEur,
			@RequestParam(value = "sim", required = false) String sim,
			@RequestParam(value = "resolution", required = false) String resolution,
			@RequestParam(value = "audioJack", required = false) String audioJack,
			@RequestParam(value = "gps", required = false) String gps,
			@RequestParam(value = "battery", required = false) String battery) {
		
		return mobileService.search(id, brand, phone, picture, announceDate, priceEur, sim,
				resolution, audioJack, gps, battery);
		
	}

}
