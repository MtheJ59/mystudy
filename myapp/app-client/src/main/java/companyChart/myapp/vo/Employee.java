package companyChart.myapp.vo;

import java.io.Serializable;

public class Employee implements Serializable {

  private int name;
  private String email;
  private int tel;
  private int jumin;
  private int joinDate;
  private int addr;

  @Override
  public String toString() {
    return "Employee{" +
        "name=" + name +
        ", email='" + email + '\'' +
        ", tel='" + tel + '\'' +
        ", jumin='" + jumin + '\'' +
        ", joinDate='" + jumin + '\'' +
        ", addr=" + addr +
        '}';
  }

  public int getName() {
    return name;
  }

  public void setName(int name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public int getTel() {
    return tel;
  }

  public void setTel(int tel) {
    this.tel = tel;
  }

  public int getJumin() {
    return jumin;
  }

  public void setJumin(int jumin) {
    this.jumin = jumin;
  }

  public int getJoinDate() {
    return joinDate;
  }

  public void setJoinDate(int joinDate) {
    this.joinDate = joinDate;
  }

  public int getAddr() {
    return addr;
  }

  public void setAddr(int addr) {
    this.addr = addr;
  }
}
