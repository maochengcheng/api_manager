package com.guanting.apimanage.finaconsume.service.impl;

import com.guanting.apimanage.finaconsume.domain.FinaConsume;
import com.guanting.apimanage.finaconsume.mapper.FinaConsumeMapper;
import com.guanting.apimanage.finaconsume.service.FinaConsumeService;
import com.guanting.common.utils.DataGridResult;
import com.guanting.common.utils.UUIDGenerator;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created with Intellij IDEA
 * User: WMQ
 * Date: 2021/2/7
 * Time: 14:46
 * Description: No Description
 */
@Service
public class FinaConsumeServiceImpl implements FinaConsumeService {

    private Logger log = Logger.getLogger(this.getClass());

    @Resource
    private FinaConsumeMapper finaConsumeMapper;

    // 新增
    @Override
    public DataGridResult insertFinaConsume(FinaConsume finaConsume){
        try{
            finaConsume.setSczt("1");
            String uuid = UUIDGenerator.getUUID();
            finaConsume.setZybh(uuid);
            finaConsume.setStatus(1);
            finaConsume.setCreateTime(new Date());
            int num = finaConsumeMapper.insertSelective(finaConsume);
            if (num > 0) {
                return DataGridResult.build(0, "新增消费数据成功!", 0L, uuid);
            } else {
                return DataGridResult.build(1, "新增消费数据失败!", 0L,null);
            }
        } catch (Exception e) {
            log.error(e, e);
            return DataGridResult.build(1, "新增消费数据失败!", 0L, e);
        }
    }

}
