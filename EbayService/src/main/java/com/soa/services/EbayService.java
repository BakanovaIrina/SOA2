package com.soa.services;
import com.soa.adapter.EbayServiceAdapter;
import com.soa.exception.AppException;
import com.soa.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EbayService {
    @Autowired
    EbayServiceAdapter ebayServiceAdapter;

    public List<Product> getProductsByManufacturer(Integer manufacturerId, int page, int size) throws AppException {
        String filters = "filter=owner%5Beq%5D%3D" + manufacturerId;
        return  ebayServiceAdapter.getProducts(filters, page, size);
    }

    public List<Product> getProductsByUnitOfMeasure(String unitOfMeasure, int page, int size) throws AppException {
        String filters = "filter=unitOfMeasure%5Beq%5D%3D" + unitOfMeasure;
        return ebayServiceAdapter.getProducts(filters, page, size);
    }
}


