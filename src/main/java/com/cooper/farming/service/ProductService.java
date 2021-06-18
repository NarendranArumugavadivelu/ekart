package com.cooper.farming.service;

import org.springframework.stereotype.Service;

import com.cooper.farming.dto.ProductDTO;
import com.cooper.farming.exception.FarmingServiceException;
import com.cooper.farming.vo.ProductVO;
import com.cooper.farming.vo.ProductsVO;

@Service
public interface ProductService {

	public ProductVO createProduct(ProductVO productVO) throws FarmingServiceException;
	
	public ProductsVO getProductsByUserId(int userId);
	
	public ProductsVO getProductsByCity(String city);
	
	public ProductDTO getProductById(int productId) throws FarmingServiceException;
}
