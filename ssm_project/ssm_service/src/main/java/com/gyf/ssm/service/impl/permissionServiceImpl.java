package com.gyf.ssm.service.impl;

import com.gyf.ssm.Permission;
import com.gyf.ssm.dao.IPermissions;
import com.gyf.ssm.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class permissionServiceImpl implements IPermissionService {
    @Autowired
    private IPermissions permissions;
    @Override
    public List<Permission> findAll() {
        return permissions.findAll();
    }

    @Override
    public void save(Permission permission) {
        permissions.save(permission);
    }
}
