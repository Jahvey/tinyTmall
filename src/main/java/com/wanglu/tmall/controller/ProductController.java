package com.wanglu.tmall.controller;

import com.wanglu.tmall.model.Product;
import com.wanglu.tmall.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wanglu on 17/2/20.
 */
@Controller
public class ProductController {
    @Resource(name = "productService")
    ProductService service;

    @RequestMapping(value = "foreproduct",method = RequestMethod.GET)
    public String product(@RequestParam("pid") int productid, ModelMap map){
        Product p = service.getProductById(productid);
        map.addAttribute("p",p);
        System.out.println(productid);
        return "product";
    }

    @RequestMapping(value="foresearch",method = RequestMethod.POST)
    public String search(@RequestParam("keyword") String keyword,ModelMap map){
        List<Product> lp = service.getProductsByKeyword(keyword);
        map.addAttribute("ps",lp);
        return "searchResult";
    }
}
