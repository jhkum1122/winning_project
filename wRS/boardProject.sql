drop table board;
create table board(
	b_num NUMBER not null primary key , --�Խ��� �� ��ȣ
	b_writer varchar2(10) not null, -- �ۼ��� (ȸ�� ���̵�)
	b_subject varchar2(50) not null,-- ������
	b_image varchar2(50),--������� �̹���
	b_content varchar2(4000) not null, -- �� ����
	b_reg_date timestamp(6) not null,--�ۼ���
	readcount NUMBER default 0,--��ȸ��
	ref NUMBER not null,-- �� �׷� ��ȣ
	re_step NUMBER not null, -- ���� �׷쿡�� �� ��� ����
	re_level NUMBER not null, -- ��� ����
	i_id varchar2(30), -- item_id
	m_id varchar2(30) -- member_id
);
drop Sequence board_seq;

CREATE SEQUENCE board_seq start with 1 increment by 1 nocache;