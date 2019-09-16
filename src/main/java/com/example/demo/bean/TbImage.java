package com.example.demo.bean;


public class TbImage {

  private long id;
  private String url;

  @Override
  public String toString() {
    return "TbImage{" +
            "id=" + id +
            ", url='" + url + '\'' +
            '}';
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

}
