INSERT INTO `caadiintegrada`.`periods` (`id`, `start`, `end`, `description`) VALUES ('1', '2017-08-07', '2017-12-09', '');

-- Alumnos Janette
INSERT INTO `caadiintegrada`.`students` (`nua`, `firstLastName`, `secondLastName`, `name`, `gender`, `birthday`, `program`, `email`) VALUES ('146068', 'AGUILERA', 'GARCIA', 'HUGO ARMANDO', 'MALE', null, '', '');
INSERT INTO `caadiintegrada`.`students` (`nua`, `firstLastName`, `secondLastName`, `name`, `gender`, `birthday`, `program`, `email`) VALUES ('143879', 'CORONA', 'MELENDEZ', 'JOSE LUIS', 'MALE', null, '', '');
INSERT INTO `caadiintegrada`.`students` (`nua`, `firstLastName`, `secondLastName`, `name`, `gender`, `birthday`, `program`, `email`) VALUES ('335912', 'FLORES', 'SALDIVAR', 'HECTOR GANDHI', 'MALE', null, '', '');
INSERT INTO `caadiintegrada`.`students` (`nua`, `firstLastName`, `secondLastName`, `name`, `gender`, `birthday`, `program`, `email`) VALUES ('145867', 'GUZMAN', 'MALDONADO', 'RODRIGO', 'MALE', null, '', '');
INSERT INTO `caadiintegrada`.`students` (`nua`, `firstLastName`, `secondLastName`, `name`, `gender`, `birthday`, `program`, `email`) VALUES ('145656', 'ROJAS', 'DELGADO', 'CARLOS LEOPOLDO', 'MALE', null, '', '');
INSERT INTO `caadiintegrada`.`students` (`nua`, `firstLastName`, `secondLastName`, `name`, `gender`, `birthday`, `program`, `email`) VALUES ('907211', 'GONZALEZ', 'VILLAGOMEZ', 'JACOB', 'MALE', null, '', '');
INSERT INTO `caadiintegrada`.`students` (`nua`, `firstLastName`, `secondLastName`, `name`, `gender`, `birthday`, `program`, `email`) VALUES ('907201', 'CALDERON', 'URIBE', 'URIEL', 'MALE', null, '', '');
INSERT INTO `caadiintegrada`.`students` (`nua`, `firstLastName`, `secondLastName`, `name`, `gender`, `birthday`, `program`, `email`) VALUES ('145295', 'DARIO', 'JIMENEZ', 'VELOMDIA', 'MALE', null, '', '');

-- Alumnos Rudy
INSERT INTO `caadiintegrada`.`students` (`nua`, `firstLastName`, `secondLastName`, `name`, `gender`, `birthday`, `program`, `email`) VALUES ('810164', 'BALCAZAR', 'TORRES', 'DAVID ALEJANDRO', 'MALE', null, '', '');
INSERT INTO `caadiintegrada`.`students` (`nua`, `firstLastName`, `secondLastName`, `name`, `gender`, `birthday`, `program`, `email`) VALUES ('146266', 'BECERRA', 'MONTAÑEZ', 'MIGUEL ALFONSO', 'MALE', null, '', '');
INSERT INTO `caadiintegrada`.`students` (`nua`, `firstLastName`, `secondLastName`, `name`, `gender`, `birthday`, `program`, `email`) VALUES ('810213', 'CONTRERAS', 'CONTRERAS', 'IGNACIO', 'MALE', null, '', '');
INSERT INTO `caadiintegrada`.`students` (`nua`, `firstLastName`, `secondLastName`, `name`, `gender`, `birthday`, `program`, `email`) VALUES ('146472', 'ORRALA', 'SILVA', 'SERGIO ALAN', 'MALE', null, '', '');
INSERT INTO `caadiintegrada`.`students` (`nua`, `firstLastName`, `secondLastName`, `name`, `gender`, `birthday`, `program`, `email`) VALUES ('146269', 'OTALORA', 'LEGUIZAMON', 'CRISTIAN CAMILO', 'MALE', null, '', '');
INSERT INTO `caadiintegrada`.`students` (`nua`, `firstLastName`, `secondLastName`, `name`, `gender`, `birthday`, `program`, `email`) VALUES ('146471', 'ROSAS', 'CENTENO', 'ELEAZAR', 'MALE', null, '', '');

-- Alumnos Blanca
INSERT INTO `caadiintegrada`.`students` (`nua`, `firstLastName`, `secondLastName`, `name`, `gender`, `birthday`, `program`, `email`) VALUES ('726133', 'DE JULIAN', 'POSADA', 'EDER CONSTANTINO', 'MALE', null, '', '');
INSERT INTO `caadiintegrada`.`students` (`nua`, `firstLastName`, `secondLastName`, `name`, `gender`, `birthday`, `program`, `email`) VALUES ('907202', 'LARA', 'ESPINOZA', 'EDWIN MIGUEL', 'MALE', null, '', '');
INSERT INTO `caadiintegrada`.`students` (`nua`, `firstLastName`, `secondLastName`, `name`, `gender`, `birthday`, `program`, `email`) VALUES ('146272', 'LOPEZ', 'CASTILLO', 'SINAI', 'FEMALE', null, '', '');
INSERT INTO `caadiintegrada`.`students` (`nua`, `firstLastName`, `secondLastName`, `name`, `gender`, `birthday`, `program`, `email`) VALUES ('143622', 'MARTINEZ', 'HURTADO', 'SANDRA', 'FEMALE', null, '', '');
INSERT INTO `caadiintegrada`.`students` (`nua`, `firstLastName`, `secondLastName`, `name`, `gender`, `birthday`, `program`, `email`) VALUES ('810122', 'MORALES', 'NUÑEZ', 'CARLOS ALFREDO', 'MALE', null, '', '');
INSERT INTO `caadiintegrada`.`students` (`nua`, `firstLastName`, `secondLastName`, `name`, `gender`, `birthday`, `program`, `email`) VALUES ('308113', 'REYNOSO', 'GODINEZ', 'REYNALDO', 'MALE', null, '', '');
INSERT INTO `caadiintegrada`.`students` (`nua`, `firstLastName`, `secondLastName`, `name`, `gender`, `birthday`, `program`, `email`) VALUES ('810150', 'VALDES', 'OCHOA', 'MIGUEL ANGEL', 'MALE', null, '', '');
INSERT INTO `caadiintegrada`.`students` (`nua`, `firstLastName`, `secondLastName`, `name`, `gender`, `birthday`, `program`, `email`) VALUES ('143424', 'ZENDEJAS', 'ANDRADE', 'LUIS ALEJANDRO', 'MALE', null, '', '');

-- Teachers
INSERT INTO `caadiintegrada`.`teachers` (`employeeNumber`, `firstLastName`, `secondLastName`, `name`, `gender`, `email`) VALUES ('000001', 'LOPEZ', 'MIRANDA', 'JANETTE', 'FEMALE', '');
INSERT INTO `caadiintegrada`.`teachers` (`employeeNumber`, `firstLastName`, `secondLastName`, `name`, `gender`, `email`) VALUES ('000002', 'AP', 'AP', 'BLANCA', 'FEMALE', '');
INSERT INTO `caadiintegrada`.`teachers` (`employeeNumber`, `firstLastName`, `secondLastName`, `name`, `gender`, `email`) VALUES ('000003', 'REYES', 'AP', 'RODOLFO', 'MALE', '');

-- Grupos
INSERT INTO `caadiintegrada`.`groups` (`id`, `periodId`, `employeeNumber`, `learningUnit`, `level`, `identifier`) VALUES ('1', '1', '000001', 'learningUnit', '3', 'ident');
INSERT INTO `caadiintegrada`.`groups` (`id`, `periodId`, `employeeNumber`, `learningUnit`, `level`, `identifier`) VALUES ('2', '1', '000002', 'learningUnit', '2', 'ident');
INSERT INTO `caadiintegrada`.`groups` (`id`, `periodId`, `employeeNumber`, `learningUnit`, `level`, `identifier`) VALUES ('3', '1', '000003', 'learningUnit', '1', 'ident');

-- Miembros de grupos
-- Grupo Janette
INSERT INTO `caadiintegrada`.`groupmembers` (`groupId`, `nua`) VALUES ('1', '146068');
INSERT INTO `caadiintegrada`.`groupmembers` (`groupId`, `nua`) VALUES ('1', '143879');
INSERT INTO `caadiintegrada`.`groupmembers` (`groupId`, `nua`) VALUES ('1', '335912');
INSERT INTO `caadiintegrada`.`groupmembers` (`groupId`, `nua`) VALUES ('1', '145867');
INSERT INTO `caadiintegrada`.`groupmembers` (`groupId`, `nua`) VALUES ('1', '145656');
INSERT INTO `caadiintegrada`.`groupmembers` (`groupId`, `nua`) VALUES ('1', '907211');
INSERT INTO `caadiintegrada`.`groupmembers` (`groupId`, `nua`) VALUES ('1', '907201');
INSERT INTO `caadiintegrada`.`groupmembers` (`groupId`, `nua`) VALUES ('1', '145295');

-- Grupo Blanca
INSERT INTO `caadiintegrada`.`groupmembers` (`groupId`, `nua`) VALUES ('2', '726133');
INSERT INTO `caadiintegrada`.`groupmembers` (`groupId`, `nua`) VALUES ('2', '907202');
INSERT INTO `caadiintegrada`.`groupmembers` (`groupId`, `nua`) VALUES ('2', '146272');
INSERT INTO `caadiintegrada`.`groupmembers` (`groupId`, `nua`) VALUES ('2', '143622');
INSERT INTO `caadiintegrada`.`groupmembers` (`groupId`, `nua`) VALUES ('2', '810122');
INSERT INTO `caadiintegrada`.`groupmembers` (`groupId`, `nua`) VALUES ('2', '308113');
INSERT INTO `caadiintegrada`.`groupmembers` (`groupId`, `nua`) VALUES ('2', '810150');
INSERT INTO `caadiintegrada`.`groupmembers` (`groupId`, `nua`) VALUES ('2', '143424');

-- Grupo Rudy
INSERT INTO `caadiintegrada`.`groupmembers` (`groupId`, `nua`) VALUES ('3', '810164');
INSERT INTO `caadiintegrada`.`groupmembers` (`groupId`, `nua`) VALUES ('3', '146266');
INSERT INTO `caadiintegrada`.`groupmembers` (`groupId`, `nua`) VALUES ('3', '810213');
INSERT INTO `caadiintegrada`.`groupmembers` (`groupId`, `nua`) VALUES ('3', '146472');
INSERT INTO `caadiintegrada`.`groupmembers` (`groupId`, `nua`) VALUES ('3', '146269');
INSERT INTO `caadiintegrada`.`groupmembers` (`groupId`, `nua`) VALUES ('3', '146471');
