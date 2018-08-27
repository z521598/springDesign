import com.github.bean.ChildSimpleBean;
import com.github.bean.SimpleBean;
import org.junit.Test;

/**
 * Created by langshiquan on 2018/8/25.
 */
public class CastTest {
    @Test
    public void testCast() throws Exception {
        SimpleBean simpleBean = new SimpleBean();

        ChildSimpleBean childSimpleBean = new ChildSimpleBean();

//        ChildSimpleBean childSimpleBean2 = ChildSimpleBean.class.cast(simpleBean);
        SimpleBean simpleBean2 = SimpleBean.class.cast(childSimpleBean);
        System.out.println(simpleBean);
        System.out.println(childSimpleBean);
        System.out.println(simpleBean2);
//        System.out.println(childSimpleBean2);

        SimpleBean simpleBean1 = (SimpleBean) null;



    }
}
