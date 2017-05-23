package com.chen.controller;


import com.chen.common.pojo.EasyUITreeNode;
import com.chen.service.ItemCatService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商品分类管理
 * Created by chen on 2017/5/23.
 */
@Controller
@RequestMapping("/item/cat")
public class ItemCatController {

    @Resource
    private ItemCatService itemCatService;
    @RequestMapping("/list")
    @ResponseBody
    public List<EasyUITreeNode> getItemCatList(@RequestParam(value = "id",defaultValue = "0")Long parentId) {
        return itemCatService.getItemCatList(parentId);
    }
}
