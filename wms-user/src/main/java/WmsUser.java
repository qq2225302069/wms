import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableAutoConfiguration
@ComponentScan(basePackages = "com.wms")
@MapperScan(basePackages = "com.wms.mapper")
@EnableTransactionManagement
@EnableAspectJAutoProxy
public class WmsUser
{
    public static void main( String[] args )
    {
        SpringApplication.run(WmsUser.class,args);
    }
}
