package com.eappcat.base.oauth2.starter.auth.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.eappcat.base.oauth2.starter.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author yuebo
 * @since 2019-10-20
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("tbl_client")
public class Client extends BaseEntity {

    private static final long serialVersionUID=1L;

    /**
     * 客户端代码
     */
    private String code;

    /**
     * 客户端密码
     */
    private String secret;

    /**
     * 客户端作用范围
     */
    private String scope;

    /**
     * 授权类型
     */
    private String grantType;


}
