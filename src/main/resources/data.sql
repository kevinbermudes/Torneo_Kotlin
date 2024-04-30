INSERT INTO torneos (nombre, ubicacion, modalidad, categoria_categoria, vacantes, premio, fecha_fin, fecha_inicio,
                     imagen)
VALUES ('Open Fantasía', 'Ciudad de Ensueño', 'INDIVIDUAL', 'ATP', 128, 1000000.00, '2024-12-15', '2024-12-01',
        'open_fantasia.png');



INSERT INTO tenistas (ranking, nombre_completo, pais, fecha_nacimiento, edad, altura, peso, ultimo_campeonato, mano,
                      revez, entrenador, total_dinero_ganado, victorias, derrotas, puntos, imagen, torneo_id)
VALUES (1, 'Juan Fantástico', 'España', '1990-03-20', 34, 1.85, 80.0, '2023-08-05', 'zurdo', 'DosManos',
        'Entrenador Maestro', 2500000.00, 200, 80, 1540, 'juan_fantastico.png', 1);
