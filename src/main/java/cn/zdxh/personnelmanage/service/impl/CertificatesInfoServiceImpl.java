package cn.zdxh.personnelmanage.service.impl;

import cn.zdxh.personnelmanage.po.CertificatesInfo;
import cn.zdxh.personnelmanage.mapper.CertificatesInfoMapper;
import cn.zdxh.personnelmanage.service.CertificatesInfoService;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 证件情况表 服务实现类
 * </p>
 *
 * @author Justin
 * @since 2019-03-15
 */
@Service
public class CertificatesInfoServiceImpl extends ServiceImpl<CertificatesInfoMapper, CertificatesInfo> implements CertificatesInfoService {
    @Autowired
    CertificatesInfoMapper certificatesInfoMapper;

    @Override
    public List<CertificatesInfo> findCertificatesInfoAll(int current, int size) {
        List<CertificatesInfo> list  = certificatesInfoMapper.selectPage(new Page<>(current, size), null);
        return list;
    }

    @Override
    public Integer findCertificatesInfoAllCount() {
        int num = certificatesInfoMapper.selectCount(null);
        return num;
    }

    @Override
    public void insertCertificatesInfo(CertificatesInfo employeeInfo) {
        certificatesInfoMapper.insert(employeeInfo);
    }

    @Override
    public void updateCertificatesInfo(CertificatesInfo employeeInfo) {
        certificatesInfoMapper.updateById(employeeInfo);
    }

    @Override
    public CertificatesInfo findCertificatesInfo(Integer id) {
        return certificatesInfoMapper.selectById(id);
    }

    @Override
    public void deleteCertificatesInfo(Integer id) {
        certificatesInfoMapper.deleteById(id);
    }

    @Override
    public List<CertificatesInfo> findAllCertificatesInfoBySearch(String content) {
        String param = "%"+content+"%";
        return certificatesInfoMapper.findAllCertificatesInfoBySearch(param);
    }
}
