package org.victor.dao;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.victor.model.Student;
import org.victor.model.StudentExample;

public interface StudentMapper {
    int countByExample(StudentExample example);

    int deleteByExample(StudentExample example);

    @Delete({
        "delete from student",
        "where student_id = #{studentId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer studentId);

    @Insert({
        "insert into student (student_id, name, ",
        "sex)",
        "values (#{studentId,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{sex,jdbcType=CHAR})"
    })
    int insert(Student record);

    int insertSelective(Student record);

    List<Student> selectByExample(StudentExample example);

    @Select({
        "select",
        "student_id, name, sex",
        "from student",
        "where student_id = #{studentId,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    Student selectByPrimaryKey(Integer studentId);

    int updateByExampleSelective(@Param("record") Student record, @Param("example") StudentExample example);

    int updateByExample(@Param("record") Student record, @Param("example") StudentExample example);

    int updateByPrimaryKeySelective(Student record);

    @Update({
        "update student",
        "set name = #{name,jdbcType=VARCHAR},",
          "sex = #{sex,jdbcType=CHAR}",
        "where student_id = #{studentId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Student record);
}