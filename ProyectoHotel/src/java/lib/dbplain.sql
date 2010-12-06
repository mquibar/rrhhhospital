--
-- PostgreSQL database dump
--

-- Started on 2010-12-06 17:08:26

SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = off;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET escape_string_warning = off;

--
-- TOC entry 403 (class 2612 OID 16386)
-- Name: plpgsql; Type: PROCEDURAL LANGUAGE; Schema: -; Owner: postgres
--

CREATE PROCEDURAL LANGUAGE plpgsql;


ALTER PROCEDURAL LANGUAGE plpgsql OWNER TO postgres;

SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 1590 (class 1259 OID 44403)
-- Dependencies: 3
-- Name: agrupamiento; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE agrupamiento (
    id integer NOT NULL,
    eliminado boolean NOT NULL,
    nombre character varying(255) NOT NULL
);


ALTER TABLE public.agrupamiento OWNER TO postgres;

--
-- TOC entry 1623 (class 1259 OID 44762)
-- Dependencies: 3
-- Name: agrupamiento_id_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE agrupamiento_id_sequence
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.agrupamiento_id_sequence OWNER TO postgres;

--
-- TOC entry 2057 (class 0 OID 0)
-- Dependencies: 1623
-- Name: agrupamiento_id_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('agrupamiento_id_sequence', 3, true);


--
-- TOC entry 1591 (class 1259 OID 44408)
-- Dependencies: 3
-- Name: asignacionhorario; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE asignacionhorario (
    id integer NOT NULL,
    descripcion character varying(255),
    fecha date,
    vigente boolean NOT NULL,
    idempleado integer NOT NULL,
    idtipohorario integer NOT NULL
);


ALTER TABLE public.asignacionhorario OWNER TO postgres;

--
-- TOC entry 1624 (class 1259 OID 44764)
-- Dependencies: 3
-- Name: asignacionhorario_id_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE asignacionhorario_id_sequence
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.asignacionhorario_id_sequence OWNER TO postgres;

--
-- TOC entry 2058 (class 0 OID 0)
-- Dependencies: 1624
-- Name: asignacionhorario_id_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('asignacionhorario_id_sequence', 1, false);


--
-- TOC entry 1592 (class 1259 OID 44413)
-- Dependencies: 3
-- Name: cargo; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE cargo (
    id integer NOT NULL,
    fechavigencia date NOT NULL,
    nombre character varying(255) NOT NULL,
    vigente boolean NOT NULL,
    idempleado integer NOT NULL,
    idpuesto integer NOT NULL
);


ALTER TABLE public.cargo OWNER TO postgres;

--
-- TOC entry 1625 (class 1259 OID 44766)
-- Dependencies: 3
-- Name: cargo_id_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE cargo_id_sequence
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.cargo_id_sequence OWNER TO postgres;

--
-- TOC entry 2059 (class 0 OID 0)
-- Dependencies: 1625
-- Name: cargo_id_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('cargo_id_sequence', 1, false);


--
-- TOC entry 1593 (class 1259 OID 44418)
-- Dependencies: 3
-- Name: categoria; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE categoria (
    id integer NOT NULL,
    cupo integer,
    elimininado boolean,
    nombre character varying(255) NOT NULL,
    numero integer,
    idtramo integer NOT NULL
);


ALTER TABLE public.categoria OWNER TO postgres;

--
-- TOC entry 1626 (class 1259 OID 44768)
-- Dependencies: 3
-- Name: categoria_id_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE categoria_id_sequence
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.categoria_id_sequence OWNER TO postgres;

--
-- TOC entry 2060 (class 0 OID 0)
-- Dependencies: 1626
-- Name: categoria_id_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('categoria_id_sequence', 7, true);


--
-- TOC entry 1594 (class 1259 OID 44423)
-- Dependencies: 3
-- Name: clase; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE clase (
    id integer NOT NULL,
    nombre character varying(255) NOT NULL
);


ALTER TABLE public.clase OWNER TO postgres;

--
-- TOC entry 1627 (class 1259 OID 44770)
-- Dependencies: 3
-- Name: clase_id_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE clase_id_sequence
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.clase_id_sequence OWNER TO postgres;

--
-- TOC entry 2061 (class 0 OID 0)
-- Dependencies: 1627
-- Name: clase_id_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('clase_id_sequence', 1, false);


--
-- TOC entry 1595 (class 1259 OID 44428)
-- Dependencies: 3
-- Name: clasecontenida; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE clasecontenida (
    id integer NOT NULL,
    antiguedadminima integer,
    inicial boolean,
    numeroindice integer,
    idcategoria integer NOT NULL,
    idclase integer NOT NULL
);


ALTER TABLE public.clasecontenida OWNER TO postgres;

--
-- TOC entry 1628 (class 1259 OID 44772)
-- Dependencies: 3
-- Name: clasecontenida_id_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE clasecontenida_id_sequence
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.clasecontenida_id_sequence OWNER TO postgres;

--
-- TOC entry 2062 (class 0 OID 0)
-- Dependencies: 1628
-- Name: clasecontenida_id_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('clasecontenida_id_sequence', 5, true);


--
-- TOC entry 1596 (class 1259 OID 44433)
-- Dependencies: 3
-- Name: clasevigente; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE clasevigente (
    id integer NOT NULL,
    fechavigencia date NOT NULL,
    vigente boolean NOT NULL,
    idcategoria integer NOT NULL,
    idclase integer NOT NULL,
    idempleado integer NOT NULL
);


ALTER TABLE public.clasevigente OWNER TO postgres;

--
-- TOC entry 1629 (class 1259 OID 44774)
-- Dependencies: 3
-- Name: clasevigente_id_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE clasevigente_id_sequence
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.clasevigente_id_sequence OWNER TO postgres;

--
-- TOC entry 2063 (class 0 OID 0)
-- Dependencies: 1629
-- Name: clasevigente_id_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('clasevigente_id_sequence', 1, true);


--
-- TOC entry 1597 (class 1259 OID 44438)
-- Dependencies: 3
-- Name: domicilio; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE domicilio (
    id integer NOT NULL,
    barrio character varying(255),
    calle character varying(255),
    departamento character varying(255),
    numero integer,
    piso character varying(255),
    idlocalidad integer NOT NULL,
    idprovincia integer NOT NULL
);


ALTER TABLE public.domicilio OWNER TO postgres;

--
-- TOC entry 1630 (class 1259 OID 44776)
-- Dependencies: 3
-- Name: domicilio_id_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE domicilio_id_sequence
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.domicilio_id_sequence OWNER TO postgres;

--
-- TOC entry 2064 (class 0 OID 0)
-- Dependencies: 1630
-- Name: domicilio_id_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('domicilio_id_sequence', 1, true);


--
-- TOC entry 1598 (class 1259 OID 44446)
-- Dependencies: 3
-- Name: empleado; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE empleado (
    cuil character varying(255),
    eliminado boolean,
    fechaingreso date,
    legajo integer NOT NULL,
    idempleado integer NOT NULL,
    idtarjeta integer NOT NULL,
    idtipoempleado integer NOT NULL
);


ALTER TABLE public.empleado OWNER TO postgres;

--
-- TOC entry 1631 (class 1259 OID 44778)
-- Dependencies: 3
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.hibernate_sequence OWNER TO postgres;

--
-- TOC entry 2065 (class 0 OID 0)
-- Dependencies: 1631
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('hibernate_sequence', 1, false);


--
-- TOC entry 1599 (class 1259 OID 44451)
-- Dependencies: 3
-- Name: licencia; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE licencia (
    id integer NOT NULL,
    eliminada boolean,
    fechafin date NOT NULL,
    fechainicio date NOT NULL,
    motivo character varying(255),
    idempleado integer NOT NULL,
    idtipolicencia integer NOT NULL
);


ALTER TABLE public.licencia OWNER TO postgres;

--
-- TOC entry 1632 (class 1259 OID 44780)
-- Dependencies: 3
-- Name: licencia_id_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE licencia_id_sequence
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.licencia_id_sequence OWNER TO postgres;

--
-- TOC entry 2066 (class 0 OID 0)
-- Dependencies: 1632
-- Name: licencia_id_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('licencia_id_sequence', 1, false);


--
-- TOC entry 1600 (class 1259 OID 44456)
-- Dependencies: 3
-- Name: localidad; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE localidad (
    id integer NOT NULL,
    localidad character varying(255) NOT NULL,
    idpovincia integer NOT NULL
);


ALTER TABLE public.localidad OWNER TO postgres;

--
-- TOC entry 1601 (class 1259 OID 44461)
-- Dependencies: 3
-- Name: operacion; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE operacion (
    id integer NOT NULL,
    description character varying(255),
    nombre character varying(255)
);


ALTER TABLE public.operacion OWNER TO postgres;

--
-- TOC entry 1602 (class 1259 OID 44469)
-- Dependencies: 3
-- Name: pais; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE pais (
    id integer NOT NULL,
    pais character varying(255) NOT NULL
);


ALTER TABLE public.pais OWNER TO postgres;

--
-- TOC entry 1633 (class 1259 OID 44782)
-- Dependencies: 3
-- Name: pais_id_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE pais_id_sequence
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.pais_id_sequence OWNER TO postgres;

--
-- TOC entry 2067 (class 0 OID 0)
-- Dependencies: 1633
-- Name: pais_id_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('pais_id_sequence', 1, false);


--
-- TOC entry 1603 (class 1259 OID 44474)
-- Dependencies: 3
-- Name: perfil; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE perfil (
    id integer NOT NULL,
    description character varying(255),
    nombre character varying(255)
);


ALTER TABLE public.perfil OWNER TO postgres;

--
-- TOC entry 1604 (class 1259 OID 44482)
-- Dependencies: 3
-- Name: perfil_operacion; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE perfil_operacion (
    perfil_id integer NOT NULL,
    operaciones_id integer NOT NULL
);


ALTER TABLE public.perfil_operacion OWNER TO postgres;

--
-- TOC entry 1605 (class 1259 OID 44485)
-- Dependencies: 3
-- Name: persona; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE persona (
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


ALTER TABLE public.persona OWNER TO postgres;

--
-- TOC entry 1634 (class 1259 OID 44784)
-- Dependencies: 3
-- Name: persona_id_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE persona_id_sequence
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.persona_id_sequence OWNER TO postgres;

--
-- TOC entry 2068 (class 0 OID 0)
-- Dependencies: 1634
-- Name: persona_id_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('persona_id_sequence', 1, true);


--
-- TOC entry 1606 (class 1259 OID 44493)
-- Dependencies: 3
-- Name: profesional; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE profesional (
    matricula character varying(255) NOT NULL,
    eliminado boolean NOT NULL,
    titulo character varying(255),
    idprofesional integer NOT NULL
);


ALTER TABLE public.profesional OWNER TO postgres;

--
-- TOC entry 1607 (class 1259 OID 44501)
-- Dependencies: 3
-- Name: provincia; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE provincia (
    id integer NOT NULL,
    provincia character varying(255) NOT NULL
);


ALTER TABLE public.provincia OWNER TO postgres;

--
-- TOC entry 1635 (class 1259 OID 44786)
-- Dependencies: 3
-- Name: provincia_id_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE provincia_id_sequence
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.provincia_id_sequence OWNER TO postgres;

--
-- TOC entry 2069 (class 0 OID 0)
-- Dependencies: 1635
-- Name: provincia_id_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('provincia_id_sequence', 1, false);


--
-- TOC entry 1636 (class 1259 OID 44788)
-- Dependencies: 3
-- Name: puesto_gerarquico_id_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE puesto_gerarquico_id_sequence
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.puesto_gerarquico_id_sequence OWNER TO postgres;

--
-- TOC entry 2070 (class 0 OID 0)
-- Dependencies: 1636
-- Name: puesto_gerarquico_id_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('puesto_gerarquico_id_sequence', 1, false);


--
-- TOC entry 1608 (class 1259 OID 44506)
-- Dependencies: 3
-- Name: puestojerarquico; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE puestojerarquico (
    id integer NOT NULL,
    nombre character varying(255) NOT NULL,
    idpuesto integer
);


ALTER TABLE public.puestojerarquico OWNER TO postgres;

--
-- TOC entry 1637 (class 1259 OID 44790)
-- Dependencies: 3
-- Name: registro_periodo_id_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE registro_periodo_id_sequence
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.registro_periodo_id_sequence OWNER TO postgres;

--
-- TOC entry 2071 (class 0 OID 0)
-- Dependencies: 1637
-- Name: registro_periodo_id_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('registro_periodo_id_sequence', 1, false);


--
-- TOC entry 1638 (class 1259 OID 44792)
-- Dependencies: 3
-- Name: registro_reloj_id_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE registro_reloj_id_sequence
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.registro_reloj_id_sequence OWNER TO postgres;

--
-- TOC entry 2072 (class 0 OID 0)
-- Dependencies: 1638
-- Name: registro_reloj_id_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('registro_reloj_id_sequence', 1, false);


--
-- TOC entry 1609 (class 1259 OID 44511)
-- Dependencies: 3
-- Name: registroperiodo; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE registroperiodo (
    id integer NOT NULL,
    eliminado boolean NOT NULL,
    fechaentrada date NOT NULL,
    fechasalida date NOT NULL,
    horaentrada time without time zone NOT NULL,
    horasalida time without time zone NOT NULL,
    idempleado integer NOT NULL
);


ALTER TABLE public.registroperiodo OWNER TO postgres;

--
-- TOC entry 1610 (class 1259 OID 44516)
-- Dependencies: 3
-- Name: registroreloj; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE registroreloj (
    id integer NOT NULL,
    eliminado boolean NOT NULL,
    fecha date NOT NULL,
    hora time without time zone NOT NULL,
    idempleado integer NOT NULL,
    numero bigint NOT NULL,
    idtiporegistro integer NOT NULL
);


ALTER TABLE public.registroreloj OWNER TO postgres;

--
-- TOC entry 1622 (class 1259 OID 44589)
-- Dependencies: 3
-- Name: relacion; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE relacion (
    idtipolicencia integer NOT NULL,
    idtipoempleado integer NOT NULL
);


ALTER TABLE public.relacion OWNER TO postgres;

--
-- TOC entry 1611 (class 1259 OID 44521)
-- Dependencies: 3
-- Name: requisito; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE requisito (
    id integer NOT NULL,
    descripcion character varying(255) NOT NULL,
    numero integer,
    idcategoria integer NOT NULL
);


ALTER TABLE public.requisito OWNER TO postgres;

--
-- TOC entry 1639 (class 1259 OID 44794)
-- Dependencies: 3
-- Name: requisito_id_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE requisito_id_sequence
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.requisito_id_sequence OWNER TO postgres;

--
-- TOC entry 2073 (class 0 OID 0)
-- Dependencies: 1639
-- Name: requisito_id_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('requisito_id_sequence', 5, true);


--
-- TOC entry 1612 (class 1259 OID 44526)
-- Dependencies: 3
-- Name: sexo; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE sexo (
    id integer NOT NULL,
    sexo character varying(255) NOT NULL
);


ALTER TABLE public.sexo OWNER TO postgres;

--
-- TOC entry 1640 (class 1259 OID 44796)
-- Dependencies: 3
-- Name: sexo_id_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE sexo_id_sequence
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.sexo_id_sequence OWNER TO postgres;

--
-- TOC entry 2074 (class 0 OID 0)
-- Dependencies: 1640
-- Name: sexo_id_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('sexo_id_sequence', 1, false);


--
-- TOC entry 1613 (class 1259 OID 44531)
-- Dependencies: 3
-- Name: tarjeta; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE tarjeta (
    id integer NOT NULL,
    eliminada boolean,
    numero bigint NOT NULL
);


ALTER TABLE public.tarjeta OWNER TO postgres;

--
-- TOC entry 1641 (class 1259 OID 44798)
-- Dependencies: 3
-- Name: tarjeta_id_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE tarjeta_id_sequence
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.tarjeta_id_sequence OWNER TO postgres;

--
-- TOC entry 2075 (class 0 OID 0)
-- Dependencies: 1641
-- Name: tarjeta_id_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('tarjeta_id_sequence', 1, false);


--
-- TOC entry 1614 (class 1259 OID 44536)
-- Dependencies: 3
-- Name: tipocarga; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE tipocarga (
    dtype character varying(31) NOT NULL,
    id integer NOT NULL,
    descripcion character varying(255),
    nombre character varying(255) NOT NULL
);


ALTER TABLE public.tipocarga OWNER TO postgres;

--
-- TOC entry 1642 (class 1259 OID 44800)
-- Dependencies: 3
-- Name: tipocarga_id_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE tipocarga_id_sequence
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.tipocarga_id_sequence OWNER TO postgres;

--
-- TOC entry 2076 (class 0 OID 0)
-- Dependencies: 1642
-- Name: tipocarga_id_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('tipocarga_id_sequence', 1, false);


--
-- TOC entry 1615 (class 1259 OID 44544)
-- Dependencies: 3
-- Name: tipoempleado; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE tipoempleado (
    id integer NOT NULL,
    codigo character varying(255),
    nombre character varying(255) NOT NULL
);


ALTER TABLE public.tipoempleado OWNER TO postgres;

--
-- TOC entry 1643 (class 1259 OID 44802)
-- Dependencies: 3
-- Name: tipoempleado_id_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE tipoempleado_id_sequence
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.tipoempleado_id_sequence OWNER TO postgres;

--
-- TOC entry 2077 (class 0 OID 0)
-- Dependencies: 1643
-- Name: tipoempleado_id_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('tipoempleado_id_sequence', 1, false);


--
-- TOC entry 1616 (class 1259 OID 44552)
-- Dependencies: 3
-- Name: tipohorario; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE tipohorario (
    id integer NOT NULL,
    descripcion character varying(255),
    eliminado boolean,
    horaingreso time without time zone NOT NULL,
    horasalida time without time zone NOT NULL,
    nombre character varying(255) NOT NULL
);


ALTER TABLE public.tipohorario OWNER TO postgres;

--
-- TOC entry 1644 (class 1259 OID 44804)
-- Dependencies: 3
-- Name: tipohorario_id_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE tipohorario_id_sequence
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.tipohorario_id_sequence OWNER TO postgres;

--
-- TOC entry 2078 (class 0 OID 0)
-- Dependencies: 1644
-- Name: tipohorario_id_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('tipohorario_id_sequence', 1, false);


--
-- TOC entry 1617 (class 1259 OID 44560)
-- Dependencies: 3
-- Name: tipolicencia; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE tipolicencia (
    id integer NOT NULL,
    descripcion character varying(255),
    eliminado boolean NOT NULL,
    nombre character varying(255) NOT NULL
);


ALTER TABLE public.tipolicencia OWNER TO postgres;

--
-- TOC entry 1645 (class 1259 OID 44806)
-- Dependencies: 3
-- Name: tipolicencia_id_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE tipolicencia_id_sequence
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.tipolicencia_id_sequence OWNER TO postgres;

--
-- TOC entry 2079 (class 0 OID 0)
-- Dependencies: 1645
-- Name: tipolicencia_id_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('tipolicencia_id_sequence', 1, false);


--
-- TOC entry 1618 (class 1259 OID 44568)
-- Dependencies: 3
-- Name: tiporegistro; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE tiporegistro (
    dtype character varying(31) NOT NULL,
    id integer NOT NULL
);


ALTER TABLE public.tiporegistro OWNER TO postgres;

--
-- TOC entry 1619 (class 1259 OID 44573)
-- Dependencies: 3
-- Name: tramo; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE tramo (
    id integer NOT NULL,
    eliminado boolean,
    nombre character varying(255) NOT NULL,
    idagrupamiento integer NOT NULL
);


ALTER TABLE public.tramo OWNER TO postgres;

--
-- TOC entry 1646 (class 1259 OID 44808)
-- Dependencies: 3
-- Name: tramo_id_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE tramo_id_sequence
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.tramo_id_sequence OWNER TO postgres;

--
-- TOC entry 2080 (class 0 OID 0)
-- Dependencies: 1646
-- Name: tramo_id_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('tramo_id_sequence', 3, true);


--
-- TOC entry 1620 (class 1259 OID 44578)
-- Dependencies: 3
-- Name: usuario; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE usuario (
    id integer NOT NULL,
    eliminado boolean NOT NULL,
    fechaalta date,
    nombre character varying(255),
    password character varying(255),
    empleado_idempleado integer
);


ALTER TABLE public.usuario OWNER TO postgres;

--
-- TOC entry 1647 (class 1259 OID 44810)
-- Dependencies: 3
-- Name: usuario_id_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE usuario_id_sequence
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.usuario_id_sequence OWNER TO postgres;

--
-- TOC entry 2081 (class 0 OID 0)
-- Dependencies: 1647
-- Name: usuario_id_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('usuario_id_sequence', 1, true);


--
-- TOC entry 1621 (class 1259 OID 44586)
-- Dependencies: 3
-- Name: usuario_perfil; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE usuario_perfil (
    usuario_id integer NOT NULL,
    perfiles_id integer NOT NULL
);


ALTER TABLE public.usuario_perfil OWNER TO postgres;

--
-- TOC entry 2019 (class 0 OID 44403)
-- Dependencies: 1590
-- Data for Name: agrupamiento; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY agrupamiento (id, eliminado, nombre) FROM stdin;
50	f	ADMINISTRATIVO Y TÉCNICO
100	f	ENFERMERÍA Y TÉCNICO ASISTENCIAL
150	f	PROFESIONAL
151	f	PROFESIONAL ASISTENCIAL Y SANITARIO
152	f	SERVICIOS GENERALES
153	f	MANTENIMIENTO Y PRODUCCIÓN
154	f	ASISTENCIA A LA ANCIANIDAD, MINORIDAD Y DISCAPACITADOS
155	f	SISTEMATIZACIÓN DE DATOS
\.


--
-- TOC entry 2020 (class 0 OID 44408)
-- Dependencies: 1591
-- Data for Name: asignacionhorario; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY asignacionhorario (id, descripcion, fecha, vigente, idempleado, idtipohorario) FROM stdin;
\.


--
-- TOC entry 2021 (class 0 OID 44413)
-- Dependencies: 1592
-- Data for Name: cargo; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY cargo (id, fechavigencia, nombre, vigente, idempleado, idpuesto) FROM stdin;
\.


--
-- TOC entry 2022 (class 0 OID 44418)
-- Dependencies: 1593
-- Data for Name: categoria; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY categoria (id, cupo, elimininado, nombre, numero, idtramo) FROM stdin;
1	10	f	AYUDANTE	1	50
51	5	f	ENCARGADO	1	100
52	5	f	JEFE DE SECCIÓN	2	100
200	2	f	JEFE DE DIVISIÓN	3	100
201	2	f	JEFE DE DEPARTAMENTO	4	100
250	1	f	SUBDIRECTOR	1	101
251	1	f	SECRETARIO GENERAL	2	101
252	2	f	ENCARGADO	1	151
253	2	f	JEFE DE UNIDAD	2	151
254	5	f	AUXILIAR DE ENFERMERÍA	1	150
255	1	f	AUXILIAR TÉCNICO Y TÉCNICO ASISTENCIAL	2	150
256	1	f	ENFERMERO	3	150
257	2	f	LICENCIADO EN ENFERMERÍA	4	150
258	1	f	SUPERVISOR DE ENFERMERÍA	3	151
259	1	f	JEFE DE SERVICIO DE ENFERMERÍA	4	151
260	1	f	REFERENTE REGIONAL DE ENFERMERÍA	1	152
261	1	f	JEFE DE DEPARTAMENTO DE ENFERMERÍA (NIVEL CENTRAL)	2	152
262	1	f	SUBDIRECTOR DE ENFERMERÍA	3	152
50	9	f	AUXILIAR	2	50
300	10	f	PLANES MENORES A 5 AÑOS	\N	153
301	10	f	PLANES MAYORES A 5 AÑOS	\N	153
350	10	f	PLANES MAYORES A 5 AÑOS	\N	154
351	10	f	PLANES MENORES A 4 AÑOS	\N	154
352	5	f	AYUDANTE	\N	155
353	5	f	AUXILIAR	\N	155
\.


--
-- TOC entry 2023 (class 0 OID 44423)
-- Dependencies: 1594
-- Data for Name: clase; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY clase (id, nombre) FROM stdin;
1	CLASE01
2	CLASE02
3	CLASE03
4	CLASE04
5	CLASE05
6	CLASE06
7	CLASE07
8	CLASE08
9	CLASE09
10	CLASE10
11	CLASE11
12	CLASE12
13	CLASE13
14	CLASE14
15	CLASE15
16	CLASE16
17	CLASE17
\.


--
-- TOC entry 2024 (class 0 OID 44428)
-- Dependencies: 1595
-- Data for Name: clasecontenida; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY clasecontenida (id, antiguedadminima, inicial, numeroindice, idcategoria, idclase) FROM stdin;
50	0	t	1	50	4
51	1	\N	2	50	5
52	2	\N	3	50	6
53	3	\N	4	50	7
54	4	\N	5	50	8
55	5	\N	6	50	9
56	6	\N	7	50	10
57	0	t	1	1	3
58	1	\N	2	1	4
59	2	\N	3	1	5
60	3	\N	4	1	6
61	4	\N	5	1	7
62	5	\N	6	1	8
63	6	\N	7	1	9
100	0	t	1	200	14
101	0	t	1	201	15
102	1	\N	2	201	16
64	0	t	1	51	11
65	1	\N	2	52	12
150	0	t	1	250	17
151	0	t	1	251	16
152	1	\N	2	251	17
153	0	t	1	252	12
154	0	t	1	253	13
155	0	t	1	254	4
156	1	\N	2	254	5
157	2	\N	3	254	6
158	3	\N	4	254	7
159	4	\N	5	254	8
160	5	\N	6	254	9
161	6	\N	7	254	10
162	0	t	1	255	7
163	1	\N	2	255	8
164	2	\N	3	255	9
165	3	\N	4	255	10
166	4	\N	5	255	11
167	5	\N	6	255	12
168	6	\N	7	255	13
169	0	t	1	256	5
170	1	\N	2	256	6
171	2	\N	3	256	7
172	3	\N	4	256	8
173	4	\N	5	256	9
174	5	\N	6	256	10
175	0	t	1	257	13
176	1	\N	2	257	14
177	2	\N	3	257	15
178	3	\N	4	257	16
179	0	t	1	258	14
180	0	t	1	259	15
181	0	t	1	260	16
182	0	t	1	261	16
183	0	t	1	262	17
200	0	t	1	300	13
201	1	\N	2	300	14
202	2	\N	3	300	15
203	0	t	1	300	13
204	1	\N	2	300	14
205	2	\N	3	300	15
250	0	t	1	350	13
251	1	\N	2	350	14
252	2	\N	3	350	15
253	3	\N	4	350	16
254	0	t	1	351	13
255	1	\N	2	351	14
256	2	\N	3	351	15
257	0	t	1	352	1
258	1	\N	2	352	2
259	2	\N	3	352	3
260	3	\N	4	352	4
261	4	\N	5	352	5
262	5	\N	6	352	6
263	6	\N	7	352	7
264	7	\N	8	352	8
265	0	t	1	353	2
266	1	\N	2	353	3
267	2	\N	3	353	4
268	3	\N	4	353	5
269	4	\N	5	353	6
270	5	\N	6	353	7
271	6	\N	7	353	8
272	7	\N	8	353	9
\.


--
-- TOC entry 2025 (class 0 OID 44433)
-- Dependencies: 1596
-- Data for Name: clasevigente; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY clasevigente (id, fechavigencia, vigente, idcategoria, idclase, idempleado) FROM stdin;
50	2010-12-06	t	50	5	50
51	2010-12-06	t	50	5	50
\.


--
-- TOC entry 2026 (class 0 OID 44438)
-- Dependencies: 1597
-- Data for Name: domicilio; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY domicilio (id, barrio, calle, departamento, numero, piso, idlocalidad, idprovincia) FROM stdin;
50	LA ESTANZUELA	SAN MARTIN	5	1	1	3	14
51	BOMBAL	9 DE JULIO	0	126	0	1	14
\.


--
-- TOC entry 2027 (class 0 OID 44446)
-- Dependencies: 1598
-- Data for Name: empleado; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY empleado (cuil, eliminado, fechaingreso, legajo, idempleado, idtarjeta, idtipoempleado) FROM stdin;
20-28245698-6	\N	2010-12-05	0	51	2	2
20-29875921-2	\N	2010-12-05	2566	50	1	1
\.


--
-- TOC entry 2028 (class 0 OID 44451)
-- Dependencies: 1599
-- Data for Name: licencia; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY licencia (id, eliminada, fechafin, fechainicio, motivo, idempleado, idtipolicencia) FROM stdin;
\.


--
-- TOC entry 2029 (class 0 OID 44456)
-- Dependencies: 1600
-- Data for Name: localidad; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY localidad (id, localidad, idpovincia) FROM stdin;
1	CAPITAL	14
2	GENERAL ALVEAR	14
3	GODOY CRUZ	14
4	GUAYMALLÉN	14
5	JUNÍN	14
6	LA PAZ	14
7	LAS HERAS	14
8	LAVALLE	14
9	LUJÁN DE CUYO	14
10	MAIPÚ	14
11	MALARGÜE	14
12	RIVADAVIA	14
13	SAN CARLOS	14
14	SAN MARTÍN	14
15	SAN RAFAEL	14
16	SANTA ROSA	14
17	TUNUYÁN	14
18	TUPUNGATO	14
\.


--
-- TOC entry 2030 (class 0 OID 44461)
-- Dependencies: 1601
-- Data for Name: operacion; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY operacion (id, description, nombre) FROM stdin;
\.


--
-- TOC entry 2031 (class 0 OID 44469)
-- Dependencies: 1602
-- Data for Name: pais; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY pais (id, pais) FROM stdin;
1	ARGENTINA
2	BRASIL
3	CHILE
4	PARAGUAY
5	PERÚ
\.


--
-- TOC entry 2032 (class 0 OID 44474)
-- Dependencies: 1603
-- Data for Name: perfil; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY perfil (id, description, nombre) FROM stdin;
1	ADMINISTRADOR DEL SISTEMA	ADMINISTRADO
2	USUARIO GENERAL DEL SISTEMA	USUARIO
3	EL INTERES DE LA GERENCIA DEBE SER DE REPORTES	GERENCIA
\.


--
-- TOC entry 2033 (class 0 OID 44482)
-- Dependencies: 1604
-- Data for Name: perfil_operacion; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY perfil_operacion (perfil_id, operaciones_id) FROM stdin;
\.


--
-- TOC entry 2034 (class 0 OID 44485)
-- Dependencies: 1605
-- Data for Name: persona; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY persona (id, apellido, dni, fechanacimiento, nombre, telefono, iddomicilio, idpais, idsexo) FROM stdin;
50	PEREZ	29875921	1983-01-01	JUAN	4445566	50	1	1
51	PERALTA	28245698	1980-10-03	MARTIN	4273685	51	1	1
\.


--
-- TOC entry 2035 (class 0 OID 44493)
-- Dependencies: 1606
-- Data for Name: profesional; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY profesional (matricula, eliminado, titulo, idprofesional) FROM stdin;
2549	f	DOCTOR	51
\.


--
-- TOC entry 2036 (class 0 OID 44501)
-- Dependencies: 1607
-- Data for Name: provincia; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY provincia (id, provincia) FROM stdin;
1	BUENOS AIRES
2	CATAMARCA
3	CHACO
4	CHUBUT
6	CORRIENTES
7	CATAMARCA
8	CAPITAL FEDERAL
9	ENTRE RÍOS
10	FORMOSA
11	JUJUY
12	LA PAMPA
13	LA RIOJA
14	MENDOZA
15	MISIONES
5	CÓRDOBA
16	NEUQUÉN
17	RÍO NEGRO
18	SALTA
19	SAN JUAN
20	SAN LUIS
21	SANTA CRUZ
22	SANTA FE
23	SANTIAGO DEL ESTERO
24	TIERRA DEL FUEGO
25	TUCUMÁN
\.


--
-- TOC entry 2037 (class 0 OID 44506)
-- Dependencies: 1608
-- Data for Name: puestojerarquico; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY puestojerarquico (id, nombre, idpuesto) FROM stdin;
\.


--
-- TOC entry 2038 (class 0 OID 44511)
-- Dependencies: 1609
-- Data for Name: registroperiodo; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY registroperiodo (id, eliminado, fechaentrada, fechasalida, horaentrada, horasalida, idempleado) FROM stdin;
\.


--
-- TOC entry 2039 (class 0 OID 44516)
-- Dependencies: 1610
-- Data for Name: registroreloj; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY registroreloj (id, eliminado, fecha, hora, idempleado, numero, idtiporegistro) FROM stdin;
\.


--
-- TOC entry 2051 (class 0 OID 44589)
-- Dependencies: 1622
-- Data for Name: relacion; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY relacion (idtipolicencia, idtipoempleado) FROM stdin;
\.


--
-- TOC entry 2040 (class 0 OID 44521)
-- Dependencies: 1611
-- Data for Name: requisito; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY requisito (id, descripcion, numero, idcategoria) FROM stdin;
157	RESULTAR EL MEJOR CALIFICADO EN EL CONCURSO RESPECTIVO\n	2	252
159	RESULTAR EL MEJOR CALIFICADO EN EL CONCURSO RESPECTIVO\n\n	2	253
160	ACREDITAR SEGÚN LOS CASOS, EL TÍTULO DE NIVEL TERCIARIO O UNIVERSITARIO DE LICENCIADO EN ENFERMERÍA PARA OPTAR AL CARGO\n	1	254
161	ACREDITAR SEGÚN LOS CASOS, EL TÍTULO DE NIVEL TERCIARIO O UNIVERSITARIO DE LICENCIADO EN ENFERMERÍA PARA OPTAR AL CARGO\n	1	255
165	APROBADO CURSOS DE LA ESPECIALIDAD DICTADOS POR ESCUELAS RECONOCIDAS POR EL ESTADO	1	257
176	REUNIR LAS CONDICIONES EXIGIDAS PARA REVISTAR EN LA CATEGORÍA AUXILIAR\n\n	1	52
177	RESULTAR EL MEJOR CALIFICADO EN EL CONCURSO RESPECTIVO\n\n	2	52
200	POSEAN TÍTULO CON PLANES DE ESTUDIO DE CINCO O MAS AÑOS	1	300
201	MEJOR CALIFICADO EN EL CONCURSO RESPECTIVO	2	300
202	PLANES DE ESTUDIO MENORES DE CINCO AÑOS	1	300
203	MEJOR CALIFICADO EN EL CONCURSO RESPECTIVO	2	300
250	PLANES DE ESTUDIO DE CINCO (5) AÑOS O MAS AÑOS	1	350
251	MEJOR CALIFICADO EN EL CONCURSO RESPECTIVO	2	350
252	MEJOR CALIFICADO EN EL CONCURSO RESPECTIVO	1	351
253	POSEAN TÍTULOS CON PLANES DE ESTUDIO MENORES DE CINCO (5) AÑOS 	2	351
254	MEJOR CALIFICADO EN EL CONCURSO RESPECTIVO	1	352
255	CONDICIONES ESTABLECIDAS	2	352
100	REUNIR LAS CONDICIONES EXIGIDAS PARA REVISTAR EN LA CATEGORÍA AUXILIAR	1	200
101	RESULTAR EL MEJOR CALIFICADO EN EL CONCURSO RESPECTIVO	2	200
103	REUNIR LAS CONDICIONES EXIGIDAS PARA REVISTAR EN LA CATEGORÍA AUXILIAR	1	201
104	RESULTAR EL MEJOR CALIFICADO EN EL CONCURSO RESPECTIVO	2	201
58	TENDRÁN LUGAR CUANDO NO EXISTA NINGÚN AGENTE DE CARRERA DE LOS CITADOS MINISTERIOS, EN CONDICIONES DE CUBRIR LA VACANTE\n	3	51
57	RESULTAR EL MEJOR CALIFICADO EN EL CONCURSO RESPECTIVO\n	2	51
56	REUNIR LAS CONDICIONES EXIGIDAS PARA REVISTAR EN LA CATEGORÍA AUXILIAR\n	1	51
55	RESULTAR EL MEJOR CALIFICADO EN EL CONCURSO RESPECTIVO\n	3	1
54	POSEER CONOCIMIENTOS DE MECANOGRAFÍA Y REDACCIÓN ADMINISTRATIVA\n	2	1
53	TENER APROBADO EL CICLO COMPLETO DE ENSEÑANZA SECUNDARIA\n	1	1
52	RESULTAR EL MEJOR CALIFICADO EN EL CONCURSO RESPECTIVO\n	3	50
51	POSEER CONOCIMIENTOS DE MECANOGRAFÍA Y REDACCIÓN ADMINISTRATIVA\n	2	50
50	TENER APROBADO EL CICLO COMPLETO DE ENSEÑANZA SECUNDARIA\n	1	50
150	REUNIR LAS CONDICIONES EXIGIDAS PARA REVISTAR EN LA CATEGORÍA AUXILIAR	1	250
151	RESULTAR EL MEJOR CALIFICADO EN EL CONCURSO RESPECTIVO	2	250
153	REUNIR LAS CONDICIONES EXIGIDAS PARA REVISTAR EN LA CATEGORÍA AUXILIAR	1	251
154	RESULTAR EL MEJOR CALIFICADO EN EL CONCURSO RESPECTIVO	2	251
156	ACREDITAR SEGÚN LOS CASOS, EL TÍTULO DE NIVEL TERCIARIO O UNIVERSITARIO DE LICENCIADO EN ENFERMERÍA PARA OPTAR AL CARGO	1	252
158	ACREDITAR SEGÚN LOS CASOS, EL TÍTULO DE NIVEL TERCIARIO O UNIVERSITARIO DE LICENCIADO EN ENFERMERÍA PARA OPTAR AL CARGO	1	253
162	APROBADO CURSOS DE LA ESPECIALIDAD DICTADOS POR ESCUELAS RECONOCIDAS POR EL ESTADO	1	256
163	RESULTAR EL MEJOR CALIFICADO EN EL CONCURSO RESPECTIVO	2	256
166	ACREDITAR SEGÚN LOS CASOS, EL TÍTULO DE NIVEL TERCIARIO O UNIVERSITARIO DE LICENCIADO EN ENFERMERÍA PARA OPTAR AL CARGO	1	258
167	RESULTAR EL MEJOR CALIFICADO EN EL CONCURSO RESPECTIVO	2	258
168	ACREDITAR SEGÚN LOS CASOS, EL TÍTULO DE NIVEL TERCIARIO O UNIVERSITARIO DE LICENCIADO EN ENFERMERÍA PARA OPTAR AL CARGO	1	259
169	RESULTAR EL MEJOR CALIFICADO EN EL CONCURSO RESPECTIVO	2	259
170	ACREDITAR EL TÍTULO UNIVERSITARIO DE LICENCIADO EN ENFERMERÍA 	1	260
171	RESULTAR EL MEJOR CALIFICADO EN EL CONCURSO RESPECTIVO	2	260
172	ACREDITAR EL TÍTULO UNIVERSITARIO DE LICENCIADO EN ENFERMERÍA 	1	261
173	RESULTAR EL MEJOR CALIFICADO EN EL CONCURSO RESPECTIVO	2	261
174	ACREDITAR EL TÍTULO UNIVERSITARIO DE LICENCIADO EN ENFERMERÍA 	1	262
175	RESULTAR EL MEJOR CALIFICADO EN EL CONCURSO RESPECTIVO	2	262
256	CONDICIONES ESTABLECIDAS 	1	353
257	MEJOR CALIFICADO EN EL CONCURSO RESPECTIVO	2	353
\.


--
-- TOC entry 2041 (class 0 OID 44526)
-- Dependencies: 1612
-- Data for Name: sexo; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY sexo (id, sexo) FROM stdin;
1	MASCULINO
2	FEMENINO
\.


--
-- TOC entry 2042 (class 0 OID 44531)
-- Dependencies: 1613
-- Data for Name: tarjeta; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY tarjeta (id, eliminada, numero) FROM stdin;
1	\N	1001
2	\N	2002
3	\N	3003
4	\N	4004
5	\N	5005
6	\N	6006
7	\N	7007
\.


--
-- TOC entry 2043 (class 0 OID 44536)
-- Dependencies: 1614
-- Data for Name: tipocarga; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY tipocarga (dtype, id, descripcion, nombre) FROM stdin;
\.


--
-- TOC entry 2044 (class 0 OID 44544)
-- Dependencies: 1615
-- Data for Name: tipoempleado; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY tipoempleado (id, codigo, nombre) FROM stdin;
1	1001	EMPLEADO
2	2002	PROFESIONAL
\.


--
-- TOC entry 2045 (class 0 OID 44552)
-- Dependencies: 1616
-- Data for Name: tipohorario; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY tipohorario (id, descripcion, eliminado, horaingreso, horasalida, nombre) FROM stdin;
\.


--
-- TOC entry 2046 (class 0 OID 44560)
-- Dependencies: 1617
-- Data for Name: tipolicencia; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY tipolicencia (id, descripcion, eliminado, nombre) FROM stdin;
\.


--
-- TOC entry 2047 (class 0 OID 44568)
-- Dependencies: 1618
-- Data for Name: tiporegistro; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY tiporegistro (dtype, id) FROM stdin;
\.


--
-- TOC entry 2048 (class 0 OID 44573)
-- Dependencies: 1619
-- Data for Name: tramo; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY tramo (id, eliminado, nombre, idagrupamiento) FROM stdin;
50	f	EJECUCIÓN	50
100	f	SUPERVISIÓN	50
101	f	SUPERIOR	50
151	f	SUPERVISIÓN 	100
150	f	EJECUCIÓN	100
152	f	SUPERIOR	100
153	f	TRAMO ÚNICO	150
154	f	TRAMO ÚNICO	151
155	f	EJECUCIÓN	152
156	f	SUPERVISIÓN	152
157	f	EJECUCIÓN	153
158	f	SUPERVISIÓN	153
159	f	EJECUCIÓN	154
160	f	SUPERVISIÓN	154
161	f	EJECUCIÓN	155
162	f	SUPERVISIÓN	155
\.


--
-- TOC entry 2049 (class 0 OID 44578)
-- Dependencies: 1620
-- Data for Name: usuario; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY usuario (id, eliminado, fechaalta, nombre, password, empleado_idempleado) FROM stdin;
50	f	\N	JPEREZ	827ccb0eea8a706c4c34a16891f84e7b	50
\.


--
-- TOC entry 2050 (class 0 OID 44586)
-- Dependencies: 1621
-- Data for Name: usuario_perfil; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY usuario_perfil (usuario_id, perfiles_id) FROM stdin;
50	1
\.


--
-- TOC entry 1926 (class 2606 OID 44407)
-- Dependencies: 1590 1590
-- Name: agrupamiento_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY agrupamiento
    ADD CONSTRAINT agrupamiento_pkey PRIMARY KEY (id);


--
-- TOC entry 1928 (class 2606 OID 44412)
-- Dependencies: 1591 1591
-- Name: asignacionhorario_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY asignacionhorario
    ADD CONSTRAINT asignacionhorario_pkey PRIMARY KEY (id);


--
-- TOC entry 1930 (class 2606 OID 44417)
-- Dependencies: 1592 1592
-- Name: cargo_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY cargo
    ADD CONSTRAINT cargo_pkey PRIMARY KEY (id);


--
-- TOC entry 1932 (class 2606 OID 44422)
-- Dependencies: 1593 1593
-- Name: categoria_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY categoria
    ADD CONSTRAINT categoria_pkey PRIMARY KEY (id);


--
-- TOC entry 1934 (class 2606 OID 44427)
-- Dependencies: 1594 1594
-- Name: clase_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY clase
    ADD CONSTRAINT clase_pkey PRIMARY KEY (id);


--
-- TOC entry 1936 (class 2606 OID 44432)
-- Dependencies: 1595 1595
-- Name: clasecontenida_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY clasecontenida
    ADD CONSTRAINT clasecontenida_pkey PRIMARY KEY (id);


--
-- TOC entry 1938 (class 2606 OID 44437)
-- Dependencies: 1596 1596
-- Name: clasevigente_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY clasevigente
    ADD CONSTRAINT clasevigente_pkey PRIMARY KEY (id);


--
-- TOC entry 1940 (class 2606 OID 44445)
-- Dependencies: 1597 1597
-- Name: domicilio_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY domicilio
    ADD CONSTRAINT domicilio_pkey PRIMARY KEY (id);


--
-- TOC entry 1942 (class 2606 OID 44450)
-- Dependencies: 1598 1598
-- Name: empleado_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY empleado
    ADD CONSTRAINT empleado_pkey PRIMARY KEY (idempleado);


--
-- TOC entry 1944 (class 2606 OID 44455)
-- Dependencies: 1599 1599
-- Name: licencia_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY licencia
    ADD CONSTRAINT licencia_pkey PRIMARY KEY (id);


--
-- TOC entry 1946 (class 2606 OID 44460)
-- Dependencies: 1600 1600
-- Name: localidad_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY localidad
    ADD CONSTRAINT localidad_pkey PRIMARY KEY (id);


--
-- TOC entry 1948 (class 2606 OID 44468)
-- Dependencies: 1601 1601
-- Name: operacion_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY operacion
    ADD CONSTRAINT operacion_pkey PRIMARY KEY (id);


--
-- TOC entry 1950 (class 2606 OID 44473)
-- Dependencies: 1602 1602
-- Name: pais_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY pais
    ADD CONSTRAINT pais_pkey PRIMARY KEY (id);


--
-- TOC entry 1952 (class 2606 OID 44481)
-- Dependencies: 1603 1603
-- Name: perfil_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY perfil
    ADD CONSTRAINT perfil_pkey PRIMARY KEY (id);


--
-- TOC entry 1954 (class 2606 OID 44492)
-- Dependencies: 1605 1605
-- Name: persona_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY persona
    ADD CONSTRAINT persona_pkey PRIMARY KEY (id);


--
-- TOC entry 1956 (class 2606 OID 44500)
-- Dependencies: 1606 1606
-- Name: profesional_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY profesional
    ADD CONSTRAINT profesional_pkey PRIMARY KEY (idprofesional);


--
-- TOC entry 1958 (class 2606 OID 44505)
-- Dependencies: 1607 1607
-- Name: provincia_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY provincia
    ADD CONSTRAINT provincia_pkey PRIMARY KEY (id);


--
-- TOC entry 1960 (class 2606 OID 44510)
-- Dependencies: 1608 1608
-- Name: puestojerarquico_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY puestojerarquico
    ADD CONSTRAINT puestojerarquico_pkey PRIMARY KEY (id);


--
-- TOC entry 1962 (class 2606 OID 44515)
-- Dependencies: 1609 1609
-- Name: registroperiodo_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY registroperiodo
    ADD CONSTRAINT registroperiodo_pkey PRIMARY KEY (id);


--
-- TOC entry 1964 (class 2606 OID 44520)
-- Dependencies: 1610 1610
-- Name: registroreloj_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY registroreloj
    ADD CONSTRAINT registroreloj_pkey PRIMARY KEY (id);


--
-- TOC entry 1966 (class 2606 OID 44525)
-- Dependencies: 1611 1611
-- Name: requisito_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY requisito
    ADD CONSTRAINT requisito_pkey PRIMARY KEY (id);


--
-- TOC entry 1968 (class 2606 OID 44530)
-- Dependencies: 1612 1612
-- Name: sexo_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY sexo
    ADD CONSTRAINT sexo_pkey PRIMARY KEY (id);


--
-- TOC entry 1970 (class 2606 OID 44535)
-- Dependencies: 1613 1613
-- Name: tarjeta_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY tarjeta
    ADD CONSTRAINT tarjeta_pkey PRIMARY KEY (id);


--
-- TOC entry 1972 (class 2606 OID 44543)
-- Dependencies: 1614 1614
-- Name: tipocarga_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY tipocarga
    ADD CONSTRAINT tipocarga_pkey PRIMARY KEY (id);


--
-- TOC entry 1974 (class 2606 OID 44551)
-- Dependencies: 1615 1615
-- Name: tipoempleado_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY tipoempleado
    ADD CONSTRAINT tipoempleado_pkey PRIMARY KEY (id);


--
-- TOC entry 1976 (class 2606 OID 44559)
-- Dependencies: 1616 1616
-- Name: tipohorario_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY tipohorario
    ADD CONSTRAINT tipohorario_pkey PRIMARY KEY (id);


--
-- TOC entry 1978 (class 2606 OID 44567)
-- Dependencies: 1617 1617
-- Name: tipolicencia_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY tipolicencia
    ADD CONSTRAINT tipolicencia_pkey PRIMARY KEY (id);


--
-- TOC entry 1980 (class 2606 OID 44572)
-- Dependencies: 1618 1618
-- Name: tiporegistro_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY tiporegistro
    ADD CONSTRAINT tiporegistro_pkey PRIMARY KEY (id);


--
-- TOC entry 1982 (class 2606 OID 44577)
-- Dependencies: 1619 1619
-- Name: tramo_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY tramo
    ADD CONSTRAINT tramo_pkey PRIMARY KEY (id);


--
-- TOC entry 1984 (class 2606 OID 44585)
-- Dependencies: 1620 1620
-- Name: usuario_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY usuario
    ADD CONSTRAINT usuario_pkey PRIMARY KEY (id);


--
-- TOC entry 2002 (class 2606 OID 44677)
-- Dependencies: 1957 1600 1607
-- Name: fk2fa5904947b6da30; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY localidad
    ADD CONSTRAINT fk2fa5904947b6da30 FOREIGN KEY (idpovincia) REFERENCES provincia(id);


--
-- TOC entry 2001 (class 2606 OID 44672)
-- Dependencies: 1599 1598 1941
-- Name: fk37fa2ccc1f88b7a8; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY licencia
    ADD CONSTRAINT fk37fa2ccc1f88b7a8 FOREIGN KEY (idempleado) REFERENCES empleado(idempleado);


--
-- TOC entry 2000 (class 2606 OID 44667)
-- Dependencies: 1977 1617 1599
-- Name: fk37fa2ccced4d10f2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY licencia
    ADD CONSTRAINT fk37fa2ccced4d10f2 FOREIGN KEY (idtipolicencia) REFERENCES tipolicencia(id);


--
-- TOC entry 2005 (class 2606 OID 44692)
-- Dependencies: 1949 1605 1602
-- Name: fk3ac8678c789754c8; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY persona
    ADD CONSTRAINT fk3ac8678c789754c8 FOREIGN KEY (idpais) REFERENCES pais(id);


--
-- TOC entry 2007 (class 2606 OID 44702)
-- Dependencies: 1612 1605 1967
-- Name: fk3ac8678c789a30a4; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY persona
    ADD CONSTRAINT fk3ac8678c789a30a4 FOREIGN KEY (idsexo) REFERENCES sexo(id);


--
-- TOC entry 2006 (class 2606 OID 44697)
-- Dependencies: 1597 1605 1939
-- Name: fk3ac8678cb6bef8; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY persona
    ADD CONSTRAINT fk3ac8678cb6bef8 FOREIGN KEY (iddomicilio) REFERENCES domicilio(id);


--
-- TOC entry 1988 (class 2606 OID 44607)
-- Dependencies: 1941 1598 1592
-- Name: fk3ddf79c1f88b7a8; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY cargo
    ADD CONSTRAINT fk3ddf79c1f88b7a8 FOREIGN KEY (idempleado) REFERENCES empleado(idempleado);


--
-- TOC entry 1987 (class 2606 OID 44602)
-- Dependencies: 1592 1608 1959
-- Name: fk3ddf79cc2b1d8b7; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY cargo
    ADD CONSTRAINT fk3ddf79cc2b1d8b7 FOREIGN KEY (idpuesto) REFERENCES puestojerarquico(id);


--
-- TOC entry 1986 (class 2606 OID 44597)
-- Dependencies: 1941 1591 1598
-- Name: fk491c00da1f88b7a8; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY asignacionhorario
    ADD CONSTRAINT fk491c00da1f88b7a8 FOREIGN KEY (idempleado) REFERENCES empleado(idempleado);


--
-- TOC entry 1985 (class 2606 OID 44592)
-- Dependencies: 1591 1975 1616
-- Name: fk491c00dab8a3b4ea; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY asignacionhorario
    ADD CONSTRAINT fk491c00dab8a3b4ea FOREIGN KEY (idtipohorario) REFERENCES tipohorario(id);


--
-- TOC entry 1991 (class 2606 OID 44622)
-- Dependencies: 1931 1593 1595
-- Name: fk4986174152f3ce94; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY clasecontenida
    ADD CONSTRAINT fk4986174152f3ce94 FOREIGN KEY (idcategoria) REFERENCES categoria(id);


--
-- TOC entry 1990 (class 2606 OID 44617)
-- Dependencies: 1595 1933 1594
-- Name: fk4986174198eea602; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY clasecontenida
    ADD CONSTRAINT fk4986174198eea602 FOREIGN KEY (idclase) REFERENCES clase(id);


--
-- TOC entry 1999 (class 2606 OID 44662)
-- Dependencies: 1598 1973 1615
-- Name: fk4af864eb13498130; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY empleado
    ADD CONSTRAINT fk4af864eb13498130 FOREIGN KEY (idtipoempleado) REFERENCES tipoempleado(id);


--
-- TOC entry 1997 (class 2606 OID 44652)
-- Dependencies: 1598 1605 1953
-- Name: fk4af864eb899cc3bb; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY empleado
    ADD CONSTRAINT fk4af864eb899cc3bb FOREIGN KEY (idempleado) REFERENCES persona(id);


--
-- TOC entry 1998 (class 2606 OID 44657)
-- Dependencies: 1613 1969 1598
-- Name: fk4af864ebfabd7bc8; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY empleado
    ADD CONSTRAINT fk4af864ebfabd7bc8 FOREIGN KEY (idtarjeta) REFERENCES tarjeta(id);


--
-- TOC entry 2013 (class 2606 OID 44732)
-- Dependencies: 1619 1925 1590
-- Name: fk4d50265490bd046; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tramo
    ADD CONSTRAINT fk4d50265490bd046 FOREIGN KEY (idagrupamiento) REFERENCES agrupamiento(id);


--
-- TOC entry 2014 (class 2606 OID 44737)
-- Dependencies: 1941 1620 1598
-- Name: fk5b4d8b0e34672f9c; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY usuario
    ADD CONSTRAINT fk5b4d8b0e34672f9c FOREIGN KEY (empleado_idempleado) REFERENCES empleado(idempleado);


--
-- TOC entry 1994 (class 2606 OID 44637)
-- Dependencies: 1596 1598 1941
-- Name: fk78c1ea441f88b7a8; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY clasevigente
    ADD CONSTRAINT fk78c1ea441f88b7a8 FOREIGN KEY (idempleado) REFERENCES empleado(idempleado);


--
-- TOC entry 1993 (class 2606 OID 44632)
-- Dependencies: 1596 1593 1931
-- Name: fk78c1ea4452f3ce94; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY clasevigente
    ADD CONSTRAINT fk78c1ea4452f3ce94 FOREIGN KEY (idcategoria) REFERENCES categoria(id);


--
-- TOC entry 1992 (class 2606 OID 44627)
-- Dependencies: 1594 1596 1933
-- Name: fk78c1ea4498eea602; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY clasevigente
    ADD CONSTRAINT fk78c1ea4498eea602 FOREIGN KEY (idclase) REFERENCES clase(id);


--
-- TOC entry 2003 (class 2606 OID 44682)
-- Dependencies: 1604 1951 1603
-- Name: fk83d14652cc153af; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY perfil_operacion
    ADD CONSTRAINT fk83d14652cc153af FOREIGN KEY (perfil_id) REFERENCES perfil(id);


--
-- TOC entry 2004 (class 2606 OID 44687)
-- Dependencies: 1604 1947 1601
-- Name: fk83d1465c24d77b7; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY perfil_operacion
    ADD CONSTRAINT fk83d1465c24d77b7 FOREIGN KEY (operaciones_id) REFERENCES operacion(id);


--
-- TOC entry 2011 (class 2606 OID 44722)
-- Dependencies: 1618 1610 1979
-- Name: fk869b3ba132c5e000; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY registroreloj
    ADD CONSTRAINT fk869b3ba132c5e000 FOREIGN KEY (idtiporegistro) REFERENCES tiporegistro(id);


--
-- TOC entry 2012 (class 2606 OID 44727)
-- Dependencies: 1593 1611 1931
-- Name: fka106ede352f3ce94; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY requisito
    ADD CONSTRAINT fka106ede352f3ce94 FOREIGN KEY (idcategoria) REFERENCES categoria(id);


--
-- TOC entry 2008 (class 2606 OID 44707)
-- Dependencies: 1941 1598 1606
-- Name: fka69eb0acd3e74193; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY profesional
    ADD CONSTRAINT fka69eb0acd3e74193 FOREIGN KEY (idprofesional) REFERENCES empleado(idempleado);


--
-- TOC entry 1996 (class 2606 OID 44647)
-- Dependencies: 1957 1597 1607
-- Name: fkaba87945570c8388; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY domicilio
    ADD CONSTRAINT fkaba87945570c8388 FOREIGN KEY (idprovincia) REFERENCES provincia(id);


--
-- TOC entry 1995 (class 2606 OID 44642)
-- Dependencies: 1600 1597 1945
-- Name: fkaba879458b0ed00; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY domicilio
    ADD CONSTRAINT fkaba879458b0ed00 FOREIGN KEY (idlocalidad) REFERENCES localidad(id);


--
-- TOC entry 1989 (class 2606 OID 44612)
-- Dependencies: 1619 1593 1981
-- Name: fkd4c701139ad33838; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY categoria
    ADD CONSTRAINT fkd4c701139ad33838 FOREIGN KEY (idtramo) REFERENCES tramo(id);


--
-- TOC entry 2018 (class 2606 OID 44757)
-- Dependencies: 1622 1973 1615
-- Name: fkdeec3fad13498130; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY relacion
    ADD CONSTRAINT fkdeec3fad13498130 FOREIGN KEY (idtipoempleado) REFERENCES tipoempleado(id);


--
-- TOC entry 2017 (class 2606 OID 44752)
-- Dependencies: 1617 1622 1977
-- Name: fkdeec3faded4d10f2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY relacion
    ADD CONSTRAINT fkdeec3faded4d10f2 FOREIGN KEY (idtipolicencia) REFERENCES tipolicencia(id);


--
-- TOC entry 2010 (class 2606 OID 44717)
-- Dependencies: 1941 1609 1598
-- Name: fke34052fb1f88b7a8; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY registroperiodo
    ADD CONSTRAINT fke34052fb1f88b7a8 FOREIGN KEY (idempleado) REFERENCES empleado(idempleado);


--
-- TOC entry 2016 (class 2606 OID 44747)
-- Dependencies: 1951 1621 1603
-- Name: fke578dc3d70230341; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY usuario_perfil
    ADD CONSTRAINT fke578dc3d70230341 FOREIGN KEY (perfiles_id) REFERENCES perfil(id);


--
-- TOC entry 2015 (class 2606 OID 44742)
-- Dependencies: 1620 1983 1621
-- Name: fke578dc3dab7e6425; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY usuario_perfil
    ADD CONSTRAINT fke578dc3dab7e6425 FOREIGN KEY (usuario_id) REFERENCES usuario(id);


--
-- TOC entry 2009 (class 2606 OID 44712)
-- Dependencies: 1608 1608 1959
-- Name: fke9657d7c2b1d8b7; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY puestojerarquico
    ADD CONSTRAINT fke9657d7c2b1d8b7 FOREIGN KEY (idpuesto) REFERENCES puestojerarquico(id);


--
-- TOC entry 2056 (class 0 OID 0)
-- Dependencies: 3
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2010-12-06 17:08:33

--
-- PostgreSQL database dump complete
--

