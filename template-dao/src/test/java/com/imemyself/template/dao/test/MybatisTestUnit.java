package com.imemyself.template.dao.test;

import com.imemyself.template.dao.DictionaryTypeMapper;
import com.imemyself.template.domain.DictionaryType;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

public class MybatisTestUnit {

    Logger LOG = LogManager.getLogger(MybatisTestUnit.class);

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void initMybatisConfig() throws Exception {
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        sqlSessionFactory = builder.build(Resources.getResourceAsReader("mybatis-config.xml"));
        LOG.info(sqlSessionFactory);
    }

    @Test
    public void testSessionQuery(){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        try {
            DictionaryType obj = sqlSession.selectOne("com.imemyself.template.dao.DictionaryTypeMapper.findOne",1L);
            LOG.info("Result:{}", obj);
        }catch (Exception e){
            LOG.error("Mybatis 操作数据库异常",e);
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testMapperQuery() {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        try {
            DictionaryTypeMapper mapper = sqlSession.getMapper(DictionaryTypeMapper.class);
            DictionaryType obj = mapper.findOne(1L);
            LOG.info("Result:{}", obj);
        }catch (Exception e){
            LOG.error("Mybatis 操作数据库异常",e);
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testSessionSave(){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        try {
            DictionaryType param = new DictionaryType();
            param.setDictionaryTypeCode("status");
            param.setDictionaryTypeName("状态");
            int obj = sqlSession.insert("com.imemyself.template.dao.DictionaryTypeMapper.save", param);
            LOG.info("Result:{}", obj);
        }catch (Exception e){
            LOG.error("Mybatis 操作数据库异常",e);
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testMapperSave(){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        try {
            DictionaryTypeMapper mapper = sqlSession.getMapper(DictionaryTypeMapper.class);
            DictionaryType obj = new DictionaryType();
            obj.setDictionaryTypeCode("ruleType");
            obj.setDictionaryTypeName("规则类型");
            mapper.save(obj);
            LOG.info("Result:{}", obj);
        }catch (Exception e){
            LOG.error("Mybatis 操作数据库异常",e);
        } finally {
            sqlSession.close();
        }
    }

}
