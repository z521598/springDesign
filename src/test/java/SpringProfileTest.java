import com.github.bean.SimpleBean;
import com.github.service.ServiceImpl;
import com.github.util.StringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by langshiquan on 2018/8/25.
 */
@ActiveProfiles("online")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext-profile.xml"})
public class SpringProfileTest {

    @Autowired
    private Environment environment;


    @Autowired
    private ApplicationContext applicationContext;

    // 激活的 覆盖 默认的
    @Test
    public void testBean() throws Exception {
        SimpleBean simpleBean2 = (SimpleBean) applicationContext.getBean("simpleBean2");
        Assert.assertEquals(2L, simpleBean2.getId().longValue());
        SimpleBean simpleBean = (SimpleBean) applicationContext.getBean("simpleBean");
        Assert.assertEquals(3L, simpleBean.getId().longValue());
    }

    @Test
    public void testEnv() throws Exception {
        System.out.println(StringUtils.toString(environment.getDefaultProfiles()));
        System.out.println(StringUtils.toString(environment.getActiveProfiles()));
        System.out.println(System.getProperty("spring.profiles.active"));
    }
}
