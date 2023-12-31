PGDMP                         {            oficina    15.3    15.3 "               0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    16398    oficina    DATABASE     ~   CREATE DATABASE oficina WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Portuguese_Brazil.1252';
    DROP DATABASE oficina;
                postgres    false            �            1259    16414    maquina    TABLE     �   CREATE TABLE public.maquina (
    id_maq integer NOT NULL,
    nome_maq character varying(40) NOT NULL,
    descricao character varying(180)
);
    DROP TABLE public.maquina;
       public         heap    postgres    false            �            1259    16413    maquina_id_maq_seq    SEQUENCE     �   CREATE SEQUENCE public.maquina_id_maq_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.maquina_id_maq_seq;
       public          postgres    false    219                       0    0    maquina_id_maq_seq    SEQUENCE OWNED BY     I   ALTER SEQUENCE public.maquina_id_maq_seq OWNED BY public.maquina.id_maq;
          public          postgres    false    218            �            1259    16407    mecanico    TABLE     �   CREATE TABLE public.mecanico (
    id_mec integer NOT NULL,
    nome_func character varying(60) NOT NULL,
    cpf character varying(20)
);
    DROP TABLE public.mecanico;
       public         heap    postgres    false            �            1259    16406    mecanico_id_mec_seq    SEQUENCE     �   CREATE SEQUENCE public.mecanico_id_mec_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 *   DROP SEQUENCE public.mecanico_id_mec_seq;
       public          postgres    false    217                       0    0    mecanico_id_mec_seq    SEQUENCE OWNED BY     K   ALTER SEQUENCE public.mecanico_id_mec_seq OWNED BY public.mecanico.id_mec;
          public          postgres    false    216            �            1259    16422 
   ordem_serv    TABLE     �   CREATE TABLE public.ordem_serv (
    id_ord integer NOT NULL,
    fk_id_maq integer,
    fk_id_mec integer,
    preco_final numeric(10,2),
    data_rec character varying(20),
    data_fim character varying(20)
);
    DROP TABLE public.ordem_serv;
       public         heap    postgres    false            �            1259    16421    ordem_serv_id_ord_seq    SEQUENCE     �   CREATE SEQUENCE public.ordem_serv_id_ord_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ,   DROP SEQUENCE public.ordem_serv_id_ord_seq;
       public          postgres    false    221                        0    0    ordem_serv_id_ord_seq    SEQUENCE OWNED BY     O   ALTER SEQUENCE public.ordem_serv_id_ord_seq OWNED BY public.ordem_serv.id_ord;
          public          postgres    false    220            �            1259    16400    usuario    TABLE     �   CREATE TABLE public.usuario (
    id_usuario integer NOT NULL,
    nome_user character varying(60) NOT NULL,
    cpf character varying(20) NOT NULL,
    login character varying(20) NOT NULL,
    senha character varying(20) NOT NULL
);
    DROP TABLE public.usuario;
       public         heap    postgres    false            �            1259    16399    usuario_id_usuario_seq    SEQUENCE     �   CREATE SEQUENCE public.usuario_id_usuario_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public.usuario_id_usuario_seq;
       public          postgres    false    215            !           0    0    usuario_id_usuario_seq    SEQUENCE OWNED BY     Q   ALTER SEQUENCE public.usuario_id_usuario_seq OWNED BY public.usuario.id_usuario;
          public          postgres    false    214            v           2604    16417    maquina id_maq    DEFAULT     p   ALTER TABLE ONLY public.maquina ALTER COLUMN id_maq SET DEFAULT nextval('public.maquina_id_maq_seq'::regclass);
 =   ALTER TABLE public.maquina ALTER COLUMN id_maq DROP DEFAULT;
       public          postgres    false    219    218    219            u           2604    16410    mecanico id_mec    DEFAULT     r   ALTER TABLE ONLY public.mecanico ALTER COLUMN id_mec SET DEFAULT nextval('public.mecanico_id_mec_seq'::regclass);
 >   ALTER TABLE public.mecanico ALTER COLUMN id_mec DROP DEFAULT;
       public          postgres    false    216    217    217            w           2604    16425    ordem_serv id_ord    DEFAULT     v   ALTER TABLE ONLY public.ordem_serv ALTER COLUMN id_ord SET DEFAULT nextval('public.ordem_serv_id_ord_seq'::regclass);
 @   ALTER TABLE public.ordem_serv ALTER COLUMN id_ord DROP DEFAULT;
       public          postgres    false    221    220    221            t           2604    16403    usuario id_usuario    DEFAULT     x   ALTER TABLE ONLY public.usuario ALTER COLUMN id_usuario SET DEFAULT nextval('public.usuario_id_usuario_seq'::regclass);
 A   ALTER TABLE public.usuario ALTER COLUMN id_usuario DROP DEFAULT;
       public          postgres    false    215    214    215                      0    16414    maquina 
   TABLE DATA           >   COPY public.maquina (id_maq, nome_maq, descricao) FROM stdin;
    public          postgres    false    219   �%                 0    16407    mecanico 
   TABLE DATA           :   COPY public.mecanico (id_mec, nome_func, cpf) FROM stdin;
    public          postgres    false    217   �%                 0    16422 
   ordem_serv 
   TABLE DATA           c   COPY public.ordem_serv (id_ord, fk_id_maq, fk_id_mec, preco_final, data_rec, data_fim) FROM stdin;
    public          postgres    false    221   6&                 0    16400    usuario 
   TABLE DATA           K   COPY public.usuario (id_usuario, nome_user, cpf, login, senha) FROM stdin;
    public          postgres    false    215   �&       "           0    0    maquina_id_maq_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public.maquina_id_maq_seq', 20, true);
          public          postgres    false    218            #           0    0    mecanico_id_mec_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.mecanico_id_mec_seq', 87, true);
          public          postgres    false    216            $           0    0    ordem_serv_id_ord_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.ordem_serv_id_ord_seq', 4, true);
          public          postgres    false    220            %           0    0    usuario_id_usuario_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('public.usuario_id_usuario_seq', 40, true);
          public          postgres    false    214            }           2606    16419    maquina maquina_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.maquina
    ADD CONSTRAINT maquina_pkey PRIMARY KEY (id_maq);
 >   ALTER TABLE ONLY public.maquina DROP CONSTRAINT maquina_pkey;
       public            postgres    false    219            {           2606    16412    mecanico mecanico_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public.mecanico
    ADD CONSTRAINT mecanico_pkey PRIMARY KEY (id_mec);
 @   ALTER TABLE ONLY public.mecanico DROP CONSTRAINT mecanico_pkey;
       public            postgres    false    217                       2606    16427    ordem_serv ordem_serv_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.ordem_serv
    ADD CONSTRAINT ordem_serv_pkey PRIMARY KEY (id_ord);
 D   ALTER TABLE ONLY public.ordem_serv DROP CONSTRAINT ordem_serv_pkey;
       public            postgres    false    221            y           2606    16405    usuario usuario_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_pkey PRIMARY KEY (id_usuario);
 >   ALTER TABLE ONLY public.usuario DROP CONSTRAINT usuario_pkey;
       public            postgres    false    215            �           2606    16428 $   ordem_serv ordem_serv_fk_id_maq_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.ordem_serv
    ADD CONSTRAINT ordem_serv_fk_id_maq_fkey FOREIGN KEY (fk_id_maq) REFERENCES public.maquina(id_maq);
 N   ALTER TABLE ONLY public.ordem_serv DROP CONSTRAINT ordem_serv_fk_id_maq_fkey;
       public          postgres    false    3197    221    219            �           2606    16433 $   ordem_serv ordem_serv_fk_id_mec_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.ordem_serv
    ADD CONSTRAINT ordem_serv_fk_id_mec_fkey FOREIGN KEY (fk_id_mec) REFERENCES public.mecanico(id_mec);
 N   ALTER TABLE ONLY public.ordem_serv DROP CONSTRAINT ordem_serv_fk_id_mec_fkey;
       public          postgres    false    221    3195    217               >   x�3���M,JN��W(�O��,K�)+�I�2���M,,��K,���, ���&r��qqq Ib         8   x��0��M,JN���42�A.3N��Լ�D�����\��Ī*NC#C�,W� ��7         =   x�Mʱ�0��Ƣ)ِw��s$i�t��A'��9,%�B�f��X�YJ�$o�G�         �   x�3���M,JN�ɇӆ��\Ɔ��P��DĈ377�3�8����HsIt �E�f��obZZf~NjII�Bxj^rjqNb)X����X�)��9�����:�-���D �� �~CCC�&����� ��>�     