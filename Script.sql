/*
SELECT
'ALTER TABLE '||S.SCHEMANAME||'.'||T.TABLENAME||' DROP CONSTRAINT '||C.CONSTRAINTNAME||';'
FROM
    SYS.SYSCONSTRAINTS C,
    SYS.SYSSCHEMAS S,
    SYS.SYSTABLES T
WHERE
    C.SCHEMAID = S.SCHEMAID
AND
    C.TABLEID = T.TABLEID
AND
S.SCHEMANAME = 'APP'

SELECT 'DROP TABLE ' || schemaname ||'.' || tablename || ';'
FROM SYS.SYSTABLES
INNER JOIN SYS.SYSSCHEMAS ON SYS.SYSTABLES.SCHEMAID = SYS.SYSSCHEMAS.SCHEMAID
where schemaname='APP';
*/

/******************************************************************************/
/***                                 Tables                                 ***/
/******************************************************************************/

CREATE TABLE CLIENTE (
    CODIGO INT not null primary key
        GENERATED ALWAYS AS IDENTITY
        (START WITH 1, INCREMENT BY 1),  
    NOME      VARCHAR(60),
    ENDERECO  VARCHAR(80),
    NUMERO    VARCHAR(6),
    BAIRRO    VARCHAR(40),
    UF        CHAR(2),
    FONE      VARCHAR(20),
    EMAIL     VARCHAR(80)
);

CREATE TABLE LOCACAO (
    CODIGO INT not null primary key
        GENERATED ALWAYS AS IDENTITY
        (START WITH 1, INCREMENT BY 1),  
    COD_CLIENTE   INTEGER,
    DT_LOCACAO    DATE,
    DT_PREVISTA   DATE,
    DT_DEVOLVIDO  DATE,
    DT_CANCELADO  DATE,
    VALOR         NUMERIC(15,2)
);

CREATE TABLE LOCACAO_PROD (
    CODIGO INT not null primary key
        GENERATED ALWAYS AS IDENTITY
        (START WITH 1, INCREMENT BY 1),  
    COD_LOCACAO  INTEGER,
    COD_PRODUTO  INTEGER
);

CREATE TABLE PRODUTO (
    CODIGO INT not null primary key
        GENERATED ALWAYS AS IDENTITY
        (START WITH 1, INCREMENT BY 1),  
    TITULO   VARCHAR(60),
    VALOR    NUMERIC(15,2),
    GENERO   VARCHAR(15),
    CLASSIF  VARCHAR(5),
    DURACAO  INTEGER
);

/******************************************************************************/
/***                              Primary Keys                              ***/
/******************************************************************************/

ALTER TABLE CLIENTE ADD CONSTRAINT PK_CLIENTE PRIMARY KEY (CODIGO);
ALTER TABLE LOCACAO ADD CONSTRAINT PK_LOCACAO PRIMARY KEY (CODIGO);
ALTER TABLE LOCACAO_PROD ADD CONSTRAINT PK_LOCACAO_PROD PRIMARY KEY (CODIGO);
ALTER TABLE PRODUTO ADD CONSTRAINT PK_PRODUTO PRIMARY KEY (CODIGO);

/******************************************************************************/
/***                              Foreign Keys                              ***/
/******************************************************************************/

ALTER TABLE LOCACAO ADD CONSTRAINT FK_LOCACAO_CLIENTE FOREIGN KEY (COD_CLIENTE) REFERENCES CLIENTE (CODIGO);
ALTER TABLE LOCACAO_PROD ADD CONSTRAINT FK_LOCACAO FOREIGN KEY (COD_LOCACAO) REFERENCES LOCACAO (CODIGO);
ALTER TABLE LOCACAO_PROD ADD CONSTRAINT FK_LOCACAO_PROD FOREIGN KEY (COD_PRODUTO) REFERENCES PRODUTO (CODIGO);