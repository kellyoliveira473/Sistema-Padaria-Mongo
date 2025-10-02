FROM maven:3.9.4-eclipse-temurin-21 AS build
WORKDIR /app

# 1. Copia o pom.xml
COPY pom.xml .

# 2. Baixa as dependências.
RUN echo "Baixando dependências do Maven..." && \
    mvn dependency:go-offline

# 3. Copia o código-fonte e compila (Build)
COPY src ./src

# 4. Compila o projeto e empacota em um JAR (ignorando testes)
RUN echo "Compilando e empacotando a aplicação..." && \
    mvn clean package -DskipTests

# ----------------------------------------------------------------------
# Estágio 2: EXECUÇÃO - Imagem leve final JRE 21
# AGORA USANDO: 21-jre-alpine (imagem mínima e estável)
# ----------------------------------------------------------------------
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
EXPOSE 8080

# Copia o arquivo JAR do estágio 'build'
COPY --from=build /app/target/*.jar app.jar

# Variável de ambiente para MongoDB
ENV SPRING_DATA_MONGODB_URI=mongodb://mongo:27017/sistemadepadaria

# Comando para iniciar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
