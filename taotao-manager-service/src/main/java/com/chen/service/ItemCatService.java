package com.chen.service;


import com.chen.common.pojo.EasyUITreeNode;

import java.util.List;

/**
 * Created by chen on 2017/5/23.
 */
public interface ItemCatService {
    public List<EasyUITreeNode> getItemCatList(Long parentId);
}
