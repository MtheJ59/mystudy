// JDBC 프로그래밍 - DBMS에 연결하기
package com.eomcs.jdbc.ex1;

import java.sql.DriverManager;

public class Exam0211 {

  public static void main(String[] args) throws Exception {
    // close() 호출의 중요성
    int count = 0;
    while (true) {
      java.sql.Connection con = null;

      try {

        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studydb", // jdbcURL
            "study", // username
            "Bitcamp!@#123" // password
        );

        System.out.println("DBMS와 연결됨!");

        System.out.println(con.getClass().getName());

        System.out.println(++count);

      } finally {
        try {
          // close()를 호출하지 않으면,
          // 서버쪽에서는 일정기간 (timeout) 동안 커넥션을 유지한다.
          // con.close();
        } catch (Exception e) {
          // 연결 해제하다가 발생된 예외는 무시한다.
          // 왜? 이런 오류는 애플리케이션에서 처리할 방법이 없다.
          // 처리할 필요도 없다.
        }
        System.out.println("DBMS와 연결 해제됨!");
      }

    }
  }
}


