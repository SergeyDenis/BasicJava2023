Очистка схемы :
DROP TABLE SURVEYS_RESULT_HIST;
DROP TABLE SURVEYS_RESULT;
DROP TABLE ANSWERS_HIST;
DROP TABLE ANSWERS_DICT;
DROP TABLE QUESTIONS_HIST;
DROP TABLE QUESTIONS_DICT;
DROP TABLE SURVEYS_HIST;
DROP TABLE SURVEYS_DICT;
DROP TABLE LIBRARYS_HIST; 
DROP TABLE LIBRARYS_DICT;
DROP TABLE USERS;
DROP TABLE STATUS;
-----------------------------------------------------------------------------------------------------------
-- Создание таблицы ФИО опрашиваемых(пользователей)
CREATE TABLE USERS (
user_id        serial       primary key,    -- ID пользователя
user_name      varchar(100) not null,       -- ФИО
user_password  varchar(100) not null        -- Пароль 
);

-- Для тестов 
INSERT INTO USERS (user_name,user_password) VALUES ('USER_1','new password');
INSERT INTO USERS (user_name,user_password) VALUES ('USER_2','new password2');
INSERT INTO USERS (user_name,user_password) VALUES ('USER_3','new password3');
UPDATE USERS SET user_name ='Петров Иван Сидорыч';
DELETE FROM USERS WHERE user_name = 'USER_2';
DELETE FROM USERS WHERE user_name <> 'Петров Иван Сидорыч';

-----------------------------------------------------------------------------------------------------------
-- Создание таблицы Справочник статусов записи
CREATE TABLE STATUS 
(stat_id   smallint     primary key,     -- ID Статуса
 stat_name varchar(100) unique not null  -- Наименование статуса 
 );
 
INSERT INTO STATUS (stat_id,stat_name)
VALUES (1 , 'Открыт' ) , (2 , 'Закрыт');

----------------------------------------------------------------------------------
-- Создание таблицы Справочник Бибилотек опросников 
CREATE TABLE LIBRARYS_DICT 
(lib_id   serial       primary key ,       -- ID  Библиотеки 
 lib_name varchar(100) unique not null     -- Имя Библиотеки
);

INSERT INTO LIBRARYS_DICT (lib_name) VALUES ('Библиотека опросов по ДЗ');

----------------------------------------------------------------------------------
-- Создание таблицы Истории изменений библиотек 
CREATE TABLE LIBRARYS_HIST
(lib_id  integer  not null REFERENCES LIBRARYS_DICT (lib_id), -- ID Библиотеки
 stat_id smallint not null REFERENCES STATUS (stat_id),       -- ID Статус библиотеки 
 stime   date     not null,                                   -- Дата начала истории
 etime   date     not null                                    -- Дата окончания истории
);

INSERT INTO LIBRARYS_HIST (lib_id , stat_id,stime,etime) VALUES (1,1,'2023-01-01','2999-12-31');

---------------------------------------------------------------------------------------------------
-- Создание таблицы  Справочник Опросников
CREATE TABLE SURVEYS_DICT
(surv_id   serial       PRIMARY KEY,      -- ID Опроса
 surv_name varchar(100) unique not null   -- Наименование Опроса 
);

INSERT INTO SURVEYS_DICT (surv_name) VALUES ('Опросник 1 по ДЗ');
-------------------------------------------------------------------------------------------------------
-- Создание таблицы  История изменения списка Опросников
CREATE TABLE SURVEYS_HIST
(surv_id            integer  REFERENCES SURVEYS_DICT (surv_id),   -- ID Опроса
 stat_id            smallint REFERENCES STATUS (stat_id),         -- ID Статуса 
 surv_order         smallint not null,                            -- Порядковый номер Опроса в Библиотеке
 surv_how_much_time integer  not null,                            -- Продолжительность опроса в секундах
 lib_id             integer  REFERENCES LIBRARYS_DICT (lib_id),   -- ID Библиотеки 
 stime              date     not null,                            -- Дата начало истории
 etime              date     not null                             -- Дата окончания истории
); 
 
INSERT INTO SURVEYS_HIST (surv_id,stat_id,surv_order,surv_how_much_time,lib_id,  stime     , etime      )
                  VALUES (   1,      1,        1,         60,            1,    '2023-01-01','2999-12-31');
--------------------------------------------------------------------------------------------------------
-- Создание таблицы Справочник вопросов 
CREATE TABLE QUESTIONS_DICT
(qst_id     serial       primary key,         -- ID Вопроса
 quest_name varchar(100) unique not null      -- Наименование вопроса
);

INSERT INTO QUESTIONS_DICT (quest_name)
VALUES
('Что не относится к языкам программирования ?') ,
('Что такое HTML ?'),
('Продолжите выражение Git это - ?');

----------------------------------------------------------------------------------------------------------
-- Создание таблицы История изменений списка Вопросов
CREATE TABLE QUESTIONS_HIST
(qst_id            integer  REFERENCES QUESTIONS_DICT (qst_id),    -- ID Вопроса
 stat_id           smallint REFERENCES STATUS (stat_id),           -- Статус Вопроса
 qst_order         smallint not null,                              -- Порядковый номер Вопроса в опроснике
 qst_how_much_time integer  not null,                              -- Продолжительность ответа на вопрос в сек
 surv_id           integer  REFERENCES SURVEYS_DICT (surv_id),     -- ID Опросника
 stime             date     not null,                              -- Начало истории
 etime             date     not null                               -- Конец истории
);

INSERT INTO QUESTIONS_HIST (qst_id,stat_id,qst_order,qst_how_much_time,surv_id,stime,etime ) 
VALUES (1,1,1,60,1,'2023-01-01','2999-12-31'),
       (2,1,1,60,1,'2023-01-01','2999-12-31'),
       (3,1,1,60,1,'2023-01-01','2999-12-31');

--------------------------------------------------------------------------------------------------------
-- Создание таблицы Справочник ответов .
CREATE TABLE ANSWERS_DICT 
(answ_id   serial       primary key,      -- ID ответа
 answ_name varchar(100) unique not null   -- Наименование ответа 
);

-- к Вопросу 1
INSERT INTO ANSWERS_DICT (answ_name)
VALUES ('Java'),('Basic'),('HTML'),('C++');

-- к Вопросу 2
INSERT INTO ANSWERS_DICT (answ_name)
VALUES ('Язык гипертекстовой разметки сайта'),
       ('Код программы С++'),
	   ('Текстовый редактор');
	   
-- к Вопросу 3
INSERT INTO ANSWERS_DICT(answ_name)
VALUES ('Язык программирования'),
       ('Мессенжер'),
	   ('Система позиционирования'),
	   ('Система контроля версий'),
	   ('Модель смартфона');
-----------------------------------------------------------------------------------------------------
-- Создание таблицы История изменения списка вопросов
CREATE TABLE ANSWERS_HIST 
(answ_id     integer  REFERENCES ANSWERS_DICT (answ_id),    -- ID ответа
 stat_id     smallint REFERENCES STATUS (stat_id),          -- ID Статус ответа
 answ_order  smallint not null,                             -- Порядковый номер ответа в вопросе 
 answ_res    boolean  not null,                             -- Результат ответа 
 qst_id      integer  REFERENCES QUESTIONS_DICT (qst_id),   -- ID вопроса
 stime       date     not null,                             -- Начало истории
 etime       date     not null                              -- Конец истории
);

CREATE INDEX qst$stat$i on answers_hist (qst_id,stat_id); 

-- QST_ID=1 к Вопросу 1
INSERT INTO ANSWERS_HIST (answ_id,stat_id,answ_order,answ_res,qst_id,stime,etime)
VALUES (1,1,1,FALSE,1,'2023-01-01','2999-12-31' ),
       (2,1,2,FALSE,1,'2023-01-01','2999-12-31' ),
       (3,1,3,TRUE,1,'2023-01-01','2999-12-31' ),
       (4,1,4,FALSE,1,'2023-01-01','2999-12-31' );
-- QST_ID=2 к Вопросу 2
INSERT INTO ANSWERS_HIST (answ_id,stat_id,answ_order,answ_res,qst_id,stime,etime)
VALUES (5,1,1,TRUE,2,'2023-01-01','2999-12-31' ),
       (6,1,2,FALSE,2,'2023-01-01','2999-12-31' ),
       (7,1,3,FALSE,2,'2023-01-01','2999-12-31' );
-- QST_ID=3 к Вопросу 3
INSERT INTO ANSWERS_HIST (answ_id,stat_id,answ_order,answ_res,qst_id,stime,etime)
VALUES (8,1,1,FALSE,3,'2023-01-01','2999-12-31' ),
       (9,1,2,FALSE,3,'2023-01-01','2999-12-31' ),
       (10,1,3,FALSE,3,'2023-01-01','2999-12-31' ),
       (11,1,4,TRUE,3,'2023-01-01','2999-12-31' ),
	   (12,1,5,FALSE,3,'2023-01-01','2999-12-31' );
---------------------------------------------------------------------------------------------
-- Создание таблицы Общих Результатов Опроса
CREATE TABLE SURVEYS_RESULT
(surv_res_id        serial  PRIMARY KEY,                        -- ID результатов опроса
 user_id            integer REFERENCES USERS (user_id),         -- ID пользователя опроса
 start_time         date    not null,                           -- Дата начала опроса
 end_time           date    not null,                           -- Дата завершения опроса
 surv_id            integer REFERENCES SURVEYS_DICT (surv_id),  -- ID опроса
 surv_result_finish boolean not null                            -- Итоговый результат опроса
 );

INSERT INTO SURVEYS_RESULT (user_id,start_time,end_time,surv_id,surv_result_finish)
VALUES (1,'2023-04-01','2023-04-01',1,true);

-------------------------------------------------------------------------------------------------
-- Создание таблицы Детальных Результатов Опроса
CREATE TABLE SURVEYS_RESULT_HIST
(res_id                serial  PRIMARY KEY,                              -- ID детали результата опроса
 surv_res_id           integer REFERENCES SURVEYS_RESULT (surv_res_id),  -- ID реузльтат опроса
 qst_id                integer REFERENCES QUESTIONS_DICT (qst_id),       -- ID Вопроса
 answ_order_res        integer not null,                                 -- ID варианта ответа 
 qst_how_much_time_res integer not null,                                 -- Время в сек потраченное на ответ
 create_time           date    not null                                  -- Дата ответа на вопрос
 );
 
INSERT INTO SURVEYS_RESULT_HIST (surv_res_id,qst_id,answ_order_res,qst_how_much_time_res,create_time)
VALUES (1,1,1,34,'2023-04-01'),
       (1,2,21,34,'2023-04-01'),
	   (1,3,4,34,'2023-04-01');

-----------------------------------------------------------------------------------------------------------
----                                           Запросы                                               ------
-----------------------------------------------------------------------------------------------------------
 -- Библиотека опросников
 SELECT lh.lib_id,ld.lib_name
   FROM LIBRARYS_HIST lh ,LIBRARYS_DICT ld
  WHERE lh.lib_id = ld.lib_id
    AND lh.stime <= localtimestamp AND lh.etime > localtimestamp
    AND lh.stat_id = 1;
 ----------------------------------------------------------------------------------------------------
 -- Опросники
 SELECT sh.surv_id,sd.surv_name,ld.lib_name
   FROM SURVEYS_HIST sh , SURVEYS_DICT sd , LIBRARYS_DICT ld
  WHERE sh.surv_id = sd.surv_id
    AND sh.stime <= localtimestamp AND sh.etime > localtimestamp
    AND sh.stat_id = 1
    AND sh.lib_id= ld.lib_id;
 -----------------------------------------------------------------------------------------------------
 -- Вопросы 
 SELECT qh.qst_id,qd.quest_name,sd.surv_name
   FROM QUESTIONS_HIST qh, QUESTIONS_DICT qd , SURVEYS_DICT sd 
  WHERE qh.qst_id = qd.qst_id
    AND qh.stime <= localtimestamp AND qh.etime > localtimestamp
    AND qh.stat_id = 1
    AND qh.surv_id=sd.surv_id;
 -----------------------------------------------------------------------------------------------------
 -- Варианты ответов 
 SELECT ah.answ_id,ah.answ_res,ad.answ_name, qd.quest_name
   FROM ANSWERS_HIST ah , ANSWERS_DICT ad , QUESTIONS_DICT qd 
  WHERE ah.answ_id = ad.answ_id
    AND ah.stime <= localtimestamp AND ah.etime > localtimestamp
    AND ah.stat_id = 1
    AND ah.qst_id=qd.qst_id;

 -----------------------------------------------------------------------------------------------------
 -- Общая информация по описанию опроса  SURV_ID = 1
 SELECT lh.lib_id,ld.lib_name,sh.surv_id,sd.surv_name,qh.qst_id,qh.qst_order,qd.quest_name,
        ah.answ_id,ah.answ_order,ad.answ_name,ah.answ_res
  FROM  LIBRARYS_HIST lh ,LIBRARYS_DICT ld, SURVEYS_HIST sh , SURVEYS_DICT sd,
        QUESTIONS_HIST qh, QUESTIONS_DICT qd ,  ANSWERS_HIST ah , ANSWERS_DICT ad
 WHERE lh.lib_id  = sh.lib_id
   AND lh.lib_id  = ld.lib_id 
   AND sh.surv_id = qh.surv_id
   AND sh.surv_id = sd.surv_id
   AND qh.qst_id  = ah.qst_id
   AND qh.qst_id  = qd.qst_id
   AND ah.answ_id = ad.answ_id
   AND lh.stime  <= localtimestamp AND lh.etime > localtimestamp  AND lh.stat_id = 1
   AND sh.stime  <= localtimestamp AND sh.etime > localtimestamp  AND sh.stat_id = 1
   AND qh.stime  <= localtimestamp AND qh.etime > localtimestamp  AND qh.stat_id = 1
   AND ah.stime  <= localtimestamp AND ah.etime > localtimestamp  AND ah.stat_id = 1
   AND sh.surv_id = 1
 order by lh.lib_id,sh.surv_id,qh.qst_id,qh.qst_order,ah.answ_order
 ------------------------------------------------------------------------------------------
 
 -- Статистика состава опроса SURV_ID=1
 SELECT sh.surv_id , 
        qh.qst_id                  as "ID Вопроса",
		count(distinct ah.answ_id) as "Кол-во вариантов ответа"
 FROM SURVEYS_HIST sh
 INNER JOIN QUESTIONS_HIST qh ON sh.surv_id = qh.surv_id 
                                 AND qh.stime <= localtimestamp AND qh.etime > localtimestamp
                                 AND qh.stat_id  = 1 
 INNER JOIN ANSWERS_HIST AH   ON ah.qst_id  = qh.qst_id 
                                 AND ah.stime <= localtimestamp AND ah.etime > localtimestamp
                                 AND ah.stat_id = 1
 WHERE sh.surv_id = 1
   AND sh.stat_id = 1 AND sh.stime <= localtimestamp AND sh.etime > localtimestamp
 GROUP BY sh.surv_id , qh.qst_id

 
 ----------------------------------------------------------------------------------------------------
 --Детальный результат , результа опроса SURV_RES_ID=1
 SELECT sr.surv_res_id                    as "Номер Опроса",
        s.user_name                       as "ФИО",
        sd.surv_name                      as "Имя опроса",
        qd.quest_name                     as "Вопрос",
        srh.answ_order_res                as "Выбор ответа",
        srh.qst_how_much_time_res         as "Потраченное время в сек",
        CASE 
         WHEN ad.answ_name IS NULL
          THEN 'неверный'
            ELSE ad.answ_name
        END                               as "Ответ",
        CASE 
         WHEN ah.answ_res IS NULL 
          THEN FALSE 
          ELSE ah.answ_res 
        END                               as "Результат" ,
        ah2.answ_order                    as "Номер Правильного ответа" ,
        ad2.answ_name                     as "Правильный ответ"
 FROM   SURVEYS_RESULT_HIST srh
 INNER JOIN SURVEYS_RESULT sr  ON srh.surv_res_id=sr.surv_res_id 
 INNER JOIN USERS s            ON sr.user_id = s.user_id 
 INNER JOIN SURVEYS_DICT sd    ON sr.surv_id = sd.surv_id
 INNER JOIN QUESTIONS_DICT qd  ON srh.qst_id = qd.qst_id
 LEFT  JOIN ANSWERS_HIST ah    ON srh.answ_order_res = ah.answ_order 
                                  AND srh.qst_id = ah.qst_id
                                  AND ah.stime <= localtimestamp AND ah.etime > localtimestamp
                               LEFT JOIN ANSWERS_DICT ad ON ad.answ_id= ah.answ_id
 INNER JOIN ANSWERS_HIST ah2   ON srh.qst_id = ah2.qst_id AND ah2.answ_res = true
 INNER JOIN ANSWERS_DICT ad2   ON ad2.answ_id = ah2.answ_id 
 WHERE srh.surv_res_id = 1
 ORDER BY srh.res_id
 
-------------------------------------------------------------------------------------------------     

-- Результат опроса общий итог
 SELECT sr.surv_res_id         as "Номер Опроса" , 
        s.user_name            as "ФИО", 
		sd.surv_name           as "Имя опроса" ,
        COUNT (1)              as "Кол-во вопросов",
        SUM ( CASE WHEN
                   CASE WHEN ah.answ_res IS NULL THEN FALSE ELSE ah.answ_res END = TRUE THEN 1
              ELSE  0
              END
            )                  as "Правильных ответов",
         SUM ( CASE WHEN
                    CASE WHEN ah.answ_res IS NULL THEN FALSE ELSE ah.answ_res END = FALSE THEN 1
               ELSE  0 
               END
             )                 as "Ошибочных ответов" , 
         sr.start_time         as "Дата начала опроса", 
		 sr.end_time           as "Дата завершения опроса",
		 sr.surv_result_finish as "Результат"
 FROM SURVEYS_RESULT_HIST srh
 INNER JOIN SURVEYS_RESULT sr ON srh.surv_res_id=sr.surv_res_id 
 INNER JOIN USERS s ON sr.user_id = s.user_id 
 INNER JOIN SURVEYS_DICT sd ON sr.surv_id = sd.surv_id
 LEFT  JOIN ANSWERS_HIST ah ON srh.answ_order_res = ah.answ_order AND srh.qst_id = ah.qst_id
                               AND ah.stime <= localtimestamp AND ah.etime > localtimestamp
                               LEFT JOIN ANSWERS_DICT ad ON ad.answ_id = ah.answ_id
 WHERE srh.surv_res_id = 1							   
 GROUP BY sr.surv_res_id , s.user_name, sd.surv_name;

 
 








