package com.eappcat.base.oauth2.starter.base.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Date;

public class AuditMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        String user=SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        this.setFieldValByName("createdDate", new Date(), metaObject);
        this.setFieldValByName("createdBy", user, metaObject);
        this.setFieldValByName("updatedDate", new Date(), metaObject);
        this.setFieldValByName("updatedBy", user, metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        String user=SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        this.setFieldValByName("updatedDate", new Date(), metaObject);
        this.setFieldValByName("updatedBy", user, metaObject);
    }
}
