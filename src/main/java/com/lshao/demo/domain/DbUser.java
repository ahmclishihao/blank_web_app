package com.lshao.demo.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * 用户
 * @author lish [254174981@qq.com]
 * @date 17-12-2
 */
@Entity
@Table(name = "db_user")
public class DbUser {

    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    /**
     * 帐号
     */
    @Column
    private String username;

    /**
     * 密码
     */
    @Column
    private String password;

    /**
     * 姓名
     */
    @Column
    private String name;

    /**
     * 性别
     */
    @Column
    private Boolean sexType;

    /**
     * 是否有效
     */
    @Column
    private Boolean isEffect;

    /**
     * 是否删除
     */
    @Column
    private Boolean isDelete;

    /**
     * 创建时间
     */
    @Column
    private Date createTime;

    /**
     * 修改时间
     */
    @Column
    private Date modifyTime;

    /**
     * 创建人
     */
    @Column
    private Integer createUser;

    /**
     * 修改人
     */
    @Column
    private Integer modifyUser;

    /**
     * 父级用户
     */
    @ManyToOne
    @JoinColumn(name = "pId",insertable = false,updatable = false)
    private DbUser parentUser;

    /**
     * 子用户集合
     */
    @OneToMany(mappedBy = "parentUser")
    private Set<DbUser> userSet;

    /**
     * 获取 id 的值。
     *
     * @return
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置 id 的值。
     *
     * @param id
     */
    public DbUser setId(Integer id) {
        this.id = id;
        return this;
    }

    /**
     * 获取 username 的值。
     *
     * @return
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置 username 的值。
     *
     * @param username
     */
    public DbUser setUsername(String username) {
        this.username = username;
        return this;
    }

    /**
     * 获取 password 的值。
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置 password 的值。
     *
     * @param password
     */
    public DbUser setPassword(String password) {
        this.password = password;
        return this;
    }

    /**
     * 获取 name 的值。
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * 设置 name 的值。
     *
     * @param name
     */
    public DbUser setName(String name) {
        this.name = name;
        return this;
    }

    /**
     * 获取 sexType 的值。
     *
     * @return
     */
    public Boolean getSexType() {
        return sexType;
    }

    /**
     * 设置 sexType 的值。
     *
     * @param sexType
     */
    public DbUser setSexType(Boolean sexType) {
        this.sexType = sexType;
        return this;
    }

    /**
     * 获取 isEffect 的值。
     *
     * @return
     */
    public Boolean getIsEffect() {
        return isEffect;
    }

    /**
     * 设置 isEffect 的值。
     *
     * @param isEffect
     */
    public DbUser setIsEffect(Boolean isEffect) {
        this.isEffect = isEffect;
        return this;
    }

    /**
     * 获取 isDelete 的值。
     *
     * @return
     */
    public Boolean getIsDelete() {
        return isDelete;
    }

    /**
     * 设置 isDelete 的值。
     *
     * @param isDelete
     */
    public DbUser setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
        return this;
    }

    /**
     * 获取 createTime 的值。
     *
     * @return
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置 createTime 的值。
     *
     * @param createTime
     */
    public DbUser setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    /**
     * 获取 modifyTime 的值。
     *
     * @return
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 设置 modifyTime 的值。
     *
     * @param modifyTime
     */
    public DbUser setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
        return this;
    }

    /**
     * 获取 createUser 的值。
     *
     * @return
     */
    public Integer getCreateUser() {
        return createUser;
    }

    /**
     * 设置 createUser 的值。
     *
     * @param createUser
     */
    public DbUser setCreateUser(Integer createUser) {
        this.createUser = createUser;
        return this;
    }

    /**
     * 获取 modifyUser 的值。
     *
     * @return
     */
    public Integer getModifyUser() {
        return modifyUser;
    }

    /**
     * 设置 modifyUser 的值。
     *
     * @param modifyUser
     */
    public DbUser setModifyUser(Integer modifyUser) {
        this.modifyUser = modifyUser;
        return this;
    }

    /**
     * 获取 parentUser 的值。
     *
     * @return
     */
    public DbUser getParentUser() {
        return parentUser;
    }

    /**
     * 设置 parentUser 的值。
     *
     * @param parentUser
     */
    public DbUser setParentUser(DbUser parentUser) {
        this.parentUser = parentUser;
        return this;
    }

    /**
     * 获取 userSet 的值。
     *
     * @return
     */
    public Set<DbUser> getUserSet() {
        return userSet;
    }

    /**
     * 设置 userSet 的值。
     *
     * @param userSet
     */
    public DbUser setUserSet(Set<DbUser> userSet) {
        this.userSet = userSet;
        return this;
    }

    @Override
    public String toString() {
        return "DbUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", sexType=" + sexType +
                ", isEffect=" + isEffect +
                ", isDelete=" + isDelete +
                ", createTime=" + createTime +
                ", modifyTime=" + modifyTime +
                ", createUser=" + createUser +
                ", modifyUser=" + modifyUser +
                ", parentUser=" + parentUser +
                ", userSet=" + userSet +
                '}';
    }
}
