# Gestor de Tareas

Aplicación para gestionar tareas con backend en Spring Boot y frontend en Angular.

## Requisitos

- Java 21
- Maven
- Node.js 18+ (para el frontend)
- npm

## Estructura de Carpetas

### Backend (Spring Boot)
- `back-end/gestor-tareas/` - Aplicación Spring Boot
  - `src/main/java/ifc33b/dwesc/gestor_tareas/` - Código fuente Java
    - `controller` - Controladores
    - `dto` - Modelos de transferencia entre front y back
    - `model` - Modelos Java
    - `repository` - JPA
    - `service` - Lógica de negocio
  - `src/main/resources/` - Recursos de la aplicación
  - `src/test/` - Tests unitarios
  - `pom.xml` - Dependencias Maven

### Frontend (Angular)
- `front-end/gestor-tareas/` - Aplicación Angular
  - `src/app/` - Código Angular
    - `components/` - Componentes reutilizables
    - `models/` - Modelos TypeScript
    - `services/` - Servicios (comunicación con backend)
  - `src/` - Assets y configuración
  - `package.json` - Dependencias npm

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

1. Acceder a la carpeta del frontend:
```bash
cd front-end/gestor-tareas
```

2. Instalar dependencias:
```bash
npm install
```

3. Ejecutar servidor de desarrollo:
```bash
npm start
```

La aplicación estará disponible en `http://localhost:4200`

## Desarrollo

### Backend

El backend está construido con:
- **Spring Boot 3.x** - Framework web
- **Spring Data JPA** - Acceso a datos
- **Maven** - Gestor de dependencias

### Frontend

El frontend está construido con:
- **Angular 18+** - Framework de desarrollo
- **TypeScript** - Lenguaje de programación
- **SCSS** - Estilos
- **npm** - Gestor de dependencias

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
├── README.md
├── back-end/
│   └── gestor-tareas/
│       ├── mvnw
│       ├── mvnw.cmd
│       ├── pom.xml
│       ├── src/
│       │   ├── main/
│       │   │   ├── java/ifc33b/dwesc/gestor_tareas/
│       │   │   │   ├── GestorTareasApplication.java
│       │   │   │   ├── controller/
│       │   │   │   │   └── HomeController.java
│       │   │   │   ├── dto/
│       │   │   │   │   ├── TascaRequest.java
│       │   │   │   │   └── TascaResponse.java
│       │   │   │   ├── model/
│       │   │   │   │   └── Tasca.java
│       │   │   │   ├── repository/
│       │   │   │   └── service/
│       │   │   └── resources/
│       │   │       └── application.properties
│       │   └── test/
│       │       └── java/ifc33b/dwesc/gestor_tareas/
│       │           └── GestorTareasApplicationTests.java
│       └── target/ (generado por Maven)
└── front-end/
    └── gestor-tareas/
        ├── angular.json
        ├── package.json
        ├── tsconfig.json
        ├── tsconfig.app.json
        ├── tsconfig.spec.json
        ├── README.md
        ├── public/
        ├── src/
        │   ├── index.html
        │   ├── main.ts
        │   ├── styles.scss
        │   └── app/
        │       ├── app.config.ts
        │       ├── app.html
        │       ├── app.routes.ts
        │       ├── app.scss
        │       ├── app.ts
        │       ├── app.spec.ts
        │       ├── components/
        │       │   ├── formulari-tasques/
        │       │   │   ├── formulari-tasques.html
        │       │   │   ├── formulari-tasques.scss
        │       │   │   ├── formulari-tasques.ts
        │       │   │   └── formulari-tasques.spec.ts
        │       │   └── llista-tasques/
        │       │       ├── llista-tasques.html
        │       │       ├── llista-tasques.scss
        │       │       ├── llista-tasques.ts
        │       │       └── llista-tasques.spec.ts
        │       ├── models/
        │       │   ├── index.ts
        │       │   ├── tasca.model.ts
        │       │   └── tasca.model.spec.ts
        │       └── services/
        │           ├── tasca.service.ts
        │           └── tasca.service.spec.ts
```