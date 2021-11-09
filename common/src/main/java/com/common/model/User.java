package com.common.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.Collection;
import java.util.List;

@Entity
@Data
//将对象转换为json报错
@JsonIgnoreProperties(value = { "hibernateLazyInitializer"})
@ApiModel
public class User implements UserDetails
{
    /**
     * jpa save要求配置生成规则，或者填写id
     */
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    @ApiModelProperty(value="用户名", example="韩愈")
    private String name;
    @ApiModelProperty(value="手机", example="18568123666")
    private String phone;
    @ApiModelProperty(value="电话", example="029-82111555")
    private String telephone;
    @ApiModelProperty(value="住址", example="广州")
    private String address;
    @ApiModelProperty(value="启用")
    private Boolean enabled;
    @ApiModelProperty(value="用户名", example="xingguo")
    private String username;
    @ApiModelProperty(value="密码", example="111")
    private String password;
    @ApiModelProperty(value="头像", example="userface")
    private String userface;
    @ApiModelProperty(value="备注", example="remark")
    private String remark;
    /**
     * 通过关系表user_role，实现多对多
     * CascadeType.DETACH 表示不操作Role实体，只处理关联关系（user_role）
     * @return
     */
    @ManyToMany(cascade = { CascadeType.DETACH,CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = {@JoinColumn(name = "user_id")}, inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private List<Role> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities()
    {
        return null;
    }

    @Override
    public boolean isAccountNonExpired()
    {
        return true;
    }

    @Override
    public boolean isAccountNonLocked()
    {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired()
    {
        return true;
    }

    @Override
    public boolean isEnabled()
    {
        return true;
    }
}
