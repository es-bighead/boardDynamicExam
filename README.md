# boardDynamicExam
게시판 만들기

# 테이블스페이스 별도 생성
create tablespace exam datafile '/app/oracle/oradata/exam/exam.dbf' size 300m reuse autoextend on next 1024k maxsize unlimited;

# ORACLE 계정 생성
create user exam identified by exam default tablespace exam;

# EXAM 계정에 권한 부여
GRANT CREATE ANY TABLE TO exam;
GRANT CONNECT, RESOURCE TO exam;

# 테이블스페이스 권한 부여
alter user exam default tablespace EXAM quota unlimited on users;

