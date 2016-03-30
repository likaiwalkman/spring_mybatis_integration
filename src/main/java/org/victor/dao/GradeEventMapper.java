package org.victor.dao;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.victor.model.GradeEvent;
import org.victor.model.GradeEventExample;

public interface GradeEventMapper {
    int countByExample(GradeEventExample example);

    int deleteByExample(GradeEventExample example);

    @Delete({
        "delete from grade_event",
        "where event_id = #{eventId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer eventId);

    @Insert({
        "insert into grade_event (event_id, date, ",
        "category)",
        "values (#{eventId,jdbcType=INTEGER}, #{date,jdbcType=DATE}, ",
        "#{category,jdbcType=CHAR})"
    })
    int insert(GradeEvent record);

    int insertSelective(GradeEvent record);

    List<GradeEvent> selectByExample(GradeEventExample example);

    @Select({
        "select",
        "event_id, date, category",
        "from grade_event",
        "where event_id = #{eventId,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    GradeEvent selectByPrimaryKey(Integer eventId);

    int updateByExampleSelective(@Param("record") GradeEvent record, @Param("example") GradeEventExample example);

    int updateByExample(@Param("record") GradeEvent record, @Param("example") GradeEventExample example);

    int updateByPrimaryKeySelective(GradeEvent record);

    @Update({
        "update grade_event",
        "set date = #{date,jdbcType=DATE},",
          "category = #{category,jdbcType=CHAR}",
        "where event_id = #{eventId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(GradeEvent record);
}