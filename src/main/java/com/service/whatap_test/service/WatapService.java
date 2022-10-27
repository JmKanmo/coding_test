package com.service.whatap_test.service;

import com.service.whatap_test.domain.UserDomain;
import com.service.whatap_test.util.ParsingUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class WatapService {
    public List<UserDomain> findUserList() {
        return ParsingUtil.findUserJson();
    }

    public UserDomain findUser(int id) {
        return ParsingUtil.findUser(id);
    }

    public boolean deleteUser(int id) {
        return ParsingUtil.deleteUser(id);
    }

    public List<UserDomain> findUserByName(String name) {
        return ParsingUtil.findUserByName(name);
    }
}
