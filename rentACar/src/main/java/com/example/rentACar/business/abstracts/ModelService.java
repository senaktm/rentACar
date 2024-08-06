package com.example.rentACar.business.abstracts;

import java.util.List;

import com.example.rentACar.business.requests.CreateBrandRequest;
import com.example.rentACar.business.requests.CreateModelRequest;
import com.example.rentACar.business.responses.GetAllModelsResponse;



public interface ModelService {
	public List<GetAllModelsResponse> getAll();
	void add(CreateModelRequest createModelRequest);

}
