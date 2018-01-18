## Prueba tecnica Rappi

Esta entrega tambien la puede encontrar en [bitbucket](https://cferrer1490@bitbucket.org/cferrer1490/rappi.git)

	git:https://cferrer1490@bitbucket.org/cferrer1490/rappi.git

**Coding challenge**

Este punto se resolvio de 2 formas distintas:

**1. Algoritmicamente:**
	El algoritmo se resolvio en hackerrank donde se pasaron todo los test. el desarrollo 	de este algoritmo lo puede encontrar en:

[codigo/cubesummation.java](http://github.com)

**2. Usando una arquitectura de microservicio con spring**
Para este desarrollo se crearon tres capas


* **persistencia** : compuesta por las entidades(Cubo y Punto) [model](https://github.com/caferrerb/pruebatecnica/tree/master/cubesummation/src/main/java/co/com/caferrerb/rappi/cubesummation/model) y dos DAOS (uno para cada entidad) [DAOS](https://github.com/caferrerb/pruebatecnica/tree/master/cubesummation/src/main/java/co/com/caferrerb/rappi/cubesummation/persistence). esta capa es la responsabe de abstraer las operaciones sobre el medio de persistencia.  

* **Negocio:** Una clase de negocio con la logica de resolucion del problema. [Negocio](https://github.com/caferrerb/pruebatecnica/tree/master/cubesummation/src/main/java/co/com/caferrerb/rappi/cubesummation/service)

* **Servicios:** Un servicio Rest con las operaciones de UPDATE y QUERY tal como en el enunciado. [Servicio](https://github.com/caferrerb/pruebatecnica/tree/master/cubesummation/src/main/java/co/com/caferrerb/rappi/cubesummation/service)

* **Utilidades:** clases de utilidad. en este caso esta el DTO generico de respuesta de los ervicios REST. [utilidades](https://github.com/caferrerb/pruebatecnica/tree/master/cubesummation/src/main/java/co/com/caferrerb/rappi/cubesummation/util)
Ademas se crearon **pruebas unitarias** que puede encontrar aqui: [pruebas unitarias](http://github.com)

---

**CODE REFACTORING**

El codigo refactorizado lo puede encontrar [aqui](https://github.com/caferrerb/pruebatecnica/blob/master/codigo/refactorizada.codigo.php)

Para refactorizar este codigo se procedio a mejorar lo siguiente:

1.  Incrementar la reutilizacion de elementos como variables y operaciones como por ejemplo en la operaciones de BD de Servicio y Driver y las variables $driverId

2. Retirar el codigo comentado.

3. Incrementar la cohesion de los elementos del codigo enviandolos a metodos especiales para esa funcion que se quiere abstraer.

---

**PREGUNTAS**

1. **En qué consiste el principio de responsabilidad única? ¿Cuál es su propósito?:**
Este es un principio que favorese la mantebilidad del codigo asignandole a una clase o componente una sola responsabilidad. Esto aisla las concecuencias de un cambio sobre ese componente al componente mismo ya que los cambios se hacen en base a la responsabilidad o funcionalida especifica que tiene esa clase. Este principio es concecuencia de diseñar componentes cohesivos.


2. **Qué características tiene según su opinión “buen” código o código limpio:** Un buen codigo es aquel que se explica por si solo que no necesite una documentacion extensa para que otra persona pueda entender su proposito siendo este sencillo de leer y mantenible. Un buen codigo es aquel que haya pasado por una etapa de refinamiento o refactor donde se hayan eliminado hasta donde mas se pueda lo que se denomina como "code smells". Un buen codigo es aquel que  use adecuadamente patrones de diseño que fomenten el buen mantenimiento y extension del mismo.

3. **¿Qué es un microservicio?, ventajas y desventajas de los micorservicios:** 
Un microservicio es una unidad agnostica altamente cohesiva de logica de negocio desplegada sobre una infrastructura(servidor de app , BD y demas) independiente con los recursos minimos para el funcionamiento del servicio. la comunicacion con los microservicios tambien debe ser usando protocolos ligeros como el http o mensajeria.
Las **ventajas** de los microservicios es que debido a su naturaleza agnostica pueden ser altamente reusables y faciles de desarrollar ya que la logica esta muy delimitada.
La **mayor desventaja** puede ser en los despliegues ya que no es lo mismo desplegar una aplicacion que tenga 100 funcionalidades que 100 aplicaciones que tengan cada una 1 funcionalidad.





 
