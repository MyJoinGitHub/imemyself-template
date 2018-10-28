package aop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AopServiceImpl implements AopService {

    private final static Logger LOGGER = LogManager.getLogger(AopServiceImpl.class);

    @Override
    public Boolean before() {
        LOGGER.info("原始方法执行");
        return true;
    }

    @Override
    public Boolean after() {
        LOGGER.info("原始方法执行");
        return false;
    }

    @Override
    public Integer exception(Boolean flag) {
        if(flag){
            LOGGER.error("异常");
            throw new RuntimeException("测试异常");
        }
        return 1;
    }

    @Override
    public Boolean introduce() {
        return false;
    }
}
