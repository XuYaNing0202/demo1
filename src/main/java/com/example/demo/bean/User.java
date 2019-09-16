package com.example.demo.bean;


public class User {

  private long id;
  private String username;
  private String password;
  private String account;
  private long permission;
  private long areaId;

  @Override
  public String toString() {
    return "User{" +
            "id=" + id +
            ", username='" + username + '\'' +
            ", password='" + password + '\'' +
            ", account='" + account + '\'' +
            ", permission=" + permission +
            ", areaId=" + areaId +
            '}';
  }

  public long getAreaId() {
    return areaId;
  }

  public void setAreaId(long areaId) {
    this.areaId = areaId;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  public String getAccount() {
    return account;
  }

  public void setAccount(String account) {
    this.account = account;
  }


  public long getPermission() {
    return permission;
  }

  public void setPermission(long permission) {
    this.permission = permission;
  }

}
