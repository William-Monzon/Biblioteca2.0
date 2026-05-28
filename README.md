# Biblioteca 2.0

Este proyecto aplica conceptos fundamentales de Programación Orientada a Objetos, como encapsulamiento, herencia, polimorfismo, sobrecarga y clases abstractas, permitiendo fortalecer los conocimientos adquiridos durante el curso. Además, incorpora validaciones, manejo de datos y persistencia mediante archivos Csv y Txt, para garantizar un mejor funcionamiento del sistema.


## Descripción

Biblioteca 2.0 es una aplicación de escritorio que permite gestionar una biblioteca mediante una interfaz gráfica creada con Swing utilizando Window Builder.  
El sistema permite registrar libros y usuarios, realizar préstamos y devoluciones, validar reglas de negocio y visualizar préstamos activos.

Este proyecto fue desarrollado como parte del curso de Programación 1 utilizando conceptos de:

- Encapsulamiento
- Herencia
- Polimorfismo
- Sobrescritura (`@Override`)
- Sobrecarga
- Clases abstractas
- Persistencia de datos


# Integrantes GRUPO #3

-  WILLIAM NOÉ MONZÓN LÓPEZ 
-  LEANNY YAILE ALVEÑO GÓMEZ 
-  ABDIEL ABRAHAM MATEO PINEDA 



# Tecnologías utilizadas


|               TECNOLOGÍAS:                |
|-------------------------------------------|
|                                           |
| Java | Lenguaje principal                 |
| Java Swing | Interfaz gráfica             |
| ArrayList | Almacenamiento en memoria     |
| Archivos CSV y Txt| Persistencia de datos |
| GitHub | Control de versiones             |
| Trello | Organización del proyecto        |
|  Figma | Refrerencia visual para Swing    |
|  Gitkraken | Organización de commits      |
--------------------------------------------




# Estructura del proyecto

```Biblioteca0.2
SRC/
│
├── main/
│   └── Main.java
│
├── models/
│   ├── Bocks.java
│   ├── Users.java
│   └── Loans.java
│
├── interfaces/
│   │
│   ├── Main window.java
│   │
│   ├── Book panel.java
│   ├── User panel.java
│   └── Loan panel.java
│   
│
├── Drivers/
│   ├── Controller book.java
│   ├── controller user.java
│   └── controller loan.java
│   
│
├── Services/
│   └── Library services.java
│
│
└──  UtilS/
    └── Validations.java







