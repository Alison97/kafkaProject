/*==============================================================*/
/* DBMS name:      PostgreSQL 8                                 */
/* Created on:     7/04/2022 10:52:03 p. m.                     */
/*==============================================================*/




/*==============================================================*/
/* Table: CLIENT                                                */
/*==============================================================*/
create table if not exists CLIENT (
   CLIENT_ID			VARCHAR(250)		 not null,	
   NAME                 VARCHAR(50)          not null,
   LASTNAME             VARCHAR(50)          not null,
   PASSWORD             VARCHAR(250)         not null,
   EMAIL                VARCHAR(250)         not null,
   constraint PK_CLIENT primary key (CLIENT_ID)
);

