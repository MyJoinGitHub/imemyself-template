package soundsystem;

import org.springframework.stereotype.Component;

/**
 * Created by linshibiji on 2018/9/21.
 */
//@Component
public class SgtPeppars implements CompactDisc {

    @Override
    public void play() {
        System.out.println(this.getClass().getCanonicalName());
    }
}
