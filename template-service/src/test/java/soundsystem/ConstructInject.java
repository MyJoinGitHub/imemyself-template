package soundsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by linshibiji on 2018/9/21.
 */
@Component
public class ConstructInject {

    private CompactDisc compactDisc;

    public ConstructInject(){
        System.out.println(this);
    }
    //构造方法自动注入
    //@Autowired
    public ConstructInject(CompactDisc compactDisc){
        this.compactDisc=compactDisc;
        System.out.println(compactDisc);
        System.out.println(this);
    }

    //通过方法注入，不限制方法名字
    @Autowired
    public void inject(CompactDisc compactDisc){
        this.compactDisc=compactDisc;
        System.out.println(compactDisc);
    }

    public void setCompactDisc(CompactDisc compactDisc) {
        this.compactDisc = compactDisc;
    }
}
