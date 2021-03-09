package com.msm.service;

import com.msm.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
     List<User> selUser(User user);
}
