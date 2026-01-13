#!/bin/bash

# Script para iniciar aplicação Spring Boot automaticamente

echo "Aguardando inicialização do container..."
sleep 5

# Verificar se existe mvnw
if [ -f "./mvnw" ]; then
    echo "Iniciando aplicação com Maven Wrapper..."
    chmod +x ./mvnw
    ./mvnw spring-boot:run
elif [ -f "pom.xml" ]; then
    echo "Iniciando aplicação com Maven..."
    mvn spring-boot:run
else
    echo "Nenhum arquivo pom.xml encontrado. Container em modo standby."
    tail -f /dev/null
fi
