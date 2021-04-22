
-- ��ü ���̺� ���� ������
--SELECT 'DROP TABLE "' || TABLE_NAME || '" CASCADE CONSTRAINTS;' FROM USER_TABLES;
--
DROP TABLE "PROFESSOR" CASCADE CONSTRAINTS;
DROP TABLE "LECTURE" CASCADE CONSTRAINTS;
DROP TABLE "DNOTICE" CASCADE CONSTRAINTS;
DROP TABLE "POST" CASCADE CONSTRAINTS;
DROP TABLE "STUDENT" CASCADE CONSTRAINTS;
DROP TABLE "GRADE" CASCADE CONSTRAINTS;
DROP TABLE "POST_COMMENT" CASCADE CONSTRAINTS;
DROP TABLE "DNOTICEFILE" CASCADE CONSTRAINTS;
DROP TABLE "POST_IMAGE" CASCADE CONSTRAINTS;
DROP TABLE "FRIENDS" CASCADE CONSTRAINTS;
DROP TABLE "STUDY" CASCADE CONSTRAINTS;
DROP TABLE "ACTIVITY" CASCADE CONSTRAINTS;
DROP TABLE "LECTUREENROLL" CASCADE CONSTRAINTS;
DROP TABLE "CONSULTING" CASCADE CONSTRAINTS;
DROP TABLE "STUDY_FILE" CASCADE CONSTRAINTS;
DROP TABLE "EVALUATION" CASCADE CONSTRAINTS;
DROP TABLE "ALARM" CASCADE CONSTRAINTS;
DROP TABLE "LECTURESYLLABUS" CASCADE CONSTRAINTS;
DROP TABLE "CHATROOM" CASCADE CONSTRAINTS;
DROP TABLE "DNOTICEFILE" CASCADE CONSTRAINTS;
DROP TABLE "STUDY_FOLDER" CASCADE CONSTRAINTS;
DROP TABLE "TIMETABLE" CASCADE CONSTRAINTS;
-- DROP SEQUENCE �ʿ��� �κи� -- 
DROP SEQUENCE POST_NO_SEQ;
DROP SEQUENCE MENT_NO_SEQ;
DROP SEQUENCE POST_IMG_NO_SEQ;
DROP SEQUENCE A_NO_SEQ;
DROP SEQUENCE F_NO_SEQ;

-- ���� --
DROP SEQUENCE STUDY_NO_SEQ;
DROP SEQUENCE FILE_NO_SEQ;
DROP SEQUENCE FOLDER_NO_SEQ;

--�л���� ����--
DROP SEQUENCE DN_NO_SEQ;
DROP SEQUENCE C_NO_SEQ;
DROP SEQUENCE ACT_NO;
DROP SEQUENCE DFILE_NO_SEQ;

--������ ����
CREATE SEQUENCE POST_NO_SEQ;
CREATE SEQUENCE MENT_NO_SEQ;
CREATE SEQUENCE MENT_DEPTH_SEQ;
CREATE SEQUENCE POST_IMG_NO_SEQ;
CREATE SEQUENCE A_NO_SEQ;
CREATE SEQUENCE F_NO_SEQ;
-- ���� --
CREATE SEQUENCE STUDY_NO_SEQ;
CREATE SEQUENCE FILE_NO_SEQ;
CREATE SEQUENCE FOLDER_NO_SEQ;

--�л���� ����--
CREATE SEQUENCE DN_NO_SEQ;
CREATE SEQUENCE DFILE_NO_SEQ;
CREATE SEQUENCE C_NO_SEQ;
CREATE SEQUENCE ACT_NO;

CREATE TABLE "PROFESSOR" (
   "P_NO"   NUMBER   NULL,
   "P_PASSWORD" VARCHAR2(30) NULL,
   "P_DEPT"   VARCHAR2(30)   NULL,
   "P_NAME"   VARCHAR2(30)   NULL,
   "P_PHONE"   VARCHAR2(30)   NULL,
   "P_ADDRESS"   VARCHAR2(30)   NULL,
   "P_EMAIL"   VARCHAR2(30)   NULL,
   "P_FILE"   VARCHAR2(300)   NULL
);

CREATE TABLE "LECTURE" (
   "L_CODE"   NUMBER   NOT NULL,
   "P_NO"   NUMBER   NOT NULL,
   "L_DAY1" VARCHAR2(20) NULL,
   "L_STARTTIME1" NUMBER NULL,
   "L_ENDTIME1" NUMBER NULL,
   "L_DAY2" VARCHAR2(20) NULL,
   "L_STARTTIME2" NUMBER NULL,
   "L_ENDTIME2" NUMBER NULL,
   "L_NAME"   VARCHAR2(30)   NULL,
   "L_PNAME"   VARCHAR2(30)   NULL,
   "L_NUMBERSTUDENT"   NUMBER   NULL,
   "L_ROOM"   VARCHAR2(300)   NULL,
   "L_CLASSIFY"   VARCHAR2(30)   NULL,
   "L_POINT"   NUMBER   NULL,
   "L_ SEMESTER"   VARCHAR2(20)   NULL
);
CREATE TABLE "DNOTICE" (
   "DN_NO"   NUMBER   NOT NULL,
   "P_NO"   NUMBER   NOT NULL,
   "P_NAME" VARCHAR2(30) NOT NULL,
   "DN_TITLE"   VARCHAR2(200)   NULL,
   "DN_DATE"   DATE   NULL,
   "DN_CONTENT"   VARCHAR2(4000)   NULL
);

CREATE TABLE "POST" (
   "POST_NO"   NUMBER   NOT NULL,
   "POST_KINDS"   VARCHAR2(80)   NOT NULL,
   "POST_CATEGORY"   VARCHAR2(80)   NULL,
   "POST_WRITER_S_NO"   NUMBER   NOT NULL,
   "POST_SUBJECT"   VARCHAR2(200)   NOT NULL,
   "POST_CONTENT"   VARCHAR2(4000)   NOT NULL,
   "POST_REGDATE"   DATE   NOT NULL,
   "STUDY_NO"   NUMBER   NULL,
   "POST_WRITER_S_NAME"   VARCHAR2(60)    NOT NULL,
    "FILEPATH" VARCHAR2(300) NULL
);

CREATE TABLE "STUDENT" (
   "S_NO"   NUMBER   NULL,
   "S_PASSWORD" VARCHAR2(40) NULL,
   "S_DEPT"   VARCHAR2(30)   NULL,
   "S_NAME"   VARCHAR2(30)   NULL,
   "S_PHONE"   VARCHAR2(30)   NULL,
   "S_ADDRESS"   VARCHAR2(30)   NULL,
   "S_EMAIL"   VARCHAR2(20)   NULL,
   "S_GRADE"   NUMBER   NULL,
   "S_FILE"   VARCHAR2(300)   NULL,
   "STUDY_NO"   NUMBER  NULL,
   "P_NO"   NUMBER   NULL
);

CREATE TABLE "GRADE" (
   "S_NO"   NUMBER   NOT NULL,
   "S_DEPT"   VARCHAR2(30)   NULL,
   "S_NAME"   VARCHAR2(30)   NULL,
   "L_CODE"   NUMBER   NULL,
   "L_NAME"   VARCHAR2(30)   NULL,
   "S_SEMESTER"   NUMBER   NULL,
   "S_RATE"   VARCHAR2(10)   NULL,
   "S_GRADEYEAR"   NUMBER   NULL
);

CREATE TABLE "POST_COMMENT" (
   "MENT_NO"   NUMBER   NOT NULL,
   "POST_NO"   NUMBER   NOT NULL,
   "MENT_WRITER"   VARCHAR2(50)   NOT NULL,
   "MENT_CONTENT"   VARCHAR2(1000)   NOT NULL,
   "MENT_REGDATE"   DATE   NOT NULL,
   "MENT_DEPTH"   NUMBER   NOT NULL,
   "MENT_FILE_PATH"   VARCHAR2(300)  NULL
);

CREATE TABLE "DNOTICEFILE" (
   "DFILE_NO"   NUMBER   NOT NULL,
   "DN_NO"   NUMBER   NOT NULL,
   "DNF_NAME"   VARCHAR2(300)   NULL,
   "DNF_ROOT"   VARCHAR2(300)   NULL,
   "DNF_CDATE"   DATE   NULL
);

CREATE TABLE "POST_IMAGE" (
   "POST_IMG_NO"   NUMBER   NOT NULL,
   "POST_IMG_NAME"   VARCHAR2(300)   NOT NULL,
   "POST_IMG_ROOT"   VARCHAR2(300)   NOT NULL,
   "POST_IMG_UPLOAD_TIME"   DATE   NOT NULL,
   "POST_NO"   NUMBER   NOT NULL
);

CREATE TABLE "FRIENDS" (
   "F_NO"   NUMBER   NOT NULL,
   "S_NO"   NUMBER NOT NULL,
   "L_NO"   VARCHAR2(30)   NOT NULL,
   "F_MESSAGE"   VARCHAR2(10)   NOT NULL
);
-- ���� --
CREATE TABLE "STUDY" (
   "STUDY_NO"   NUMBER   NOT NULL,
   "STUDY_NAME"   VARCHAR(50)  NOT  NULL,
   "STUDY_MANAGER"   NUMBER   NULL
);

CREATE TABLE "ACTIVITY" (
   "ACT_NO"   NUMBER   NOT NULL,
   "S_NO"   NUMBER   NOT NULL,
   "ACT_DATE"   DATE   NULL,
   "ACT_TITLE"   VARCHAR2(200)   NULL,
   "ACT_CONTENT"   VARCHAR2(4000)   NULL,
   "ACT_PHOTO"   VARCHAR2(100)   NULL
);

CREATE TABLE "LECTUREENROLL" (
   "L_CODE"   NUMBER   NOT NULL,
   "S_NO"   NUMBER   NOT NULL,
   "S_RATE" VARCHAR2(30) NULL
);

CREATE TABLE "CONSULTING" (
   "C_NO"   NUMBER   NOT NULL,
   "P_NO"   NUMBER   NOT NULL,
   "S_NO"   NUMBER   NOT NULL,
   "S_NAME" VARCHAR2(50) NULL,
   "S_GRADE" NUMBER NULL,
   "C_TITLE"   VARCHAR2(100)   NULL,
   "C_CONTENT"   VARCHAR2(4000)   NULL,
   "C_ANSWER"   VARCHAR2(4000)   NULL,
   "C_DATE"   DATE   NULL,
   "FLAG"  NUMBER DEFAULT 0
);
-- ���� --
CREATE TABLE "STUDY_FILE" (
   "FILE_NO"   NUMBER   NOT NULL,
   "STUDY_NO"   NUMBER   NOT NULL,
   "FILE_NAME"   VARCHAR2(300)   NOT NULL,
   "FILE_PATH"   VARCHAR2(300)   NULL,
   "FILE_UPLOAD_TIME"   DATE   NULL,
   "FOLDER_NO"   NUMBER   NOT NULL,
   "FILE_REGISTRANT" VARCHAR2(20) NOT NULL
);

CREATE TABLE "EVALUATION" (
   "S_NO"   NUMBER   NOT NULL,
   "L_CODE"   NUMBER   NOT NULL,
   "E_RATE"   NUMBER   NULL,
   "E_CONTENT"   VARCHAR2(4000)   NULL,
   "E_DATE"   DATE   NULL
);

CREATE TABLE "ALARM" (
   "A_NO"   NUMBER   NOT NULL,
   "A_CONTENT"   VARCHAR2(4000)   NOT NULL,
   "A_UPLOAD_TIME"   VARCHAR2(100)   NOT NULL,
   "L_NO"   VARCHAR2(30)   NOT NULL
);

CREATE TABLE "LECTURESYLLABUS" (
   "L_CODE"   NUMBER   NOT NULL,
   "LS_GOAL"   VARCHAR2(1000)   NULL,
   "LS_CONTENT"   VARCHAR2(1000)   NULL,
   "LS_BOOK"   VARCHAR2(1000)   NULL,
   "LS_DATE"   VARCHAR2(1000)   NULL
);
-- ���� --
CREATE TABLE "CHATROOM" (
   "CROOM_S_NO"   NUMBER   NOT NULL,
   "CROOM_NO"   NUMBER NOT NULL,
   "CROOM_S_NAME"   VARCHAR(30) NOT NULL,
   "CROOM_S_IMAGE"   VARCHAR(20)   NULL
);
-- ���� --
CREATE TABLE "STUDY_FOLDER" (
   "FOLDER_NO"   NUMBER   NOT NULL,
   "STUDY_NO"   NUMBER   NOT NULL,
   "FOLDER_NAME"   VARCHAR2(40)  NOT  NULL,
   "PARENT_FOLDER_NO"   NUMBER   NOT NULL
);

-- ���� --
CREATE TABLE "TIMETABLE" (
   "S_NO"   NUMBER NULL,
   "P_NO"   NUMBER NULL,
   "MON1"   VARCHAR2(30)   NULL,
   "MON2"   VARCHAR2(30)   NULL,
   "MON3"   VARCHAR2(30)   NULL,
   "MON4"   VARCHAR2(30)   NULL,
   "MON5"   VARCHAR2(30)   NULL,
   "MON6"   VARCHAR2(30)   NULL,
   "MON7"   VARCHAR2(30)   NULL,
   "TUE1"   VARCHAR2(30)   NULL,
   "TUE2"   VARCHAR2(30)   NULL,
   "TUE3"   VARCHAR2(30)   NULL,
   "TUE4"   VARCHAR2(30)   NULL,
   "TUE5"   VARCHAR2(30)   NULL,
   "TUE6"   VARCHAR2(30)   NULL,
   "TUE7"   VARCHAR2(30)   NULL,
   "WED1"   VARCHAR2(30)   NULL,
   "WED2"   VARCHAR2(30)   NULL,
   "WED3"   VARCHAR2(30)   NULL,
   "WED4"   VARCHAR2(30)   NULL,
   "WED5"   VARCHAR2(30)   NULL,
   "WED6"   VARCHAR2(30)   NULL,
   "WED7"   VARCHAR2(30)   NULL,
   "TUR1"   VARCHAR2(30)   NULL,
   "TUR2"   VARCHAR2(30)   NULL,
   "TUR3"   VARCHAR2(30)   NULL,
   "TUR4"   VARCHAR2(30)   NULL,
   "TUR5"   VARCHAR2(30)   NULL,
   "TUR6"   VARCHAR2(30)   NULL,
   "TUR7"   VARCHAR2(30)   NULL,
   "FRI1"   VARCHAR2(30)   NULL,
   "FRI2"   VARCHAR2(30)   NULL,
   "FRI3"   VARCHAR2(30)   NULL,
   "FRI4"   VARCHAR2(30)   NULL,
   "FRI5"   VARCHAR2(30)   NULL,
   "FRI6"   VARCHAR2(30)   NULL,
   "FRI7"   VARCHAR2(30)   NULL
);

ALTER TABLE "PROFESSOR" ADD CONSTRAINT "PK_PROFESSOR" PRIMARY KEY (
   "P_NO"
);

ALTER TABLE "LECTURE" ADD CONSTRAINT "PK_LECTURE" PRIMARY KEY (
   "L_CODE"
);

ALTER TABLE "DNOTICE" ADD CONSTRAINT "PK_DNOTICE" PRIMARY KEY (
   "DN_NO"
);

ALTER TABLE "POST" ADD CONSTRAINT "PK_POST" PRIMARY KEY (
   "POST_NO"
);

ALTER TABLE "STUDENT" ADD CONSTRAINT "PK_STUDENT" PRIMARY KEY (
   "S_NO"
);

ALTER TABLE "POST_COMMENT" ADD CONSTRAINT "PK_POST_COMMENT" PRIMARY KEY (
   "MENT_NO",
   "POST_NO"
);

ALTER TABLE "DNOTICEFILE" ADD CONSTRAINT "PK_DNOTICEFILE" PRIMARY KEY (
   "DFILE_NO"
);

ALTER TABLE "POST_IMAGE" ADD CONSTRAINT "PK_POST_IMAGE" PRIMARY KEY (
   "POST_IMG_NO",
    "POST_NO"
);

ALTER TABLE "FRIENDS" ADD CONSTRAINT "PK_FRIENDS" PRIMARY KEY (
   "F_NO",
   "S_NO"
);

ALTER TABLE "STUDY" ADD CONSTRAINT "PK_STUDY" PRIMARY KEY (
   "STUDY_NO"
);

ALTER TABLE "ACTIVITY" ADD CONSTRAINT "PK_ACTIVITY" PRIMARY KEY (
   "ACT_NO"
);

ALTER TABLE "LECTUREENROLL" ADD CONSTRAINT "PK_LECTUREENROLL" PRIMARY KEY (
   "L_CODE",
   "S_NO"
);

ALTER TABLE "CONSULTING" ADD CONSTRAINT "PK_CONSULTING" PRIMARY KEY (
   "C_NO"
);

ALTER TABLE "STUDY_FILE" ADD CONSTRAINT "PK_STUDY_FILE" PRIMARY KEY (
   "FILE_NO",
   "STUDY_NO"
);

ALTER TABLE "EVALUATION" ADD CONSTRAINT "PK_EVALUATION" PRIMARY KEY (
   "S_NO",
   "L_CODE"
);

ALTER TABLE "ALARM" ADD CONSTRAINT "PK_ALARM" PRIMARY KEY (
   "A_NO"
);

ALTER TABLE "LECTURESYLLABUS" ADD CONSTRAINT "PK_LECTURESYLLABUS" PRIMARY KEY (
   "L_CODE"
);

ALTER TABLE "CHATROOM" ADD CONSTRAINT "PK_CHATROOM" PRIMARY KEY (
   "CROOM_S_NO"
);

ALTER TABLE "STUDY_FOLDER" ADD CONSTRAINT "PK_STUDY_FOLDER" PRIMARY KEY (
   "FOLDER_NO"
);

ALTER TABLE "LECTURE" ADD CONSTRAINT "FK_PROFESSOR_TO_LECTURE_1" FOREIGN KEY (
   "P_NO"
)
REFERENCES "PROFESSOR" (
   "P_NO"
);

ALTER TABLE "DNOTICE" ADD CONSTRAINT "FK_PROFESSOR_TO_DNOTICE_1" FOREIGN KEY (
   "P_NO"
)
REFERENCES "PROFESSOR" (
   "P_NO"
);
--����--
ALTER TABLE "POST" ADD CONSTRAINT "FK_STUDY_TO_POST_1" FOREIGN KEY(
   "STUDY_NO"
)
REFERENCES "STUDY" (
   "STUDY_NO"
) ON DELETE CASCADE;

ALTER TABLE "STUDENT" ADD CONSTRAINT "FK_STUDY_TO_STUDENT_1" FOREIGN KEY (
   "STUDY_NO"
)
REFERENCES "STUDY" (
   "STUDY_NO"
) ;

ALTER TABLE "STUDENT" ADD CONSTRAINT "FK_PROFESSOR_TO_STUDENT_1" FOREIGN KEY (
   "P_NO"
)
REFERENCES "PROFESSOR" (
   "P_NO"
);

ALTER TABLE "GRADE" ADD CONSTRAINT "FK_STUDENT_TO_GRADE_1" FOREIGN KEY (
   "S_NO"
)
REFERENCES "STUDENT" (
   "S_NO"
);

ALTER TABLE "POST_COMMENT" ADD CONSTRAINT "FK_POST_TO_POST_COMMENT_1" FOREIGN KEY (
   "POST_NO"
)
REFERENCES "POST" (
   "POST_NO"
)on delete cascade;

ALTER TABLE "DNOTICEFILE" ADD CONSTRAINT "FK_DNOTICE_TO_DNOTICEFILE_1" FOREIGN KEY (
   "DN_NO"
)
REFERENCES "DNOTICE" (
   "DN_NO"
)ON DELETE CASCADE;

ALTER TABLE "POST_IMAGE" ADD CONSTRAINT "FK_POST_TO_POST_IMAGE_1" FOREIGN KEY (
   "POST_NO"
)
REFERENCES "POST" (
   "POST_NO"
);

ALTER TABLE "FRIENDS" ADD CONSTRAINT "FK_STUDENT_TO_FRIENDS_1" FOREIGN KEY (
   "S_NO"
)
REFERENCES "STUDENT" (
   "S_NO"
);

ALTER TABLE "ACTIVITY" ADD CONSTRAINT "FK_STUDENT_TO_ACTIVITY_1" FOREIGN KEY (
   "S_NO"
)
REFERENCES "STUDENT" (
   "S_NO"
);



ALTER TABLE "LECTUREENROLL" ADD CONSTRAINT "FK_LECTURE_TO_LECTUREENROLL_1" FOREIGN KEY (
   "L_CODE"
)
REFERENCES "LECTURE" (
   "L_CODE"
)ON DELETE CASCADE;

ALTER TABLE "LECTUREENROLL" ADD CONSTRAINT "FK_STUDENT_TO_LECTUREENROLL_1" FOREIGN KEY (
   "S_NO"
)
REFERENCES "STUDENT" (
   "S_NO"
);

ALTER TABLE "CONSULTING" ADD CONSTRAINT "FK_PROFESSOR_TO_CONSULTING_1" FOREIGN KEY (
   "P_NO"
)
REFERENCES "PROFESSOR" (
   "P_NO"
);

ALTER TABLE "CONSULTING" ADD CONSTRAINT "FK_STUDENT_TO_CONSULTING_1" FOREIGN KEY (
   "S_NO"
)
REFERENCES "STUDENT" (
   "S_NO"
);
-- ���� --
ALTER TABLE "STUDY_FILE" ADD CONSTRAINT "FK_STUDY_TO_STUDY_FILE_1" FOREIGN KEY (
   "STUDY_NO"
)

REFERENCES "STUDY" (
   "STUDY_NO"
) ON DELETE CASCADE;
-- ���� --
ALTER TABLE "STUDY_FILE" ADD CONSTRAINT "FK_FOLDER_TO_FILE_1" FOREIGN KEY (
   "FOLDER_NO"
)
REFERENCES "STUDY_FOLDER" (
   "FOLDER_NO"
) ON DELETE CASCADE;

ALTER TABLE "EVALUATION" ADD CONSTRAINT "FK_STUDENT_TO_EVALUATION_1" FOREIGN KEY (
   "S_NO"
)
REFERENCES "STUDENT" (
   "S_NO"
);

ALTER TABLE "EVALUATION" ADD CONSTRAINT "FK_LECTURE_TO_EVALUATION_1" FOREIGN KEY (
   "L_CODE"
)
REFERENCES "LECTURE" (
   "L_CODE"
)ON DELETE CASCADE;

ALTER TABLE "LECTURESYLLABUS" ADD CONSTRAINT "FK_LECTURE_TO_LPLANE" FOREIGN KEY (
   "L_CODE"
)
REFERENCES "LECTURE" (
   "L_CODE"
)ON DELETE CASCADE;
-- ���� --
ALTER TABLE "STUDY_FOLDER" ADD CONSTRAINT "FK_STUDY_TO_FOLDER_1" FOREIGN KEY (
   "STUDY_NO"
)
REFERENCES "STUDY" (
   "STUDY_NO"
) ON DELETE CASCADE;
-- ���� --
ALTER TABLE "STUDY_FOLDER" ADD CONSTRAINT "FK_FOLDER_TO_FOLDER_1" FOREIGN KEY (
   "PARENT_FOLDER_NO"
)
REFERENCES "STUDY_FOLDER" (
   "FOLDER_NO"
) ON DELETE CASCADE;

COMMIT;
--�׽�Ʈ������
insert into PROFESSOR values (1,'1','��ǻ�Ͱ���','����','010-0000-0000','�ּ�','p1@naver.com',null);
insert into PROFESSOR values (2,'1','��ǻ�Ͱ���','����','010-0000-0000','�ּ�','p1@naver.com',null);
insert into study values(0,'�׽�Ʈ ���͵�',1);
insert into study values(1,'�׽�Ʈ ���͵�',1);
insert into study values(2,'�׽�Ʈ ���͵�',2);
insert into STUDENT values (1,'1','��ǻ�Ͱ���','�̽¿�','010-0000-0000','�ּ�','s1@naver.com',4,'sw.jpg',1,1);
insert into STUDENT values (2,'1','��ǻ�Ͱ���','�۹���','010-0000-0000','�ּ�','s2@naver.com',4,'bj.jpg',1,1);
insert into STUDENT values (3,'1','��ǻ�Ͱ���','������','010-0000-0000','�ּ�','s3@naver.com',4,'uj.jpg',1,1);
insert into STUDENT values (4,'1','��ǻ�Ͱ���','������','010-0000-0000','�ּ�','s4@naver.com',4,'js.jpg',2,1);
insert into STUDENT values (5,'1','��ǻ�Ͱ���','������','010-0000-0000','�ּ�','s4@naver.com',4,'js.jpg',0,1);
insert into STUDENT values (6,'1','��ǻ�Ͱ���','������','010-0000-0000','�ּ�','s4@naver.com',4,'js.jpg',0,1);
insert into LECTURE VALUES(1111, 1, '��',1,2,'��',3,4,'�ڹ�', '�κ���',30,'���а�101','����', 3, '2020-01');
insert into LECTURE VALUES(1112, 2, '��',3,4,'��',1,2,'CSS', '�̽¿�',30,'���а�102','����', 3, '2020-01');
insert into LECTURE VALUES(1113, 1, '��',1,2,'��',5,6,'�Ƶ��̳�', '�̽¿�',30,'���а�102','����', 3, '2020-01');
insert into LECTURE VALUES(1114, 1, 'ȭ',1,2,'��',1,2,'���������', '�̽¿�',30,'���а�102','����', 3, '2020-01');
insert into LECTURE VALUES(1115, 1, '��',5,6,'��',3,4,'���ڰ���', '�̽¿�',30,'���а�102','����', 3, '2020-01');
insert into timetable (s_no) values(1);
insert into timetable (s_no) values(2);
insert into timetable (s_no) values(3);
insert into timetable (s_no) values(4);
insert into timetable (s_no) values(5);
insert into timetable (s_no) values(6);
insert into LECTURESYLLABUS values(1111, '1', '1', '1', sysdate);
insert into LECTURESYLLABUS values(1112, '2', '2', '2', sysdate);
insert into LECTURESYLLABUS values(1113, '3', '3', '3', sysdate);
insert into LECTURESYLLABUS values(1114, '4', '4', '4', sysdate);
insert into LECTURESYLLABUS values(1115, '5', '5', '5', sysdate);
COMMIT;

update student set study_no = (select max(study_no) from study) where s_no=5;
select study_no_seq.nextval from dual;
select MENT_DEPTH_SEQ.NEXTVAL from dual;
select * from study;
select * from post_comment;
delete from study;
select * from student;
select * from chatRoom;
delete from chatRoom;
select * from post_image;
select * from POST;
delete from post where post_no=41;
select * from STUDY_FILE;
select to_char(sysdate,'YY/MM/DD') from dual;
select *
		from student s left join post p on (s.s_no = p.post_writer_s_no);
select *
		from student s left join post p on (s.s_no = p.post_writer_s_no)
		where s.study_no = 1
		and to_char(post_regdate,'YY/MM/DD')=to_char(sysdate,'YY/MM/DD');
select * from post where to_char(post_regdate,'YY/MM/DD')=to_char(sysdate,'YY/MM/DD');
update student set study_no = (select max(study_no) from study) where s_no=5;
SELECT * FROM POST_COMMENT 
		WHERE MENT_NO = (select max(MENT_NO) from post_comment)