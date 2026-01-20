# LexBot - API

Esta es la API del chatbot llamado **LexBot**, desarrollada en **Spring Boot**.  
LexBot permite interactuar con una **IA conversacional enfocada en las leyes colombianas**.

La aplicación está pensada para ayudar a los ciudadanos colombianos a **resolver dudas legales**, realizar **trámites** y **generar documentos legales básicos**, como derechos de petición, querellas, hábeas data y poderes especiales.

---

## Características

- Arquitectura completamente reactiva basada en Spring WebFlux
  
- Chat con IA usando:
  - OpenAI API
  - DeepSeek API
  - Solo una API activa a la vez
  - Existe un endpoint que permite cambiar el proveedor de IA en cualquier momento, incluso mientras la aplicación está en ejecución
 
- Los documentos generados son entregados directamente como PDF

- Cada consulta a la IA realiza búsquedas en internet usando la **API de Tavily**

- Dos modos de respuesta:
  - Respuesta única (texto completo)
  - Streaming (flujo de palabra a palabra en tiempo real)

- Configuración dinámica de CORS
- Persistencia de mensajes y usuarios usando **Firebase Firestore**
- Gestión de seguridad con **Firebase Authentication**, permitiendo inicio de sesión con email y contraseña o directamente con Google  
- Todos los endpoints están protegidos mediante **JWT**
- Despliegue sencillo usando el archivo `.jar` en **AWS Elastic Beanstalk**

---

## Tecnologías

- Java 21
- Spring Boot
- Spring WebFlux (programación reactiva)
- Firebase Firestore
- Firebase Authentication
- OpenAI / DeepSeek
- Tavily Search API
- AWS Elastic Beanstalk

---

## Requisitos para correr la aplicación

Antes de ejecutar la aplicación se requiere:

- Tener instalado **Java 21**
- Variables de entorno configuradas

Configura las siguientes variables de entorno:

```bash
DEEP_SEEK_API_KEY=your_deepseek_api_key
OPENAI_API_KEY=your_openai_api_key
TAVILY_API_KEY=your_tavily_api_key
FRONTEND_URL=https://tu-frontend.com
```

**Nota sobre `FRONTEND_URL`**

Esta variable se usa para la configuración de CORS, permitiendo el acceso únicamente el dominio del frontend que consume la API.

- Archivo de credenciales de Firebase
Es obligatorio proporcionar el archivo de credenciales de Firebase llamado `FirestoreKey.json`.
  
Este archivo lo proporciona Firebase para aplicaciones web/server y debe contener una estructura como la siguiente:
```json
{
  "type": "",
  "project_id": "",
  "private_key_id": "",
  "private_key": "",
  "client_email": "",
  "client_id": "",
  "auth_uri": "",
  "token_uri": "",
  "auth_provider_x509_cert_url": "",
  "client_x509_cert_url": "",
  "universe_domain": ""
}
```
  
El archivo debe ubicarse en la misma carpeta donde se encuentran los archivos de configuración de Spring Boot:
`src/main/resources/FirestoreKey.json`

## Despliegue

La aplicación ha sido probada y validada en AWS Elastic Beanstalk.

### Pasos generales
1. Cumplir con los requisitos para ejecutar la aplicación
2. Generar el archivo .jar con Gradle
3. Crear un entorno de Elastic Beanstalk (Java)
4. Configurar las variables de entorno en Elastic Beanstalk
5. Subir el archivo .jar generado
6. Iniciar el entorno
