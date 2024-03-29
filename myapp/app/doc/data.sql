-- members 테이블 데이터
insert into members(member_no,email,name,password,created_date)
  values(101,'user1@test.com','user1',sha2('1111',256),'2024-1-1');
insert into members(member_no,email,name,password,created_date)
  values(102,'user2@test.com','user2',sha2('1111',256),'2024-2-2');
insert into members(member_no,email,name,password,created_date)
  values(103,'user3@test.com','user3',sha2('1111',256),'2024-3-3');
insert into members(member_no,email,name,password,created_date)
  values(104,'user4@test.com','user4',sha2('1111',256),'2024-4-4');
insert into members(member_no,email,name,password,created_date)
  values(105,'user5@test.com','user5',sha2('1111',256),'2024-5-5');

-- boards 테이블 데이터
insert into boards(board_no,title,content,writer,category)
  values(1, '제목1','내용1',101, 1);
insert into boards(board_no,title,content,writer,category)
  values(2, '제목2','내용2',102, 1);
insert into boards(board_no,title,content,writer,category)
  values(3, '제목3','내용3',102, 2);
insert into boards(board_no,title,content,writer,category)
  values(4, '제목4','내용4',104, 2);
insert into boards(board_no,title,content,writer,category)
  values(5, '제목5','내용5',104, 2);
  insert into boards(board_no,title,content,writer,category)
  values(6, '제목6','내용6',101, 1);
insert into boards(board_no,title,content,writer,category)
  values(7, '제목7','내용7',102, 1);
insert into boards(board_no,title,content,writer,category)
  values(8, '제목8','내용8',102, 2);
insert into boards(board_no,title,content,writer,category)
  values(9, '제목9','내용9',104, 2);
insert into boards(board_no,title,content,writer,category)
  values(10, '제목10','내용10',104, 2);
  insert into boards(board_no,title,content,writer,category)
  values(11, '제목11','내용11',101, 1);
insert into boards(board_no,title,content,writer,category)
  values(12, '제목12','내용12',102, 1);
insert into boards(board_no,title,content,writer,category)
  values(13, '제목13','내용13',102, 2);
insert into boards(board_no,title,content,writer,category)
  values(14, '제목14','내용14',104, 2);
insert into boards(board_no,title,content,writer,category)
  values(15, '제목15','내용15',104, 2);
  insert into boards(board_no,title,content,writer,category)
  values(16, '제목16','내용16',101, 1);
insert into boards(board_no,title,content,writer,category)
  values(17, '제목17','내용17',102, 1);
insert into boards(board_no,title,content,writer,category)
  values(18, '제목18','내용18',102, 2);
insert into boards(board_no,title,content,writer,category)
  values(19, '제목19','내용19',104, 2);
insert into boards(board_no,title,content,writer,category)
  values(20, '제목20','내용20',104, 2);
  insert into boards(board_no,title,content,writer,category)
  values(21, '제목21','내용21',101, 1);
insert into boards(board_no,title,content,writer,category)
  values(22, '제목22','내용22',102, 1);
insert into boards(board_no,title,content,writer,category)
  values(23, '제목23','내용23',102, 2);
insert into boards(board_no,title,content,writer,category)
  values(24, '제목24','내용24',104, 2);
insert into boards(board_no,title,content,writer,category)
  values(25, '제목25','내용25',104, 2);

-- board_files 테이블 데이터
insert into board_files(file_no,file_path,board_no) values
  (1,'a1.gif', 1), (2,'a2.gif', 1), (3,'a3.gif', 1),
  (4,'b1.gif', 2), (5,'b2.gif', 2),
  (6,'c1.gif', 4), (7,'c2.gif', 4), (8,'c3.gif', 4), (9,'c4.gif', 4),
  (10,'d1.gif', 5);



-- assignments 테이블 데이터
insert into assignments(assignment_no,title,content,deadline)
  values(1,'과제1','내용1','2024-1-1');
insert into assignments(assignment_no,title,content,deadline)
  values(2,'과제2','내용2','2024-2-2');
insert into assignments(assignment_no,title,content,deadline)
  values(3,'과제3','내용3','2024-3-3');
insert into assignments(assignment_no,title,content,deadline)
  values(4,'과제4','내용4','2024-4-4');
insert into assignments(assignment_no,title,content,deadline)
  values(5,'과제5','내용5','2024-5-5');
  insert into assignments(assignment_no,title,content,deadline)
  values(6,'과제6','내용6','2024-6-6');
  insert into assignments(assignment_no,title,content,deadline)
  values(7,'과제7','내용7','2024-7-7');
  insert into assignments(assignment_no,title,content,deadline)
  values(8,'과제8','내용8','2024-8-8');
  insert into assignments(assignment_no,title,content,deadline)
  values(9,'과제9','내용9','2024-9-9');
  insert into assignments(assignment_no,title,content,deadline)
  values(10,'과제10','내용10','2024-10-10');


