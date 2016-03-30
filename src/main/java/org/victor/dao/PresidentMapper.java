package org.victor.dao;

import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.victor.model.President;
import org.victor.model.PresidentExample;

public interface PresidentMapper {
    int countByExample(PresidentExample example);

    int deleteByExample(PresidentExample example);

    @Insert({
        "insert into president (last_name, first_name, ",
        "suffix, city, state, ",
        "birth, death)",
        "values (#{lastName,jdbcType=VARCHAR}, #{firstName,jdbcType=VARCHAR}, ",
        "#{suffix,jdbcType=VARCHAR}, #{city,jdbcType=VARCHAR}, #{state,jdbcType=VARCHAR}, ",
        "#{birth,jdbcType=DATE}, #{death,jdbcType=DATE})"
    })
    int insert(President record);

    int insertSelective(President record);

    List<President> selectByExample(PresidentExample example);

    int updateByExampleSelective(@Param("record") President record, @Param("example") PresidentExample example);

    int updateByExample(@Param("record") President record, @Param("example") PresidentExample example);
}