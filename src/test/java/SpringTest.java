import com.github.SimpleBean;

import com.github.service.ServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by langshiquan on 2018/8/25.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class SpringTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void testBean() throws Exception {
        SimpleBean simpleBean = (SimpleBean) applicationContext.getBean("simpleBean");
        Assert.assertEquals(1L, simpleBean.getId().longValue());
    }

    @Test
    public void testAutowire() throws Exception {
        ServiceImpl service = (ServiceImpl) applicationContext.getBean("serviceImpl");
        Assert.assertNotNull(service.getDao());
        System.out.println("applicationName:" + applicationContext.getApplicationName());
    }


}
