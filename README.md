🌿 Proyecto: Gestor de Tareas Moderno (MVC)
1. Descripción del Proyecto
Este software es una aplicación de escritorio diseñada en Java para la gestión de tareas diarias. El objetivo principal fue crear una herramienta funcional que no solo permita organizar pendientes, sino que ofrezca una experiencia de usuario fluida mediante una interfaz gráfica estilizada.

Características principales:

Diseño Flat: Botones sin bordes 3D, tipografía moderna y paleta de colores coherente.

Interactividad: Efectos de iluminación (hover) al pasar el cursor sobre los botones.

Gestión Dinámica: Registro, eliminación y cambio de estado de tareas en tiempo real.

Filtrado Inteligente: Capacidad de visualizar tareas según su estado (Pendientes/Completadas).

2. Cómo Ejecutar
Para poner en marcha la aplicación, sigue estos pasos:

Entorno: Asegúrate de tener instalado el JDK 17 o una versión superior.

Importación: Abre tu IDE (IntelliJ IDEA, NetBeans o Eclipse) e importa la carpeta del proyecto.

Compilación: Localiza la clase principal Main.java dentro del paquete org.example.

Lanzamiento: Ejecuta el archivo Main.java. Se abrirá una ventana de 750x550 píxeles con el gestor listo para usar.

3. Explicación del uso de POO
El proyecto fue estructurado bajo el paradigma de Programación Orientada a Objetos, utilizando los siguientes conceptos clave:

A. Patrón de Diseño MVC (Modelo-Vista-Controlador)
Esta arquitectura divide el software en tres partes para facilitar el mantenimiento:

Modelo (Tarea): Contiene la estructura de los datos y la lógica interna de cada tarea.

Vista (VistaTarea): Se encarga exclusivamente de la representación visual, colores, botones y disposición de los elementos.

Controlador (ControladorTarea): Actúa como el puente; escucha las acciones del usuario en la Vista y ordena al Modelo actualizarse.

<img width="727" height="534" alt="image" src="https://github.com/user-attachments/assets/a0b6e16f-4453-4e9f-a803-fc025ce195a2" />
