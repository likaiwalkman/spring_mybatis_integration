package org.victor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.victor.service.MemberListAble;

@Controller
@RequestMapping(name = "memberController", value = "/member")

public class MemberController {
    @Autowired
    private MemberListAble memberListAble;

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, produces = "html/text", value = "/listAll.action")
    public String listAll() {
        return memberListAble.list().toString();
    }
}
