package com.imemyself.template.common.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class Log4j2TestUnit {

    Logger logger = LogManager.getLogger(Log4j2TestUnit.class);

    @Test
    public void testOne() {
        logger.error("Hello world!");
        logger.info("Hello world!");
        logger.warn("Hello world!");
    }
}
