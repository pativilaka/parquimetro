INSERT INTO tb_cliente (nome, telefone) VALUES ('João Silva', '123456789');
INSERT INTO tb_cliente (nome, telefone) VALUES ('Maria Oliveira', '987654321');

INSERT INTO tb_veiculo (placa, modelo, cliente_id) VALUES ('ABC-1234', 'Honda Civic', 1);
INSERT INTO tb_veiculo (placa, modelo, cliente_id) VALUES ('DEF-5678', 'Toyota Corolla', 2);

INSERT INTO tb_filial (nome, endereco) VALUES ('Filial Morumbi', 'Rua A, 123');
INSERT INTO tb_filial (nome, endereco) VALUES ('Filial Interlagos', 'Av. B, 456');

INSERT INTO tb_registro_estacionamento (entrada, saida, veiculo_id, filial_id) VALUES ('2025-01-10 08:00:00', '2025-01-10 10:00:00', 1, 1);
INSERT INTO tb_registro_estacionamento (entrada, saida, veiculo_id, filial_id) VALUES ('2025-01-10 14:00:00', '2025-01-10 15:30:00', 2, 2);

INSERT INTO tb_cobranca (valor, pago, registro_id) VALUES (20.00, TRUE, 1);
INSERT INTO tb_cobranca (valor, pago, registro_id) VALUES (25.00, FALSE, 2);