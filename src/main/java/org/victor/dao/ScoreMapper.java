package org.victor.dao;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.victor.model.Score;
import org.victor.model.ScoreExample;
import org.victor.model.ScoreKey;

public interface ScoreMapper {
    int countByExample(ScoreExample example);

    int deleteByExample(ScoreExample example);

    @Delete({
        "delete from score",
        "where event_id = #{eventId,jdbcType=INTEGER}",
          "and student_id = #{studentId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(ScoreKey key);

    @Insert({
        "insert into score (event_id, student_id, ",
        "score)",
        "values (#{eventId,jdbcType=INTEGER}, #{studentId,jdbcType=INTEGER}, ",
        "#{score,jdbcType=INTEGER})"
    })
    int insert(Score record);

    int insertSelective(Score record);

    List<Score> selectByExample(ScoreExample example);

    @Select({
        "select",
        "event_id, student_id, score",
        "from score",
        "where event_id = #{eventId,jdbcType=INTEGER}",
          "and student_id = #{studentId,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    Score selectByPrimaryKey(ScoreKey key);

    int updateByExampleSelective(@Param("record") Score record, @Param("example") ScoreExample example);

    int updateByExample(@Param("record") Score record, @Param("example") ScoreExample example);

    int updateByPrimaryKeySelective(Score record);

    @Update({
        "update score",
        "set score = #{score,jdbcType=INTEGER}",
        "where event_id = #{eventId,jdbcType=INTEGER}",
          "and student_id = #{studentId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Score record);
}