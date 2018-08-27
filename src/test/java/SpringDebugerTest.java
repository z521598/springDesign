import com.github.bean.SimpleBean;
import org.junit.Test;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by langshiquan on 2018/8/26.
 */
public class SpringDebugerTest {
    @Test
    public void testXmlBeanFactory() throws Exception {
        // xmlBeanFactory为延迟加载Bean
        XmlBeanFactory xmlBeanFactory = new XmlBeanFactory(new ClassPathResource("applicationContext-profile.xml"));
        SimpleBean simpleBean = (SimpleBean) xmlBeanFactory.getBean("simpleBean");
        System.out.println(simpleBean);
    }
    @Test
    public void testApplicationContext() throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext-profile.xml");
        SimpleBean simpleBean = (SimpleBean) applicationContext.getBean("simpleBean");
        System.out.println(simpleBean);
    }

    @Test
    public void testSet() throws Exception {
        Set<String> set = new HashSet<String>();
        System.out.println(set.add("1"));
        System.out.println(set.add("1"));

    }
}
