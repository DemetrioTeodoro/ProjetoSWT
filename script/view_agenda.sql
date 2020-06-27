CREATE 
    ALGORITHM = UNDEFINED 
    DEFINER = `root`@`localhost` 
    SQL SECURITY DEFINER
VIEW `view_agenda` AS
    SELECT 
        `o`.`id` AS `id`,
        `o`.`data_inicio` AS `data_inicio`,
        `o`.`data_termino_previsto` AS `data_termino_previsto`,
        `o`.`data_termino` AS `data_termino`,
        `o`.`numero_os` AS `numero_os`,
        `e`.`bairro` AS `bairro`,
        `e`.`cidade` AS `cidade`,
        `e`.`estado` AS `estado`,
        `cl`.`nome` AS `nome`,
        `cl`.`telefone` AS `telefone`
    FROM
        ((`ordem_servico` `o`
        JOIN `endereco` `e` ON ((`o`.`id_endereco` = `e`.`id`)))
        JOIN `cliente` `cl` ON ((`o`.`id_cliente` = `cl`.`id`)))
    GROUP BY `o`.`id`