package com.cooper.farming.service.impl;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import org.springframework.stereotype.Service;

import com.cooper.farming.constants.Constants;
import com.cooper.farming.dto.ItemDTO;
import com.cooper.farming.dto.ProductDTO;
import com.cooper.farming.dto.UserDTO;
import com.cooper.farming.exception.FarmingServiceException;
import com.cooper.farming.repository.ProductRepository;
import com.cooper.farming.service.ItemService;
import com.cooper.farming.service.ProductService;
import com.cooper.farming.service.UserService;
import com.cooper.farming.utils.CommonUtils;
import com.cooper.farming.vo.ErrorVO;
import com.cooper.farming.vo.ProductVO;
import com.cooper.farming.vo.ProductsVO;


@Service
public class ProductServiceImpl implements ProductService {
	
	private Properties errorProperties;
	
	private ProductRepository productRepository;
	
	private ItemService itemService;
	
	private UserService userService;
	

	public ProductServiceImpl(ItemService itemService, UserService userService, ProductRepository productRepository, Properties errorProperties) {
		this.itemService = itemService;
		this.userService = userService;
		this.productRepository = productRepository;
		this.errorProperties = errorProperties;
	}
	

	@Override
	public ProductVO createProduct(ProductVO productVO) throws FarmingServiceException {
		ProductDTO productDTO = getProductDTOByVO(productVO);
		ItemDTO itemDTO = itemService.getItemById(productVO.getItemId());
		productDTO.setItemDTO(itemDTO);
		UserDTO userDTO = userService.getUserById(productVO.getUserId());
		productDTO.setUserDTO(userDTO);
		productDTO = productRepository.save(productDTO);
		return getProductVOByDTO(productDTO);
	}
	
	@Override
	public ProductsVO getProductsByUserId(int userId) {
		List<ProductDTO> productDTOs = productRepository.findByUserDTOUserId(userId);
		ProductsVO productsVO = new ProductsVO();
		List<ProductVO> productVOs = new ArrayList<>();
		if(productDTOs != null && !productDTOs.isEmpty()) {
			productDTOs.forEach(productDTO -> productVOs.add(getProductVOByDTO(productDTO)));
		}
		productsVO.setProductVOs(productVOs);
		return productsVO;
	}
	
	/**Method to get the product DTO by VO*/
	private ProductDTO getProductDTOByVO(ProductVO productVO) throws FarmingServiceException {
		LocalDateTime createdAt = LocalDateTime.now();
		ProductDTO productDTO = new ProductDTO();
		productDTO.setBasePrice(productVO.getBasePricePerKg());
		productDTO.setCreatedAt(createdAt);
		productDTO.setBidEndsOn(getDateFromString(productVO.getBidEndsOn()));
		productDTO.setModifiedAt(createdAt);
		productDTO.setQuantity(productVO.getQuantity());
		return productDTO;
	}
	
	/**Method to get the product VO by DTO*/
	public ProductVO getProductVOByDTO(ProductDTO productDTO) {
		ProductVO productVO = new ProductVO();
		productVO.setBasePricePerKg(productDTO.getBasePrice());
		productVO.setBidEndsOn(CommonUtils.formatDateToString(productDTO.getBidEndsOn()));
		productVO.setItemId(productDTO.getItemDTO().getItemId());
		productVO.setItemName(productDTO.getItemDTO().getItemName());
		productVO.setUserId(productDTO.getUserDTO().getUserId());
		productVO.setUserName(productDTO.getUserDTO().getUserName());
		productVO.setProductId(productDTO.getProductId());
		productVO.setQuantity(productDTO.getQuantity());
		return productVO;
	}
	
	
	/**Method to validate the date time in string format*/
	private LocalDateTime getDateFromString(String dateInString) throws FarmingServiceException {
		LocalDateTime localDateTime = CommonUtils.parseStringToDate(dateInString);
		if(localDateTime == null) {
			String message = MessageFormat.format(errorProperties.getProperty(Constants.INVALID_BID_END_DATE), dateInString, Constants.DATE_TIME_FORMAT);
			ErrorVO errorVO = new ErrorVO();
			errorVO.setErrorCode(Constants.INVALID_BID_END_DATE);
			errorVO.setErrorMessage(message);
			throw new FarmingServiceException(message, errorVO);
		}
		return localDateTime;
	}

	@Override
	public ProductsVO getProductsByCity(String city) {
		ProductsVO productsVO = new ProductsVO();
		List<ProductVO> productVOs = new ArrayList<>();
		Iterable<ProductDTO> productDTOs = productRepository.findByUserDTOCity(city);
		productDTOs.forEach(productDTO -> productVOs.add(getProductVOByDTO(productDTO)));
		productsVO.setProductVOs(productVOs);
		return productsVO;
	}

	@Override
	public ProductDTO getProductById(int productId) throws FarmingServiceException {
		Optional<ProductDTO> optionalDTO =  productRepository.findById(productId);
		if(optionalDTO.isPresent()) {
			return optionalDTO.get();
		} else {
			String message = MessageFormat.format(errorProperties.getProperty(Constants.PRODUCT_DOES_NOT_EXISTS), productId);
			ErrorVO errorVO = new ErrorVO();
			errorVO.setErrorCode(Constants.PRODUCT_DOES_NOT_EXISTS);
			errorVO.setErrorMessage(message);
			throw new FarmingServiceException(message, errorVO);
		}
	}
}
