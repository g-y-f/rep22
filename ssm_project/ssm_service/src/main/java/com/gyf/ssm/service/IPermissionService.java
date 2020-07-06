package com.gyf.ssm.service;

import com.gyf.ssm.Permission;

import java.util.List;

public interface IPermissionService {
    List<Permission> findAll();

    void save(Permission permission);
}
