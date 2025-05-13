# Akto MCP Server

Akto MCP Server is a Spring Boot-based Model Context Protocol (MCP) server, designed to provide AI-powered tools and APIs to interact with Akto. It leverages the Spring AI and is container-ready for easy deployment.

## Features

- **Spring Boot 3.4.5** application
- **Model Context Protocol (MCP)** support via Spring AI
- **Docker** support for containerized deployment

## Prerequisites

- Java 17+
- Maven 3.8+
- Docker (optional, for containerized deployment)
- An `AKTO_API_KEY` environment variable (required)

## Getting Started

### 1. Clone the repository

```sh
git clone <repo-url>
cd akto-mcp-server
```

### 2. Build the project

```sh
./mvnw clean package
```

### 3. Run the server

**Locally:**

```sh
export AKTO_API_KEY=your_api_key
java -jar target/mcp-1.0.jar
```

> **Note:** To generate your `AKTO_API_KEY`, follow the instructions at the <a href="https://docs.akto.io/api-reference/api-reference" target="_blank">Akto API Reference</a>.

**With Docker:**

```sh
docker build -t akto-mcp-server .
docker run --rm -i -e AKTO_API_KEY=your_api_key akto-mcp-server
```

## Integrating with MCP Clients (Claude, Cursor, etc.)

You can connect the Akto MCP Server to any MCP-compatible client, such as Claude, Cursor, and others. These clients typically require a configuration specifying how to reach your MCP server.

Below is an example configuration for integrating with an MCP client:

```json
{
  "mcpServers": {
    "akto-mcp-server": {
      "command": "docker",
      "args": [
        "run",
        "--rm",
        "--name akto-mcp-server",
        "-i",
        "-e",
        "AKTO_API_KEY",
        "akto-api-security/akto-mcp-server:latest"
      ],
      "env": {
        "AKTO_API_KEY": "your_api_key"
      }
    }
  }
}
```

- Replace `your_api_key` with your actual Akto API key.
- This configuration allows the client to start and connect to the Akto MCP Server automatically.

Refer to your MCP client's documentation for the exact location and format of this configuration.

## Examples of configuring with MCP client

### Cursor

**Current Method (as of 2025):**
- Cursor does **not** use a standard config file for MCP servers. Instead, you must add MCP servers via the Cursor app UI:
  1. Open Cursor.
  2. Go to **Settings**.
  3. Navigate to the **MCP** tab.
  4. Click **Add new global MCP server**.
  5. Paste your MCP server JSON config (the block from above) into the dialog.
  6. Click **Save** or **Refresh** to activate the server.

> **Note:** There is currently no file-based config for MCP servers in Cursor. All configuration is managed through the UI.

**Reference:**  
- [Browser MCP Docs](https://docs.browsermcp.io/setup-server)  
- [Cursor Community Forum](https://forum.cursor.com/t/how-do-i-get-cursor-to-use-my-configured-mcp-servers/50042)

---

### Claude Desktop

**Config File Location:**
- On **macOS**:  
  `~/Library/Application Support/Claude/claude_desktop_config.json`
- On **Windows**:  
  `%APPDATA%\Claude\claude_desktop_config.json`

**Steps:**
1. Open the `claude_desktop_config.json` file in your preferred text editor.
2. Add or update the `"mcpServers"` section with your server config:
   ```json
   {
     "mcpServers": {
       "akto-mcp-server": {
         "command": "docker",
         "args": [
           "run",
           "--rm",
           "--name akto-mcp-server",
           "-i",
           "-e",
           "AKTO_API_KEY",
           "akto-api-security/akto-mcp-server:latest"
         ],
         "env": {
           "AKTO_API_KEY": "your_api_key"
         }
       }
     }
   }
   ```
3. Save the file and restart Claude Desktop.

### Troubleshooting

- If the server does not appear, ensure your JSON is valid and the app is restarted.
- For Cursor, always use the UI as file-based config is not supported.
- For Claude, ensure you are editing the correct file for your OS.
