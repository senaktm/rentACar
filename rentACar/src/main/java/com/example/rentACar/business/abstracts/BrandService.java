package com.example.rentACar.business.abstracts;

import java.util.List;

import com.example.rentACar.business.requests.CreateBrandRequest;
import com.example.rentACar.business.requests.UpdateBrandRequest;
import com.example.rentACar.business.responses.GetAllBrandsResponse;
import com.example.rentACar.business.responses.GetByIdBrandResponse;
import com.example.rentACar.entities.concretes.Brand;

public interface BrandService {

	public List<GetAllBrandsResponse> getAll();
	void add(CreateBrandRequest createBrandRequest);
	void update(UpdateBrandRequest updateBrandRequest);
	void delete(int id);
	GetByIdBrandResponse getById(int id);
}
