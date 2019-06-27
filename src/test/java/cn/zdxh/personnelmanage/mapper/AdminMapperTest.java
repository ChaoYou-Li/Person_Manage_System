package cn.zdxh.personnelmanage.mapper;

import cn.zdxh.personnelmanage.po.Admin;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class AdminMapperTest {

    @Autowired
    private AdminMapper adminMapper;

    @Test
    public void testFindAdmin(){
        Admin admin = new Admin();
        admin.setUsername("admin");
        admin.setPassword("123456");
        Admin resultAdmin = adminMapper.findAdmin(admin);
//        log.info("admin = {}",resultAdmin);
    }

    @Test
    public void testFindAllAdmins(){
        List<Admin> allAdmins = adminMapper.findAllAdmins();
        for (Admin admin : allAdmins){
//            log.info("admin = {}",admin);
        }
    }
}
