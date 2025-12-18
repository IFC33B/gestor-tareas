# Gestor de Tareas

Aplicación para gestionar tareas con backend en Spring Boot y frontend en Angular.

## Requisitos

- Java 21
- Maven
- Node.js (para el frontend)

## Instalación

### Backend

1. Acceder a la carpeta del backend:
```bash
cd back-end/gestor-tareas
```

2. Compilar y ejecutar:
```bash
mvn spring-boot:run
```

El servidor estará disponible en `http://localhost:8080`

### Frontend

```bash
cd front-end
npm install
npm start
```

## Endpoints API

La API está disponible en `http://localhost:8080/api/tasques`

### Tabla Resumen de Endpoints

| Método | Ruta | Descripción | Status |
|--------|------|-------------|--------|
| GET | `/api/tasques` | Obtener todas las tareas | 200 |
| POST | `/api/tasques` | Crear una nueva tarea | 201 |
| PUT | `/api/tasques/{id}` | Actualizar una tarea | 200 |
| DELETE | `/api/tasques/{id}` | Eliminar una tarea | 204 |

### 1. Obtener todas las tareas

**GET** `/api/tasques`

Devuelve la lista de todas las tareas.

**Response (200 OK):**
```json
[
  {
    "id": 1,
    "titol": "Mi primera tarea",
    "descripcio": "Descripción de la tarea",
    "feta": false
  },
  {
    "id": 2,
    "titol": "Segunda tarea",
    "descripcio": "Otra descripción",
    "feta": true
  }
]
```

---

### 2. Crear una nueva tarea

**POST** `/api/tasques`

Crea una nueva tarea.

**Headers:**
```
Content-Type: application/json
```

**Request Body:**
```json
{
  "titol": "Título de la tarea",
  "descripcio": "Descripción de la tarea",
  "feta": false
}
```

**Parámetros requeridos:**
- `titol` (string, obligatorio): Título de la tarea
- `descripcio` (string, obligatorio): Descripción de la tarea
- `feta` (boolean, opcional): Estado de la tarea (completada o no). Por defecto: false

**Response (201 Created):**
```json
{
  "id": 3,
  "titol": "Título de la tarea",
  "descripcio": "Descripción de la tarea",
  "feta": false
}
```

---

### 3. Actualizar una tarea

**PUT** `/api/tasques/{id}`

Actualiza una tarea existente.

**Path Parameters:**
- `id` (number): ID de la tarea a actualizar

**Response (200 OK):**
```json
{
  "id": 3,
  "titol": "Título actualizado",
  "descripcio": "Descripción actualizada",
  "feta": true
}
```

---

### 4. Eliminar una tarea

**DELETE** `/api/tasques/{id}`

Elimina una tarea existente.

**Path Parameters:**
- `id` (number): ID de la tarea a eliminar

**Response (204 No Content)**

---

## Ejemplos de uso

### Con cURL

**Crear una tarea:**
```bash
curl -v -X POST "http://localhost:8080/api/tasques"   -H "Content-Type: application/json; charset=UTF-8"   --data-raw '{"titol":"Test","descripcio":"Test","feta":true}'
```

**Obtener todas las tareas:**
```bash
curl -X GET "http://localhost:8080/api/tasques"
```

**Actualizar una tarea:**
```bash
curl -v -X PUT "http://localhost:8080/api/tasques/1"   -H "Content-Type: application/json; charset=UTF-8"   --data-raw '{"titol":"Test","descripcio":"Test","feta":true}'
```

**Eliminar una tarea:**
```bash
curl -X DELETE "http://localhost:8080/api/tasques/1"
```

## Estructura del Proyecto

```
gestor-tareas/
├── back-end/
│   └── gestor-tareas/          (Backend Spring Boot)
│       ├── src/
│       │   ├── main/
│       │   │   ├── java/
│       │   │   │   └── ifc33b/dwesc/gestor_tareas/
│       │   │   │       ├── controller/        (Controladores REST)
│       │   │   │       ├── service/           (Servicios)
│       │   │   │       ├── model/             (Modelos)
│       │   │   │       ├── dto/               (Data Transfer Objects)
│       │   │   │       └── repository/        (Acceso a datos)
│       │   │   └── resources/
│       │   │       └── application.properties
│       │   └── test/
│       └── pom.xml
└── front-end/                   (Frontend)
```