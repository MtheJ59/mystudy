package com.eomcs.oop.ex02.step16;

public class Score {

  String name;
  int kor;
  int eng;
  int math;
  int sum;
  float aver;

  public void compute() {
    this.sum = this.kor + this.eng + this.math;
    this.aver = this.sum / 3f;
  }
}


