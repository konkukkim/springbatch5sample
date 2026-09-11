package kr.co.wlife.fac.jhb.batch.mapper;

import kr.co.wlife.fac.jhb.batch.bean.item.TestItem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TestMapper {

    void insertTestItem(@Param("item") TestItem item);
}