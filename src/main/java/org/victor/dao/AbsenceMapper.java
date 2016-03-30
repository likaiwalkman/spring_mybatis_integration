package org.victor.dao;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.victor.model.AbsenceExample;
import org.victor.model.AbsenceKey;

public interface AbsenceMapper {
    int countByExample(AbsenceExample example);

    int deleteByExample(AbsenceExample example);

    @Delete({
        "delete from absence",
        "where student_id = #{studentId,jdbcType=INTEGER}",
          "and date = #{date,jdbcType=DATE}"
    })
    int deleteByPrimaryKey(AbsenceKey key);

    @Insert({
        "insert into absence (student_id, date)",
        "values (#{studentId,jdbcType=INTEGER}, #{date,jdbcType=DATE})"
    })
    int insert(AbsenceKey record);

    int insertSelective(AbsenceKey record);

    List<AbsenceKey> selectByExample(AbsenceExample example);

    int updateByExampleSelective(@Param("record") AbsenceKey record, @Param("example") AbsenceExample example);

    int updateByExample(@Param("record") AbsenceKey record, @Param("example") AbsenceExample example);
}