# Sistema de Ticketing de Incidencias LAB-LIS
## Proyecto final de POO — Implementación en Java
Este sistema es una aplicación de consola desarrollada en Java que permite gestionar incidencias generadas en el Laboratorio de Cómputo LAB-LIS.
El programa permite que cualquier usuario de la universidad pueda registrar una incidencia (un ticket), proporcionando su matrícula, nombre, descripción del problema, tipo de incidencia y el equipo afectado. Además, el sistema permite que los técnicos del laboratorio administren de manera adecuada todas las incidencias.
Ellos pueden consultar las incidencias registradas, asignarse como responsables, actualizar su estado conforme avanza la atención, establecer la prioridad del ticket y generar un reporte general del estado del laboratorio. También cuentan con acceso a un historial completo de cada incidencia, lo que facilita dar seguimiento a los cambios realizados.
Fue construido utilizando el paradigma de Programación Orientada a Objetos.

## Funcionalidades principales
**Para usuario que reporta**
- Registrar nuevas incidencias reportadas por usuarios  
- Guardar automáticamente la fecha y hora de creación  
**Para tecnico**
- Listar todas las incidencias registradas  
- Filtrar incidencias por estado  
- Asignar técnico responsable  
- Cambiar estado de una incidencia  
- Asignar prioridad (solo técnico)  
- Listar incidencias en proceso ordenadas por prioridad  
- Generar un reporte básico del estado del laboratorio  
- Mantener un historial completo de cada incidencia  

## Autor
- Omar Vásquez Machorro
- s24016731
- Universidad Veracruzana campus Coatzacoalcos 

## Cómo ejecutar el sistema
1. Clonar o descargar este repositorio
2. Abrir el proyecto en cualquier IDE compatible
3. Compilar y ejecutar la clase:
TicketingApp.java
4. Seleccionar el tipo de usuario (Usuario o Técnico)
5. Navegar con las opciones del menú

## Historial de cada incidencia
- **Cada incidencia mantiene un registro automático con:**
- Creación
- Asignación de técnico
- Cambios de estado
- Cambios de prioridad
- Esto permite rastrear todo lo que ha ocurrido con el ticket.