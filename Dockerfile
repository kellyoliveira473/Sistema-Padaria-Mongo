FROM maven:3.9.4-eclipse-temurin-17 AS build
WORKDIR /app

# 1. Copia o pom.xml
COPY pom.xml .

# 2. Baixa as dependências. Isso aproveita o cache do Docker.
# Se o pom.xml não mudar, este passo é ignorado em builds subsequentes.
RUN echo "Baixando dependências do Maven..." && \
    mvn dependency:go-offline

# 3. Copia o código-fonte restante
COPY src ./src

# 4. Compila o projeto e empacota em um JAR (ignorando testes)
RUN echo "Compilando e empacotando a aplicação..." && \
    mvn clean package -DskipTests

# ----------------------------------------------------------------------
# Estágio 2: EXECUÇÃO - Imagem leve final para rodar a aplicação
# Usa apenas o JRE (Java Runtime Environment) para ser menor e mais seguro
# ----------------------------------------------------------------------
FROM eclipse-temurin:17-jre-focal
WORKDIR /app

# Porta que a aplicação Spring Boot expõe
EXPOSE 8080

# Copia o arquivo JAR gerado no estágio 'build'
COPY --from=build /app/target/*.jar app.jar

# Variável de ambiente crucial para conectar ao MongoDB
# O host 'mongo' é o nome de serviço padrão quando usado com docker-compose
ENV SPRING_DATA_MONGODB_URI=mongodb://mongo:27017/sistemadepadaria

# Comando para iniciar a aplicação Spring Boot
ENTRYPOINT ["java", "-jar", "app.jar"]
