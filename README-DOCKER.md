# Ambiente de Desenvolvimento Docker

Este projeto utiliza Docker para criar um ambiente de desenvolvimento consistente para todos os serviços Spring Boot.

## Estrutura

- **Dockerfile.dev**: Imagem base com JDK 21 e Maven para desenvolvimento
- **docker-compose.yml**: Configuração de todos os serviços com volumes compartilhados

## Características

- ✅ JDK 21 (Eclipse Temurin)
- ✅ Maven instalado
- ✅ Volumes compartilhados com o host (alterações no código são refletidas automaticamente)
- ✅ Cache do Maven compartilhado entre containers
- ✅ Rede Docker compartilhada (spring-network) para comunicação entre serviços
- ✅ Portas mapeadas para cada serviço

## Portas dos Serviços

| Serviço           | Porta no Host | Porta no Container |
|-------------------|---------------|--------------------|
| arquiteturaspring | 8080          | 8080               |
| libraryapi        | 8081          | 8080               |
| localizacao       | 8082          | 8080               |
| pedidos-api       | 8083          | 8080               |
| produtosapi       | 8084          | 8080               |
| resource-server   | 8085          | 8080               |
| sbootexp-security | 8086          | 8080               |

## Como Usar

### Iniciar todos os serviços
```bash
docker-compose up -d
```

### Iniciar um serviço específico
```bash
docker-compose up -d libraryapi
```

### Executar a aplicação dentro do container
```bash
# Acessar o container
docker exec -it libraryapi-dev bash

# Compilar e executar com Maven
./mvnw spring-boot:run

# Ou compilar o projeto
./mvnw clean package
```

### Ver logs de um serviço
```bash
docker-compose logs -f libraryapi
```

### Parar todos os serviços
```bash
docker-compose down
```

### Parar e remover volumes
```bash
docker-compose down -v
```

## Desenvolvimento

1. Inicie o container do serviço desejado
2. Acesse o container via `docker exec -it <container-name> bash`
3. Execute o Maven: `./mvnw spring-boot:run`
4. Faça alterações no código no seu editor local
5. As alterações são refletidas automaticamente no container (pode ser necessário reiniciar a aplicação)

## Comunicação entre Serviços

Todos os serviços estão na mesma rede Docker (`spring-network`). Para comunicação entre serviços, use o nome do serviço como hostname:

```java
// Exemplo: chamar produtosapi do libraryapi
String url = "http://produtosapi:8080/api/produtos";
```

## Cache do Maven

O volume `maven-repo` é compartilhado entre todos os containers para evitar downloads repetidos de dependências.
