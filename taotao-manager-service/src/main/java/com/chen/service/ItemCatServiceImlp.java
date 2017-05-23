package com.chen.service;

import com.chen.mapper.TbItemCatMapper;
import com.chen.common.pojo.EasyUITreeNode;
import com.chen.common.pojo.TbItemCat;
import com.chen.common.pojo.TbItemCatExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**s
 * 商品分类管理
 * Created by chen on 2017/5/23.
 */
@Service
public class ItemCatServiceImlp implements  ItemCatService{

    @Resource
    private TbItemCatMapper itemCatMapper;
    @Override
    public List<EasyUITreeNode> getItemCatList(Long parentId) {
        //根据parendId查询分类列表
        TbItemCatExample tbItemCatExample = new TbItemCatExample();
        TbItemCatExample.Criteria criteria = tbItemCatExample.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        //执行查询
        List<TbItemCat> tbItemCatList = itemCatMapper.selectByExample(tbItemCatExample);
        //转换为EasyUITreeNode列表
        List<EasyUITreeNode> easyUITreeNodeList = new ArrayList<EasyUITreeNode>();
        for(TbItemCat tbItemCat : tbItemCatList){
            EasyUITreeNode easyUITreeNode = new EasyUITreeNode();
            easyUITreeNode.setId(tbItemCat.getId());
            easyUITreeNode.setText(tbItemCat.getName());
            easyUITreeNode.setState(tbItemCat.getIsParent()?"closed":"open");
            easyUITreeNodeList.add(easyUITreeNode);
        }
        return easyUITreeNodeList;
    }
}
