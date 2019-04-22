package com.yiwei.ywt.sys.serviceInformation.mapper;

import com.yiwei.ywt.framework.dao.CRUDMapper;
import com.yiwei.ywt.sys.serviceInformation.model.PayMode;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PayModeMapper extends CRUDMapper<PayMode> {
    List<PayMode> selectAll();
}