# Medicine Inventory MCP Server

A Spring Boot-based Model Context Protocol (MCP) server for managing medicine inventory. This application provides a structured interface for AI assistants to interact with medicine inventory data through standardized MCP tools and prompts.

## Overview

This is a Spring Boot application that implements the Model Context Protocol (MCP) server specification, enabling AI assistants to:
- Query and retrieve medicine information
- Manage medicine inventory data
- Execute predefined operations through MCP tools
- Access structured medicine prompts for AI interaction

## Features

- **MCP Server Implementation**: Full compliance with Model Context Protocol specifications
- **Medicine Inventory Management**: Manage and query medicines from a JSON-based data store
- **RESTful API**: HTTP endpoints for integration with MCP clients
- **Server-Sent Events (SSE)**: Real-time communication support
- **Spring Boot 3**: Modern Spring Framework with Java 21
- **Lombok Integration**: Simplified entity definitions with annotations
- **Jackson Support**: JSON serialization with Java 8 date/time support

## Technology Stack

- **Java**: 21
- **Spring Boot**: 3.5.11
- **Spring AI MCP Server**: 1.1.2
- **Build Tool**: Maven
- **Additional Libraries**: Lombok, Jackson

## Project Structure

```
src/
├── main/
│   ├── java/medicine/mcp/server/
│   │   ├── MedicineInventoryMcpServerApplication.java  # Main Spring Boot application
│   │   ├── config/                                      # Configuration classes
│   │   ├── model/
│   │   │   └── Medicine.java                           # Medicine entity
│   │   ├── pormpt/                                      # Prompt definitions
│   │   │   └── MedicineInventoryPrompts.java
│   │   ├── service/
│   │   │   └── MedicineService.java                    # Business logic
│   │   ├── tools/
│   │   │   └── MedicineTools.java                      # MCP tool definitions
│   │   └── utils/
│   │       └── MedicineDataLoader.java                 # Data initialization
│   └── resources/
│       ├── application.yaml                             # Application configuration
│       ├── data/
│       │   └── medicines.json                          # Medicine inventory data
│       └── templates/
└── test/
    └── java/medicine/mcp/server/
        └── MedicineInventoryMcpServerApplicationTests.java
```

## Configuration

The application is configured via `application.yaml`:

```yaml
spring:
  application:
    name: medicine-inventory-mcp-server
  ai:
    mcp:
      server:
        enabled: true
        name: inventory-mcp-server
        version: 0.0.1
        type: SYNC
        sse-endpoint: mcp
        protocol: streamable
        webmvc:
          cors:
            allowed-origins: "*"

server:
  port: 9090
```

**Key Configuration Points:**
- **Port**: Server runs on port 9090
- **MCP Endpoint**: Available at `/mcp` (SSE protocol)
- **CORS**: Enabled for all origins (configurable)
- **Protocol**: Synchronous, streamable protocol

## Getting Started

### Prerequisites

- Java 21 or higher
- Maven 3.6 or higher

### Building

```bash
./mvnw clean package
```

This command will:
- Clean previous builds
- Compile the Java source code
- Run tests
- Package the application as an executable JAR

### Running the Application

```bash
./mvnw spring-boot:run
```

Or run the packaged JAR:

```bash
java -jar target/medicine-inventory-mcp-server-0.0.1-SNAPSHOT.jar
```

The application will start on `http://localhost:9090`

## API Endpoints

### MCP Server Endpoint
- **SSE Endpoint**: `http://localhost:9090/mcp`

This endpoint provides the MCP server interface for AI assistants to interact with medicine inventory tools and prompts.

## Data Files

### medicines.json
Located in `src/main/resources/data/`, this file contains the medicine inventory data that the application loads on startup. The data is managed by the `MedicineDataLoader` utility.

## Development

### IDE Setup
VS Code or IntelliJ IDEA recommended. IDE configurations are tracked in `.gitignore`.

### Running Tests

```bash
./mvnw test
```

### Maven Wrapper
The project includes Maven wrapper scripts (`mvnw` for Unix/Mac, `mvnw.cmd` for Windows) for consistent builds without requiring Maven installation.

## Project Dependencies

Key dependencies are managed through Maven:
- **spring-boot-starter-web**: Web and REST support
- **spring-ai-starter-mcp-server-webmvc**: MCP server implementation
- **projectlombok**: Annotation processing for cleaner code
- **jackson-datatype-jsr310**: Java 8 date/time JSON support

See `pom.xml` for the complete dependency list.

## Troubleshooting

### Port Already in Use
If port 9090 is already in use, update the `server.port` in `application.yaml`.

### Build Issues
- Ensure Java 21 is installed: `java -version`
- Clear Maven cache: `./mvnw clean`
- Verify Maven installation: `./mvnw --version`

## License

See [LICENSE](LICENSE) file for details (if applicable).

## References

- [Spring Boot Documentation](https://docs.spring.io/spring-boot/3.5.11/reference/)
- [Spring AI MCP Server Documentation](https://docs.spring.io/spring-ai/reference/api/mcp/mcp-server-boot-starter-docs.html)
- [Model Context Protocol Specification](https://modelcontextprotocol.io/)
- [Spring Web MVC Guide](https://docs.spring.io/spring-boot/3.5.11/reference/web/servlet.html)