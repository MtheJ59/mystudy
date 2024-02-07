package companyChart.myapp.vo;

import java.io.Serializable;

public class Employee implements Serializable {

  private int no;
  private String name;
  private String email;
  private String tel;
  private String jumin;
  private String joinDate;
  private String addr;
  private  String depm;

  @Override
  public String toString() {
    return "Employee{" +
            "no=" + no +
        ", name='" + name + '\'' +
        ", email='" + email + '\'' +
        ", tel='" + tel + '\'' +
        ", jumin='" + jumin + '\'' +
        ", joinDate='" + joinDate + '\'' +
        ", addr='" + addr + '\'' +
        ", depm=" + depm +
        '}';
  }


  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getTel() {
    return tel;
  }

  public void setTel(String tel) {
    this.tel = tel;
  }

  public String getJumin() {
    return jumin;
  }

  public void setJumin(String jumin) {
    this.jumin = jumin;
  }

  public String getJoinDate() {
    return joinDate;
  }

  public void setJoinDate(String joinDate) {
    this.joinDate = joinDate;
  }

  public String getAddr() {
    return addr;
  }

  public void setAddr(String addr) {
    this.addr = addr;
  }

  public String getDepm() {
    return depm;
  }

  public void setDepm(String depm) {
    this.depm = depm;
  }
}
