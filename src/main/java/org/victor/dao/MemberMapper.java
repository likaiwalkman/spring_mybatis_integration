package org.victor.dao;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.victor.model.Member;
import org.victor.model.MemberExample;

public interface MemberMapper {
    int countByExample(MemberExample example);

    int deleteByExample(MemberExample example);

    @Delete({
        "delete from member",
        "where member_id = #{memberId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer memberId);

    @Insert({
        "insert into member (member_id, last_name, ",
        "first_name, suffix, ",
        "expiration, email, ",
        "street, city, state, ",
        "zip, phone, interests)",
        "values (#{memberId,jdbcType=INTEGER}, #{lastName,jdbcType=VARCHAR}, ",
        "#{firstName,jdbcType=VARCHAR}, #{suffix,jdbcType=VARCHAR}, ",
        "#{expiration,jdbcType=DATE}, #{email,jdbcType=VARCHAR}, ",
        "#{street,jdbcType=VARCHAR}, #{city,jdbcType=VARCHAR}, #{state,jdbcType=VARCHAR}, ",
        "#{zip,jdbcType=VARCHAR}, #{phone,jdbcType=VARCHAR}, #{interests,jdbcType=VARCHAR})"
    })
    int insert(Member record);

    int insertSelective(Member record);

    List<Member> selectByExample(MemberExample example);

    @Select({
        "select",
        "member_id, last_name, first_name, suffix, expiration, email, street, city, state, ",
        "zip, phone, interests",
        "from member",
        "where member_id = #{memberId,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    Member selectByPrimaryKey(Integer memberId);

    int updateByExampleSelective(@Param("record") Member record, @Param("example") MemberExample example);

    int updateByExample(@Param("record") Member record, @Param("example") MemberExample example);

    int updateByPrimaryKeySelective(Member record);

    @Update({
        "update member",
        "set last_name = #{lastName,jdbcType=VARCHAR},",
          "first_name = #{firstName,jdbcType=VARCHAR},",
          "suffix = #{suffix,jdbcType=VARCHAR},",
          "expiration = #{expiration,jdbcType=DATE},",
          "email = #{email,jdbcType=VARCHAR},",
          "street = #{street,jdbcType=VARCHAR},",
          "city = #{city,jdbcType=VARCHAR},",
          "state = #{state,jdbcType=VARCHAR},",
          "zip = #{zip,jdbcType=VARCHAR},",
          "phone = #{phone,jdbcType=VARCHAR},",
          "interests = #{interests,jdbcType=VARCHAR}",
        "where member_id = #{memberId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Member record);
}