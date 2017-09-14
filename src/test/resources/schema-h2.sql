drop table if exists public.tb_usuario;




create table public.tb_usuario (
  id int PRIMARY KEY AUTO_INCREMENT NOT NULL,
  nome varchar(45),
  email varchar(255),
  password varchar(80)
  
);


