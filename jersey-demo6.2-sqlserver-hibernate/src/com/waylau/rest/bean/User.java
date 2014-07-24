package com.waylau.rest.bean;

import javax.xml.bind.annotation.XmlRootElement;  
/* *
 * 用户 bean 
 * @author waylau.com
 * 2014-7-24
 */
@XmlRootElement  
public class User {  

    private String userId;  
    private String userName;  
    private String age;  

    public User() {};  

    public User(String userId, String userName, String age) {  
        this.userId = userId;  
        this.userName = userName;  
        this.age = age;  
    }  
    public String getUserId() {  
        return userId;  
    }  
    public void setUserId(String userId) {  
        this.userId = userId;  
    }  
    public String getUserName() {  
        return userName;  
    }  
    public void setUserName(String userName) {  
        this.userName = userName;  
    }  
    public String getAge() {  
        return age;  
    }  
    public void setAge(String age) {  
        this.age = age;  
    }  
}  