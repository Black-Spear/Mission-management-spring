## Mission Management API with Spring Boot and MySQL

**Take control of your missions with this powerful and user-friendly API, built with Spring Boot and MySQL to ensure speed, reliability, and scalability.**

**Features:**

* **Effortlessly manage missions:** Create, read, update, and delete missions with ease.
* **Track mission progress and status:** Monitor mission progress and know where your team stands at all times.
* **Assign and manage personnel:** Assign personnel to missions and manage their roles and responsibilities.
* **Keep your data secure:** MySQL database ensures data security and integrity.
* **Simple and intuitive RESTful API:** Easy to integrate with your existing applications.
* **Open-source and community-driven:** Get involved and contribute to the project's development.

**Tech Stack:**

* Spring Boot
* MySQL
* Maven

**Getting Started:**

1. **Clone the repository:**
```
git clone https://github.com/your-username/mission-management-api.git
```
2. **Build the project:**
```
mvn clean install
```
3. **Configure the database:**
- Update the `application.properties` file with your MySQL connection details.
4. **Run the application:**
```
mvn spring-boot:run
```
5. **Start managing your missions!**

**API Endpoints:**

**Missions:**

| Endpoint | HTTP Method | Description |
|---|---|---|
| `/missions` | GET | Get all missions |
| `/missions/{id}` | GET | Get a specific mission by ID |
| `/missions/{id}/personnel` | GET | Get all personnel assigned to a mission |
| `/missions` | POST | Create a new mission |
| `/missions/{id}` | PUT | Update a mission |
| `/missions/{id}` | DELETE | Delete a mission |
| `/missions/{missionId}/addPersonnel/{personnelId}` | POST | Assign a personnel to a mission |
| `/missions/{missionId}/removePersonnel/{personnelId}` | DELETE | Unassign a personnel from a mission |

**Personnel:**

| Endpoint | HTTP Method | Description |
|---|---|---|
| `/personnel` | GET | Get all personnel |
| `/personnel/{id}` | GET | Get a specific personnel by ID |
| `/personnel` | POST | Add a new personnel |
| `/personnel/{id}` | PUT | Update personnel information |
| `/personnel/{id}` | DELETE | Delete a personnel |
| `/personnel/school` | GET | Get all personnel by school name |


**Try it**

I recommend using HTTPie to try the endpoints and manage them inside a cool interface.

![Api endpoints example](HTTPie.png "API endpoints illustrated")

**Contact:**

For support or feedback, please feel free to open an issue on this repository or contact us at your preferred communication channel.

**Contribute:**

This project is open-source and welcomes contributions! Feel free to fork the repository, make your changes, and submit pull requests.

**Happy Mission Management!**

