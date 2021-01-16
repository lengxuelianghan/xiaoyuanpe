package com.xiaoyuanpe.services;

public interface LoginService {
    String login(String username, String password, Integer schoolId);
    String login(String username, String password);
}
