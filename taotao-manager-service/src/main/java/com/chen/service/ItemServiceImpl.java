package com.chen.service;

import com.chen.mapper.TbItemMapper;
import com.chen.common.pojo.EasyUIDataGridResult;
import com.chen.common.pojo.TbItem;
import com.chen.common.pojo.TbItemExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by chen on 2017/5/22.
 */
@Service
public class ItemServiceImpl implements  ItemService {
    @Resource
    TbItemMapper itemMapper;
    @Override
    public EasyUIDataGridResult getItemList(int page, int rows) {
        //分页处理
        PageHelper.startPage(page,rows);
        //执行查询
        TbItemExample tbItemExample = new TbItemExample();
        List<TbItem> tbItemList = itemMapper.selectByExample(tbItemExample);
        PageInfo<TbItem> pageInfo = new PageInfo<TbItem>(tbItemList);
        //返回结果
        EasyUIDataGridResult easyUIDataGridResult = new EasyUIDataGridResult();
        easyUIDataGridResult.setTotal(pageInfo.getTotal());
        easyUIDataGridResult.setRows(tbItemList);
        return easyUIDataGridResult;
    }
}
