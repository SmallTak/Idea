package com.kaishengit.controller;

import com.github.pagehelper.PageInfo;
import com.kaishengit.controller.result.ResponseBean;
import com.kaishengit.entity.SeckillProduct;
import com.kaishengit.service.SeckillProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private SeckillProductService seckillProductService;

    @GetMapping
    public String Home(@RequestParam(required = false, name = "p", defaultValue = "1") Integer pageNo, Model model){

        PageInfo<SeckillProduct> pageInfo = seckillProductService.findAllProductPage(pageNo);
        model.addAttribute("page",pageInfo);
        return "product/home";
    }

    @GetMapping("/new")
    public String addProduct(){
        return "product/new";
    }

    @PostMapping("/new")
    public String addProduct(SeckillProduct seckillProduct, Model model){
        seckillProductService.saveProduct(seckillProduct);
        return "redirect:/product";
    }

    @GetMapping("/{id}/del")
    public String delProduct(@PathVariable Integer id){
        seckillProductService.delProduct(id);
        return "redirect:/product";
    }

    @GetMapping("/{id}/edit")
    public String editProduct(@PathVariable Integer id, Model model){
        SeckillProduct seckillProduct = seckillProductService.findProductById(id);
        model.addAttribute("product", seckillProduct);
        return "product/edit";
    }

    @PostMapping("/{id}/edit")
    public String editProduct(SeckillProduct seckillProduct){
        seckillProductService.editProduct(seckillProduct);
        return "redirect:/product";
    }

    @GetMapping("/{id}")
    public String detailProduct(@PathVariable Integer id, Model model){
        SeckillProduct productById = seckillProductService.findProductById(id);
        model.addAttribute("product", productById);
        return "product/detail";
    }

    @GetMapping("/buy/{id}")
    @ResponseBody
    public ResponseBean seckillBuy(@PathVariable Integer id){
        try {
            seckillProductService.buyProduct(id);
        } catch (RuntimeException e) {
            return ResponseBean.error(e.getMessage());
        }
        return ResponseBean.success();
    }

}
