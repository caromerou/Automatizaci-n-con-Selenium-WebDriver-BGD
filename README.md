# Automatizaci-n-con-Selenium-WebDriver-BGD
Saucedemo Automation - Screenplay BDD
Este proyecto contiene la automatización de pruebas para el sitio web Sauce Demo, implementando una arquitectura robusta y escalable utilizando el patrón Screenplay.

🎯 Objetivo
Automatizar flujos críticos de negocio, incluyendo la gestión de usuarios, el carrito de compras y el proceso de checkout, garantizando la estabilidad de la plataforma.

🛠️ Tecnologías Utilizadas
El proyecto está construido bajo los siguientes estándares y herramientas:

Lenguaje: Java 11

Gestor de Dependencias: Maven

Framework de Automatización: Serenity BDD

Patrón de Diseño: Screenplay Pattern

BDD Tool: Cucumber

Testing Framework: JUnit 5

Navegador: Google Chrome (Modo Incógnito configurado)

📋 Escenarios Automatizados
Los escenarios se encuentran definidos en lenguaje Gherkin dentro de la carpeta src/test/resources/features:

Inicio de sesión exitoso: Usuario válido puede ingresar.

Inicio de sesión fallido: Validación de error con credenciales inválidas.

Gestión de producto: Añadir un producto individual al carrito.

Compra básica: Finalizar compra con un solo producto.

Flujo avanzado: Añadir múltiples productos, eliminar uno y finalizar compra.

🏗️ Arquitectura (Screenplay Pattern)
El proyecto sigue la estructura de Screenplay para separar las responsabilidades:

Actors: Quién realiza la acción.

Tasks: Acciones de alto nivel (ej. HacerLogin, FinalizarCompra).

Actions: Interacciones directas con la web (ej. Click, Enter).

Questions: Verificaciones y aserciones.

User Interface: Mapeo de selectores (Locators).

🚀 Ejecución de Pruebas
Para ejecutar las pruebas y generar los reportes, utiliza el siguiente comando en la terminal:

Bash

mvn clean verify
📊 Reportes de Serenity
Una vez finalizada la ejecución, Serenity genera un reporte detallado con capturas de pantalla de cada paso. Puedes encontrarlo en:

target/site/serenity/index.html

Nota: Se ha configurado el driver en serenity.properties para evitar las ventanas emergentes de seguridad de Chrome relacionadas con contraseñas públicas.
