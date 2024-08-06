package com.example.rentACar.business.rules;

import org.springframework.stereotype.Service;

import com.example.rentACar.core.utilities.exceptions.BusinessException;
import com.example.rentACar.dataAccess.abstracts.BrandRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BrandBusinessRules {

	private BrandRepository _brandRepository;
	public void checkIfBrandNameExists(String name) {
		if(this._brandRepository.existsByName(name)) {
			throw new BusinessException("Brand name already exist"); //Java exception types
		}
	}
}
