# Sistema de Gestión de Equipos de Fútbol

Este proyecto es una aplicación web desarrollada en Java utilizando JSP y Servlets, que permite registrar, editar, eliminar y listar equipos de fútbol, así como realizar login de usuario con control de acceso. La base de datos utilizada es PostgreSQL y el servidor de despliegue es Apache Tomcat.

##  Estructura del Proyecto

equiposapp/
├── clases/ # Archivos .class compilados
├── src/
│ └── main/
│ └── java/
│ └── com.equipos.equiposfutbol/
│ ├── config/ # Configuración de conexión DB
│ ├── controller/ # Servlets
│ ├── dao/ # Lógica de acceso a datos
│ └── model/ # Entidades
├── web/
│ ├── formulario.jsp # Formulario para registrar/editar
│ ├── listar.jsp # Lista de equipos registrados
│ ├── login.jsp # Login de usuario
│ └── WEB-INF/
│ ├── web.xml # Despliegue y configuración web
│ └── index.jsp # Página de inicio
├── equiposapp-war/ # Carpeta usada para generar el archivo WAR
└── README.md # Este archivo


##  Tecnologías utilizadas

- Java 17
- JSP & Servlets
- Apache Tomcat 9.0.106
- PostgreSQL
- Visual Studio Code (como entorno de desarrollo)
- Git + GitHub (control de versiones)

##  Funcionalidades

- Registro de equipos de fútbol
- Edición y eliminación de registros
- Listado completo de equipos
- Login de usuario con validación
- Control de acceso por sesión
- Conexión a base de datos PostgreSQL
- Despliegue en servidor Apache Tomcat

##  Requisitos

- Java JDK 17
- PostgreSQL instalado y base de datos `equiposdb` creada
- Apache Tomcat 9 configurado
- Driver postgresql.jar incluido en el classpath
- Visual Studio Code (opcional)

##  Instalación y ejecución

1. Clona este repositorio:

```bash
git clone https://github.com/tu_usuario/equiposapp.git



rea la base de datos en PostgreSQL:




Compila los archivos Java:


javac -cp "C:/Tomcat9/apache-tomcat-9.0.106/lib/servlet-api.jar;clases" -d clases src/main/java/com/equipos/equiposfutbol/**/*.java
Empaqueta el archivo WAR:


jar -cvf equiposapp.war *
Copia el archivo WAR a la carpeta webapps de Tomcat:


C:/Tomcat9/apache-tomcat-9.0.106/webapps/
Inicia el servidor Tomcat y accede en el navegador a:

URL de inicio de sesión:


http://localhost:8080/equiposapp/login.jsp

 URL para listar equipos (requiere login):


http://localhost:8080/equiposapp/equipos


URL para registrar un nuevo equipo (desde el botón en listar.jsp, pero directamente sería):


http://localhost:8080/equiposapp/formulario.jsp


 URL para cerrar sesión:


http://localhost:8080/equiposapp/logout
