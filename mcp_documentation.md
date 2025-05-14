# Model Context Protocol (MCP) Server Documentation

## What is Model Context Protocol?

The Model Context Protocol (MCP) is a standardized protocol that enables AI models to interact with external tools and services. In the context of Akto, the MCP server acts as a bridge between AI-powered tools (like Claude, Cursor, etc.) and Akto's API security platform, allowing these tools to access and analyze your API security data.

## Key Features

### 1. AI-Powered API Security Analysis
- Access to Akto's comprehensive API security data
- Real-time analysis of API endpoints and vulnerabilities
- Integration with popular AI tools like Claude and Cursor

### 2. Comprehensive API Access
- API collection management
- Vulnerability analysis
- Test management
- Issue tracking

### 3. Easy Integration
- Docker-based deployment
- Simple configuration for MCP clients
- RESTful API interface

## Prerequisites

- Docker installed on your system
- Akto API Key

## Getting Started

### Generating an API Key

For detailed information about generating and managing API keys, refer to the [Akto API Reference Documentation](https://docs.akto.io/api-reference/api-reference).

### Configuring MCP Clients

#### Cursor Configuration
1. **Open Settings**
   - Launch Cursor
   - Go to Settings
   - Navigate to the MCP tab

2. **Add MCP Server**
   - Click "Add new global MCP server"
   - Paste the following configuration:
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
           "aktosecurity/akto-mcp-server:latest"
         ],
         "env": {
           "AKTO_API_KEY": "your_api_key"
         }
       }
     }
   }
   ```
   - Replace `your_api_key` with your actual API key
   - Click Save to activate

#### Claude Desktop Configuration
1. **Locate Config File**
   - macOS: `~/Library/Application Support/Claude/claude_desktop_config.json`
   - Windows: `%APPDATA%\Claude\claude_desktop_config.json`

2. **Update Configuration**
   - Add the following configuration:
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
           "aktosecurity/akto-mcp-server:latest"
         ],
         "env": {
           "AKTO_API_KEY": "your_api_key"
         }
       }
     }
   }
   ```
   - Replace `your_api_key` with your actual API key
   - Save the file
   - Restart Claude Desktop

## Feature Highlights

The MCP server provides easy access to Akto's powerful API security features through AI tools. Here's what you can do:

1. **View Your APIs**: Get a complete list of all your APIs and their details in one place
2. **Track API Changes**: Monitor new endpoints and changes in your API landscape
3. **Find Security Issues**: Automatically detect vulnerabilities and security risks in your APIs
4. **Analyze Sensitive Data**: Identify and track sensitive information in your API responses
5. **Monitor API Health**: Keep track of API performance and security status
6. **Track Issues**: View and monitor the status of security issues
7. **Get Security Insights**: Receive AI-powered analysis and recommendations for your APIs
8. **View Risk Scores**: Access risk scores for your APIs to understand their security posture

Each of these capabilities is designed to work seamlessly with AI tools like Claude and Cursor, making API security management more intuitive and efficient.

## Troubleshooting

### Common Issues

#### Server Connection Issues
- Verify API key is correct
- Check network connectivity
- Ensure Docker is running
- Verify Docker image pull was successful

#### Client Configuration
- Validate JSON configuration
- Check file permissions
- Verify environment variables
- Ensure Docker image name is correct (`aktosecurity/akto-mcp-server`)

#### API Access
- Confirm API key permissions
- Check rate limits
- Verify endpoint accessibility

### Getting Help

- Visit [Akto Documentation](https://docs.akto.io)
- Check [API Reference](https://docs.akto.io/api-reference/api-reference)
- Contact Akto Support for assistance

## Best Practices

### Configuration Management
- Use environment variables for sensitive data
- Implement proper logging
- Regular configuration reviews

### Performance Optimization
- Monitor Docker container resources
- Regular container updates
- Clean up unused containers

### Security
- Regular security audits
- Keep Docker image updated
- Follow security best practices

## Frequently Asked Questions (FAQs)

### 1. What is the Model Context Protocol (MCP)?
MCP is a standardized protocol that enables AI models to interact with Akto's API security platform, allowing tools like Claude and Cursor to access and analyze your API security data.

### 2. How much does Akto MCP cost?
Akto MCP is free of cost.

### 3. Is MCP secure?
Yes, MCP is secure as it uses your existing Akto API key for authentication and all communication is encrypted.

### 4. How quickly can I get started with MCP?
You can get started in under 5 minutes by installing Docker, generating an API key, and configuring your preferred client (Cursor or Claude Desktop).

### 5. How do I know if my MCP server is running correctly?
Run `docker ps | grep akto-mcp-server` to verify the container is running and test a simple API collection fetch through your configured client.

### 6. What should I do if I get authentication errors?
Verify your API key is correct in the environment variables and ensure it hasn't expired or been revoked.

### 7. Can I use multiple API keys with the MCP server?
No, the MCP server works with a single API key at a time, which must be set as an environment variable when starting the Docker container.

### 8. How often should I update the MCP server?
Update the MCP server whenever new versions are released to get the latest features and security patches.

---

This documentation provides a comprehensive guide for using the Akto MCP server. For more detailed information about specific features or capabilities, refer to the [Akto Documentation](https://docs.akto.io). 