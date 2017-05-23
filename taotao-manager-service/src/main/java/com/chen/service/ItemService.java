package com.chen.service;


import com.chen.common.pojo.EasyUIDataGridResult;

/**
 * Created by chen on 2017/5/22.
 */
public interface ItemService {
    public EasyUIDataGridResult getItemList(int page, int rows);
}
