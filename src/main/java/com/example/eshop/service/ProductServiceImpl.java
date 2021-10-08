package com.example.eshop.service;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import com.example.eshop.model.Product;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ProductServiceImpl implements ProductService {

	@Value("classpath:data/data.json")
	Resource resourceFile;
	
	 private String asString(Resource resource) {
	        try (Reader reader = new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8)) {
	            return FileCopyUtils.copyToString(reader);
	        } catch (IOException e) {
	            throw new UncheckedIOException(e);
	        }
	    }
	 
	@Override
	public List<Product> getData() {
		// TODO Auto-generated method stub
		List<Product> productList = null;
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			productList= objectMapper.readValue(asString(resourceFile), new TypeReference<List<Product>>(){});
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return productList;
	}

}
