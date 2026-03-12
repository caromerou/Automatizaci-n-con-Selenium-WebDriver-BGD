Feature: Compra en Saucedemo
  Como usuario de Saucedemo
  Quiero iniciar sesión y realizar compras
  Para adquirir productos

  Background:
    Given que el actor está en la página de inicio de sesión

  @login
  Scenario: Inicio de sesión exitoso con usuario válido
    When el actor inicia sesión con credenciales válidas
    Then el actor debería ver el catálogo de productos

  @login
  Scenario: Inicio de sesión fallido con usuario inválido
    When el actor intenta iniciar sesión con usuario "invalid_user" y contraseña "wrongpass"
    Then debería ver un mensaje de error indicando que las credenciales son incorrectas

  @cart
  Scenario: Añadir un producto al carrito
    Given el actor ha iniciado sesión como usuario estándar
    When añade el producto "Sauce Labs Backpack" al carrito
    Then el carrito debería mostrar 1 producto

  @checkout
  Scenario: Finalizar una compra con un producto en el carrito
    Given el actor ha iniciado sesión como usuario estándar
    Y tiene el producto "Sauce Labs Backpack" en el carrito
    When procede al checkout y completa la información de envío
    And finaliza la compra
    Then debería ver un mensaje de confirmación de compra exitosa

  @remove
  Scenario: Añadir múltiples productos, eliminar uno y finalizar compra
    Given el actor ha iniciado sesión como usuario estándar
    When añade los productos "Sauce Labs Backpack" y "Sauce Labs Bike Light" al carrito
    And elimina el producto "Sauce Labs Bike Light" del carrito
    And procede al checkout y completa la información de envío
    And finaliza la compra
    Then debería ver un mensaje de confirmación de compra exitosa    Given el actor ha iniciado sesi[o]n como usuario est[�]ndar 
  @login 
    And finaliza la compra 
