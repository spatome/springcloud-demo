FROM registry.cn-shenzhen.aliyuncs.com/spatome/jre8
MAINTAINER zw
ADD . /app
WORKDIR /app/
RUN mvn clean package
#ADD demo-cloud-register-0.0.1-SNAPSHOT.jar app.jar
#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","app.jar"]
#EXPOSE 9999