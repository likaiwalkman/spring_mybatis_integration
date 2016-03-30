package org.victor.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.victor.dao.MemberMapper;
import org.victor.model.Member;
import org.victor.model.MemberExample;
import org.victor.service.MemberListAble;

import java.util.List;

@Service
public class MemberListAbleImpl implements MemberListAble {

    @Autowired
    private MemberMapper memberMapper;

    public List<Member> list() {
        return memberMapper.selectByExample(new MemberExample());
    }
}
