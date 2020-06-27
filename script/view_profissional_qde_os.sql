CREATE 
    ALGORITHM = UNDEFINED 
    DEFINER = `root`@`localhost` 
    SQL SECURITY DEFINER
VIEW `view_profissional_qde_os` AS
    SELECT DISTINCT
        `p`.`nome` AS `NOME`,
        COUNT(`op`.`id_profissional`) AS `QDE_OS`
    FROM
        (`profissional` `p`
        JOIN `ordem_servico_profissional` `op` ON ((`p`.`id` = `op`.`id_profissional`)))
    GROUP BY `op`.`id_profissional`