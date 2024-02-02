-- DDL(Data Definition Language)
-- database --> table --> boards , assignment , member

drop table ramb;

create table lambs(
  lamb_no int primary key,
  title varchar(50) unique key not null,
  content text not null,
  cooks varchar(20) not null,
  price varchar(20) not null
);

insert into lambs(lamb_no,title, content, cooks, price)
  values(1, 'lamb sand', '같이 준비된 레몬을 짜서 한입에 먹는다.', '미디움웰던', '15000원');
insert into lambs(lamb_no,title, content, cooks, price)
  values(2, 'French Rack', '한입 크기로 썰어 가니쉬 + 소스와 함께 먹는다.', '미디움레어', '20000원');
insert into lambs(lamb_no,title, content, cooks, price)
  values(3, 'noir', '초벌한 프렌치렉을 화로에 취향껏 구워 소스와 함께 즐긴다.', '레어', '20000원');
insert into lambs(lamb_no, title, content, cooks, price)
  values(4, 'sirloin', '특제 소스를 발라 담백하게 구워낸 양등심 & 한입 크기의 미니쌈', '웰던', '18000원');

select *
from lambs;

select *
from lambs
where lamb_no = 3;

-- 데이터를 바꾸는 방법

update lambs set
  title='sirloin',
  content='특제 소스를 발라 담백하게 구워낸 양등심 & 한입 크기의 미니쌈',
where lamb_no = 4;


-- 삭제할 때 조건을 상세하게 적지 않으면 그 테이블의 모든 정보가 삭제된다.
delete from lambs where rmab_no=4;


drop table beef;

create table beefs(
  beef_no int primary key auto_increment,
  title varchar(50) not null,
  content text not null,
  created_date datetime null default now()
);

insert into beefs(beef_no, title, content)
  values(1, '소불고기', '야채와 고기가 익으면 쌈이나 밥과 함께 즐긴다.');
insert into beefs(beef_no, title, content)
  values(2, '소등심', '취향에 따라 익혀 먹는다.');
insert into beefs(beef_no, title, content)
  values(3, '비프웰링턴', '통 소고기 파이! 얇게 썰어서 먹어도 두껍게 썰어 먹어도 맛있다.');
insert into beefs(beef_no, title, content)
  values(4, '육회', '노른자를 터트려 어린 채소와 달달한 배와 함께 즐긴다.');


  update beefs set
    title='육회',
    content='노른자를 터트려 어린 채소와 달달한 배와 함께 즐긴다.',
  where beef_no = 4;

  delete from beefs where beef_no=4;


create table cooks (
  cooks_no int primary key auto_increment,
  title varchar(20) not null,
  beef_no int not null
);

alter table cooks
  add constraint cooks_fk foreign key (beef_no) references beefs (beef_no);

insert into cooks (cooks_no, title)
  values (1, '레어');
insert into cooks (cooks_no, title)
  values (2, '미디움레어');
insert into cooks (cooks_no, title)
  values (3, '미디움');
insert into cooks (cooks_no, title)
  values (4, '미디움웰던');
insert into cooks (cooks_no, title)
  values (5, '웰던');