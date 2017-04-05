package com.hxsn.lfqx.entity;

import com.alibaba.fastjson.annotation.JSONField;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * Created by Administrator on 2017/2/15.
 * 用Entity可以在数据库中生产表结构信息
 */

public class User implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * userId:商家用户ID
     */
    @Id
   // @GenericGenerator(name="idGenerator", strategy="uuid") //这个是hibernate的注解/生成32位UUID
   // @GeneratedValue(generator="idGenerator")
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String userId;

    /**
     * userName:商家用户名  大家帮忙看看这是什么问题
     */
    private String userName;

    /**
     * createDate:创建时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss",serialize = true)
    private Date createDate;

    /**
     * screenName:用户别名
     */
    private String screenName;

    /**
     * repassword:密码
     */
    @JSONField(serialize=false)
    private String password;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }



    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
