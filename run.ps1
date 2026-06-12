# Load environment variables from .env file
if (Test-Path ".env") {
    Write-Host "Loading environment variables from .env..." -ForegroundColor Green
    Get-Content .env | ForEach-Object {
        $line = $_.Trim()
        if ($line -and -not $line.StartsWith("#") -and $line.Contains("=")) {
            $key, $value = $line -split '=', 2
            $key = $key.Trim()
            $value = $value.Trim()
            [System.Environment]::SetEnvironmentVariable($key, $value)
        }
    }
} else {
    Write-Warning ".env file not found! Using system/default environment variables."
}

# Run the Spring Boot application
Write-Host "Starting Spring Boot Application..." -ForegroundColor Cyan
.\mvnw.cmd spring-boot:run
