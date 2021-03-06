# Gerenciamento de pacientes
Permite o gerenciamento de pacientes em uma clínica

O Controle de gerenciamento aos pacientes (CAP) é um sistema simples desenvolvido utilizando o padrão de projeto MVC, a linguagem Java e o postgresql.

### Mas iai? Como faço para testar?

Para testá-lo, basta ter o `NetBeans IDE 8.2` e o `postgresql` intalado e configurado, a versão do postgresql utilizado foi a 9.5.

No postgresql crie:
- uma base com o nome `clinic`
- tablela de `usuario`
```
CREATE TABLE public.usuario
(
  id integer NOT NULL DEFAULT nextval('usuario_id_seq'::regclass),
  cpfusuario character varying(11) NOT NULL,
  senhausuario character varying(20) NOT NULL,
  CONSTRAINT usuario_pkey PRIMARY KEY (id)
)
```
- tabela de `endereco`
```
CREATE TABLE public.endereco
(
  cep character varying(50) NOT NULL,
  rua character varying(50),
  numero character varying(10),
  bairro character varying(20),
  complemento character varying(20),
  cidade character varying(20),
  uf character varying(2),
  CONSTRAINT endereco_pkey PRIMARY KEY (cep)
)
```

- tabela de `paciente`

```
CREATE TABLE public.paciente
(
  nome character varying(50),
  cpf character varying(11) NOT NULL,
  cns character varying(50),
  cep character varying(20) NOT NULL,
  CONSTRAINT paciente_pkey PRIMARY KEY (cpf),
  CONSTRAINT fkpaciente_endereco FOREIGN KEY (cep)
      REFERENCES public.endereco (cep) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
```


e por fim....

Execute a interface `TelaLogin.java` e prontooo, a brincadeira comçouu!
