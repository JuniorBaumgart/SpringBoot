INSERT INTO tb_department(dpt_nome) VALUES ('Gestão');
INSERT INTO tb_department(dpt_nome) VALUES ('Informática');

INSERT INTO tb_cidade(cdd_descricao, cdd_uf) VALUES ('Marau', 'RS');
INSERT INTO tb_cidade(cdd_descricao, cdd_uf) VALUES ('Sao Paulo', 'SP');

INSERT INTO tb_user(dpt_id, usr_nome, usr_email, usr_senha, usr_nascimento, cdd_id) VALUES (1, 'Maria Silva', 'maria@gmail.com', '000', '2001-02-23', 1);
INSERT INTO tb_user(dpt_id, usr_nome, usr_email, usr_senha, usr_nascimento, cdd_id) VALUES (1, 'Bob Amarante', 'bob@gmail.com', '111', '2001-02-23', 1);
INSERT INTO tb_user(dpt_id, usr_nome, usr_email, usr_senha, usr_nascimento, cdd_id) VALUES (2, 'Alex', 'alex@gmail.com', '111', '2001-02-23', 1);
INSERT INTO tb_user(dpt_id, usr_nome, usr_email, usr_senha, usr_nascimento, cdd_id) VALUES (2, 'Ana', 'ana@gmail.com','333', '2001-02-23', 1);
INSERT INTO tb_user(dpt_id, usr_nome, usr_email, usr_senha, usr_nascimento, cdd_id) VALUES (2, 'Mario', 'mario@gmail.com','111', '2001-02-23', 1);
INSERT INTO tb_user(dpt_id, usr_nome, usr_email, usr_senha, usr_nascimento, cdd_id) VALUES (2, 'Ana da Silva', 'anasilva@gmail.com','555', '2001-02-23', 1);