package com.imemyself.template.dao.test;

import com.github.pagehelper.PageHelper;
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

import java.util.List;

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

    @Test
    public void testSessionUpdate(){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        try {
            DictionaryType param = new DictionaryType();
            param.setId(4L);
            param.setDictionaryTypeCode("status");
            param.setDictionaryTypeName("状态");
            int obj = sqlSession.insert("com.imemyself.template.dao.DictionaryTypeMapper.update", param);
            LOG.info("Result:{}", obj);
        }catch (Exception e){
            LOG.error("Mybatis 操作数据库异常",e);
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testMapperUpdate(){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        try {
            DictionaryTypeMapper mapper = sqlSession.getMapper(DictionaryTypeMapper.class);
            DictionaryType obj = new DictionaryType();
            obj.setId(5L);
            obj.setDictionaryTypeCode("ruleType");
            obj.setDictionaryTypeName("规则类型");
            mapper.update(obj);
            LOG.info("Result:{}", obj);
        }catch (Exception e){
            LOG.error("Mybatis 操作数据库异常",e);
        } finally {
            sqlSession.close();
        }
    }


    @Test
    public void testSessionDelete(){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        try {
            int obj = sqlSession.delete("com.imemyself.template.dao.DictionaryTypeMapper.delete", 4L);
            LOG.info("Result:{}", obj);
        }catch (Exception e){
            LOG.error("Mybatis 操作数据库异常",e);
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testMapperDelete(){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        try {
            DictionaryTypeMapper mapper = sqlSession.getMapper(DictionaryTypeMapper.class);
            Integer obj = mapper.delete(4L);
            LOG.info("Result:{}", obj);
        }catch (Exception e){
            LOG.error("Mybatis 操作数据库异常",e);
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testList(){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        try {
            DictionaryTypeMapper mapper = sqlSession.getMapper(DictionaryTypeMapper.class);
            PageHelper.startPage(0,1);
            DictionaryType dictionaryType = new DictionaryType();
            List<DictionaryType> obj = mapper.find(dictionaryType);
            LOG.info("Result:{}", obj);
            PageHelper.offsetPage(1,1);
            obj = mapper.find(dictionaryType);
            LOG.info("Result:{}", obj);
            PageHelper.offsetPage(2,1);
            obj = mapper.find(dictionaryType);
            LOG.info("Result:{}", obj);
        }catch (Exception e){
            LOG.error("Mybatis 操作数据库异常",e);
        } finally {
            sqlSession.close();
        }
    }
}
