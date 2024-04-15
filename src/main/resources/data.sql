-- Crear tabla torneos si no existe
CREATE TABLE IF NOT EXISTS torneos
(
    id                 BIGINT AUTO_INCREMENT PRIMARY KEY,
    ubicacion          VARCHAR(255) NOT NULL,
    modalidad          VARCHAR(20)  NOT NULL,
    categoria_categoria VARCHAR(20)  NOT NULL,
    vacantes           INT          NOT NULL,
    premio             DOUBLE       NOT NULL,
    fecha_inicio       DATE         NOT NULL,
    fecha_fin          DATE         NOT NULL,
    imagen             VARCHAR(255)
    );

-- Insertar datos en la tabla torneos
INSERT INTO torneos (ubicacion, modalidad, categoria_categoria, vacantes, premio, fecha_inicio, fecha_fin, imagen) VALUES
                                                                                                                       ('Paris, Francia', 'individual', 'ATP', 128, 4300000.00, '2024-05-22', '2024-06-07', 'url_imagen1'),
                                                                                                                       ('Londres, Inglaterra', 'individual', 'ATP', 128, 4500000.00, '2024-06-29', '2024-07-14', 'url_imagen2'),
                                                                                                                       ('Nueva York, EE.UU.', 'individual', 'ATP', 128, 4700000.00, '2024-08-25', '2024-09-08', 'url_imagen3'),
                                                                                                                       ('Melbourne, Australia', 'individual', 'ATP', 128, 4400000.00, '2024-01-13', '2024-01-28', 'url_imagen4');

-- Crear tabla tenistas si no existe
CREATE TABLE IF NOT EXISTS tenistas
(
    id                  BIGINT AUTO_INCREMENT PRIMARY KEY,
    ranking             BIGINT       NOT NULL,
    nombre_completo     VARCHAR(255) NOT NULL,
    pais                VARCHAR(50)  NOT NULL,
    fecha_nacimiento    DATE         NOT NULL,
    edad                INT          NOT NULL,
    altura              DOUBLE       NOT NULL,
    peso                DOUBLE       NOT NULL,
    ultimo_campeonato   DATE,
    mano                VARCHAR(10)  NOT NULL CHECK (mano IN ('diestro', 'zurdo')),
    revez               VARCHAR(10)  NOT NULL CHECK (revez IN ('UnaMano', 'DosManos')),
    entrenador          VARCHAR(255),
    total_dinero_ganado DOUBLE       NOT NULL,
    victorias           INT          NOT NULL,
    derrotas            INT          NOT NULL,
    puntos              INT          NOT NULL,
    imagen              VARCHAR(255)
    );

-- Insertar datos en la tabla tenistas
INSERT INTO tenistas (ranking,
                      nombre_completo,
                      pais,
                      fecha_nacimiento,
                      edad,
                      altura,
                      peso,
                      ultimo_campeonato,
                      mano,
                      revez,
                      entrenador,
                      total_dinero_ganado,
                      victorias,
                      derrotas,
                      puntos,
                      imagen)
VALUES (1,
        'Rafael Nadal',
        'España',
        '1986-06-03',
        35,
        1.85,
        85.0,
        '2022-01-30',
        'zurdo',
        'DosManos',
        'Carlos Moya',
        120000000.00,
        1020,
        205,
        12345,
        'https://example.com/imagen_nadal.jpg');

