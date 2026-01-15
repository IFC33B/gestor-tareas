# Gestor Tareas

Tarea 1 de las prácticas de APIs en entorno **cliente** & **servidor**.

## Endpoints

| Method     | Endpoint          | Description                                           | Respuestas                                                                    |
| ---------- | ----------------- | ----------------------------------------------------- | ----------------------------------------------------------------------------- |
| **GET**    | /api/tasques      | Mostrar todas las tareas                              | **200** -> Ok, tareas disponibles<br>**204** -> Ok, sin tareas disponibles    |
| **POST**   | /api/tasques/{id} | Crear tarea con `{id}` usando los datos del body      | **201** -> Ok, tarea creada                                                   |
| **PUT**    | /api/tasques/{id} | Actualizar tarea con `{id}` usando los datos del body | **201** -> Ok, tarea actualizada<br>**404** -> Tarea con `{id}` no encontrada |
| **DELETE** | /api/tasques/{id} | Eliminar tarea con `{id}`                             | **204** -> Ok, tarea eliminada<br>**404** -> Tarea con `{id}` no encontrada   |

## Comandos de prueba Windows

_El curl no me va y pues esto es lo que he encontrado... \*ejem...\* ~chatgpt_

> Ejecutar los comandos de forma secuencial tras iniciar el servidor.

**Get tareas sin contenido**

```
iwr http://localhost:8080/api/tasques
```

_Esperamos:_ **_404_**

---

**Crear tarea**

```
iwr http://localhost:8080/api/tasques -Method POST -Headers @{ "Content-Type" = "application/json" } -Body '{ "titol": "titolTest", "descripcio": "testDescription", "feta": false }'
```

_Esperamos:_ **_201_**

---

**Get tareas con contenido**

```
iwr http://localhost:8080/api/tasques
```

_Esperamos:_ **_200_**

---

**Actualizar tarea**

```
iwr http://localhost:8080/api/tasques/1 -Method PUT -Headers @{ "Content-Type" = "application/json" } -Body '{ "titol": "titolActualitzat", "descripcio": "descripciocAtualitzada", "feta": true }'
```

_Esperamos:_ **_201_**

---

**Get tareas con contenido actuzalizado**

```
iwr http://localhost:8080/api/tasques
```

_Esperamos:_ **_200_** _y el contenido actualizado_

---

**Elminar tarea**

```
iwr http://localhost:8080/api/tasques/1 -Method DELETE -Headers @{ "Content-Type" = "application/json" }
```

_Esperamos:_ **_204_**
