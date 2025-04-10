# Olympic & Paralympic Medals 2024

A Spring Boot application that provides medal tracking for the 2024 Paris Olympics and Paralympics.

## Features

- REST API endpoints for Olympic and Paralympic medal data
- Simple web interface for viewing medal standings
- Country-specific medal filtering
- Fallback to local data when API is unavailable

## API Endpoints

- `GET /api/medals` - Get Olympic medal standings
- `GET /api/paralympics/medals` - Get Paralympic medal standings

Both endpoints support an optional `country` query parameter to filter by country code (e.g., `?country=aus`).

## Local Development

1. Clone the repository
2. Install Java 17 or later
3. Run the application:
   ```bash
   ./mvnw spring-boot:run
   ```
4. Access the web interface at `http://localhost:8080`

## Deployment to Vercel

1. Install the Vercel CLI:
   ```bash
   npm install -g vercel
   ```

2. Build the application:
   ```bash
   ./mvnw clean package
   ```

3. Deploy to Vercel:
   ```bash
   vercel
   ```

4. Configure the following environment variables in Vercel:
   - `JAVA_HOME`: Path to Java installation
   - `MAVEN_HOME`: Path to Maven installation

## Data Sources

The application uses the official Olympics.com API as the primary data source. If the API is unavailable, it falls back to local data stored in the `resources` directory.

## License

MIT 