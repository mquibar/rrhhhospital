PGDMP     &    	                n            rrhh-hospital    8.4.1    8.4.1 �               0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                       false                       0    0 
   STDSTRINGS 
   STDSTRINGS     )   SET standard_conforming_strings = 'off';
                       false                       1262    44402    rrhh-hospital    DATABASE     �   CREATE DATABASE "rrhh-hospital" WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Spanish_Spain.1252' LC_CTYPE = 'Spanish_Spain.1252';
    DROP DATABASE "rrhh-hospital";
             postgres    false                        2615    2200    public    SCHEMA        CREATE SCHEMA public;
    DROP SCHEMA public;
             postgres    false                       0    0    SCHEMA public    COMMENT     6   COMMENT ON SCHEMA public IS 'standard public schema';
                  postgres    false    3                       0    0    public    ACL     �   REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;
                  postgres    false    3            �           2612    16386    plpgsql    PROCEDURAL LANGUAGE     $   CREATE PROCEDURAL LANGUAGE plpgsql;
 "   DROP PROCEDURAL LANGUAGE plpgsql;
             postgres    false            6           1259    44403    agrupamiento    TABLE     �   CREATE TABLE agrupamiento (
    id integer NOT NULL,
    eliminado boolean NOT NULL,
    nombre character varying(255) NOT NULL
);
     DROP TABLE public.agrupamiento;
       public         postgres    false    3            W           1259    44762    agrupamiento_id_sequence    SEQUENCE     z   CREATE SEQUENCE agrupamiento_id_sequence
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 /   DROP SEQUENCE public.agrupamiento_id_sequence;
       public       postgres    false    3            	           0    0    agrupamiento_id_sequence    SEQUENCE SET     ?   SELECT pg_catalog.setval('agrupamiento_id_sequence', 3, true);
            public       postgres    false    1623            7           1259    44408    asignacionhorario    TABLE     �   CREATE TABLE asignacionhorario (
    id integer NOT NULL,
    descripcion character varying(255),
    fecha date,
    vigente boolean NOT NULL,
    idempleado integer NOT NULL,
    idtipohorario integer NOT NULL
);
 %   DROP TABLE public.asignacionhorario;
       public         postgres    false    3            X           1259    44764    asignacionhorario_id_sequence    SEQUENCE        CREATE SEQUENCE asignacionhorario_id_sequence
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 4   DROP SEQUENCE public.asignacionhorario_id_sequence;
       public       postgres    false    3            
           0    0    asignacionhorario_id_sequence    SEQUENCE SET     E   SELECT pg_catalog.setval('asignacionhorario_id_sequence', 1, false);
            public       postgres    false    1624            8           1259    44413    cargo    TABLE     �   CREATE TABLE cargo (
    id integer NOT NULL,
    fechavigencia date NOT NULL,
    nombre character varying(255) NOT NULL,
    vigente boolean NOT NULL,
    idempleado integer NOT NULL,
    idpuesto integer NOT NULL
);
    DROP TABLE public.cargo;
       public         postgres    false    3            Y           1259    44766    cargo_id_sequence    SEQUENCE     s   CREATE SEQUENCE cargo_id_sequence
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 (   DROP SEQUENCE public.cargo_id_sequence;
       public       postgres    false    3                       0    0    cargo_id_sequence    SEQUENCE SET     9   SELECT pg_catalog.setval('cargo_id_sequence', 1, false);
            public       postgres    false    1625            9           1259    44418 	   categoria    TABLE     �   CREATE TABLE categoria (
    id integer NOT NULL,
    cupo integer,
    elimininado boolean,
    nombre character varying(255) NOT NULL,
    numero integer,
    idtramo integer NOT NULL
);
    DROP TABLE public.categoria;
       public         postgres    false    3            Z           1259    44768    categoria_id_sequence    SEQUENCE     w   CREATE SEQUENCE categoria_id_sequence
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 ,   DROP SEQUENCE public.categoria_id_sequence;
       public       postgres    false    3                       0    0    categoria_id_sequence    SEQUENCE SET     <   SELECT pg_catalog.setval('categoria_id_sequence', 7, true);
            public       postgres    false    1626            :           1259    44423    clase    TABLE     \   CREATE TABLE clase (
    id integer NOT NULL,
    nombre character varying(255) NOT NULL
);
    DROP TABLE public.clase;
       public         postgres    false    3            [           1259    44770    clase_id_sequence    SEQUENCE     s   CREATE SEQUENCE clase_id_sequence
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 (   DROP SEQUENCE public.clase_id_sequence;
       public       postgres    false    3                       0    0    clase_id_sequence    SEQUENCE SET     9   SELECT pg_catalog.setval('clase_id_sequence', 1, false);
            public       postgres    false    1627            ;           1259    44428    clasecontenida    TABLE     �   CREATE TABLE clasecontenida (
    id integer NOT NULL,
    antiguedadminima integer,
    inicial boolean,
    numeroindice integer,
    idcategoria integer NOT NULL,
    idclase integer NOT NULL
);
 "   DROP TABLE public.clasecontenida;
       public         postgres    false    3            \           1259    44772    clasecontenida_id_sequence    SEQUENCE     |   CREATE SEQUENCE clasecontenida_id_sequence
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 1   DROP SEQUENCE public.clasecontenida_id_sequence;
       public       postgres    false    3                       0    0    clasecontenida_id_sequence    SEQUENCE SET     A   SELECT pg_catalog.setval('clasecontenida_id_sequence', 5, true);
            public       postgres    false    1628            <           1259    44433    clasevigente    TABLE     �   CREATE TABLE clasevigente (
    id integer NOT NULL,
    fechavigencia date NOT NULL,
    vigente boolean NOT NULL,
    idcategoria integer NOT NULL,
    idclase integer NOT NULL,
    idempleado integer NOT NULL
);
     DROP TABLE public.clasevigente;
       public         postgres    false    3            ]           1259    44774    clasevigente_id_sequence    SEQUENCE     z   CREATE SEQUENCE clasevigente_id_sequence
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 /   DROP SEQUENCE public.clasevigente_id_sequence;
       public       postgres    false    3                       0    0    clasevigente_id_sequence    SEQUENCE SET     ?   SELECT pg_catalog.setval('clasevigente_id_sequence', 1, true);
            public       postgres    false    1629            =           1259    44438 	   domicilio    TABLE       CREATE TABLE domicilio (
    id integer NOT NULL,
    barrio character varying(255),
    calle character varying(255),
    departamento character varying(255),
    numero integer,
    piso character varying(255),
    idlocalidad integer NOT NULL,
    idprovincia integer NOT NULL
);
    DROP TABLE public.domicilio;
       public         postgres    false    3            ^           1259    44776    domicilio_id_sequence    SEQUENCE     w   CREATE SEQUENCE domicilio_id_sequence
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 ,   DROP SEQUENCE public.domicilio_id_sequence;
       public       postgres    false    3                       0    0    domicilio_id_sequence    SEQUENCE SET     <   SELECT pg_catalog.setval('domicilio_id_sequence', 1, true);
            public       postgres    false    1630            >           1259    44446    empleado    TABLE     �   CREATE TABLE empleado (
    cuil character varying(255),
    eliminado boolean,
    fechaingreso date,
    legajo integer NOT NULL,
    idempleado integer NOT NULL,
    idtarjeta integer NOT NULL,
    idtipoempleado integer NOT NULL
);
    DROP TABLE public.empleado;
       public         postgres    false    3            _           1259    44778    hibernate_sequence    SEQUENCE     t   CREATE SEQUENCE hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 )   DROP SEQUENCE public.hibernate_sequence;
       public       postgres    false    3                       0    0    hibernate_sequence    SEQUENCE SET     :   SELECT pg_catalog.setval('hibernate_sequence', 1, false);
            public       postgres    false    1631            ?           1259    44451    licencia    TABLE     �   CREATE TABLE licencia (
    id integer NOT NULL,
    eliminada boolean,
    fechafin date NOT NULL,
    fechainicio date NOT NULL,
    motivo character varying(255),
    idempleado integer NOT NULL,
    idtipolicencia integer NOT NULL
);
    DROP TABLE public.licencia;
       public         postgres    false    3            `           1259    44780    licencia_id_sequence    SEQUENCE     v   CREATE SEQUENCE licencia_id_sequence
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 +   DROP SEQUENCE public.licencia_id_sequence;
       public       postgres    false    3                       0    0    licencia_id_sequence    SEQUENCE SET     <   SELECT pg_catalog.setval('licencia_id_sequence', 1, false);
            public       postgres    false    1632            @           1259    44456 	   localidad    TABLE     �   CREATE TABLE localidad (
    id integer NOT NULL,
    localidad character varying(255) NOT NULL,
    idpovincia integer NOT NULL
);
    DROP TABLE public.localidad;
       public         postgres    false    3            A           1259    44461 	   operacion    TABLE        CREATE TABLE operacion (
    id integer NOT NULL,
    description character varying(255),
    nombre character varying(255)
);
    DROP TABLE public.operacion;
       public         postgres    false    3            B           1259    44469    pais    TABLE     Y   CREATE TABLE pais (
    id integer NOT NULL,
    pais character varying(255) NOT NULL
);
    DROP TABLE public.pais;
       public         postgres    false    3            a           1259    44782    pais_id_sequence    SEQUENCE     r   CREATE SEQUENCE pais_id_sequence
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 '   DROP SEQUENCE public.pais_id_sequence;
       public       postgres    false    3                       0    0    pais_id_sequence    SEQUENCE SET     8   SELECT pg_catalog.setval('pais_id_sequence', 1, false);
            public       postgres    false    1633            C           1259    44474    perfil    TABLE     |   CREATE TABLE perfil (
    id integer NOT NULL,
    description character varying(255),
    nombre character varying(255)
);
    DROP TABLE public.perfil;
       public         postgres    false    3            D           1259    44482    perfil_operacion    TABLE     g   CREATE TABLE perfil_operacion (
    perfil_id integer NOT NULL,
    operaciones_id integer NOT NULL
);
 $   DROP TABLE public.perfil_operacion;
       public         postgres    false    3            E           1259    44485    persona    TABLE     @  CREATE TABLE persona (
    id integer NOT NULL,
    apellido character varying(255) NOT NULL,
    dni character varying(255) NOT NULL,
    fechanacimiento date,
    nombre character varying(255),
    telefono bigint NOT NULL,
    iddomicilio integer NOT NULL,
    idpais integer NOT NULL,
    idsexo integer NOT NULL
);
    DROP TABLE public.persona;
       public         postgres    false    3            b           1259    44784    persona_id_sequence    SEQUENCE     u   CREATE SEQUENCE persona_id_sequence
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 *   DROP SEQUENCE public.persona_id_sequence;
       public       postgres    false    3                       0    0    persona_id_sequence    SEQUENCE SET     :   SELECT pg_catalog.setval('persona_id_sequence', 1, true);
            public       postgres    false    1634            F           1259    44493    profesional    TABLE     �   CREATE TABLE profesional (
    matricula character varying(255) NOT NULL,
    eliminado boolean NOT NULL,
    titulo character varying(255),
    idprofesional integer NOT NULL
);
    DROP TABLE public.profesional;
       public         postgres    false    3            G           1259    44501 	   provincia    TABLE     c   CREATE TABLE provincia (
    id integer NOT NULL,
    provincia character varying(255) NOT NULL
);
    DROP TABLE public.provincia;
       public         postgres    false    3            c           1259    44786    provincia_id_sequence    SEQUENCE     w   CREATE SEQUENCE provincia_id_sequence
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 ,   DROP SEQUENCE public.provincia_id_sequence;
       public       postgres    false    3                       0    0    provincia_id_sequence    SEQUENCE SET     =   SELECT pg_catalog.setval('provincia_id_sequence', 1, false);
            public       postgres    false    1635            d           1259    44788    puesto_gerarquico_id_sequence    SEQUENCE        CREATE SEQUENCE puesto_gerarquico_id_sequence
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 4   DROP SEQUENCE public.puesto_gerarquico_id_sequence;
       public       postgres    false    3                       0    0    puesto_gerarquico_id_sequence    SEQUENCE SET     E   SELECT pg_catalog.setval('puesto_gerarquico_id_sequence', 1, false);
            public       postgres    false    1636            H           1259    44506    puestojerarquico    TABLE     }   CREATE TABLE puestojerarquico (
    id integer NOT NULL,
    nombre character varying(255) NOT NULL,
    idpuesto integer
);
 $   DROP TABLE public.puestojerarquico;
       public         postgres    false    3            e           1259    44790    registro_periodo_id_sequence    SEQUENCE     ~   CREATE SEQUENCE registro_periodo_id_sequence
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 3   DROP SEQUENCE public.registro_periodo_id_sequence;
       public       postgres    false    3                       0    0    registro_periodo_id_sequence    SEQUENCE SET     D   SELECT pg_catalog.setval('registro_periodo_id_sequence', 1, false);
            public       postgres    false    1637            f           1259    44792    registro_reloj_id_sequence    SEQUENCE     |   CREATE SEQUENCE registro_reloj_id_sequence
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 1   DROP SEQUENCE public.registro_reloj_id_sequence;
       public       postgres    false    3                       0    0    registro_reloj_id_sequence    SEQUENCE SET     B   SELECT pg_catalog.setval('registro_reloj_id_sequence', 1, false);
            public       postgres    false    1638            I           1259    44511    registroperiodo    TABLE       CREATE TABLE registroperiodo (
    id integer NOT NULL,
    eliminado boolean NOT NULL,
    fechaentrada date NOT NULL,
    fechasalida date NOT NULL,
    horaentrada time without time zone NOT NULL,
    horasalida time without time zone NOT NULL,
    idempleado integer NOT NULL
);
 #   DROP TABLE public.registroperiodo;
       public         postgres    false    3            J           1259    44516    registroreloj    TABLE     �   CREATE TABLE registroreloj (
    id integer NOT NULL,
    eliminado boolean NOT NULL,
    fecha date NOT NULL,
    hora time without time zone NOT NULL,
    idempleado integer NOT NULL,
    numero bigint NOT NULL,
    idtiporegistro integer NOT NULL
);
 !   DROP TABLE public.registroreloj;
       public         postgres    false    3            V           1259    44589    relacion    TABLE     d   CREATE TABLE relacion (
    idtipolicencia integer NOT NULL,
    idtipoempleado integer NOT NULL
);
    DROP TABLE public.relacion;
       public         postgres    false    3            K           1259    44521 	   requisito    TABLE     �   CREATE TABLE requisito (
    id integer NOT NULL,
    descripcion character varying(255) NOT NULL,
    numero integer,
    idcategoria integer NOT NULL
);
    DROP TABLE public.requisito;
       public         postgres    false    3            g           1259    44794    requisito_id_sequence    SEQUENCE     w   CREATE SEQUENCE requisito_id_sequence
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 ,   DROP SEQUENCE public.requisito_id_sequence;
       public       postgres    false    3                       0    0    requisito_id_sequence    SEQUENCE SET     <   SELECT pg_catalog.setval('requisito_id_sequence', 5, true);
            public       postgres    false    1639            L           1259    44526    sexo    TABLE     Y   CREATE TABLE sexo (
    id integer NOT NULL,
    sexo character varying(255) NOT NULL
);
    DROP TABLE public.sexo;
       public         postgres    false    3            h           1259    44796    sexo_id_sequence    SEQUENCE     r   CREATE SEQUENCE sexo_id_sequence
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 '   DROP SEQUENCE public.sexo_id_sequence;
       public       postgres    false    3                       0    0    sexo_id_sequence    SEQUENCE SET     8   SELECT pg_catalog.setval('sexo_id_sequence', 1, false);
            public       postgres    false    1640            M           1259    44531    tarjeta    TABLE     e   CREATE TABLE tarjeta (
    id integer NOT NULL,
    eliminada boolean,
    numero bigint NOT NULL
);
    DROP TABLE public.tarjeta;
       public         postgres    false    3            i           1259    44798    tarjeta_id_sequence    SEQUENCE     u   CREATE SEQUENCE tarjeta_id_sequence
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 *   DROP SEQUENCE public.tarjeta_id_sequence;
       public       postgres    false    3                       0    0    tarjeta_id_sequence    SEQUENCE SET     ;   SELECT pg_catalog.setval('tarjeta_id_sequence', 1, false);
            public       postgres    false    1641            N           1259    44536 	   tipocarga    TABLE     �   CREATE TABLE tipocarga (
    dtype character varying(31) NOT NULL,
    id integer NOT NULL,
    descripcion character varying(255),
    nombre character varying(255) NOT NULL
);
    DROP TABLE public.tipocarga;
       public         postgres    false    3            j           1259    44800    tipocarga_id_sequence    SEQUENCE     w   CREATE SEQUENCE tipocarga_id_sequence
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 ,   DROP SEQUENCE public.tipocarga_id_sequence;
       public       postgres    false    3                       0    0    tipocarga_id_sequence    SEQUENCE SET     =   SELECT pg_catalog.setval('tipocarga_id_sequence', 1, false);
            public       postgres    false    1642            O           1259    44544    tipoempleado    TABLE     �   CREATE TABLE tipoempleado (
    id integer NOT NULL,
    codigo character varying(255),
    nombre character varying(255) NOT NULL
);
     DROP TABLE public.tipoempleado;
       public         postgres    false    3            k           1259    44802    tipoempleado_id_sequence    SEQUENCE     z   CREATE SEQUENCE tipoempleado_id_sequence
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 /   DROP SEQUENCE public.tipoempleado_id_sequence;
       public       postgres    false    3                       0    0    tipoempleado_id_sequence    SEQUENCE SET     @   SELECT pg_catalog.setval('tipoempleado_id_sequence', 1, false);
            public       postgres    false    1643            P           1259    44552    tipohorario    TABLE       CREATE TABLE tipohorario (
    id integer NOT NULL,
    descripcion character varying(255),
    eliminado boolean,
    horaingreso time without time zone NOT NULL,
    horasalida time without time zone NOT NULL,
    nombre character varying(255) NOT NULL
);
    DROP TABLE public.tipohorario;
       public         postgres    false    3            l           1259    44804    tipohorario_id_sequence    SEQUENCE     y   CREATE SEQUENCE tipohorario_id_sequence
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 .   DROP SEQUENCE public.tipohorario_id_sequence;
       public       postgres    false    3                       0    0    tipohorario_id_sequence    SEQUENCE SET     ?   SELECT pg_catalog.setval('tipohorario_id_sequence', 1, false);
            public       postgres    false    1644            Q           1259    44560    tipolicencia    TABLE     �   CREATE TABLE tipolicencia (
    id integer NOT NULL,
    descripcion character varying(255),
    eliminado boolean NOT NULL,
    nombre character varying(255) NOT NULL
);
     DROP TABLE public.tipolicencia;
       public         postgres    false    3            m           1259    44806    tipolicencia_id_sequence    SEQUENCE     z   CREATE SEQUENCE tipolicencia_id_sequence
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 /   DROP SEQUENCE public.tipolicencia_id_sequence;
       public       postgres    false    3                       0    0    tipolicencia_id_sequence    SEQUENCE SET     @   SELECT pg_catalog.setval('tipolicencia_id_sequence', 1, false);
            public       postgres    false    1645            R           1259    44568    tiporegistro    TABLE     a   CREATE TABLE tiporegistro (
    dtype character varying(31) NOT NULL,
    id integer NOT NULL
);
     DROP TABLE public.tiporegistro;
       public         postgres    false    3            S           1259    44573    tramo    TABLE     �   CREATE TABLE tramo (
    id integer NOT NULL,
    eliminado boolean,
    nombre character varying(255) NOT NULL,
    idagrupamiento integer NOT NULL
);
    DROP TABLE public.tramo;
       public         postgres    false    3            n           1259    44808    tramo_id_sequence    SEQUENCE     s   CREATE SEQUENCE tramo_id_sequence
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 (   DROP SEQUENCE public.tramo_id_sequence;
       public       postgres    false    3                        0    0    tramo_id_sequence    SEQUENCE SET     8   SELECT pg_catalog.setval('tramo_id_sequence', 3, true);
            public       postgres    false    1646            T           1259    44578    usuario    TABLE     �   CREATE TABLE usuario (
    id integer NOT NULL,
    eliminado boolean NOT NULL,
    fechaalta date,
    nombre character varying(255),
    password character varying(255),
    empleado_idempleado integer
);
    DROP TABLE public.usuario;
       public         postgres    false    3            o           1259    44810    usuario_id_sequence    SEQUENCE     u   CREATE SEQUENCE usuario_id_sequence
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 *   DROP SEQUENCE public.usuario_id_sequence;
       public       postgres    false    3            !           0    0    usuario_id_sequence    SEQUENCE SET     :   SELECT pg_catalog.setval('usuario_id_sequence', 1, true);
            public       postgres    false    1647            U           1259    44586    usuario_perfil    TABLE     c   CREATE TABLE usuario_perfil (
    usuario_id integer NOT NULL,
    perfiles_id integer NOT NULL
);
 "   DROP TABLE public.usuario_perfil;
       public         postgres    false    3            �          0    44403    agrupamiento 
   TABLE DATA                     public       postgres    false    1590   ��       �          0    44408    asignacionhorario 
   TABLE DATA                     public       postgres    false    1591   ��       �          0    44413    cargo 
   TABLE DATA                     public       postgres    false    1592   ��       �          0    44418 	   categoria 
   TABLE DATA                     public       postgres    false    1593   ��       �          0    44423    clase 
   TABLE DATA                     public       postgres    false    1594   ��       �          0    44428    clasecontenida 
   TABLE DATA                     public       postgres    false    1595   ��       �          0    44433    clasevigente 
   TABLE DATA                     public       postgres    false    1596   t�       �          0    44438 	   domicilio 
   TABLE DATA                     public       postgres    false    1597   �       �          0    44446    empleado 
   TABLE DATA                     public       postgres    false    1598   ��       �          0    44451    licencia 
   TABLE DATA                     public       postgres    false    1599   {�       �          0    44456 	   localidad 
   TABLE DATA                     public       postgres    false    1600   ��       �          0    44461 	   operacion 
   TABLE DATA                     public       postgres    false    1601   ��       �          0    44469    pais 
   TABLE DATA                     public       postgres    false    1602   ��       �          0    44474    perfil 
   TABLE DATA                     public       postgres    false    1603   O�       �          0    44482    perfil_operacion 
   TABLE DATA                     public       postgres    false    1604   ��       �          0    44485    persona 
   TABLE DATA                     public       postgres    false    1605   �       �          0    44493    profesional 
   TABLE DATA                     public       postgres    false    1606   ��       �          0    44501 	   provincia 
   TABLE DATA                     public       postgres    false    1607   p�       �          0    44506    puestojerarquico 
   TABLE DATA                     public       postgres    false    1608   ��       �          0    44511    registroperiodo 
   TABLE DATA                     public       postgres    false    1609   ��       �          0    44516    registroreloj 
   TABLE DATA                     public       postgres    false    1610   ��                 0    44589    relacion 
   TABLE DATA                     public       postgres    false    1622   �       �          0    44521 	   requisito 
   TABLE DATA                     public       postgres    false    1611   �       �          0    44526    sexo 
   TABLE DATA                     public       postgres    false    1612   ��       �          0    44531    tarjeta 
   TABLE DATA                     public       postgres    false    1613   �       �          0    44536 	   tipocarga 
   TABLE DATA                     public       postgres    false    1614   ��       �          0    44544    tipoempleado 
   TABLE DATA                     public       postgres    false    1615   ��       �          0    44552    tipohorario 
   TABLE DATA                     public       postgres    false    1616   /�       �          0    44560    tipolicencia 
   TABLE DATA                     public       postgres    false    1617   I�       �          0    44568    tiporegistro 
   TABLE DATA                     public       postgres    false    1618   c�                  0    44573    tramo 
   TABLE DATA                     public       postgres    false    1619   }�                 0    44578    usuario 
   TABLE DATA                     public       postgres    false    1620   t�                 0    44586    usuario_perfil 
   TABLE DATA                     public       postgres    false    1621   �       �           2606    44407    agrupamiento_pkey 
   CONSTRAINT     U   ALTER TABLE ONLY agrupamiento
    ADD CONSTRAINT agrupamiento_pkey PRIMARY KEY (id);
 H   ALTER TABLE ONLY public.agrupamiento DROP CONSTRAINT agrupamiento_pkey;
       public         postgres    false    1590    1590            �           2606    44412    asignacionhorario_pkey 
   CONSTRAINT     _   ALTER TABLE ONLY asignacionhorario
    ADD CONSTRAINT asignacionhorario_pkey PRIMARY KEY (id);
 R   ALTER TABLE ONLY public.asignacionhorario DROP CONSTRAINT asignacionhorario_pkey;
       public         postgres    false    1591    1591            �           2606    44417 
   cargo_pkey 
   CONSTRAINT     G   ALTER TABLE ONLY cargo
    ADD CONSTRAINT cargo_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.cargo DROP CONSTRAINT cargo_pkey;
       public         postgres    false    1592    1592            �           2606    44422    categoria_pkey 
   CONSTRAINT     O   ALTER TABLE ONLY categoria
    ADD CONSTRAINT categoria_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.categoria DROP CONSTRAINT categoria_pkey;
       public         postgres    false    1593    1593            �           2606    44427 
   clase_pkey 
   CONSTRAINT     G   ALTER TABLE ONLY clase
    ADD CONSTRAINT clase_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.clase DROP CONSTRAINT clase_pkey;
       public         postgres    false    1594    1594            �           2606    44432    clasecontenida_pkey 
   CONSTRAINT     Y   ALTER TABLE ONLY clasecontenida
    ADD CONSTRAINT clasecontenida_pkey PRIMARY KEY (id);
 L   ALTER TABLE ONLY public.clasecontenida DROP CONSTRAINT clasecontenida_pkey;
       public         postgres    false    1595    1595            �           2606    44437    clasevigente_pkey 
   CONSTRAINT     U   ALTER TABLE ONLY clasevigente
    ADD CONSTRAINT clasevigente_pkey PRIMARY KEY (id);
 H   ALTER TABLE ONLY public.clasevigente DROP CONSTRAINT clasevigente_pkey;
       public         postgres    false    1596    1596            �           2606    44445    domicilio_pkey 
   CONSTRAINT     O   ALTER TABLE ONLY domicilio
    ADD CONSTRAINT domicilio_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.domicilio DROP CONSTRAINT domicilio_pkey;
       public         postgres    false    1597    1597            �           2606    44450    empleado_pkey 
   CONSTRAINT     U   ALTER TABLE ONLY empleado
    ADD CONSTRAINT empleado_pkey PRIMARY KEY (idempleado);
 @   ALTER TABLE ONLY public.empleado DROP CONSTRAINT empleado_pkey;
       public         postgres    false    1598    1598            �           2606    44455    licencia_pkey 
   CONSTRAINT     M   ALTER TABLE ONLY licencia
    ADD CONSTRAINT licencia_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.licencia DROP CONSTRAINT licencia_pkey;
       public         postgres    false    1599    1599            �           2606    44460    localidad_pkey 
   CONSTRAINT     O   ALTER TABLE ONLY localidad
    ADD CONSTRAINT localidad_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.localidad DROP CONSTRAINT localidad_pkey;
       public         postgres    false    1600    1600            �           2606    44468    operacion_pkey 
   CONSTRAINT     O   ALTER TABLE ONLY operacion
    ADD CONSTRAINT operacion_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.operacion DROP CONSTRAINT operacion_pkey;
       public         postgres    false    1601    1601            �           2606    44473 	   pais_pkey 
   CONSTRAINT     E   ALTER TABLE ONLY pais
    ADD CONSTRAINT pais_pkey PRIMARY KEY (id);
 8   ALTER TABLE ONLY public.pais DROP CONSTRAINT pais_pkey;
       public         postgres    false    1602    1602            �           2606    44481    perfil_pkey 
   CONSTRAINT     I   ALTER TABLE ONLY perfil
    ADD CONSTRAINT perfil_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.perfil DROP CONSTRAINT perfil_pkey;
       public         postgres    false    1603    1603            �           2606    44492    persona_pkey 
   CONSTRAINT     K   ALTER TABLE ONLY persona
    ADD CONSTRAINT persona_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.persona DROP CONSTRAINT persona_pkey;
       public         postgres    false    1605    1605            �           2606    44500    profesional_pkey 
   CONSTRAINT     ^   ALTER TABLE ONLY profesional
    ADD CONSTRAINT profesional_pkey PRIMARY KEY (idprofesional);
 F   ALTER TABLE ONLY public.profesional DROP CONSTRAINT profesional_pkey;
       public         postgres    false    1606    1606            �           2606    44505    provincia_pkey 
   CONSTRAINT     O   ALTER TABLE ONLY provincia
    ADD CONSTRAINT provincia_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.provincia DROP CONSTRAINT provincia_pkey;
       public         postgres    false    1607    1607            �           2606    44510    puestojerarquico_pkey 
   CONSTRAINT     ]   ALTER TABLE ONLY puestojerarquico
    ADD CONSTRAINT puestojerarquico_pkey PRIMARY KEY (id);
 P   ALTER TABLE ONLY public.puestojerarquico DROP CONSTRAINT puestojerarquico_pkey;
       public         postgres    false    1608    1608            �           2606    44515    registroperiodo_pkey 
   CONSTRAINT     [   ALTER TABLE ONLY registroperiodo
    ADD CONSTRAINT registroperiodo_pkey PRIMARY KEY (id);
 N   ALTER TABLE ONLY public.registroperiodo DROP CONSTRAINT registroperiodo_pkey;
       public         postgres    false    1609    1609            �           2606    44520    registroreloj_pkey 
   CONSTRAINT     W   ALTER TABLE ONLY registroreloj
    ADD CONSTRAINT registroreloj_pkey PRIMARY KEY (id);
 J   ALTER TABLE ONLY public.registroreloj DROP CONSTRAINT registroreloj_pkey;
       public         postgres    false    1610    1610            �           2606    44525    requisito_pkey 
   CONSTRAINT     O   ALTER TABLE ONLY requisito
    ADD CONSTRAINT requisito_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.requisito DROP CONSTRAINT requisito_pkey;
       public         postgres    false    1611    1611            �           2606    44530 	   sexo_pkey 
   CONSTRAINT     E   ALTER TABLE ONLY sexo
    ADD CONSTRAINT sexo_pkey PRIMARY KEY (id);
 8   ALTER TABLE ONLY public.sexo DROP CONSTRAINT sexo_pkey;
       public         postgres    false    1612    1612            �           2606    44535    tarjeta_pkey 
   CONSTRAINT     K   ALTER TABLE ONLY tarjeta
    ADD CONSTRAINT tarjeta_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.tarjeta DROP CONSTRAINT tarjeta_pkey;
       public         postgres    false    1613    1613            �           2606    44543    tipocarga_pkey 
   CONSTRAINT     O   ALTER TABLE ONLY tipocarga
    ADD CONSTRAINT tipocarga_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.tipocarga DROP CONSTRAINT tipocarga_pkey;
       public         postgres    false    1614    1614            �           2606    44551    tipoempleado_pkey 
   CONSTRAINT     U   ALTER TABLE ONLY tipoempleado
    ADD CONSTRAINT tipoempleado_pkey PRIMARY KEY (id);
 H   ALTER TABLE ONLY public.tipoempleado DROP CONSTRAINT tipoempleado_pkey;
       public         postgres    false    1615    1615            �           2606    44559    tipohorario_pkey 
   CONSTRAINT     S   ALTER TABLE ONLY tipohorario
    ADD CONSTRAINT tipohorario_pkey PRIMARY KEY (id);
 F   ALTER TABLE ONLY public.tipohorario DROP CONSTRAINT tipohorario_pkey;
       public         postgres    false    1616    1616            �           2606    44567    tipolicencia_pkey 
   CONSTRAINT     U   ALTER TABLE ONLY tipolicencia
    ADD CONSTRAINT tipolicencia_pkey PRIMARY KEY (id);
 H   ALTER TABLE ONLY public.tipolicencia DROP CONSTRAINT tipolicencia_pkey;
       public         postgres    false    1617    1617            �           2606    44572    tiporegistro_pkey 
   CONSTRAINT     U   ALTER TABLE ONLY tiporegistro
    ADD CONSTRAINT tiporegistro_pkey PRIMARY KEY (id);
 H   ALTER TABLE ONLY public.tiporegistro DROP CONSTRAINT tiporegistro_pkey;
       public         postgres    false    1618    1618            �           2606    44577 
   tramo_pkey 
   CONSTRAINT     G   ALTER TABLE ONLY tramo
    ADD CONSTRAINT tramo_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.tramo DROP CONSTRAINT tramo_pkey;
       public         postgres    false    1619    1619            �           2606    44585    usuario_pkey 
   CONSTRAINT     K   ALTER TABLE ONLY usuario
    ADD CONSTRAINT usuario_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.usuario DROP CONSTRAINT usuario_pkey;
       public         postgres    false    1620    1620            �           2606    44677    fk2fa5904947b6da30    FK CONSTRAINT     t   ALTER TABLE ONLY localidad
    ADD CONSTRAINT fk2fa5904947b6da30 FOREIGN KEY (idpovincia) REFERENCES provincia(id);
 F   ALTER TABLE ONLY public.localidad DROP CONSTRAINT fk2fa5904947b6da30;
       public       postgres    false    1957    1600    1607            �           2606    44672    fk37fa2ccc1f88b7a8    FK CONSTRAINT     z   ALTER TABLE ONLY licencia
    ADD CONSTRAINT fk37fa2ccc1f88b7a8 FOREIGN KEY (idempleado) REFERENCES empleado(idempleado);
 E   ALTER TABLE ONLY public.licencia DROP CONSTRAINT fk37fa2ccc1f88b7a8;
       public       postgres    false    1599    1598    1941            �           2606    44667    fk37fa2ccced4d10f2    FK CONSTRAINT     z   ALTER TABLE ONLY licencia
    ADD CONSTRAINT fk37fa2ccced4d10f2 FOREIGN KEY (idtipolicencia) REFERENCES tipolicencia(id);
 E   ALTER TABLE ONLY public.licencia DROP CONSTRAINT fk37fa2ccced4d10f2;
       public       postgres    false    1977    1617    1599            �           2606    44692    fk3ac8678c789754c8    FK CONSTRAINT     i   ALTER TABLE ONLY persona
    ADD CONSTRAINT fk3ac8678c789754c8 FOREIGN KEY (idpais) REFERENCES pais(id);
 D   ALTER TABLE ONLY public.persona DROP CONSTRAINT fk3ac8678c789754c8;
       public       postgres    false    1949    1605    1602            �           2606    44702    fk3ac8678c789a30a4    FK CONSTRAINT     i   ALTER TABLE ONLY persona
    ADD CONSTRAINT fk3ac8678c789a30a4 FOREIGN KEY (idsexo) REFERENCES sexo(id);
 D   ALTER TABLE ONLY public.persona DROP CONSTRAINT fk3ac8678c789a30a4;
       public       postgres    false    1612    1605    1967            �           2606    44697    fk3ac8678cb6bef8    FK CONSTRAINT     q   ALTER TABLE ONLY persona
    ADD CONSTRAINT fk3ac8678cb6bef8 FOREIGN KEY (iddomicilio) REFERENCES domicilio(id);
 B   ALTER TABLE ONLY public.persona DROP CONSTRAINT fk3ac8678cb6bef8;
       public       postgres    false    1597    1605    1939            �           2606    44607    fk3ddf79c1f88b7a8    FK CONSTRAINT     v   ALTER TABLE ONLY cargo
    ADD CONSTRAINT fk3ddf79c1f88b7a8 FOREIGN KEY (idempleado) REFERENCES empleado(idempleado);
 A   ALTER TABLE ONLY public.cargo DROP CONSTRAINT fk3ddf79c1f88b7a8;
       public       postgres    false    1941    1598    1592            �           2606    44602    fk3ddf79cc2b1d8b7    FK CONSTRAINT     t   ALTER TABLE ONLY cargo
    ADD CONSTRAINT fk3ddf79cc2b1d8b7 FOREIGN KEY (idpuesto) REFERENCES puestojerarquico(id);
 A   ALTER TABLE ONLY public.cargo DROP CONSTRAINT fk3ddf79cc2b1d8b7;
       public       postgres    false    1592    1608    1959            �           2606    44597    fk491c00da1f88b7a8    FK CONSTRAINT     �   ALTER TABLE ONLY asignacionhorario
    ADD CONSTRAINT fk491c00da1f88b7a8 FOREIGN KEY (idempleado) REFERENCES empleado(idempleado);
 N   ALTER TABLE ONLY public.asignacionhorario DROP CONSTRAINT fk491c00da1f88b7a8;
       public       postgres    false    1941    1591    1598            �           2606    44592    fk491c00dab8a3b4ea    FK CONSTRAINT     �   ALTER TABLE ONLY asignacionhorario
    ADD CONSTRAINT fk491c00dab8a3b4ea FOREIGN KEY (idtipohorario) REFERENCES tipohorario(id);
 N   ALTER TABLE ONLY public.asignacionhorario DROP CONSTRAINT fk491c00dab8a3b4ea;
       public       postgres    false    1591    1975    1616            �           2606    44622    fk4986174152f3ce94    FK CONSTRAINT     z   ALTER TABLE ONLY clasecontenida
    ADD CONSTRAINT fk4986174152f3ce94 FOREIGN KEY (idcategoria) REFERENCES categoria(id);
 K   ALTER TABLE ONLY public.clasecontenida DROP CONSTRAINT fk4986174152f3ce94;
       public       postgres    false    1931    1593    1595            �           2606    44617    fk4986174198eea602    FK CONSTRAINT     r   ALTER TABLE ONLY clasecontenida
    ADD CONSTRAINT fk4986174198eea602 FOREIGN KEY (idclase) REFERENCES clase(id);
 K   ALTER TABLE ONLY public.clasecontenida DROP CONSTRAINT fk4986174198eea602;
       public       postgres    false    1595    1933    1594            �           2606    44662    fk4af864eb13498130    FK CONSTRAINT     z   ALTER TABLE ONLY empleado
    ADD CONSTRAINT fk4af864eb13498130 FOREIGN KEY (idtipoempleado) REFERENCES tipoempleado(id);
 E   ALTER TABLE ONLY public.empleado DROP CONSTRAINT fk4af864eb13498130;
       public       postgres    false    1598    1973    1615            �           2606    44652    fk4af864eb899cc3bb    FK CONSTRAINT     q   ALTER TABLE ONLY empleado
    ADD CONSTRAINT fk4af864eb899cc3bb FOREIGN KEY (idempleado) REFERENCES persona(id);
 E   ALTER TABLE ONLY public.empleado DROP CONSTRAINT fk4af864eb899cc3bb;
       public       postgres    false    1598    1605    1953            �           2606    44657    fk4af864ebfabd7bc8    FK CONSTRAINT     p   ALTER TABLE ONLY empleado
    ADD CONSTRAINT fk4af864ebfabd7bc8 FOREIGN KEY (idtarjeta) REFERENCES tarjeta(id);
 E   ALTER TABLE ONLY public.empleado DROP CONSTRAINT fk4af864ebfabd7bc8;
       public       postgres    false    1613    1969    1598            �           2606    44732    fk4d50265490bd046    FK CONSTRAINT     v   ALTER TABLE ONLY tramo
    ADD CONSTRAINT fk4d50265490bd046 FOREIGN KEY (idagrupamiento) REFERENCES agrupamiento(id);
 A   ALTER TABLE ONLY public.tramo DROP CONSTRAINT fk4d50265490bd046;
       public       postgres    false    1619    1925    1590            �           2606    44737    fk5b4d8b0e34672f9c    FK CONSTRAINT     �   ALTER TABLE ONLY usuario
    ADD CONSTRAINT fk5b4d8b0e34672f9c FOREIGN KEY (empleado_idempleado) REFERENCES empleado(idempleado);
 D   ALTER TABLE ONLY public.usuario DROP CONSTRAINT fk5b4d8b0e34672f9c;
       public       postgres    false    1941    1620    1598            �           2606    44637    fk78c1ea441f88b7a8    FK CONSTRAINT     ~   ALTER TABLE ONLY clasevigente
    ADD CONSTRAINT fk78c1ea441f88b7a8 FOREIGN KEY (idempleado) REFERENCES empleado(idempleado);
 I   ALTER TABLE ONLY public.clasevigente DROP CONSTRAINT fk78c1ea441f88b7a8;
       public       postgres    false    1596    1598    1941            �           2606    44632    fk78c1ea4452f3ce94    FK CONSTRAINT     x   ALTER TABLE ONLY clasevigente
    ADD CONSTRAINT fk78c1ea4452f3ce94 FOREIGN KEY (idcategoria) REFERENCES categoria(id);
 I   ALTER TABLE ONLY public.clasevigente DROP CONSTRAINT fk78c1ea4452f3ce94;
       public       postgres    false    1596    1593    1931            �           2606    44627    fk78c1ea4498eea602    FK CONSTRAINT     p   ALTER TABLE ONLY clasevigente
    ADD CONSTRAINT fk78c1ea4498eea602 FOREIGN KEY (idclase) REFERENCES clase(id);
 I   ALTER TABLE ONLY public.clasevigente DROP CONSTRAINT fk78c1ea4498eea602;
       public       postgres    false    1594    1596    1933            �           2606    44682    fk83d14652cc153af    FK CONSTRAINT     v   ALTER TABLE ONLY perfil_operacion
    ADD CONSTRAINT fk83d14652cc153af FOREIGN KEY (perfil_id) REFERENCES perfil(id);
 L   ALTER TABLE ONLY public.perfil_operacion DROP CONSTRAINT fk83d14652cc153af;
       public       postgres    false    1604    1951    1603            �           2606    44687    fk83d1465c24d77b7    FK CONSTRAINT     ~   ALTER TABLE ONLY perfil_operacion
    ADD CONSTRAINT fk83d1465c24d77b7 FOREIGN KEY (operaciones_id) REFERENCES operacion(id);
 L   ALTER TABLE ONLY public.perfil_operacion DROP CONSTRAINT fk83d1465c24d77b7;
       public       postgres    false    1604    1947    1601            �           2606    44722    fk869b3ba132c5e000    FK CONSTRAINT        ALTER TABLE ONLY registroreloj
    ADD CONSTRAINT fk869b3ba132c5e000 FOREIGN KEY (idtiporegistro) REFERENCES tiporegistro(id);
 J   ALTER TABLE ONLY public.registroreloj DROP CONSTRAINT fk869b3ba132c5e000;
       public       postgres    false    1618    1610    1979            �           2606    44727    fka106ede352f3ce94    FK CONSTRAINT     u   ALTER TABLE ONLY requisito
    ADD CONSTRAINT fka106ede352f3ce94 FOREIGN KEY (idcategoria) REFERENCES categoria(id);
 F   ALTER TABLE ONLY public.requisito DROP CONSTRAINT fka106ede352f3ce94;
       public       postgres    false    1593    1611    1931            �           2606    44707    fka69eb0acd3e74193    FK CONSTRAINT     �   ALTER TABLE ONLY profesional
    ADD CONSTRAINT fka69eb0acd3e74193 FOREIGN KEY (idprofesional) REFERENCES empleado(idempleado);
 H   ALTER TABLE ONLY public.profesional DROP CONSTRAINT fka69eb0acd3e74193;
       public       postgres    false    1941    1598    1606            �           2606    44647    fkaba87945570c8388    FK CONSTRAINT     u   ALTER TABLE ONLY domicilio
    ADD CONSTRAINT fkaba87945570c8388 FOREIGN KEY (idprovincia) REFERENCES provincia(id);
 F   ALTER TABLE ONLY public.domicilio DROP CONSTRAINT fkaba87945570c8388;
       public       postgres    false    1957    1597    1607            �           2606    44642    fkaba879458b0ed00    FK CONSTRAINT     t   ALTER TABLE ONLY domicilio
    ADD CONSTRAINT fkaba879458b0ed00 FOREIGN KEY (idlocalidad) REFERENCES localidad(id);
 E   ALTER TABLE ONLY public.domicilio DROP CONSTRAINT fkaba879458b0ed00;
       public       postgres    false    1600    1597    1945            �           2606    44612    fkd4c701139ad33838    FK CONSTRAINT     m   ALTER TABLE ONLY categoria
    ADD CONSTRAINT fkd4c701139ad33838 FOREIGN KEY (idtramo) REFERENCES tramo(id);
 F   ALTER TABLE ONLY public.categoria DROP CONSTRAINT fkd4c701139ad33838;
       public       postgres    false    1619    1593    1981            �           2606    44757    fkdeec3fad13498130    FK CONSTRAINT     z   ALTER TABLE ONLY relacion
    ADD CONSTRAINT fkdeec3fad13498130 FOREIGN KEY (idtipoempleado) REFERENCES tipoempleado(id);
 E   ALTER TABLE ONLY public.relacion DROP CONSTRAINT fkdeec3fad13498130;
       public       postgres    false    1622    1973    1615            �           2606    44752    fkdeec3faded4d10f2    FK CONSTRAINT     z   ALTER TABLE ONLY relacion
    ADD CONSTRAINT fkdeec3faded4d10f2 FOREIGN KEY (idtipolicencia) REFERENCES tipolicencia(id);
 E   ALTER TABLE ONLY public.relacion DROP CONSTRAINT fkdeec3faded4d10f2;
       public       postgres    false    1617    1622    1977            �           2606    44717    fke34052fb1f88b7a8    FK CONSTRAINT     �   ALTER TABLE ONLY registroperiodo
    ADD CONSTRAINT fke34052fb1f88b7a8 FOREIGN KEY (idempleado) REFERENCES empleado(idempleado);
 L   ALTER TABLE ONLY public.registroperiodo DROP CONSTRAINT fke34052fb1f88b7a8;
       public       postgres    false    1941    1609    1598            �           2606    44747    fke578dc3d70230341    FK CONSTRAINT     w   ALTER TABLE ONLY usuario_perfil
    ADD CONSTRAINT fke578dc3d70230341 FOREIGN KEY (perfiles_id) REFERENCES perfil(id);
 K   ALTER TABLE ONLY public.usuario_perfil DROP CONSTRAINT fke578dc3d70230341;
       public       postgres    false    1951    1621    1603            �           2606    44742    fke578dc3dab7e6425    FK CONSTRAINT     w   ALTER TABLE ONLY usuario_perfil
    ADD CONSTRAINT fke578dc3dab7e6425 FOREIGN KEY (usuario_id) REFERENCES usuario(id);
 K   ALTER TABLE ONLY public.usuario_perfil DROP CONSTRAINT fke578dc3dab7e6425;
       public       postgres    false    1620    1983    1621            �           2606    44712    fke9657d7c2b1d8b7    FK CONSTRAINT        ALTER TABLE ONLY puestojerarquico
    ADD CONSTRAINT fke9657d7c2b1d8b7 FOREIGN KEY (idpuesto) REFERENCES puestojerarquico(id);
 L   ALTER TABLE ONLY public.puestojerarquico DROP CONSTRAINT fke9657d7c2b1d8b7;
       public       postgres    false    1608    1608    1959            �   	  x����N�@��<���R���dݹ�R��Ԁ"5	*�L<R^�H�&n�<}��_fqd=�x������vxa�shO]��q�a��s���=9X���K��u���[�\8��ޕ�2��m��5l֑�dK�";}`�tAK��4Wgg͖I�n���W�0�=ZNl�����f���	Y,�%¯/�
%���9@H��J��)����~+�2�y֨s�f��f�p�*4�Mj�"jp�W���;h��G�e_~I�-      �   
   x���          �   
   x���          �   �  x����n�@��<����M���'h��.Zۨ�@+K*�<D=T}$^�c��u�29���7;?�R�h��0p_=�~lwu�z����ϭ��z]o�M����v�m����z���z�����	̅*1�q�A�{�z�E�]�E�	]���A�O>�����g �Tة��31�9������B�i*��4�C&r����wљ���Ȏ��A?g���C�����������I�ial�ꀃ�TL-�JS�h�j�����v�z�\j���,8v�J�_���6pԷh�����6t�
K�\����T����|+r��y� �kG�]s�s���Lqf���IE�����3�4�LO9Dly�8��<��4 ^��\&���dbi�"X�J��h���%�]��]�cc-稀ʨ��9i���.�$
�A�٨n^���9�%jN�������dKW	��_���.�j�84�~�xW�d`5^ш94V㔔�}4���Ł��&Ԩw3�PG��L�'      �   �   x���;
�@�~V�$�"7�`$�@��D{�)?��A������)���4�l��ޫ��Kj����Z;��a#�h;�a�%��S9U.���TIU
���USՂj�A�T��:�NP�~�¸����(?� P��C��@)���s]E��      �   �  x��Y�j�0��+tl�?�z��i=B
�v�&6��8�M������>�@H��o�i��v�����l�o��=����2-�8��yl̰\��4�q^��И��a��\���4/�|�n_���2}���?��z6~�>_�͓os{]���O�1�s���ْ�%��?w�����6�xW���2j��
| �w�����>�x-�=^3j�^Z"~��w{9"z��'\�����zmk�	��*���y���jyu���xiᰳ�!�^ZA��D�Kkk�L�w�8��=D��@,��l>y�=@<�Г5 U�P���g@�A��IH� �X͠�� �2�I@R�"� ���"� �}G2b$����I&�L)�݇�L�y��jz�ԡ=Y�ГE�ч�-E#zn0�DO>5�=�H����)�hE�HAЊ�mF���ی�C'*�����fV�0��V�0���a���V�0��ia�#�
qu[��U�x[N��Z���P������Y��u��;�gwĎTewɱ����uUa@�m�ë�=�
��U�	���*�޶0`VW���
��-�]����Pu�Q�ց����\�'�L����$�c,u�mq��	0U�K�L�)B��f�^���L��1�'� ��z��kCU��lÀ}��m�8�{��k��bp\�>�6L�ú�2��l~ U��      �   �   x���v
Q���WH�I,N-�LO�+IU��L�QHKM�H�$g&�(@�t2S�KR��@�@H#���[������������aj���nd`h�kh�k`���PRT
T7Q��\��v�!a7pq �P8      �   �   x�����0�w��6 a �Tb��R>�*�p	PR�����+���r����xۃP}��8�4<���2�4��]���l����5[O������6��޽qQ�pcr�$e�A,�g�>p�b:��fm/Th%IA^��)�s$��WM]1PNp�p�hB����K_�(� )\�      �   �   x���=�0�w�m*$�M�t�� ���݃�6?����Zp�Z8��}��'/��ZC^�����f�ڗ��w��0���a�ԯ�I����]��|�f��n��2�n��*�B<(�&\�ʦ(��K�B�d�4�)����&G����C��dH�$)�0���^�      �   
   x���          �     x��ԿN�0�=Oq[[)��1�\9v�?��5���2�32����a�
v��t��3�*L	��q:�y�a���o,��/�W�|t��jX�V5�� _�@��}���]���*�|���͛h�F�P+���Uѳ8vȹ��6�+�Gk,��c�EoK�c8�N��&Nӱ��ك�P��(�Mr�Y�?3`d�8��eX��j(6`��^��F5*.3��T�Ce�d�l/���~����:�#Ɗ+�����/\oE��7�E�癪.      �   
   x���          �   k   x���v
Q���W(H�,V��L��4�}B]�4u���]�B<��5��<��d�����C�c�gOWb5� 589��:F����5��,�.. �D�      �   �   x���A�@E���; a�.]U�1M��<��$
�,�nX�����$�ES7��	Ej+h��cN�'�C����]	7�(v�hjv����,MTc�*����^AMhP�Å	ڵ�WoV��D}"�l,�Kȝ5���܅�^"���,�,�ryZ�      �   
   x���          �   �   x���͊�0��}��S!��mjʬ�袃S�V�b�2ڤX>�IA8p~��W�ǲi���=L�6;�`�����0�v�E����U�h�ݯ֍כ!p7���j�F�p��L
��y����Ta�)�աl��ʇ�[^$,dV�4��+�ߓ��gY�y�?����o#��ܵr�I��B��i�hL���d�Vv�Ms�=6�`G���gv      �   j   x���v
Q���W((�OK-���K�Q��M,)�L.�I�QH�����KL��Q(�,)�ҙ)H�5�}B]�4ԍLM,�u�s�Su�]��C�������\\\ �"      �   7  x���=O�0@�����J�����\�#�g�,] 1�320��ǈ�
�c��|'?Ǹ@����������xx���i����;�B��f[!��a
��uf&��Pb�����:�7X���و�V�t�"��ِ���/���Ոw&���*b��%�A2���y��j0Ԟ[;䩝F�W����a�i�^q6��ੜ�\���<�&�4�$�쿹�[��)\Gr+��S��T8ڱ���܀6jfߌ��FP1{�:�V��?��P����WP�_�p�;Y�IsE�7b��S�4�Tb�R��c��,��Ԅ      �   
   x���          �   
   x���          �   
   x���             
   x���          �   z  x�͙�N�@��y��R�'����me�Z�vD{CU9�������ɋuvm�"hU�AD������s�J;��P�4b��~��Yݮ���j(��7��շ���z(��.7�X]]^�.��7��#���B'�d6]��`f"Ǐ�
	�:SR#P���hYYg=[�,���"�_}(���4;�1�tD8 -���8�oi�GDθ�G)��e����j�/��
�2�_�ο��#����vc�>C���ރ(��0�_�@�� p�-��Y�E	�E������#��p�D�E��B*R%Kz�
��0G�C�d$=��������Φ!�I@+�Ҵ01)��.��y��5��P.$��fH(qn��P���\1h�dL�Y�BФM<�W��w�H+�"����T�uJ���͜��q�8�ш�����+R��
{A�Y��6��T��V�����d���;������ a��� �k���Yf�����|tR+#פ�0|%+��IQ�~�ah.��|�:TH�v�4;�t�B���M�1�f�/[�F�Io��`�cb)Q�v����D$+���׊ġ�P���K��"���._T=i�J�H��,���[թ��%�_�1�\�W�onY8ǿf��Kz	EN�C�4���g�\Q��C}�(fn����0R�RmR4�u�Y *h��G5���v{���a0͋�0� ��} �hs%+��>	���}��7�����_�X#���D	���ݮ9a��5_�����f���9�����{a�b���SS>�q�f�ُ�>�3��$ڪ��Iv�gP����|0������5M���w�焉5�k���5�f¨�w��[�V#�3��?��D{�����p����_0���      �   I   x���v
Q���W(N��W��L��4�}B]�4u�}��C}<���5��<��d��������� X�      �   �   x��̽
�0�=OqG�_��N!���:�T���.y�{��<ωb�t��^���HZ?u�{Y����������a�NI�sJ������C�C�y�v�0�X���� �<|;<��GhG ���KˊN      �   
   x���          �   p   x���v
Q���W(�,�O�-�IML�W��L�QH�O�L��Q���M*J�Ts�	uV�0�QP7400TҮ�>��.���\�d�f4����dZ@���k������@.. /-{      �   
   x���          �   
   x���          �   
   x���              �   x����
�@�Oqv)���ƊV!��(/�'��VOҮ���Ri�t�������<J@I�F�5�*#��T��jU]������y\e���^[p��R��lgYܺ'3��~���0�Z��|j�8=��(bl��F��l�i ���CBts�������~�h��}�{m�	�"L7	� 	�v%������$,'Z`+m�9�����A�-�0��a��0�7B5�H         �   x�5˻�0�ᝧ8��t(ʥ�ɡ�����b��J��׷n���E�Ⱥ��j���Wm!�2z�3��H�h��`�S�������ŐgO=�3����da�������ʒ��r��|�|�}�TωP`�3��C�q&��(�{oR�� �WY1�         C   x���v
Q���W(-.M,�̏/H-J��QЀ�3St b��@��B��O�k���������5 mrL     