/**
 * Copyright (C), 2019/4-2019/5, 武汉易维科技股份有限公司
 * FileName: AgainWaterServiceImpl
 * Author:   向珂
 * Date:     2019/4/18
 * Time:     9:56
 * 描述:
 * <author>          <time>          <version>
 * 向珂              2019/4/18           1.0.0
 */
package com.yiwei.ywt.businessProcess.againWaterMeter.service.impl;

import com.yiwei.ywt.businessProcess.againWaterMeter.mapper.AgainWaterMeterMapper;
import com.yiwei.ywt.businessProcess.againWaterMeter.model.AgainWaterMeter;
import com.yiwei.ywt.businessProcess.againWaterMeter.service.AgainWaterService;
import com.yiwei.ywt.businessProcess.handleState.mapper.HandleStateMapper;
import com.yiwei.ywt.businessProcess.handleState.model.HandleState;
import com.yiwei.ywt.framework.web.AjaxResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class AgainWaterServiceImpl implements AgainWaterService {

    @Resource
    private AgainWaterMeterMapper againWaterMeterMapper;

    @Resource
    private HandleStateMapper handleStateMapper;

    /**
     * 复接申请
     *
     * @param againWaterMeter
     * @return AgainWaterMeter
     */
    @Override
    public AgainWaterMeter addEntity(AgainWaterMeter againWaterMeter) {
        //todo 必须要绑定户号
        if (null == againWaterMeterMapper.selectByFamilyNumber(againWaterMeter.getFamilyNumber())) {
            //复接申请 想要插入办理进度业务表 只能存在唯一户号(本业务)
            //按户号校验，不允许重复提交申请
            //todo 添加到办理进度
            HandleState handleState = new HandleState();
            //业务类型（名）
            handleState.setBusinessName(AgainWaterMeter.BUSINESS_NAME);
            //业务办理状态 = 0 = 正在审核
            handleState.setBusinessState(0);
            //申请人姓名
            handleState.setApplyName(againWaterMeter.getTransactor());
            //申请人联系方式
            if (null != againWaterMeter.getTransactorMobile()) {
                //如果办理人手机号码不为空，那么添加当前办理人联系方式
                //如果户主手机号与当前办理人联系方式皆不为空，那么优先存入当前办理人联系方式
                handleState.setApplyMobile(againWaterMeter.getTransactorMobile());
            }else {
                //否则添加户主手机号码，户主手机号为必填项。
                handleState.setApplyMobile(againWaterMeter.getOwnerMobile());
            }
            //复接申请以户号检验
            handleState.setFamilyNumber(againWaterMeter.getFamilyNumber());
            //添加进办理进度业务表
                if (0 < handleStateMapper.insert(handleState)) {
                    //添加成功
                }else {
                    //添加失败
                    throw new RuntimeException(AjaxResponse.FAILURE_ADD_ENTITY);
                }
                return 0 < againWaterMeterMapper.insert(againWaterMeter) ? againWaterMeter : null;
        }else {
            //重复申请
            throw new RuntimeException(AjaxResponse.ERROR_INFO);
        }
    }
}
