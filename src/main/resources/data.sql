INSERT INTO TB_CONTA (id_conta, NM_CONTA, VL_SALDO_INICIAL, VL_SALDO) VALUES(1, 'Nubank', 100.0, -900.00);
INSERT INTO TB_CONTA (id_conta, NM_CONTA, VL_SALDO_INICIAL, VL_SALDO) VALUES(2, 'Inter', 200.0, -300.00);
INSERT INTO TB_CONTA (id_conta, NM_CONTA, VL_SALDO_INICIAL, VL_SALDO) VALUES(3, 'Neon', 300.0, 1600.00);

INSERT INTO tb_transferencia (id_transferencia, fk_origem, fk_destino, vl_transferido) VALUES (1, 1, 2, 200.0);
INSERT INTO tb_transferencia (id_transferencia, fk_origem, fk_destino, vl_transferido) VALUES (2, 1, 2, 300.0);
INSERT INTO tb_transferencia (id_transferencia, fk_origem, fk_destino, vl_transferido) VALUES (3, 1, 3, 500.0);

INSERT INTO tb_transferencia (id_transferencia, fk_origem, fk_destino, vl_transferido) VALUES (7, 2, 3, 200.0);
INSERT INTO tb_transferencia (id_transferencia, fk_origem, fk_destino, vl_transferido) VALUES (8, 2, 3, 300.0);
INSERT INTO tb_transferencia (id_transferencia, fk_origem, fk_destino, vl_transferido) VALUES (9, 2, 3, 300.0);