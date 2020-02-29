package com.zbw.secondskill.controller;

import com.zbw.secondskill.model.ItemModel;
import com.zbw.secondskill.model.dto.ResultDTO;
import com.zbw.secondskill.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

/**
 * @ClassName ItemController.java
 * @Description //商品controller
 * @Author ZBW
 * @Date 2020年03月01日 00:13
 **/
@RestController
@CrossOrigin(origins = {"*"} ,allowedHeaders = "true")
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping(value = "/create")
    public ResultDTO createItem(@RequestParam(name = "title") String title,
                                @RequestParam(name = "price") BigDecimal price,
                                @RequestParam(name = "stock") Integer stock,
                                @RequestParam(name = "description") String description,
                                @RequestParam(name = "imgUrl") String imgUrl) {
        ItemModel itemModel = new ItemModel(title, price, stock, description, imgUrl);
        return itemService.createItem(itemModel);
    }

    @GetMapping(value = "/get")
    public ResultDTO getItem(@RequestParam(name = "id") Integer id) {
        return itemService.getItemById(id);
    }

}
