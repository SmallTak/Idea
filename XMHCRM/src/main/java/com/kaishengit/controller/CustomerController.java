package com.kaishengit.controller;

import com.github.pagehelper.PageInfo;
import com.kaishengit.entity.Customer;
import com.kaishengit.entity.Product;
import com.kaishengit.entity.ProductType;
import com.kaishengit.exception.NotFountException;
import com.kaishengit.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/product")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/{id:\\d+}/del")
    public String delProduct(@PathVariable Integer id, RedirectAttributes redirectAttributes){

        customerService.delProduct(id);
        redirectAttributes.addFlashAttribute("message","客户删除成功");
        return "redirect:/product";
    }

    @GetMapping("/{id:\\d+}/edit")
    public String editProduct(@PathVariable Integer id, Model model){

        Customer customer = customerService.findById(id);
        if (customer == null){
            throw new NotFountException();
        }

        model.addAttribute("customer",customer);

        return "product/edit";
    }

    @PostMapping("/{id:\\d+}/edit")
    public String editProduct(Customer customer, RedirectAttributes redirectAttributes){

        customerService.updateProduct(customer);

        redirectAttributes.addFlashAttribute("message","商品修改成功");
        return "redirect:/product";
    }

    @GetMapping("/{id:\\d+}")
    public String viewProduct(@PathVariable Integer id, Model model){

        Customer customer = customerService.findById(id);
        if (customer == null){
            throw new NotFountException();
        }
        model.addAttribute("customer",customer);
        return "product/product";

    }
    @GetMapping
    public String listProduct(@RequestParam(defaultValue = "1",name = "p",required = false) Integer pageNo, Model model,
                              @RequestParam(required = false) String mobile
                              ){


        Map<String,Object> queryParamMap = new HashMap<>();
        queryParamMap.put("mobile", mobile);

        PageInfo<Product> productPageInfo = customerService.findAllPageAndQueryParam(pageNo,queryParamMap);

        model.addAttribute("productPageInfo",productPageInfo);
        return "product/list";
    }

    @GetMapping("/new")
    public String newProduct(Model model){

        return "product/new";
    }

    @PostMapping("/new")
    public String newProduct(Customer customer, RedirectAttributes redirectAttributes){

        customerService.saveCustomer(customer);
        redirectAttributes.addFlashAttribute("message","客户保存成功");
        return "redirect:/product";
    }

}
