package vn.locdt.cart.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import vn.locdt.cart.model.Product;

@FeignClient(name = "product-service")
public interface ProductClient {
	@RequestMapping(method = RequestMethod.GET, value = "/products")
	Page<Product> getProducts(@RequestParam("page") Integer page, @RequestParam("size") Integer size);

	@RequestMapping(method = RequestMethod.GET, value = "/products/{id}")
	Product findProduct(@PathVariable("id") Long id);
}
