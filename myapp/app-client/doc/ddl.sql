-- DDL(Data Definition Language)
-- database --> table --> boards , assignment , member

create table boards(
  board_no int primary key auto_increment,
  title varchar(255) not null,
  content text not null,
  writer varchar(30) not null,
  created_date datetime null default now()
);

insert into boards(title,content,writer) values('제목1', '내용1', '홍길동');
insert into boards(title,content,writer) values('제목2', '내용2', '임꺽정');
insert into boards(title,content,writer) values('제목3', '내용3', '이순신');
insert into boards(title,content,writer) values('제목4', '내용4', '세종대왕');
insert into boards(title,content,writer) values('제목5', '내용5', '은비까비');

select * from boards;