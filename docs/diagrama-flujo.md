

# 📄 Especificación de Casos de Uso - Gastromind

### CU-01: Escaneo de Ticket e Inventariado Automático

| Campo | Detalle |
| --- | --- |
| **Nombre** | **Escanear Ticket de Compra** |
| **ID** | CU-01 |
| **Actor Principal** | Usuario Final |
| **Actores Secundarios** | Google AI Studio (Gemini 1.5 Flash) |
| **Descripción** | El usuario captura una imagen de un ticket físico. La IA procesa el texto, identifica productos y los inserta automáticamente en la base de datos. |
| **Precondiciones** | Usuario autenticado y con un `household_id` válido. |
| **Flujo Principal** | 1. El usuario activa la cámara desde la App.<br>2. Se envía la imagen al Backend.<br>3. El Backend solicita extracción de datos a Gemini.<br>4. Gemini devuelve JSON con: nombre, cantidad, precio y categoría.<br>5. El sistema registra el `ticket` y crea los `fridge_items`.<br>6. Se confirma la carga al usuario. |
| **Postcondición** | Los productos aparecen en la vista de "Nevera" y el gasto se refleja en el reporte mensual. |

---

### CU-02: Sugerencia de Receta Inteligente (IA)

| Campo | Detalle |
| --- | --- |
| **Nombre** | **Solicitar Receta Sugerida** |
| **ID** | CU-02 |
| **Actor Principal** | Usuario Final |
| **Actores Secundarios** | Google AI Studio (Gemini) |
| **Descripción** | El sistema genera una receta personalizada basada exclusivamente en los ingredientes disponibles, alérgenos y electrodomésticos del hogar. |
| **Precondiciones** | Existencia de productos en la tabla `fridge_items`. |
| **Flujo Principal** | 1. El usuario solicita una sugerencia.<br>2. El sistema recupera productos próximos a caducar.<br>3. El sistema recupera alérgenos (`user_allergens`) y aparatos (`household_appliances`).<br>4. Gemini procesa el contexto y genera la receta.<br>5. El sistema presenta la receta con instrucciones y tiempo de preparación. |
| **Postcondición** | El usuario visualiza una receta segura y ejecutable con su equipamiento actual. |

---

### CU-03: Alerta de Caducidad Proactiva

| Campo | Detalle |
| --- | --- |
| **Nombre** | **Recibir Alerta de Caducidad** |
| **ID** | CU-03 |
| **Actor Principal** | Sistema Gastromind (Automatizado) |
| **Actor Pasivo** | Usuario Final |
| **Descripción** | El sistema monitoriza las fechas de caducidad y notifica al usuario para evitar el desperdicio de alimentos. |
| **Flujo Principal** | 1. El sistema ejecuta un proceso programado diario.<br>2. Filtra productos con `expiration_date` < 48 horas y `status` = 'disponible'.<br>3. Se dispara una notificación push al dispositivo del usuario.<br>4. El usuario accede a la app para ver el producto en riesgo. |
| **Postcondición** | Se reduce el índice de `status` = 'desperdiciado' en la base de datos. |

---

### CU-04: Gestión de Preferencias y Seguridad

| Campo | Detalle |
| --- | --- |
| **Nombre** | **Gestionar Alérgenos y Electrodomésticos** |
| **ID** | CU-04 |
| **Actor Principal** | Usuario Final |
| **Descripción** | El usuario define las limitaciones médicas y el equipamiento técnico de su cocina para filtrar la lógica de la IA. |
| **Flujo Principal** | 1. El usuario accede a "Ajustes de Cocina".<br>2. Selecciona alérgenos de la tabla `allergen`.<br>3. Marca los electrodomésticos activos (`appliance_type`).<br>4. El sistema actualiza las tablas `user_allergens` y `household_appliances`. |
| **Postcondición** | La IA ajusta el filtrado de recetas en tiempo real para futuras consultas. |


<img src="images/diagrama_flujo.png" alt="Diagrama de Flujo" align="center" height="400" width="2000" />