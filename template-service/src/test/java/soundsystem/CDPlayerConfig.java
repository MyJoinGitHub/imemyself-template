package soundsystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * Created by linshibiji on 2018/9/21.
 */
@Configuration
@ComponentScan
public class CDPlayerConfig {

    @Bean
    public CompactDisc sgtPepars(){
        return new SgtPeppars();
    }

    @Bean
    public ConstructInject constructInjectOne(){
        ConstructInject constructInject=new ConstructInject(sgtPepars());
        return constructInject;
    }

    @Bean
    public ConstructInject constructInjectTwo(CompactDisc sgtPepars){
        ConstructInject constructInject=new ConstructInject(sgtPepars);
        return constructInject;
    }

    @Bean
    public ConstructInject constructInjectThree(CompactDisc sgtPepars){
        ConstructInject constructInject=new ConstructInject();
        constructInject.setCompactDisc(sgtPepars);
        return constructInject;
    }
}
