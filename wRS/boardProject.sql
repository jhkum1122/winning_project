drop table board;
create table board(
	b_num NUMBER not null primary key , --게시판 글 번호
	b_writer varchar2(10) not null, -- 작성자 (회원 아이디)
	b_subject varchar2(50) not null,-- 글제목
	b_image varchar2(50),--사용자의 이미지
	b_content varchar2(4000) not null, -- 글 내용
	b_reg_date timestamp(6) not null,--작성일
	readcount NUMBER default 0,--조회수
	ref NUMBER not null,-- 글 그룹 번호
	re_step NUMBER not null, -- 같은 그룹에서 글 출력 순서
	re_level NUMBER not null, -- 답글 레벨
	i_id varchar2(30), -- item_id
	m_id varchar2(30) -- member_id
);
drop Sequence board_seq;

CREATE SEQUENCE board_seq start with 1 increment by 1 nocache;