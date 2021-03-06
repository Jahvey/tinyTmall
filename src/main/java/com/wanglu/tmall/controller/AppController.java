package com.wanglu.tmall.controller;

import com.wanglu.tmall.model.Category;
import com.wanglu.tmall.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
//@RequestMapping("/")
public class AppController {


    @Resource(name = "categoryService")
    CategoryService service;
//
//    @Resource
//    MessageSource messageSource;
//    private Logger logger = Logger.getLogger(this.getClass().getName());


    /*
     * This method will list all existing employees.
     */
    @RequestMapping(value = {"forehome"}, method = RequestMethod.GET)
    public String homePage(ModelMap model, HttpSession session) {

//        List<Product> c = service.findByCategoryID(60);
        List<Category> categorys = service.findAllCategory();
        model.addAttribute("cs", categorys);
        if (session.getAttribute("user") != null)
            model.addAttribute("user", session.getAttribute("user"));
        return "home";
    }

    @RequestMapping(value = "forecategory", method = RequestMethod.GET)
    public String categoryPage(@RequestParam("cid") int cid, ModelMap map) {
        Category c = service.findById(cid);
        map.addAttribute("c", c);
        return "category";
    }


}