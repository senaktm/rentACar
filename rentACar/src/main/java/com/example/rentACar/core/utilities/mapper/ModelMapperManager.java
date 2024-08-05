package com.example.rentACar.core.utilities.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ModelMapperManager implements ModelMapperService{
	private ModelMapper _modelMapper;
	@Override
	public ModelMapper forResponse() {
		this._modelMapper.getConfiguration()
		.setAmbiguityIgnored(true)
		.setMatchingStrategy(MatchingStrategies.LOOSE);
		
		return this._modelMapper;
	}

	@Override
	public ModelMapper forRequest() {
		this._modelMapper.getConfiguration()
		.setAmbiguityIgnored(true)
		.setMatchingStrategy(MatchingStrategies.STANDARD);
		
		return this._modelMapper;
	}

}
