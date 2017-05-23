package com.chen.controller;

import com.chen.common.pojo.EasyUIDataGridResult;
import com.chen.service.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by chen on 2017/5/22.
 */
@Controller
public class ItemController {

    @Resource
    ItemService itemService;
    @RequestMapping("/item/list")
    @ResponseBody
    public EasyUIDataGridResult getItemList(Integer page, Integer rows){
        return itemService.getItemList(page,rows);
    }
}
