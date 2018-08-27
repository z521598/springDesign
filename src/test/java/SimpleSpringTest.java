import com.github.bean.SimpleBean;
import com.github.service.ServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.RuntimeBeanReference;
import org.springframework.beans.factory.support.*;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * Created by langshiquan on 2018/8/25.
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class SimpleSpringTest {
    private final String beanName = "simpleBean";
    private final String beanName2 = "simpleBean2";
    private final String daoClass = "com.github.service.Dao";
    private final String serviceClass = "com.github.service.ServiceImpl";
    private final String serviceBeanName = "service";
    private final String daoBeanName = "dao";


    DefaultListableBeanFactory defaultListableBeanFactory;

    @Before
    public void setUp() throws Exception {
        defaultListableBeanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(defaultListableBeanFactory);
        xmlBeanDefinitionReader.loadBeanDefinitions(new ClassPathResource("applicationContext.xml"));

    }

    @Test
    public void testApplicationContext() throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        SimpleBean simpleBean = (SimpleBean) applicationContext.getBean(beanName);
        Assert.assertEquals(1L, simpleBean.getId().longValue());
    }

    @Test
    public void testXmlBeanDefinitionReader() throws Exception {
        SimpleBean sb = (SimpleBean) defaultListableBeanFactory.getBean(beanName);
        Assert.assertEquals(1L, sb.getId().longValue());
        Assert.assertEquals("lsq", sb.getName());

    }

    @Test
    public void testDefaultListableBeanFactory() throws Exception {
        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setBeanClassName("com.github.bean.SimpleBean");
        beanDefinition.setScope(GenericBeanDefinition.SCOPE_SINGLETON);
        MutablePropertyValues mutablePropertyValues = new MutablePropertyValues();
        mutablePropertyValues.addPropertyValue("id", 2L);
        mutablePropertyValues.addPropertyValue("name", "lsq2");
        beanDefinition.setPropertyValues(mutablePropertyValues);

        defaultListableBeanFactory.registerBeanDefinition(beanName2, beanDefinition);
        SimpleBean sb = (SimpleBean) defaultListableBeanFactory.getBean(beanName2);
        Assert.assertEquals(2L, sb.getId().longValue());
        Assert.assertEquals("lsq2", sb.getName());
    }

    @Test
    public void testAutowireRuntimeReference() throws Exception {
        GenericBeanDefinition daoBeanDefinition = new GenericBeanDefinition();
        daoBeanDefinition.setBeanClassName(daoClass);
        daoBeanDefinition.setScope(GenericBeanDefinition.SCOPE_SINGLETON);

        GenericBeanDefinition serviceBeanDefinition = new GenericBeanDefinition();
        serviceBeanDefinition.setBeanClassName(serviceClass);
        serviceBeanDefinition.setScope(GenericBeanDefinition.SCOPE_SINGLETON);
        MutablePropertyValues mutablePropertyValues = new MutablePropertyValues();
        // RuntimeBeanReference
        mutablePropertyValues.addPropertyValue(daoBeanName, new RuntimeBeanReference(daoBeanName));
        serviceBeanDefinition.setPropertyValues(mutablePropertyValues);

        defaultListableBeanFactory.registerBeanDefinition(serviceBeanName, serviceBeanDefinition);
        defaultListableBeanFactory.registerBeanDefinition(daoBeanName, daoBeanDefinition);

        ServiceImpl service = (ServiceImpl) defaultListableBeanFactory.getBean(serviceBeanName);
        Assert.assertNotNull(service.getDao());

    }
}
